package xrcics.sparksql

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

/**
  * Created by tpolzer on 03.02.2020.
  */
class InternalRDDs (sparkcontext: SparkContext, sparksqlsession: SparkSession){

  val sc:SparkContext = sparkcontext
  val spark:SparkSession = sparksqlsession

  val employee1 = Employee(1,"Thomas","Polzer",50,"Hanau")
  val employee2 = Employee(2,"Johannes","Kuhnert",27,"Hannover")
  val employee3 = Employee(3,"Annika","Menk",25,"Krefeld")
  val employee4 = Employee(4,"Axel","Ludwig",29,"Mainz")
  val employee5 = Employee(5,"Stefanie","Häckel",42,"Tübingen")
  val employee6 = Employee(6,"Wulf","Maier",45,"Böblingen")
  val employee7 = Employee(7,"Stefan","Oetzel",52,"Würzburg")
  val employee8 = Employee(8,"Klaus","Jockheck",53,"Dülmen")
  val employee9 = Employee(9,"Kühl","Veronika",38,"Essen")
  val employee10 = Employee(10,"Waitl","Christine",36,"Landshut")
  val employees = List[Employee](employee1,employee2,employee3,employee4,employee5,employee6,employee7,employee8,employee9,employee10)

  // internal RDD
  val employeeRDD = sc.parallelize(employees)

  // create DataFrame from RDD, schema reflectively inferred
  import spark.implicits._
  val employeeDF = employeeRDD.toDF()
  employeeDF.show()

  // Register the DataFrame as a SQL temporary view
  employeeDF.createOrReplaceTempView("employees")

  // Run queries
  val youngGuns = spark.sql("select fname, age from employees where age < 30 order by age")
  val oldMan = spark.sql("select max(age) as highest_age from employees")
  youngGuns.show()
  oldMan.show()

}
