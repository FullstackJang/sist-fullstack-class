<img src = "https://user-images.githubusercontent.com/69107255/105180685-38a80e00-5b6e-11eb-9ef6-27da840b396e.png">
<hr>

```javascript
        document.getElementById('btnAdd').addEventListener('click',function(){
            let food = document.getElementById('input').value;
            let txt_food = document.createTextNode(food);/*사용자가 입력한 값을 가지고 text를 만든다.*/
            let li_food = document.createElement('li');
       
            li_food.appendChild(txt_food);
                
            document.getElementById('foodList').appendChild(li_food);
        });
```
```javascript
        document.getElementById('btnAdd').addEventListener('click',function(){
```

아이디가 `btnAdd`인 `추가 버튼`이 클릭되면 함수의 내용이 실행된다.

```javascript
        let food = document.getElementById('input').value;
```

아이디가 `input`인 태그에 사용자가 입력한 값을 가져와서 `food`변수에 값을 저장한다.

```javascript
        let li_food = document.createElement('li');
```

`food`변수를 가지고 `.createTextNode()`를 통해 *<li*>*</li*>태그 사이에 들어 갈 문자열을 만든다.

```javascript
        li_food.appendChild(txt_food);

       /*예시*/ <li>txt_food</li>
```
`li_food`의 자식노드로 `txt_food`변수를 추가한다.

```javascript
        document.getElementById('foodList').appendChild(li_food);

    /*예시*/
        <ul>
            <li>txt_food</li>
        </ul>
```
***<ul*>**태그에 아이디인 `foodList`를 가지고 자식 노드로 `li_food`를 추가한다.
