object session {
  // sum of the integers between a and b
  def sumInts(a:Int,b:Int):Int = {
    if (a > b)0 else a + sumInts(a+1,b)
  }

  // sum of the cubes
  def cube(x:Int):Int = x*x*x

  def sumCubes(a:Int,b:Int):Int = {
    if (a < b) 0 else cube(a)+ sumCubes(a+1,b)
  }


  // Generalization
  def sum(f:Int => Int,a:Int,b:Int):Int = {
    if (a>b)0 else f(a)+sum(f,a+1,b)
  }

  def id(x:Int) = x

  sum (id, 3,5)

}