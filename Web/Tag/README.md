# Tag
> 모양

- 태그는 대소문자를 가리지 않는다.
- Error가 발생하지 않는다.(Compile 과정이 없다.)
- HTML은 소스상에서 줄이 변경되지만 Web Browser상에서는 줄변경이 되지 않는다.
**사용법**
```
<시작태그>내용</끝태그>
```

내용이 없는 태그
```
<시작태그></끝태그>
<태그명/>
```

## 줄변경
- ***<br/*>**
> 원하는 곳에서 줄을 변경
```html
    오늘은 <br/>수요일
```

## 문단 태그
- ***<p*>**
> 문단을 만들 때 사용
```html
    <p> 오늘은 </p>
    <p> 수요일 </p>
```

## 글자 태그

|태그|설명|
|----|----|
|*<b*>|글자를 진하게|
|*<strong*>| 글자 크기를 크게<br>HTML5에서 지원하지 않음<br> *<strong*>내용 *</strong*>
|*<big*>|글자 크기를 크게 / HTML5에서 지원하지 않음|
|*<small*>|글자를 작게 하고싶을 때|
|*<u*>|밑줄 / HTML5에서 지원하지 않음|
|*<i*>|이탤릭체|
|*<sup*>|윗첨자|
|*<sub*>|아랫첨자|
|*<mark*>|글자의 형광펜 효과|
|*<center*>|가운데 정렬 / HTML5에서 지원하지 않음|

## 글 제목태그(heading)
- 태그를 사용하면 줄이 변경된다.
- `*<h1*> ~ *<h6*>`까지 제공
- `*<h1*>`이 글자가 가장 크다.
- `*<h6*>`이 글자가 가장 작다.

## 글꼴 태그
> 속성이 있는 태그
- 값을 사용자가 입력하여 다양한 형태의 태그를 사용할 수 있다.
- HTML5에서 지원하지 않는 태그
**속성 사용법**
> `쌍따옴표`, `홀따옴표`, `안써도` 똑같은 값이 나온다. 
```html
    <태그명 속성명="값" 속성명='값' 속성명=값>
```
font는 `3가지 속성`을 가진다.
- `크기`는 **1~10**까지 사용가능
- `글꼴`은 모든 글꼴 가능
- 색
    -  영어 색상 단어 : `black`,`red`,`magenta`
    -  RGB Color : 16진수를 사용하여 색을 표현 `0 ~ F` #<font color="red">00</font><font color="green">00</font><font color="black">00</font>
        - #은 숫자를 나타내는 기호
```
<font size="크기" face="글꼴" colo="색" >내용</font>
```

## **선긋기 태그**
>브라우저마다 다르게 보여진다.(사용자에게 보여주지 않고 소스를 구분하는 의미적인 형태로 사용)
- 줄변경
- width
    - % - 가변길이(브라우저 크기에 따라 변경된다.)
    - 숫자 - 고정길이(브라우저 크기에 따라 변경되지 않는다.)

*<hr width="너비" heigth="높이" color="선색"*>

## **목록 태그**
- *<li*>를 사용하면 줄 변경
- *<ol*>, *<ul*>, *<dl*> 3가지 목록태그를 제공

**사용법**
```html
<!-- 순서 목록: 번호, 기호를 보여줄 때(순서가 있는 데이터를 보여줄 때 사용) -->

    <ol type="1"> <!--  type속성에는 default는 1이고 type속에는 숫자, 영문자, 소문자, 로마자 i-->
        <li>값</li>
        <li>값</li>
    </ol>

<!-- 도형목록 도형을 사용하여 보여줄 때 순서가 없는 데이터를 보여줄 때 사용-->
    <ul type="disc"> <!-- type속성에는 default는 disc이고, circle, square -->
        <li>값</li>
        <li>값</li>   
    </ul>

<!-- 설명목록: 대상에 대해 들여쓰기로 설명을 제공할 때-->
    <dl>
        <dt>제목</dt>
        <dd>설명</dd>
    </dl>

```

## 이미지
- *<img*> 태그를 사용한다.
- `src` 속성을 사용한다.
- 이미지 경로
    - **절대 경로**: c:/경로/파일명 // **절대 사용하지 않는다.**
    - **브라우저에서 보여지는 경로**
        - **상대 경로**: 이미지의 자원을 사용하는 html파일이 제공되는 URL을 기준으로 설정하는 경로 
            - http://localhost/html_prj/day0107/test.html
            - 이미지가 HTML파일과 같은 위치에 존재할 때.
                - 경로를 사용하지않는다.
                ```html
                    <img src="a.png"> 
                ```
            - 이미지가 HTML파일의 하위 폴더에 존재할 때
                - http://localhost/html_prj/day0107/images/a.png
                - 하위 경로부터 기술한다.
                - *<img src="images/a.png*>

            - 이미지가 HTML파일과 다른 폴더에 존재할 때
                - http://localhost/html_prj/**common/images/a.png**
                - 상위경로(..)로 이동하여 경로를 기술한다. 
                - http://localhost/html_prj/**day0107/test.html**
                - 현재 day0107폴더에 test.html에서 common폴더에 images폴더에 a.png를 사용하고 싶을때.
                - *<img src ="../common/images/a.png" *>
            - **상대경로**의 `특징`
                - 장점: 경로를 짧게 기술할 수 있다.
                - 단점: HTML의 파일 위치가 변경되면 모든 경로를 그 위치에 맞게 변경해야한다. 
            
        - **URL**
            - 이미지가 제공되는 모든 경로를 사용하는 방식
            *<img src="http://localhost/html_prj/day0107/images/a.png"*>
        - URL의 특징
           - 장점: HTML파일의 위치가 변경되더라도 경로 수정을 할 필요가 없다.
           - 단점: 경로를 길게 기술해야한다.

```html
    <img src ="이미지경로" width="넓이" height="높이" title="풍선도움말" border="테두리 선 두께" alt="이미지가 로딩되지 않았을 때 보여줄 텍스트 ">
```

## 하이퍼 링크
- 다른 HTML파일과 연결할 때 사용

- 이동할페이지 경로
    - 상대경로
        - 이동할 페이지가 같은 경로에 존재
        ```html
             <a href="a.html"></a>
        ```
        - 이동할 페이지가 하위 경로에 존재
        ```html
            <a href="경로명/파일명"></a>
            <a href="test/a.html"></a>
        ```
        - 이동할 페이지가 다른 경로에 존재
        ```html
            <a href="../../폴더명/파일명"></a>
            <a href="../../test/a.html"></a>
        ```
    - URL
        - 다른 웹 서버에 존재하는 페이지로도 이동 가능
        ```html
        ```
            <a href="http://localhost/html_prj/test/a.html">
```html
    <a href="이동할 페이지경로" title="풍선도움말" target="보여줄페이지가 띄워질 frame위치">
    사용자가 클릭할 내용</a>
```

- **target**
    - target은 HTML을 보여줄 frame이 존재하지 않으면 새창(새탭)으로 HTML을 보여줄 수 있다.
    - 메일보내기: <a href=mailto:받을사람의 메일주소>클릭할이름</a>
    - 전화걸기: <a href="tel:전화번호">전화걸이름</a>

- **frame**
    - 하나의 창(탭)에서 여러 개의 HTML파일을 동시에 로딩하여 보여줄 때 사용

- `frame`과`iframe`을 제공
    - `frame`: 웹 브라우저 전체를 나눠서 페이지를 보여줄 때 사용(페이지의 전체 디자인설정)
    - `iframe`: 웹 브라우저의 일부분을 나눠서 페이지를 보여줄 때 사용

**ifrmae의 사용법**
```html
    <iframe src="프레임에서 보여줄 페이지" name="이름(a태그 target속성에 설정할 이름)" width="너비" height="높이" frameborder="테두리선 두께" scrolling="스크롤바의 여부"></iframe>
```

**map**
 이미지를 자르지 않고 특정 위치에 링크를 설정할 때

 **map사용법**
1. map설정
```html
    <map name="맵이름" id="맵아이디"><!--맵 이름과 맵 아이디는 동일하게 설정한다.-->
        <!-- 형태에는 rect, circle, poly-->
        <area shape="형태" coords="좌표" title="툴팁텍스트" href="링크html">
        <area shape="형태" coords="좌표" title="툴팁텍스트" href="링크html">
    </map>
```
2. 이미지 map사용 속성설정
```html
    <img src="" usemap="#맵이름">
```

## 특수문자
- 기능을 가진 문자

**문법**
```html
    &nbsp; <!--공백 -->
    &lt; <!--*< -->
    &gt; <!--*> -->
    &amp; <!-- & -->
```