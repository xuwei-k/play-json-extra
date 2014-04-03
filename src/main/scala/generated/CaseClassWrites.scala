package play.jsonext

import play.api.libs.json.{Writes, OWrites, JsPath}
import play.api.libs.functional.syntax._

object CaseClassWrites {

  def apply[A1, Z](f: Z => Option[A1])(key1: String)(implicit A1: Writes[A1]): OWrites[Z] =
    Writes.at(JsPath \ key1)(A1).contramap(Function.unlift(f))

  
  def apply[A1, A2, Z](f: Z => Option[(A1, A2)])(key1: String, key2: String)(implicit A1: Writes[A1], A2: Writes[A2]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2)))
    }


  def apply[A1, A2, A3, Z](f: Z => Option[(A1, A2, A3)])(key1: String, key2: String, key3: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3)))
    }


  def apply[A1, A2, A3, A4, Z](f: Z => Option[(A1, A2, A3, A4)])(key1: String, key2: String, key3: String, key4: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4)))
    }


  def apply[A1, A2, A3, A4, A5, Z](f: Z => Option[(A1, A2, A3, A4, A5)])(key1: String, key2: String, key3: String, key4: String, key5: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5)))
    }


  def apply[A1, A2, A3, A4, A5, A6, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12))).deepMerge(JsPath.createObj((JsPath \ key13) -> A13.writes(tuple._13)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12))).deepMerge(JsPath.createObj((JsPath \ key13) -> A13.writes(tuple._13))).deepMerge(JsPath.createObj((JsPath \ key14) -> A14.writes(tuple._14)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12))).deepMerge(JsPath.createObj((JsPath \ key13) -> A13.writes(tuple._13))).deepMerge(JsPath.createObj((JsPath \ key14) -> A14.writes(tuple._14))).deepMerge(JsPath.createObj((JsPath \ key15) -> A15.writes(tuple._15)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12))).deepMerge(JsPath.createObj((JsPath \ key13) -> A13.writes(tuple._13))).deepMerge(JsPath.createObj((JsPath \ key14) -> A14.writes(tuple._14))).deepMerge(JsPath.createObj((JsPath \ key15) -> A15.writes(tuple._15))).deepMerge(JsPath.createObj((JsPath \ key16) -> A16.writes(tuple._16)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12))).deepMerge(JsPath.createObj((JsPath \ key13) -> A13.writes(tuple._13))).deepMerge(JsPath.createObj((JsPath \ key14) -> A14.writes(tuple._14))).deepMerge(JsPath.createObj((JsPath \ key15) -> A15.writes(tuple._15))).deepMerge(JsPath.createObj((JsPath \ key16) -> A16.writes(tuple._16))).deepMerge(JsPath.createObj((JsPath \ key17) -> A17.writes(tuple._17)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12))).deepMerge(JsPath.createObj((JsPath \ key13) -> A13.writes(tuple._13))).deepMerge(JsPath.createObj((JsPath \ key14) -> A14.writes(tuple._14))).deepMerge(JsPath.createObj((JsPath \ key15) -> A15.writes(tuple._15))).deepMerge(JsPath.createObj((JsPath \ key16) -> A16.writes(tuple._16))).deepMerge(JsPath.createObj((JsPath \ key17) -> A17.writes(tuple._17))).deepMerge(JsPath.createObj((JsPath \ key18) -> A18.writes(tuple._18)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12))).deepMerge(JsPath.createObj((JsPath \ key13) -> A13.writes(tuple._13))).deepMerge(JsPath.createObj((JsPath \ key14) -> A14.writes(tuple._14))).deepMerge(JsPath.createObj((JsPath \ key15) -> A15.writes(tuple._15))).deepMerge(JsPath.createObj((JsPath \ key16) -> A16.writes(tuple._16))).deepMerge(JsPath.createObj((JsPath \ key17) -> A17.writes(tuple._17))).deepMerge(JsPath.createObj((JsPath \ key18) -> A18.writes(tuple._18))).deepMerge(JsPath.createObj((JsPath \ key19) -> A19.writes(tuple._19)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19], A20: Writes[A20]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12))).deepMerge(JsPath.createObj((JsPath \ key13) -> A13.writes(tuple._13))).deepMerge(JsPath.createObj((JsPath \ key14) -> A14.writes(tuple._14))).deepMerge(JsPath.createObj((JsPath \ key15) -> A15.writes(tuple._15))).deepMerge(JsPath.createObj((JsPath \ key16) -> A16.writes(tuple._16))).deepMerge(JsPath.createObj((JsPath \ key17) -> A17.writes(tuple._17))).deepMerge(JsPath.createObj((JsPath \ key18) -> A18.writes(tuple._18))).deepMerge(JsPath.createObj((JsPath \ key19) -> A19.writes(tuple._19))).deepMerge(JsPath.createObj((JsPath \ key20) -> A20.writes(tuple._20)))
    }


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19], A20: Writes[A20], A21: Writes[A21]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      (JsPath.createObj((JsPath \ key1) -> A1.writes(tuple._1))).deepMerge(JsPath.createObj((JsPath \ key2) -> A2.writes(tuple._2))).deepMerge(JsPath.createObj((JsPath \ key3) -> A3.writes(tuple._3))).deepMerge(JsPath.createObj((JsPath \ key4) -> A4.writes(tuple._4))).deepMerge(JsPath.createObj((JsPath \ key5) -> A5.writes(tuple._5))).deepMerge(JsPath.createObj((JsPath \ key6) -> A6.writes(tuple._6))).deepMerge(JsPath.createObj((JsPath \ key7) -> A7.writes(tuple._7))).deepMerge(JsPath.createObj((JsPath \ key8) -> A8.writes(tuple._8))).deepMerge(JsPath.createObj((JsPath \ key9) -> A9.writes(tuple._9))).deepMerge(JsPath.createObj((JsPath \ key10) -> A10.writes(tuple._10))).deepMerge(JsPath.createObj((JsPath \ key11) -> A11.writes(tuple._11))).deepMerge(JsPath.createObj((JsPath \ key12) -> A12.writes(tuple._12))).deepMerge(JsPath.createObj((JsPath \ key13) -> A13.writes(tuple._13))).deepMerge(JsPath.createObj((JsPath \ key14) -> A14.writes(tuple._14))).deepMerge(JsPath.createObj((JsPath \ key15) -> A15.writes(tuple._15))).deepMerge(JsPath.createObj((JsPath \ key16) -> A16.writes(tuple._16))).deepMerge(JsPath.createObj((JsPath \ key17) -> A17.writes(tuple._17))).deepMerge(JsPath.createObj((JsPath \ key18) -> A18.writes(tuple._18))).deepMerge(JsPath.createObj((JsPath \ key19) -> A19.writes(tuple._19))).deepMerge(JsPath.createObj((JsPath \ key20) -> A20.writes(tuple._20))).deepMerge(JsPath.createObj((JsPath \ key21) -> A21.writes(tuple._21)))
    }

}

