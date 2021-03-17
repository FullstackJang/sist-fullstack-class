# Override(Overriding)
> 상속관계의 클래스에서 같은 이름의 method를 자식클래스에서 재정의 하는 방법

- 상속관계에서 사용
- 부모클래스가 제공하는 method를 사용할 때
- 기능이 자식 클래스와 맞지않는다면 부모클래스의 method를 자식클래스에서 재정의 하는 것
- 최우선적인 호출: 자식의 method가 가장 먼저 호출
- 규칙: 접근지정자는 달라도 되고, 반환형, method명, 매개변수는 같아야 함 

## 상속
> 코드의 재사용성 향상

## extends
> 자식클래스에서 부모클래스를 선택

### 클래스간 계층
- 부모 클래스: 공통 특징 정의
- 자식 클래스: 공통특징은 부모 것을 사용 + `자신의 특징을 정의`


- **Overriding예시 코드**
    - OverrideSuper.java  [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/OverrideSuper.java)
    - OverrideSub.java [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/OverrideSub.java)
    - OverrideSub2.java [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/OverrideSub2.java)
    - RunOverride.java (Main) [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/RunOverride.java)

## is-a 관계
> `부모클래스로 데이터형을 선언`하고 `자식클래스를 생성해서 할당` 하는 것
- 부모클래스의 variable과 method만 호출 가능
- 자식클래스에 부모클래스에 Override한 method가 있으면 그 method를 호출
- 내 클래스에 정의 된 것처럼 사용
    - method명();

### 상속관계의 객체화(is-a 관계의 객체화)
> 객체 다형성을 사용할 때

```java
부모클래스명 객체명 = new 자식클래스생성자();
```
### 객체 다형성
- 부모클래스로 다양한 자식클래스의 객체를 저장할 수 있음
- 어떤 자식이 부모한테 대입되었는지에 따라 다른 기능을 사용 할 수 있음

## has-a 관계
> 객체명을 사용하여 다른 클래스를 사용
- 객체명.method명();


**Object 클래스**
> JVM에서 객체를 제어하는 일들을 정의

## super
- 부모클래스의 자원을 사용할 때
    - `method 형식`
    - `keyword 형식`

- **super 예시코드**<br>
    - SuperA.java [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/SuperA.java)<br>
    - SubA.java [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/SubA.java)<br>
    - Run.java(Main) [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/Run.java)<br>

### method 형식
> 부모클래스의 생성자를 호출할 때 사용

- 모든 클래스의 생성자의 첫 줄에는 `super();`가 생략되어 있음
- 생성자의 첫번째 줄에서만 사용 가능
```java
    super(); // default 생성자
    super(값); // 매개변수 받는 생성자
```

**부모클래스 Test.java**
```java
    class Test extends Object{
        public Test() {
            super(); // Object생성자 호출
        }
    }
```

**자식클래스 TestSub.java**
```java
    class TestSub extends Test{
        public TestSub(){
            super(); // 생략되더라도 default 부모클래스 생성자가 불림
        }
    }
```

### keyword 형식
- 부모 객체의 시작 주소를 저장하고 있음
- 부모 클래스와 자식클래스가 같은 이름의 변수,method를 가지고 있는 경우 식별하여 사용할 때

**instance영역에서만 사용가능**
```java
    super.변수명;0
    super.메소드명();
```

**부모클래스 Test.java**
```java
    class Test{
        int i;
        int j;

        public void useVar() {
            System.out.println(i + "/" + j);
        }
    }
```

**자식클래스 TestSub.java**
```java
    class TestSub extends Test {
        int i;
        
        public void UseI(){
            super.j= 10;
            super.useVar();
             System.out.println(this.i); // this가 숨어있다.
        }
        public static void main(String[] args) {
            TestSub ts = new TestSub();
	    }
    }
```

- **TestSuper.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/TestSuper.java)
- **TestSub.java(Main)** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/TestSub.java)

## 추상 클래스(abstract class)
> 상속관계에서 부모클래스를 만들 때 사용

**abstract method**
-  `구현에 강제성이 있는 method`(자식클래스에서 반드시 Override하여 사용)
- method의 body가 없는 추상 method를 가진다.
    - method body가 없어 일을 할 수 없다.(자식 클래스가 구현해야할 일의 목록을 만들 때 사용)
- 직접호출하면 ERROR 발생(super.method명() => error)
- 객체화가 되지않는 클래스(자식클래스가 객체화될 때에만 객체가 생성됨)

- **AbstractSuper.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/AbstractSuper.java)<br>
- **AbstractSub.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/AbstractSub.java)

```java
    abstract class 클래스명
    변수: instatnce_Varialbe, static_Varialbe
    method: instance_Method, static_Method
    abstract_method // method의 body가 없는 추상 method를 가진다.
```

**추상 클래스(abstract class)**
```java
    접근지정자 abstract 반환형 method명(매개변수);
```
**추상클래스 작성법**
```java
    접근지정자 abstract class 클래스명 extends 부모클래스명 implements 구현인터페이스들..
```

**추상 클래스 예시코드**
- **Person.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/Person.java)
```java
Person.java

public abstract class Person {
        /**
        * 사람 객체의 동사적인 특징
        * 사람객체가 집에서 먹는 일 구현
        * @return 밥먹는 행동
        */
        public abstract String eat();

        /**
        * method overload: 같은 이름의 method를 여러개 만드는 것
        * 사람 객체가 밖에서 사먹는 일
        * @param menu 음식 종류
        * @param price 음식 가격
        * @return 식당에서 사먹는 일
        */
        public abstract String eat(String menu, int price);

        /**
        * 사람이 구사하는 언어 
        * @return
        */
        public abstract String[] language(); 
    }
```

- **HongGilDong.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/HongGilDong.java)

```java
HongGilDong.java

public class HongGilDong extends Person {
        @Override
        public String eat(String menu, int price) { //오버로딩
            return super.getName() + "이(가) 주막에서 " + menu + "인 음식을 "+ price +"냥 내고 사먹었습니다."; 
        }//eat

        @Override
        public String eat() {
            return getName()+"이 집에서 밥을 먹는다.";
        }//eat

        @Override
        public String[] language() {
            
            String[] lang = {"한국어","중국어"};
            return lang;
        }//language
    }
```
- **Clark.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/Clark.java)
```java
Clark.java

public class Clark extends Person {
            @Override
        public String eat() {
            //name변수는 private이기 때문에 자식클래스에서 사용할 수 없다.
            //부모클래스의 private 변수는 setter method나 getter method를 사용하여 접근한다.
            return super.getName() + "이 집에서 '빵'을 먹는다."; 
        }//eat

        @Override
        public String eat(String food, int price) { //오버로딩
            return super.getName() + "이 레스토랑에서 " + food + "인 음식을 "+ price +"$ 내고 사먹었습니다."; 
        }//eat

        @Override
        public String[] language() {
            String[] lang = new String[3];
            lang[0] = "영어";
            lang[1] = "독일어";
            lang[2] = "외례어";
            return lang;
        }//language
    }
```
- **UsePerson.java(Main)** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days15/UsePerson.java)

```java
UsePerson.java

    public class UsePerson{
            public static void main(String[] args) {

            String[] hongLang = hgd.language();
            for(int i=0; i < hongLang.length; i++) System.out.println(hongLang[i]);
        
            String[] Clark = superman.language();
            for(int i=0; i < Clark.length; i++) System.out.println(Clark[i]);
        }
    }
```