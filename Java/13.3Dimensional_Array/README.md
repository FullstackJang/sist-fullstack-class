## 3차원 배열
> 면, 행, 열로 구성된 배열
- 면의 수:  배열명.length
- 행의 수: 배열명[면의 번호].length
- 열의 수: 배열명[면의 번호][행의 번호].length
- **3차원 배열**  [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days14/Array3.java)

- **과제 3차원 배열 예제 코드** 
    - 과제 내용: 3차원 배열에 입력 된 점수에 `3과목 총점`,`과목별 총점`,`전체 총점`, `전체 평균`, `Java최고점수`를 Method만들어서 출력해보기 [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days14/Array3Score.java)

### **3차원 배열 작성법**

**선언**
```java
    데이터형[면][행][열] 배열명 = null;
    // 객체참조 변수 배열명이 stack에 할당
```

**생성**
```java
    배열명 = new 데이터형[면의 수][행의 수][열의 수];

    //new를 통해서 heap에 생성, 모든 방의 값이 초기화 됨
```

```java
    int [][][] arr = null;

    arr = new int[2][2][3];
    //2행 3열짜리 배열이 2개가 있다 생각하면 됨
```
**값 할당**
```java
    배열명[면의 번호][행의 번호][열의 번호] = 값;
    arr[0][0][0] = 10;
    arr[1][1][0] = 20;
```

**값 사용**
```java
    배열명[면의 번호][행의 번호][열의 번호];
```
<br>

**3차원 배열의 일괄처리**

```java
    for(int i = 0; i < 배열명.length; i++){ // 면
        for(int j = 0; j < 배열명[i].length; j++) { // 행
            for(int k = 0 k < 배열명[i][j].length; k++){ // 열
                    배열명[i][j][k];
            }
        }
    }
```

### 기본형 형식의 사용
```java
    데이터형[][][] 데이터명 = {{{값}},{{값}}};

    //2면 2행 3열
    int[][][] = {{{10,20,30},{40,50,60}},{{70,80,90},{100,110,120}}};
```

## 가변배열(Variable Array)
> 행마다 열의 갯수가다른 배열

- 이차원 배열형식(행과 열로 구성)
- 행의 수: 배열명.length
- 열의 수: 배열명[행의 번호].length
- **가변 배열 예제 코드**  [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days14/VariableArray.java)

### **가변배열 작성법**

**선언**
```java
    데이터형[][] 배열명 = null;
    int[][] arr = null;
```

**생성**
- 열의 수를 설정하지 않음
- 행은 알지만 열을 알수 없다.
```java
    배열명 = new 데이터형[행의 수][];
    arr = new int[4][];
```

**행마다 열을 생성**
```java
    배열명[행의 번호] = new 데이터형[열의 갯수];
    arr[0] = new int[3];
    arr[1] = new int[2];
```

**초기 값을 넣을때**
```java
    배열명[행의번호] = new 데이터형[]{값,,};
    arr[2] = new int[] {10};
    arr[3] = new int[] {10,20,30,40};
```

**가변 배열의 기본형 형식**
```java
    데이터형[][] 배열명 = {{값,},{값}};
```

## 상속(inheritance)
> 부모클래스의 자원을 자식클래스에서 사용하는 것(코드의 재사용성 향상)

- 모든 클래스의 부모 클래스는 `java.lang.Object클래스`이다.
- 단일 상속만 지원(부모가 하나인 상속)(부모클래스가  명확함 단, 기능 확장에 제한적)
- 클래스간의 계층 생성(부모자식 관계)
- 부모클래스의 자원 중 `private`은 자식에서 사용 할 수 없다.

**부모 클래스(super class)**: 기능 제공(모든 자식이 사용하게 될 공통 특징 정의)<br>
**자식 클래스(sub class)**: 기능 사용

`extends`키워드로 `자식클래스`에서 `부모클래스`를 선택(부모 클래스는 자식클래스를 알 수 없음)<br>
`생성자`는 상속되지 않는다.<br>
`자식 클래스`를 생성하면 `부모 클래스`가 먼저 생성된다.

**상속 수업 예제 코드1**
- **부모 클래스 TestSuper.java**  [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days14/TestSuper.java)
- **자식 클래스 TestSub.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days14/TestSub.java)
---
**상속 수업 예제 코드2**
- **부모 클래스 Person.java**  [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days14/Person.java)
- **자식 클래스 HongGilDong.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days14/HongGilDong.java)
- **자식 클래스 Clark.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days14/Clark.java)
- **main 클래스 UsePerson.java** [code](https://github.com/Jangilkyu/sist-fullstack-class/blob/master/Java/days14/UsePerson.java)
