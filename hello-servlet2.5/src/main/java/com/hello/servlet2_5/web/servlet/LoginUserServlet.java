package com.hello.servlet2_5.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.servlet2_5.domain.User;
import com.hello.servlet2_5.service.UserService;

public class LoginUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//0 编码
		request.setCharacterEncoding("UTF-8");
		
		//1 获得用户和密码，并封装数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password);
		
		//2 执行用户登录
		UserService userService = new UserService();
		User loginUser = userService.login(user);
		
		//3处理
		if(loginUser != null){
			//成功 -- session记录登录状态，重定向指定页（查询所有）
			// * session 作用域保存数据
			request.getSession().setAttribute("loginUser", loginUser);
			// * 重定向
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			//不成功-- request记录当次请求提示信息，请求转发到登录login.jsp 显示数据
			// * request记录错误信息
			request.setAttribute("msg", "用户名和密码不匹配");
			// * 使用请求转发显示数据
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
