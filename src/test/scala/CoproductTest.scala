package play.jsonext

import org.scalacheck.{Gen, Arbitrary, Prop, Properties}
import play.api.libs.functional.syntax._
import play.api.libs.json.{JsObject, OFormat, OWrites}

object CoproductTest extends Properties("coproduct"){
  property("coproduct") = Prop.forAll{ aaa: AAA =>
    val json = implicitly[OWrites[AAA]].writes(aaa)
    json.as[AAA] == aaa
  }
}

sealed abstract class AAA extends Product with Serializable{
  def toJson: JsObject
}

object AAA{
  implicit val format: OFormat[AAA] = OFormat(
    BBB.reads | CCC.reads | DDD.reads,
    OWrites[AAA](_.toJson)
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
  val (reads, writes) = CaseClassFormats.readsAndWrites[AAA]("a", "c").build(apply, unapply)
}

final case class CCC(c: Long, d: List[Int], e: Option[String]) extends AAA{
  def toJson = CCC.writes.writes(this)
}

object CCC {
  val (reads, writes) = CaseClassFormats.readsAndWrites[AAA]("c", "d", "e").build(apply, unapply)
}

final case class DDD(z: Boolean) extends AAA {
  def toJson = DDD.writes.writes(this)
}

object DDD {
  val (reads, writes) = CaseClassFormats.readsAndWrites[AAA]("z").build(apply, unapply)
}
