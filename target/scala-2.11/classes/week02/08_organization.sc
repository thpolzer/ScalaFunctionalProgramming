val mytest = new Testclass(1)
mytest.test(2)


class Testclass (x:Int){
  def myval:Int = x
  def test (x:Int):String = if (x == 1)"Thomas" else "Polzer"
}

