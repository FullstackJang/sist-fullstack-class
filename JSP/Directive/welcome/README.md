# JSP Welcome 파일 설정하기
> `web.xml`에 웹 애플리케이션의 홈페이지 설정 기능

**web.xml**
```jsp
<welcome-file-list>
	<welcome-file>jsp 또는 html 파일 이름1</welcome-file>
	<welcome-file>jsp 또는 html 파일 이름2</welcome-file>
</welcome-file-list>    
``` 


## 1. 다음과 같이 `ex01 폴더 하위에 index.jsp 파일`과 `web.xml 파일`을 준비한다.
<img src ="https://user-images.githubusercontent.com/69107255/107780609-40805a00-6d8a-11eb-8440-5716a99bdcdd.png">

<br>

<img src="https://user-images.githubusercontent.com/69107255/107780656-50983980-6d8a-11eb-8686-9b49f8f69c1a.png">


## 2. web.xml에 <welcome-file-list> 태그 경로를 포함하여 홈페이지에 해당하는 파일들을 나열한다.
> 여러개의 welcome파일이 지정된 경우 브라우저에서 요청시 첫번째 <*welcome-file*>부터 파일을 찾아 없으면 다음 <*welcome-file*>을 찾아서 화면에 보여준다.
<img src ="https://user-images.githubusercontent.com/69107255/107781451-4296e880-6d8b-11eb-9307-cefc24f037cd.png">

## 3. 톰캣을 다시 실행하면 브라우저에서 컨텍스트 이름(/ex01)로 요청한다.
> main.jsp페이지가 나오는것을 확인 할 수있다.

<img src="https://user-images.githubusercontent.com/69107255/107781535-56dae580-6d8b-11eb-9b32-ed701c3857b2.png">