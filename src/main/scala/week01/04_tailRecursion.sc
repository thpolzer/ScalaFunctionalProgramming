object session {

  def factorial(n: Integer): Integer = {
    def loop(acc: Int, n: Int): Integer =
      if (n == 0) acc
      else loop(acc * n, n - 1)

    loop (1,n)

  }

  factorial (5)


  def fact (n:Int):Int = if (n==0)1 else n * fact(n-1)

  fact (3)

}