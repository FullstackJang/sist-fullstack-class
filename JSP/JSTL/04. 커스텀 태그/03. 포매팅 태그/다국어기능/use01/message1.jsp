<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <fmt>태그를 사용하기 전에 반드시 설정해야 한다.  --%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<%--
		locale을 영어로 지정한다.
		<fmt:setLocale value="en_US" />
	 --%>
		<%-- locale을 한글로 지정한다.--%>
		
		<fmt:setLocale value="ko_KR"/>	
	
	<h1>회원정보
	<%--  resource 패키지 아래 member 프로퍼티 파일을 읽어온다.  --%>
	<fmt:bundle basename="resource.member.properties">
		<%--  <fmt:message> 태그의 key 속성에 프로퍼티 파일의 key를 지정하여 값(value)을 출력한다.  --%>
		이름 <fmt:message key="mem.name" /><br>
		주소: <fmt:message key="mem.address" /><br>
		직업: <fmt:message key="mem.job" /><br>
	</fmt:bundle>
	<br><br></h1>
	
</body>
</html>