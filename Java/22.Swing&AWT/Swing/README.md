## Swing(AWT2라고 함)
> 디자인이 강조된 윈도우 프로그램을 만들 때 사용

- **특징**
    - 일반적으로 AWT와 같을때 클래스이름 앞에 `J`가 붙는다.
    - 이미지를 다루기 쉽다.
    - Error가 적다.
    - 속도가 빠르다.
    - 만들기 어렵다.(MVC Pattern이 적용된 Component가 존재)
    - `기능`과 `디자인`을 `JVM`이 `모두 저장` 하고 있음

**Swing 작성법**
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

**GridLayout(격자 레이아웃)**
- `행`과 `열`로 구성된 레이아웃
- 컴포넌트의 크기가 동일하게 배치되는 레이아웃
- 컴포넌트는 배치하는 순서대로 왼쪽에서 오른쪽 순으로 배치된다.

**GridLayout(격자 레이아웃)의 문법**
1. 레이아웃 관리자 생성
```java
    GrideLayout gl = new GridLayout(행(row),열(column));
```

2. 배치관리자 적용
```java
    setLayout(gl);
```

1번과 2번을 합친다.
```java
    setLayout(new GrideLayout(행,열));
```

3. 컴포넌트 배치
```java
    //3행 2열로 하려면 add()를 6번해야한다.
    add(btn); //add해서 버튼을 붙여주겠어
    add(bt2); //add해서 버튼2를 붙여주겠어
```

**GridBagLayout**
> 행마다 열의 크기,갯수를 다르게 보여줄 때 사용
- 수동 배치

**cardLayout**
- Container Component에만 적용할 수 있는 레이아웃
- 한정적인 공간에 다른 디자인을 제공할 때 사용(tab의 역할)
- 여러개의 Container Component를 만들어 두고 그 중 하나의 Container Component를 보여줄 때 사용


**swing의 종료 처리**
> swing은 x(닫기)버튼이 되지만 종료가 된건 아니다. 즉, setVisible(false);인 상태로 있는거다.
```java
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```