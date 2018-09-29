package com.hello.spring.boot.controller;

import com.hello.spring.boot.bean.User;
import com.hello.spring.boot.model.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Api：用在请求的类上，表示对类的说明
	tags="说明该类的作用，可以在UI界面上看到的注解"
	value="该参数没什么意义，在UI界面上也看到，所以不需要配置"

 * @author
 *
 */
@Api(value="hello", tags="测试接口模块")
@RestController
@RequestMapping(value="/hello")
public class HelloController {
	/**
	 * @ApiOperation：用在请求的方法上，说明方法的用途、作用
		value="说明方法的用途、作用"
		notes="方法的备注说明"
		 @ApiImplicitParams：用在请求的方法上，表示一组参数说明
		 @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
		 name：参数名
		 value：参数的汉字说明、解释
		 required：参数是否必须传
		 paramType：参数放在哪个地方
		 · header --> 请求参数的获取：@RequestHeader
		 · query --> 请求参数的获取：@RequestParam
		 · path（用于restful接口）--> 请求参数的获取：@PathVariable
		 · body（不常用）
		 · form（不常用）
		 dataType：参数类型，默认String，其它值dataType="Integer"
		 defaultValue：参数的默认值

		 @ApiResponses：用在请求的方法上，表示一组响应
		 @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
		 code：数字，例如400
		 message：信息，例如"请求参数没填好"
		 response：抛出异常的类

		 @ApiModel：用于响应类上，表示一个返回响应数据的信息
		 （这种一般用在post创建的时候，使用@RequestBody这样的场景，
		 请求参数无法使用@ApiImplicitParam注解进行描述的时候）
		 @ApiModelProperty：用在属性上，描述响应类的属性
	 *
	 *
	 */


	/**
	 * 获取用户列表
	 * @return list
	 */
	@ApiOperation(value ="查询所有用户",notes ="",httpMethod = "GET")
	@GetMapping("/userList")
	@ResponseBody
	public List<User> userList(){

		List<User> list = new ArrayList<>();

		list.add(new User("小明", 10, new Date()));
		list.add(new User("小强", 12, new Date()));
		list.add(new User("小红", 11, new Date()));

		return  list;
	}

	/**
	 * 查询用户根据id
	 * @return User对象
	 * @param  id
	 */
	@ApiOperation(value = "查询用户",notes = "根据用户id查询用户",httpMethod = "GET")
	@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "String")
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable String id){
		return new User(Integer.parseInt(id), "小明", 10, new Date());
	}

	/**
	 * 新增User
	 * @param user
	 * @return success or error
	 */
	@ApiOperation(value = "新增用户",notes = "",httpMethod = "POST")
	@ApiImplicitParam(name = "user",value = "用户实体",required = true,dataType = "User")
	@PostMapping("/user")
	public String createUser(@RequestBody User user){
		return "success";
	}

	/**
	 * 更新User
	 * @param user
	 * @return success or error
	 */
	@ApiOperation(value = "更新用户",notes = "根据用户id更新用户",httpMethod = "PUT")
	@PutMapping(value = "user/{id}")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "用户id", required = true, paramType = "path", dataType = "Integer"),
			@ApiImplicitParam(name = "user",value = "用户实体,传入更改后的数据",required = true,dataType = "User")
	})
	public String updateUser(@PathVariable Integer id, @RequestBody UserModel user){
		return "success";
	}

	/**
	 * 删除用户
	 * @param id
	 * @return success or error
	 */
	@ApiOperation(value = "删除用户",notes = "",httpMethod = "DELETE")
	@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "String")
	@DeleteMapping("user/{id}")
	public String deleteUser(@PathVariable String id){
		return "success";
	}

}
