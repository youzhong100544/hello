package com.hello.scala

object DemoTrait {

}

class DemoTrait {

}

abstract class Human {
  def sleep() : Unit

  def eat(x: Any) : Any
}

/**
  * Scala Trait(特征) 相当于 Java 的接口，实际上它比接口还功能强大。
  *   Trait(特征) 定义的方式与类类似，但它使用的关键字是 trait
  *
  * 与接口不同的是，它还可以定义属性和方法的实现。
  *
  * 一般情况下Scala的类只能够继承单一父类，但是如果是 Trait(特征) 的话就可以继承多个，从结果来看就是实现了多重继承。
  *
  */
trait Person extends Human{

  /**
    * 与接口不同的是，它还可以定义属性和方法的实现。
    */
  val name : String
  val age : Integer

  def isEqual(x: Any): Boolean
  // 与接口不同的是，它还可以定义属性和方法的实现。
  def isNotEqual(x: Any): Boolean = !isEqual(x)

  def study() : Unit

  def work(x: Any) : Any
}

trait Man extends Person {
  def play(x: Any) : Any
}

trait Woman extends Person {
  def shop(x: Any) :Any
}


class Adult extends Person with Man {

  /**
    * 与接口不同的是，它还可以定义属性和方法的实现。
    */
  override val name: String = "student"
  override val age: Integer = 0

  override def isEqual(x: Any): Boolean = ???

  override def study(): Unit = ???

  override def work(x: Any): Any = ???

  override def sleep(): Unit = ???

  override def eat(x: Any): Any = ???

  override def play(x: Any): Any = ???

}

class Employee extends Person {
  /**
    * 与接口不同的是，它还可以定义属性和方法的实现。
    */
  override val name: String = "employee"
  override val age: Integer = 18

  override def isEqual(x: Any): Boolean = ???

  override def study(): Unit = ???

  override def work(x: Any): Any = ???

  override def sleep(): Unit = ???

  override def eat(x: Any): Any = ???
}

class Student extends Person {
  /**
    * 与接口不同的是，它还可以定义属性和方法的实现。
    */
  override val name: String = "student"
  override val age: Integer = 0

  override def isEqual(x: Any): Boolean = ???

  override def study(): Unit = ???

  override def work(x: Any): Any = ???

  override def sleep(): Unit = ???

  override def eat(x: Any): Any = ???
}