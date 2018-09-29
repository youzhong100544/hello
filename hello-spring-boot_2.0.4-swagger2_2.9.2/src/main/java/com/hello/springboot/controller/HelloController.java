package com.hello.springboot.controller;

import com.hello.springboot.bean.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value="/hello")
public class HelloController {

	/**
	 * 获取用户列表
	 * @return list
	 */
	@ApiOperation(value ="查询所有用户",notes ="",httpMethod = "GET")
	@GetMapping("/user")
	public List<User> userList(){

		List<User> list = new ArrayList<>();

		list.add(new User("小明", 10, new Date()));
		list.add(new User("小强", 12, new Date()));
		list.add(new User("小红", 11, new Date()));

		return  list;
	}

	/**
	 * 查询用户根据id
	 * @return USer对象
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
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "String"),
			@ApiImplicitParam(name = "user",value = "用户实体,传入更改后的数据",required = true,dataType = "User")
	})
	@PutMapping("user/{id}")
	public String updateUser(@PathVariable String id,@RequestBody User user){
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
