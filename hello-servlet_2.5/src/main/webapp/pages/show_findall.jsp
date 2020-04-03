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
			<td>编号</td>
			<td>员工号</td>
			<td>用户名</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.allUser }" var="user" varStatus="vs">
			<tr>
				<td>${vs.getCount() }</td>
				<td>${user.id }</td>
				<td>${user.username }</td>
				<td> 
					<a href="${pageContext.request.contextPath}/FindUserByIdServlet?id=${user.id}">查询详情</a>  
					修改 
					删除 
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>