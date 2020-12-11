object session{

  val mylist = List(1,2,3,4,5,6)
  val mylist2 = List(7,8,9,10,11,12)
  sum_usual (List(1,2,3))

  def sum_usual (xs: List[Int]):Int = xs match{
    case Nil => 0
    case y :: ys => y + sum_usual(ys)
  }

def sum(xs:List[Int]) = (0 :: xs) reduceLeft((x,y)=> x + y)

  def product(xs:List[Int]) = (1 :: xs) reduceLeft((x,y)=> x * y)

// or

  def sum1(xs:List[Int]) = (0 :: xs) reduceLeft(_ + _)
  def product1(xs:List[Int]) = (1 :: xs) reduceLeft(_ * _)

  // or
  def sum2(xs:List[Int]) = (xs foldLeft 0) (_ + _)
  def product2(xs:List[Int]) = (xs foldLeft 1) (_ * _)

  (mylist foldLeft 0)(_+_)
  (mylist foldRight 0)(_+_)

  // concatenation
  val list = mylist :: mylist2

  (mylist foldRight mylist2) (_ :: _)

}