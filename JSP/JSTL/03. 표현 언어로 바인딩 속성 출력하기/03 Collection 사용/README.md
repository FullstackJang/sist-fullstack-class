# ArrayList객체를 활용해 바인딩 속성 출력하기

`request`에 회원 정보를 저장한 ArrayList를 바인딩하고 출력해보자

1. 

```jsp
<%
	request.setCharacterEncoding("UTF-8");

	List membersList = new ArrayList();
	MemberBean m1 = new MemberBean("lee","1234","이미주","lee@admin.com");
	MemberBean m2 = new MemberBean("son","1234","손흥민","son@admin.com");
	
	membersList.add(m1);
	membersList.add(m2);
	
	request.setAttribute("membersList", membersList);
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


		<!-- 표현 언어에서 속성 이름으로 ArrayList에 접근한 후 인덱스를 이용해 첫 번째 회원정보를 출력한다.  -->		
		<tr align="center">
			<td>${membersList[0].id }</td>
			<td>${membersList[0].pwd }</td>
			<td>${membersList[0].name }</td>
			<td>${membersList[0].email }</td>
		</tr>

		<!-- 표현 언어에서 속성 이름으로 ArrayList에 접근한 후 인덱스를 이용해 두 번째 회원정보를 출력한다.  -->		
		<tr align="center">
			<td>${membersList[1].id }</td>
			<td>${membersList[1].pwd }</td>
			<td>${membersList[1].name }</td>
			<td>${membersList[1].email }</td>
		</tr>
	</table>
```

<img src ="https://user-images.githubusercontent.com/69107255/107857014-28363b00-6e6f-11eb-8b83-59fcceacf3cb.png"> 