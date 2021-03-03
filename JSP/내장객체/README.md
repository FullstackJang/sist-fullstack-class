# 내장 객체(implicit object)

> JSP가 서블릿으로 변환 시 컨테이너가 자동으로 생성 시키는 서블릿 멤버 변수

JSP파일인 **hello.jsp**파일을 서블릿으로 변환 **hello_jsp.java**
<img src="https://user-images.githubusercontent.com/69107255/107755730-8e836680-6d66-11eb-8d3d-4593c27600fa.png">


# JSP에서 제공하는 내장 객체들
|내장객체|서블릿|설명|
|----|----|----|
|request|javax.servlet.http.HttpServletRequest |웹 브라우저의 요청 정보를 저장하고 있는 객체| 
|response |javax.servlet.http.HttpServletResponse |웹 브라우저의 요청에 대한 응답 정보를 저장하고 있는 객체| 
|out|javax.servlet.jsp.jsp.jspWriter |JSP 페이지에 출력할 내용을 가지고 있는 출력 스트림 객체이다. |
|session |javax.servlet.http.HttpSession |하나의 웹 브라우저의 정보를 유지하기 위한 세션 정보를 저장하고 있는 객체|
|application |javax.servlet.ServletContext |웹 어플리케이션 Context의 정보를 저장하고 있는 객체 |
|pageContext |javax.servlet.jsp.PageContext |JSP 페이지에 대한 정보를 저장하고 있는 객체 |
|page |java.lang.Object |JSP 페이지를 구현한  자바 클래스 객체|
|config |javax.servlet.ServletConfig |JSP 페이지에 대한 설정 정보를 저장하고 있는 객체 |
|exception |java.lang.Throwable |JSP 페이지서 예외가 발생한 경우에 사용되는 객체 |

# 내장 객체들의 스코프
- 웹 애플리케이션은 `page`, `request`, `session`, `application` 4개의 영역(scope)을 가진다.
- 내장 객체의 영역은 객체 `유효기간`이라고도 불리며 **객체를 누구와 공유할 것인가**를 나타냄

|내장객체|서블릿|스코프|
|----|----|----|
|page|this|한 번의 요청에 대해 하나의 JSP페이지를 공유한다.|
|request|HttpServletRequest|한 번의 요청에 대해 같은 요청을 공유하는 JSP 페이지를 공유한다|
|session|HttpSession|같은 브라우저에서 공유한다.|
|application|ServletContext|같은 애플리케이션에서 공유한다.|

## page 영역
- 한 번의 웹 브라우저(클라이언트)의 요청에 대해 하나의 JSP 페이지가 호출된다.
- page 영역은 객체를 하나의 페이지 내에서만 공유
- pageContext 내장 객체 사용

## request 영역
- 한 번의 웹 브라우저의 요청에 대해 같은 요청을 공유하는 페이지가 대응됨
- 같은 request 영역인 경우 두 개의 페이지가 같은 요청을 공유할 수 있음
-객체를 하나 또는 두 개의 페이지 내에서 공유 가능
- include, forward 액션 태그 사용시 request 내장 객체를 공유하게 되며
그에 따라 같은 request 영역이 됨
- 주로 페이지 모듈화에 사용
- request 내장 객체 사용

## session 영역
- 하나의 웹 브라우저당 1개의 session 객체 생성
- 같은 웹 브라우저 내에서 요청되는 페이지들은 같은 객체 공유
- 주로 회원 관리(인증)에 사용되며 session 내장 객체 사용

## application 영역
- 하나의 웹 애플리케이션(프로젝트)당 1개의 application 객체 생성
- 같은 웹 애플리케이션에 요청되는 페이지들은 같은 객체 공유 /Project_Name 웹 애플리케이션에서는 같은 application 객체 공유
- 애플리케이션 전체에서 공유하는 객체이므로
- 메모리에 부담이 갈 수 있어서 자주 사용되지는 않음
- application 내장 객체 사용

# setAttribute() & getAttribute()

JSP 페이지 및 서블릿 간 정보를 주고받을 수 있도록 한다.

|메소드|설명|
|----|----|
|void setAttribute(String key, Object value)|해당 내장 객체의 속성값을 설정하는 메소드 key 속성명에 value 속성값을 지정|
|java.util.Enumeration getAttributeNames()|해당 내장 객체의 속성명을 읽어오는 메소드 모든 속성의 이름을 얻어옴|
|Object getAttribute(String key)|key 속성명에 해당하는 속성값 반환|
|void removeAttribute(String key)|key 속성명에 해당하는 속성 제거|