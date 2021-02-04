# Directive(지시자)
- JSP페이지를 어떻게 처리할 것인지를 설정하는 태그이다

- page Directive
- include Directive
- taglib Directive

|디렉티브 태그|형식|설명|
|----|----|----|
|page|<%@ page %>|JSP 페이지에 대한 정보를 설정한다.|
|include|<%@ include %>|JSP 페이지의 특정 영역에 다룬 문서를 포함한다.|
|taglib|<%@ taglib %>|JSP페이지에서 사용할 태그 라이브러리를 설정한다.|

# page 디렉티브 태그
- 현재 JSP페이지에 대한 정보를 설정하는 태그
- JSP 페이지의 어디에서든 선언할 수 있지만 일반적으로 JSP폐이찌 최상단에 위치 하는 것이 표준
- *<page*> 디렉티브 태그는 여러개가 올 수 있다.
```java
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
```

|속성|설명|
|----|----|
|language| 현재 JSP페이지가 사용할 프로그래밍 언어를 설정한다|
|contentType|현재 JSP페이지가 생성할 문서의 콘텐츠 유형을 설정한다|
|pageEncoding|현재 JSP페이지의 문자 인코딩을 설정한다|
|import|현재 JSP 페이지가 사용할 자바 클래스를 설정한다|
|session|현재 JSP 페이지의 세션 사용 여부를 설정한다|
|buffer|현재 JSP 페이지의 출력 버퍼 크기를 설정한다|
|autoFlush|출력 버퍼의 동작 제어를 설정한다
|isThreadSafe|현재 JSP 페이지의 멀티스레드 허용 여부를 설정한다|
|info|현재 JSP 페이지에 대한 설명을 설정한다|
|errorPage|현재 JSP 페이지에 오류가 발생핼을 때 보여줄 오류 페이지를 설정한다|
|isErrorPage|현재 JSP 페이지가 오류 페이지인지 여부를 설정한다|
|isELlgnored|현재 JSP 페이지의 표현 언어(EL)지원 여부를 설정한다|
|isScriptingEnabled|현재 JSP 페이지의 스크립트 태그 사용 여부를 설정한다|