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
		request.setCharacterEncoding("utf-8");
		
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			
		if("tiger".equals(id) && "1234".equals(pwd)){
		%>
		<jsp:forward page="main.jsp"/>
			<% 
			} else{
			%>
		
			<jsp:forward page="login.html"/>
		<%
			}
		%>
		
</body>
</html>