package play.jsonext

import play.api.libs.json.{Reads, JsPath, JsValue, JsResult}
import play.api.libs.functional.syntax.functionalCanBuildApplicative
import play.api.libs.functional.{FunctionalCanBuild, ~}

object CaseClassReads {

  private[this] val G: FunctionalCanBuild[JsResult] =
    functionalCanBuildApplicative[JsResult]


  def apply[A1, Z](f: A1 => Z)(key1: String)(implicit A1: Reads[A1]): Reads[Z] =
    Reads.at(JsPath \ key1)(A1).map(f)

  
  def apply[A1, A2, Z](f: (A1, A2) => Z)(key1: String, key2: String)(implicit A1: Reads[A1], A2: Reads[A2]): Reads[Z] =
    Reads[Z](json =>
      G(A1.reads(json \ key1), A2.reads(json \ key2)).map{ case a1 ~ a2 => f(a1, a2)}
    )


  def apply[A1, A2, A3, Z](f: (A1, A2, A3) => Z)(key1: String, key2: String, key3: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3]): Reads[Z] =
    Reads[Z](json =>
      G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)).map{ case a1 ~ a2 ~ a3 => f(a1, a2, a3)}
    )


  def apply[A1, A2, A3, A4, Z](f: (A1, A2, A3, A4) => Z)(key1: String, key2: String, key3: String, key4: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)).map{ case a1 ~ a2 ~ a3 ~ a4 => f(a1, a2, a3, a4)}
    )


  def apply[A1, A2, A3, A4, A5, Z](f: (A1, A2, A3, A4, A5) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 => f(a1, a2, a3, a4, a5)}
    )


  def apply[A1, A2, A3, A4, A5, A6, Z](f: (A1, A2, A3, A4, A5, A6) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 => f(a1, a2, a3, a4, a5, a6)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, Z](f: (A1, A2, A3, A4, A5, A6, A7) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 => f(a1, a2, a3, a4, a5, a6, a7)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 => f(a1, a2, a3, a4, a5, a6, a7, a8)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)), A13.reads(json \ key13)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 ~ a13 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)), A13.reads(json \ key13)), A14.reads(json \ key14)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 ~ a13 ~ a14 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)), A13.reads(json \ key13)), A14.reads(json \ key14)), A15.reads(json \ key15)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 ~ a13 ~ a14 ~ a15 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)), A13.reads(json \ key13)), A14.reads(json \ key14)), A15.reads(json \ key15)), A16.reads(json \ key16)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 ~ a13 ~ a14 ~ a15 ~ a16 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)), A13.reads(json \ key13)), A14.reads(json \ key14)), A15.reads(json \ key15)), A16.reads(json \ key16)), A17.reads(json \ key17)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 ~ a13 ~ a14 ~ a15 ~ a16 ~ a17 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)), A13.reads(json \ key13)), A14.reads(json \ key14)), A15.reads(json \ key15)), A16.reads(json \ key16)), A17.reads(json \ key17)), A18.reads(json \ key18)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 ~ a13 ~ a14 ~ a15 ~ a16 ~ a17 ~ a18 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18], A19: Reads[A19]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)), A13.reads(json \ key13)), A14.reads(json \ key14)), A15.reads(json \ key15)), A16.reads(json \ key16)), A17.reads(json \ key17)), A18.reads(json \ key18)), A19.reads(json \ key19)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 ~ a13 ~ a14 ~ a15 ~ a16 ~ a17 ~ a18 ~ a19 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18], A19: Reads[A19], A20: Reads[A20]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)), A13.reads(json \ key13)), A14.reads(json \ key14)), A15.reads(json \ key15)), A16.reads(json \ key16)), A17.reads(json \ key17)), A18.reads(json \ key18)), A19.reads(json \ key19)), A20.reads(json \ key20)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 ~ a13 ~ a14 ~ a15 ~ a16 ~ a17 ~ a18 ~ a19 ~ a20 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20)}
    )


  def apply[A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, Z](f: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21) => Z)(key1: String, key2: String, key3: String, key4: String, key5: String, key6: String, key7: String, key8: String, key9: String, key10: String, key11: String, key12: String, key13: String, key14: String, key15: String, key16: String, key17: String, key18: String, key19: String, key20: String, key21: String)(implicit A1: Reads[A1], A2: Reads[A2], A3: Reads[A3], A4: Reads[A4], A5: Reads[A5], A6: Reads[A6], A7: Reads[A7], A8: Reads[A8], A9: Reads[A9], A10: Reads[A10], A11: Reads[A11], A12: Reads[A12], A13: Reads[A13], A14: Reads[A14], A15: Reads[A15], A16: Reads[A16], A17: Reads[A17], A18: Reads[A18], A19: Reads[A19], A20: Reads[A20], A21: Reads[A21]): Reads[Z] =
    Reads[Z](json =>
      G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(G(A1.reads(json \ key1), A2.reads(json \ key2)), A3.reads(json \ key3)), A4.reads(json \ key4)), A5.reads(json \ key5)), A6.reads(json \ key6)), A7.reads(json \ key7)), A8.reads(json \ key8)), A9.reads(json \ key9)), A10.reads(json \ key10)), A11.reads(json \ key11)), A12.reads(json \ key12)), A13.reads(json \ key13)), A14.reads(json \ key14)), A15.reads(json \ key15)), A16.reads(json \ key16)), A17.reads(json \ key17)), A18.reads(json \ key18)), A19.reads(json \ key19)), A20.reads(json \ key20)), A21.reads(json \ key21)).map{ case a1 ~ a2 ~ a3 ~ a4 ~ a5 ~ a6 ~ a7 ~ a8 ~ a9 ~ a10 ~ a11 ~ a12 ~ a13 ~ a14 ~ a15 ~ a16 ~ a17 ~ a18 ~ a19 ~ a20 ~ a21 => f(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21)}
    )

}

