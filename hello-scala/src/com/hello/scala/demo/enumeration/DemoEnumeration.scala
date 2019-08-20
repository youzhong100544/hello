package com.hello.scala.demo.enumeration


/**
	* scala 枚举
	*
	*
	* 	遍历推荐使用下面这种方式
	* 		Color.values.foreach { v => println(v,v.id)}
	*/
object DemoEnumeration {
	def main(args: Array[String]): Unit = {

		val demo = new DemoEnumeration

		println("demoColor:")
		println()
		demo.demoColor()
		println("-----------------------------------------------------------------------")

		println()
		println("demoWeek:")
		println()
		demo.demoWeek
		println("-----------------------------------------------------------------------")

		println()
		println("demoWeekDay:")
		println()
		demo.demoWeekDay
		println("-----------------------------------------------------------------------")

		println()
		println("demoDirection:")
		println()
		demo.demoDirection
		println("-----------------------------------------------------------------------")

		println()
		println("demoMonth:")
		println()
		demo.demoMonth
		println("-----------------------------------------------------------------------")

		println()
		println("demoFruits:")
		println()
		demo.demoFruits
		println("-----------------------------------------------------------------------")



	}
}


object Color extends Enumeration {
	val Red = Value
	val Green = Value
	val Blue = Value
}

/**
	* 继承Value的时候，可以指定初始值，也就是起始下标
	*/
object Week extends Enumeration(10) {

	val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value

}


object WeekDay extends Enumeration {

	//声明枚举对外暴露的变量类型
	type WeekDayType = Value


	val Mon = Value("1")
	val Tue = Value("2")
	val Wed = Value("3")
	val Thu = Value("4")
	val Fri = Value("5")
	val Sat = Value("6")
	val Sun = Value("7")

	def checkExists(day: String) = this.values.exists(_.toString == day) //检测是否存在此枚举值
	def isWorkingDay(day: WeekDayType) = ! ( day == Sat || day == Sun) //判断是否是工作日
	def showAll = this.values.foreach(println) // 打印所有的枚举值

	def showEnum(day: WeekDay.Value) = println(s"ID: ${day.id}, Str: $day")



}

object Direction extends Enumeration {
	val North = Value("North")
	val East = Value("East")
	val South = Value("South")
	val West = Value("West")
}

object Month extends Enumeration {

	//声明枚举对外暴露的变量类型
	type MonthType = Value

	val January = Value("1")
	val February = Value("2")
	val March = Value
	val April = Value
	val May = Value
	val June = Value
	val July = Value
	val August = Value
	val September = Value
	val October = Value
	val November = Value
	val December = Value


	def checkExists(month: String) = this.values.exists(_.toString == month) //检测是否存在此枚举值
	def isWinter(month: MonthType) = ! ( month == October || month == November || month == December) //判断是否是冬天
	def showAll = this.values.foreach(println) // 打印所有的枚举值
}


object Fruits extends Enumeration {

	//这行是可选的，类型别名，在使用import语句的时候比较方便，建议加上
	//声明枚举对外暴露的变量类型
	type FruitsType = Value

	// 可以传向Value传ID, 名称， 或两个都传;
	// 未定义时， ID默认从0开始， 累计加1, 缺省名称为字段名
	val apple = Value(20, "app")
	val orange, banana = Value

	val Q1 = Value(100, "Quarter1")
	val Q2 = Value(200, "Quarter2")


}


class DemoEnumeration {
	def demoColor(): Unit = {
		println("元素个数:" + Color.maxId)
		println("遍历方式一:")
		for(i <- 0 until Color.maxId){
			println(Color(i))
		}

		println("遍历方式二:")
		Color.values.foreach { v => println(v.id, v)}

		println("遍历方式二:")
		Color.values.foreach { v => println(s"ID: ${v.id}, Str: $v")}

		println("遍历方式二简写:")
		Color.values foreach println

		println("遍历方式三:")
		for(n <- Range(0, Color.maxId)){
			println(Color(n))
		}

		println(Color.Red.id)
		println(Color.Red)

	}

	def demoWeek(): Unit = {
		println("元素个数:" + Week.maxId)

		println("遍历:")
		Week.values.foreach { v => println(v.id, v)}

	}

	def demoWeekDay(): Unit = {
		println("元素个数:" + Week.maxId)

		println("遍历:")
		WeekDay.values.foreach { v => println(v.id, v)}

		println("执行里面的方法:")
		println(WeekDay.checkExists("8"))//检测是否存在

		println(WeekDay.Sun == WeekDay.withName("7"))//正确的使用方法

		println(WeekDay.Sun == "7") //错误的使用方法

		println("打印所有的枚举值")
		WeekDay.showAll //打印所有的枚举值

		println("是否是工作日")
		println(WeekDay.isWorkingDay(WeekDay.Sun)) //是否是工作日

		// 通过枚举ID访问枚举
		println("通过枚举ID访问枚举")
		WeekDay.showEnum(WeekDay(0))
		WeekDay.showEnum(WeekDay(3))

		println()

		// 通过枚举名称访问枚举
		println("通过枚举名称访问枚举")
		WeekDay.showEnum(WeekDay withName "1")
		WeekDay.showEnum(WeekDay withName "3")

		println()

		// 遍历枚举内容
		println("遍历枚举内容")
		WeekDay.values foreach WeekDay.showEnum
	}

	def demoDirection(): Unit = {
		println("元素个数:" + Direction.maxId)
		for(i <- 0 until Direction.maxId){
			println(Direction(i))
		}
	}

	def demoMonth(): Unit = {
		println("元素个数:" + Month.maxId)
		for(i <- 0 until Month.maxId){
			println(Month(i))
		}
	}

	def demoFruits(): Unit = {
		println("元素个数:" + Fruits.maxId)
		println("遍历方式一:")
		/* 由于枚举类的id不规则所以是使用这种方式会报错 */
		/* 推荐是用方式二 */
		/*
		for(i <- 0 until Fruits.maxId){
			println(Fruits(i))
		}
		*/
		println()
		println()

		println("遍历方式二:")
		Fruits.values.foreach { v => println(v.id, v)}

		//import com.hello.scala.demo.enumeration.Fruits._
		//for (c <- FruitsType) println(c.id + ":" + c)*/

	}
}

