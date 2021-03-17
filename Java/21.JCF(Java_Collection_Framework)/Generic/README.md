## Generic을 사용하지 않았을 때
1. 생성(<E>: 사용X) - 모든 `객체`를 저장할 수 있다.
```java
    List l = new ArrayList();
```

2. 값 추가
> 모든 값을 추가할 수 있음
```java
    l.add((new Integer(10)));
    l.add((new Integer(20)));
    l.add(30); // l.add((new Integer(30)));과 동일
    l.add("오늘은 월요일");
```

3. 크기(방의 갯수)
```java
    l.size();
```

4. 값 얻기
```java
    l.get(10); //0번째방 나옴
    
    for(int i =0; i < l.size(); i++){
        l.get(i);
    }
```

**Autoboxing 방법**
> JDK1.5에서부터 추가
- JCF에 기본형 데이터형의 값을 추가할 때
- 기본형 데이터형을 Wrapper Class로 감싸서 입력하는 일(기본형 -> 객체)

JDK 1.8(Java SE8)까지는 Wrapper Class의 생성자를 사용하여 값을 넣지만, JDK 1.9(Java SE9)에서 부터는 static method를 사용하게 된다.

JDK1.8 => list.add(10) // list.add(new Integer(10));
JDK1.9 => list.add(10) // list.add(Integer.intValue(10));

**언박싱(un boxing)방법**
- JDK1.5에서부터 추가
- JCF에서 입력된 기본형 데이터형을 얻을 때 동작
- Wrapper Class로 입력된 데이터형을 기본형으로 풀어서 꺼내는 일(객체->기본형)

```java
    int i = list.get(0);
    //int i = ((Integer)list.get(0).intValue());
```