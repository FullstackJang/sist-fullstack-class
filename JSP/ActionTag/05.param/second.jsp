<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Title : <%= request.getParameter("title") %><br>
	Year : <%= request.getParameter("year") %><br>
	Date : <%= request.getParameter("date") %>
</body>
</html>