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

## stream은 생성되어있으면 memory를 계속 소모한다.
- 메모리 누수(memory leak)

사용이 끝난 스트림은 누수를 막기 위해서 반드시 연결을 끊어야 한다.
* System 클래스에서 제공하는 표준 스트림은 끊지 않는다.


# **입력의 근원 시스템(키보드 입력)**
<img src = "https://user-images.githubusercontent.com/69107255/100623932-28da2d80-3366-11eb-8985-f4977e90eb98.png">

<img src ="https://user-images.githubusercontent.com/69107255/100624732-13b1ce80-3367-11eb-9b38-e6605a982569.png">

## Charst: 문자집합
- 완성형(모든 글자가 만들어져 있는 문자 집합)
- 8859_1 : 1byte
- KSC5601: 2byte 국내표준
- EUC-KR : 2byte 국제표준 // 아햏햏,뷁,섊 이런 단어가 없음
- MS949
- UTF-8


## 조합형
- 자음코드와 모음코드를 조합하여 문자를 표현하는 문자 집합