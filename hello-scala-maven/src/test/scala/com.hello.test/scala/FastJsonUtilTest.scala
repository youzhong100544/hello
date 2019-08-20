package com.hello.test.scala


import com.alibaba.fastjson.{JSON, JSONArray, JSONObject}
import com.hello.scala.utils.FastJsonUtil
import com.hello.scala.utils.FastJsonUtil.strToJSONObject
import org.junit.Test

import scala.collection.immutable
import scala.io.Source

object FastJsonUtilTest {

	/*
{
"dataId":123,
"dataType":"mysql",
"resultData":[
				{"binlog":"mysql_binlog.000","column":[{"name":"single","type":"int(5)"},{"name":"single3","type":"int(5)"}]},
				{"binlog1":"redis_binlog.000","column":[{"name":"single3","type":"int(5)"},{"name":"single3","type":"int(5)"}]},
		]
}
	* */
	val str1: String = "{\n\t\"dataId\":123,\n\t\"dataType\":\"mysql\",\n\t\"resultData\":[\n\t\t\t\t  {\"binlog\":\"mysql_binlog.000\",\"column\":[{\"name\":\"single\",\"type\":\"int(5)\"},{\"name\":\"single3\",\"type\":\"int(5)\"}]},\n\t\t\t\t  {\"binlog1\":\"redis_binlog.000\",\"column\":[{\"name\":\"single3\",\"type\":\"int(5)\"},{\"name\":\"single3\",\"type\":\"int(5)\"}]},\n\t\t\t     ]\n}"


	val str2: String = "{\"name\":\"张三\",\"age\":10}"

	val str3: String = "{\"data\":[{\"label\":\"123\",\"acc\":1,\"version\":\"4.3.1\"}]}"

	val str4: String = "{\"data\":[{\"label\":\"789\",\"acc\":1,\"version\":\"4.3.1\"},{\"label\":\"78\",\"acc\":100,\"version\":\"4.3.1\"}]}"


	def main(args: Array[String]): Unit = {
		val test = new FastJsonUtilTest

		test.test01()
		test.test02()
		test.test03()
		test.test04()

		println()
		println()
		println("test05------------")
		println()
		test.test05()





	}
}

class FastJsonUtilTest{

	def test01(): Unit = {
		/* ----------------------------------------- */
		// 对于JSON中的套JSON字符串的可以使用
		val jsonObject: JSONObject = JSON.parseObject(FastJsonUtilTest.str1)

		val resultDataStr : String = jsonObject.getString("resultData")
		println("resultDataStr------------")
		println(resultDataStr)

		val result : JSONArray = jsonObject.getJSONArray("resultData")
		println("result------------")
		println(result)

		//获取 result 中的 的数组的对应的第一个JSONObject
		val rObject_0: JSONObject = result.getJSONObject(0)
		println("0------------")
		println(rObject_0)

		val rObject_1: JSONObject = result.getJSONObject(1)
		println("1------------")
		println(rObject_1)

		//或取里面的value值
		val str = rObject_1.getString("binlog")

		//里面的column对应的还是一个数组类型的当然还可以使用getJSONArray
		val column  : JSONArray   = rObject_1.getJSONArray("column")

		//可以通过上面的getString 方法获取每一个字段

		//如果想要遍历JSONArray中的所有数据，想不使用getJSONObject方法，但是想要
		//这里面的遍历的所有的JSONObject可以使用

		import scala.collection.JavaConversions._
		//可以把Java中的集合转成Scala中的集合
		//先把JSONArray转换成迭代器Iterator[AnyRef]类型，再转换为List
		//转换为List时需要导入 上面的包

		val list: List[AnyRef] = result.iterator().toList

		val listOBJ: List[JSONObject] = list.map(m=>
			JSON.parseObject(m.toString)
			/*或者使用m.asInstanceOf[JSONObject]*/
		)
		//然后可以使用for循环或者foreach尽心循环

		println("-----------------------------------------------------------------------------------")


	}

	def test02(): Unit = {
		/* ------------------------------------------------------------------------- */

		val nObject: JSONObject = strToJSONObject(FastJsonUtilTest.str2)
		println("name: " + nObject.get("name"))
		println("name: " + nObject.getString("name"))
		println("age: " + nObject.getInteger("age"))

		/* ----------------------------------------- */
	}

	def test03(): Unit = {


		val jObject: JSONObject = FastJsonUtil.strToJSONObject(FastJsonUtilTest.str3)
		println("data: " + jObject.get("data"))
	}

	def test04(): Unit = {


		/* ----------------------------------------- */
		val fj = new FastJsonUtil
		val sObject: JSONObject = fj.strToJSONObject(FastJsonUtilTest.str4)
		val data: AnyRef = sObject.get("data")
		println("data: " + data)

		/* ----------------------------------------- */
	}

	def test05(): Unit = {
		// val lines: Iterator[String] = Source.fromFile("json.txt").getLines()
		// 上面的语句会报错

		// test/resources/json.txt
		val lines: Iterator[String] = Source.fromURL(getClass.getResource("/json.txt")).getLines()
		lines.foreach(println)
		println(lines)

		val list: List[String] = lines.toList
		val jSONObjects: immutable.Seq[JSONObject] = list.map(x => {  //取出每一条数据，把数据转换成JSONObject类型
			println(x)
			JSON.parseObject(x)
		})
		jSONObjects.foreach( t =>{
			val str: String = t.getString("resultData")  //取出resultData的数据，
			val oNArray: JSONArray = t.getJSONArray("resultData")
			//result对应的数据是一个 数组中 存的是 [{json字符串},{json字符串}]

			// /想要遍历JSONArray中的数据可以使用
			import scala.collection.JavaConversions._  //可以把Java中的集合转成Scala中的集合
			val list: List[AnyRef] = oNArray.iterator().toList
			val listOBJ: List[JSONObject] = list.map(m=> JSON.parseObject(m.toString)/*或者使用m.asInstanceOf[JSONObject]*/)

			val str1 = oNArray.getString(0)
			//也可以通过getJSONObject(下标)  获取相应的JSONObject
			val nObject: JSONObject = oNArray.getJSONObject(1)
			//获取column
			val value = nObject.getString("column")
			val array = nObject.getJSONArray("column")
			println(str1)
			println(value)
			println(array.getString(0))
			val on1 = array.getJSONObject(0)
			val str3 = on1.getString("modified")
			println(str3)

		})

	}


	@Test
	def test06(): Unit = {

	}
}