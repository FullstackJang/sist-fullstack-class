# Random 클래스
> 난수를 생성하기 위해 만들어진 클래스

## Random 클래스 사용

- Random class 예제 코드 [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days18/UseRandom.java)

1. **객체생성**
- 객체가 생성되었을 때 `모든 난수`가 생성되어 있음
```java
    Random r = new Random();
```

2. **난수 얻기**

**정수의 난수**
```java
    //nextInt()의 특징 음수가 나옴
    r.nextInt(); //음수와 양수에 범위로 나옴 -2147483648~ +214748367 범위중 한개가 나옴

    범위의 난수
    r.nextInt()%가짓수; //음수에서 양수 범위가 나온다.

    nextInt(int bound) //양수만 리턴
```
**실수의 난수**
```java
    r.nextDouble()*범위
```

**boolean의 난수**
```java
    r.nextBoolean();
```
# DecimalFormat 클래스
> java.text.DecimalFormat

**숫자 형식**
- 출력되는 숫제에 `,`를 넣어 가독성을 향상
