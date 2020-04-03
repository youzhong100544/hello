package com.hello.test.spark.scala.sql

import org.apache.spark.sql.{DataFrame, SparkSession}

object TestMySQL {

	def main(args: Array[String]): Unit = {
		val spark = new SparkSession.Builder()
			.master("local")
			.appName("source_data_mysql001")
			.getOrCreate()

		val jdbc_conf: Map[String, String] = Map(
			"url" -> "jdbc:mysql://192.168.15.70:23306/dmp?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true",   //设置mysql的链接地址和指定数据库
			// "driver" -> "com.mysql.jdbc.Driver",    //设置MySQL的链接驱动
			"driver" -> "com.mysql.cj.jdbc.Driver",    //设置MySQL的链接驱动
			"dbtable" -> "action_word",      //获取数据所在表的名成
			"user" -> "dmp",        //连接mysql的用户
			"password" -> "123456"   //连接用户的密码
		)
		val data_mysql: DataFrame = spark.read.format("jdbc")   //设置读取方式
			.options(jdbc_conf)    //放入jdbc的配置信息
			.load()

		data_mysql.show()   //使用一个action算子来检查是否能读取数据
	}


}
