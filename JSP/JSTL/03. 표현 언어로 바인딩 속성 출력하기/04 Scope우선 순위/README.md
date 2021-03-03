# SCOPE 우선순위

**forward4.jsp**
```jsp
    <%
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("id", "jang");
        request.setAttribute("pwd", "1234");
        session.setAttribute("name", "장일규");
        application.setAttribute("email", "jang@admin.com");

        /* request에 address 속성 이름으로 바인딩한다.  */
        request.setAttribute("address", "인천시 계양구");
    %>

    	<jsp:forward page="member4.jsp"></jsp:forward>
```

**member4.jsp**
```jsp
    <%
        session.setAttribute("address", "서울시 강남구");
    %>
```
`forward4.jsp`와 `member4.jsp` 둘 다 같은 속성인 `address`속성을 가지고 바인딩을 하였다.
session보다 request가 우선순위가 높기 때문에 **인천시 계양구**가 나오는 것을 확인 할 수 있다.

<img src ="https://user-images.githubusercontent.com/69107255/107857558-36398b00-6e72-11eb-99d6-7909f1889a8e.png">

# 표현언어에서 같은 속성에 대한 우선순위

page > request > session > application