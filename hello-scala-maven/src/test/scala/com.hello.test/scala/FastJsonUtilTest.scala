package com.hello.test.scala


import com.alibaba.fastjson.{JSON, JSONArray, JSONObject}
import com.hello.scala.utils.FastJsonUtil
import com.hello.scala.utils.FastJsonUtil.strToJSONObject

object FastJsonUtilTest {
	def main(args: Array[String]): Unit = {

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
		val str0: String = "{\n\t\"dataId\":123,\n\t\"dataType\":\"mysql\",\n\t\"resultData\":[\n\t\t\t\t  {\"binlog\":\"mysql_binlog.000\",\"column\":[{\"name\":\"single\",\"type\":\"int(5)\"},{\"name\":\"single3\",\"type\":\"int(5)\"}]},\n\t\t\t\t  {\"binlog1\":\"redis_binlog.000\",\"column\":[{\"name\":\"single3\",\"type\":\"int(5)\"},{\"name\":\"single3\",\"type\":\"int(5)\"}]},\n\t\t\t     ]\n}"


		val str1: String = "{\"name\":\"张三\",\"age\":10}"

		val str2: String = "{\"data\":[{\"label\":\"123\",\"acc\":1,\"version\":\"4.3.1\"}]}"

		val str3: String = "{\"data\":[{\"label\":\"789\",\"acc\":1,\"version\":\"4.3.1\"},{\"label\":\"78\",\"acc\":100,\"version\":\"4.3.1\"}]}"


		/* ----------------------------------------- */
		// 对于JSON中的套JSON字符串的可以使用
		val jsonObject: JSONObject = JSON.parseObject(str0)

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





		/* ------------------------------------------------------------------------- */

		val nObject: JSONObject = strToJSONObject(str1)
		println("name: " + nObject.get("name"))
		println("name: " + nObject.getString("name"))
		println("age: " + nObject.getInteger("age"))

		/* ----------------------------------------- */

		val jObject: JSONObject = FastJsonUtil.strToJSONObject(str2)
		println("data: " + jObject.get("data"))

		/* ----------------------------------------- */
		val fj = new FastJsonUtil
		val sObject: JSONObject = fj.strToJSONObject(str3)
		val data: AnyRef = sObject.get("data")
		println("data: " + data)



		/* ----------------------------------------- */

	}
}
