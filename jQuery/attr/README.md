# attr()

**속성 조작**
|메소드|설명|
|----|----|
|attr()|속성을 조작합니다.|

**img 태그의 src속성을 가져온다.**
```javascript
$('img').attr('src')
```

- **img 태그**의 `src 속성`을 `http://placehod.it/300*200`으로 설정한다.
```javascript
        $(function(){
           $('#image').attr('src','http://placehold.it/300x200') ;
           $('#image').attr('width',300) ;
           $('#image').attr('height',200) ;
        });
```
- **img 태그**의 `src 속성`과 `alt속성`을 한꺼번에 지정한다.
```javascript
        $(function(){
            $('#image').attr({
               src:'http://placehold.it/300x200',
               width:300,
               height:200
            });
        });
```