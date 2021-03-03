<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />

    <c:url var="url1" value="/test01/member1.jsp"> 
		<c:param name="id" value="jeon"/>
		<c:param name="pwd" value="1234"/>
		<c:param name="name" value="전지현"/>
		<c:param name="email" value="jeon@admin.com"/>
	</c:url>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:url 태그 실습</title>
</head>
<body>
	 <%-- <a href="${contextPath }/test01/member1.jsp">회원정보 출력</a> --%>
	<a href="${url1}">회원정보 출력</a>
</body>
</html>