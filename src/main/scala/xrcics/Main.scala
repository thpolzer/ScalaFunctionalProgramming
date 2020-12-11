package xrcics
import sparkdetails.Sparksettings
import sparksql.{Csvfile, Datasets, InternalRDDs}
import xrcics.texthandling.Coronavirus
import xrcics.structureddata.{Csvfiles, Partitionusecases}

/**
  * Created by tpolzer on 28.01.2020.
  */
object Main extends App{

  override def main(args: Array[String]): Unit = {

    val sparksession = new Sparksettings
    val sc = sparksession.sparkconfig._2
    val sparksql = sparksession.sparkconfig._3
    //new Coronavirus(sc)
    new Csvfiles(sc)
    //new Partitionusecases(sc)
    //new Csvfile (sc,sparksql)
    // new InternalRDDs(sc,sparksql)
    //new Datasets(sc,sparksql)


  }

}
