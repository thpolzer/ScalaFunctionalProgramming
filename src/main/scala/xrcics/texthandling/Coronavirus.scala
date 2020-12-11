package xrcics.texthandling
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by tpolzer on 28.01.2020.
  */
class Coronavirus (sparkcontext: SparkContext){

  val sc = sparkcontext

  // creating an RDD
  // This RDD is an Array like data structure with each line representing an element in the array
  val text = sc.textFile("C:\\Users\\tpolzer\\OneDrive - DXC Production\\Documents\\Scala\\Testdaten\\textfiles")

  // number of lines within the entrie text file
  val lines: Long = text.count()

  // Print out the first line
  println(text.first())

  // detect all words within the first line
  val firstlineWords = text.first().split(" ")
  //firstlineWords.foreach(println)

  //// detect all the words of the file
  // 1. collect all words
  // If you have a collection of a collection (here: a list of lists which all contain strings) and want to have a 1-dimensinal list
  // containingd all elements(here: strings) you you can apply the flatMap function. It is the same as (a map b).flatten
  val words = text.flatMap(line => line.split(" "))

  // 2. Put every word in a Tuple2 (= Pair) and assign value 1
  val tuples = words.map(word => (word,1))
  // 3. Reduce the keys
  val result = tuples.reduceByKey(_+_)
  // 4. print out result
  //for ((k,v) <- result) printf("%s : %d\n", k, v)
  for ((k,v) <- result) println(k.toString+": ", v.toString)

  val nestedList = List(List(1,2,3),List(4,5,6))
  val flattenedList = nestedList.flatten
  //
  // dummy value to set a breakpoint
  sc.stop()





}
