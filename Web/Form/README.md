# **HTML Form Control**
- 접속자의 정보를 받기 위해 제공하는 HTML의 객체들
    - *<input*>
    - *<select*>
    - *<textarea*>
- 입력된 정보는 *<form*>태그를 사용하여 Back-end로 전송할 수 있다.

## *<input*>태그

- readonly="readonly"
    - 사용자가 편집할 수 없다.
    - Back-end로 값을 전송할 수 있다.
- disabled = "disabled"
    - 사용자가 편집할수 없다.
    - Back-end로 값을 전송할 수 있다.

## text / password
```html
    <input type="text" or type="password">

    <input type="text" name="이름" size="보여지는 크기" maxlength="최대입력글자 수" value="설정될 값" readonly="read" disabled="disabled" autofocus="autofocus" placeholder="사용자에게 보여질 메시지" id="아이디">
```

## hidden
> 사용자에게 보여지지 않고 Back-end로 값을 전달할 때
```html
    <input type="hidden">

    <input type="hidden" name="이름" value="설정될 값" id="아이디">
```

## checkbox
```html
    <input type="checkbox" name="이름" value="Back-end로 전송할 값" checked="checked" id="아이디">보여질값
```

## radio
```html
    <input type="radio" name="이름" value="Back-end로 전송할 값" checked="checked" readonly="readonly" disabled="disabled" id="아이디">보여질값
```

## button
```html
    <input type="button" value="버튼라벨" readonly="readonly" disabled="disabled" id="아이디">버튼 모양
```

## submit
> *<form*>태그 안에 존재하는 HTML Form Control의 값을 Back-end로 전송하는 일
```html
    <input type="submit" value="버튼라벨" readonly="readonly" disabled="disabled" id="아이디">
```

## file
> 접속자의 HDD에서 파일을 선택하는 일
- JavaScript 또는 JSP에서 값을 설정할 수 없다.
```html
    <input type="file" name="이름" id="아이디">
```

## image
- 클릭되었을 때 `submit효과`를 가진다. 
- *<form*>태그 안에 존재하는 HTML Form Control의 값을 Back-end로 전송하는 일
- submit이나 image를 클릭하면 JavaScript에서 유효성 검증이 실패 하더라도 전송이 된다.
```html
    <input type="image" name="이름" src="이미지경로" id="아이디">
```

## select
```html
    <select name="이름" size="보여질 옵션의 갯수" id="아이디">
    <option value="전송할 값">보여질 값</option>
    <option value="전송할 값">보여질 값</option>
    <option value="전송할 값">보여질 값</option>
```

## textarea
```html
    <textarea name="이름" cols="한줄에 쓸 글자수" rows="행의 수" id="아이디">사용자에게 보여질 값</textarea>
```

# form
> HTML From Control의 값을 Back-end로 전송할 때 사용
- 
```html
    <form name="이름" id="아이디" method="요청방식" action="Back-end에 값을 받을 페이지" enctype="전송방식">

    </form>
```

- *<input type="submit"*>이 클릭되면 action에 설정된 페이지로 값들을 전송한다.

# *<label*>
> 이름표를 표현할 때 사용하는 태그
```html
    <input type="text" name="first_name">
```
# *<titledborder*>
> 제목을 가진 테두리를 만들 때
<form>태그 안에서 사용한다.
```html
    <fieldset>
        <legend>제목</legend>
    </fieldset>
```

- method = "요청방식"
    - GET: 웹브라우저의 주소창을 통해 값을 서버로 전달하는 방식(식별 가능)
        - 보안이 되지 않는다.
        - 256자 이하의 소용량 문자열 데이터만 전송 가능
    - POST: HTTP header를 통해 값을 서버로 전달하는 방식(식별 불가능)
        - GET방식 보다 보안이 유리하다.
        - 256자 이상의 대용량 데이터를 전송할 수 있다.(문자열 binary 데이터 전송 가능)

- action="a.jsp", b.jsp, servlet-mapping명: HTML Form Control의 값을 받는 페이지
- enctype="전송방식" 파라미터전송방식(application/x-www-form-urlencoded)이 기본으로 설정되어 있다.(파일은 업로드 되지 않는다.)
    - 파일 전송 방식: multipart/form-data