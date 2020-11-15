# Calendar 클래스
- `단편적인 날짜 정보를 얻을 때`

- 특징
    - 객체화가 되지 않는 클래스(abstract class)
    - is-a 관계의 객체화
    - 날짜 정보를 얻기 위해 `Constant`사용

## Calendar 클래스 사용

- **Claendar class 예제 코드** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days18/UseCalendar.java)

**is-a관계 객체화**
```java
    Calendar c = new GregorianCalendar();
```
**객체를 얻는 method 사용**
> is-a관계객체화 보다 getInstance()를 호출하는 것을 더 많이 사용함
```java
    Calendar cal = Calendar.getInstance();

    //Calendar는 날짜정보를 얻을 때 get()method를 사용
    cal.get(상수); // 가독성이 떨어짐 무슨 값을 리턴하는지 모름
    cal.get(Calendar.YEAR);
            //필드를 집어넣으면 가독성이 향상 됨  

    //년을 얻고 싶을 때
    cal.get(Calendar.YEAR); //YYYY년

    //월을 얻고 싶을 때
    cal.get(Calendar.MONTH)+1; // M월 
    //0월~11월이 나옴

    //일을 얻고 싶을 때
    cal.get(Calendar.DAY_OF_MONTH); //D요일

    //요일을 얻고 싶을때
    cal.get(Calendar.DAY_OF_WEEK); //6
    //1 2 3 4 5 6 7
    //일 월 화 수 목 금 토
    
    //오전|오후를 얻고 싶을때
    cal.get(Calendar.AM_PM); // 0,1
    //삼항연산자 or 배열만들기
    // cal.get(Calendar.AM_PM) == Calendar.AM ? "오전" : "오후";

    //24시간제 
    cal.get(Calendar.HOUR_OF_DAY);

    /*
        1일때 일요일 / 2일때 월요일을 보여주고 싶다면
        
        첫번째 방법
        switch case문이나 if문을 사용하면 된다.
        
    
        2번째 방법
        String[] weekTitle{"일요일","월요일",,,,};
        weekTitle[cal.get(Calendar.DAY_OF_WEEK)-1];
    */
```

## 날짜 변경을 하고자 할 때
```java
    set() //사용
    cal.set(field,value);
```
1. **생성**
```java
    Calendar cal = Calendar.getInstance();
```
2. **변경**
```java
    cal.set(Calendar.YEAR,2019); // 년도 변경 2020 => 2019

    cal.set(Calendar.MONTH,4) // 월 변경 11 => 5  4를 넣어줘야 5가 나옴

    cal.set(Calender.DAY_OF_MONTH,31) // 일 변경 31
```