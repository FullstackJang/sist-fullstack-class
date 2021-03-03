<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
   	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
	<%--
		<c:set /> 태그 위나 아래에 <!-- --> 주석 시 Missing end tag for "c:set" 에러 발생
		
		<c:set> 태그를 이용해 변수를 선언한다. value 속성에는 표현 언어를 사용해서 초기화 할 수 있다 
	--%>
		<c:set var="id" value="hong" scope="page" />
		<c:set var="pwd" value="1234" scope="page"/>
    	<c:set var="name" value="${'홍길동' }" scope="page"  />
    	<c:set var="age" value="${ 21 }" scope="page"/>
    	<c:set var="height" value="${ 180 }" scope="page"  />
    	
    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" align="center">
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
	</table>

</body>
</html>
