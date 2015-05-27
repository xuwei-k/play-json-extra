package play.jsonext

import org.scalacheck.{Gen, Arbitrary, Prop, Properties}
import play.api.libs.functional.syntax._
import play.api.libs.json.{JsObject, OFormat, OWrites, __}
import CaseClassCoproductFormats._

object CoproductTest extends Properties("coproduct"){
  property("coproduct") = Prop.forAll { aaa: AAA =>
    val json1 = AAA.format1.writes(aaa)
    json1.as[AAA](AAA.format1) == aaa
    json1.as[AAA](AAA.format2) == aaa

    val json2 = AAA.format2.writes(aaa)
    json2.as[AAA](AAA.format1) == aaa
    json2.as[AAA](AAA.format2) == aaa
  }
}

sealed abstract class AAA extends Product with Serializable{
  def toJson: JsObject
}

object AAA{
  val format1: OFormat[AAA] = OFormat(
    BBB.reads | CCC.reads | DDD.reads,
    OWrites[AAA](_.toJson)
  )

  val format2: OFormat[AAA] = CaseClassCoproductFormats.format(
    BBB.readsAndWrites, CCC.readsAndWrites, DDD.readsAndWrites
  )

  implicit val arbitrary: Arbitrary[AAA] = Arbitrary(Gen.oneOf(
    Gen.resultOf(BBB.apply _),
    Gen.resultOf(CCC.apply _),
    Gen.resultOf(DDD.apply _)
  ))
}

final case class BBB(a: Int, b: String) extends AAA{
  def toJson = BBB.writes.writes(this)
}

object BBB {
  val (reads, writes) = CaseClassFormats.readsAndWrites[AAA]("a", "b").build(apply, unapply)

  val readsAndWrites = (
    (__ \ "a").format[Int] and
    (__ \ "b").format[String]
  ).readsAndWrites[AAA](apply)(unapply)
}

final case class CCC(c: Long, d: List[Int], e: String) extends AAA{
  def toJson = CCC.writes.writes(this)
}

object CCC {
  val (reads, writes) = CaseClassFormats.readsAndWrites[AAA]("c", "d", "e").build(apply, unapply)

  val readsAndWrites = (
    (__ \ "c").format[Long] and
    (__ \ "d").format[List[Int]] and
    (__ \ "e").format[String]
  ).readsAndWrites[AAA](apply)(unapply)
}

final case class DDD(z: Boolean) extends AAA {
  def toJson = DDD.writes.writes(this)
}

object DDD {
  val (reads, writes) = CaseClassFormats.readsAndWrites[AAA]("z").build(apply, unapply)

  val readsAndWrites = (__ \ "z").format[Boolean].readsAndWrites[AAA](apply)(unapply)
}
