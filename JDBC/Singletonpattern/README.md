# **Singleton pattern**
> 실행중인 JVM에서 객체를 하나만 생성하고 관리하며 사용할 수 있는 개발 방법

- 메모리를 절약할 수 있다. 
- 객체가 항상 생성되어있기 때문에 속도가 빠르다.
- 객체가 소멸되었을 때 더 이상 사용할 수 없다. (코드를 구현하여 해결)

**Singleton pattern 작성법**

1. **클래스의 객체를 클래스 내부에서만 생성할 수 있도록 만든다.**
    - 생성자의 접근지정자를 private으로 처리한다.
```java
    public class Test {
        //1. 클래스의 객체를 클래스 내부에서만 생성할 수 있도록 만든다.
        private Test(){

        }

    }
```

2. **객체를 반환하는 method를 만든다.**
    -  `getInstance()`

```java
    public class Test {
        //1. 클래스의 객체를 클래스 내부에서만 생성할 수 있도록 만든다.
        private Test(){

        }
        //2.객체를 반환하는 method를 만든다.
        //객체를 생성하지 못하니 static으로 처리
        public static Test getInstance(){
            return new Test();
        }
    }
```

3. **객체를 반환하는 method안에서는 객체를 하나만 생성할 수 있도록 만든다.**
    ```java
        if(객체명 == null){
            객체명 = new 생성자();
        }
    ```

```java
    public class Test {

        private static Test t;

        //1. 클래스의 객체를 클래스 내부에서만 생성할 수 있도록 만든다.
        private Test(){ //객체외부에서 객체생성 불가.

        }
        //2.객체를 반환하는 method를 만든다.
        //객체를 생성하지 못하니 static으로 처리
        public static Test getInstance(){ //객체를 반환하는 일. 
                if(t == null){
                    t = new Test();
                }
                return t;
        }
    }
```