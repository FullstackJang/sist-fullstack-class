`h2태그 요소`를 묶어서 변경을 시도해 보려고 한다.

<img src = "https://user-images.githubusercontent.com/69107255/105835177-d1c3a280-600e-11eb-82f8-d11a90c7b9a1.png">
<br>
<br>
<hr>

설정하기 버튼을 누른 후 `.html('다 바뀐다')`을 사용 시 `h2태그`의 요소가 **전부 바뀌는 것**을 확인 할 수 있다.

<img src ="https://user-images.githubusercontent.com/69107255/105835361-09324f00-600f-11eb-94ad-c10c334e3675.png">

```javascript
    //매개변수가 있으면 바꾸는 역할 setter
    $('#btnSet').click(function(){
        //설정할때는 h2요소가 전부 다 바뀐다.
        $('h2').html('다 바뀐다');
    });
```
<hr>

`.html()`의 매개변수가 없을 경우에는 맨 첫번 째 요소의 *<h2*> 다 바뀐다 *</h2*> 하나만 읽어오게 된다.
<img src = "https://user-images.githubusercontent.com/69107255/105835728-84940080-600f-11eb-9192-77ece85d8273.png">

```javascript
        // 매개변수가 없으면 읽어오는 역할 getter
        $('#btnGet').click(function(){
          // 읽어올때는 맨첫번째요소 '다 바뀐다' 하나만 읽어오게 된다.
          let r =  $('h2').html();
            alert(r);
        });
```