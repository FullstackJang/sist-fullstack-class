<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	/*회원 가입창의 request에 대해 다시 주소 정보를 바인딩한다.  */
	request.setAttribute("address", "인천시 계양구");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
	<!-- member2.jsp로 포워딩한다.  -->
	<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>