# JMenu
> 고정된 위치에서 사용자에게 서비스를 제공할 때

**`MenuBar`,`JMenu`,`MenuItem`으로 구성**

- MenuBar: Menu들이 배치되어 제공되는 바
- JMenu: 비슷한 일을 하는 JMenuItem을 묶어서 제공하기 위한 컴포넌트 
- MenuItem : 개별적인 일을 제공하기 위한 컴포넌트


<img src="https://user-images.githubusercontent.com/69107255/99808538-5cf26900-2b84-11eb-9e55-e8cc1717213d.png">

**사용법**
1. **JMenuBar 생성**
```java
    JMenuBar jmb = new JMenuBar();
```

2. **JMenu 생성**
```java
    JMenu m = new JMenu("대표이름");
```

3. **JMenuItem생성**
```java
    JMenuItem mi = new JMenuItem("서비스할 이름");
```

4. **생성된 JMenuItem을 Menu배치**
```java
    m.add(메뉴아이템 객체);

    m.add(다른 메뉴객체); // 메뉴아이템에서 하위 메뉴를 제공할 때
```

5. 메뉴아이템을 가진 메뉴가 JMenuBar에 배치
```java
    mb.add(메뉴 객체);
```

6. JMenuBar를 Window Component에 배치
```java
    setJMenuBar(메뉴바 객체);
```


# MVC Pattern을 도입하여 제작된 컴포넌트들
> 파일 하나에서 서로 다른 생명주기를 가진 코드를 분리한 것
- `Jcombo`
- `JList`
- `JTable`

## 특징

**장점**
- 소스코드의 복잡도가 낮아진다.
- 업무를 구분하여 작성하기 좋다.(**유지보수의 편의성 향상** => 프로그램에 생명이 길어짐)

**단점**
- 파일이 많이 생성되므로 파일관리의 복잡도 상승
- 값의 처리가 어렵다.
- 에러처리가 어렵다.

-  MVC(Model, View, Controller)
> `하나의 서비스`를 `분해`하여 `구현`하는 개발 방식(Design Pattern)

서로다는 작업을 분해하여 구현하는 개발 방식

- Model: 데이터를 관리하고 처리하는 일
- View: 데이터를 보여주는 일
- Controller: 이벤트 처리, 업무로직(Business Logic:연산,제어) 구현하는 일

<img src="https://user-images.githubusercontent.com/69107255/99808796-beb2d300-2b84-11eb-8a16-29b3cd19f9a8.png">

# JComboBox

**사용법**
1. 데이터를 가진 `Model클래스`를 생성
```java
    DefaultComboBoxModel<E> dcbm = new DefaultComboBoxModel<E>(); 
```

2.  Model 객체에 데이터 추가
```java
    dcbm.addElement(값); //인자값으로 어떤 데이터에 타입이든 받을 수 있다.
```

3. 데이터를 보여줄 `View 클래스`를 생성
```java
    JComboBox jcb = new JComboBox(dcbm);
```


# JList
- JList는 `ScrollBar가 없다.

**사용법**
1. 데이터를 가진 `Model클래스`를 생성
```java
    DefaultListModel<E> dlm = new DefaultListModel<E>(); 
```

2.  Model 객체에 데이터 추가
```java
    dlm.addElement(값); //인자값으로 어떤 데이터에 타입이든 받을 수 있다.
```

3. 데이터를 보여줄 `View 클래스`를 생성
```java
    JList jl = new JList(dlm);
```

4. ScrollBar 설정
```java
    JScrollPane jsp = new JScrollPane(jl); //JScrollPane과 jl은 has a관계
```

# JTable
> 데이터를 시안성을 높여 보여줄 때

**사용법**
1. 데이터를 가진 Model 클래스를 생성
> javax.swing.table.DefaultTableModel 클래스를 제공
- 컬럼명을 일차원 배열로 생성
```java
> String[] columnNames={"컬렴명","컬렴명","컬렴명"};
```
- 데이터는 2차원 배열로 생성
```java
    String[][] rowData = {{"값","값","값","값"},
                          {"값","값","값","값"}
                         };
```

```java
    DefaultTableModel dtm = new DefaultTableModel(rowData,columnNames);
```

2. Model 객체에 데이터 추가

- 배열
```java
    String[] data = {"값",,,,};
    
    dtm.addRow(data);
```
- Vector
> is a 관계의 객체화로 객체를 생성하지 않는다.
```java
    Vector<E> vec = new Vector<E>();

    vec.add("값"); // 컬럼의 개수 만큼 add를 사용하여 값을 추가

    dtm.addRow(vec);

```

3. 데이터를 보여줄 View클래스 생성
> swing패키지에 있음
```java
    JTable jt = new JTable(dtm);
```
4. JTable은 ScrollBar를 가지고있지 않다.
> JScrollPane을 사용하지 않고 JTable을 직접 배치하면 Table의 header가 보여지지 않는다.
```java
    JScrollPane jsp = new JScrollPane(jt);
```

# TitledBorder
> 테두리를 가진 제목 설정하는 Component
<img src ="https://user-images.githubusercontent.com/69107255/99808924-eefa7180-2b84-11eb-9852-34ef35349c4c.png">

**사용법**

1. 생성
- 대부분의 `Component`는 `border`를 가질 수 있다.<br>
**javax.swing.border 패키지**에는 테두리를 설정할 수 있는 Component가 제공
```java
    TitledBorder tb = TitledBorder("제목"); 
```

2.border가 필요한 Component에 생성한 border 설정
```java
    JButton jbtn = new JButton("난 버튼");

    jbt.setBorder(tb);
```