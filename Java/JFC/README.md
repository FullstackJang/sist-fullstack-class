# **GridLayout(격자 레이아웃)**
- `행`과 `열`로 구성된 레이아웃
- 컴포넌트의 크기가 동일하게 배치되는 레이아웃
- 컴포넌트는 배치하는 순서대로 왼쪽에서 오른쪽 순으로 배치된다.

<img src = "https://user-images.githubusercontent.com/69107255/100498015-8c1b6280-31a2-11eb-9f80-7fe73c37cb95.png">

**GridLayout(격자 레이아웃)의 문법**
1. 레이아웃 관리자 생성
```java
    GrideLayout gl = new GridLayout(행(row),열(column));
```

2. 배치관리자 적용
```java
    setLayout(gl);
```

1번과 2번을 합친다.
```java
    setLayout(new GrideLayout(행,열));
```

3. 컴포넌트 배치
```java
    //3행 2열로 하려면 add()를 6번해야한다.
    add(btn); //add해서 버튼을 붙여주겠어
    add(bt2); //add해서 버튼2를 붙여주겠어
```

# **GridBagLayout**
> 행마다 열의 크기,갯수를 다르게 보여줄 때 사용
- 수동 배치


# **cardLayout**
- Container Component에만 적용할 수 있는 레이아웃
- 한정적인 공간에 다른 디자인을 제공할 때 사용(tab의 역할)
- 여러개의 Container Component를 만들어 두고 그 중 하나의 Container Component를 보여줄 때 사용

# **복합레이아웃**
> 제공되는 Layout Manager를 사용하여 복잡한 디자인을 만들 때

<img src = "https://user-images.githubusercontent.com/69107255/99621363-178e4880-2a6b-11eb-9e41-49a79774b201.JPG">

1. Frame의 Layout은 BorderLayout으로 기본 설정
2. North영역에 `3개`의 `컴포넌트`가 배치
    - (`라벨`, `텍스트필드`, `버튼`은 Container Component에 배치하여 North 영역에 Container Component 하나를 배치)
3. Center영역에 TextArea 배치

- Jpanel : FlowLayout
- Jframe : BorderLayout
    - BorderLayout은 하나의 영역에 하나의 컴포넌트가 고유 크기를 무시하고 배치된다.

# **수동배치**
> 제공되는 Layout Manager를 사용하지 않고 개발자가 배치되는 컴포넌트의 크기와 위치를 직접 설정하는 배치방법

<img src = "https://user-images.githubusercontent.com/69107255/99621523-76ec5880-2a6b-11eb-861a-d6d66060200e.png">

**수동배치의 장점**
- 배치관리자가 제공하지 않는 복잡한 디자인을 만들 때
- 코딩량이 많아진다. 좌표와 크기 계산을 해야한다.

**수동배치 방법**
1. 자동배치관리자를 해제한다.
    - setLayout(null);
2. 컴포넌트를 생성하고 배치되는 위치와 크기 설정
    - 위치설정 : setLocation(x,y);
    - 크기설정 : setSize(w,h);
    > 위치설정은 `JFrame`에 사용되면 `모니터 왼쪽 상단이 시작점`이고 `Container Component`나 `일반Component`에 사용되면 배치되는 `JFrame의 왼쪽 상단이 시작점`이 된다.
   - 위치와 크기를 한번에 설정: setBounds(x,y,w,h);