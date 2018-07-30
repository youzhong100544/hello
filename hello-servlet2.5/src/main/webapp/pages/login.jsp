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

	<c:if test="${not empty msg}">
	
		<font color="red">${msg}</font> <br/>
	</c:if>
	
	<form action="${pageContext.request.contextPath}/LoginUserServlet" method="post">
		<table border="1">
			<tr>
				<td>名称</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="登录" /></td>
			</tr>
		</table>
	</form>


</body>
</html>