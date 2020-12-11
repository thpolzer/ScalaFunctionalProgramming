val x = new Rational(1,3)
x.numer
x.denom
x.neg
val y = new Rational(5,7)
x+y.toString
(x-y).toString
val z = new Rational(3,2)
x - y - z
y + y
x < y
x max y
new Rational(2)
val strange = new Rational(1,0)
strange + strange
//val strange2 = new Rational(5,6)
//strange2.add(strange)


//////////////////////////////////////////////////////////


class Rational (x: Int, y:Int){
  require(y != 0 || x == 0, "denominator must be nonzero and numerator other than zero")

  // additional constructor
  def this(x:Int)= this(x,1)

  private def gcd (a:Int,b:Int):Int = if (b == 0)a else gcd(b, a % b)
  private val g = gcd(x,y)
  def numer = x/g
  def denom = y/g

  // if the functions numer and denom are called very often:
  // val numer = x / gcd(x,y)
  // val denom = y/g

  def < (that:Rational):Boolean = this.numer * that.denom < that.numer * this.denom

  def max (that:Rational):Rational = if (this.<(that))that else this

  def + (that: Rational)= new Rational(
    this.numer * that.denom + that.numer * this.denom,
    this.denom * that.denom
  )

  def neg : Rational = new Rational (- numer,denom)

  def - (that: Rational)= this +(that.neg)

  override def toString: String = numer +"/"+denom

}










