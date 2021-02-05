
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

 <*jsp:include*> 은 second.jsp의 서블릿을 만들어서 include된다.

```jsp	
<jsp:include page="second.jsp"/>
```
<img src= "https://user-images.githubusercontent.com/69107255/106852375-4c6d7b80-66fb-11eb-8886-d273b636e183.png">

# ActionTag에 include 와 Directivetag include 차이

|구분|include 액션태그|include 디렉티브 태그|
|----|----|----|
|처리시간|요청시 자원을 포함한다|번역 시 자원을 포함한다|
|데이터 전달 방법|request 기본 내장 객체나 param 액션 태그를 이용하여 파라미터를 전달한다.| 페이지 내의 변수를 선언한 후 변수에 값을 저장한다.|
|용도|화면 레이아웃의 일부분을 모듈화할 때 주로 사용한다.|다수의 JSP웹 페이지에서 공통으로 사용되는 코드나 저작권과 같은 문장을 포함하는 경우에 사용|
|기타|동적페이지에 사용한다.|정적 페이지에 사용한다.|