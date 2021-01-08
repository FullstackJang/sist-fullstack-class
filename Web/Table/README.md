# 표 만들기
- 데이터를 읽기 좋게 만들어 제공하기 위해

## 표 만들기 관련 Tag
- ***<table*>**
    - 표를 시작하거나 끝낼 때 사용
- ***<tr*>**
    - `행`을 만들 때 사용
- ***<th***>**
    - 제목에 해당하는 칸을 만들 때 사용
- ***<td*>**
    - 사용자에게 보여줄 데이터를 넣을 칸을 만들 때 사용

- 사용자의 눈에 보이지 않는다.(소스상태를 구분하기 위한 의미적인 태그들)
- `*<tr*>태그`를 감싸서 사용
    - ***<thead*>**
        - 표의 가장 위에서 보여진다.
    - ***<tbody*>**
        - 
    - ***<tfoot*>**
        - 표의 가장 아래에서 보여진다.

**테이블의 속성**
|속성|비고|
|----|----|
|border|테이블의 테두리|
|bordercolor|테이블의 테두리 색상|
|borderspacing|셀간 여백|
|cellspacing|셀 내부 여백|
|width|테이블 가로 크기 |
|height|테이블 세로 크기|
|align|정렬|
|bgcolor|배경색|
|colspan| 가로 합병(열 합병)|
|rowspan| 세로 합병(행 합병)|

***<table*>의 속성**
```html
<table border="선의두께" width="테이블의너비", heigth="테이블의높이" bordercolor="선색" borderspacing="셀간여백" cellsapcing="셀내부여백" align="정렬" bgcolor="바닥색"ㄴ>
```
***<tr*>의 속성**
```html
    <tr bgcolor="바닥색" height="행의 높이" align="수평정렬" valign="수직정렬">
```

# 복잡한 표 만들기
- 칸합치기
    - *<td*>, *<th*>에서만 가능
    ```html
        colspan="합칠칸의 수"
        <!--표를 동일하게 만들어 놓고, 합치고 싶은 시작 <td>에서 colspan="합칠칸의 수"로 써주고
            뒤에 나오는 <td>를 삭제한다.-->
    ```
- 행합치기
```html
    rowspan="합칠행의 수"
            <!--표를 동일하게 만들어 놓고, 합치고 싶은 시작 <td>에서 rowspan="합칠행의 수"로 써주고
            아래에 나오는 <td>를 삭제한다.-->
```

# 흘러가는 글자
```html
<marquee scrollamount="속도" direction="방향" behavior="동작">내용</marquee>

<!-- direction = left, up, down -->
<!-- behavior= slide, alternate -->
```