## AWT
> 간단한 윈도우 프로그램을 만들 때 사용

**java.awt 패키지**에서 관련 클래스를 제공함
- **특징**
    - `Component의 기능`만 `제공`
    - 버튼은 Java에서 눌려질 수 있어
    - `OS`에서 `디자인`을 가져온다.
        - OS마다 Component의 모양과 크기가 다르다.
        - 해당 운영체제의 특징에 따라서 화면 구성을 하게 된다. 따라서 운영체제에 따라 느낌이 다르다.
        

- **단점**

- 이미지를 다루기 어렵다.
- Error가 많다.
- 속도가 느리다.
- 만들기 쉽다.

**Component 종류**

##  window Component
> 사용자에게 보여줄 때 사용
- `window`
- `Frame`(창안에 배치 되는것)
- `Dialog`
- `FileDialog`

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
- `Panel`
- `ScrollPane`

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

**AWT Window Component의 종료이벤트 처리**
1. addWindowListener method 호출
```java 	
addWindowListener(WindowListener l)
Adds the specified window listener to receive window events from this window.

WindowListener는 인터페이스 클래스 객체화가 안된다. 자식이 구현 클래스

```
- method의 매개변수가 interface 일 때
    1. `interface`를 구현한 클래스를 만들고, 객체화하여 객체를 넣는다.
    //Mywin은 Frame이다. is-A관계
    //MYwin은 WindowListener이다.
    //자식은 부모이다.

    2. `anonnymouse inner class`를 만든다.
    이름 없는 클래스부모는 바로 앞에 new뒤에 정의된 class나 interface가 된다.

**배치관리자(Layout Manager)**
- awt 패키지에서 사용<br>
- `Non visual Component`: 사용자에게 보여지지 않는다.
- `container Component`, `Component`를 지정 된 위치에 편하게 배치하기 위해 제공
- `window Component`(Jframe),(JDialog) 와 `conatiner Component`(Panel),(ScrollPane)에 적용하여 사용

5가지를 제공
    - BorderLayout
    - FlowLayout
    - GrideLayout
    - GideBagLayout
    - cardLayout

적용방법
1. 배치관리자 생성
```java
 BorderLayout b = new BorderLayout();
```
2. 적용
```java
    window Component //기본 레이아웃:Border Layout
    setLayout(b); //상속을 받았기 때문에 재사용 가능
                 //부모클래스로 JFrame을 상속을 받음
```

```java
    container Component적용하려면 //기본레이아웃:Flow Layout
   2-1 Container Component 생성
    Jpanel jp = new JPanel();
```

2-2 적용
```java
    jp.setLayout(b);
```

**배치 관리자의 특성**

**Border Layout(경계 레이아웃)**
- window Component의 기본 레이아웃

<img src= "https://user-images.githubusercontent.com/69107255/99486906-7c349f00-29a8-11eb-9e42-1d1727ae11fa.JPG" width="500" height="500">

- North, East, West, south등 하나의 `지역`에는 하나의 Component만 배치된다.
- 배치되는 Component는 고유크기가 무시되고 배치되는 곳의 크기에 맞게 변경된다.
- 배치되는 위치를 지정해야한다.(배치위치를 지정하지 않으면 가운데로 배치)
**Border Layout 사용법**
1. 레이아웃 설정
```java
    setLayout(new BorderLayout());
```

2. 배치
```java
    add("영역",Component);

    1. 문자열 상수를 사용해서 배치하는 방법
    add("North", btn);
    add("Center", ta);

    2. BorderLayout의 상수를 사용하여 배치하는 방법
    add(BorderLayout.East,btn); 
```

**Flowlayout(흐름레이아웃)**
- Container Component의 기본 레이아웃
- 배치되는 Component는 고유 크기대로 배치된다.
- 배치는 왼쪽에서 오른쪽의 순서로 배치된다.

**사용법**
1. 배치관리자 생성
```java
    FlowLayout fl = new FlowLayout();
```
2. 배치 관리자를 적용.
```java
    setLayout(fl);
```
1번과 2번을 합쳐서
```java
    setLayout(new Flowout()); //fl객체명을 만들지 않고 사용한다. 아래서 사용할 일이 없기 때문에
```

3. 배치
```java
    add(btn);
    add(jl);
    add(jtf);
    add(btn1);
    //윈도우창을 줄였을때 배치되어있는 component들이 아래로 떨어진다.
```