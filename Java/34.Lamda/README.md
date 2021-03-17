# lamda(람다식)

- 인터페이스를 편하게 사용할 수 있는 문법
- JavaSE 8 (JDK1.8)에서 부터 추가된 문법
- 인터페이스의 `abstract method`가 `하나`인 경우에만 람다식을 사용할 수 있다.
- 구현클래스 없이, `abstract method`를 Override 하지 않아도 interface를 사용할 수 있음 SAM (Single Abstract Method), => @FunctionalInterface

- interface를 정의할 때 interface위에 `@FunctionalInterface`를 사용하면 그 interface는 SAM으로만 작성될 수 있다.

**문법**
```
    인터페이스명 객체명 = (매개변수,,) -> { 코드작성 };
    // 매개변수 부분 () : abstract method의 parameter정의 부
    // 코드작성 부분 {} : abstract method의 구현부 
```

```java
    //====매개변수와 리턴타입이 없을 때========
    public interface Test {
        public void test();
    }

    Test t = () -> {System.out.println("Override");};

    //=========리턴타입이 있을때=======
    public interface Test{
        public String myName();
    }

    Test t = () -> { return "류수정"; };


    //=====매개변수가 있을때=======
    @FuncationalInterface
    public interface Test{
        public void myName(String name);
    }

    Test t = (String n) -> {System.out.println(n);};
    t.myName("류수정");

```