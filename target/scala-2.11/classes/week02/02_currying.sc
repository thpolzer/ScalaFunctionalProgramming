object session {

  def sum(f:Int => Int):(Int,Int)=> Int = {
    def sumF(a:Int, b:Int):Int = {
      if (a > b)0 else f(a) + sumF(a+1,b)
    }
    sumF
  }

  // Äquivalente Schreibweise zu obiger Funktion
  def sum1(f:Int => Int)(a: Int, b: Int): Int = {
      if (a > b)0 else f(a) + sum1(f)(a+1,b)

  }
  sum1(cube)(2,11)

  def sumInt = sum(x => x)
  sumInt(2,9)

  def sumCubes = sum (x => x * x * x)
  sumCubes(2,4)

  def sumFact = sum (fact)
  sumFact(2,3)

  def fact (n:Int):Int = {
    if (n == 0)1 else n * fact(n-1)
  }

  def id(x:Int):Int = x

  def cube(x:Int):Int = x * x * x

  // the function call of sum can also be written as per below
  sum(cube)(1,10)
  sum (fact) (2,4)
  sum (id)(1,18)


  // exercise 1
  def product1 (f:Int => Int):(Int,Int) => Int = {
    def productF  (a:Int,b:Int):Int = {
      if (a > b)1 else f(a) * productF(a+1,b)
    }
    productF
  }

  def myproduct = product1 (x => x)
myproduct (2,5)


  //////// combination of sum and product //////////////
  def mapReduce(f:Int => Int, combine:(Int,Int) => Int,zero:Int)(a:Int,b:Int):Int = {
    if (a > b)zero else combine(f(a),mapReduce(f,combine,zero)(a+1,b))
  }

  // or
  def product (f: Int => Int)(a:Int,b:Int):Int = {
    if (a > b)1 else f(a) * product(f)(a+1,b)
  }

  product (x=>x)(2,7)

  def fact_new(n:Int) = product(x=>x)(1,n)
  fact_new(5)



}