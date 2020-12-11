package xrcics.structureddata
import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, RangePartitioner, SparkConf, SparkContext}

/**
  * Created by tpolzer on 30.01.2020.
  */
class Partitionusecases (sparkcontext: SparkContext){

  val sc:SparkContext = sparkcontext
  val path1 = "C:\\Users\\tpolzer\\OneDrive - DXC Production\\Documents\\Scala\\Testdaten\\csvdata\\02_income.csv"
  val path2 = "C:\\Users\\tpolzer\\OneDrive - DXC Production\\Documents\\Scala\\Testdaten\\csvdata\\03_income2.csv"
  val path3 = "C:\\Users\\tpolzer\\OneDrive - DXC Production\\Documents\\Scala\\Testdaten\\csvdata\\04_state_population.csv"

  val incomeRDD1 = sc.textFile(path1)
  val incomeRDD2 = sc.textFile(path2)
  val statePopulationRDD = sc.textFile(path3)

  // Partitioning can be applied for pairRDDs only; 6 cores have been assigned to Spark, so we have a maximum of 6 partitions
  val pairRDD1 = incomeRDD1.filter(x => !x.split(";")(0).equals("NAME")).map (x => (x.split(";")(4),x.split(";")(6))).map(x => (x._1,x._2.toDouble))
  val pairRDD2 = incomeRDD2.filter(x => !x.split(";")(0).equals("NAME")).map (x => (x.split(";")(4),x.split(";")(6))).map(x => (x._1,x._2.toDouble))

  /////// Partitioners ///////
  // 1. HashPartitioning (by default used for group by and whenever the parent RDD has been constructed with a HashPartitioner
  val tunePartitioner_hash = new HashPartitioner(6)
  // 2. RangePartitioning (by default used for sortBy)
  val tunePartitioner1 = new RangePartitioner (6,pairRDD1)
  val tunePartitioner2 = new RangePartitioner (6,pairRDD2)
  // we need to persist the partitioned RDD otherwise the partitioning needs to be reorganized each time the pairRDD get invoked;
  val pairRDD1_HashPartitioned = pairRDD1.partitionBy(tunePartitioner_hash).persist()
  val pairRDD2_HashPartitioned = pairRDD2.partitionBy(tunePartitioner_hash).persist()
  val pairRDD1_RangePartitioned = pairRDD1.partitionBy(tunePartitioner1).persist()
  val pairRDD2_RangePartitioned = pairRDD2.partitionBy(tunePartitioner2).persist()

  // check the data for debug purposes
  val test1 = pairRDD1_RangePartitioned.collect()
  val test2 = pairRDD2_RangePartitioned.collect()

  sc.stop()

}
