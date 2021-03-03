# 표현 언어에서 제공하는 내장 객체의 종류와 기능

## 표현 언어에서 제공하는 여러 가지 내장 객체

|구분|내장 객체|설명|
|----|----|---|
|스코프|pageScope|JSP의 page와 같은 기능을 하고 page 영역에 바인딩된 객체를 참조한다.|
||requestScope|JSP의 request와 같은 기능을 하고 request에 바인딩된 객체를 참조한다.|
||sessionScope|JSP의 application과 같은 기능을 하고 application에 바인딩된 객체를 참조한다.|
|요청 매개변수|param|request.getParameter()메서드를 호출한 것과 같으며 한 개의 값을 전달하는 요청 매개변수를 처리한다.|
||paramValues|request.getParameterValues()메서드를 호출한 것과 같으며 여러 개의 값을 전달하는 요청 매개변수를 처리한다.|
|헤더 값|header|request.getHeader()메서드를 호출한 것과 같으며 요청 헤더 이름의 정보를 단일 값으로 반환한다.|
||headerValues|request.getHeader()메서드를 호출한 것과 같으며 요청 헤더 이름의 정보를 배열로 반환한다.|
|쿠키 값|Cookies|쿠키 이름의 값을 반환한다.|
|JSP 내용|pageContext|pageContext 객체를 참조할 때 사용한다.|
|초기 매개변수|initParam|Context의 초기화 매개변수 이름의 값을 반환한다.| 

# param 내장 객체 사용

## 1. input 작성

**memberForm.jsp**

```jsp
	<form action="member1.jsp" method="post">
		<table align="center">
				<tr>
					<td width="200"><p align="right">아이디</td>
					<td width="400"><input type="text" name="id"></td>
				</tr>
				<tr>
					<td width="200"><p align="right">비밀번호</td>
					<td width="400"><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td width="200"><p align="right">이름</td>
					<td width="400"><input type="text" name="name"></td>
				</tr>
				<tr>
					<td width="200"><p align="right">이메일</td>
					<td width="400"><input type="text" name="email"></td>
				</tr>
				<tr>
					<td width="200"><p>&nbsp;</p></td>
					<td width="400">
					<input type="submit" value="제출">
					<input type="reset" value="다시입력"></td>
				</tr>
		</table>
	</form>
```

<img src ="https://user-images.githubusercontent.com/69107255/107847998-a543bf00-6e33-11eb-80f9-da8b3613024e.png">

## 2. member1.jsp를 작성

```jsp
<%
    /* 회원 정보를 표시하기 전에 한글 인코딩을 설정한다. */
	request.setCharacterEncoding("UTF-8");

    
    /* 표현식을 출력하기 위해 getParameter()메서드를 이용해 회원정보를 가져온다. */
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
%>

	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		<!-- getParameter()로 가져온 회원 정보를 표현식으로 출력 -->
		<tr align="center">
			<td><%= id %></td>
			<td><%= pwd %></td>
			<td><%= name %></td>
			<td><%= email %></td>
		</tr>
		
		<!-- param 객체를 이용해 getParameter() 메서드를 이용하지 않고 바로 회원 정보를 출력 -->
		
		<tr align="center">
			<td>${param.id }</td>
			<td>${param.pwd }</td>
			<td>${param.name }</td>
			<td>${param.email }</td>
		</tr>
	</table>
```
첫번째 행은 `표현식`으로 출력이 된거고
두번째 행은 `param내장객체`를 사용해서 출력이 된 것이다.

<img src="https://user-images.githubusercontent.com/69107255/107848014-bdb3d980-6e33-11eb-8627-66441d966fd0.png">


# requestScope 사용

## 1. **memberForm.jsp**를 통해서 **forward.jsp**로 전송한다.

**memberForm.jsp**

<img src ="https://user-images.githubusercontent.com/69107255/107848417-a4f8f300-6e36-11eb-9925-84c88aca9807.png">


## 2. **forward.jsp**를 작성한다. 

```jsp
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
```

## 3. **requestScope**를 이용해 바인딩된 `주소 정보 출력`

**member2.jsp**
```jsp
	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
			<td width="20%"><b>주소</b></td>
		</tr>
		
		<tr align="center">
			<td>${param.id }</td>
			<td>${param.pwd }</td>
			<td>${param.name }</td>
			<td>${param.email }</td>
            
            <!-- requestScope를 이용해 바인딩된 주소 정보를 출력한다  -->
			<td>${requestScope.address }</td> 
		</tr>
	</table>
```

<img src ="https://user-images.githubusercontent.com/69107255/107848728-30738380-6e39-11eb-89a6-962a8f6ff217.png">


