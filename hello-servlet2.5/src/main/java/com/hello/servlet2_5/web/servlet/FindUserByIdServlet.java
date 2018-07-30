package com.hello.servlet2_5.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.servlet2_5.domain.User;
import com.hello.servlet2_5.service.UserService;

public class FindUserByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1 获得请求参数id的值
		String id = request.getParameter("id");
		//2 通过service 查询用户
		UserService userService = new UserService();
		User user = userService.findUserById(id);
		
		//3 使用 请求转发显示数据
		// 3.1 在request作用域设置数据
		request.setAttribute("user",user);
		// 3.2 请求转发到jsp
		request.getRequestDispatcher("/pages/show_detail.jsp").forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
