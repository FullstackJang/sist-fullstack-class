# Date 클래스
- 형식이 있는 날짜를 얻을 때 사용 하고 `SimpleDateFormat`과 같이 사용함

## Date클래스 사용
**객체 생성**
```java
    Date d = new Date(); //시스템의 날짜정보를 저장하는 객체가 생성
```

**java.txt package존재**
- SimpleDateFormat 
> 날짜 형식 제공
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
|:----|:----:|:-----:|----|
|년|y|Year||
|월|M|Week year	||
|일|d|Day in month|	|
|시|h|Hour in am/pm (1-12)	||
|오전/오후|a|Am/pm marker||
|분|m|Minute in hour||
|초|s|||
|요일|E|||
<br>
<br>

# Calendar 클래스
- 단편적인 날짜 정보를 얻을 때

- 특징
    - 객체화가 되지 않는 클래스(abstract class)
    - is-a 관계의 객체화
    - 날짜 정보를 얻기 위해 `Constant`사용

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

## 날짜 변경
```java
    set() //사용
    cal.set(field,value);
```
1. 생성
```java
    Calendar cal = Calendar.getInstance();
```
2. 변경
```java
    cal.set(Calendar.YEAR,2019); // 년도 변경 2020 => 2019

    cal.set(Calendar.MONTH,4) // 월 변경 11 => 5  4를 넣어줘야 5가 나옴

    cal.set(Calender.DAY_OF_MONTH,31) // 일 변경 31
```
# Random 클래스
> 난수를 생성하기 위해 만들어진 클래스

**사용법**
1. 객체생성
- 객체가 생성되었을 때 `모든 난수`가 생성되어 있음
```java
    Random r = new Random();
```

2. 난수 얻기

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

**사용법**
1. 객체 생성
```java
    DecimalFormat df = new DecimalFormat("pattern"); 
    // #패턴은 값이 있을때에만 출력
    // 0패턴은 값이 있다면 값을 출력하고 값이 없다면 0을 출력
```
2. 형식에 따른 문자열을 얻기
```java
    df.format("정수 or 실수");
    //형식에 대한 문자열이 리턴
```