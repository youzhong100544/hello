package com.hello.scala.utils

import com.alibaba.fastjson.{JSON, JSONObject}

object FastJsonUtil{

	def strToJSONObject(str: String): JSONObject = {
		JSON.parseObject(str)
	}

}

class FastJsonUtil {


	def strToJSONObject(str: String): JSONObject = {
		JSON.parseObject(str)
	}

}
