package play.jsonext

import org.scalacheck._
import play.api.libs.json.{Writes, Format}

object JsonExtraTest extends Properties("JsonExtra") {

  final case class Foo(a: Int, b: String, c: List[Boolean])

  object Foo {
    implicit val fooFormat: Format[Foo] =
      CaseClassFormats(apply _, unapply _)(
        "a", "b", "c"
      )

    implicit val fooArbitrary: Arbitrary[Foo] = Arbitrary(
      Gen.resultOf(apply _)(
        implicitly[Arbitrary[Int]],
        Arbitrary(Gen.alphaStr),
        implicitly[Arbitrary[List[Boolean]]]
      )
    )
  }

  property("write read") = Prop.forAll{ foo: Foo =>
    val json = implicitly[Writes[Foo]].writes(foo)
    json.as[Foo] == foo
  }

}
