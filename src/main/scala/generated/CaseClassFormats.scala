package play.jsonext

import play.api.libs.json.{Reads, Writes, Format, OFormat, JsPath}
import play.api.libs.functional.syntax._

object CaseClassFormats {

  def apply[A1, Z](applyFunc: A1 => Z, unapplyFunc: Z => Option[A1])(key1: String)(implicit A1R: Reads[A1], A1W: Writes[A1]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1),
      CaseClassWrites(unapplyFunc)(key1)
    )

  
  def apply[A1, A2, Z](applyFunc: (A1, A2) => Z, unapplyFunc: Z => Option[(A1, A2)])(key1: String, key2: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A1W: Writes[A1], A2W: Writes[A2]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2),
      CaseClassWrites(unapplyFunc)(key1, key2)
    )


  def apply[A1, A2, A3, Z](applyFunc: (A1, A2, A3) => Z, unapplyFunc: Z => Option[(A1, A2, A3)])(key1: String, key2: String, key3: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3),
      CaseClassWrites(unapplyFunc)(key1, key2, key3)
    )


  def apply[A1, A2, A3, A4, Z](applyFunc: (A1, A2, A3, A4) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4)])(key1: String, key2: String, key3: String, key4: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4)
    )


  def apply[A1, A2, A3, A4, A5, Z](applyFunc: (A1, A2, A3, A4, A5) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5)])(key1: String, key2: String, key3: String, key4: String, key5: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5)
    )


  def apply[A1, A2, A3, A4, A5, A6, Z](applyFunc: (A1, A2, A3, A4, A5, A6) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](applyFunc: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z, unapplyFunc: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String)(implicit A1R: Reads[A1], A2R: Reads[A2], A3R: Reads[A3], A4R: Reads[A4], A5R: Reads[A5], A6R: Reads[A6], A7R: Reads[A7], A8R: Reads[A8], A9R: Reads[A9], A10R: Reads[A10], A11R: Reads[A11], A12R: Reads[A12], A13R: Reads[A13], A14R: Reads[A14], A15R: Reads[A15], A16R: Reads[A16], A17R: Reads[A17], A18R: Reads[A18], A19R: Reads[A19], A20R: Reads[A20], A21R: Reads[A21], A1W: Writes[A1], A2W: Writes[A2], A3W: Writes[A3], A4W: Writes[A4], A5W: Writes[A5], A6W: Writes[A6], A7W: Writes[A7], A8W: Writes[A8], A9W: Writes[A9], A10W: Writes[A10], A11W: Writes[A11], A12W: Writes[A12], A13W: Writes[A13], A14W: Writes[A14], A15W: Writes[A15], A16W: Writes[A16], A17W: Writes[A17], A18W: Writes[A18], A19W: Writes[A19], A20W: Writes[A20], A21W: Writes[A21]): OFormat[Z] =
    OFormat(
      CaseClassReads(applyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21),
      CaseClassWrites(unapplyFunc)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21)
    )

}

