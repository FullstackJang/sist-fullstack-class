# **Swing Component 사용법**

## 이미지  
> ImageIcon 클래스로 이미지를 손쉽게 사용할 수 있다.
- Component가 Icon을 매개변수로 정의하고 있으면, ImageIcon을 생성하여 넣어줄 수 있다.

**사용법**
1. ImageIcon객체화 : 이미지파일의 경로는 `절대경로(c:/)`를 사용한다.
```java
    ImageIcon ii = new ImageIcon("이미지파일경로");
```

2. 이미지를 사용할 컴포넌트에서 이미지아이콘 객체를 설정(2가지 방법이 있다.)
    - **생성자를 사용**
    ```java
        JButton jb = new JButton();
    ```
    - **setIcon() 사용**
    ```java
        JButton jb = new JButton(); //아이콘이 없는 버튼 생성
        jb.setIcon(이미지아이콘객체); //method를 사용하여 이미지 설정

    ```
<img src = "https://user-images.githubusercontent.com/69107255/99621612-b450e600-2a6b-11eb-88e4-d2899eaca6a2.png">

# **JLabel**
- 이름표 역할
- 컴포넌트의 정보제공
  
```java
    JLabel jl = new JLabel("문자열");
```
# **JTextField**
- 한 줄의 문자열을 입력 받을 때

1. **생성**
```java
    JTextField jtf = new JTextField(); // 보여주는 글자수가 0글자인 크기
                     new JTextField(5); // 대문자 A기준 5글자를 보여주는 크기
                     new JTextField("문자열")// 문자열이 들어간 상태로 제공
```

<img src= "https://user-images.githubusercontent.com/69107255/99625901-88862e00-2a74-11eb-83e3-9a728b9f8cd6.png">

# **JPasswordField**
- 반향문자(EchoChar)를 사용하여 한줄의 문자열을 입력 받을 때
- 반향문자란? 입력한 문자 대신 설정한 문자가 표현되는 것
- 
<img src = "https://user-images.githubusercontent.com/69107255/99626348-5923f100-2a75-11eb-81f9-9b9cbb679683.png">

1. **생성**
```java
    JPasswordField jpf = new JPasswordField(); // 크기 설정
    //생성된 JPasswordField는 한글 입력이 안된다.
    //ㄱ ㅏ ㄴ ㅏ *(ehco char)가 한개씩 나오기때문에 안된다.
```


2. **반향문자를 설정할 수 있다.**

# **JTextArea**
- 여러줄의 문자열을 입력할 때 사용하는 Component

- java.awt.TextArea: ScrollBar가 포함 되어 제공
- javax.swing.JTextArea : ScrollBar가 별도로 제공

`JTextArea에 ScrollBar`를 제공하기위해 `Container Component`인 `JScrollPane`을 사용한다.

<img src = "https://user-images.githubusercontent.com/69107255/100498904-de5f8200-31a8-11eb-910e-d2fac48d74b0.png">

**사용법**

1. **JTextArea를 생성**
```java
    JTextArea jta = new JTextArea();
```

2. **ScrollBar를 가져야하는 컴포넌트를 위해 JScrollPane이 제공.**
    - ScrollBar를 가져야할 컴포넌트를 생성하고 JScrollPane과 Has a 관계 설정
```java
    JScrollPane jsp = new JScrollPane(jta); // Has a 관계
```

3. **배치(객체를 가지고 있는 객체를 배치한다.)**
```java
    add(jsp);
```

# **JCheckBox**
- 여러 개의 선택을 해야 할 때

<img src = "https://user-images.githubusercontent.com/69107255/100499114-55e1e100-31aa-11eb-909e-3f1132573a36.png">

```java
    JCheckBox jcb = new JCheckBox("메시지"); //체크가 해제된 상태로 제공
    JCheckBox jcb = new JCheckBox("메시지",boolean); //체크 여부
```

# **JRadioButton**
- 여러개 중 하나만 선택해야 할 때
    - ButtonGroup에 포함되어야 여러개 중 하나만 선택 가능한 상태
- 라디오버튼은 버튼 그룹으로 묶여야 하나의 라디오버튼만 선택 가능

<img src = "https://user-images.githubusercontent.com/69107255/100499135-7c078100-31aa-11eb-9165-6ccd213e4a7f.png">

```java
    JRadioButton jrb = new JRadioButton("메시지"); //체크가 해제된 상태로 제공
    JRadioButton jcb = new JRadioButton("메시지",boolean); //체크 여부
```

```java
        ButtonGroup bg = new ButtonGroup();
        bg.add(라디오버튼 객체);
```

