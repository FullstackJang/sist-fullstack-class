# Override(Overriding)
> 상속관계의 클래스에서 같은 이름의 method를 자식클래스에서 재정의 하는 방법

- 상속관계에서 사용
- 부모클래스가 제공하는 method를 사용할 때
- 기능이 자식 클래스와 맞지않는다면 부모클래스의 method를 자식클래스에서 재정의 하는 것
- 최우선적인 호출: 자식의 method가 가장 먼저 호출
- 규칙: 접근지정자는 달라도 되고, 반환형, method명, 매개변수는 같아야 함 

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

## has a 관계
> 객체명을 사용하여 다른 클래스를 사용
- 객체명.method명();

## annotation(주석달기)
- JDK1.5에서부터 추가된 기능
- Compiler에 명령을 전달할 때 사용
- method위, method안에 사용
    - `@Annotation명`
    - Overriding된 method를 명시하기 위해 method위에 `@Override`를 명시
    JDK1.5에서는 `@Override`, `@SuppressWarnings`, `@Deprecated`가 3개가 추가 

**@Override**
```java
    @Override // 메소드 위 정의
              // Override가 제대로 되었는지 확인할때
```

**Deprecated**
> 지원하지만 동작은 하지만 이상동작을 할 수있는 method 
```java
    @Deprecated // 동작은 하지만 이상동작을 할 수 있는 method위 정의
``` 

**SuppressWarnings**
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

**Object 클래스**
> JVM에서 객체를 제어하는 일들을 정의

## super
- 부모클래스의 자원을 사용할 때
    - `method 형식`
    - `keyword 형식`

## method 형식
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

## keyword 형식
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

## 추상 클래스(abstract class)
> 상속관계에서 부모클래스를 만들 때 사용

**abstract method**
-  `구현에 강제성이 있는 method`(자식클래스에서 반드시 Override하여 사용)
- method의 body가 없는 추상 method를 가진다.
    - method body가 없어 일을 할 수 없다.(자식 클래스가 구현해야할 일의 목록을 만들 때 사용)
- 직접호출하면 ERROR 발생(super.method명() => error)
- 객체화가 되지않는 클래스(자식클래스가 객체화될 때에만 객체가 생성됨)

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