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

## 2. 표현어로 값 출력

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

# <c:set> 태그로 빈 속성 이름 줄여서 사용하기

**login.jsp**

```js
   <%-- <c:set>태그 이용해 pageContext 내장 객체의 컨텍스트 이름을 변수 contextPath에 미리 설정한다. --%>

    <c:set var="contextPath" value="${pageContext.request.contextPath }" />
```

```html

	<!-- 경로를 전부 pull path로 작성했기에 불편함이 있었다..  -->
	<%-- <a href="${pageContext.request.contextPath }/memberForm.jsp">회원가입하기</a> --%>


	<!-- 긴 내장 객체의 속성을 사용할 필요 없이 간단한 변수이름으로 컨텍스트 이름을 설정한다.   -->
	<a href="${contextPath}/memberForm.jsp">회원가입하기</a>
```

<img src ="https://user-images.githubusercontent.com/69107255/107868220-bb9a5b00-6ec5-11eb-8b62-d2b9f693bb92.png">

<img src ="https://user-images.githubusercontent.com/69107255/107868229-d7056600-6ec5-11eb-802e-c666053b0d87.png">

# <c:remove> 태그를 이용한 실습

**<c:remove> 형식**
```jsp
	<c:remove var="변수 이름" [scope="scope속성 중 하나"] />

	var: 제거할 변수 이름
	value: 변수에 저장한 값
	scope: 접근 범위(page, request, session, application 중 하나)
```
 
## 1. <c:remove/>를 통해 값 삭제
- <c:remove/>를 통해서 `age`값과 `height`값을 삭제했다.

**member3.jsp**

 ```jsp
		<c:set var="id" value="hong" scope="page" />
		<c:set var="pwd" value="1234" scope="page"/>
    	<c:set var="name" value="${'홍길동' }" scope="page"  />
    	<c:set var="age" value="${ 21 }" scope="page"/>
    	<c:set var="height" value="${ 180 }" scope="page"  />
    	<c:remove var="age"/>
    	<c:remove var="height"/>
```

## 2. 값을 출력해보기

표현 언어로 변수 값을 출력해 보았다.
`age`와 `height`값이 <c:remove/> 태그를 이용해 삭제되어 출력되지 않는 것을 확인 할 수 있다.

```jsp
		<tr align="center">
			<td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${age }</td>
			<td>${height }</td>
		</tr>
```

<img src ="https://user-images.githubusercontent.com/69107255/107869512-5a2cb900-6ed2-11eb-9a1d-8742edd68a5f.png">


# <c:if>태그를 이용한 실습

**<c:if>태그**
- 조건문을 대체하는 태그

**<c:if>태그 형식**

```jsp
	<c:if test="${조건식}" var="변수 이름" [scope="scope 속성 중 하나"] />
	...
	</c:if>

	test: 표현 언어를 이용해 수행할 조건식 위치
	var: 조건식의 결과값을 저장
	scope :변수의 접근 범위(page, request, session, application 중 하나)
```


## 1. 변수 선언

- 사용 전 반드시 taglib 디렉티브 태그를 선언해야 한다.
    - <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

**member4.jsp**

```jsp
	<c:set var="id" value="hong" scope="page" />
	<c:set var="pwd" value="1234" scope="page" />
	<c:set var="name" value="${'홍길동' }" scope="page" />
	<c:set var="age" value="${29 }" scope="page" />
	<c:set var="height" value="${180}" scope="page" />
```

```jsp
	<!-- 조건식이 true이므로 항상 참이 나온다. -->
	<c:if test="${true }">
		<h1>항상 참입니다.</h1>
	</c:if>
	
	<!-- 조건식에 비교 연산자를 사용   -->
	<c:if test="${722==722}">
		<h1>두 값은 같습니다.</h1>
	</c:if>
	
	<!-- 조건식에 비교 연산자를 사용 -->
	<c:if test="${10 != 50 }">
		<h1>두 값은 같지 않습니다.</h1>
	</c:if>
	
	<!-- 조건식에 논리 연산자를 사용  -->
	<c:if test="${(id=='hong') || (name == '홍길동')}">
		<h1>아이디는 ${id } 이고 이름은 ${name } 입니다.</h1>
	</c:if>
	
	<c:if test="${age == 22 }">
		<h1>${name }의 나이는 ${age }살 입니다.</h1>	
	</c:if>
	
	<c:if test="${height > 160 }">
		<h1>${name }의 키는 160보다 틉니다.</h1>
	</c:if>	
```

<img src ="https://user-images.githubusercontent.com/69107255/107869958-62d3be00-6ed7-11eb-8f8f-43e95d4ae622.png">


# <c:choose>태그를 이용한 실습

**<c:choose>태그**
- switch문의 기능을 수행한다.

