# Set
- **검색의 기능이 없으며, 중복데이터를 저장 할 수 없음**

- 값이 순차적으로 들어가지 않는다.
- 일차원 배열의 구조를 가진다.
    - 가변길이 형
- 모든 데이터를 저장할 수 있다.

1. **생성**
```java
    //1.
    HashSet<E> hs = new HashSet<E>();

    //2.
    Set<E> s = new HashSet<E>();
```

2. **값 추가**
> 입력되는 값은 순차적으로 들어가지 않음
- 중복값은 입력되지 않음
```java
    set.add(값);
```

3. **크기**
```java
    set.size();
```

4. **값 삭제**
- 방하나 삭제: index로 값을 삭제할 수 없음 => 데이터에 순서가 없기 때문에
```java
    set.remove(Object);
            //Object에는 합당하는 Wrapper Class를 사용한다.
```

5. **모든 방의 값을 삭제**
```java
    set.clear();
```

6. **값얻기**
## Iterator사용
- java.util.Iterator를 사용

`Iterator`는 입력되는 `대상의 제어권`을 얻어 `값`을 얻는 일을 하는 객체

iterator에 제어권을 할당
```java
Iterator<E> ita = Set.iterator();
```

7. **값이 존재하는지?**
```java
    while(ita.hasNext()){ // 다음 요소가 존재하는지 ?

        //8. 값얻기
             ita.next // 값을 얻고 포인터를 다음으로 이동 시킨다.

    }
```

**Iterator 객체에서 사용할 수 있는 method**
|메소드|설명|
|----|----|
|boolean hasNext()|다음 반복에서 사용될 요소가 있으면 true 리턴|
|E next()|다음 요소 리턴|
|void remove()|마지막으로 리턴된 요소 제거|
