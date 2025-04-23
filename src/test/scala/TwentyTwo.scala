package play.jsonext

import org.scalacheck.{Gen, Arbitrary}
import play.api.libs.json.OFormat

import scalaz.Monad
import _root_.unapply.syntax._

final case class TwentyTwo(
  _01: String,
  _02: String,
  _03: String,
  _04: String,
  _05: String,
  _06: String,
  _07: String,
  _08: String,
  _09: String,
  _10: String,
  _11: String,
  _12: String,
  _13: String,
  _14: String,
  _15: String,
  _16: String,
  _17: String,
  _18: String,
  _19: String,
  _20: String,
  _21: String,
  _22: String
)

object TwentyTwo{

  implicit val instance: OFormat[TwentyTwo] =
    CaseClassFormats.apply22(apply, (_: TwentyTwo).asTupleOption)(
      "_01",
      "_02",
      "_03",
      "_04",
      "_05",
      "_06",
      "_07",
      "_08",
      "_09",
      "_10",
      "_11",
      "_12",
      "_13",
      "_14",
      "_15",
      "_16",
      "_17",
      "_18",
      "_19",
      "_20",
      "_21",
      "_22"
    )

  private implicit val GenMonad: Monad[Gen] = new Monad[Gen] {
    def point[A](a: => A) = Gen.sized(_ => Gen.const(a))
    def bind[A, B](fa: Gen[A])(f: A => Gen[B]) = fa flatMap f
    override def map[A, B](fa: Gen[A])(f: A => B) = fa map f
  }

  implicit val arbitrary: Arbitrary[TwentyTwo] = {
    val s = implicitly[Arbitrary[String]].arbitrary
    Arbitrary(
      scalaz.ApplyBuilder.apply22(
        s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s
      ).run(apply)
    )
  }
 
}
