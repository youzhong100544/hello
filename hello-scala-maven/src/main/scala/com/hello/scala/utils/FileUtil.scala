package com.hello.scala.utils

import scala.io.Source

object FileUtil {
	def main(args: Array[String]): Unit = {
		val lines: Iterator[String] = Source.fromFile("test.txt").getLines()
		println(lines)
	}
}
