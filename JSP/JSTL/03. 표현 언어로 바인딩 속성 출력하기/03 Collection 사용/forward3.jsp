<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("UTF-8");

	List membersList = new ArrayList();
	MemberBean m1 = new MemberBean("lee","1234","이미주","lee@admin.com");
	MemberBean m2 = new MemberBean("son","1234","손흥민","son@admin.com");
	
	membersList.add(m1);
	membersList.add(m2);
	
	request.setAttribute("membersList", membersList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward3</title>
</head>
<body>

	<jsp:forward page="member3.jsp"></jsp:forward>

</body>
</html>