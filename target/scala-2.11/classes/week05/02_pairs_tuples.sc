object session {

  val mylist = List (5,2,6,1,9,-2)
  val tupleexample = Tuple2(2,3)
  tupleexample._1.toString

  // or
  val (num1,num2) = tupleexample
  num2.toString

  val nextlist = 89 :: mylist


}