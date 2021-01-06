# HTML형식
1. **코드 작성**
```html
<!--주석(코멘트)-->
<!DOCTYPE html> <!--선언부-->
    <html>    <!--<html>부터</html>까지를 HTML요소 -->
        <head>
        <meta charset="UTF-8">
            <title>

            </title>
        </head>
        <body>

        </body>
    </html>
```

2. **저장**
```
    xxx.html
```

3. 배포(deploy)
- 제작된 HTML파일을 웹 서비스하기 위해서 정해진 위치(server.xml | contex.xml설정)에 놓는다. 
- java에서 Web Service하기 위한 폴더 구성
```
    c:/web/a
          /b
          /c
          /WEB-INF/web.xml (DD: Deployment Descriptor)
          /classes/package선언/class파일(class,Servlet)
          /lib (외부 library, Framework에 대한 파일들)
```
- `a`,`b`,`c`폴더에는 HTML,CSS,JavaScript,JSP가 들어있다.

4. Web Server(Web Conainer) 실행

5. Web Browser열고 HTML을 요청하는 URL을 입력

