package com.didi365.sparksql

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object App {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("test").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)
    sqlContext.table("ai.wy_acc") // 库名.表名 的格式
      .registerTempTable("wy_acc")  // 注册成临时表
    sqlContext.sql(
      """
        | select *
        |   from wy_acc
        |  limit 10
      """.stripMargin).show()
    sc.stop()
  }
}
