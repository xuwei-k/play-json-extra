package play.jsonext

import play.api.libs.json.{Writes, OWrites, JsObject}

object CaseClassWrites {

  def apply1[A1, Z](f: Z => Option[A1])(key1: String)(implicit A1: Writes[A1]): OWrites[Z] =
    OWrites(z => JsObject((key1, A1.writes(f(z).get)) :: Nil))

  def apply[A1, Z](f: Z => Option[A1])(key1: String)(implicit A1: Writes[A1]): OWrites[Z] =
    apply1(f)(key1)(A1)

  
  def apply2[A1, A2, Z](f: Z => Option[(A1, A2)])(key1: String, key2: String)(implicit A1: Writes[A1], A2: Writes[A2]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, Z](f: Z => Option[(A1, A2)])(key1: String, key2: String)(implicit A1: Writes[A1], A2: Writes[A2]): OWrites[Z] =
    apply2[A1, A2, Z](f)(key1, key2)(A1, A2)


  def apply3[A1, A2, A3, Z](f: Z => Option[(A1, A2, A3)])(key1: String, key2: String, key3: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, Z](f: Z => Option[(A1, A2, A3)])(key1: String, key2: String, key3: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3]): OWrites[Z] =
    apply3[A1, A2, A3, Z](f)(key1, key2, key3)(A1, A2, A3)


  def apply4[A1, A2, A3, A4, Z](f: Z => Option[(A1, A2, A3, A4)])(key1: String, key2: String, key3: String, key4: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, Z](f: Z => Option[(A1, A2, A3, A4)])(key1: String, key2: String, key3: String, key4: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4]): OWrites[Z] =
    apply4[A1, A2, A3, A4, Z](f)(key1, key2, key3, key4)(A1, A2, A3, A4)


  def apply5[A1, A2, A3, A4, A5, Z](f: Z => Option[(A1, A2, A3, A4, A5)])(key1: String, key2: String, key3: String, key4: String, key5: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, Z](f: Z => Option[(A1, A2, A3, A4, A5)])(key1: String, key2: String, key3: String, key4: String, key5: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5]): OWrites[Z] =
    apply5[A1, A2, A3, A4, A5, Z](f)(key1, key2, key3, key4, key5)(A1, A2, A3, A4, A5)


  def apply6[A1, A2, A3, A4, A5, A6, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6]): OWrites[Z] =
    apply6[A1, A2, A3, A4, A5, A6, Z](f)(key1, key2, key3, key4, key5, key6)(A1, A2, A3, A4, A5, A6)


  def apply7[A1, A2, A3, A4, A5, A6, A7, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7]): OWrites[Z] =
    apply7[A1, A2, A3, A4, A5, A6, A7, Z](f)(key1, key2, key3, key4, key5, key6, key7)(A1, A2, A3, A4, A5, A6, A7)


  def apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8]): OWrites[Z] =
    apply8[A1, A2, A3, A4, A5, A6, A7, A8, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8)(A1, A2, A3, A4, A5, A6, A7, A8)


  def apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9]): OWrites[Z] =
    apply9[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9)(A1, A2, A3, A4, A5, A6, A7, A8, A9)


  def apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10]): OWrites[Z] =
    apply10[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)


  def apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11]): OWrites[Z] =
    apply11[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)


  def apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12]): OWrites[Z] =
    apply12[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)


  def apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13]): OWrites[Z] =
    apply13[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)


  def apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key14, A14.writes(tuple._14))).::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14]): OWrites[Z] =
    apply14[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)


  def apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key15, A15.writes(tuple._15))).::((key14, A14.writes(tuple._14))).::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15]): OWrites[Z] =
    apply15[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)


  def apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key16, A16.writes(tuple._16))).::((key15, A15.writes(tuple._15))).::((key14, A14.writes(tuple._14))).::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16]): OWrites[Z] =
    apply16[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)


  def apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key17, A17.writes(tuple._17))).::((key16, A16.writes(tuple._16))).::((key15, A15.writes(tuple._15))).::((key14, A14.writes(tuple._14))).::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17]): OWrites[Z] =
    apply17[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)


  def apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key18, A18.writes(tuple._18))).::((key17, A17.writes(tuple._17))).::((key16, A16.writes(tuple._16))).::((key15, A15.writes(tuple._15))).::((key14, A14.writes(tuple._14))).::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18]): OWrites[Z] =
    apply18[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)


  def apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key19, A19.writes(tuple._19))).::((key18, A18.writes(tuple._18))).::((key17, A17.writes(tuple._17))).::((key16, A16.writes(tuple._16))).::((key15, A15.writes(tuple._15))).::((key14, A14.writes(tuple._14))).::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19]): OWrites[Z] =
    apply19[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)


  def apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19], A20: Writes[A20]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key20, A20.writes(tuple._20))).::((key19, A19.writes(tuple._19))).::((key18, A18.writes(tuple._18))).::((key17, A17.writes(tuple._17))).::((key16, A16.writes(tuple._16))).::((key15, A15.writes(tuple._15))).::((key14, A14.writes(tuple._14))).::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19], A20: Writes[A20]): OWrites[Z] =
    apply20[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)


  def apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19], A20: Writes[A20], A21: Writes[A21]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key21, A21.writes(tuple._21))).::((key20, A20.writes(tuple._20))).::((key19, A19.writes(tuple._19))).::((key18, A18.writes(tuple._18))).::((key17, A17.writes(tuple._17))).::((key16, A16.writes(tuple._16))).::((key15, A15.writes(tuple._15))).::((key14, A14.writes(tuple._14))).::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19], A20: Writes[A20], A21: Writes[A21]): OWrites[Z] =
    apply21[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)


  def apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String, key22: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19], A20: Writes[A20], A21: Writes[A21], A22: Writes[A22]): OWrites[Z] =
    OWrites{ z: Z =>
      val tuple = f(z).get
      JsObject(Nil.::((key22, A22.writes(tuple._22))).::((key21, A21.writes(tuple._21))).::((key20, A20.writes(tuple._20))).::((key19, A19.writes(tuple._19))).::((key18, A18.writes(tuple._18))).::((key17, A17.writes(tuple._17))).::((key16, A16.writes(tuple._16))).::((key15, A15.writes(tuple._15))).::((key14, A14.writes(tuple._14))).::((key13, A13.writes(tuple._13))).::((key12, A12.writes(tuple._12))).::((key11, A11.writes(tuple._11))).::((key10, A10.writes(tuple._10))).::((key9, A9.writes(tuple._9))).::((key8, A8.writes(tuple._8))).::((key7, A7.writes(tuple._7))).::((key6, A6.writes(tuple._6))).::((key5, A5.writes(tuple._5))).::((key4, A4.writes(tuple._4))).::((key3, A3.writes(tuple._3))).::((key2, A2.writes(tuple._2))).::((key1, A1.writes(tuple._1))))
    }

  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](f: Z => Option[(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)])(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String, key22: String)(implicit A1: Writes[A1], A2: Writes[A2], A3: Writes[A3], A4: Writes[A4], A5: Writes[A5], A6: Writes[A6], A7: Writes[A7], A8: Writes[A8], A9: Writes[A9], A10: Writes[A10], A11: Writes[A11], A12: Writes[A12], A13: Writes[A13], A14: Writes[A14], A15: Writes[A15], A16: Writes[A16], A17: Writes[A17], A18: Writes[A18], A19: Writes[A19], A20: Writes[A20], A21: Writes[A21], A22: Writes[A22]): OWrites[Z] =
    apply22[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, Z](f)(key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21, key22)(A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22)

}

