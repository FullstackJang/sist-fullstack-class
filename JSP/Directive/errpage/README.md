

사용자가 정상적인 값이 아닌 값으로 요청할 때 에러가 발생하게 되는데 

<img src ="https://user-images.githubusercontent.com/69107255/106826664-b3267100-66ca-11eb-8ca1-a10bc6cca712.png">

```java
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
```

age변수에 정수가 들어와야하지만 `스물아홉살`이라는 문자열을 전달 하였습니다.

<img src ="https://user-images.githubusercontent.com/69107255/106827060-773fdb80-66cb-11eb-9026-55d5a845df97.png">


정수가 아닌 문자열이 전달이 되기 때문에 오류가 발생하게 된다.

<img src ="https://user-images.githubusercontent.com/69107255/106827110-90e12300-66cb-11eb-93a1-0e3897bf8bef.png">