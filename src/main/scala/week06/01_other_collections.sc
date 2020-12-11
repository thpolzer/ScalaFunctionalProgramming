object session {

  val xs = Array(1,2,3,44)
  xs map (x => x%2)
  xs(3)

  val s = "Hello World"
  s filter (c => c.isLower)
  s filter (c => c.isUpper)

  val r:Range = 1 until 5
  val t:Range = 1 to 5
  1 to 10
  1 to 10 by 3
  6 to 1 by -2

 s exists (c => c.isUpper)
  s forall (c => c.isUpper)

  val pairs = List(1,2,3) zip s
  pairs.unzip

  s flatMap (c => List('.',c))

  xs.sum
  xs.max


}