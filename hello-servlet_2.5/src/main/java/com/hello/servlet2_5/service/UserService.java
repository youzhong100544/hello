package com.hello.servlet2_5.service;

import java.util.List;

import com.hello.servlet2_5.dao.UserDao;
import com.hello.servlet2_5.domain.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAllUser(){
		return userDao.findAll();
	}
	
	/**
	 * 通过唯一标识id查询用户详情
	 * @param id
	 * @return
	 */
	public User findUserById(String id){
		return userDao.findById(id);
	}

	/**
	 * 用户注册
	 * @param user
	 */
	public void regist(User user) {
		userDao.save(user);
	}

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user){
		return userDao.find(user.getUsername(),user.getPassword());
	}
}
