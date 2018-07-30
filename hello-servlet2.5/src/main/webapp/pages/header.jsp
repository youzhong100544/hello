<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<a href="${pageContext.request.contextPath}/FindAllUserServlet">首页</a>

<%--用户没有登录，显示注册和登录 --%>
<c:if test="${empty loginUser}">
	<a href="${pageContext.request.contextPath}/pages/regist.jsp">注册</a>
	<a href="${pageContext.request.contextPath}/pages/login.jsp">登录</a>
</c:if>
<%--用户登录，显示名称，注销 --%>
<c:if test="${not empty loginUser}">
	欢迎，vip中p ${loginUser.username } ， 
	<a href="${pageContext.request.contextPath}/LogoutUserServlet">注销</a>
</c:if>

<hr/>


    
    