
`css 설정하기 버튼`과 `객체를 이용하여 설정`하는 2가지 버튼을 만들었다.

<img src ="https://user-images.githubusercontent.com/69107255/105825558-134e5080-6003-11eb-9a43-9d31624b52be.png">


**css 설정하기 버튼**
css 설정하기 버튼이 클릭되면 콜백함수를 통해서 `div`인 요소의 css스타일을 변경한다. 
```javascript
        $('#btnSetCss').click(function(){
             $('div').css('backgroundColor','blue');
             $('div').css('width','200px');
             $('div').css('height','200px');
        });
```
`버튼이 클릭되면` 아래와 같이 css설정된 내용으로 변경이 된다.

<img src = "https://user-images.githubusercontent.com/69107255/105825926-8061e600-6003-11eb-96c1-3c5a4310c13e.png">