object session {

  def insert (x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y)x :: xs else y::insert (x,ys)
  }

  def isort(xs:List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert (y, isort(ys))
  }

  //isort (List(-1, 9,2))


  var sampleList = List(2,4,8,9,3)
  sampleList.splitAt(sampleList.length/2)

}