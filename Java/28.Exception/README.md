# Exception Handling

- 예외: 가벼운에러

- Error 상태
    - 발생하면 프로그램이 더 이상 진행할 수 없는 상태
    - 프로그램이 더 이상 사용될 수 없다.

- Exception: 상태
    - 발생하면 프로그램 안에서 처리하여 연속된 진행을 할 수 있는 상태
    - 프로그램을 계속하여 사용할 수 있다.

- 개발자가 반드시 예외 상황에 대한 대비 코드를 작성하고 처리될 수 있도록 만들어야한다.

- 예외는 **Compile Exception**과 **Runtime Exception** 두 가지로 구분
## Compile Exception
- 개발자가 반드시 try~catch로 처리해야 하는 예외
- bytecode가 제대로 생성되지 않는 상황에 발생하는 예외

## Runtime Exception
- 개발자가 try~catch를 하지 않아도 JVM이 처리해주는 예외
- 저장과 연산이 제대로 수행되지 못하는 상황에 발생하는 예외


try~catch, throws, throw를 사용하여 예외를 처리

- try~catch: 예외를 잡아서 예외상황을 처리할 때 사용
- throw: 예외를 강제적으로 발생시킬 때
- throws: 발생된 예외를 던질 때 사용

**try~catch 문법**
```java
    try {
        예외발생 예상 코드 //API를 보고 확인한다.
    }catch(예외처리클래스 객체명){
        예외가 발생했을 때 제공할 코드
    }catch(예외처리클래스 객체명){
    예외가 발생했을 때 제공할 코드
    }finally{
        반드시 실행되어야 할 코드를 정의
    }
```

## 예외 출력
- 예외 처리 클래스가 제공하는 메시지를 출력하는 것
- 예외상황에 대한 정보를 확인하고, 대응코드를 작성할 수 있다.

- 예외 전용 출력 스트림
```java
    System.err(에러 출력).println("예외에 대한 메시지");
```

- 모든 예외처리 클래스는 예외 메시지를 반환하는 method를 가지고 있다.
    - 간단한 예외메시지 출력 : getMessage(); // 예외의 이유만 출력
    - 예외 클래스와 예외메시지를 출력 : 객체명.toString();
    - 자세한 이유 출력 : printStackTrace(); //출력까지 같이 해주는 method ->너무 자세하게 나와서 사용자한테는 절대 보여주면 안됨


# 컴파일 예외
- 객체(instance) 복제(동일한 값을 가진 객체를 하나 더 만드는 것)될 수 없다.
- 객체가 복제 될려면 타입체크(Cloneable : 형을 체크)가 되어야 한다.
- 객체를 복제할 때에는 Ojbect에서 제공하는 clone()를 사용한다.

# throws
- method안에서 발생된 예외를 method밖으로 던질 때 사용
- method를 호출한 곳에서 예외를 처리하도록 만드는 것
- 일처리 코드와 예외처리 코드를 분리할 수 있다.
- throws되는 예외는 method안에서 try~catch로 처리하지 않는다.

**문법**
```java
    접근지정자 반환형 method명(매개변수) throws 예외클래스 , , , {
    }
    
    호출하는 곳에서 예외 처리)
    try{
        method명();
    }catch(예외클래스 객체명){
        예외가 발생했을 때 제공할 코드
    } 
```

# throw
- 예외를 강제로 발생 시킬 때 사용
- 발생된 예외는 try~catch로 또는 throws로 반드시 처리해야 한다.
- 특정상황에서 예외를 발생시켜 처리할 때 사용
- 사용자 정의 예외 처리 클래스와 주로 사용
-
**문법**
```java
    throw new 예외처리클래스();
```

```java
    //예외가 발생된 후 바로 처리 : 권장하지 않는다.
    public void test(){
    try{
        throw new Exception();
        }catch(Exception e){

        }
    }
```

```java
//throws 에서는 throw로 발생시킨 예외 또는 부모예외로 예외를 날릴 수 있다.
    public void test() throws Exception{
        throw new Exception();
    }
```

# 사용자정의 예외 처리 클래스
- java에서 제공되는 예외처리 클래스가 현재 업무상황에 맞지 않을 때
- 개발자가 현재 업무상황에 맞는 예외처리 클래스를 만드는 것

- Compile 예외를 만들 때 : Exception 상속
- Runtime 예외를 만들 때 : RuntimeException 상속

