package com.babs.sparkproject

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}


object SimpleCountApp extends App {
  val spark: SparkSession = SparkSession.builder()
    .master("local[*]")
    .appName("simple-count-app")
    .getOrCreate()

  val dataSet: Dataset[String] = spark.read.textFile("textfile.csv")
  val filteredDataSet: Dataset[String] = dataSet.filter(x => x.contains("a"))
  val splitDataSet: Dataset[String] = filteredDataSet.flatMap(_.split(" "))

  val df: DataFrame = dataSet.toDF() //Converts to DataFrame
  val colList: Array[String] = df.columns
  val selectData: DataFrame = df.select("col1", "col2")
                                .withColumnRenamed("someCol1", "someCol2")



  val sc: SparkContext = spark.sparkContext
  val rdd = sc.textFile("textfile.csv")


//  val data: Array[Int] = Array(1, 2, 3, 4, 5, 6, 6, 7, 7)
//  val dataRdd: RDD[Int] = sc.parallelize(data)

  val counts = WordCount.withStopWordsFiltered(rdd)
  counts.foreach(println)


  sc.stop()
  spark.stop()
}