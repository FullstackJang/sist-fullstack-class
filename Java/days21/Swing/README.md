## **복합레이아웃**
> 제공되는 Layout Manager를 사용하여 복잡한 디자인을 만들 때

1. Frame의 Layout은 BorderLayout으로 설정
2. North영역에 `3개`의 `컴포넌트`가 배치
    - (`라벨`, `텍스트필드`, `버튼`은 Container Component에 배치하여 North 영역에 Container Component 하나를 배치)
3. Center영역에 TextArea 배치

- Jpanel : FlowLayout
- Jframe : BorderLayout
    - BorderLayout은 하나의 영역에 하나의 컴포넌트가 고유 크기를 무시하고 배치된다.

**복합레이아웃**

<img src = "https://user-images.githubusercontent.com/69107255/99621363-178e4880-2a6b-11eb-9e41-49a79774b201.JPG">

## **수동배치**
> 제공되는 Layout Manager를 사용하지 않고 개발자가 배치되는 컴포넌트의 크기와 위치를 직접 설정하는 배치방법

장점
- 배치관리자가 제공하지 않는 복잡한 디자인을 만들 때
- 코딩량이 많아진다. 좌표와 크기 계산을 해야한다.

**수동배치 방법**
1. 자동배치관리자를 해제한다.
    - setLayout(null);
2. 컴포넌트를 생성하고 배치되는 위치와 크기 설정
    - 위치설정 : setLocation(x,y);
    - 크기설정 : setSize(w,h);
    > 위치설정은 `JFrame`에 사용되면 `모니터 왼쪽 상단이 시작점`이고 `Container Component`나 `일반Component`에 사용되면 배치되는 `JFrame의 왼쪽 상단이 시작점`이 된다.
   - 위치와 크기를 한번에 설정: setBounds(x,y,w,h);
  
**수동배치**

<img src = "https://user-images.githubusercontent.com/69107255/99621523-76ec5880-2a6b-11eb-861a-d6d66060200e.png">



## Swing Component 사용법
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
    - **method 사용**
    ```java
        setIcon();

        JButton jb = new JButton(); //아이콘이 없는 버튼 생성
        jb.setIcon(이미지아이콘객체); //method를 사용하여 이미지 설정

    ```
<img src = "https://user-images.githubusercontent.com/69107255/99621612-b450e600-2a6b-11eb-88e4-d2899eaca6a2.png">

**JLabel**
> 이름표
- 컴포넌트의 정보제공
  
```java
    JLabel jl = new JLabel("문자열");
```
**JTextField**
- 한 줄의 문자열을 입력 받을 때

1. 생성
```java
    JTextField jtf = new JTextField(); // 보여주는 글자수가 0글자인 크기
                     new JTextField(5); // 대문자 A기준 5글자를 보여주는 크기
                     new JTextField("문자열")// 문자열이 들어간 상태로 제공
```

<img src= "https://user-images.githubusercontent.com/69107255/99625901-88862e00-2a74-11eb-83e3-9a728b9f8cd6.png">

**JPasswordField**
- 반향문자(EchoChar)를 사용하여 한줄의 문자열을 입력 받을 때
- 반향문자란? 입력한 문자 대신 설정한 문자가 표현되는 것

1. 생성
```java
    JPasswordField jpf = new JPasswordField(); // 크기 설정
    //생성된 JPasswordField는 한글 입력이 안된다.
    //ㄱ ㅏ ㄴ ㅏ *(ehco char)가 한개씩 나오기때문에 안된다.
```
<img src = "https://user-images.githubusercontent.com/69107255/99626348-5923f100-2a75-11eb-81f9-9b9cbb679683.png">

2. 반향문자를 설정할 수 있다.

**JTextArea**
- 여러줄의 문자열을 입력할 때 사용하는 Component

java.awt.TextArea: ScrollBar가 포함 되어 제공
javax.swing.JTextArea : ScrollBar가 별도로 제공

`JTextArea에 ScrollBar`를 제공하기위해 `Container Component`인 `JScrollPane`을 사용한다.

**사용법**

1. JTextArea를 생성
```java
    JTextArea jta = new JTextArea();
```

2. ScrollBar를 가져야하는 컴포넌트를 위해 JScrollPane이 제공.
    - ScrollBar를 가져야할 컴포넌트를 생성하고 JScrollPane과 Has a 관계 설정
```java
    JScrollPane jsp = new JScrollPane(jta); // Has a 관계
```

3. 배치(객체를 가지고 있는 객체를 배치한다.)
```java
    add(jsp);
```

## JCheckBox 
- 여러 개의 선택을 해야 할 때
**생성**
```java
    JCheckBox jcb = new JCheckBox("메시지"); //체크가 해제된 상태로 제공
    JCheckBox jcb = new JCheckBox("메시지",boolean); //체크 여부
```
## JRadioButton
- 여러개 중 하나만 선택해야 할 때
    - ButtonGroup에 포함되어야 여러개 중 하나만 선택 가능한 상태
- 라디오버튼은 버튼 그룹으로 묶여야 하나의 라디오버튼만 선택 가능
    ```java
        ButtonGroup bg = new ButtonGroup();
        bg.add(라디오버튼 객체);
    ```
**생성**
```java
    JRadioButton jrb = new JRadioButton("메시지"); //체크가 해제된 상태로 제공
    JRadioButton jcb = new JRadioButton("메시지",boolean); //체크 여부
```