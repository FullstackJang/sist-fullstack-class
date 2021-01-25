# $(document).ready()

```javascript
$(document).ready(function(){
        alert('hello ready');
});

$(document).onload(function(){
        alert('hello load');
});
```

자바스크립트의 `window.onload`와 같은 기능을 한다.

1. **호출 시점 차이**: 한 페이지에 두 함수가 다 있다면 실행 우선순위 (.ready() → .onload() 순으로 실행)
    - .ready() 호출시점 : DOM Tree 생성 완료 후
    - .onload() 호출시점 : 모든 페이지 구성요소 페인팅 완료 후


# 출처
[jQuery .ready() vs .onload 차이](https://hahahoho5915.tistory.com/28)