**<c:choose>태그 형식**
```jsp
	<c:choose>
		<c:when test="조건식1">본문내용1</when>
		<c:when test="조건식2">본문내용2</when>
		.
		.
		.
		<c:otherwise>본문내용n</otherwise>
	</c:choose>
	
	test: 표현 언어를 이용해 수행할 조건식 위치
```

## 1. 값 선언

**member5.jsp**

```jsp
    <c:set var="id" value="hong" scope="page" />
	<c:set var="pwd" value="1234" scope="page" />
	<c:set var="name" value="${'홍길동' }" scope="page" />
	<c:set var="age" value="${29 }" scope="page" />
	<c:set var="height" value="${180}" scope="page" />
```

## 2. 값 출력

```html
	<c:choose>
		<%-- <c:when test="${name == null }"/> --%>

		<!-- 변수 name이 null이거나 빈 문자열인지 체크한다. -->
		<c:when test="${empty name }">
			<tr align="center">
				<td colspan="5">이름을 입력하세요.!!</td>
			</tr>
		</c:when>

		<!-- name이 정상적인 값이면 1에서 선언한 회원 정보를 출력한다 -->
		<c:otherwise>
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>나이</b></td>
			<td width="20%"><b>키</b></td>
		</tr>

		<tr align="center">
			<td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${age }</td>
			<td>${height }</td>
		</tr>
		</c:otherwise>		
	</c:choose>
```
- ${name}에 값이 존재한 경우

<img src ="https://user-images.githubusercontent.com/69107255/107870140-75e78d80-6ed9-11eb-8ad4-0785a2cbf8c9.png">

- ${name}에 값이 null이거나 빈 문자열인경우

<img src ="https://user-images.githubusercontent.com/69107255/107870214-c363fa80-6ed9-11eb-808b-1d846b9072a3.png">


# <c:forEach> 태그를 이용한 실습

**<c:forEach>태그**
- JSP페이지에서 반복문을 수행하는 태그

**<c:forEach>태그 형식**
```jsp
	<c:forEach var ="변수 이름"
			   items="반복할 객체이름"
			   begin="시작값" end="마지막값"
			   step="증가값" varStatus="박복상태변수이름">
	>
	</c:forEach>

	var: 반복할 변수 이름
	items: 반복할 객체 이름
	begin: 반복 시작값
	end: 반복 종료값
	step: 한 번 반복할 때마다 반복 변수를 증가 시킬 값
	varStatus: 반복 상태 속성
``` 

**varStatus의 속성**
|속성|값|설명|
|----|----|----|
|index|int|items에서 정의한 항목을 가리키는 index번호입니다. 0부터 시작한다.|
|count|int|몇 번째 반복인지 나타낸다. 1부터 시작한다.|
|first|boolean|첫 번째 반복인지 나타낸다.|
|last|boolean|마지막 반복인지 나타낸다.|

## <c:forEach>태그 사용해보기

```jsp
	<!-- 반복 변수 i를 1부터 10까지 1씩 증가시키면서 반복문을 수행한다. -->
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i = ${i } &nbsp;&nbsp;&nbsp; 반복횟수: ${loop.count }<br>
	</c:forEach>
	
	<hr>
	
	<!-- 반복 변수 i를 1부터 10까지 2씩 증가시키면서 반복문을 수핸한다. -->
	<c:forEach var="i" begin="1" end="10" step="2">
		5 * ${i } = ${5*i }<br>
	</c:forEach>
	
	<hr>
	<%
    	List dataList = new ArrayList();
    	dataList.add("hello");
    	dataList.add("world");
    	dataList.add("안녕하세요.!!");
    %>
    
	<%--표현 언어에서 사용할 수 있도록 <c:set>태그를 이용해 변수 dataList를 할당 --%>    
    <c:set var="list" value="<%=dataList %>" />
	<!-- ArrayList와 같은 컬렉션 객체에 저장된 객체(데이터)를 반복해서 반복 변수 data에 하나씩 가져와 처리한다.  -->
	<c:forEach var="data" items="${list }">
		${data }<br>
	</c:forEach>

	<hr>

	<!-- 구분자 .(콤마)를 이용해 문자열을 분리해서 출력한다.  -->
	<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤" />
	<c:forTokens items="${fruits }" var="token" delims=",">
		${token }<br>
	</c:forTokens>
```

<img src ="https://user-images.githubusercontent.com/69107255/107870617-57839100-6edd-11eb-9b0f-b0e0e36a36de.png">


# <c:forEach>태그를 이용해 ArrayList에 저장된 회원 정보 출력해보기

## 1. 값 할당 및 저장

**member7.jsp**

ArrayList 객체 생성 후, 3개의 MemberBean객체에 각각이 값을 할당 후 membersList에 저장했다.

```jsp
    <%
    	request.setCharacterEncoding("UTF-8");
    
    	List membersList = new ArrayList();
    	MemberBean m1 = new MemberBean("ryu","1234","류수정","ryu@admin.com");
    	MemberBean m2 = new MemberBean("park","4321","박혜수","park@admin.com");
    	MemberBean m3 = new MemberBean("lee","1004","이미주","lee@admin.com");

    	membersList.add(m1);
    	membersList.add(m2);
    	membersList.add(m3);
    %>
```