# JMenu
> 고정된 위치에서 사용자에게 서비스를 제공할 때

**`MenuBar`,`JMenu`,`MenuItem`으로 구성**

- **MenuBar** : Menu들이 배치되어 제공되는 바
- **JMenu** : 비슷한 일을 하는 JMenuItem을 묶어서 제공하기 위한 컴포넌트 
- **MenuItem** : 개별적인 일을 제공하기 위한 컴포넌트


<img src="https://user-images.githubusercontent.com/69107255/99808538-5cf26900-2b84-11eb-9e55-e8cc1717213d.png">

**사용법**
1. **JMenuBar 생성**
```java
    JMenuBar jmb = new JMenuBar();
```

2. **JMenu 생성**
```java
    JMenu m = new JMenu("대표이름");
```

3. **JMenuItem생성**
```java
    JMenuItem mi = new JMenuItem("서비스할 이름");
```

4. **생성된 JMenuItem을 Menu배치**
```java
    m.add(메뉴아이템 객체);

    m.add(다른 메뉴객체); // 메뉴아이템에서 하위 메뉴를 제공할 때
```

5. 메뉴아이템을 가진 메뉴가 JMenuBar에 배치
```java
    mb.add(메뉴 객체);
```

6. JMenuBar를 Window Component에 배치
```java
    setJMenuBar(메뉴바 객체);
```

# TitledBorder
> 테두리를 가진 제목 설정하는 Component
<img src ="https://user-images.githubusercontent.com/69107255/99808924-eefa7180-2b84-11eb-9852-34ef35349c4c.png">

**사용법**

1. 생성
- 대부분의 `Component`는 `border`를 가질 수 있다.<br>
**javax.swing.border 패키지**에는 테두리를 설정할 수 있는 Component가 제공
```java
    TitledBorder tb = TitledBorder("제목"); 
```

2.border가 필요한 Component에 생성한 border 설정
```java
    JButton jbtn = new JButton("난 버튼");

    jbt.setBorder(tb);
```

# MVC Pattern을 도입하여 제작된 컴포넌트들
> 파일 하나에서 서로 다른 생명주기를 가진 코드를 분리한 것
- `Jcombo`
- `JList`
- `JTable`

## 특징

**장점**
- 소스코드의 복잡도가 낮아진다.
- 업무를 구분하여 작성하기 좋다.(**유지보수의 편의성 향상** => 프로그램에 생명이 길어짐)

**단점**
- 파일이 많이 생성되므로 파일관리의 복잡도 상승
- 값의 처리가 어렵다.
- 에러처리가 어렵다.

-  MVC(Model, View, Controller)
> `하나의 서비스`를 `분해`하여 `구현`하는 개발 방식(Design Pattern)

서로다는 작업을 분해하여 구현하는 개발 방식

- Model: 데이터를 관리하고 처리하는 일
- View: 데이터를 보여주는 일
- Controller: 이벤트 처리, 업무로직(Business Logic:연산,제어) 구현하는 일

<img src="https://user-images.githubusercontent.com/69107255/99808796-beb2d300-2b84-11eb-8a16-29b3cd19f9a8.png">

# JComboBox

<img src = "https://user-images.githubusercontent.com/69107255/100503424-8d06c100-31af-11eb-899e-340e5482bd89.png">

**사용법**
1. 데이터를 가진 `Model클래스`를 생성
```java
    DefaultComboBoxModel<E> dcbm = new DefaultComboBoxModel<E>(); 
```

2.  Model 객체에 데이터 추가
```java
    dcbm.addElement(값); //인자값으로 어떤 데이터에 타입이든 받을 수 있다.
```

3. 데이터를 보여줄 `View 클래스`를 생성
```java
    JComboBox jcb = new JComboBox(dcbm);
```


# JList
- JList는 `ScrollBa`r가 없다.

<img src = "https://user-images.githubusercontent.com/69107255/100504059-bcb5c900-31af-11eb-8e66-6bebc5e2e4a0.png">

**사용법**
1. 데이터를 가진 `Model클래스`를 생성
```java
    DefaultListModel<E> dlm = new DefaultListModel<E>(); 
```

2.  Model 객체에 데이터 추가
```java
    dlm.addElement(값); //인자값으로 어떤 데이터에 타입이든 받을 수 있다.
```

3. 데이터를 보여줄 `View 클래스`를 생성
```java
    JList jl = new JList(dlm);
```

4. ScrollBar 설정
```java
    JScrollPane jsp = new JScrollPane(jl); //JScrollPane과 jl은 has a관계
```


# JTable
> 데이터를 시안성을 높여 보여줄 때

