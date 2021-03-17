# Thread
- Thread 장점
    - 동시에 일(method)을 처리 해야 할 때
    - 작은 프로세스(process: CPU가 한번에 처리하는 일(사용자가 실행하는 프로그램)의 단위)
    - Multi Thread를 지워
    - 선점형 CPU Scheduling 사용
- Thread 특징
    - Interrutpted가 발생될 수 있다.
    - Thread를 사용하면 프로그램의 종료시간을 측정할 수 없다.
    - `생명 주기`를 가진다.
    
    <img src = "https://user-images.githubusercontent.com/69107255/101704252-a79e3b80-3ac7-11eb-9623-2789e552d9b3.png">
    
## Multi Task
> 여러개의 프로그램을 실행 시킬 수 있는 것 (Mac OS, Windows, Linux, Unix)

## Single Task
> 한번에 하나의 프로그램을 실행 시킬 수 있는 것(DOS)

## Multi Thread
>  여러개의 프로그램을 동시에 처리하는 것

## Single Thread
> 하나의 프로그램만을 처리하는 것

## 시분할 CPU Scheduling
> 작업관리자 역할이 중요

- Thread가 CPU를 점유하는 시간을 설정하는 방식


# Thread 사용법

- Thread class extends(상속)하는 방법

<img src = "https://user-images.githubusercontent.com/69107255/101704334-d9af9d80-3ac7-11eb-9ffc-deacbecfb44c.png">

1. Thread 클래스를 상속
```java
    public class MyClass extends Thread {

```

2. Run Method를 Override하고 동시에 처리되어야할 코드를 정의 (Thead로 동작할 코드를 정의)
```java
    public void run(){
        //동시에 실행되어야 할 코드를 정의
    }
```

3. 자식클래스로 객체 생성(부모인 Thread가 생성된다.)
```java
    MyClass mc = new MyClass();
```

4. Thread 클래스의 start()를 호출하여 run()를 호출한다.
```java
        mc.start(); // Thread에 start()를 호출했지만 run()이 오버라이드 되어서 내 클래스에 있는 run()가 호출된다.
  
    }//class
```


- Runnable interface implements(구현)하는 방법

<img src = "https://user-images.githubusercontent.com/69107255/101704449-1d0a0c00-3ac8-11eb-8251-656b76c2903d.png">

1. Runnable interface를 구현
```java
    public class MyClass implements Runnable {
  
```

2. run() abstract method Override
```java
    public void run() {
        //Thread로 동작해야할 코드 (동시에 실행 되어야할 코드)
    }//run
```

3. 자식 클래스를 객체화
```java
    MyClass mc = new MyClass();
```

4. Thread클래스를 객체화
```java
    Thread t = new Thread(mc); // has a
```

5. Thread에 존재하는 strat()를 호출하여 run()를 호출한다.
```java
    t.strat();

```

# Thread의 상태 변환
```java

try{
Thread.sleep(ms); //입력된 ms동안 block상태에 들어갔다가 running 상태로 돌아온다.
}catch(InterruptedException ie){

}
```