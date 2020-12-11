import scala.collection.immutable.::

object session {

  def scaleList(xs:List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y::ys => y * factor :: scaleList(ys,factor)
  }

  scaleList(List(1,2,3,4), 1.5)

  def scaleListMap(xs:List[Double], factor: Double): List[Double] =
    xs map(x=>x*factor)

  scaleListMap(List(6,2,3,4), 2.5)


  def squareList(xs:List[Int]):List[Int] = xs match{
    case Nil => Nil
    case y::ys => y*y :: squareList(ys)
  }

  def squareListMap(xs:List[Int]):List[Int] = {
    xs map (x=>x*x)
  }

  squareList(List(4,2,3,8))
  squareListMap(List(7,2,3,8))

  val test = List(1,2,3,4,5)


  // filter
  val nums = List (2,3,-41,5,6,9,1)
  val fruits = List ("banana","apple","pineapple","strawberry","orange")

  nums filter (x => x > 0)
  nums filter (x => (x % 2 == 0))
  nums filterNot(x => (x % 2 == 0))
  nums partition (x => (x % 2 == 0))

  nums takeWhile (x => x > 0)
  nums dropWhile(x => x > 0)
  val tet = nums span (x => x > 0)

  val data = List("a","a","a","b","c","c","a")
def pack[T] (xs:List[T]):List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (first, rest) = xs span (y => y == x)
    first::pack(rest)
}
  pack[String](data)

  def encode[T] (xs:List[T]):List[(T,Int)] =   {
    pack(xs) map (ys => (ys.head, ys.length))
  }

}