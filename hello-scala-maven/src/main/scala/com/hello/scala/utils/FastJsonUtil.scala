package com.hello.scala.utils

import com.alibaba.fastjson.{JSON, JSONArray, JSONException, JSONObject}

object FastJsonUtil{

	def isJSONValid(str: String): Boolean = {

		try {
			val obj: Object = JSON.parse(str)
			if (obj.isInstanceOf[JSONObject]) {
				val jsonObject: JSONObject = obj.asInstanceOf[JSONObject]
				println("jsonObject:" + jsonObject)
				true
			} else if (obj.isInstanceOf[JSONArray]) {
				val jsonArray: JSONArray = obj.asInstanceOf[JSONArray]
				println("jsonArray:" + jsonArray)
				true
			} else {
				println("no")
				false
			}
		} catch {
			case ex: JSONException =>{
				println(ex)
				false
			}
			case ex: Exception => {
				println(ex)
				false
			}
		}

	}

	def strToJSONObject(str: String): JSONObject = {
		JSON.parseObject(str)
	}

}

class FastJsonUtil {


	def strToJSONObject(str: String): JSONObject = {
		JSON.parseObject(str)
	}

}
