# 자주 사용하는 클래스들
- 문자열관련
	String, StringBuffer, StringBuilder, java.util.StringTokenzier
- 날짜 관련
	java.util.Date, java.util.Calendar
- 형식 관련
	java.text.SimpleDateFormat, java.text.DecimalFormat
- 수학
	java.lang.Math
- 난수
	java.util.Random
- 지역
	java.util.Locale
--- 
## String class
`String`의 `주소`를 저장 할 클래스
- `String`은 문자열 저장소를 의미

`짧은 문자열` / `긴 문자열` 구분

"안녕하세요" : 짧은 문자열

"안" + "녕" : 긴 문자열

1. 문자열을 다루는 일<br>
**java.lang.String**
> 짧은 문자열을 다룰때 사용

**특징**<br>
- 속도가 느리다<br>
- 같은 문자열은 존재하지 않음
- 문자열 저장소에서 부르기 때문에 메모리를 아낄 수 잇음
- method를 호출하여 일을 하면 원본 문자열에 영향을 끼치지 않음

**java.lang.String.Buffer**
> 긴 문자열을 다룰 때 사용

**특징**<br>

- 메모리(힙)에 문자열을 직접 생성<br>
- 같은 문자열이 존재<br>
- 객체마다 문자열을 따로 생성하고 각각 사용<br>
- method를 호출하여 일을 하면 원본 문자열에 영향을 줌<br>
- String Builder보다 속도가 느리다.
- MultiThread에서 동시접근이 안된다(동기화처리되어있음)
동기화: 한개 처리하고 끝나고 한개 처리<br>
ex) 은행 본인 카드 통장 동시에 넣고 출금하면 한개는 처리가 되고 한개는 처리가 안됨

**java.lang.StringBuilder**
> 긴 문자열을 다룰 때 사용

**특징**<br>

- 메모리(힙)에 문자열을 직접 생성<br>
- 같은 문자열이 존재<br>
- 객체마다 문자열을 따로 생성하고 각각 사용<br>
- method를 호출하여 일을 하면 원본 문자열에 영향을 줌
- 문자열을 다룰때 속도가 가장 빠르다.
- MultiThread에서 동시접근이 가능(동기화가 되어있지 않음-비동기)
비동기: 동기식과는 다르게 여러개 처리가능

**StringBuilder의 기능**
1. **객체생성**
```java
    StringBuilder sb = new StringBuilder();
```

2. 값 추가
```java
    sb.append("안녕");
    sb.append("11");
    sb.append("월");
    sb.append("true");
```
3. 값을 삽입
```java
    //insert시 그 인덱스에 존재하는 값들이 뒤로 밀린다.
    //안녕11월true
    sb.insert(인덱스,값);
    sb.insert(2,"하세요?");//안녕하세요?11월true
```

4. 인덱스사이의 문자열 삭제
```java
delete(시작 인덱스, 끝 인덱스+1); //+1 하는이유 null문자
```

5. 문자열 뒤집기
```java
    sb.reverse(); //eurt월11녕안
    // 사용 시 문자열이 뒤집혀진 상태로 유지가 됨
```

6. StringBuilder의 값을 문자열로 변환
```java
    String sb = sb.toString
```

**메소드 체인**
> 모든 메서드가 하나의 체인으로 연결
```java
		참조변수.append("오늘은 ").append(11).append(12).append("일");
```

2. 문자열을 자르는 일
- **java.util.StringTokenizer**
**StringTokenizer**
- 문자열을 `짧은 한마디`로 구분할 때 사용 / `짧은 한마디`=> Token
- java.util패키지에서 제공

**StringTokenizer 사용법**
1. 생성
> 문자열을 공백으로 구분
```java
    String str = "오늘은 목요일 입니다.";
    StringTokenizer stk = new StringTokenizer(str); //값에 대한 제어권을 얻는다.
```

2. Token의 수(기준:현재 Pointer 기준)
```java
	stk.countTokens(); // 반환형 int
    String str = "오늘은 목요일 입니다.";
    /*
    "오늘은" / 1Token
    "목요일" / 1Token
    "입니다." / 1Token
    */
```
3. Token이 존재하는지?
```java
    stk.hasMoreTokens(); // 반환형 boolean
```

4. 토큰의 값을 얻고 포인터를 다음 토큰으로 이동
```java
    stk.nextToken(); 
```
**StringTokenizer의 while문 사용법**
```java
    while(stk.hasMoreTokens()){ //Token이 존재하는지?
        stk.nextToken(); // 값을 얻고 포인터를 다음으로 이동 
    }

```
## CSV Data(comma separated value)
```java
    String str = "안녕,하세요,오늘은,목요일";
```

String 클래스에 `split(String regex)`을 사용하면 특정문자로 `구분`하여 배열로 얻는 일을 할 수 있음


class의 접근지정자에 `final`이 있을 때
> 상속 불가 / 제공하는 기능을 그대로 사용
```java
    public final class 클래스명 extends 부모클래스 implements 구현인터페이스,,,{ }
    // 자식을 가질 수 없지만 부모는 가질 수 있음
```
---
## Math Class
특징
- 생성자가 없는 클래스
    - 객체화 할 수 없음
- static method로만 구성된 클래스

**절대값**
```java
    Math.abs(수); // -2 => 2
```

**반올림**
```java
    Math.round(실수); // 10.5 => 11
```

**올림**
```java
    Math.ceil(실수);//10.1 => 11
```

**내릴때**
```java
    Math.floor(실수) //10.9 => 10.0
```

**절삭**
```java
// 소수점이하 값을 버릴때는 => Casting 해야함
    (int)10.01; // 10
```

**난수**
```java
    Math.ramdom(); 
```