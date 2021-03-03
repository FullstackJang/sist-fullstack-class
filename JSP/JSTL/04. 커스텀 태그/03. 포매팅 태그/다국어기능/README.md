# 다국어 태그 라이브러리 사용하기

다국어 태그 라이브러리 종류
|분류|태그|설명|
|----|----|----|
|다국어|<*fmt:setLocale*>|Locale(언어)를 지정한다.|
||<*fmt:message*>|지정한 언어에 해당하는 언어를 표시한다.|
||<*fmt:setBundle*>|사용할 번들을 지정한다.|
||<*fmt:setParam*>|전달할 매개변수를 지정한다.|
||<*fmt:requestEncoding*>|요청 매개변수의 문자 인코딩을 지정한다.|

## 1. Properties Editor 설치하기

1. 이클립스 상단 메뉴에 Help -> Install New Software를 선택한다.

<img src ="https://user-images.githubusercontent.com/69107255/107873825-c02c3700-6ef8-11eb-9a81-27333461bb43.png">

2. `Add...`을 클릭한다.

<img src ="https://user-images.githubusercontent.com/69107255/107873849-e356e680-6ef8-11eb-891c-f20067ec8a17.png">

3. Name은 원하는 이름으로 입력해도 되지만, Location에는 http://propedit.sourceforge.jp/eclipse/updates을 입력해준 후 Add를 클릭한다.

<img src ="https://user-images.githubusercontent.com/69107255/107873885-15684880-6ef9-11eb-9920-96b3eec2c649.png">


4. PropertiesEditor 항목을 선택한 후 Next를 클릭한다.

<img src ="https://user-images.githubusercontent.com/69107255/107874086-6dec1580-6efa-11eb-9d80-fe1d23a04747.png">

5. Install Details 화면이 나타나면 Next를 클릭한다.

<img src ="https://user-images.githubusercontent.com/69107255/107874114-9d028700-6efa-11eb-817e-14a12b48eedb.png">

6. 라이선스 정책에 동의한 후 Finish를 클릭한다.

<img src ="https://user-images.githubusercontent.com/69107255/107874132-c28f9080-6efa-11eb-8cfa-d012d6337a46.png" >

7. 설치 후 이클립스를 재실행할지 묻는 창이 나오면 Restart Now를 클릭한다.

<img src ="https://user-images.githubusercontent.com/69107255/107874183-169a7500-6efb-11eb-8f80-2f25e0d7fc83.png">


# 한글 아스키 파일 만들기

1. 프로젝트의 src 폴더에 resource 패키지를 생성하고 마우스 오른쪽 버튼을 클릭한 후 New > Other..를 선택한다.

<img src="https://user-images.githubusercontent.com/69107255/107874297-ee5f4600-6efb-11eb-8c90-c9208c23e9b0.png">

2. General 항목의 File을 선택 후 Next를 클릭한다.

<img src ="https://user-images.githubusercontent.com/69107255/107874328-1fd81180-6efc-11eb-852b-ddd1b02f4716.png">

3. 파일 이름으로 member.properties를 입력 후 Finish를 클릭한다.

- 확장자는 항상 `.properties`이여야 한다.
<img src ="https://user-images.githubusercontent.com/69107255/107874347-47c77500-6efc-11eb-9df0-5a46722eb6b1.png">

4. resource 패키지에 member.properties가 생성된 것을 확인 할 수 있다.

<img src ="https://user-images.githubusercontent.com/69107255/107874362-747b8c80-6efc-11eb-9c7a-7f130b17879e.png">

5. 위와 같은 방법으로 member_ko.properties.와 member_en.properties 파일을 생성한다.

<img src ="https://user-images.githubusercontent.com/69107255/107874384-b4427400-6efc-11eb-99e5-de6b81b2a407.png">

6. member.properties 파일을 열어 키/값 쌍으로 회원 정보를 한글로 작성한 후 저장한다.

```
mem.name = 장일규
mem.address = 인천시 계양구
mem.job = 취준생
```

<img src ="https://user-images.githubusercontent.com/69107255/107874399-de943180-6efc-11eb-9797-7d94ede6e524.png">

7. 작성한 회원 정보 전체를 마우스로 드래그한 후 오른쪽 버튼을 클릭해 Unicode표시를 선택한다.

<img src ="https://user-images.githubusercontent.com/69107255/107874431-19966500-6efd-11eb-839f-4f0b0d974285.png">

8. 창에 표시된 아스키 코드 전체를 마우스로 드래그 후 복사한다.

<img src ="https://user-images.githubusercontent.com/69107255/107874452-30d55280-6efd-11eb-986c-0a189743c63a.png">

9. member_ko.properies 파일을 열어 붙여 넣은 후 저장한다.

```
mem.name = \uc7a5\uc77c\uaddc
mem.address = \uc778\ucc9c\uc2dc \uacc4\uc591\uad6c
mem.job = \ucde8\uc900\uc0dd
```

<img src ="https://user-images.githubusercontent.com/69107255/107874486-582c1f80-6efd-11eb-92f5-79d9c51d2a90.png">

10. member_en.properties 파일을 열어 동일한 key에 대한 회원 정보를 영어로 따로 입력한다.

```
mem.name = jangilkyu
mem.address = incheon, kyeyang-gu
mem.job = Job seeker
```

<img src ="https://user-images.githubusercontent.com/69107255/107874486-582c1f80-6efd-11eb-92f5-79d9c51d2a90.png">

# JSP 페이지에 다국어 표시하기

1. 먼저 프로젝트의 `WebContent 폴더`에 Use01폴더를 만든 후 message1.jsp파일을 저장한다.

<img src ="https://user-images.githubusercontent.com/69107255/107874585-ec968200-6efd-11eb-83ab-ffe8bf8077d5.png">

2. message1.jsp 파일을 다음과 같이 작성한다.

```
	<%-- <fmt>태그를 사용하기 전에 반드시 설정해야 한다.  --%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```