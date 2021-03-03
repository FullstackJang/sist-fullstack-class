# <*jsp:param*>

- <*jsp:include*>액션 태그는 <*jsp:param*> 태그를 이용해서 JSP페이지에 파라미터를 추가할 수 있다.

아래 코드와 같이 <*jsp:param*>태그의 사용 형식을 보여주고 있다.

**first.jsp**
```jsp
	<jsp:include page="second.jsp">
		<jsp:param value="SiSt" name="title"/>
		<jsp:param value="2021" name="year"/>
		<jsp:param value="<%= new Date() %>" name="date"/>
	</jsp:include>
```

**second.jsp**
```jsp
	Year : <%= request.getParameter("year") %><br>
	Date : <%= request.getParameter("date") %>
```