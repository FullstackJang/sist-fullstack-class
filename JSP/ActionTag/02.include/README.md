# include 액션 태그

**include 액션 태그 형식**
```jsp
<jsp:include page="jsp페이지" flush="true 또는 false">
...
<jsp:include>
```
- page : 포함할 JSP페이지명
- flush : 지정한 JSP를 실행하기 전 출력 버퍼 비움 여부 지정

# 인클루드 액션 태그 처리 과정
<img src ="https://user-images.githubusercontent.com/69107255/107783843-0add7000-6d8e-11eb-8d6f-daa023ba4fa4.png">

1. 브라우저 요청 시 `JSP파일을 컴파일` 한다.
2. 컴파일 시 `<*jsp:include*>가 지시하는 JSP`를 **요청**한다.
3. `요청된 JSP를 컴파`일 한다.
4. 컴파일된 JSP가 응답을 보낸다.
5. JSP는 브라우저에서 요청한 응답 결과를 출력한다.


# 인클루드 액션 태그는 `param 액션 태그`를 이용해 동적 처리 가능

## user_image.jsp

```jsp
<body>
<br><br>
	<h1>이름은 <%= name %>입니다.</h1> <br><br>
	
	<img src="<%= imgName %>">
</body>
```

## include1.jsp

```jsp
<body>
	안녕하세요. 쇼핑몰 중심 JSP 시작입니다.!!
	<br>
	
	<jsp:include page="user_image.jsp" flush="true">
		<jsp:param value="네모" name="name"/>
		<jsp:param value="square.png" name="imgName"/>
	</jsp:include>
	<br>
	안녕하세요. 쇼핑몰 중심 JSP 끝 부분입니다.
</body>
```
<img src ="https://user-images.githubusercontent.com/69107255/107790196-da013900-6d95-11eb-9050-2738019b4b66.png">

## include2.jsp
```jsp
<body>

	안녕하세요. 쇼핑몰 중심 JSP 시작입니다.!!
	<br>
	
	<jsp:include page="user_image.jsp" flush="true">
		<jsp:param value="동그라미" name="name"/>
		<jsp:param value="circle.png" name="imgName"/>
	</jsp:include>
	<br>
	안녕하세요. 쇼핑몰 중심 JSP 끝 부분입니다.
</body>
```

<img src ="https://user-images.githubusercontent.com/69107255/107790263-eeddcc80-6d95-11eb-865e-e47d181a0116.png">


형관펜 영역은 `include2.jsp`의 내용이고 include이후에 내용도 출력이 되는것을 확인 할 수 있다.
<img src ="https://user-images.githubusercontent.com/69107255/107790355-087f1400-6d96-11eb-97f9-1d93e81bff08.png">

<hr>

## <*jsp:include*> 은 include2.jsp의 서블릿을 만들어서 include된다.

```jsp	
<jsp:include page="include2.jsp"/>
```
<img src= "https://user-images.githubusercontent.com/69107255/106852375-4c6d7b80-66fb-11eb-8886-d273b636e183.png">

# ActionTag에 include 와 Directivetag include 차이

|항목|include 액션태그|include 디렉티브 태그|
|----|----|----|
|기능|JSP 레이아웃 모듈화|JSP 레이아웃 모듈화|
|처리시간|요청 시간에 처리|JSP를 자바 코드로 변환 시 처리|
|데이터 처리 방법|param 액션 태그를 이용해 동적 처리 가능 | 정적 처리만 가능|
|포함된 JSP 자바 파일 변환 여부 | 포함되는 JSP가 각각 자바 파일로 생성|포함되는 JSP가 포함하는 JSP에 합쳐진 후 한개의 자바 파일로 생성|