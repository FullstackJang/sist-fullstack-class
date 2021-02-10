
## second.jsp

```jsp
    <body>
        <h3>이 파일은 second.jsp입니다.</h3>
        
        Today is <%= new Date() %>
    </body>

```

## first.jsp

```jsp
    <body>
        <h3>이 파일은 first.jsp입니다.</h3>
        <jsp:include page="second.jsp"/>
        <p>Java Server  Page</p>
    </body>	
```

*<jsp:include*> 은 second.jsp의 서블릿을 만들어서 first.jsp에  
```jsp	
<jsp:include page="second.jsp"/>
```
<img src= "https://user-images.githubusercontent.com/69107255/106852375-4c6d7b80-66fb-11eb-8886-d273b636e183.png">