<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
   	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	
    <%-- <c:set>태그 이용해 pageContext 내장 객체의 컨텍스트 이름을 변수 contextPath에 미리 설정한다. --%>
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>

	<form action="result.jsp">
		아이디 : <input type="text" size="20"><br>
		비밀번호 : <input type="password" size="20"><br>
		<input type="submit" value="로그인" /> <input type="reset" value="다시입력" />
	</form>
	<br><br>

	<!-- 경로를 전부 pull path로 작성했기에 불편함이 있었다..  -->
	<%-- <a href="${pageContext.request.contextPath }/memberForm.jsp">회원가입하기</a> --%>
	
		<!-- 긴 내장 객체의 속성을 사용할 필요 없이 간단한 변수이름으로 컨텍스트 이름을 설정한다.   -->
		<a href="${contextPath}/memberForm.jsp">회원가입하기</a>
	
</body>
</html>