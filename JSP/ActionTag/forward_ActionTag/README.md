# jsp:forward action tag

요청을 다른 자원으로 전달하는 데 사용

## 파라미터 없을때

파라미터가 없을때에는 끝에 꼭 **/** 로 닫아주어야 한다.
```jsp
<jsp:forward page="relativeURL | <%= expression %>" />
```

## 파라미터 있을때

<jsp:forward page="relativeURL | <%= expression %>">  
<jsp:param name="parametername" value="parametervalue | <%=expression%>" />  
</jsp:forward>  


웹은 현재 작업중인 페이지에서 다른 페이지로 이동하기 위해 2가지 페이지 전환 기능을 제공한다.

## 1. Forward 방식

`Forward`는 `Web Container` 차원에서 페이지의 이동만 존재한다. 실제로 웹 브라우저는 다른 페이지로 이동했음을 알 수가 없다. 그렇기 때문에 웹 브라우저에는 최초에 호출한 URL이 표시되고, 이동한 페이지의 URL 정보는 확인할 수 없다. 또한 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 Request 객체와 Response 객체를 공유합니다. 