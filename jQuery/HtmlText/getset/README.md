
`body태그`에 h2태그안에 홍길동이라는 적혀있고, `설정하기 버튼`과 `읽어오기 버튼` 두가지 버튼이 있다.

<img src = "https://user-images.githubusercontent.com/69107255/105834108-6927f600-600d-11eb-8d89-8ee70d286ed9.png">

```javascript
        //매개변수가 있으면 바꾸는 역할 setter
        $('#btnSet').click(function(){
            $('h2').html('이순신');
        });
        
        // 매개변수가 없으면 읽어오는 역할 getter
        $('#btnGet').click(function(){
          let r =  $('h2').html();
            alert(r);
        });
```

# **.html(값이 있는경우)**

**설정하기 버튼**을 누르면 `홍길동`에서 `이순신`으로 h2요소에 값이 변하는 것을 확인할 수있다.

<img src ="https://user-images.githubusercontent.com/69107255/105834694-23b7f880-600e-11eb-96f8-a1941f8dabd5.png">

- `.html(값이 있는 경우)`은 값이 있을 경우에는 `Setter`(값을 변경하는)의 역할을 한다.

# **.html() 메소드 안에 값이 없는 경우**

위에 `홍길동`에서 `이순신`으로 변경된 후 **읽어 오기 버튼**을 누르면 alert()창에 변경된 `이순신`이 출력되는것을 확인할 수 있다.

<img src = "https://user-images.githubusercontent.com/69107255/105834810-5235d380-600e-11eb-9452-36f2d3fbd02a.png">

- `.html()` 값이 없는 경우에는 요소안에 있는 값을 읽어오는 `Getter`의 역할을한다.