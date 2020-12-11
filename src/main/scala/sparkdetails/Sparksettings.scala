package sparkdetails
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{SparkSession, SQLContext}


/**
  * Created by tpolzer on 28.01.2020.
  */
class Sparksettings {

  private val sparkConf = new SparkConf().setAppName("Text extraction").setMaster("local[6]")
  private val sc = new SparkContext(sparkConf)
  private val sparksql = SparkSession.builder().appName("App1").getOrCreate()

  def sparkconfig = Tuple3(sparkConf,sc,sparksql)

}
