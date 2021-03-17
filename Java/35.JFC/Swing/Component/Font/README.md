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