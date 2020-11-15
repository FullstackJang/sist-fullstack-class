## DecimalFormat 클래스 사용
-  **DecimalFormat class 예제 코드** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days18/UseDecimalFormat.java)
  
1. **객체 생성**
```java
    DecimalFormat df = new DecimalFormat("pattern"); 
    // #패턴은 값이 있을때에만 출력
    // 0패턴은 값이 있다면 값을 출력하고 값이 없다면 0을 출력
```
2. **형식에 따른 문자열을 얻기**
```java
    df.format("정수 or 실수");
    //형식에 대한 문자열이 리턴
```