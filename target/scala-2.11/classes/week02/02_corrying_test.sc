object session {

  def mapReduce(f:Int => Int, combine:(Int,Int) => Int, zero:Int)(a:Int,b:Int) : Int = {
    if (a > b) zero else combine (f(a), mapReduce(f,combine,zero)(a+1,b))
  }

  def product(f:Int => Int)(a:Int,b:Int):Int = {
    if (a > b)1 else f(a) * product (f)(a+1,b)
  }

  def factorial(n:Int) = product ((x:Int) => x)(1,n)
  factorial(5)


  def test1(f: Int => String)(a:Int): String = {
    f(a)+" "+a
  }

  def innertest1 (a:Int) = if (a==0)"Gude" else "Hello"

  test1(innertest1)(1)
  test1((a:Int) => if (a==0)"Gude" else "Hello")(0)


}