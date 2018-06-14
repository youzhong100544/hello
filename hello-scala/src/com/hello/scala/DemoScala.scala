package com.hello.scala

object DemoScala {
  def main(args: Array[String]): Unit = {

    val testScala = new TestScala()

    val add = testScala.addInt(1, 2)
    println("1 + 2 = " + add)

    val ids = 1 to 10
    println("ids " + ids)
    println("type-ids " + ids.asInstanceOf[AnyRef].getClass.getSimpleName)
    println("type-ids " + ids.asInstanceOf[AnyRef].getClass.getName)
    // scala.collection.immutable.Range.Inclusive

    val i = 1
    println("i " + i)
    println("i " + i.asInstanceOf[AnyRef].getClass.getSimpleName)
    println("i " + i.asInstanceOf[AnyRef].getClass.getName)

    val is = i.toString
    println("is " + is)
    println("is " + is.asInstanceOf[AnyRef].getClass.getSimpleName)
    println("is " + is.asInstanceOf[AnyRef].getClass.getName)


    var is_var = i.toString
    println("is_var " + is_var)
    println("is_var " + is_var.asInstanceOf[AnyRef].getClass.getSimpleName)



  }

}
