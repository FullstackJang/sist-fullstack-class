<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    %>
    
	<jsp:useBean id="m" class="sec01.ex02.MemberBean" />
	<jsp:setProperty property="*" name="m"/> 
	
	<jsp:useBean id="addr" class="sec01.ex02.Address" />
	<jsp:setProperty property="city" name="addr" value="서울"/>
	<jsp:setProperty property="zipcode" name="addr" value="07654"/>
	
	<%
		m.setAddr(addr);
	%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>

	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
				<td width="5%"><b>도시</b></td>
				<td width="5%"><b>우편번호</b></td>
		</tr>
		
		<%
			m.setAddr(addr);
		%>
		
		<!-- 인덱스가 0이므로 첫 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${ m.id }</td>
			<td>${ m.pwd }</td>
			<td>${ m.name }</td>
			<td>${ m.email }</td>
			<!-- 속성들의 getter를 두 번 호출해서 주소를 출력한다.  -->
			<td><%= m.getAddr().getCity() %></td>
			<td><%= m.getAddr().getZipcode() %></td>
		</tr>
		
		<!-- 인덱스가 1이므로 두 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${m.id }</td>
			<td>${m.pwd }</td>
			<td>${m.name }</td>
			<td>${m.email }</td>
			<!-- 자바 빈의 속성 이름과 .(마침표)연산자를 이용해 주소를 출력한다.  -->
			<td>${m.addr.city }</td>
			<td>${m.addr.zipcode }</td>
		</tr>
	</table>
	
</body>
</html>