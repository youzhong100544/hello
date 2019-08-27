package com.hello.scala.demo.NullValue


/**
	* 为了让所有的东西都是对象的目标更加一致，也为了遵循函数式编程的习惯。
	* Scala鼓励你在变量和函数返回值可能不会引用任何值的时候使用Option类型。
	* Scala的Option类型可以避免NullPointerException情况，因此，Scala应用推荐使用Option类型来代表一些可选值。
	* 使用Option类型，读者一眼就可以看出这种类型的值可能为None。
	*
	* 如果没有值的时候使用None，这是Option的一个子类。 
	* 如果有值使用Some来包含这个值，Some也是Option的之类。
	*
	*
	*
	*
	* Scala程序使用Option非常频繁，在Java中使用null来表示空值，代码中很多地方都要添加null关键字检测，不然很容易出现NullPointException。
	* 因此Java程序需要关心那些变量可能是null,而这些变量出现null的可能性很低，但一但出现，很难查出为什么出现NullPointerException。
	*
	* Scala的Option类型可以避免这种情况，因此Scala应用推荐使用Option类型来代表一些可选值。
	* 使用Option类型，读者一眼就可以看出这种类型的值可能为None。
	*
	*
	* 实际上，多亏Scala的静态类型，你并不能错误地尝试在一个可能为null的值上调用方法。
	* 虽然在Java中这是个很容易犯的错误，它在Scala却通不过编译，这是因为Java中没有检查变量是否为null的编程作为变成Scala中的类型错误（不能将Option[String]当做String来使用）。
	* 所以，Option的使用极强地鼓励了更加弹性的编程习惯。
	*
	*
	*/
object DemoTest {

	def main(args: Array[String]): Unit = {
		val capitals = Map("France"->"Paris", "China"->"Beijing", "Italy"->"Rome", "Japan"->"Tokyo")

		println("1、------------------------------------------------------------------------------")
		println(capitals get "France") // Some(Paris)
		println(capitals get "North Pole") // None


		println("2、------------------------------------------------------------------------------")
		println(capitals get "France" get)// Paris
		/*
		capitals get "North Pole" get

		Exception in thread "main" java.util.NoSuchElementException: None.get
				at scala.None$.get(Option.scala:347)
				at scala.None$.get(Option.scala:345)
		 */

		println(capitals("France"))// Paris


		println("3、------------------------------------------------------------------------------")
		println((capitals get "France") getOrElse "Oops") // Paris
		println((capitals get "North Pole") getOrElse "Oops") // Oops

		println(capitals.getOrElse("Italy", "Oops")) // Rome


		println("4、------------------------------------------------------------------------------")
		println(showCapital(capitals get "China")) // Beijing
		println(showCapital(capitals get "North Pole")) // ?

	}

	private def showCapital(x: Option[String]) = x match {
		case Some(s) => s
		case None => "?"
	}
}

/**
	* 详解Option[T]
	*
	* 在Scala里Option[T]实际上是一个容器，就像数组或是List一样，你可以把他看成是一个可能有零到一个元素的List。
	* 当你的Option里面有东西的时候，这个List的长度是1（也就是 Some），而当你的Option里没有东西的时候，它的长度是0（也就是 None）。
	*
	*
	*/
object DemoOption {
	def main(args: Array[String]): Unit = {
		val capitals = Map("France"->"Paris", "China"->"Beijing", "Italy"->"Rome", "Japan"->"Tokyo")

		println("1、for循环------------------------------------------------------------------------------")
		printContentLength(capitals.get("France")) // 5

		printContentLength(capitals.get("North Pole")) //


		println("2、map操作------------------------------------------------------------------------------")
		capitals.get("France").map(_.length).map("length: " + _).foreach(println) // length: 5
		capitals.get("France").map("length: " + _.length).foreach(println) // length: 5
	}

	/**
		* for循环
		* @param x
		*/
	def printContentLength(x: Option[String]) {
		for (c <- x){
			println(c.length)
		}
	}


}