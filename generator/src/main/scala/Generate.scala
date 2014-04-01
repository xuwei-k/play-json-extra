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
  def apply[${tparams(n).mkString(", ")}, Z](f: Z => Option[(${tparams(n).mkString(", ")})])(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}: Writes[${t}]").mkString(", ")}): Writes[Z] =
    (${(tparams(n), params(n)).zipped.map((t, k) => s"Writes.at(JsPath \\ ${k})(${t})").mkString(" and ")})(Function.unlift(f))
"""
    }

    packageLine + s"""
import play.api.libs.json.{Writes, JsPath}
import play.api.libs.functional.syntax._

object $className {
  ${arities.map(method).mkString("\n")}
}
"""
  }

  private val reads: String => String = { className =>
    val method: Int => String = { n =>
s"""
  def apply[${tparams(n).mkString(", ")}, Z](f: (${tparams(n).mkString(", ")}) => Z)(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}: Reads[${t}]").mkString(", ")}): Reads[Z] =
    (${(tparams(n), params(n)).zipped.map((t, k) => s"Reads.at(JsPath \\ ${k})(${t})").mkString(" and ")})(f)
"""
    }

    packageLine + s"""
import play.api.libs.json.{Reads, JsPath}
import play.api.libs.functional.syntax._

object $className {
  ${arities.map(method).mkString("\n")}
}
"""
  }

  private val formats: String => String = { className =>
    val method: Int => String = { n =>
s"""
  def apply[${tparams(n).mkString(", ")}, Z](applyFunc: (${tparams(n).mkString(", ")}) => Z, unapplyFunc: Z => Option[(${tparams(n).mkString(", ")})])(${params(n).map(_ + ": String").mkString(", ")})(implicit ${tparams(n).map(t => s"${t}R: Reads[${t}]").mkString(", ")}, ${tparams(n).map(t => s"${t}W: Writes[${t}]").mkString(", ")}): Format[Z] =
    Format.GenericFormat(
      CaseClassReads(applyFunc)(${params(n).mkString(", ")}),
      CaseClassWrites(unapplyFunc)(${params(n).mkString(", ")})
    )
"""
    }

    packageLine + s"""
import play.api.libs.json.{Reads, Writes, Format, JsPath}
import play.api.libs.functional.syntax._

object $className {
  ${arities.map(method).mkString("\n")}
}
"""
  }

}


