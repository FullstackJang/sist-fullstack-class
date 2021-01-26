`rgb메소드`를 이용해서 2픽셀의 높이만큼 블록요소인 div태그에 적용한다.

**.appendTo()** 메소드를 사용하였다.

`.appendTo()`는 $(A).appendTo(B) A 가 B 사이의 마지막에 추가 된다.<br>
*<div*>*</div*>를 전부 만든 후 `body`에 붙인다는 뜻이다.


<img src = "https://user-images.githubusercontent.com/69107255/105827156-fd418f80-6004-11eb-90e5-eda469443fff.png">

```javascript
    for(i=0; i < 256; i++){
    $("<div></div>").css({
            height: '2px',
            backgroundColor : `rgb(${i},${i},${i})`
        }).appendTo('body');
    }
```

div라는 변수를 만든 후 
```javascript
	for(i=0;i<256;i++){
		let div = $("<div></div>").css({
			height:2,
			background:`rgb(${i},${i},${i})`
		});
		
		$("body").append(div);
    }
```