# JCF (Java Collection Framework)
- 자료구조
    - 데이터를 `상황`에 따라 편하게 처리하기 위해 제공하는 객체들

- `Collection계열`, `Map계열`로 구분
- java.util.package에서 제공
- JDK1.5에서부터 `Generic`,`Autoboxing`,`unboxing` 지원
- 자바에서 발생하는 모든 데이터를 저장할 수 있음

<img src ="https://user-images.githubusercontent.com/69107255/99204158-1a353780-27f8-11eb-9fd8-8957290e456c.JPG">


## Generic
> 입력되는 데이터형의 형 제한
- JDK1.5에서 부터 추가

## Generic을 사용해야하는 이유
- 잘못된 타입이 사용될 수 있는 문제를 컴파일 과정에서 제거할 수 있기 때문
- E에 특정 타입으로 구체화

**문법**
```java
    ArrayList<E> al = new ArrayList<E>();
    //<E>에 사용할 수 있는 건 기본형 데이터형은 사용할 수 없다.
    // 참조형 데이터형만 사용 가능

    //JDK 1.7에서부터는 생성자의 Generic을 생략할 수 있다.
    ex)
    ArrayList<Integer> al = new ArrayList<Integer>();
    ArrayList<Integer> al = new ArrayList(); // 생성자 Generic 생략 가능
```