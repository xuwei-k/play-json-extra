package play.jsonext

import java.io.File
import java.nio.file.Files
import java.nio.charset.Charset
import java.util.Collections.singletonList

object Generate {

  private def deleteDir(file: File){
    if(!file.delete() && file.isDirectory){
      Option(file.listFiles).toList.flatten.foreach(deleteDir)
      file.delete
    }
  }

  def main(args: Array[String]){
    val dir = new File(args.headOption.getOrElse(sys.error("invalid args " + args.mkString(", "))))
    deleteDir(dir)
    generate(dir)
  }

  private def generate(dir: File): Unit = {
    dir.mkdir
    List(
      "Writes" -> writes, "Reads" -> reads, "Formats" -> formats, "CoproductFormats" -> coproduct
    ).foreach{ case (name, contents) =>
      val className = "CaseClass" + name
      val f = new File(dir, className + ".scala").toPath
      Files.write(f, singletonList(contents(className)), Charset.forName("UTF-8"))
    }
  }

  private val packageLine = "package play.jsonext\n"
  private val arities = (2 to 22)
  private def tparams(n: Int) = (1 to n).map("A" + _)
  private def params(n: Int) = (1 to n).map("key" + _)

  private val coproduct: String => String = { className =>
    val ReadsAlternative = "F"
    val ReadsAndWrites = "ReadsAndWrites"
    val readsAndWrites = "readsAndWrites"
    val WritesBuilder = s"WritesBuilder[B1]"

    val method: Int => String = { n =>

      val t = tparams(n).mkString(", ")

s"""  implicit class ReadsAndWrites$n[$t](a: FunctionalBuilder[OFormat]#CanBuild$n[$t]) {
    sealed abstract class $WritesBuilder{
      def apply[B2](f2: B2 => Option[($t)])(implicit B2: ClassTag[B2]): $ReadsAndWrites[B1, B2]
    }

    def $readsAndWrites[B1](f1: ($t) => B1): $WritesBuilder =
      new $WritesBuilder {
        override def apply[B2](f2: B2 => Option[($t)])(implicit B2: ClassTag[B2]): $ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[($t)]]))
          $ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, ${tparams(n).map(_ + " <: Z").mkString(", ")}](${(1 to n).map(i => s"a$i: $ReadsAndWrites[Z, A$i]").mkString(", ")}): OFormat[Z] = {
    OFormat(
      ${(1 to n).map(i => s"a$i.reads").reduceLeft{ (x, y) => s"$ReadsAlternative.|($x, $y)" }},
      OWrites[Z]{
        ${(1 to n).map(i => s"case a$i.C(a) => a$i.writes.writes(a)").mkString("; ")}
      }
    )
  }
"""
    }

    val one = s"""
  implicit class ReadsAndWrites1[A1](a: OFormat[A1]) {
    sealed abstract class $WritesBuilder{
      def apply[B2](f2: B2 => Option[A1])(implicit B2: ClassTag[B2]): $ReadsAndWrites[B1, B2]
    }

    def $readsAndWrites[B1](f1: A1 => B1): $WritesBuilder =
      new $WritesBuilder {
        override def apply[B2](f2: B2 => Option[A1])(implicit B2: ClassTag[B2]): $ReadsAndWrites[B1, B2] = {
          $ReadsAndWrites(a.map(f1), OWrites[B2](b2 => a.writes(f2(b2).get)), B2)
        }
      }
  }"""

packageLine + s"""
import play.api.libs.functional.{Alternative, FunctionalBuilder}
import play.api.libs.json.{OFormat, OWrites, Reads}
import scala.reflect.ClassTag

final case class ReadsAndWrites[A, B](reads: Reads[A], writes: OWrites[B], C: ClassTag[B])

object $className {
  private[this] val $ReadsAlternative: Alternative[Reads] = Reads.alternative

$one

${(2 to 21) map method mkString "\n"}
}
"""
  }

  private val writes: String => String = { className =>
    val method: Int => String = { n =>

      val apply = "apply"
      val applyN = "apply" + n
      val f = "f"

      def methodDef(name: String) = s"""def $name[${tparams(n).mkString(", ")}, Z]($f: Z => Option[(${tparams(n).mkString(", ")})])(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}: Writes[${t}]").mkString(", ")}): OWrites[Z] ="""

s"""
  ${methodDef(applyN)}
    OWrites{ z: Z =>
      val tuple = $f(z).get
      ${tparams(n).zip(params(n)).zipWithIndex.map{
        case ((t, k), i) => s"(($k, $t.writes(tuple._${i + 1})))"
      }.reverse.mkString("JsObject(Nil.::", ".::", ")")}
    }

  ${methodDef(apply)}
    $applyN[${tparams(n).mkString(", ")}, Z]($f)(${params(n).mkString(", ")})(${tparams(n).mkString(", ")})
"""


    }

    packageLine + s"""
import play.api.libs.json.{Writes, OWrites, JsObject}

object $className {

  def apply1[A1, Z](f: Z => Option[A1])(key1: String)(implicit A1: Writes[A1]): OWrites[Z] =
    OWrites(z => JsObject((key1, A1.writes(f(z).get)) :: Nil))

  def apply[A1, Z](f: Z => Option[A1])(key1: String)(implicit A1: Writes[A1]): OWrites[Z] =
    apply1(f)(key1)(A1)

  ${arities.map(method).mkString("\n")}
}
"""
  }

