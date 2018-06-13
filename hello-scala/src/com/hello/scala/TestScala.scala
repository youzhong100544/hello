package com.hello.scala

class TestScala {

  def m(x : Int) = x + 3
  val f = (x : Int) => x + 3


  def addInt( a : Int, b : Int ) : Int = {
    var sum : Int = 0
    sum = a + b

    return sum
  }


  def printMe( ) : Unit = {
    println("Hello, Scala!")
  }

}
