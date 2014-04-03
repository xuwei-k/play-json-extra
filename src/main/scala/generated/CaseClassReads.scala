package play.jsonext

import play.api.libs.json.{Reads, JsPath, JsValue, JsResult}
import play.api.libs.functional.syntax._
import play.api.libs.functional.Functor

object CaseClassReads {

  private[this] implicit val jsResultFunctor: Functor[JsResult] =
    new Functor[JsResult] {
      def fmap[A, B](m: JsResult[A], f: A => B) = m map f
    }


  def apply[A1, Z](f: A1 => Z)(key1: String)(implicit A1: Reads[A1]): Reads[Z] =
    Reads.at(JsPath \ key1)(A1).map(f)

  
  def apply[A1, A2, Z](f: (A1, A2) => Z)(key1: String, key2: String)(implicit A1: Reads[A1], A2: Reads[A2]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2))(f)
    )


  def apply[A1, A2, A3, Z](f: (A1, A2, A3) => Z)(key1: String, key2: String, key3: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3))(f)
    )


  def apply[A1, A2, A3, A4, Z](f: (A1, A2, A3, A4) => Z)(key1: String, key2: String, key3: String, key4: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4))(f)
    )


  def apply[A1, A2, A3, A4, A5, Z](f: (A1, A2, A3, A4, A5) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, Z](f: (A1, A2, A3, A4, A5, A6) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, Z](f: (A1, A2, A3, A4, A5, A6, A7) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12) and (json \ key13).validate(A13))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12) and (json \ key13).validate(A13) and (json \ key14).validate(A14))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12) and (json \ key13).validate(A13) and (json \ key14).validate(A14) and (json \ key15).validate(A15))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12) and (json \ key13).validate(A13) and (json \ key14).validate(A14) and (json \ key15).validate(A15) and (json \ key16).validate(A16))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12) and (json \ key13).validate(A13) and (json \ key14).validate(A14) and (json \ key15).validate(A15) and (json \ key16).validate(A16) and (json \ key17).validate(A17))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12) and (json \ key13).validate(A13) and (json \ key14).validate(A14) and (json \ key15).validate(A15) and (json \ key16).validate(A16) and (json \ key17).validate(A17) and (json \ key18).validate(A18))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18], A19: Reads[A19]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12) and (json \ key13).validate(A13) and (json \ key14).validate(A14) and (json \ key15).validate(A15) and (json \ key16).validate(A16) and (json \ key17).validate(A17) and (json \ key18).validate(A18) and (json \ key19).validate(A19))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18], A19: Reads[A19], A20: Reads[A20]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12) and (json \ key13).validate(A13) and (json \ key14).validate(A14) and (json \ key15).validate(A15) and (json \ key16).validate(A16) and (json \ key17).validate(A17) and (json \ key18).validate(A18) and (json \ key19).validate(A19) and (json \ key20).validate(A20))(f)
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18], A19: Reads[A19], A20: Reads[A20], A21: Reads[A21]): Reads[Z] =
    Reads[Z](json =>
      ((json \ key1).validate(A1) and (json \ key2).validate(A2) and (json \ key3).validate(A3) and (json \ key4).validate(A4) and (json \ key5).validate(A5) and (json \ key6).validate(A6) and (json \ key7).validate(A7) and (json \ key8).validate(A8) and (json \ key9).validate(A9) and (json \ key10).validate(A10) and (json \ key11).validate(A11) and (json \ key12).validate(A12) and (json \ key13).validate(A13) and (json \ key14).validate(A14) and (json \ key15).validate(A15) and (json \ key16).validate(A16) and (json \ key17).validate(A17) and (json \ key18).validate(A18) and (json \ key19).validate(A19) and (json \ key20).validate(A20) and (json \ key21).validate(A21))(f)
    )

}

