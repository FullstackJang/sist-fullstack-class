<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
	
	<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
	<!-- 회원 가입창에서 전송된 회원 정보를 빈 속성에 설정한다.  -->
	<jsp:setProperty property="*" name="m1"/>
	<!-- mebmersList로 ArrayList객체를 생성한다.  -->
	<jsp:useBean id="membersList" class="java.util.ArrayList"/>
	
	<%
		/* 자바 코드로 새로운 회원 정보를 저장하는 MemberBean 객체를 생성한다.  */
		MemberBean m2 = new MemberBean("ryu","1234","류수정","ryu@admin.com");
	
		/* 두 개의 membersList 객체를 ArrayList에 저장한다.  */
		membersList.add(m1);
		membersList.add(m2);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>

	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		
		<!-- 인덱스가 0이므로 첫 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
		</tr>
		
		<!-- 인덱스가 1이므로 두 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${membersList[1].id}</td>
			<td>${membersList[1].pwd}</td>
			<td>${membersList[1].name}</td>
			<td>${membersList[1].email}</td>
		</tr>
	</table>



</body>
</html>