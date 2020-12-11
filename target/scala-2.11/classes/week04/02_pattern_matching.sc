package week04

trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr


object exprs {

  def show(e:Expr):String = e match  {
    case Number(x) => x.toString
    case Sum(l,r) => show(l) + "+" + show(r)
  }

  show(Sum(Number(1),Number(44)))

}


object session {

  def insert (x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y)x :: xs else y::insert (x,ys)
  }

  def isort(xs:List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert (y, isort(ys))
  }

  isort (List(-1, 9,2))

}