# Core태그 라이브러리 사용

Core태그 라이브러리 기능

- 자바로 구현한 `변수 선언`, `조건식`, `반복문` 기능들을 태그로 대체한다
- 사용 전 반드시 taglib 디렉티브 태그를 선언해야 한다.
    - <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

여러 가지 Core 태그 라이브러리 기능

|기능|태그|설명|
|변수지원|<c:set>|JSP페이지에서 변수를 지정한다.|
||<c:remove>|지정된 변수를 제거한다.|
|흐름 제어|<c:if>|조건문을 사용한다.|
||<c:choose>|switch문을 사용한다.<br><c:when>과 <c:otherwise> 서브 태그를 갖는다.|
||<c:forTokens>|구분자로 분리된 각각의 토큰을 처리할 때 사용한다.|
|URL 처리|<c:import>|URL을 이용해 다른 자원을 JSP페이지에 추가한다.|
||<c:redirect>|response.sendRedirect()기능을 수행한다.|
|기타 태그|<c:catch>|예외 처리에 사용한다.|
||<c:out>|JspWriter에 내용을 처리한 후 출력한다.|

**<c:set>형식**
```jsp
    <c:set var="변수이름" value="변수 값" [scope="scope속성 중 하나"] /> 

    - var: 사용할 변수 이름
    - value: 변수에 저장할 값
    - scope: 접근 범위(page,request,session,application 중 하나)
```

# <c:set> 태그를 이용한 실습

- 사용 전 반드시 taglib 디렉티브 태그를 선언해야 한다.
    - <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


## 1. <c:set> 태그를 이용해 변수를 선언한다.
> value 속성에는 표현 언어를 사용해서 초기화 할 수 있다. 

`value="hong"`처럼 값을 자바언어를 사용해 지정할 수 도 있고, `value="${'홍길동' }"`표현 언어를 사용해서 선언할 수 도 있다.

```jsp
		<c:set var="id" value="hong" scope="page" />
		<c:set var="pwd" value="1234" scope="page"/>
    	<c:set var="name" value="${'홍길동' }" scope="page"  />
    	<c:set var="age" value="${ 21 }" scope="page"/>
    	<c:set var="height" value="${ 180 }" scope="page"  />
```

## 2.

```jsp
	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>나이</b></td>
			<td width="20%"><b>키</b></td>
		</tr>
		
    <!-- 표현 언어로 바로 접근하여 값을 출력한다.  -->
		<tr align="center">
			<td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${age }</td>
			<td>${height }</td>
		</tr>
	</table>
```

<img src ="https://user-images.githubusercontent.com/69107255/107867950-fd75d200-6ec2-11eb-94a0-a8454064f2a9.png">

# 