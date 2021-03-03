# 내장 객체 속성 값 출력 실습

1. 첫 번째 JSP인 `forward1.jsp` 작성

```jsp
<%
	request.setCharacterEncoding("UTF-8");

	/* requset 내장 객체에 바인딩한다. */
	request.setAttribute("id", "hong");
	request.setAttribute("pwd", "1234");

    /* session 내장 객체에 바인딩한다. */
	request.setAttribute("name", "홍길동");

    /* application 내장 객체에 바인딩한다. */
	request.setAttribute("email", "hong@admin.com");
%>

    <!--  member1.jsp로 포워딩한다. -->
	<jsp:forward page="member1.jsp" />
```

2. 바인딩한 속성을 가져와서 출력하기

```jsp
    <%
    	request.setCharacterEncoding("UTF-8");
    	
    	/* 각 내장 객체에 바인딩된 속성 값들을 getAttribute()메서드를 통해 가져온다.  */
    	String id = (String)request.getAttribute("id");
    	String pwd = (String)request.getAttribute("pwd");
    	String name = (String)request.getAttribute("name");
    	String email = (String)request.getAttribute("email");
    %>

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

```

<img src ="https://user-images.githubusercontent.com/69107255/107856483-c45e4300-6e6b-11eb-9dac-d235522ca348.png">