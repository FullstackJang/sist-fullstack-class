<%@page import="com.sist.loginDAO.MemberDAO"%>
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
			
			MemberDAO mDAO = MemberDAO.getInstance();
			
			 if(mDAO.isMember(id, pwd)){
				 session.setAttribute("member","yes");
				 System.out.println(session.getId());
				 response.sendRedirect("main.jsp");
			 }else{
				 response.sendRedirect("login.html");
			 }
		%>
</body>
</html>