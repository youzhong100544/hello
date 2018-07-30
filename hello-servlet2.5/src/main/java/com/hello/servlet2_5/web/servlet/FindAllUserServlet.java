package com.hello.servlet2_5.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.servlet2_5.domain.User;
import com.hello.servlet2_5.service.UserService;

public class FindAllUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//2 service 层 对象实例
		UserService userService = new UserService();
		// * 查询所有
		List<User> allUser =  userService.findAllUser();
		
		//3 使用请求转发，到show_findall.jsp 显示数据
		//3.1 存放request作用域
		request.setAttribute("allUser",allUser);
		//3.2 请求转发
		request.getRequestDispatcher("/pages/show_findall.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
