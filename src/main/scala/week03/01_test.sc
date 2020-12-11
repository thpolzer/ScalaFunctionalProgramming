abstract class Base {
  def foo = 1
  def bar:Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}

val mytest = new Sub
mytest bar