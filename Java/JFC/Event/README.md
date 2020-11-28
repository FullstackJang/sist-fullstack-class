# Event Handling
> Window Application에서 사용자에 동작에 따른 준비된 코드를 만들어 실행시키는 것
- 관련 클래스 제공
    - java.awt.event 패키지
    - javax.swing.event 패키지
- Swing 컴포넌트는 AWT의 이벤트 처리 객체를 사용

|이벤트 종류|처리 리스너(interface)|주 적용 Component|
|:----|:----:|:----:|
|**액션이벤트**<br>(버튼을 클릭, Text Component에서 Enter가 눌렸을 때)|ActionListener|Button, Text Component|
|윈도우 이벤트<br>(Window Component에만 처리)|WindowListener|Frame, Window, Dialog|
|**키보드 이벤트**<br>(키의 입력(Text-Component)이 가능한 Component)|KeyListener|TextField, JTextField, JPasswordField,JTextArea|
|아이템 이벤트<br>(Item을 가지는 Component)|ItemListener|java.awt.List<br> Choice|
|리스트 선택이벤트<br>(Swing Component) 스윙 컴포넌트를 위한 이벤트|javax.swing.event.ListSelectionListener|JList, JComboBox
|**마우스 이벤트**<br>(모든 컴포넌트)|MouseListener|모든 컴포넌트 적용가능|

# 이벤트 처리 방법

1. 이벤트를 처리할 XxxListener를 구현

- Ex) 버튼을 클릭했을 때 이벤트를 처리할 것이다.
```java
    public class Test extends JFrame implements ActionListener {

    }
```

2. 추상method를 Override
```java
    @Override //annotation은 컴파일러에게 명령을 내리는 것
    public void actionPerformed(ActtionEvent ae){
        3. 이벤트가 발생했을때 제공할 기능 구현

    }

```

4. Component를 이벤트에 등록
- 이벤트에 등록하는 method
```java
        addXxxListener(XxxListener);

        Button btn = new Button("버튼");

        btn.addActionListener(이벤트를 처리할 객체);

```


# IS-A관계로 이벤트 처리할 때의 순서
1. 윈도우 컴포넌트를 상속받는다. 이벤트처리 Listener를 구현
```java
    public class Test extends JFrame implements ActionListener {

    }
```

2. 이벤트처리와 관계있는 Component를 instance variable 선언
```java
    private JButton btn;
```

3. 생성자를 정의하고, Component를 생성
```java
    public Test(){
        //컴포넌트 생성
        btn = new JButton("버튼");

        4. Component를 이벤트에 등록
        byn.addActionListener(this);

    }
```

5. 추상 method Override
```java
    public void actionPerformed(ActionEvenet ae){
        6. 이벤트가 발생했을 때 제공할 코드 정의
    }
```

# KeyEvent
> 키보드의 키가 눌렀을 때 동작하는 이벤트

- TextComponent인 TextFiled, JTextFiled, JPasswordField, JTextArea에서 사용할 수 있다.

**사용법**

1. KeyListener를 구현(KeyAdapte를 상속)
```java
    public class Test extends JFrame implements KeyListener {
```
S
2. abstract method Override
```java
    public void keyTyped(KeyEvent ke){
        //1. 키가 눌려지는 순간에 처리해야 할 일
    }//keyTyped

    public void keyPressed(KeyEvent ke){
        //2. 키가 눌려서 문자가 입력되는 순간에 해야 할 일
    }//keyPressed

    public void keyReleased(KeyEvent ke){
        //3. 눌린 키가 올라오는 순간에 해야할 일
    }
```

3. 텍스트 컴포넌트를 이벤트에 등록
```java
    jtf.addKeyListener(이벤트를 처리할 객체);

    //keyEvent로 눌린키의 키코드와 키의 문자를 얻을 수 있다.
    키코드: ke.getKeyCode();
    키의 문자: ke.getKeyChar();
```

# Mouse Event
- Mouse Adapter을 상속받던 anonymousclass를 만들어 사용한다.
- addMouseListener에 등록하여 사용한다.

# 윈도우 이벤트
## XxxxAdapter
> 추상method를 하나 이상 가지고 있는 이벤트 처리용 interface를 미리 구현해 놓은 추상 클래스

- WindowListener를 구현하여 이벤트를 처리하면 windowClosing method하나만 사용하게 된다.
- 나머지 6개의 method는 사용하지 않아도 반드시 구현(Override)해야한다.

WindowListner를 미리 구현한 WindowAdapter를 사용하면 필요한 method하나만 구현하면 된다.
