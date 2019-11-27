package com.hello.scala.demo.collection

import scala.collection.mutable.ListBuffer

object DemoList {

	def main(args: Array[String]): Unit = {

		immutableList()

		// mutableListBuffer()

	}

	/** ============================================================================================ */

	/**
		* 不可变的 list
		*/
	def immutableList(): Unit ={

		val fruit: List[String] = scala.collection.immutable.List("Apple", "Banana", "Orange")

		println(s"fruit: ${fruit}")

	}



	/** ============================================================================================ */
	/**
		* 可变的 list
		*/
	def mutableListBuffer(): Unit ={

		// mutableListBufferAppend()

		mutableListBuffer1()

	}

	def mutableListBufferAppend(): Unit ={
		val list: ListBuffer[String] = new scala.collection.mutable.ListBuffer[String]

		list.append("1")
		println(list)

		list.append("2")
		list.append("3")
		println(list)

	}


	def mutableListBuffer1(): Unit ={

		val list = new ListBuffer[String]

		list += ("11")
		println(list)

		list += "22"
		list += "33"
		println(list)

	}

	/** ============================================================================================ */

	/**
		* 可变 list 转换成 不可变 list
		*/
	def mutableListBufferConversionImmutableList(): Unit ={

		val list: ListBuffer[String] = new ListBuffer[String]

		list.append("1")
		println(list)

		list.append("2")
		list.append("3")
		println(list)


		val immutableList: List[String] = list.toList

		println(immutableList)

	}


}
