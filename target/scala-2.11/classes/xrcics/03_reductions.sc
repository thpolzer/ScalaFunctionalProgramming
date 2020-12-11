object session {

  val list1 = List(1,2,3,4,5)

  list1 reduce (_+_)
  list1 reduce ((x,y) => x + (2 *y))
  list1 reduceRight ((x,y) => x + (2 *y))

  val array = Array(1,2,3,4)

  val list2 = (6,7,8,9,10)

  var myzip = list1 zip "qwerty"


list1 map (x => 2 * x) map (x => 10-x) map (x => x%2)




}