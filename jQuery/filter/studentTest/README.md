**객체 탐색 메소드**
|메소드|설명|
|----|----|
|parent()|부모 태그를 선택합니다.|
|find()|후손 태그를 찾습니다.|


```javascript
        $(tr).click(function(){
            $('tr').removeClass('active');
            $(this).addClass('active');
            //this==tr 을 기준으로 td들을 찾아라 
            let td_list = $(this).find('td');
                
            for(i=0; i < input_arr.length; i++){
                $(input_arr[i]).val( $(td_list[i]).text() );    
            }
        });
```