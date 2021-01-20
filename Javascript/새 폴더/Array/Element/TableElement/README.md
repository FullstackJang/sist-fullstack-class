```
"등록"버튼을 누르면 사용자의 입력값으로 테이블에 새로운 행을 추가해 보자.

    .createElement
    .createTextNode
    .appendChild
    를 사용하자
```


```javascript
        document.getElementById('btnAdd').addEventListener('click',function() {
            let txt_name =  document.createTextNode(document.getElementById('name').value);
            let txt_age =  document.createTextNode(document.getElementById('age').value);
            let txt_addr =  document.createTextNode(document.getElementById('addr').value);
            let txt_tel =  document.createTextNode(document.getElementById('tel').value);
            
            let td_name = document.createElement('td');
            let td_age = document.createElement('td');
            let td_addr = document.createElement('td');
            let td_tel = document.createElement('td');
            
            td_name.appendChild(txt_name);
            td_age.appendChild(txt_age);
            td_addr.appendChild(txt_addr);
            td_tel.appendChild(txt_tel);
            
            let tr = document.createElement('tr');
            
            tr.appendChild(td_name);
            tr.appendChild(td_age);
            tr.appendChild(td_addr);
            tr.appendChild(td_tel);

            document.getElementById('listMember').appendChild(tr);
        });
```

```javascript
        document.getElementById('btnAdd').addEventListener('click',function() {
```
아이디가 `btnAdd`인 버튼이 클릭이 되면 안에 함수가 실행이 된다.


```javascript
        let txt_name =  document.createTextNode(document.getElementById('name').value);
        let txt_age =  document.createTextNode(document.getElementById('age').value);
        let txt_addr =  document.createTextNode(document.getElementById('addr').value);
        let txt_tel =  document.createTextNode(document.getElementById('tel').value);
```
사용자로부터 ***<input*>**태그에서 입력받은 값을 `createTextNode`함수를 통해 문자열로 만들어 각 변수에 저장합니다.


```javascript
        let td_name = document.createElement('td');
        let td_age = document.createElement('td');
        let td_addr = document.createElement('td');
        let td_tel = document.createElement('td');
```
```javascript
    <td></td>
```
`td`요소를 만듭니다. 해당 요소를 만들고 나면은 위와 같이 만들어집니다.

**자식노드 추가하기**
```javascript
        td_name.appendChild(txt_name);
        td_age.appendChild(txt_age);
        td_addr.appendChild(txt_addr);
        td_tel.appendChild(txt_tel);
```
`td_name`의 자식으로 `txt_name`이 들어가게 되고
`td_age`의 자식으로 `txt_age`가 들어가게된다.`td_addr`,`td_tel`도 동일하다.


```javascript
        let tr = document.createElement('tr');
```
```javascript
    <tr></tr>
```
`tr`요소를 만듭니다. 해당 요소를 만들고 나면은 위와 같이 만들어집니다.

```javascript
        tr.appendChild(td_name);
        tr.appendChild(td_age);
        tr.appendChild(td_addr);
        tr.appendChild(td_tel);
```
`tr`의 자식으로 `td_xxx`를 넣어준다.

```javascript
        document.getElementById('listMember').appendChild(tr);
```
아이디가 `listMember`인 ***<table*>**태그에 자식으로 tr을 넣어준다.