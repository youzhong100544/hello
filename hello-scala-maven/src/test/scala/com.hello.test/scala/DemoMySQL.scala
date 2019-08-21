package com.hello.test.scala

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}

object DemoMySQL {
	def main(args: Array[String]): Unit = {
		// val URL = "jdbc:mysql://192.168.15.70:23306/db_test"

		val URL = "jdbc:mysql://192.168.15.70:23306/dmp?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&autoReconnect=true"
		val USERNAME = "dmp"
		val PASSWORD = "123456"

		var connection: Connection = null
		var statement: PreparedStatement = null
		var resultSet: ResultSet = null

		try {
			// 1.加载Driver
			//classOf[com.mysql.jdbc.Driver]
			classOf[com.mysql.cj.jdbc.Driver]
			// 2.建立连接
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)
			// 3.预加载语句
			statement = connection.prepareStatement("SELECT * FROM `action_word` WHERE `id` = ?")
			statement.setInt(1, 1) // 设置值
			// 4.执行
			resultSet = statement.executeQuery()
			// 取值
			while (resultSet.next()){
				val id = resultSet.getInt("id")
				val code = resultSet.getString("code")
				println(s"id: $id, name: $code")
			}
		} catch {
			case e:Exception => e.printStackTrace()
		} finally {
			resultSet.close()
			statement.close()
			connection.close()
		}
	}
}
