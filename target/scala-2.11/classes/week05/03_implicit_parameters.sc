object session{

  def msort[T] (xs: List[T])(lessThan:(T,T)=> Boolean): List[T] = {
    val n = xs.length/2
    if (n==0) xs
    else {
      def merge(xs: List[T], ys: List[T] ): List[T] = {
        xs match {
          case Nil =>
            ys
          case x::xs1 =>
            ys match {
              case Nil =>
                xs
              case y::ys1 =>
                if (lessThan(x,y)) x::merge(xs1,ys)
                else y :: merge(xs, ys1)
            }
        }
      }

      val (fst,snd) = xs splitAt n
      merge (msort(fst)(lessThan),msort(snd)(lessThan))
    }
  }


  msort(List(3,-1,6,2))((x:Int, y:Int)=> if (x < y)true else false)
  msort(List("thomas","annika","axel"))((x:String, y:String)=> x.compareTo(y)<0)

}