
`login.jsp`에서는 `아이디`와`비밀번호`를 입력받아 `result.jsp`로 전송합니다.

**login.jsp**
```jsp
	<form action="result.jsp" method="post">
		아이디 : <input type="text" name="userID"><br>
		비밀번호 : <input type="password" name="userPw"><br>
			<input type="submit" value="로그인">
			<input type="reset" value="다시입력">
	</form>
```

`result.jsp`에서는 `userID`가 0일 경우에 `msg변수`에 있는 값을 <*jsp:forward*>에 param함수를 통해서 `login.jsp`로 전달하여 아이디와 비밀번호 입력 경고 메시지를 전달합니다.
userID값이 0이 아닐 경우에는 <*h1*>태그요소가 출력됩니다.

**result.jsp**
```jsp
	<%!
		String msg = "아이디를 입력하지 않았습니다. 아이디를 입력해주세요.";
	%>


	<%
		String userID = request.getParameter("userID");
		if(userID.length() == 0){
			
	%>
		<jsp:forward page="login.jsp">
			<jsp:param value="<%=msg %>" name="msg"></jsp:param>
		</jsp:forward>
	<%
		}
	%>
	
	<h1>환영합니다 <%= userID %>님!!</h1>
```

**login.jsp 입력 화면**
<img src ="https://user-images.githubusercontent.com/69107255/107794055-51d16280-6d9a-11eb-86a1-f18c539649a2.png">


## userID에 length길이가 0일 경우 

<img src ="https://user-images.githubusercontent.com/69107255/107793775-0a4ad680-6d9a-11eb-93ba-7bf286b76b3b.png">

## userID에 length가 0이 아닐 경우

<img src ="https://user-images.githubusercontent.com/69107255/107793993-3f572900-6d9a-11eb-88fb-f8b5ca17b751.png">