object paits{

  def isPrime(n:Int) = (2 until n) forall (n % _ != 0)

  val n = 7
  (1 until 7)map (i =>
    (1 until i)map (j => (i,j)))

  (1 until n) flatMap (i =>
    (1 until i) map (j => (i,j)))

  isPrime(11)

  (1 until n) flatMap (i =>
    (1 until i) map (j => (i,j))) filter (pair =>
    isPrime(pair._1 + pair._2))

  class person (name:String, age:Int){
    val persons = List(new person("Thomas",50),new person("Lina",49),new person("Lemmy",2))

  }

  val fruit = Set("apple","banana","pear")
  val fruit1 = Set("apple","banana","apple")


}