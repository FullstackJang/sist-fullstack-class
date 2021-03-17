# Class Type
- class
- abstract
- interface
- inner class(이벤트 처리용)
    - inner class
    - nested class
    - local class
    - anonymous innerclass

## interface
> 다중 상속의 장점을 사용하기 위해서
- 약결합을 구현하여 객체간의 유연성을 높이기 위해서 사용

**장점**
- 기능 확장이 쉬움

**단점**
- 부모가 모호하다.
- 객체의 크기가 필요 이상 커질 수 있음

<img src = "https://user-images.githubusercontent.com/69107255/98751432-70266b80-2403-11eb-95b6-4fb58e3261a4.PNG">

**default method**
> interface에서 업무를 구현할 수 있는 method
- JDK 1.7에서부터 interface에 업무를 구현할 수 있는 defalut method 추가
- 구현하게 되면 추상클래스와 큰 차이가 없어지게 됨
- 사용은 객체를 생성한 후에 사용(is-a관계에서)
```java
접근지정자 default 반환형 method명(매개변수,,) {
        
	}
```
- interface는 생성자가 없음
- interface를 구현한(implments)클래스로 만들어진 객체의 주소는 저장할 수 있음(is-a관계의 객체화)


**문법**
```java
    인터페이스명 객체명 = new 구현클래스의생성자();

```

```java
    접근지정자 interface 인터페이스명 extends 부모인터페이스명..N개 가능{

    //abstract method: 구현의 강제성을 가지는 method 일을 정의 할 수 없음
    //interface에서는 일반method를 가질 수 없기 때문에 abstract를 붙여도 안붙여도 에러가 나지 않음
    접근지정자 abstract 반환형 method명(매개변수,,,);
    접근지정자 반환형 method명(매개변수,,); 

    //접근지정자: public: 외부 패키지에서 사용가능 
    //           package: 패키지 안에서만 접근 가능
    //           default, static, synchronized
    }
```
## inner class
> 안긴 클래스: 클래스에 클래스를 정의
- 이벤트 처리용으로 개발
- 이벤트를 객체마다 따로 처리해야 할 때
- 안쪽 클래스를 인스턴스 변수처럼 사용할 때
- 컴파일되면 bytecode가 두개 생성됨
    - 바깥클래스명.class
    - 바깥클래스명$안쪽클래스명.class
    - 파일명에$가 붙어있으면 inner class임을 알 수 있음(os에 파일 확장자와 구분 class에서 $로 구분)

<img src="https://user-images.githubusercontent.com/69107255/98769132-70cefa00-2423-11eb-9d16-e5b0a8d82d38.JPG" width="350" >

- 안쪽클래스인 **Inner class** 에서는 바깥쪽 클래스인 **Outer class**의 자원을 마음대로 사용할 수 있음
- 바깥쪽 클래스인 **Outer class**에서 안쪽 클래스인 **Inner class**의 자원을 사용하려면 `반드시 객체화`를 하여 사용

**객체화 방법**
1. 외부클래스의 객체화
```java
    바깥클래스명 객체명 = new 바깥클래스의 생성자();
    Outer out = new Outer();
```
2. 내부클래스의 객체화
```java
    바깥클래스명.안쪽클래스 객체명 = 바깥클래스객체명.new 안쪽클래스의 생성자();
    Outer.Inner in = out.new Inner();
```
3. 내부클래스의 자원을 사용
```java
    내부클래스객체명.변수명 / 내부클래스객체명.method명
``` 

## nested class
- 내부 클래스를 static 변수처럼 사용
- 객체화 없이 사용하는 것을 권장

```java
    클래스명.변수명
    클래스명.method();
```

## local class
> 클래스를 지역변수처럼 사용
- method안에서만 사용되는 클래스

- local클래스 안에서는 method안에 Outer에 변수를 쓸 수 있음
- local클래스에서 지역변수나, parameter는 `final`이 붙은 변수만 사용할 수 있음
- JDK 1.7에서 부터는 `final`이 붙지 않은 변수나 `parameter`를 사용할 수 있음 단, 값을 사용 할 수 있으나 할당은 안됨

**UseLocalOuter$1Local.class**
- class파일명 $ 1뒤에는 method명이 온다.

## anonymous inner class
> class를 Arguments로 사용 할 때
- Arguments=> method parameter에 전달 하는 값
- method의 매개변수로 class나 interface가 사용 되었을 때 주로 사용

```java
    class Test {

        public void method(Fly f){
            f.method();
        }
    }
```

1. 인터페이스를 구현한 클래스 작성
```java
    class Temp implements Fly {
        //추상 method override
    }
```

2. 객체화
```java
    Test t = new Test();
    Fly f = new Temp();
```

3. method 호출
```java
    t.method(f);
```

**anonymous inner class 작성법**
```java
            //이름없는 클래스가 부모가될 클래스를 부모로하여 생성 됨
    method(new 부모가 될 클래스/인터페이스의 생성자() {
        //생성자 부터 닫는 중괄호 영역이 anonymous inner class 영역
        //method 선언
        //Override
    
        구현인터페이스명 객체명 = new 부모클래스명(); 
        부모클래스명 객체명 = new 부모클래스명();
                                //method선언
                                //Override선언
    })
```

## import
> 외부 패키지에 존재하는 `클래스`를 사용할 때 
- `package 선언`과 `class선언` 사이에서 필요한 만큼 정의

**문법**
```java
    //선언된 패키지안의 모든 클래스를 사용하고 싶을 때
    import 패키지명.*;
    //선언된 패키지안의 특정 클래스 하나만 사용할 때
    import 패키지명.class명
```

**사용법**
```java
    package test;

    import java.util.Date;

    class Test{

        Date date;
        Date date1 = new Date();
        
        //- import를 선언하지 않고 외부패키지를 사용하려면 클래스앞에 모든 패키지를 기술하는 full path를 기술해야 한다.
        java.util.Calendar // full path
    }
```

* 주의: 패키지가 다르고 클래스의 이름이 같은 경우에는 하나만 `import`할 수 있음
```java
    import java.util.Date;
    // import java.sql.Date;

    //위에 경우 처럼 패키지가 다르고 클래스의 이름이 같은 경우는 하나는 full path로 처리하고 하나는 import로 처리
    java.sql.Date d = new java.sql.Date();
    Date d1 = new Date();
```

## static import
- JDK 1.5에서부터 추가된 기능
- 다른 클래스의 `static 변수`, `static 메소드`를 클래스명없이 사용할 때

**문법**
```java
- Constant 사용
    import static 패키지명.클래스명.static변수명;
                                   filed명(Constant:상수)

- method 사용
    import static 패키지명.클래스명.method명;
```

```java
packge test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt

        class Test{
                MAX_VALUE;
                parseInt("11"); // 정수의 11
        }
```