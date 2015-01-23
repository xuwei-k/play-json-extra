package play.jsonext

import play.api.libs.functional.{Alternative, FunctionalBuilder}
import play.api.libs.json.{OFormat, OWrites, Reads}
import scala.reflect.ClassTag

final case class ReadsAndWrites[A, B](reads: Reads[A], writes: OWrites[B], C: ClassTag[B])

object CaseClassCoproductFormats {
  private[this] val F: Alternative[Reads] = Reads.alternative


  implicit class ReadsAndWrites1[A1](a: OFormat[A1]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[A1])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: A1 => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[A1])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          ReadsAndWrites(a.map(f1), OWrites[B2](b2 => a.writes(f2(b2).get)), B2)
        }
      }
  }

  implicit class ReadsAndWrites2[A1, A2](a: FunctionalBuilder[OFormat]#CanBuild2[A1, A2]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2]): OFormat[Z] = {
    OFormat(
      F.|(a1.reads, a2.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites3[A1, A2, A3](a: FunctionalBuilder[OFormat]#CanBuild3[A1, A2, A3]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3]): OFormat[Z] = {
    OFormat(
      F.|(F.|(a1.reads, a2.reads), a3.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites4[A1, A2, A3, A4](a: FunctionalBuilder[OFormat]#CanBuild4[A1, A2, A3, A4]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites5[A1, A2, A3, A4, A5](a: FunctionalBuilder[OFormat]#CanBuild5[A1, A2, A3, A4, A5]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites6[A1, A2, A3, A4, A5, A6](a: FunctionalBuilder[OFormat]#CanBuild6[A1, A2, A3, A4, A5, A6]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites7[A1, A2, A3, A4, A5, A6, A7](a: FunctionalBuilder[OFormat]#CanBuild7[A1, A2, A3, A4, A5, A6, A7]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites8[A1, A2, A3, A4, A5, A6, A7, A8](a: FunctionalBuilder[OFormat]#CanBuild8[A1, A2, A3, A4, A5, A6, A7, A8]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites9[A1, A2, A3, A4, A5, A6, A7, A8, A9](a: FunctionalBuilder[OFormat]#CanBuild9[A1, A2, A3, A4, A5, A6, A7, A8, A9]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](a: FunctionalBuilder[OFormat]#CanBuild10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](a: FunctionalBuilder[OFormat]#CanBuild11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](a: FunctionalBuilder[OFormat]#CanBuild12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](a: FunctionalBuilder[OFormat]#CanBuild13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z, A13 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12], a13: ReadsAndWrites[Z, A13]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads), a13.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a); case a13.C(a) => a13.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](a: FunctionalBuilder[OFormat]#CanBuild14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z, A13 <: Z, A14 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12], a13: ReadsAndWrites[Z, A13], a14: ReadsAndWrites[Z, A14]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads), a13.reads), a14.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a); case a13.C(a) => a13.writes.writes(a); case a14.C(a) => a14.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](a: FunctionalBuilder[OFormat]#CanBuild15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z, A13 <: Z, A14 <: Z, A15 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12], a13: ReadsAndWrites[Z, A13], a14: ReadsAndWrites[Z, A14], a15: ReadsAndWrites[Z, A15]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads), a13.reads), a14.reads), a15.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a); case a13.C(a) => a13.writes.writes(a); case a14.C(a) => a14.writes.writes(a); case a15.C(a) => a15.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](a: FunctionalBuilder[OFormat]#CanBuild16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z, A13 <: Z, A14 <: Z, A15 <: Z, A16 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12], a13: ReadsAndWrites[Z, A13], a14: ReadsAndWrites[Z, A14], a15: ReadsAndWrites[Z, A15], a16: ReadsAndWrites[Z, A16]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads), a13.reads), a14.reads), a15.reads), a16.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a); case a13.C(a) => a13.writes.writes(a); case a14.C(a) => a14.writes.writes(a); case a15.C(a) => a15.writes.writes(a); case a16.C(a) => a16.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](a: FunctionalBuilder[OFormat]#CanBuild17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z, A13 <: Z, A14 <: Z, A15 <: Z, A16 <: Z, A17 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12], a13: ReadsAndWrites[Z, A13], a14: ReadsAndWrites[Z, A14], a15: ReadsAndWrites[Z, A15], a16: ReadsAndWrites[Z, A16], a17: ReadsAndWrites[Z, A17]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads), a13.reads), a14.reads), a15.reads), a16.reads), a17.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a); case a13.C(a) => a13.writes.writes(a); case a14.C(a) => a14.writes.writes(a); case a15.C(a) => a15.writes.writes(a); case a16.C(a) => a16.writes.writes(a); case a17.C(a) => a17.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](a: FunctionalBuilder[OFormat]#CanBuild18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z, A13 <: Z, A14 <: Z, A15 <: Z, A16 <: Z, A17 <: Z, A18 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12], a13: ReadsAndWrites[Z, A13], a14: ReadsAndWrites[Z, A14], a15: ReadsAndWrites[Z, A15], a16: ReadsAndWrites[Z, A16], a17: ReadsAndWrites[Z, A17], a18: ReadsAndWrites[Z, A18]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads), a13.reads), a14.reads), a15.reads), a16.reads), a17.reads), a18.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a); case a13.C(a) => a13.writes.writes(a); case a14.C(a) => a14.writes.writes(a); case a15.C(a) => a15.writes.writes(a); case a16.C(a) => a16.writes.writes(a); case a17.C(a) => a17.writes.writes(a); case a18.C(a) => a18.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](a: FunctionalBuilder[OFormat]#CanBuild19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z, A13 <: Z, A14 <: Z, A15 <: Z, A16 <: Z, A17 <: Z, A18 <: Z, A19 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12], a13: ReadsAndWrites[Z, A13], a14: ReadsAndWrites[Z, A14], a15: ReadsAndWrites[Z, A15], a16: ReadsAndWrites[Z, A16], a17: ReadsAndWrites[Z, A17], a18: ReadsAndWrites[Z, A18], a19: ReadsAndWrites[Z, A19]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads), a13.reads), a14.reads), a15.reads), a16.reads), a17.reads), a18.reads), a19.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a); case a13.C(a) => a13.writes.writes(a); case a14.C(a) => a14.writes.writes(a); case a15.C(a) => a15.writes.writes(a); case a16.C(a) => a16.writes.writes(a); case a17.C(a) => a17.writes.writes(a); case a18.C(a) => a18.writes.writes(a); case a19.C(a) => a19.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](a: FunctionalBuilder[OFormat]#CanBuild20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z, A13 <: Z, A14 <: Z, A15 <: Z, A16 <: Z, A17 <: Z, A18 <: Z, A19 <: Z, A20 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12], a13: ReadsAndWrites[Z, A13], a14: ReadsAndWrites[Z, A14], a15: ReadsAndWrites[Z, A15], a16: ReadsAndWrites[Z, A16], a17: ReadsAndWrites[Z, A17], a18: ReadsAndWrites[Z, A18], a19: ReadsAndWrites[Z, A19], a20: ReadsAndWrites[Z, A20]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads), a13.reads), a14.reads), a15.reads), a16.reads), a17.reads), a18.reads), a19.reads), a20.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a); case a13.C(a) => a13.writes.writes(a); case a14.C(a) => a14.writes.writes(a); case a15.C(a) => a15.writes.writes(a); case a16.C(a) => a16.writes.writes(a); case a17.C(a) => a17.writes.writes(a); case a18.C(a) => a18.writes.writes(a); case a19.C(a) => a19.writes.writes(a); case a20.C(a) => a20.writes.writes(a)
      }
    )
  }

  implicit class ReadsAndWrites21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](a: FunctionalBuilder[OFormat]#CanBuild21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21]) {
    sealed abstract class WritesBuilder[B1]{
      def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2]
    }

    def readsAndWrites[B1](f1: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => B1): WritesBuilder[B1] =
      new WritesBuilder[B1] {
        override def apply[B2](f2: B2 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)])(implicit B2: ClassTag[B2]): ReadsAndWrites[B1, B2] = {
          val f = a[B1](f1, Function.unlift(f2.asInstanceOf[B1 => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)]]))
          ReadsAndWrites(f, f.asInstanceOf[OWrites[B2]], B2)
        }
      }
  }

  def format[Z, A1 <: Z, A2 <: Z, A3 <: Z, A4 <: Z, A5 <: Z, A6 <: Z, A7 <: Z, A8 <: Z, A9 <: Z, A10 <: Z, A11 <: Z, A12 <: Z, A13 <: Z, A14 <: Z, A15 <: Z, A16 <: Z, A17 <: Z, A18 <: Z, A19 <: Z, A20 <: Z, A21 <: Z](a1: ReadsAndWrites[Z, A1], a2: ReadsAndWrites[Z, A2], a3: ReadsAndWrites[Z, A3], a4: ReadsAndWrites[Z, A4], a5: ReadsAndWrites[Z, A5], a6: ReadsAndWrites[Z, A6], a7: ReadsAndWrites[Z, A7], a8: ReadsAndWrites[Z, A8], a9: ReadsAndWrites[Z, A9], a10: ReadsAndWrites[Z, A10], a11: ReadsAndWrites[Z, A11], a12: ReadsAndWrites[Z, A12], a13: ReadsAndWrites[Z, A13], a14: ReadsAndWrites[Z, A14], a15: ReadsAndWrites[Z, A15], a16: ReadsAndWrites[Z, A16], a17: ReadsAndWrites[Z, A17], a18: ReadsAndWrites[Z, A18], a19: ReadsAndWrites[Z, A19], a20: ReadsAndWrites[Z, A20], a21: ReadsAndWrites[Z, A21]): OFormat[Z] = {
    OFormat(
      F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(F.|(a1.reads, a2.reads), a3.reads), a4.reads), a5.reads), a6.reads), a7.reads), a8.reads), a9.reads), a10.reads), a11.reads), a12.reads), a13.reads), a14.reads), a15.reads), a16.reads), a17.reads), a18.reads), a19.reads), a20.reads), a21.reads),
      OWrites[Z]{
        case a1.C(a) => a1.writes.writes(a); case a2.C(a) => a2.writes.writes(a); case a3.C(a) => a3.writes.writes(a); case a4.C(a) => a4.writes.writes(a); case a5.C(a) => a5.writes.writes(a); case a6.C(a) => a6.writes.writes(a); case a7.C(a) => a7.writes.writes(a); case a8.C(a) => a8.writes.writes(a); case a9.C(a) => a9.writes.writes(a); case a10.C(a) => a10.writes.writes(a); case a11.C(a) => a11.writes.writes(a); case a12.C(a) => a12.writes.writes(a); case a13.C(a) => a13.writes.writes(a); case a14.C(a) => a14.writes.writes(a); case a15.C(a) => a15.writes.writes(a); case a16.C(a) => a16.writes.writes(a); case a17.C(a) => a17.writes.writes(a); case a18.C(a) => a18.writes.writes(a); case a19.C(a) => a19.writes.writes(a); case a20.C(a) => a20.writes.writes(a); case a21.C(a) => a21.writes.writes(a)
      }
    )
  }

}

