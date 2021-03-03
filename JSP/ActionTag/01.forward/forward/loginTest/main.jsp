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
		String member = (String)session.getAttribute("member");	
		
		if(member == null){
			response.sendRedirect("login.html");
			out.print("<script>");
			out.print("alert('로그인하세요.')");
			out.print("</script>");
		}

		else{
	%>
			
	서비스되는 문서입니다.
	<br>
		
		<%
	}
	
	%>
</body>
</html>