<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	/* MemberBean 객체 생성 후 회원 정보를 속성에 설정한다.  */
	MemberBean member = new MemberBean("park","1234","박혜수","park@admin.com");
	/* 속성 이름 member로 MemberBean객체를 바인딩한다.  */
	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward2</title>
</head>
<body>

	<jsp:forward page="member2.jsp"></jsp:forward>

</body>
</html>