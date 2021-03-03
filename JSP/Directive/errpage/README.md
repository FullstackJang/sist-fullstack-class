
# JSP 페이지 예외 처리 과정
- JSP 예외 처리 페이지 만드는 과정

1. 예외 처리 담당 JSP를 만든다.
```jsp
	<%@ page isErrorPage='true' %>
```

2. 예외 발생 시 예외처리 담당 JSP파일을 지정한다.
```jsp
	<%@ page errorPage='joinException.jsp'%>
```
- 예외 처리 과정
<img src= "https://user-images.githubusercontent.com/69107255/107772766-05792900-6d80-11eb-98ca-4cc8dbe80345.png">


## 1. 사용자가 정상적인 값이 아닌 값으로 요청할 때 에러가 발생하게 되는데 

<img src ="https://user-images.githubusercontent.com/69107255/106826664-b3267100-66ca-11eb-8ca1-a10bc6cca712.png">

```java
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
```

## 2. age변수에 정수가 들어와야하지만 `스물아홉살`이라는 문자열을 전달 하였습니다.

<img src ="https://user-images.githubusercontent.com/69107255/106827060-773fdb80-66cb-11eb-9026-55d5a845df97.png">


## 3.`정수`가 아닌 `문자열`이 전달이 되기 때문에 오류가 발생하게 된다.

<img src="https://user-images.githubusercontent.com/69107255/107767131-dc549a80-6d77-11eb-8a0f-6a6edab22f6a.png">

## 4. 정수를 문자처리할 시 예외가 발생하게 된다. 다음과 같이 `예외 처리 페이지`에서 예외를 처리한다.
<img src="https://user-images.githubusercontent.com/69107255/107771201-c1852480-6d7d-11eb-9ece-b2e638a76f0f.png">


# 에러 코드에 따른 예외 페이지 지정
> 전체 JSP 페이지에 대해 발생하는 오류에 따라서 화면에 표시되는 각각의 예외 처리 JSP 페이지를 지정함

`404Error`와`500Error`는 웹어플리케이션에서 자주 발생하기 때문에 일일히 웹페이지에서 예외처리페이지를 지정해서 사용하기 보다는 **web.xml**에 등록해서 사용하면 편리하다.

## web.xml에 지정 방법
> 
- web.xml
```jsp
	<error-page>
		<error-code>에러코드</error-code>
		<location>오류 페이지 위치</location>
	</error-page>
```

## 1. WebContent 하위에 오류 페이지들이 위치할 err폴더를 만들고 err_404.jsp, error_505.jsp 파일을 준비한다.
<img src ="https://user-images.githubusercontent.com/69107255/107773833-913f8500-6d81-11eb-804e-ab3fbf498b3d.png">

## 2. `web.xml`에 `<error-page>태그`를 이용해 각각의 에러 코드에 대해 처리할 오류 페이지가 있는 경로를 지정한다.
<img src ="https://user-images.githubusercontent.com/69107255/107774323-3195a980-6d82-11eb-9af9-3a5e33c603c0.png">

## 3. `404Error`를 처리하는 JSP페이지인 `error_404.jsp`를 작성한다.
<img src ="https://user-images.githubusercontent.com/69107255/107774517-70c3fa80-6d82-11eb-8ebd-c84d80579149.png">


## 4.  `500Error`를 처리하는 JSP페이지인 `error_500.jsp`를 작성한다.

<img src ="https://user-images.githubusercontent.com/69107255/107774792-d3b59180-6d82-11eb-8854-b35e3cb33f8b.png">


## 6. 존재하지 않는 경로인 `joinOK1.jsp`를 지정하여 예외를 발생 시켜 보겠습니다.
<img src ="https://user-images.githubusercontent.com/69107255/107778432-6a844d00-6d87-11eb-81ce-28f8d09770e9.png">

## 7. 실행 중 예외를 발생시키는 
> 만약 한개의 JSP페이지에 페이지 디렉티브의 errorPage속성과 web.xml이 같이 지정되어 있으면 `페이지 디렉티브`의 `errorPage`가 **우선적으로 나타납니다.**
<img src="https://user-images.githubusercontent.com/69107255/107778639-a7e8da80-6d87-11eb-8045-5ce9216087b3.png">