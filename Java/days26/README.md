# IO(Input / Output)Stream
> java.io 패키지에서 관련 클래스를 제공

- JVM외부에 존재하는 데이터를 JVM내부로 읽어들이거나, JVM내부의 데이터를 JVM외부로 내보낼 때 사용하는 객체들

// 이미지 삽입 입력의 근원 , 출력의 목적지 그림

## 단방향 스트림
- 읽기 스트림은 읽기만 가능 
- 쓰기 스트림은 쓰기만 가능
- 양방향으로 읽고 쓰기를 동시에 할 수 없음

# 스트림 종류
## 8bit stream(byte stream)
- `모든 종류의 데이터`를 읽고 쓸 수 있다.

## 16bit stream(String stream)
- `문자열데이터`를 읽고, 쓸수 있다.

# input stream(입력스트림)

<img src = "https://user-images.githubusercontent.com/69107255/100623568-acdfe580-3365-11eb-9bb3-aa0811bc8d7a.png">

# Output stream (출력스트립)

<img src = "https://user-images.githubusercontent.com/69107255/100623761-f16b8100-3365-11eb-9135-2bd6c76be073.png">


# **입력의 근원 시스템(키보드 입력)**
<img src = "https://user-images.githubusercontent.com/69107255/100623932-28da2d80-3366-11eb-8985-f4977e90eb98.png">

<img src ="https://user-images.githubusercontent.com/69107255/100624732-13b1ce80-3367-11eb-9b38-e6605a982569.png">

- 영어 1자 1byte(8859_1)
- 한글 1자 2byte

- 한글 1자 2byte : KSC5601, EUC-KR, MS949 
- 한글 1자 3byte : UTF-8

```java
//키보드의 입력을 받기위해서는 JVM이 연결한 System.in Stream을 사용해야한다.

try{
    int inputCode=System.in.read();
}catch(IOException ie){

}
```
<img src = "https://user-images.githubusercontent.com/69107255/100626843-a6ec0380-3369-11eb-9d87-cb4afa02d774.png">

<img src = "https://user-images.githubusercontent.com/69107255/100627076-e87cae80-3369-11eb-9453-7cfe16063421.png">

```java
- BufferedReader- 줄 단위로 읽기 : readLine()
- InputStreamReader – 8bit와 16bit 스트림을 연결.
//8bit스트림과 16bit 스트림 연결

InputStreamReader isr=new InputStreamReader( System.in );
//줄 단위로 읽어들이는 기능을 가진 스트림 연결
BufferedReader br=new BufferedReader( isr );
String str=br.readLine();
```

## **stream은 생성되어있으면 memory를 계속 소모한다.**
> 메모리 누수(memory leak)

- 사용이 끝난 스트림은 누수를 막기 위해서 반드시 연결을 끊어야 한다.
    * System 클래스에서 제공하는 표준 스트림(System)은 끊지 않는다.
