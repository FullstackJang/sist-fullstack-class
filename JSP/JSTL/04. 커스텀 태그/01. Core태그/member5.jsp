<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
    
    <c:set var="id" value="hong" scope="page" />
	<c:set var="pwd" value="1234" scope="page" />
	<c:set var="name" value="${'홍길동' }" scope="page" />
	<c:set var="age" value="${29 }" scope="page" />
	<c:set var="height" value="${180}" scope="page" />
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<table border="1" align="center">
	<c:choose>
		<%-- <c:when test="${name == null }"/> --%>
		<c:when test="${empty name }">
			<tr align="center">
				<td colspan="5">이름을 입력하세요.!!</td>
			</tr>
		</c:when>
		<c:otherwise>
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>나이</b></td>
			<td width="20%"><b>키</b></td>
		</tr>
		
		<!-- 표현 언어로 바로 접근하여 값을 출력한다.  -->
		
		<tr align="center">
			<td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${age }</td>
			<td>${height }</td>
		</tr>
		</c:otherwise>		
	</c:choose>
	</table>
</body>
</html>