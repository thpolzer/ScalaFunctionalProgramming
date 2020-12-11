import week03.List
import week03.Cons
import week03.Nil

object nth {

  def nth[T](n: Int, list: List[T]): T ={
    if (list.isEmpty)throw new IndexOutOfBoundsException
    if (n == 0) list.head
    else nth(n-1, list.tail)
  }

  val list1 = new Cons(1, new Cons(2, new Cons(3, new Nil)))
  println(nth (6, list1))


}