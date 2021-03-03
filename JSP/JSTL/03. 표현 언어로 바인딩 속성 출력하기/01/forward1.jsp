<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	/* requset 내장 객체에 바인딩한다. */
	request.setAttribute("id", "hong");
	request.setAttribute("pwd", "1234");

    /* session 내장 객체에 바인딩한다. */
	request.setAttribute("name", "홍길동");

    /* application 내장 객체에 바인딩한다. */
	request.setAttribute("email", "hong@admin.com");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward1</title>
</head>
<body>

	<jsp:forward page="member1.jsp"></jsp:forward>

</body>
</html>