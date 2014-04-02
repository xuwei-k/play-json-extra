package play.jsonext

import play.api.libs.json.{Reads, JsPath}
import play.api.libs.functional.syntax._

object CaseClassReads {

  def apply[A1, Z](f: A1 => Z)(key1: String)(implicit A1: Reads[A1]): Reads[Z] =
    Reads.at(JsPath \ key1)(A1).map(f)

  
  def apply[A1, A2, Z](f: (A1, A2) => Z)(key1: String, key2: String)(implicit A1: Reads[A1], A2: Reads[A2]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2))(f)


  def apply[A1, A2, A3, Z](f: (A1, A2, A3) => Z)(key1: String, key2: String, key3: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3))(f)


  def apply[A1, A2, A3, A4, Z](f: (A1, A2, A3, A4) => Z)(key1: String, key2: String, key3: String, key4: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4))(f)


  def apply[A1, A2, A3, A4, A5, Z](f: (A1, A2, A3, A4, A5) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5))(f)


  def apply[A1, A2, A3, A4, A5, A6, Z](f: (A1, A2, A3, A4, A5, A6) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, Z](f: (A1, A2, A3, A4, A5, A6, A7) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12) and Reads.at(JsPath \ key13)(A13))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12) and Reads.at(JsPath \ key13)(A13) and Reads.at(JsPath \ key14)(A14))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12) and Reads.at(JsPath \ key13)(A13) and Reads.at(JsPath \ key14)(A14) and Reads.at(JsPath \ key15)(A15))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12) and Reads.at(JsPath \ key13)(A13) and Reads.at(JsPath \ key14)(A14) and Reads.at(JsPath \ key15)(A15) and Reads.at(JsPath \ key16)(A16))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12) and Reads.at(JsPath \ key13)(A13) and Reads.at(JsPath \ key14)(A14) and Reads.at(JsPath \ key15)(A15) and Reads.at(JsPath \ key16)(A16) and Reads.at(JsPath \ key17)(A17))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12) and Reads.at(JsPath \ key13)(A13) and Reads.at(JsPath \ key14)(A14) and Reads.at(JsPath \ key15)(A15) and Reads.at(JsPath \ key16)(A16) and Reads.at(JsPath \ key17)(A17) and Reads.at(JsPath \ key18)(A18))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18], A19: Reads[A19]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12) and Reads.at(JsPath \ key13)(A13) and Reads.at(JsPath \ key14)(A14) and Reads.at(JsPath \ key15)(A15) and Reads.at(JsPath \ key16)(A16) and Reads.at(JsPath \ key17)(A17) and Reads.at(JsPath \ key18)(A18) and Reads.at(JsPath \ key19)(A19))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18], A19: Reads[A19], A20: Reads[A20]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12) and Reads.at(JsPath \ key13)(A13) and Reads.at(JsPath \ key14)(A14) and Reads.at(JsPath \ key15)(A15) and Reads.at(JsPath \ key16)(A16) and Reads.at(JsPath \ key17)(A17) and Reads.at(JsPath \ key18)(A18) and Reads.at(JsPath \ key19)(A19) and Reads.at(JsPath \ key20)(A20))(f)


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18], A19: Reads[A19], A20: Reads[A20], A21: Reads[A21]): Reads[Z] =
    (Reads.at(JsPath \ key1)(A1) and Reads.at(JsPath \ key2)(A2) and Reads.at(JsPath \ key3)(A3) and Reads.at(JsPath \ key4)(A4) and Reads.at(JsPath \ key5)(A5) and Reads.at(JsPath \ key6)(A6) and Reads.at(JsPath \ key7)(A7) and Reads.at(JsPath \ key8)(A8) and Reads.at(JsPath \ key9)(A9) and Reads.at(JsPath \ key10)(A10) and Reads.at(JsPath \ key11)(A11) and Reads.at(JsPath \ key12)(A12) and Reads.at(JsPath \ key13)(A13) and Reads.at(JsPath \ key14)(A14) and Reads.at(JsPath \ key15)(A15) and Reads.at(JsPath \ key16)(A16) and Reads.at(JsPath \ key17)(A17) and Reads.at(JsPath \ key18)(A18) and Reads.at(JsPath \ key19)(A19) and Reads.at(JsPath \ key20)(A20) and Reads.at(JsPath \ key21)(A21))(f)

}