  private val reads: String => String = { className =>
    val method: Int => String = { n =>
      val values = (1 to n).map("a" + _)
      val zippedString = (tparams(n), params(n)).zipped.map((t, k) => s"JsPath \\ $k").toList
      val zippedPath = (tparams(n), params(n)).zipped.map((t, k) => s"Reads.at[$t]($k)($t)").toList

      val apply = "apply"
      val applyN = "apply" + n
      val fromPaths = "fromPaths"
      val fromPathsN = fromPaths + n
      val f = "f"

      def pathMethodDef(name: String) = s"""def $name[${tparams(n).mkString(", ")}, Z]($f: (${tparams(n).mkString(", ")}) => Z)(${params(n).map(_ + ": JsPath").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}: Reads[${t}]").mkString(", ")}): Reads[Z] ="""

      def methodDef(name: String) = s"""def $name[${tparams(n).mkString(", ")}, Z]($f: (${tparams(n).mkString(", ")}) => Z)(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}: Reads[${t}]").mkString(", ")}): Reads[Z] ="""

s"""
  ${pathMethodDef(fromPathsN)}
    ${zippedPath.tail.foldLeft(zippedPath.head){(result, a) => "G(" + result + ", " + a + ")"}}.map{ case ${values.mkString(" ~ ")} => f(${values.mkString(", ")})}

  ${pathMethodDef(fromPaths)}
    $fromPathsN[${tparams(n).mkString(", ")}, Z]($f)(${params(n).mkString(", ")})(${tparams(n).mkString(", ")})

  ${methodDef(applyN)}
    $fromPathsN[${tparams(n).mkString(", ")}, Z]($f)(${zippedString.mkString(", ")})(${tparams(n).mkString(", ")})

  ${methodDef(apply)}
    $applyN[${tparams(n).mkString(", ")}, Z]($f)(${params(n).mkString(", ")})(${tparams(n).mkString(", ")})
"""
    }

    packageLine + s"""
import play.api.libs.json.{Reads, JsPath}
import play.api.libs.functional.syntax.functionalCanBuildApplicative
import play.api.libs.functional.{FunctionalCanBuild, ~}

object $className {

  private[this] val G: FunctionalCanBuild[Reads] =
    functionalCanBuildApplicative[Reads]


  def apply1[A1, Z](f: A1 => Z)(key1: String)(implicit A1: Reads[A1]): Reads[Z] =
    Reads.at(JsPath \\ key1)(A1).map(f)

  def apply[A1, Z](f: A1 => Z)(key1: String)(implicit A1: Reads[A1]): Reads[Z] =
    apply1[A1, Z](f)(key1)(A1)

  ${arities.map(method).mkString("\n")}
}
"""
  }

  private val formats: String => String = { className =>
    val method: Int => String = { n =>
      val apply = "apply"
      val applyN = "apply" + n
      val readsAndWrites = "readsAndWrites"
      val readsAndWritesN = "readsAndWrites" + n
      val applyFunc = "applyFunc"
      val unapplyFunc = "unapplyFunc"
      val R = "R"
      val W = "W"

      val ps: String = {
        if(n == 1) tparams(n).mkString(", ")
        else tparams(n).mkString("(", ", ", ")")
      }

      val keys = params(n).map(_ + ": String").mkString(", ")
      val reads = tparams(n).map(t => s"$t$R: Reads[${t}]").mkString(", ")
      val writes = tparams(n).map(t => s"$t$W: Writes[${t}]").mkString(", ")
      val typeParams = tparams(n).mkString(", ")
      val builderN = "Builder" + n
      val paramValues = params(n).mkString(", ")

      def methodDef(name: String) =
        s"""def $name[$typeParams, Z]($applyFunc: $ps => Z, $unapplyFunc: Z => Option[$ps])($keys)(implicit $reads, $writes): OFormat[Z] ="""

      def readsAndWritesMethod(name: String) = s"""
  def $name[R]($keys): $builderN[R] =
    new $builderN($paramValues)"""

      val builder = s"""
  final class $builderN[R]($keys) {
    def build[${tparams(n).mkString(", ")}, W]($applyFunc: $ps => R, $unapplyFunc: W => Option[$ps])(implicit $reads, $writes): (Reads[R], OWrites[W]) =
      (CaseClassReads($applyFunc)($paramValues), CaseClassWrites($unapplyFunc)($paramValues))
  }"""

s"""
  ${methodDef(applyN)}
    OFormat(
      CaseClassReads($applyFunc)(${params(n).mkString(", ")}),
      CaseClassWrites($unapplyFunc)(${params(n).mkString(", ")})
    )

  ${methodDef(apply)}
    $applyN[${tparams(n).mkString(", ")}, Z]($applyFunc, $unapplyFunc)(${params(n).mkString(", ")})(${tparams(n).map(_ + R).mkString(", ")}, ${tparams(n).map(_ + W).mkString(", ")})

$builder
${readsAndWritesMethod(readsAndWrites)}
${readsAndWritesMethod(readsAndWritesN)}
"""
    }

    packageLine + s"""
import play.api.libs.json.{Reads, Writes, OFormat, OWrites}

object $className {
  ${(1 +: arities).map(method).mkString("\n")}
}
"""
  }

}


