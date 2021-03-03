<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%-- 리다이렉트할 페이지를 설정한다. --%>
    <c:redirect url="/test01/member1.jsp">
    <%-- 리다이렉트할 페이지로 전달할 매개변수를 설정한다. --%>
    	<c:param name="id" value="${'hong' }"/>
    	<c:param name="pwd" value="${'1234' }"/>
    	<c:param name="name" value="${'홍길동' }"/>
    	<c:param name="email" value="${'hong@admin.com' }"/>
    </c:redirect>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect</title>
</head>
<body>	

</body>
</html>