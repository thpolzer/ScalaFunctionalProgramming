object session{

  def msort (xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if (n==0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] = {
        xs match {
          case Nil =>
            ys
          case x::xs1 =>
            ys match {
              case Nil =>
                xs
              case y::ys1 =>
                if (x < y) x::merge(xs1,ys)
                else y :: merge(xs, ys1)
            }
        }
      }

        val (fst,snd) = xs splitAt n
        merge (msort(fst),msort(snd))
    }
  }
  
  msort(List(3,-1,9,2))

}