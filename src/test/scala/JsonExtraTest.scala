package play.jsonext

import org.scalacheck._
import play.api.libs.json.{OWrites, OFormat}

object JsonExtraTest extends Properties("JsonExtra") {

  final case class Foo(a: Int, b: String, c: List[Boolean])

  object Foo {
    implicit val fooOFormat: OFormat[Foo] =
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

  final case class Arity1(aaa: List[Int])

  object Arity1 {
    implicit val arity1OFormat: OFormat[Arity1] =
      CaseClassFormats(apply _, unapply _)("xyz")

    implicit val fooArbitrary: Arbitrary[Arity1] = Arbitrary(
      implicitly[Arbitrary[List[Int]]].arbitrary.map(Arity1.apply)
    )
  }

  property("write read") = Prop.forAll{ (foo: Foo) =>
    val json = implicitly[OWrites[Foo]].writes(foo)
    json.as[Foo] == foo
  }

  property("arity 1") = Prop.forAll{ (a: Arity1) =>
    val json = implicitly[OWrites[Arity1]].writes(a)
    json.as[Arity1] == a
  }

  property("22") = Prop.forAll{ (a: TwentyTwo) =>
    val json = implicitly[OWrites[TwentyTwo]].writes(a)
    json.as[TwentyTwo] == a
  }

}
