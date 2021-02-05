# 내장 객체(implicit object)

- `Scriptlet(스크립트릿<% %>)`안에서만 사용할 수 있다.
- `Scriptlet(스크립트릿<% %>)`안에서 내장객체와 같은 이름의 변수를 선언할 수가 없다.
- 서블릿 컨테이너가 해당 JSP페이지 실행 시 자동으로 생성 해준다.
    - jsp가 변환된 fileName_jsp.java 파일을 열어보면 
    - _jspService() 메소드 내부에 선언되어 있음
- 개발자가 객체를 별도로 생성하지 않아도 JSP에서 바로 사용할 수 있는 객체
- 컨테이너가 JSP를 서블릿으로 변환할 때 자동으로 객체가 생성됨




## 속성 처리 메소드의 종류


# 요청 파라미터 관련 메소드의 종류

|요청 파라미터 관련 메소드|반환 유형|설명|
|----|----|----|
|getParameter(String name)|String|요청 파라미터 이름이 name인 값을 전달받습니다. 요청 파라미터 값이 없으면 null을 반환한다.|
|getParameterValues(String name)|String[]|모든 요청 파라미터 이름이 name인 값을 배열 형태로 전달 받는다. 요청 파라미터 값이 없으면 null을 반환한다.|
|getParameterNames()|java.util.Enumeration|모든 요청 파라미터의 이름과 값을 Enumeration객체 타입으로 전달 받는다. 
|getParameterMap()|java.util.Map|모든 요청의 파라미터의 이름과 값을 Map객체 타입으로 전달받는다.|   