# pageContext객체 사용

## 1. request.getContextPath() 이용해 컨텍스트 이름 가져오기
**login.jsp**
```jsp
	<a href="<%= request.getContextPath() %>/pageContext/memberForm.jsp">회원가입하기</a>
```

<img src= "https://user-images.githubusercontent.com/69107255/107849132-8269d880-6e3c-11eb-87c1-45777e110705.png">

## 2. request.getContextPath() 출력해보기

**memberForm.jsp**

```jsp
    <%=request.getContextPath()  %>
```

<img src ="https://user-images.githubusercontent.com/69107255/107849199-09b74c00-6e3d-11eb-876b-373936726fab.png">

# 빈 사용

**빈 속성 접근 방법**
```jsp
    ${빈이름.속성이름}
```

## 1. `memberForm.jsp`의 action 값을 `member3.jsp`로 설정

**memberForm.jsp.jsp**

```jsp
	<form action="member3.jsp" method="post">
```

<img src ="https://user-images.githubusercontent.com/69107255/107849557-6ca9e280-6e3f-11eb-938b-250249a60931.png">

## 2. 빈 생성 및 속성 설정

**member3.jsp**
```jsp
	<!-- 1. 회원 정보를 저장할 빈을 생성한다. -->
	<jsp:useBean id="m" class="sec01.ex01.MemberBean" />
    <!-- 2. 전송된 회원 정보를 빈의 속성에 솔정한다. -->
	<jsp:setProperty property="*" name="m"/>
	
	
	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		<!-- 자바 코드로 표현식을 이용해 회원 정보 출력  -->
		<tr align="center">
			<td><%= m.getId() %></td>
			<td><%= m.getPwd() %></td>
			<td><%= m.getName() %></td>
			<td><%= m.getEmail() %></td>
		</tr>
		
		<!-- 빈 id속성 이름으로 접근해 회원 정보 출력 -->
        <!-- 표현언어에서는 빈에 속성명으로 바로 접근해서 값을 가져 올 수 있다. -->
		<tr align="center">
			<td>${ m.id }</td>
			<td>${ m.pwd }</td>
			<td>${ m.name }</td>
			<td>${ m.email }</td>
```
첫번째 행은 `자바 코드로 표현식을 이용해 회원정보`를 출력한 것이고,<br>
두번째 행은 `빈 id속성 이름으로 접근해 회원 정보`를 출력한 것이다.
<img src ="https://user-images.githubusercontent.com/69107255/107849581-96fba000-6e3f-11eb-9ef9-c923a9490bf4.png">

# Collection 객체 사용

**Collection 객체 접근 형식**
```jsp
    ${Collection객체이름[index].속성이름}
    
    index: Collection에 저장된 순서
```

## 1. `memberForm.jsp`의 action 값을 `member4.jsp`로 설정

```jsp
	<form action="member4.jsp" method="post">
```
<img src ="https://user-images.githubusercontent.com/69107255/107850078-176fd000-6e43-11eb-961f-f23f57f25e61.png">

## 2.  MemberBean과 ArrayList 생성 및 설정

**member4.jsp**
```jsp
	<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
	<!-- 회원 가입창에서 전송된 회원 정보를 빈 속성에 설정한다.  -->
	<jsp:setProperty property="*" name="m1"/>
	<!-- mebmersList로 ArrayList객체를 생성한다.  -->
	<jsp:useBean id="membersList" class="java.util.ArrayList"/>
	
	<%
		/* 자바 코드로 새로운 회원 정보를 저장하는 MemberBean 객체를 생성한다.  */
		MemberBean m2 = new MemberBean("ryu","1234","류수정","ryu@admin.com");
	
		/* 두 개의 membersList 객체를 ArrayList에 저장한다.  */
		membersList.add(m1);
		membersList.add(m2);
	%>
```

## 3. membersList에 저장된 회원 정보 출력

**member4.jsp**
```jsp
	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		
		<!-- 인덱스가 0이므로 첫 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
		</tr>
		
		<!-- 인덱스가 1이므로 두 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${membersList[1].id}</td>
			<td>${membersList[1].pwd}</td>
			<td>${membersList[1].name}</td>
			<td>${membersList[1].email}</td>
		</tr>
	</table>
``` 

<img src ="https://user-images.githubusercontent.com/69107255/107850091-2f475400-6e43-11eb-9da3-d02af634270a.png">


# HashMap 사용

**HashMap에 저장된 객체에 접근하는 방법**
```
    ${HashMap객체이름.키이름}
```

## 1. `memberForm.jsp`의 action 값을 `member5.jsp`로 설정

```jsp
	<form action="member4.jsp" method="post">
```

