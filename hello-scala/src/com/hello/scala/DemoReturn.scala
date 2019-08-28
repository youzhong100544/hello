package com.hello.scala

object DemoReturn {
	def main(args: Array[String]): Unit = {
		var a = 1
		var b = 2

		if (add(a, b) > 10){
			println(1)
			println(2)
			println(3)
		}else{
			println(4)
			return
			println(5)
			println(6)
		}

		a = 10
		b = 2

		if (subtract(a, b) > 10){
			println(11)
			println(21)
			println(31)
		}else{
			println(41)
			println(51)
			println(61)
		}

	}

	// add, subtract, multiply and divide
	def add(a: Int, b: Int): Int = {
		a + b
	}

	def subtract(a: Int, b: Int): Int = {
		a - b
	}

	def multiply(a: Int, b: Int): Int = {
		a * b
	}

	def divide(a: Int, b: Int): Int = {
		a / b
	}

}