## 2. 값 출력

```jsp

	<table border="1" align="center">
		<tr align="center" bgcolor="gray" style="color: white">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>나이</b></td>
		</tr>
		
		<!-- membersList에 저장된 회원 수만큼 반복 변수 i를 0부터 1씩 증가시키면서 forEach문을 실행한다.  -->
		<c:forEach var="i" begin="0" end="2" step="1">
		<tr align="center">
			<!-- 반복 변수 i를 ArrayList의 인덱스로 사용해 회원 정보를 차례대로 출력한다.-->
			<td>${membersList[i].id }</td>
			<td>${membersList[i].pwd }</td>
			<td>${membersList[i].name}</td>
			<td>${membersList[i].email }</td>
		</tr>
		</c:forEach>
	</table>
```

**member8.jsp**	

<c:forEach>문의 items속성에 membersList를 할당한 후 실행하여 자동으로 var의 member에 membersList의 MemberBean 객체가 차례대로 할당되도록 하였다.

```jsp
		<!-- 반복문을 수행하면서 memberList에 저장된 MemberBean객체가 차례대로 member에 할당된다.  -->		
		<c:forEach var="member"  items="${membersList}">
		<tr align="center">
			<td>${member.id }</td>
			<td>${member.pwd }</td>
			<td>${member.name }</td>
			<td>${member.email }</td>
		</tr>
		</c:forEach>
```

`member7.jsp`와`member8.jsp`와 같은 결과가 나온다.

<img src ="https://user-images.githubusercontent.com/69107255/107870790-d5946780-6ede-11eb-83d1-723737b86427.png">


# <c:url> 태그를 이용한 실습

**<c:url>태그**
- JSP페이지에서 URL 정보를 저장하는 기능

```jsp
	<c:url var="변수이름" value="URL경로" [scope="scope 속성 중 하나"]>
	[<c:param name="매개변수이름"> value="전달값" /> ]
	.
	.
	.
	</c:url>

	var: url이 저장된 변수
	value: 생성할 URL
	scope: 변수의 접근 범위(page, request, session, application 중 하나)
```


## 1. <c:url /> 설정

**urlTest.jsp**

```jsp
    <c:set var="contextPath" value="${pageContext.request.contextPath }" />

    <c:url var="url1" value="/test01/member1.jsp"> 
		<c:param name="id" value="jeon"/>
		<c:param name="pwd" value="1234"/>
		<c:param name="name" value="전지현"/>
		<c:param name="email" value="jeon@admin.com"/>
	</c:url>
```

```jsp
	<a href="${url1}">회원정보 출력</a>
```

**회원정보 출력**클릭 시 get방식으로 url에 지정된 param태그에 값들이 member1.jsp로 전달 되어 값이 출력되는 것을 확인 할 수 있다.

**test01/member1.jsp**
<img src ="https://user-images.githubusercontent.com/69107255/107872264-7ccbcb80-6eec-11eb-8522-fa3227cb4a7f.png">


# <c:redirect>태그를 이용한 실습

**<c:redirect>**
- response.sendRedirct() 기능을 대체함

**<c:redirect> 태그 형식**
```jsp
	<c:redirect url="redirect할 URL">
	[ <c:param name="매개변수이름" value="전달값"/>]
	.
	.
	.
	</c:redirect>

	url: 리다이렉트될 URL이 저장될 변수
```

## 1. 리다이렉트할 페이지 설정 및 매개변수 설정

```jsp
    <%-- 리다이렉트할 페이지를 설정한다. --%>
    <c:redirect url="/test01/member1.jsp">
    <%-- 리다이렉트할 페이지로 전달할 매개변수를 설정한다. --%>
    	<c:param name="id" value="${'hong' }"/>
    	<c:param name="pwd" value="${'1234' }"/>
    	<c:param name="name" value="${'홍길동' }"/>
    	<c:param name="email" value="${'hong@admin.com' }"/>
    </c:redirect>
```

-  <c:redirect url="/test01/member1.jsp">를 통해서 /test01/member1.jsp로 파라미터 값들을 전달해서 값이 출력되는 것을 확인할 수 있다.

<img src ="https://user-images.githubusercontent.com/69107255/107873421-d258a600-6ef5-11eb-8d58-2957453cd8db.png">


# <c:out> 태그를 이용한 실습

**<c:out>태그**
- 화면에 지정한 값을 출력하는 기능


**<c:out>태그 형식**
```jsp
	<c:out value="출력값" default="기본값" [escapeXml="boolean값"] />

	value: 출력할 값
	default: value에 지정된 값이 없을 때 출력할 기본값
	exscaleXml: escape 문자를 변환여부 지정(생략할 수 있으며 기본값은 true)
```



