<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--添加公共头信息 --%>
	<%@include file="/pages/header.jsp" %>

	<form action="${pageContext.request.contextPath}/RegistUserServlet" method="post">
		<table border="1">
			<tr>
				<td>用户号</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>名称</td>
				<td><input type="text" name="username" value="${formBean.username}" /> ${formBean.errorMsg.usernameMsg}</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" value="${formBean.password}" />${formBean.errorMsg.passwordMsg}</td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="repassword" value="${formBean.repassword}" />${formBean.errorMsg.repasswordMsg}</td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="gender" checked="checked" value="男" />男
					<input type="radio" name="gender" value="女"/>女
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><img src="" /> <input type="text" name="verifyCode" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="注册" /></td>
			</tr>
		</table>
	</form>


</body>
</html>