package com.hello.scala.`trait`

/**
  * 陆生生物
  */
trait Terrestrial {
  def breathe(organ : String = "肺") : Unit = { println("用" + organ + "呼吸") }
}
