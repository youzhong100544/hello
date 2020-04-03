package com.hello.servlet2_5.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.servlet2_5.domain.User;
import com.hello.servlet2_5.service.UserService;
import com.hello.servlet2_5.web.bean.UserFormBean;

public class RegistUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//0 请求编码
			request.setCharacterEncoding("UTF-8");

			// 1 获得数据并封装到javabean
			// 1.1 获得数据
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			
			/**数据校验 start*/
			// #1 将所有数据，封装 表单校验javabean
			UserFormBean formBean = new UserFormBean(id, username, password, repassword, gender, age);
			if(! formBean.validate()){
				//没有校验成功 -- 表单中显示相应的信息  formBean.username , formBean.errorMsg.usernameMsg
				request.setAttribute("formBean", formBean); //提交数据、提示信息
				request.getRequestDispatcher("/pages/regist.jsp").forward(request, response);
				return;
			}
			/**数据校验 end*/

			// 1.2 封装
			User user = new User(id, username, password, gender, age);
			// 2 执行注册
			UserService userService = new UserService();
			userService.regist(user);
			// 3提示--成功
			request.setAttribute("msg", "用户注册成功");
			request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
			
		} catch (Exception e) {
			// 记录日志
			e.printStackTrace();
			
			// 提示--不成功
			request.setAttribute("msg", "用户名注册不成功，请稍后重试");
			request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
