# Event Handling
> Window Application에서 사용자에 동작에 따른 준비된 코드를 만들어 실행시키는 것
- 관련 클래스 제공
    - java.awt.event 패키지
    - javax.swing.event 패키지
- Swing 컴포넌트는 AWT의 이벤트 처리 객체를 사용

|이벤트 종류|처리 리스너(interface)|주 적용 Component|
|:----|:----:|:----:|:----:|
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

# JOptionPane
> javax.swing.JOptionPane

- 간단한 대화창을 제공할 때 사용하는 클래스<br>
**3가지 제공**
    - ConfirmDialog
    - MessageDialog
    - InputDialog

**특징**

객체를 생성하여 사용하지 않는다.

## ConfirmDialog
- 사용자의 의향을 물어볼 때 : 예, 아니오
```java
    int flag = JOptionPane.showConfirmDialog(윈도우컴포넌트,"메시지");
```

```java
 	switch(flag) {
		case JOptionPane.OK_OPTION:
			dispose();
			break;
			
		case JOptionPane.NO_OPTION :
			System.out.println("아니오");
			break;
		case JOptionPane.CANCEL_OPTION :
			System.out.println("취소");
	}//end switch
```

## MessageDialog
- 사용자에게 단순 정보를 제공할 때
```java
    JOptionPane.showMessageDialog(윈도우컴포넌트,"메시지");
```

## InputDialog
- 사용자가 입력하는 메시지를 받을 때
```java
String msg = JOptionPane.showInputDialog("메시지");
```

# 이벤트 비교처리
* 이벤트를 발생시킨 컴포넌트에 대한 비교처리
- 위치: 이벤트 처리 method(Override한 method안)

1. 이벤트 등록
```java
    btn.addActionListener(this); // -> actionPerformed
    tf.addActionListener(this); // -> actionPerformed
```

2. 이벤트 처리 method에서 매개변수로 입력되는 객체(XxxAction)를 사용하여 비교
```java
    public void actionPerformed(ActionEvent ae){
        /*매개변수로 입력되는 이벤트 객체는 이벤트를 발생한*/ **객체의 주소** /*를 얻을 수 있다.*/
    
        //getSource는 EventObject클래스
        if(ae.getSource(); == btn) { // 이벤트를 발생시킨 객체의 주소가 btn과 같은지 비교
                //btn에 대해서 처리할 코드
        }

        else if(ae.getSource() == tf) {
                //tf에 대해서 처리할 코드
        }
    }
```

### JPasswordField의 값 얻기
```java
    JPasswordField jpf = new JPasswordField();

    char[] pass = jpf.getPassword();
    //char[]은 다른 배열과는 다르게 출력하면 주소가 아닌 값이 출력된다.

    //문자열로 저장
    1. 생성자 사용
    String str = new String(pass);

    2. valueOf() 사용
    String str = String.valueOf(pass);

```

# Has-A관계의 이벤트 처리
- 디자인을 구현한 클래스와 이벤트를 처리하는 클래스를 구분하여 만들 수 있다.


1. 디자인 클래스를 생성
    - 1-1. 윈도우 컴포넌트를 상속
    ```java
        public class Test extends JFrame {

        
    ```
    - 1-2. 이벤트 처리대상 Component를 선언
    ```java
        JButton btn;
    ```

    - 1-3. 생성자를 작성하고, Component를 생성 
    ```java
        public Test(){
            btn = new JButton("click");
        }
    ```
    - 1-4. 이벤트처리객체를 생성하고, 이벤트를 등록
    ```java
        TestEvt te = new TestEvt(this); //has a 관계

        btn.addActionListener(te);
    }
    ```

    - 1-5. 이벤트처리클래스에서 디자인 클래스의 Component를 사용하기 위해 getter method 작성
    ```java
        public JBtutton getBtn(){
            return btn;
        }
    ```

1. 이벤트 클래스를 생성

    1,이벤트 클래스 생성

    1-1. 이벤트 객체를 구현
    ```java
    public class TestEvt implements ActionListener {
    ```

    1-2. 디자인 클래스를 인스턴스 변수로 선언
    ```java
        private Test t;
    ```

    1-3. 생성자에서 디자인 클래스의 객체를 전달받는다.
    ```java
        public TestEvt(Test t){
            this.t = t;
        }
    ```

    1-4. 추상method Override
    ```java
        public void actionPerformed(ActionEvent ae) {
            //이벤트가 발생했을 때 처리 할 코드
            //버튼이 클릭되었을 때 사용자에게 제공할 코드
        }
    ```

# Font 클래스의 사용
> java.awt패키지에서 제공

- Non Visual Component로 컴포넌트의 폰트(글꼴,크기,스타일)정보를 변경해 주는 일을 하는 클래스

**사용법**

1. 객체생성

```java
    Font fnt = new Font("글꼴","스타일","크기");
    /*
    글꼴
       - Dialog
       - DialogInput 
       - Monospaced 
       - Serif
       - SansSerif
    */
    /*스타일
       - PLAIN
       - BOLD
       - ITALIC (for example, bitwise BOLD|ITALIC)
    */
    Font fnt = new Font("SansSerif",Font.BOLD,20);
```

2. font를 적용할 Component에 setFont()를 사용하여 생성된 font를 적용
```java
    JButton jbtn = new JButton();
    jbtn.setFont(fnt);
```

# Color클래스
> Non Visual Component로 Component의 글자색,바닥색을 변경할 때 사용

- 몇 가지 색은 Constant로 제공, 복잡한 색은 RGB color로 설정
글자색(전경색): Foreground Color
```java
    컴포넌트 객체명.setForeground(Color.색상); //Constant로 전경색 설정
```

바닥색: Backgroud Color
```java
    컴포넌트 객체명.setBackground(Color.생상);

    투명도를 해제 : setOpaque(true);
```

# 윈도우 이벤트

# XxxxAdapter
> 추상method를 하나 이상 가지고 있는 이벤트 처리용 interface를 미리 구현해 놓은 추상 클래스

- WindowListener를 구현하여 이벤트를 처리하면 windowClosing method하나만 사용하게 된다.
- 나머지 6개의 method는 사용하지 않아도 반드시 구현(Override)해야한다.

WindowListner를 미리 구현한 WindowAdapter를 사용하면 필요한 method하나만 구현하면 된다.
