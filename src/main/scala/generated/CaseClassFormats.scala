package play.jsonext

import play.api.libs.json.{Reads, Writes, OFormat, OWrites}

object CaseClassFormats {
  
  def apply1[A1, Z](applyFunc: A1 => Z, unapplyFunc: Z => Option[A1])(key1: String)(implicit A1R: Reads[A1], A1W: Writes[A1]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1),
      CaseClassWrites(unapplyFunc)(key1)
    )

  def apply[A1, Z](applyFunc: A1 => Z, unapplyFunc: Z => Option[A1])(key1: String)(implicit A1R: Reads[A1], A1W: Writes[A1]): OFormat[Z] =
    apply1[A1, Z](applyFunc, unapplyFunc)(key1)(A1R, A1W)


  final class Builder1[R](key1: String) {
    def build[A1, W](applyFunc: A1 => R, unapplyFunc: W => Option[A1])(implicit A1R: Reads[A1], A1W: Writes[A1]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1), CaseClassWrites(unapplyFunc)(key1))
  }

  def readsAndWrites[R](key1: String): Builder1[R] =
    new Builder1(key1)

  def readsAndWrites1[R](key1: String): Builder1[R] =
    new Builder1(key1)


  def apply2[A1, A2, Z](applyFunc: (A1, A2) => Z, unapplyFunc: Z => Option[(A1, A2)])(key1: String, key2: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A1W: Writes[A1], A2W: Writes[A2]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2),
      CaseClassWrites(unapplyFunc)(key1, key2)
    )

  def apply[A1, A2, Z](applyFunc: (A1, A2) => Z, unapplyFunc: Z => Option[(A1, A2)])(key1: String, key2: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A1W: Writes[A1], A2W: Writes[A2]): OFormat[Z] =
    apply2[A1, A2, Z](applyFunc, unapplyFunc)(key1, key2)(A1R, A2R, A1W, A2W)


  final class Builder2[R](key1: String, key2: String) {
    def build[A1, A2, W](applyFunc: (A1, A2) => R, unapplyFunc: W => Option[(A1, A2)])(implicit A1R: Reads[A1], A2R: Reads[A2], A1W: Writes[A1], A2W: Writes[A2]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2), CaseClassWrites(unapplyFunc)(key1, key2))
  }

  def readsAndWrites[R](key1: String, key2: String): Builder2[R] =
    new Builder2(key1, key2)

  def readsAndWrites2[R](key1: String, key2: String): Builder2[R] =
    new Builder2(key1, key2)


  def apply3[A1, A2, A3, Z](applyFunc: (A1, A2, A3) => Z, unapplyFunc: Z => Option[(A1, A2, A3)])(key1: String, key2: String, key3: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3),
      CaseClassWrites(unapplyFunc)(key1, key2, key3)
    )

  def apply[A1, A2, A3, Z](applyFunc: (A1, A2, A3) => Z, unapplyFunc: Z => Option[(A1, A2, A3)])(key1: String, key2: String, key3: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3]): OFormat[Z] =
    apply3[A1, A2, A3, Z](applyFunc, unapplyFunc)(key1, key2, key3)(A1R, A2R, A3R, A1W, A2W, A3W)


  final class Builder3[R](key1: String, key2: String, key3: String) {
    def build[A1, A2, A3, W](applyFunc: (A1, A2, A3) => R, unapplyFunc: W => Option[(A1, A2, A3)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3), CaseClassWrites(unapplyFunc)(key1, key2, key3))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String): Builder3[R] =
    new Builder3(key1, key2, key3)

  def readsAndWrites3[R](key1: String, key2: String, key3: String): Builder3[R] =
    new Builder3(key1, key2, key3)


  def apply4[A1, A2, A3, A4, Z](applyFunc: (A1, A2, A3, A4) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4)])(key1: String, key2: String, key3: String, key4: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4)
    )

  def apply[A1, A2, A3, A4, Z](applyFunc: (A1, A2, A3, A4) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4)])(key1: String, key2: String, key3: String, key4: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4]): OFormat[Z] =
    apply4[A1, A2, A3, A4, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4)(A1R, A2R, A3R, A4R, A1W, A2W, A3W, A4W)


  final class Builder4[R](key1: String, key2: String, key3: String, key4: String) {
    def build[A1, A2, A3, A4, W](applyFunc: (A1, A2, A3, A4) => R, unapplyFunc: W => Option[(A1, A2, A3, A4)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String): Builder4[R] =
    new Builder4(key1, key2, key3, key4)

  def readsAndWrites4[R](key1: String, key2: String, key3: String, key4: String): Builder4[R] =
    new Builder4(key1, key2, key3, key4)


  def apply5[A1, A2, A3, A4, A5, Z](applyFunc: (A1, A2, A3, A4, A5) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5)])(key1: String, key2: String, key3: String, key4: String, key5: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5)
    )

  def apply[A1, A2, A3, A4, A5, Z](applyFunc: (A1, A2, A3, A4, A5) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5)])(key1: String, key2: String, key3: String, key4: String, key5: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5]): OFormat[Z] =
    apply5[A1, A2, A3, A4, A5, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5)(A1R, A2R, A3R, A4R, A5R, A1W, A2W, A3W, A4W, A5W)


  final class Builder5[R](key1: String, key2: String, key3: String, key4: String, key5: String) {
    def build[A1, A2, A3, A4, A5, W](applyFunc: (A1, A2, A3, A4, A5) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String): Builder5[R] =
    new Builder5(key1, key2, key3, key4, key5)

  def readsAndWrites5[R](key1: String, key2: String, key3: String, key4: String, key5: String): Builder5[R] =
    new Builder5(key1, key2, key3, key4, key5)


  def apply6[A1, A2, A3, A4, A5, A6, Z](applyFunc: (A1, A2, A3, A4, A5, A6) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6)
    )

  def apply[A1, A2, A3, A4, A5, A6, Z](applyFunc: (A1, A2, A3, A4, A5, A6) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6]): OFormat[Z] =
    apply6[A1, A2, A3, A4, A5, A6, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6)(A1R, A2R, A3R, A4R, A5R, A6R, A1W, A2W, A3W, A4W, A5W, A6W)


  final class Builder6[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String) {
    def build[A1, A2, A3, A4, A5, A6, W](applyFunc: (A1, A2, A3, A4, A5, A6) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String): Builder6[R] =
    new Builder6(key1, key2, key3, key4, key5, key6)

  def readsAndWrites6[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String): Builder6[R] =
    new Builder6(key1, key2, key3, key4, key5, key6)


  def apply7[A1, A2, A3, A4, A5, A6, A7, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7]): OFormat[Z] =
    apply7[A1, A2, A3, A4, A5, A6, A7, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A1W, A2W, A3W, A4W, A5W, A6W, A7W)


  final class Builder7[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String): Builder7[R] =
    new Builder7(key1, key2, key3, key4, key5, key6, key7)

  def readsAndWrites7[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String): Builder7[R] =
    new Builder7(key1, key2, key3, key4, key5, key6, key7)


  def apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8]): OFormat[Z] =
    apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W)


  final class Builder8[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String): Builder8[R] =
    new Builder8(key1, key2, key3, key4, key5, key6, key7, key8)

  def readsAndWrites8[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String): Builder8[R] =
    new Builder8(key1, key2, key3, key4, key5, key6, key7, key8)


  def apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9]): OFormat[Z] =
    apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W)


  final class Builder9[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String): Builder9[R] =
    new Builder9(key1, key2, key3, key4, key5, key6, key7, key8, key9)

  def readsAndWrites9[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String): Builder9[R] =
    new Builder9(key1, key2, key3, key4, key5, key6, key7, key8, key9)


  def apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10]): OFormat[Z] =
    apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W)


  final class Builder10[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String): Builder10[R] =
    new Builder10(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10)

  def readsAndWrites10[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String): Builder10[R] =
    new Builder10(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10)


  def apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11]): OFormat[Z] =
    apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W)


  final class Builder11[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String): Builder11[R] =
    new Builder11(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11)

  def readsAndWrites11[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String): Builder11[R] =
    new Builder11(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11)


  def apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12]): OFormat[Z] =
    apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W)


  final class Builder12[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String): Builder12[R] =
    new Builder12(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12)

  def readsAndWrites12[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String): Builder12[R] =
    new Builder12(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12)


  def apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13]): OFormat[Z] =
    apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W)


  final class Builder13[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String): Builder13[R] =
    new Builder13(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13)

  def readsAndWrites13[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String): Builder13[R] =
    new Builder13(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13)


  def apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14]): OFormat[Z] =
    apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A14R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W, A14W)


  final class Builder14[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String): Builder14[R] =
    new Builder14(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14)

  def readsAndWrites14[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String): Builder14[R] =
    new Builder14(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14)


  def apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15]): OFormat[Z] =
    apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A14R, A15R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W, A14W, A15W)


  final class Builder15[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String): Builder15[R] =
    new Builder15(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15)

  def readsAndWrites15[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String): Builder15[R] =
    new Builder15(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15)


  def apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16]): OFormat[Z] =
    apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A14R, A15R, A16R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W, A14W, A15W, A16W)


  final class Builder16[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String): Builder16[R] =
    new Builder16(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16)

  def readsAndWrites16[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String): Builder16[R] =
    new Builder16(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16)


  def apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17]): OFormat[Z] =
    apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A14R, A15R, A16R, A17R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W, A14W, A15W, A16W, A17W)


  final class Builder17[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String): Builder17[R] =
    new Builder17(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17)

  def readsAndWrites17[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String): Builder17[R] =
    new Builder17(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17)


  def apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18]): OFormat[Z] =
    apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A14R, A15R, A16R, A17R, A18R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W, A14W, A15W, A16W, A17W, A18W)


  final class Builder18[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String): Builder18[R] =
    new Builder18(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18)

  def readsAndWrites18[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String): Builder18[R] =
    new Builder18(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18)


  def apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19]): OFormat[Z] =
    apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A14R, A15R, A16R, A17R, A18R, A19R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W, A14W, A15W, A16W, A17W, A18W, A19W)


  final class Builder19[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String): Builder19[R] =
    new Builder19(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19)

  def readsAndWrites19[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String): Builder19[R] =
    new Builder19(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19)


  def apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20]): OFormat[Z] =
    apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A14R, A15R, A16R, A17R, A18R, A19R, A20R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W, A14W, A15W, A16W, A17W, A18W, A19W, A20W)


  final class Builder20[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String): Builder20[R] =
    new Builder20(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20)

  def readsAndWrites20[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String): Builder20[R] =
    new Builder20(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20)


  def apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A21R: Reads[A21], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20], A21W: Writes[A21]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A21R: Reads[A21], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20], A21W: Writes[A21]): OFormat[Z] =
    apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A14R, A15R, A16R, A17R, A18R, A19R, A20R, A21R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W, A14W, A15W, A16W, A17W, A18W, A19W, A20W, A21W)


  final class Builder21[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A21R: Reads[A21], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20], A21W: Writes[A21]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String): Builder21[R] =
    new Builder21(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21)

  def readsAndWrites21[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String): Builder21[R] =
    new Builder21(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21)


  def apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String, key22: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A21R: Reads[A21], A22R: Reads[A22], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20], A21W: Writes[A21], A22W: Writes[A22]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21, key22),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21, key22)
    )

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String, key22: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A21R: Reads[A21], A22R: Reads[A22], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20], A21W: Writes[A21], A22W: Writes[A22]): OFormat[Z] =
    apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](applyFunc, unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21, key22)(A1R, A2R, A3R, A4R, A5R, A6R, A7R, A8R, A9R, A10R, A11R, A12R, A13R, A14R, A15R, A16R, A17R, A18R, A19R, A20R, A21R, A22R, A1W, A2W, A3W, A4W, A5W, A6W, A7W, A8W, A9W, A10W, A11W, A12W, A13W, A14W, A15W, A16W, A17W, A18W, A19W, A20W, A21W, A22W)


  final class Builder22[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String, key22: String) {
    def build[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, W](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22) => R, unapplyFunc: W => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)])(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A21R: Reads[A21], A22R: Reads[A22], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20], A21W: Writes[A21], A22W: Writes[A22]): (Reads[R], OWrites[W]) =
      (CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21, key22), CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21, key22))
  }

  def readsAndWrites[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String, key22: String): Builder22[R] =
    new Builder22(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21, key22)

  def readsAndWrites22[R](key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String, key22: String): Builder22[R] =
    new Builder22(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21, key22)

}

