object session {

  val x = 5.0
  val estimate = 1.0

  def abs(a:Double):Double =
    if (a > 0) a else -a

  def isGoodEnough(estimate:Double):Boolean =
    if (abs(x - (estimate*estimate)) < 0.001)true else false

  def improveEstimate (estimate:Double):Double =
     (estimate + (x/estimate))/2

  def sqrtIteration(estimate:Double):Double = {
    if (isGoodEnough(estimate))estimate else
      sqrtIteration(improveEstimate(estimate))
  }

  def sqrt():Double = sqrtIteration(estimate)

  sqrt()

}