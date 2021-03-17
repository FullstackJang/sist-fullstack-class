### annotation(주석달기)
- JDK1.5에서부터 추가된 기능
- Compiler에 명령을 전달할 때 사용
- method위, method안에 사용
    - `@Annotation명`
    - Overriding된 method를 명시하기 위해 method위에 `@Override`를 명시
    JDK1.5에서는 `@Override`, `@SuppressWarnings`, `@Deprecated`가 3개가 추가 

- **Java annotation 예시 코드**
    - UseAnnotation.java [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/UseAnnotation.java)

**@Override**
```java
    @Override // 메소드 위 정의
              // Override가 제대로 되었는지 확인할때
```

**@Deprecated**
> 지원하지만 동작은 하지만 이상동작을 할 수있는 method 
```java
    @Deprecated // 동작은 하지만 이상동작을 할 수 있는 method위 정의
``` 

**@SuppressWarnings**
> 경고를 무시할 때
```java
    @SuppressWarnings  // method위, 변수위에 정의 가능
    // method내 모든 변수에 적용, 해당 변수만 적용
    
    - 변수를 사용하지 않을 때
    @SuppressWarnings("unused")
    - Generic을 사용하지 않을 때
    @SuppressWarnings("rawtypes")
    List l = new ArrayList(); => List<String> l = new ArrayList<String>();
```
