# Ajax
> Asynchronous JavaScript and XML

- 사용목적
    - 자바스크립트에서 서버에 데이터를 요청하기 위해서  

초기에는 XML로 받아 왔지만 `JSON`을 통해서 받아온다.

||설명|
|----|----|
|비동기 (Synchronous)|동기는 말 그대로 동시에 일어난다는 뜻이다. 요청과 그 결과가 동시에 일어난다는 약속이다. 바로 요청을 하면 시간이 얼마가 걸리던지 요청한 자리에서 결과가 주어져야한다.|
|동기 (Asynchronous)|비동기는 동시에 일어나지 않는다를 의미한다. 요청과 결과가 동시에 일어나지 않을거라는 약속이다.|
# javascript에서 Ajax통신

javascript에서 Ajax통신을 하기위해서 `XMLHttpRequest()`객체를 생성한다.
`open()`함수를 통해서 요청 해당 파일에 요청한다.

```javascript
    request.open('요청방식','서비스명','비동기여부');
```

```javascript
    // XMLHttpRequest객체를 생성
    let request = new XMLHttpRequest();
    request.open('GET','JSP파일명',false);

    // Ajax를 수행
    request.send(); // open함수에 지정된 JSP파일명으로 이동하라는 뜻

    // 출력
    // 서버가 응답한 데이터를 가져오와서 저장되어 있는 곳이 responseText이다.
    alert(request.responseText);

```