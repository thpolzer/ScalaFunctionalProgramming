import java.lang

object session {
  def printtest0 :String =
  "Hello World"

  printtest0

  ////////////////////////////////

  def printtest1 (a: String): String =
    if (a == "Thomas")"Polzer" else "Anton"

  printtest1("Thomas")

  ////////////////////////////////

  def printtest (a: Int)(f:Int => Int) = {
    if (f(a)>0)"Thomas" else "Polzer"
  }

  printtest(2)(x => x+2)
  printtest(2)(x => x-2)

  ////////////////////////////////

  def max (a: List[Int],b:Int): Int =
    if (a.isEmpty)b
    else if (a.head < b) max(a.tail,b)
    else max(a.tail,a.head)

  max (List(4,2,6,3),List(4,2,6,3).head)

/*  def max[T](a:List[T], b:T): T =
    if (a.isEmpty)b
    else if (a.head < b) max(a.tail,b)
    else max(a.tail,a.head)*/

  ////////////////////////////////

  def concattest (f:String => String)(word: String): String = {

    if (word.length == 0)"".toString else f(word(0).toString) + concattest(f)(word.substring(1))
  }


  concattest (x=> x.toUpperCase)("thomas")
  concattest (x=> x.toLowerCase)("POLZER")

  var a: java.lang.String = "test";
  String.valueOf((a.charAt(0)+3).toChar)

}
