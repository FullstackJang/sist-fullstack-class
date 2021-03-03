<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="joinException.jsp"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	
	이름 : <%= name %>
	나이 : <%= age %>
</body>
</html>