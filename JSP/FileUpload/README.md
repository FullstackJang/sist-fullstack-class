

1. `jakarta.apache.org`로 접속 후 왼쪽메뉴에서 `Commons`를 클릭

<img src= "https://user-images.githubusercontent.com/69107255/107853584-3a59ae80-6e5a-11eb-9fcb-c9f64beb3fef.png">

2. 페이지 중간쯤에 위치한 `FileUpload`를 클릭

<img src ="https://user-images.githubusercontent.com/69107255/107853672-a805da80-6e5a-11eb-8490-15468a4d43d4.png">

3. FileUpload 1.4 버전을 찾아서 `here`를 클릭

<img src ="https://user-images.githubusercontent.com/69107255/107853723-e3080e00-6e5a-11eb-9f69-95fd337ebe1b.png">

4. 압축을 푼 폴더의 하위 폴더인 `commons-fileupload-1.4-bin`에 위치한 `commons-fileupload-1.4.jar`파일을 복사한다.

<img src ="https://user-images.githubusercontent.com/69107255/107853772-2a8e9a00-6e5b-11eb-9558-91c6400320a7.png">

<img src ="https://user-images.githubusercontent.com/69107255/107853781-498d2c00-6e5b-11eb-95c4-3dd61691b240.png">

4. 프로젝트 WEB-INF 하위에 있는 lib폴더에 붙여 넣는다.

<img src ="https://user-images.githubusercontent.com/69107255/107853833-8527f600-6e5b-11eb-9546-e237e6e23a0c.png"> 

5. Commons IO 2.8.0.jar 파일 설치

[다운로드 링크](https://commons.apache.org/proper/commons-io/download_io.cgi)

<img src ="https://user-images.githubusercontent.com/69107255/107853953-113a1d80-6e5c-11eb-85a7-f0fe0213e2ac.png" >

<img src ="https://user-images.githubusercontent.com/69107255/107854035-9fae9f00-6e5c-11eb-9005-a17df9d7bbba.png">

# 파일 업로드 관련 API

DiskFileItemFactory 클래스가 제공하는 메서드
|메서드|기능|
|----|----|
|setRepository()|파일을 저장할 디렉터리를 설정한다.|
|setSizeThreadhold()|최대 업로드 가능한 파일 크기를 설정한다.|

ServletFileUpload클래스가 제공하는 메서드
|메서드|기능
|----|----|
|parseRequest()|전송된 매개변수를 List 객체로 얻는다.|
|getItemIterator()|전송된 매개변수를 Iterator 타입으로 얻는다.|


# JSP 페이지에서 파일 업로드 실습

1. sec01.ex01 패키지를 만든 후 FileUpload 클래스를 생성한다. 그 후 fileuploadTest폴더를 생성 후 uploadForm.jsp를 추가한다.

<img src ="https://user-images.githubusercontent.com/69107255/107854149-5f9bec00-6e5d-11eb-8051-a4204f5b588e.png"> 

2. 파일을 업로드할 때 사용할 저장소를 C드라이브 아래에 만든다.
폴더 이름을 `file_repo`로 생성하였다.

<img src ="https://user-images.githubusercontent.com/69107255/107854199-aee21c80-6e5d-11eb-9bcf-15851d8270d8.png">

3. uploadForm.jsp를 작성한다.
```jsp


```