package com.hello.scala

object DemoMap {

  def main(args: Array[String]): Unit = {
    val colors = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")

    val nums: Map[Int, Int] = Map()

    println( "colors 中的键为 : " + colors.keys )
    println( "colors 中的值为 : " + colors.values )
    println( "检测 colors 是否为空 : " + colors.isEmpty )
    println( "检测 nums 是否为空 : " + nums.isEmpty )


    colors.keys.foreach{ i =>
      print( "Key = " + i )
      println(" Value = " + colors(i) )}
  }

}