## 2. HashMap과 ArrayList객체를 생성 및 속성 설정

**member5.jsp**

```jsp
	<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
	<!-- 회원 가입창에서 전송된 회원 정보를 빈 속성에 설정한다.  -->
	<jsp:setProperty property="*" name="m1"/>
	<!-- mebmersList로 ArrayList객체를 생성한다.  -->
	<jsp:useBean id="membersList" class="java.util.ArrayList"/>
	
		<!-- 회원 정보를 지정할 HashMap 객체를 <useBean>액션 태그를 이용해 생성 membersMap로 HashMap객체를 생성한다.  -->
	<jsp:useBean id="membersMap" class="java.util.HashMap"></jsp:useBean>
	
	<%
		/* HashMap에 key/value 쌍으로 회원 정보를 저장한다.  */
		membersMap.put("id", "ryu");
		membersMap.put("pwd", "1234");
		membersMap.put("name", "류수정");
		membersMap.put("email", "ryu@admin.com");

		/* 회원 정보를 저장하는 MebmerBean객체를 생성한다.  */
		MemberBean m2 = new MemberBean("hong","1234","홍길동","hong@admin.com");
		
		/* 전송된 회원 정보와 자바 코드로 생성한 회원 정보를 ArrayList에 저장한다. */
		membersList.add(m1);
		membersList.add(m2);
		
		/* 회원 정보가 저장된 memberList를 memberList라는 key로 HashMap에 저장한다.  */
		membersMap.put("membersList", membersList);
		
	%>
```

## 3. HashMap에 저장된 정보를 출력

**member5.jsp**

```jsp
	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		
		<!--  HashMap 이름 뒤에 .(마침표) 연산자로 저장 시 사용한 key를 사용하여 value를 가져온다. -->
		<tr align="center">
			<td>${membersMap.id}</td>
			<td>${membersMap.pwd}</td>
			<td>${membersMap.name}</td>
			<td>${membersMap.email}</td>
			
		</tr>
		
		<!-- HashMap에 저장된 ArrayList에 .(마침표)로 접근한 후 다시 각각의 속성에 .(마침표)를 이용해 접근하여 첫 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
		</tr>
		
		<!-- ArrayList에 저장된 두 번째 회원 정보를 출력한다.  -->
		<tr align="center">
			<td>${membersMap.membersList[1].id}</td>
			<td>${membersMap.membersList[1].pwd}</td>
			<td>${membersMap.membersList[1].name}</td>
			<td>${membersMap.membersList[1].email}</td>
		</tr>		
	</table>
```

# has-a 관계 빈

**has-a 관계 빈 속성 접근 방법**
```jsp
    ${부모빈이름.자식속성이름.속성이름}
```

## 1. sec01.ex02 패키지를 만든 후 `MemberBean클래스`와 Address클래스`를 만든다.

<img src ="https://user-images.githubusercontent.com/69107255/107850521-5d7a6300-6e46-11eb-8b4a-88736856c540.png">


## 2. `MemberBean클래스`에 Address타입에 addr 참조변수를 추가한다.

**MemberBean.java**

<img src ="https://user-images.githubusercontent.com/69107255/107850607-f7daa680-6e46-11eb-9197-525df962754e.png">

## 3. `거주 도시`와`우편번호`를 저장하는 자식 클래스 `Address클래스`를 작성한다.

**Address.java**

<img src="https://user-images.githubusercontent.com/69107255/107850646-4ab45e00-6e47-11eb-8cd3-1664c36bbf3d.png">

## 4. `memberForm.jsp` action 값을 member6.jsp로 설정한다.


```jsp
	<form action="member6.jsp" method="post">
```

## 5.

```jsp
    
	<jsp:useBean id="m" class="sec01.ex02.MemberBean" />
	<jsp:setProperty property="*" name="m"/> 
	
	<jsp:useBean id="addr" class="sec01.ex02.Address" />
	<jsp:setProperty property="city" name="addr" value="서울"/>
	<jsp:setProperty property="zipcode" name="addr" value="07654"/>
	
	<%
		m.setAddr(addr);
	%>   
```

## 6.
```jsp

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
		

		<tr align="center">
			<td>${ m.id }</td>
			<td>${ m.pwd }</td>
			<td>${ m.name }</td>
			<td>${ m.email }</td>
			<!-- 속성들의 getter를 두 번 호출해서 주소를 출력한다.  -->
			<td><%= m.getAddr().getCity() %></td>
			<td><%= m.getAddr().getZipcode() %></td>
		</tr>
		
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
```

<img src ="https://user-images.githubusercontent.com/69107255/107853395-0e89f900-6e59-11eb-9977-e6056f0b8521.png">