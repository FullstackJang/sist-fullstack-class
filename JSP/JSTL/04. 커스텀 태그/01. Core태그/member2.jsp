<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    
    <jsp:useBean id="membersList" class="java.util.ArrayList"/>
    <jsp:useBean id="membersMap" class="java.util.HashMap"/>
    
	<%
		membersMap.put("id", "park");
		membersMap.put("pwd", "1234");
		membersMap.put("name", "박혜수");
		membersMap.put("email", "park@admin.com");
		MemberBean m1 = new MemberBean("ryu","1234","류수정","ryu@admin.com");
		MemberBean m2 = new MemberBean("lee","4321","이미주","lee@admin.com");
		
		membersList.add(m1);
		membersList.add(m2);
		membersMap.put("membersList", membersList);
	%>
	<!-- <c:set>태그를 이용해 HashMap에 저장된 ArrayList에 접근하기 위해 사용하기 편리한 이름으로 설정한다. -->
	<c:set var="membersList" value="${membersMap.membersList }"/>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 


	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		
		<tr align="center">
			<td>${membersMap.id }</td>
			<td>${membersMap.pwd }</td>
			<td>${membersMap.name }</td>
			<td>${membersMap.email }</td>
		</tr>
		
		
		<tr align="center">
			<td>${membersList[0].id }</td>
			<td>${membersList[0].pwd }</td>
			<td>${membersList[0].name }</td>
			<td>${membersList[0].email }</td>
		</tr>
		
		<tr align="center">
			<td>${membersList[1].id }</td>
			<td>${membersList[1].pwd }</td>
			<td>${membersList[1].name }</td>
			<td>${membersList[1].email }</td>
		</tr>
	</table>
	
	

</body>
</html>