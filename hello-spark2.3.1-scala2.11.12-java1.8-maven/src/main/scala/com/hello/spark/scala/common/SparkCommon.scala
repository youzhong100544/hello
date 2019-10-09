package com.hello.spark.scala.common

object SparkCommon {

  def round(dataFrame: DataFrame, columnName: String): DataFrame = round(dataFrame, columnName, 2)

  def round(dataFrame: DataFrame, columnName: String, digit: Int): DataFrame = {
    round(dataFrame, Array(columnName), digit)
  }

  def round(dataFrame: DataFrame, columnNames: Array[String]): DataFrame = round(dataFrame, columnNames, 2)

  def round(dataFrame: DataFrame, columnNames: Array[String], digit: Int): DataFrame = {

    val columns: Array[String] = dataFrame.columns

    for(columnName <- columnNames){
      //var bool: Boolean = columns.contains(columnName)
      if (!columns.contains(columnName)){
        throw new Exception(s"没有${columnName}列信息")
      }

    }

    val sqlArray: Array[String] = new Array[String](columns.size)

    for (i <- 0 until columns.length) {

      val columnName: String = columns(i)
      var sql: String = ""
      if (columnNames.contains(columnName)){
        sql = s"round(`${columnName}`, ${digit}) as `${columnName}`"
      } else {
        sql = s"`${columnName}`"
      }

      sqlArray(i) = sql

    }

    val frame: DataFrame = dataFrame.selectExpr(sqlArray: _*)

    frame

  }

}

class SparkCommon {




}