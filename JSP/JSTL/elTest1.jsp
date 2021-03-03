<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어에서 사용되는 데이터들</title>
</head>
<body>
	<h1>표현 언어로 여러 가지 데이터 출력하기</h1>
	\${100}:${100}<br>
	\${"안녕하세요"}: ${"안녕하세요"}<br>
	\${10+1} : ${10+1}<br> 
	\${"10"+1} : ${"10"+1}<br> <!-- 숫자형 문자열 같은경우에는 정수로 바꿔저서 10 +1로 연산이 가능하다 -->
	\${null + 10 } : ${null + 10 }<br><!-- null은 0으로 인식한다.  -->
	<%-- \${"안녕" + 11 } : ${"안녕" + 11} --%><br> <!-- 문자열+정수 시 NumberFormatException에러 발생  -->
	<%-- \${"hello" + "world" } : ${"hello"+"world""} --%><br><!-- 문자열과 문자열은 더할 수 없다.  -->
</body>
</html>