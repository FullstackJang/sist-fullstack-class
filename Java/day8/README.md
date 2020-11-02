## 변수(Variable)
> 목적: 프로그램에서 사용할 값을 메모리에 일시적으로 저장하기 위해

## 자바에서 제공하는 변수
> 3가지 종류의 변수를 제공

- **local variable**
- **instance variable**
- **static variable**
 
### 변수의 특징
- 변수를 선언하는 위치에 따라 다른 변수가 만들어진다.
- 각각의 변수는 생명주기와 사용범위, 사용방법이 다르다.

## 변수명 규칙
  - 소문자로 시작한다.
  - 숫자로 시작하지 않는다.
  - 변수명에 특수문자를 포함하지 않는다.
  - 여러 개의 단어로 변수명이 구성되면 첫 단어는 모두 소문자로,나머지 단어는 첫글자만 대문자로 구성한다.

## instance(member) variable - 멤버 변수
- JVM의 heap 메모리에 생성된다.
-  class를 객체화하면 객체마다 변수가 메모리에 생성된다.
- class field에 선언하고, 객체화하여 객체명으로 사용하는 변수
- 자동 초기화가 된다.(개발자가 초기화 값을 넣지 않아도 된다.)
- 객체가 Garbage Collector에 의해  사라질때 메모리에서 사라진다.
- static 영역에서는 instance영역에 변수를 직접 접근할 수 없다.

**instance 변수 선언 방법**
```
    access modifier(접근지정자) datatype variable_name = default_value;
```

**instance 변수 선언 위치**
```JAVA
  class Test{
      int i; //instance 영역에 선언된 instance변수

          public static void main(String[] args){

          }
      } 
```

## static(class) variable - 스태틱 변수
> 공용 변수: 하나의 자원을 여러 대상들이 공유하고 사용하는 것
- 자동초기화가 된다.
- class field에 선언한다.
- 클래스가 실행되면 memory에 올라간다.
- instance 변수보다 참조하는 속도가 빠르다.
- 실행중인 JVM에서 하나만 만들어지고 사용된다.
- 값이 변경되면 변경된 값으로 모두 사용하게 된다.
- 사용하지 않으면 메모리를 계속 점유하기 때문에 메모리의 낭비로 이어질수 있다.

**static 변수 선언방법**
```
    접근지정자 static 데이터형 변수명;
```

**static 변수 선언 위치**
```JAVA
  class Test{
      static int i;

        public static void main(String[] args){

        }
  }

//사용법: 클래스명.변수명으로 사용 => Test.i;
// 공용변수는 특정객체에 속해있는 변수가 아니므로 객체명.변수명의 형식으로 사용하지 않는다.
```
## 접근 지정자
|폴더개념| |
|:---|----|
|public|클래스 외부에서 사용가능|
|protected|패키지가 다르면 상속관계의 자식클래스에서만 사용가능 같은 패키지의 다른 클래스에서는 사용 가능|
|private|클래스 안에서만 사용가능|
|default|패키지가 다르면 사용할 수 없고, 같은 패키지에 다른 클래스에서는 사용가능

|메모리개념| |
|:---|----|
|static|공용 메모리에 생성|
|final|값 변경 불가|
|transient|직렬화 방지키워드(IO Stream)을 타고 나가지 못하도록 막는 일을 함|

## 데이터형
  > 기본형 데이터형, 참조형 데이터형 사용 가능

------------------------------------------------------------------------
## method
> 업무를 구분하여 작성할 때 사용

**method 특징**
- 중복코드를 최소화 할 수 있다.
- **instance method**와 **static method** 2가지를 만들 수 있다.
- polymorphism을 지원(method Overload, method Override)

**method 문법**
```
  접근지정자 반환형 method명(매개변수){
    
    업무 구현

  }
```

## instance method
> 클래스의 인스턴스 변수를 사용하여 일을 처리하는 method
- 객체화를 하여 **객체명.method명( )** 으로 호출하여 사용

