object session {

  // polymorphism
  def test[T](a:List[T]):T =  {
    a.head
  }

  test(List(1.2,3,2,1.9))

}