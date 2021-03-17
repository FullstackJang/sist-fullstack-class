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