<img src = "https://user-images.githubusercontent.com/69107255/100504565-e2db6900-31af-11eb-9f74-9bc6a7dabad7.png">

**사용법**
1. 데이터를 가진 Model 클래스를 생성
- javax.swing.table.DefaultTableModel 클래스를 제공
- 컬럼명을 일차원 배열로 생성
```java
> String[] columnNames={"컬렴명","컬렴명","컬렴명"};
```
- 데이터는 2차원 배열로 생성
```java
    String[][] rowData = {{"값","값","값","값"},
                          {"값","값","값","값"}
                         };
```

```java
    DefaultTableModel dtm = new DefaultTableModel(rowData,columnNames);
```

2. Model 객체에 데이터 추가

- 배열
```java
    String[] data = {"값",,,,};
    
    dtm.addRow(data);
```
- Vector
> is a 관계의 객체화로 객체를 생성하지 않는다.
```java
    Vector<E> vec = new Vector<E>();

    vec.add("값"); // 컬럼의 개수 만큼 add를 사용하여 값을 추가

    dtm.addRow(vec);

```

3. 데이터를 보여줄 View클래스 생성
> swing패키지에 있음
```java
    JTable jt = new JTable(dtm);
```
4. JTable은 ScrollBar를 가지고있지 않다.
> JScrollPane을 사용하지 않고 JTable을 직접 배치하면 Table의 header가 보여지지 않는다.
```java
    JScrollPane jsp = new JScrollPane(jt);
```

# **JOptionPane**
> javax.swing.JOptionPane

- 간단한 대화창을 제공할 때 사용하는 클래스<br>
**3가지 제공**
    - ConfirmDialog
    - MessageDialog
    - InputDialog

**특징**

객체를 생성하여 사용하지 않는다.

## **ConfirmDialog**
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

## **MessageDialog**
- 사용자에게 단순 정보를 제공할 때
```java
    JOptionPane.showMessageDialog(윈도우컴포넌트,"메시지");
```

## **InputDialog**
- 사용자가 입력하는 메시지를 받을 때
```java
String msg = JOptionPane.showInputDialog("메시지");
```

# FileDialog
- java.awt 패키지에서 제공하는 Window Component
- 파일을 선택할 때 사용
- Windows OS에서 제공하는 Dialog를 사용
- 반드시 **부모 창(Window,Frame,Diallg)**이 필요하다.

**사용법**

1. 생성: mode - 열기(FileDialog.LOAD), 저장(FileDialog.SAVE)
```java
    FileDialog fd = new FileDialog(Frame, "title bar에 들어갈 문자열",mode); 
```

2. 사용자에게 보여주기
```java
    fd.setVisible(true);
```

3. 선택한 폴더 얻기
```java
    String directory = fd.getDirectory();
```

4. 선택한 파일명얻기
```java
    String file = fd.getFile();
```

# JDialog
> Window Component

- Window(Frame)에서 부가적인 정보를 제공할 때 사용하는 윈도우 컴포넌트
- modal이란? 자식 창이 동작했을 때 부모창이 선택되지 못하는 것
- non-modal이란? 자식 창이 동작했을 때 부모창이 선택되는 것

## JDialog를 상속하지 않고 생성하는 방법(배치되는 Component의 수가 적을 때)
**사용법**
1. 생성
- JDialog의 Layout은 BorderLayout이다.
```java
    JDialog jd = new JDialog(부모 창, "타이틀 바 내용", modal여부);
```

2. 다이얼로그에 배치 될 Component 생성
```java
    JButton jb = new JButton("버튼");
```

3. 배치
```java
    jd.add("Center",jb);
```

4. 다이얼로그의 크기 설정
```java
    jd.setSize(); or
    jd.setBounds();
```

5. 다이얼로그의 가시화
```java
    jd.setVisible(true);
```

6. 다이얼로그의 종료 처리
```java
    jd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
```

## JDialog를 상속하여 사용하는 방법(배치되는 Component의 수가 많거나 복잡할 때)

1. JDialog를 상속받는다.
```java
    public class Test extends JDialog {
```

2. 부모 창(JFrame을 상속받고 있는 클래스)과 Has a 관계를 설정하는 생성자
```java
    public Test(ParentWindow pw){
        super(pw,"다이얼 로그 타이틀",true);
    }
```

3. 다이얼로그에 배치 될 Component 생성
```java
    JButton jbtn = new JBtton("버튼");
```

4. 배치
```java
    add("Center",jbtn);
```

5. 다이얼로그의 크기 설정
```java
    setSize(W,H);
```

6. 다이얼로그를 사용자에게 보여주기
```java
    setVisible(true);
```

7. 종료
```java
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
```