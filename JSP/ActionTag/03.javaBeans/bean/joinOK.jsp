<%@page import="com.sist.loginDAO.MemberDAO"%>
<%@page import="com.sist.BeanVo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="m" class="com.sist.BeanVo.MemberVo"/>
<jsp:setProperty property="*" name="m"/> 

<!-- join.html에 있는 name에 이름이랑 jsp:setProperty에 name에 이름이랑 동일해야한다.  -->
<!--jsp:setProperty는 setter()를 호출한다고 생각하면 된다.  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		
	/*
		MemberVo m = new MemberVo();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		m.setId(id);
		m.setPwd(pwd);
		m.setName(name);
		m.setEmail(email); 
		*/
	%>
	
	<%
	
		MemberDAO dao = MemberDAO.getInstance();
		int re = dao.insertMember(m);
	%>
	
<%= re %>
</body>
</html>