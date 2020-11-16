# List
- **검색의 기능이 있으며, 중복데이터를 저장할 수 있음**
- 일차원 배열에 구조를 가진다.
    - 가변길이 형(개발자가 발생하는 데이터의 갯수를 몰라도 된다.)
- 값을 추가하면 방의 길이(갯수)가 늘어나고, 값을 삭제하면 방의 길이(갯수)가 줄어든다.


자식객체화 보다 Is-A 관계로 객체화를 하여 부모가 제공하는 기능들로 사용한다.

**1. 자식**
> 부모의 모든 method, 자식의 모든 method를 모두 사용 가능
```java
    ArrayList<E> al = new ArrayList<E>();
    //<E>=> Generic
```
**2. 부모**
> Is-A 관계의 객체화, 부모의 모든 method 사용 가능, 자식 method 사용 불가
```java
    List<E> list = new ArrayList<E>();
```

## List 사용법
**1. 생성**
```java
    List<String> list = new ArrayList<String>();
```

**2. 값 추가**
```java
    list.add(E o);
    // E는 Element => String으로 바뀐다.
    // o는 object  => 
    list.add("오늘은");
    list.add("월요일");
    list.add("입니다.");
    
    // 중복값을 저장할 수 있음
    list.add("월요일") // list는 중복값 허용
```

**3. 방의 크기**
```java
    list.size();
```

**4. 값 얻기**
> 검색이 가능하다는 뜻

- 인덱스로 얻기
> Generic으로 설정한 데이터형이 반환 됨
```java
    list.get(0); //Generic으로 설정한 데이터형이 반환 됨
```

- 객체로 얻기
> 같은 객체가 있을 때에만 값을 얻는다.
```java
    list.get("오늘은"); 
    //없으면 null을 반환
```

**5. List가 비었는지**
```java
    list.isEmpty(); // 비어있으면 true리턴
```

**6. 방의 값을 삭제**
```java
    //-모든 방을 삭제
    list.claer();

    //- 리스트 방의 값 삭제: 삭제되면 방의크기가 줄어든다.

    //index 삭제 => 삭제된 이후 방들의 인덱스는 변경된다.
    list.remove(인덱스);
    list.remove(0);

    //방의 내용 삭제
    list.remove(객체);
    list.remove("오늘은");//중복데이터가 존재하면 가장 처음 일치하는 방의 값만 삭제
```

**List의 일괄처리**
```java
    for(int i = 0; i < list.size(); i++){
        list.get(i); //처음 방부터 끝 방 까지 모든 방의 값을 얻는다.
    }
```

**List의 내용을 배열로 복사할 때**
> List에 Generic이 사용된 경우에만 복사 됨
```java
    1. List의 크기대로 배열을 생성
    데이터형[] 배열명 = new 데이터형[list.size()];

    2. 리스트의 내용을 배열로 복사
    list.toArray(배열명);

```
**ArrayList<E> 클래스의 주요 메소드**

|메소드|설명|
|:----|:----|
|boolean add(E element)|ArrayList의 맨 뒤에 element 추가|
|void add(int index, E element)|인덱스 index에 지정된 element 삽입|
|boolean addAll(Collection<? extends E> c|컬렉션 c의 모든 요소를 ArrayList의 맨 뒤에 추가|
|void clear()|ArrayList의 모든 요소 삭제|
|boolean contains(Object o)|ArrayList가 지정된 객체를 포함하고 있으면 true 리턴|
|E elementAt(int index)|index 인덱스의 요소 리턴|
|E get(int index)|index 인덱스의 요소 리턴|
|int indexOf(Object o)|o와 같은 첫 번째 요소의 인덱스 리턴. 없으면 -1 리턴|
|boolean isEmpty()|ArrayList가 비어 있으면 true리턴|
|E remove(int index)| index 인덱스의 요소 삭제|
|boolean remove(Object o)|o 와 같은 첫 번째 요소를 ArrayList에서 삭제|
|int size () | ArrayList가 포함하는 요소의 개수 리턴|
|Object[] toArray()|ArrayList의 모든 요소를 포함하는 배열 리턴|

## Vector<E> vs ArrayList<E>

**공통점**
- List<E> 인터페이스를 구현
- 데이터의 크기를 알 수 없으며, 순차적으로 데이터를 추가 할 때 사용


**차이점**
Vector: Multi Thread에서 동시접근 불가능(동기화 O), 속도가 느림
ArrayList: Mulit Tread에서 동시접근 가능(동기화 X), 속도가 빠름
