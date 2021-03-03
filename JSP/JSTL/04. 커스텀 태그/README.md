# 커스텀 태그(Custom Tag)
> 액션 태그나 표현 언어를 사용하더라도 조건식이나 반복문 등의 자바 코드를 제거하기 위해서 도입된 기능

# 커스텀 태그(Custom Tag)의 종류
- JSTL(JSP Standard Tag Library)
    - JSP 페이지에서 가장 많이 사용하는 기능을 태그로 제공하며, JSTL 라이브러리를 따로 설치해서 사용한다.
- 개발자가 만든 커스텀 태그
    - 개발자가 필요에 의해 만든 태그로, 스트러츠나 스프링 프레임워크에서 미리 만들어서 제공한다.


# 표준 태그 라이브러리 JSTL(JSP Standard Tag Library)
> 커스텀 태그 중 가장 많이 사용되는 태그를 표준화 하여 라이브러리로 제공

|라이브러리|세부 기능|접두어|관련 URI|
|----|----|----|----|
|코어|변수 지원, 흐름 제어, URL 처리|c|http://java.sun.com/jsp/jstl/core|
|국제화|지역,메시지 형식,숫자 및 날짜 형식|fmt|http://java.sun.com/jsp/jstl/fmt|
|XML|XML 코어, 흐름 제어, XML 변환|x| http://java.sun.com/jsp/jstl/xml|
|데이터베이스|SQL|sql|http://java.sun.com/jsp/jstl/sql|
|함수|컬렉션 처리,문자열 처리|fn|http://java.sun.com/jsp/jstl/functions|

1. JSTL 라이브러리 다운 및 설치

- 4개의 jar파일을 다운로드한다.

<img src ="https://user-images.githubusercontent.com/69107255/107857958-e3ad9e00-6e74-11eb-92d7-5fcd08933c1e.png">


다운로드 링크(http://tomcat.apache.org/download-taglibs.cgi)

2. 다운로드한 파일을 복사해 프로젝트의 lib 폴더에 붙여 넣어준다.

<img src ="https://user-images.githubusercontent.com/69107255/107857983-16f02d00-6e75-11eb-8ee5-affc62168b97.png">

<img src ="https://user-images.githubusercontent.com/69107255/107858006-38e9af80-6e75-11eb-99f7-7167fe388849.png">


# Core태그 라이브러리 사용

Core태그 라이브러리 기능

- 자바로 구현한 `변수 선언`, `조건식`, `반복문` 기능들을 태그로 대체한다
- 사용 전 반드시 taglib 디렉티브 태그를 선언해야 한다.
    - <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

여러 가지 Core 태그 라이브러리 기능

|기능|태그|설명|
|----|----|----|
|변수지원|<c:set>|JSP페이지에서 변수를 지정한다.|
||<c:remove>|지정된 변수를 제거한다.|
|흐름 제어|<c:if>|조건문을 사용한다.|
||<c:choose>|switch문을 사용한다.<br><c:when>과 <c:otherwise> 서브 태그를 갖는다.|
||<c:forTokens>|구분자로 분리된 각각의 토큰을 처리할 때 사용한다.|
|URL 처리|<c:import>|URL을 이용해 다른 자원을 JSP페이지에 추가한다.|
||<c:redirect>|response.sendRedirect()기능을 수행한다.|
|기타 태그|<c:catch>|예외 처리에 사용한다.|
||<c:out>|JspWriter에 내용을 처리한 후 출력한다.|