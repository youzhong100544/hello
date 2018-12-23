package com.hello.scala


/**
  * 方法(method)与函数(function)
  * Scala 有方法与函数，二者在语义上的区别很小。Scala 方法是类的一部分，而函数是一个对象可以赋值给一个变量。换句话来说在类中定义的函数即是方法。
  *
  * Scala 中的方法跟 Java 的类似，方法是组成类的一部分。
  *
  * Scala 中的函数则是一个完整的对象，Scala 中的函数其实就是继承了 Trait 的类的对象。
  *
  * Scala 中使用 val 语句可以定义函数，def 语句定义方法。
  *
  */

object DemoMethodAndFunction {

}

class DemoMethodAndFunction {

  /**
    * 方法
    */

  def demo_method_1(): Unit = {
    println(1)
  }
  def demo_method_1_1(){
    println(1)
  }
  def demo_method_1_2() = println(1)

  def demo_method_1_3 = {
    println(1)
  }

  def demo_method_1_4 = println(1)



  def demo_method_2(x: Int, y: Int) : Int = {
    return x + y
  }

  def demo_method_2_1(x: Int, y: Int) : Int = {
    x + y
  }

  def demo_method_2_2(x: Int, y: Int) : Int = {x + y}

  def demo_method_2_3(x: Int, y: Int) : Int = x + y

  def demo_method_2_4(x: Int, y: Int) = x + y


  /**
    * 函数
    *   Scala的函数是基于Function家族，0-22，一共23个Function Trait可以被使用，数字代表了Funtcion的入参个数
    *
    *
    *   函数必须有参数列表，否则报错
    *     var f1 =  => 100
    *      <console>:1: error: illegal start of simple expression
    *     var f1 =  => 100
    *            ^
    */


  val demo_function_0 = () => {println(0)}

  val demo_function_1 = (x: Int, y: Int) => {println(x + y)}

  val demo_function_2 = (x: Int, y: Int) => println(x + y)


  val demo_function_3 = (x: Int, y: Int) => {x + y}

  val demo_function_4 = (x: Int, y: Int) => x + y
}


/**
  * 方法
  */
class DemoMethod {

}

/**
  * 函数
  *
  *   Scala的函数是基于Function家族，0-22，一共23个Function Trait可以被使用，数字代表了Funtcion的入参个数
  *
  *   下面这四个函数的意义是一样的
  */
class DemoFunction {
  val fun_1 = new Function2[Int,Int,Int]() {
    override def apply(v1: Int, v2: Int): Int = {
      v1+v2
    }
  }

  val fun_2 = new ((Int, Int) => Int)() {
    override def apply(v1: Int, v2: Int): Int = {
      v1+v2
    }
  }

  val fun_3 = (v1:Int,v2:Int) => v1+v2

  // _可以把method转换成function
  val fun_4 = fun4Method _
  def fun4Method(v1:Int,v2:Int): Int = {
    v1+v2
  }

}