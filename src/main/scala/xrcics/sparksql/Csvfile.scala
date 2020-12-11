package xrcics.sparksql

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SQLContext, SparkSession}
import org.apache.spark.sql.types.{StructField, _}
import org.apache.spark.sql.functions._


/**
  * Created by tpolzer on 03.02.2020.
  */
class Csvfile (sparkcontext: SparkContext, sparksqlsession: SparkSession){

  val sc:SparkContext = sparkcontext
  val sqlsession:SparkSession = sparksqlsession
  val path = "C:\\Users\\tpolzer\\OneDrive - DXC Production\\Documents\\Scala\\Testdaten\\csvdata\\02_income.csv"
  val incomeRDD = sc.textFile(path)

  //////// 1. create a dataframe from an existing RDD ////////
  // 1.1. create the schema
/*  val schemaString = "NAME;VORNAME;GESCHLECHT;WOHNORT;BUNDESLAND;ALTER;EINKOMMEN" // schema is encoded in a string
  val fields = schemaString.split(";").map(fieldName => StructField(fieldName, StringType,nullable = true))
  val schema = StructType(fields)

  val incomeRDDnoHeader = incomeRDD.filter(row => !(row.split(";")(0).equals("NAME")))
  val rowRDD = incomeRDDnoHeader.map(_.split(";"))
    .map(attributes => Row (attributes(0),attributes(1),attributes(2),attributes(3),attributes(4),attributes(5),attributes(6)))

  val incomeDF_schema = sparksqlsession.createDataFrame(rowRDD,schema)
  incomeDF_schema.show()*/


  import sparksqlsession.implicits._
  //val incomeDF = incomeRDD.toDF()
  //incomeDF.show()

  ///////// 2. create a dataframe straight from the csv file /////////
  // 2.1. file load (convert semicolon into comma if necessary)
 val incomeDF_csv =  sparksqlsession.read.format("csv").option("header","true").option("delimiter",",").load(path)
  // 2.2 Register the DatFrame as an SQL temporary view
  incomeDF_csv.createOrReplaceTempView("income")
  incomeDF_csv.show()
  incomeDF_csv.printSchema()
  // problem: age apperas as String!
  // solution: manually create a schema
  val schema_csv = StructType(List(StructField("name",StringType, true),StructField("vorname",StringType, true),
    StructField("geschlecht",StringType, true), StructField("wohnort",StringType, true),StructField("bundesland",StringType, true),
    StructField("alter",IntegerType, true),StructField("einkommen",DoubleType, true)))

  val incomeDF_csv_withSchema = sparksqlsession.read.format("csv")
    .option("header","true")
    .option("delimiter",",")
      .schema(schema_csv)
    .load(path)
  incomeDF_csv_withSchema.printSchema()


  // 2.3. Fire your queries
  val noBavaria = sparksqlsession.sql("SELECT * from income where bundesland <> \"BY\"")
  //noBavaria.show()

 // val topIncome = sparksqlsession.sql("SELECT einkommen,name FROM income WHERE einkommen IN (SELECT MAX(einkommen) FROM income").show()

  // 2.4. Queries with DataFrame API
  val highIncomeNames = incomeDF_csv_withSchema.select("vorname","name","wohnort","einkommen")
                            .where("einkommen > 60000")
                            .orderBy(("einkommen"))
                              .show()

  val a = 10

}
