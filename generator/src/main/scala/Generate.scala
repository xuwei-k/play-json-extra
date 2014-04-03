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
  private val arities = (2 to 21)
  private def tparams(n: Int) = (1 to n).map("A" + _)
  private def params(n: Int) = (1 to n).map("key" + _)

  private val writes: String => String = { className =>
    val method: Int => String = { n =>
s"""
  def apply[${tparams(n).mkString(", ")}, Z](f: Z => Option[(${tparams(n).mkString(", ")})])(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}: Writes[${t}]").mkString(", ")}): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      ${tparams(n).zip(params(n)).zipWithIndex.map{ case ((t, k), i) =>
        s"(JsPath.createObj((JsPath \\ $k) -> $t.writes(tuple._${i + 1})))"
      }.mkString(".deepMerge")}
    }
"""
    }

    packageLine + s"""
import play.api.libs.json.{Writes, OWrites, JsPath}
import play.api.libs.functional.syntax._

object $className {

  def apply[A1, Z](f: Z => Option[A1])(key1: String)(implicit A1: Writes[A1]): OWrites[Z] =
    Writes.at(JsPath \\ key1)(A1).contramap(Function.unlift(f))

  ${arities.map(method).mkString("\n")}
}
"""
  }

  private val reads: String => String = { className =>
    val method: Int => String = { n =>
s"""
  def apply[${tparams(n).mkString(", ")}, Z](f: (${tparams(n).mkString(", ")}) => Z)(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}: Reads[${t}]").mkString(", ")}): Reads[Z] =
    Reads[Z](json =>
      (${(tparams(n), params(n)).zipped.map((t, k) => s"(json \\ $k).validate($t)").mkString(" and ")})(f)
    )
"""
    }

    packageLine + s"""
import play.api.libs.json.{Reads, JsPath, JsValue, JsResult}
import play.api.libs.functional.syntax._
import play.api.libs.functional.Functor

object $className {

  private[this] implicit val jsResultFunctor: Functor[JsResult] =
    new Functor[JsResult] {
      def fmap[A, B](m: JsResult[A], f: A => B) = m map f
    }


  def apply[A1, Z](f: A1 => Z)(key1: String)(implicit A1: Reads[A1]): Reads[Z] =
    Reads.at(JsPath \\ key1)(A1).map(f)

  ${arities.map(method).mkString("\n")}
}
"""
  }

  private val formats: String => String = { className =>
    val method: Int => String = { n =>
s"""
  def apply[${tparams(n).mkString(", ")}, Z](applyFunc: (${tparams(n).mkString(", ")}) => Z, unapplyFunc: Z => Option[(${tparams(n).mkString(", ")})])(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}R: Reads[${t}]").mkString(", ")}, ${tparams(n).map(t => s"${t}W: Writes[${t}]").mkString(", ")}): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(${params(n).mkString(", ")}),
      CaseClassWrites(unapplyFunc)(${params(n).mkString(", ")})
    )
"""
    }

    packageLine + s"""
import play.api.libs.json.{Reads, Writes, OFormat}
import play.api.libs.functional.syntax._

object $className {

  def apply[A1, Z](applyFunc: A1 => Z, unapplyFunc: Z => Option[A1])(key1: String)(implicit A1R: Reads[A1], A1W: Writes[A1]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1),
      CaseClassWrites(unapplyFunc)(key1)
    )

  ${arities.map(method).mkString("\n")}
}
"""
  }

}


