package play.jsonext

import java.io.File
import java.nio.file.{Files, Path}
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
      "Writes" -> writes, "Reads" -> reads, "Formats" -> formats
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
      val zipped = (tparams(n), params(n)).zipped.map((t, k) => s"$t.reads(json \\ $k)").toList

      val apply = "apply"
      val applyN = "apply" + n
      val f = "f"

      def methodDef(name: String) = s"""def $name[${tparams(n).mkString(", ")}, Z]($f: (${tparams(n).mkString(", ")}) => Z)(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}: Reads[${t}]").mkString(", ")}): Reads[Z] ="""

s"""
  ${methodDef(applyN)}
    Reads[Z](json =>
      ${zipped.tail.foldLeft(zipped.head){(result, a) => "G(" + result + ", " + a + ")"}}.map{ case ${values.mkString(" ~ ")} => f(${values.mkString(", ")})}
    )

  ${methodDef(apply)}
    $applyN[${tparams(n).mkString(", ")}, Z]($f)(${params(n).mkString(", ")})(${tparams(n).mkString(", ")})
"""
    }

    packageLine + s"""
import play.api.libs.json.{Reads, JsPath, JsValue, JsResult}
import play.api.libs.functional.syntax.functionalCanBuildApplicative
import play.api.libs.functional.{FunctionalCanBuild, ~}

object $className {

  private[this] val G: FunctionalCanBuild[JsResult] =
    functionalCanBuildApplicative[JsResult]


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
      val applyFunc = "applyFunc"
      val unapplyFunc = "unapplyFunc"
      val R = "R"
      val W = "W"

      val ps: String = {
        if(n == 1) tparams(n).mkString(", ")
        else tparams(n).mkString("(", ", ", ")")
      }

      def methodDef(name: String) = s"""def $name[${tparams(n).mkString(", ")}, Z]($applyFunc: $ps => Z, $unapplyFunc: Z => Option[$ps])(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"$t$R: Reads[${t}]").mkString(", ")}, ${tparams(n).map(t => s"$t$W: Writes[${t}]").mkString(", ")}): OFormat[Z] ="""

s"""
  ${methodDef(applyN)}
    OFormat(
      CaseClassReads($applyFunc)(${params(n).mkString(", ")}),
      CaseClassWrites($unapplyFunc)(${params(n).mkString(", ")})
    )

  ${methodDef(apply)}
    $applyN[${tparams(n).mkString(", ")}, Z]($applyFunc, $unapplyFunc)(${params(n).mkString(", ")})(${tparams(n).map(_ + R).mkString(", ")}, ${tparams(n).map(_ + W).mkString(", ")})
"""
    }

    packageLine + s"""
import play.api.libs.json.{Reads, Writes, OFormat}

object $className {
  ${(1 +: arities).map(method).mkString("\n")}
}
"""
  }

}


