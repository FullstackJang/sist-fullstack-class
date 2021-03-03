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
	
		<!-- 회원 정보를 지정할 HashMap 객체를 <useBean>액션 태그를 이용해 생성 membersMap로 HashMap객체를 생성한다.  -->
	<jsp:useBean id="membersMap" class="java.util.HashMap"></jsp:useBean>
	
	<%
		/* HashMap에 key/value 쌍으로 회원 정보를 저장한다.  */
		membersMap.put("id", "ryu");
		membersMap.put("pwd", "1234");
		membersMap.put("name", "류수정");
		membersMap.put("email", "ryu@admin.com");

		/* 회원 정보를 저장하는 MebmerBean객체를 생성한다.  */
		MemberBean m2 = new MemberBean("hong","1234","홍길동","hong@admin.com");
		
		/* 전송된 회원 정보와 자바 코드로 생성한 회원 정보를 ArrayList에 저장한다. */
		membersList.add(m1);
		membersList.add(m2);
		
		/* 회원 정보가 저장된 memberList를 memberList라는 key로 HashMap에 저장한다.  */
		membersMap.put("membersList", membersList);
		
	%>
	

    
    
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
		
		<!--  HashMap 이름 뒤에 .(마침표) 연산자로 저장 시 사용한 key를 사용하여 value를 가져온다. -->
		<tr align="center">
			<td>${membersMap.id}</td>
			<td>${membersMap.pwd}</td>
			<td>${membersMap.name}</td>
			<td>${membersMap.email}</td>
			
		</tr>
		
		<!-- HashMap에 저장된 ArrayList에 .(마침표)로 접근한 후 다시 각각의 속성에 .(마침표)를 이용해 접근하여 첫 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
		</tr>
		
		<!-- ArrayList에 저장된 두 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${membersMap.membersList[1].id}</td>
			<td>${membersMap.membersList[1].pwd}</td>
			<td>${membersMap.membersList[1].name}</td>
			<td>${membersMap.membersList[1].email}</td>
		</tr>		
	</table>

</body>
</html>