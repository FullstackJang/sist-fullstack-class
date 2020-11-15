# Date 클래스
- `형식이 있는 날짜를 얻을 때 사용` 하고 `SimpleDateFormat`클래스와 같이 사용함

> Date클래스는 java.util.Date

## Date클래스 사용

- **Date class 예제  코드** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days18/UseDate.java)

**Date 클래스 객체 생성**
```java
    Date d = new Date(); //시스템의 날짜정보를 저장하는 객체가 생성
```

**java.txt package존재**
>`날짜 형식 제공
- SimpleDateFormat는 `java.text`.SimpleDateFormat

1. 객체 생성
```java
    //객체 생성 시 형식이 설정이됨
    SimpleDateFormat sdf = new SimpleDateFormat("pattern");
                                                 //형식을 설정하면 형식대로 날짜가 출력됨
``` 

2. 날짜정보를 넣어 형식의 날짜를 얻는다.
```java
    sdf.format(new Date());
        //상속method
```

**자주 사용하는 Date and Time Patterns**
|Letter|Date or Time Component|Presentation|Examples
|:----|:----:|:-----:|:----:|
|년|y|Year|1996; 96|
|월|M|Week year|July; Jul; 07|
|일|d|Day in month|10|
|시|h|Hour in am/pm (1-12)|12|
|오전/오후|a|Am/pm marker|PM|
|분|m|Minute in hour|30|
|초|s|Second in minute|55|
|요일|E|Day name in week|Tuesday; Tue|
