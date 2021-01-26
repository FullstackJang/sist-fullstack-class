
<img src ="https://user-images.githubusercontent.com/69107255/105829692-08e28580-6008-11eb-8b4b-8234290686c8.png">

```javascript
        let h1_list = $('h1'); /*h1_list는 h1요소를 가지고있는 배열이된다.*/
        
        console.log(h1_list.length);
       
        for(i=0; i < h1_list.length;i++){
            let h = h1_list[i]; //h1_list[i]번째 요소를 h변수에 넣는다.
            
            if(i % 2 == 1){ 
//                $(h).css($(h).css('background-color','red'));
//                $(h).css('color','blue');
               $(h).css({
                   backgroundColor: 'red',
                   color : 'blue'
               });
            }
        }
```

3가지 방법으로 적용이 가능하다.
```javascript
    $(h).css($(h).css('background-color','red'));
```
```javascript
    $(h).css('color','blue');
```

```javascript
               $(h).css({
                   backgroundColor: 'red',
                   color : 'blue'
               });
```