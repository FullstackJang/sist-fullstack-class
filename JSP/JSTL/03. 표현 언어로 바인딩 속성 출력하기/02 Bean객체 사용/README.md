# 빈객체를 활용해 바인딩 속성 출력하기

1. `forward2.jsp`에서 `MemberBean객체`를 생성 후 속성에 회원 정보를 설정한다. 

```jsp
    <%
        request.setCharacterEncoding("UTF-8");

        /* MemberBean 객체 생성 후 회원 정보를 속성에 설정한다.  */
        MemberBean member = new MemberBean("park","1234","박혜수","park@admin.com");
        /* 속성 이름 member로 MemberBean객체를 바인딩한다.  */
        request.setAttribute("member", member);
    %>
```

2. 바인딩한 속성을 가져와서 출력하기

`member.id`,`member.pwd`,`member.name`,`member.email` member의 속성에 바로 접근해서 값을 출력할 수 있다.
```jsp
	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>

		<!-- 바인딩 시 속성 이름으로 각각의 MemberBean 속성에 접근하여 회원 정보를 출력한다.  -->		
		<tr align="center">
			<td>${member.id }</td>
			<td>${member.pwd }</td>
			<td>${member.name }</td>
			<td>${member.email }</td>
		</tr>
	</table>
```

<img src ="https://user-images.githubusercontent.com/69107255/107856660-f8863380-6e6c-11eb-951e-d00936d75960.png"> 