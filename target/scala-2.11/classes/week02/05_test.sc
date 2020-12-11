

class mytest (x:Int,y:Int){
  def numer = x
  def denom = y

  override def toString: String = numer +"/"+denom
}

val instance = new mytest(3,4)

instance.numer
instance.denom