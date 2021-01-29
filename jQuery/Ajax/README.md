# Ajax()

```javascript
    $.ajax([옵션])
```

```javascript
$.ajax({

    url: "/examples/media/request_ajax.php", // 클라이언트가 요청을 보낼 서버의 URL 주소

    data: { name: "홍길동" },                // HTTP 요청과 함께 서버로 보낼 데이터

    type: "GET",                             // HTTP 요청 방식(GET, POST)

    dataType: "json"                         // 서버에서 보내줄 데이터의 타입

})

// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.

.done(function(json) {

    $("<h1>").text(json.title).appendTo("body");

    $("<div class=\"content\">").html(json.html).appendTo("body");

})

// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.

.fail(function(xhr, status, errorThrown) {

    $("#text").html("오류가 발생했습니다.<br>")

    .append("오류명: " + errorThrown + "<br>")

    .append("상태: " + status);

})

// HTTP 요청이 성공하거나 실패하는 것에 상관없이 언제나 always() 메소드가 실행됨.

.always(function(xhr, status) {

    $("#text").html("요청이 완료되었습니다!");

});