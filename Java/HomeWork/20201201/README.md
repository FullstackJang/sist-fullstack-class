```

프로그램 실행하면 JOptionPane.showInputDialog("경로입력");를 제공하여 입력된 값이 정상적인 "경로" (c:/dev)라면 해당 폴더 안에 있는 모든 폴더와 파일을 아래와 같이 JOptionPane.showMessageDialog()에 JTextArea를 사용하여 출력하세요.

이름 수정한날짜 유형 크기
------------------------
Apis 2020-10-21오후 2:28 폴더
.
.
.
.
a.bat 2020-1021오후 2:28 파일 1byte

- 날짜는 long으로 반환되니 Date클래스의 생성자를 사용할 것

정상적인 경로가 아니라면 "경로를 확인하세요"를 JOptionPane.showMessageDialog()로 출력
```