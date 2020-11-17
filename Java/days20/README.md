##  Swing을 사용해 미니프로젝트로 하는 이유 
상속의 개념을 확실하게 잡을 수 있음.
구현에 개념
클래스에 개념
을 잡을 수 있따.

# JFC(Java Foundation class)
- window용 Application 만들 때 사용하는 class들

- `AWT(Abstract Window Toolkit)`와 `Swing`이 제공

## AWT
> 간단한 윈도우 프로그램을 만들 때 사용

**java.awt 패키지**에서 관련 클래스를 제공함
- **특징**
    - Component의 기능만 제공
    - 버튼은 Java에서 눌려질 수 있어
    - OS에서 디자인을 가져온다.
        - 해당 운영체제의 특징에 따라서 화면 구성을 하게 된다. 따라서 운영체제에 따라 느낌이 다르다.
    - OS마다 Component의 모양과 크기가 다르다.

- **단점**

- 이미지를 다루기 어렵다.
- Error가 많다.
- 속도가 느리다.
- 만들기 쉽다.

## Swing(AWT2라고 함)
> 디자인이 강조된 윈도우 프로그램을 만들 때 사용

- **특징**
    - 이미지를 다루기 쉽다.
    - Error가 적다.
    - 속도가 빠르다.
    - 만들기 어렵다.(MVC Pattern이 적용된 Component가 존재)

- Component Programming
>기능을 가진 최소한의 단위

- 보여주거나 일을 수행할 수 있는 단위
- exe파일을 만들 수 없음
- 그래픽 성능이 많이 떨어진다.

**Component 종류**

##  window Component
> 사용자에게 보여줄 때 사용
`window`,`Frame`(창안에 배치 되는것),`Dialog`,`FileDialog`

```java
// 이렇게 사용하면 창과 화면에 배치되는게 따로 논다.
Window w = new Window();
Frame f = new Frame();
```

```java
    Frame  f = new Frame();
```

## Container Component
> 일반 컴포넌트를 담거나, Container Component를 담아서 배치할 때
- `Panel`,`ScrollPane`

## Component
> 기능을 가지는 최소한의 단위
- `Button`: 클릭하는 일
- `Label`: 이름표
- `TextField`: 한줄의 입력을 받을 때
- `TextArea`: 여러줄의 입력을 받을 때
- `List`: 여러개의 item을 사용 할 때
- `Checkbox`: 여러개의 항목을 선택할 때
- `CheckboxGroup`: checkbox를 묶어서 하나만 선택되도록 만들 때
- `Choice` : 여러개의 아이템 중 하나를 선택하게 할 때

windows Programming
**코딩 순서**
1. window Component를 상속받는다.
```java
    public class MyWin extends Frame{


    }
```

2. 생성자를 정의한다.
> 사용 할 Component 생성
```java
    public MyWin(){
        //3. Component 생성
        Button b = new Button("버튼"); 
    
```

4. 배치
```java
    Container Component, Winddow Component 사용
    add(b);
```

5. 윈도우의 크기 설정
```java
    setSize(w,h);
```

6. 사용자에게 보여주기
```java
    setVisible(true);
    }//MyWin생성자 끝
```

```java
    public static void main(String[] args){
        new MyWin();
    }
```