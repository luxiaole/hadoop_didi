package com.didi365.hive

/**
  * Created by wuyufei on 05/09/2017.
  */


import java.io.File

import org.apache.spark.sql.SparkSession

case class Record(key: Int, name: String,age :Int)

object HiveOperation {

  def main(args: Array[String]) {

    val warehouseLocation = new File("/spark-warehouse").getAbsolutePath

    val spark = SparkSession
      .builder()
      .appName("Spark Hive Example")
      .config("spark.sql.warehouse.dir", warehouseLocation)
      .enableHiveSupport()
      .getOrCreate()

    //import spark.implicits._

    spark.sql("CREATE TABLE IF NOT EXISTS aaaaa (key INT, value STRING)")
    spark.sql("LOAD DATA LOCAL INPATH 'hdfs://master:8022/person.txt' INTO TABLE src")

    // Queries are expressed in HiveQL
    val df = spark.sql("SELECT * FROM aaaaa")
    df.show()

    df.write.format("json").save("hdfs://master:8022/person.json")

    spark.stop()
  }


}



