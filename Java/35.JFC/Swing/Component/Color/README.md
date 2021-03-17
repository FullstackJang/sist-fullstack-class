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