<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");

	request.setAttribute("id", "jang");
	request.setAttribute("pwd", "1234");
	session.setAttribute("name", "장일규");
	application.setAttribute("email", "jang@admin.com");

	/* request에 address 속성 이름으로 바인딩한다.  */
	request.setAttribute("address", "인천시 계양구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward3</title>
</head>
<body>

	<jsp:forward page="member4.jsp"></jsp:forward>

</body>
</html>