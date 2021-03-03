<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	session.setAttribute("address", "서울시 강남구");
%>
<body>

	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="5%"><b>이름</b></td>
			<td width="5%"><b>이메일</b></td>
			<td width="5%"><b>주소</b></td>
		</tr>


		<!-- 표현 언어에서 속성 이름으로 ArrayList에 접근한 후 인덱스를 이용해 첫 번째 회원정보를 출력한다.  -->		
		<tr align="center">
			<td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${email }</td>
			<td>${address }</td>
			
		</tr>
		
	</table>


</body>
</html>