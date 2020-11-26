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