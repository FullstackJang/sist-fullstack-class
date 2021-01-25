# attr()

```javascript
        $(function(){
           $('#image').attr('src','http://placehold.it/300x200') ;
           $('#image').attr('width',300) ;
           $('#image').attr('height',200) ;
        });
```

```javascript
        $(function(){
            $('#image').attr({
               src:'http://placehold.it/300x200',
               width:300,
               height:200
            });
        });
```