## static method
> 객체가 가지고 있는 값을 사용하여 일을 처리하는 것이 아닌, 입력된 값을 가지고 일시적인 연산을 할 때 사용
- 객체화를 하지 않고 **클래스명.method명( )** 으로 호출하여 사용.

### method의 접근지정자

| 폴더개념의 접근지정자|(1개 사용 가능) |
|:----|:----|
|public|클래스 외부에서 호출 가능|
|protected| 같은 패키지의 다른 클래스에서 호출 가능 / 패키지가 다르면 상속관계의 자식클래스에서만 호출 가능
|private| 클래스안에서만 호출 가능
|default| 같은 패키지의 다른 클래스에서 호출 가능 / 패키지가 다르면 호출 불가능

|메모리개념의 접근지정자|(N개 사용 가능)|
|:----|:-----|
|static| static method로 만들 때
|final| Override를 막을 때
|synchronized| multi thread에서 동시 호출을 막을 때

### 반환형(return type)
> method안에서 업무처리한 결과를 밖으로 내보낼 때 사용

### 매개변수(parameter)
- method외부에 존재하는 값(arguments)을 method 내부로 전달하기 위한 변수
- method를 호출 할때 매개변수의 개수와 형에 대해 일치하여 호출 

### return
- method가 반환형을 가지고 있다면 method의 가장 마지막 줄에 반드시 return을 정의해야한다.
- return은 값을 반환할 때 사용

문법
```java
  return 값;
        //값의 종류: 상수, 변수, 연산식,
```

## method의 4가지 형태
**1. 반환형 없고, 매개변수 없는 형. - 고정적인 일**
  ```java
      public void typeA(){

      }// 닫힘괄호의 의미는 호출한 곳으로 돌아가라

      호출) 객체명.typeA();
  ```
**2. 반환형 없고, 매개변수 있는 형 - 동적인 일**
```java
      public void typeB(int i, char c){

      }
      호출) 객체명.typeB(1,'C');
      //호출할 때에는 method의 매개변수 개수와 데이터형을 일치시켜야함
```

**3. 반환형 있고, 매개변수 없는 형 - 고정 값**
```java
      public int typeC(){

        return 30; // 값을 반환해
      }
      호출) int i = 객체명.typeC();
      //변수에 할당하거나, 연산에 참여 시킬 수 있다.
```
**4. 반환형 있고, 매개변수 있는 형 - 가변 값**
```java
      public int typeD(char c){

          return (int)c;
      }
      호출)int value = 객체명.typeD('C');
      //데이터형 변수명 = 객체명.method명(값);
      //변수에 할당하거나, 연산에 참여 시킬 수 있다.
```
## Variable Argumetns (가변인자형)
> method 호출할 때 입력하는 값을 동적으로 넣어줄 때
- JavaSE JDK 1.5에서부터 지원되는 문법
- parameter를 정의할 때 **"데이터형 ... 매개변수명"** 의 형식을 가진다
-  method안에서는 배열로 처리된다.
  - 대표: System.out.printf();, System.out.format();
- method가 여러 개의 parameter를 정의할 때 가변인자형은 가장 마지막에만 사용할 수있다.

**형식**
```java
    접근지정자 반환형 method명(데이터형 ... 매개변수명)
```
**호출**
```java
    method명();
    method명(값);
    method명(값,값,,,);
```

```java
public void va(int ... parami){
  // ...parami 매개변수는 배열로 처리된다.
  // (반복문을 사용하여 처음부터 끝까지 모든 값을 얻을 수 있다.)

  for(int value : parami){
    value // 입력된 모든 arguments를 사용 할 수 있다.
  }

   - 호출) va();    // arguments 없이 호출가능.
          va(10); // argumetns 하나를 넣어 호출 가능
          va(10,20,30,40); //arguments 여러개를 넣어 호출 가능
  
}
```