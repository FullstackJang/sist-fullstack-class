# Web Programming
> World wide Web (w3)

- **Web의 정의**
인터넷에서 `문자`, `이미지`, `소리`, `영상(멀티미디어)`등을 하이퍼텍스트를 사용하여 전송,검색 할 수 있게 해주는 서비스

- **internet**
> 하이퍼텍스트를 이용하여 정보를 검색할 수 있는 프로그램

- 1973 TCP/IP를 정리한 빈튼서프, 밥간(Robert E. Kahn) 네트워크끼리 연결하는 방식을 정리(하나의 통신망으로 발전)

# HTML
> Hyper Text Markup Language

- **특징**
    - Tag언어 `<태그명>내용</태그>`로 제작하는 언어 
        - SGML(태그를 제작하는 언어)을 사용하여 필요한 기능을 정의한 언어
    - 연산 기능이 없다.
    - Web Browser에서 태그를 그려서 보여준다.(Tag를 Rendering)

- Web Browser안에서만 동작(동일한 모양으로 표현되지 않을 수 있다. => 웹표준의 필요성)
- `Markup`(본문에서 특정 부분을 강조하여 보여주는 것)`Language`
- 웹에서 동작하는 문서를 작성하고 표현할 수 있는 표준언어
- Tim Berners Lee(HTML, URL, HTTP를 최초설계)가 1989년에 최초 고안하고 W3C에서 표준제정 발표

# Web강의에 들어가기 앞서 알아야 할 용어 정리

## Hyper Text
> HTML문서 안에서 다른 문서로 연결할 수 있는 연결점을 가진 문서
## Hyper Link
> HTML문서간에 이동을 위해 사용하는 링크
## HTTP(Hyper Text Transfer Protocol)
> HTML문서를 주고 받기 위해 정의한 프로토콜
## URL
> 인터넷에 존재하는 정보(문서, 이미지, 동영상)를 사용하기 위한 주소 체계
```
    프로토콜://호스트이름:포트번호/데이터파일경로/데이터파일의이름
    http 80port   / https 443port
    http://localhost:80day0106/test.html?
```

# HTML역사 (표준안 W3C발표된 시점)
- 1995년 HTML 1.0발표 후 HTML 2.0발표
- 1997년 HTML3.2발표
- 1999년 HTML4.01 발표
- 2014년 10월 HTML5 발표
    - ActiveXObject(Flash Player)없이 브라우저에서 멀티미디어 컨텐츠를 쉽게 서비스 받을 수 있도록 하는 것을 목적

# Web Server
- 웹 브라우저의 요청을 받아 HTML을 서비스 할 수 있는 프로그램
    - 대표적으로 Apache HTTP Server가 있다.
# Web Container
- 웹 브라우저의 요청을 받아 Servlet/JSP를 HTML로 변환하여 서비스 할 수 있는 프로그램
    - 대표적으로 Apache Tomcat

# Web Client
- Url을 사용하여 웹 서버로 요청을 보내고, 응답된 HTML을 그려서 보여주는 일(Web Browser)
