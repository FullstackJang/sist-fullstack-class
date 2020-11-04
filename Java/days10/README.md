## 복합적인 값 저장
> 사용자 정의 자료형: 기존의 데이터형을 조합하여 새로운 이름의 데이터형을 만드는 것

## 사용자 정의 자료형 
- **학생정보**
    - 학번
    - 이름
    - 나이
    - 키
    - 몸무게

**사용자 정의 자료형 예제 코드**
```java
    class Studnet{ //Student는 데이터형명 

        // int String int double double 기존에 있는 데이터형을 조합해
        // Student라는 새로운 데이터형을 만들었다.
        private int regiNum;
        private String name;
        private int age;
        private double height;
        private double weight;

        //데이터를 처리하기 위한 기능
        public String method() { 

        }
    }

    //참조형 데이터형 사용: 객체화(heap 생성)
    데이터형 변수명 = 값; (heap생성된 값 - n개 생성 - 시작주소)

    int i = 10; //값이 하나이므로 변수에 직접 저장 가능.
    Student s = 5개가 생성이 된다.
    s는 5개가 생성된 곳에 시작 주소를 담는다.
    new: 선언된 데이터형으로 heap에 n개의 변수를 생성 그리고 시작 주소를 가진다. 
```

## setter method
> 클래스 instance 변수의 값을 변경하기 위한 method
- instatnce 변수는 외부에서 값을 직접 변경하지 못하도록 접근지정자를 대부분 private으로 설정
    - (유효성검증을 수행하기 어렵기 때문에)
- method를 통해서 값을 설정하면 유효성검증을 수행할 수 있다.
- 사용의 편의성,중복코드의 최소화

**setter의 규칙**
```java
    public viod setXxx( 매개변수 ){
        this.변수명 = 매개변수명;
    }

    // setter method는 set을 접두어로 사용하고 변수명을 붙여서 만들어 준다.
    "set변수명" 형식을 가진다.
``` 

**setter 예제코드**
```java

    class Test{
        private int age;

        public void setAge(int age){
            if(age > 120){ // 유효성 겁증
               age = 0;
            }
            this.age = age;
        }
    }
```

## getter method
> 클래스의 instance 변수가 private으로 설정 되어있을 때, instance 변수의 값을 클래스 외부에서 받아가기 위해서 만드는 method

**getter의 규칙**
```java
    public 반환형 get변수명( ) {
        return 변수명;
    }

    // getter method는 get을 접두어로 사용하고 변수명을 붙여서 만들어준다.
    "get변수명" 형식을 가진다.
```

**getter 예제코드**
```java

    class Test{
        private int age;

        public int getAge(){
            return age;
        }
    }
```

## Constructor(생성자)
> 객체가 생성 될 때 가지고 있어야 할 초기화 값, 코드를 정의하는 method의 일종

- 생성자는 상속되지 않는다.
- 생성자는 직접 호출 할 수 없다.
- 생성자는 클래스의 이름과 동일하게 작성한다.
- 생성자안에서 다른 생성자를 this( ) 나 super( )로 호출 할 수 있다. 
- new 키워드로만 호출 가능.
    -(객체 생성시에만 호출 가능)
- 개발자가 생성자를 하나도 정의하지 않으면 Compiler가 매개변수 없는 기본 생성자(Default Constructor)를 생성해준다. 
    - 개발자가 생성자를 하나라도 정의하면 Compiler는 기본 생성자를 만들지 않는다.

**Constructor(생성자) 작성법**
```
    접근지정자 클래스명(매개변수){
        객체가 가져야할 초기화 값
        객체가 생성되면서 실행 되어야할 코드
    }
```
**Constructor(생성자) 접근 지정자**
|Constructor(생성자)|접근지정자|
|:----|:----|
|public|클래스 외부에서 객체 생성가능|
|protected|같은 패키지의 다른 클래스에서는 객체 생성가능 / 다른 패키지에서는 상속관계의 자식 클래스에서만 객체생성 가능?|
|private|클래스안에서만 객체생성가능(Singleton Pattern으로 객체를 생성 할때)|
|default|같은 패키지의 다른 클래스에서 객체 생성 가능 / 다른 패키지에서는 객체생성 불가능|

## this
> 자신클래스와 관련된 일만 수행
- **keyword형식** , **method형식** 두 가지로 사용할 수 있다.

- method 형식: 자신 클래스의 생성자를 호출 할 때 사용
  - this(); - 기본 생성자를 호출 할때 사용
  - this(값); - 매개변수 있는 생성자를 호출 할 때 사용
**주의**
- **생성자의 첫 줄에서만 사용 할 수 있다.**
- 아래 코드와 같이 재귀호출되는 상황이라면 에러발생
  
**잘못된 this() 재귀호출 오류 상황1**
```java
    public Test(){
      this();
    //재귀호출되는 상황이라면 에러발생
    }
```
**잘못된 this()오류 상황2**
```java
    class Test{
        public Test() {
            this(10);
        }
        
        public Test(int i) {
            this();
        }
    }
    /*오류 설명
        Test(int i)의 i를 통해 매개변수 값이 들어 왔다고 가정했을 때
        this()를 실행 즉 Test()생성자를 실행하고 this(10)은 다시 Test(int i)를 실행
        계속 상황이 반복 한쪽은 탈출구가 있어야한다.
```

**this keyword사용**
```java
    class Test{
        int i;
        
        public void setI(int i){
                this.i=i; // heap에 i에  stack에 i를 할당
                //this는 method를 호출한 객체의 주소로 바뀐다.
        }

        public static void main(String[] args){
                Test t = new Test();
                t.setI(1000);
        }//main
    }//class


```
참조형 데이터형
> 값은 메모리에 다른 곳에 생성되고, 그 시작 주소를 저장하는 데이터형

- 다른 곳에 생성할려면: new가 필요
  - new가 사용되어 값을 생성 하는 것을 객체화라고 한다. 