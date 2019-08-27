package com.hello.test.scala

import com.alibaba.fastjson.JSON
import org.apache.http.client.methods.{HttpGet, HttpPost}
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

object DemoHttpClient {

	def main(args: Array[String]): Unit = {
		val url = "http://192.168.1.00:8082/risk/getUserByGet?userName=zhoujiamu"

		println("This get response: ")
		println(getResponse(url))

		val postUrl = "http://192.168.1.00:8082/risk/group"
		val params = """{"company_list":["北京佛尔斯特金融信息服务有限公司"],"conditions":{}}"""

		println("This post response: ")
		println(postResponse(postUrl, params, """{"Content-Type": "application/json"}"""))

	}
	def getResponse(url: String, header: String = null): String = {
		val httpClient = HttpClients.createDefault()    // 创建 client 实例
		val get = new HttpGet(url)    // 创建 get 实例

		if (header != null) {   // 设置 header
			val json = JSON.parseObject(header)
			json.keySet().toArray.map(_.toString).foreach(key => get.setHeader(key, json.getString(key)))
		}

		val response = httpClient.execute(get)    // 发送请求
		EntityUtils.toString(response.getEntity)    // 获取返回结果
	}

	def postResponse(url: String, params: String = null, header: String = null): String ={
		val httpClient = HttpClients.createDefault()    // 创建 client 实例
		val post = new HttpPost(url)    // 创建 post 实例

		// 设置 header
		if (header != null) {
			val json = JSON.parseObject(header)
			json.keySet().toArray.map(_.toString).foreach(key => post.setHeader(key, json.getString(key)))
		}

		if (params != null) {
			post.setEntity(new StringEntity(params, "UTF-8"))
		}

		val response = httpClient.execute(post)    // 创建 client 实例
		EntityUtils.toString(response.getEntity, "UTF-8")   // 获取返回结果
	}

}
