package com.hello.scala.demo.array

object DemoTest {

}
object DemoArray {

	def main(args: Array[String]): Unit = {

		val z: Array[String] = new Array[String](3)

		z(0) = "Runoob"; z(1) = "Baidu"; z(4/2) = "Google"

		// 打印
		println(z) //[Ljava.lang.String;@ea4a92b

		// 循环遍历打印1
		z.foreach(println)

		// 循环遍历打印2
		for (elem <- z) {
			print(elem + ",")
		}
		println()
		println()
		for ( i <- 0 to (z.length - 1)) {
			if (i != z.length- 1){
				print(z(i) + ',')
			}else{
				print(z(i))
			}
		}
		println()
		println()
		// 创建数组 ---------------------------------------------------

		// 创建数组
		var a = Array("Runoob", "Baidu", "Google")

		// 多维数组----------------------------------------------------------
		println("多维数组")
		import Array._
		var multidimensionalArray = ofDim[Int](2,3)

		// 创建矩阵
		for (i <- 0 to 1) {
			for ( j <- 0 to 2) {
				multidimensionalArray(i)(j) = j;
			}
		}
		// 打印二维阵列
		println("打印二维阵列");
		for (i <- 0 to 1) {
			for ( j <- 0 to 2) {
				print(" " + multidimensionalArray(i)(j));
			}
			println();
		}
		println();
		println();
		// 打印二维阵列
		for (i <- 0 to 1 ; j <- 0 to 2) {
			multidimensionalArray(i)(j) = j;
		}
		// 打印二维阵列
		for (i <- 0 to 1 ; j <- 0 to 2) {
			print(" " + multidimensionalArray(i)(j));
			println();
		}
		println();
		println();



	}

}