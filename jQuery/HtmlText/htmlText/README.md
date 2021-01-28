# jQuery 객체

jQuery라이브러리는 `$함수`를 활용한다.

**jQuery 객체생성**
```javascript
    //  일반 문서 객체로 jQuery 객체를 생성
    $(document)

    // CSS 선택자로 jQuery 객체 생성
    $('h1')

    // HTML 문자열로 jQuery 객체를 생성
    $('<h1></h1>')
```

## 문서 객체 선택
```javascript
    // h1태그를 선택한다.
    $('h1')

    // h1태그 중에 class속성으로 main를 가진 태그를 선택한다.
    $('h1.main')

    // id속성이 head인 태그를 선택한다.
    $('h1.head')

    // input 태그 중에 type 속성이 submit인 태그를 선택
    $('input[type=submit]')
```