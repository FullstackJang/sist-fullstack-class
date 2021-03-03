<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    	
    	/* 각 내장 객체에 바인딩된 속성 값들을 getAttribute()메서드를 통해 가져온다.  */
    	String id = (String)request.getAttribute("id");
    	String pwd = (String)request.getAttribute("pwd");
    	String name = (String)request.getAttribute("name");
    	String email = (String)request.getAttribute("email");
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
		<!-- 표현식으로 출력  -->
		<tr align="center">
			<td><%= id %></td>
			<td><%= pwd %></td>
			<td><%= name %></td>
			<td><%= email %></td>
		</tr>
		
		<!-- 자바코드 없이 바로 바인딩된 속성 이름으로 회원 정보를 출력한다.-->
		
		<tr align="center">
			<td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${email }</td>
		</tr>
	</table>


</body>
</html>