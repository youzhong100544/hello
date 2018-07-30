package com.hello.servlet2_5.dao;

import java.util.ArrayList;
import java.util.List;

import com.hello.servlet2_5.domain.User;

public class UserDao {

	/**
	 * 添加
	 * @param user
	 */
	public void save(User user){

	}
	/**
	 * 更新（编辑）
	 * @param user
	 */
	public void update(User user){
		
	}
	/**
	 * 删除
	 * @param id
	 */
	public void delete(String id){
		
	}
	
	/**
	 * 查询所有用户
	 * * 思想：一般情况dao层，如果出现异常，都自己进行try catch 但需要通知调用，throw 异常（RuntimeException ，自定义异常）
	 * @return
	 */
	public List<User> findAll(){
		List<User> list = new ArrayList<User>();
		try {
			User user = new User("1", "xiaoming", "123456", "man", "21");
			list.add(user);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过唯一标识（id）查询
	 * @param id
	 * @return
	 */
	public User findById(String id){
		try {
			return new User("1", "xiaoming", "123456", "man", "21");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 通过用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return
	 */
	public User find(String username, String password) {
		try {
			return new User("1", "xiaoming", "123456", "man", "21");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
