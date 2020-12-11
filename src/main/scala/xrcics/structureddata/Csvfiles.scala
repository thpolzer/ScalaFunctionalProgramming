package xrcics.structureddata
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by tpolzer on 28.01.2020.
  */
class Csvfiles (sparkcontext: SparkContext){

val sc:SparkContext = sparkcontext
  val path = "/home/ubuntu/IdeaProjects/ScalaFunctionalProgramming/src/main/scala/xrcics/testdata/income.csv"
  val incomeRDD = sc.textFile(path)

  // remove the header
  val incomeRDDnoHeader = incomeRDD.filter(row => !(row.split(",")(0).equals("NAME")))
  val incomeRDDnoHeader1 =incomeRDDnoHeader.collect() // to see the result in the debugger (within the "this" object)

  // test RDD (just checking the first 3 rows)
  val testRDD = incomeRDD.take(3)

  // create pairRDD (Bundesland, Einkommen), do some filtering on this pairRDD and convert Value into Double
  val pairRDD = incomeRDDnoHeader map (row => (row.split(",")(4), row.split(",")(6))) map(x => (x._1,x._2.toDouble))
  val removeHH_RDD = pairRDD.filter(x => !x._1.equals("HH")).map(x => (x._1,x._2.toDouble))
  val removeHH_RDD_debug = removeHH_RDD.collect()


  // reduction
  val sumPerState = pairRDD.reduceByKey(_+_).collect()
  val averagePerState = pairRDD.reduceByKey((v1,v2) => (v1+v2)/2).collect()
  val maxPerState = pairRDD.reduceByKey((v1,v2) => if (v2 > v1)v2 else v1).collect()

  // group by: ATTENTION: This requires extensive shuffling all across the network leading to slow performance!!!
  val revenuesPerState = pairRDD.groupByKey().collect()

  // slow version of count (using group by)
  val countPerState_groupBy = pairRDD.groupByKey().map(x => (x._1,x._2.size)).collect()

  // quick version of count (avoiding group by, using reduceByKey instead) => according to tests this strategy is 3 x faster
  val countPerState_reduceBy = pairRDD.map(x => (x._1, (1,x._2))).collect()

    //reduceByKey((v1,v2) => (v1._1+v2._1, 0)).map(x => (x._1,x._2._1)).collect()



  sc.stop()

}
