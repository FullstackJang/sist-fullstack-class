<%@page import="com.sist.CalDAO.Calculator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
//		Calculator bean = new Calculator();
	%>

	<jsp:useBean id="bean" class="com.sist.CalDAO.Calculator"/>

	<%
	
		int m = bean.process(5);
	
		out.print("5의 3제곱 : " + m);
	
	%>


</body>
</html>