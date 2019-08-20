package com.hello.scala.utils

import scala.io.Source

object FileUtil {
	def main(args: Array[String]): Unit = {
		//val lines: Iterator[String] = Source.fromFile("test.txt").getLines()
		// 上面的语句会报错 找不到文件


		// main/resources/test.txt
		val lines = Source.fromURL(getClass.getResource("/test.txt")).getLines()
		lines.foreach(println)
		println(lines)
	}
}
