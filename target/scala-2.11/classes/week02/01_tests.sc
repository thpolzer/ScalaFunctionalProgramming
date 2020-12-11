object test {

 def sumBetweenInts(a:Int, b: Int): Int ={

    if (a > b)0 else a + sumBetweenInts(a+1,b)

  }

  sumBetweenInts(4,6)

  def sumCubesInts (a:Int,b:Int):Int = {

  //  if (a > b)0 else a*a*a + sumCubesInts(a+1,b)
    if (a > b)0 else calculateCube(a) + sumCubesInts(a+1,b)

  }

  sumCubesInts(2,3)


  def calculateCube(a:Int):Int = a * a * a


  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop (a: Int, acc: Int): Int = {
      if (a > b)acc
      else loop(a+1, f(a) + acc)
    }

    loop (a,0)
  }

  sum(x => x * x) (4,5)


  def product (f: Int => Int)(a: Int, b: Int): Int ={
    if (a > b)1 else f(a) * product(f)(a+1,b)
  }

  product (x => x * x) (3,4)


  def product_fact (f: Int => Int)(a: Int, b: Int): Int ={
    if (a == b)1 else f(a) * product_fact(f)(a-1,b)
  }

  product_fact(x => x)(5,0)


  def product_sum (f: Int => Int)(termination: String => Boolean)(a: Int, b: Int, prod: String, sum: String): Int ={
    if (termination(prod))1 else if (termination(sum))1 else f(a) * product_fact(f)(a-1,b)
  }


}