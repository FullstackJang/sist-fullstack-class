# **Swing(AWT2라고 함)**
> 디자인이 강조된 윈도우 프로그램을 만들 때 사용

- **특징**
    - 일반적으로 AWT와 같을때 클래스이름 앞에 `J`가 붙는다.
    - 이미지를 다루기 쉽다.
    - Error가 적다.
    - 속도가 빠르다.
    - 만들기 어렵다.(MVC Pattern이 적용된 Component가 존재)
    - `기능`과 `디자인`을 `JVM`이 `모두 저장` 하고 있음

## **Swing 작성법**
1. window component의 `JFrame`을 상속받는다.
```java
    public class Test extends JFrame {
    }
```

2. 생성자 작성
```java
    public Test(){
        super("title-bar에 들어갈 내용");
    }
```
3. 일반 컴포넌트를 생성
```java
    Button => JButton 
//AWT와 호환이 된다. Button으로 사용해도 되지만 Button으로 사용하면 os한테 계속 물어본다.
```

4. 배치(3번에서 생성된 컴포넌트를 붙이는 것)
```java
    add(컴포넌트) //일반 Component가 window Component에 배치 되었다.
                // 일반 Component가 container Component에 배치될 수도 있다.
//  부모 일반
```

5. 윈도우 컴포넌트에 크기 설정
```java
    setSize(w,h);
```

6. 윈도우를 사용자에게 보여주자.
```java
    setVisible(true);
```

# swing의 종료 처리

swing은 x(닫기)버튼이 되지만 종료가 된건 아니다. 즉, setVisible(false);인 상태로 있는거다.
```java
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```