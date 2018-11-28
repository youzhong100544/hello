package com.hello.scala

object HelloScala {
  /* 这是一个 Scala 程序
    * 这是一行注释
    * 这里演示了多行注释
    */
  def main(args: Array[String]): Unit = {

    // 输出 Hello World
    // 这是一个单行注释
    println("hello scala")

    /*换行符

    Scala是面向行的语言，语句可以用分号（;）结束或换行符。
    Scala 程序里,语句末尾的分号通常是可选的。如果你愿意可以输入一个,但若一行里仅 有一个语句也可不写。
    另一方面,如果一行里写多个语句那么分号是需要的。
    */
    val s = "hello"; println(s)

    val helloScala = new HelloScala
    val result = helloScala.add(1, 10)

    println(result)



    println(max(1,10))

    println(min(1)(10))

  }


  def max(a: Int, b: Int ): Int = {
    if(a > b)
      a
    else
      b
  }

  def min(a: Int)(b: Int): Int = {
    if(a > b)
      b
    else
      a
  }


}
class HelloScala {

  def add(a: Int, b: Int ): Int = {
    var sum: Int = 0
    sum = a + b

    return sum
  }



}
