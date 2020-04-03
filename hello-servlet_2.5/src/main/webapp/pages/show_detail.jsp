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

	<table border="1">
		<tr>
			<td>用户号</td>
			<td>${user.id}</td>
		</tr>
		<tr>
			<td>名称</td>
			<td>${user.username}</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>${user.gender}</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td>${user.age}</td>
		</tr>
	</table>
</body>
</html>