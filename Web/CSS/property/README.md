# CSS 속성

- 속성 부여
```html
    속성명:값 의 문법을 사용한다.
```

## 글자 속성
- **글꼴 변경**
    - `font-family:적용 글꼴;`
- **글꼴이 적용 안될 때**
    - `font-family:적용 글꼴,적용 글꼴,적용 글꼴;`
- **진하게**
    - `font-weight: 값;` 값은 두가지 가능 bold - 진하게, normal - 일반글꼴
- **색**
    - `color:색; 영어단어 or RGB`
- **이탤릭**
    - `font-style: italic;`
- **밑줄**
    - `text-decoration: 값;` underline - 밑줄, overline - 윗줄, line-throgh - 취소선

- **크기**
    - `font-size:크기;` 크기의 단위는 px(고정),%(가변),em(가변)

- **정렬**
    - `text-align: 정렬위치;` 정렬위치는 left,right,center를 이용해 수평정렬 할 수 있다.
    - `vertical-align: 정렬위치;` top, middle, bottom
- **text-align**으로 정렬되지 않는 대상은 `margin속성`을 사용하여 정렬한다.

- **대상을 숨기거나 보여주기**
```css
    display:값; none - 숨기기, block - 보이기
```

- **list-style**숨기거나 보여주기
    - `ul`,`ol`의 도형, 숫자를 숨길 때 사용
    ```css
        list-style:none;
    ```
- **크기변경**
```css
    width:너비; height:높이;
```

- **바닥색 변경**
```css
    background-color:색;
```

- **이미지 설정**
```css
    background: 바닥 url('바닥에 들어갈 이미지') 반복설정;

    /*  반복 설정
        - x좌표 반복: repeat-x
        - y좌표 반복: repeat-y
        - 반복하지 않음: no-repeat
    */
```


- **커서(마우스포인터 모양변경)**
```css
    cursor:값;

    값
    손가락 : pointer
    십자선 : crosshair
    이동표시 : move
    로딩 : progress
```