## method 호출

## Call By Value
> method를 호출 할 때 매개변수가 기본형 데이터형이면 값이 복사되어 넘어간다.

```java
    class Test{

        public static void swap(int i, int j){ //기본형 데이터형 매개변수
            int temp = 0;
            temp = i;
            i = j;
            j = temp;
            System.out.println("swap method i =" + i + "j =" + j); //
        }

        public static void main(String[] args){
                int i = 11;
                int j = 4;
                System.out.println("i=" + i + ", j=" +j); // i = 11, j = 4
                swap(i,j); //넘겨주는 값은 복사되어 넘어간다.
                System.out.println("i=" + i + ", j=" +j);
        }//main
    }//class
```

## Call By Reference
> method를 호출 할 때 매개변수가 **참조형 데이터형** 이면 **주소** 가 그대로 전달된다.
 
- **참조형 데이터형** 에는 class, String, array있다.
- **주소** 는 유일하다.

```java
    class Test{

        int i,j; // instance 변수

        public void swap(Test t ){
            int temp = 0;
            temp = t.i;
            t.i = temp;
            System.out.println("swap t.i= " + t.i + "t.j=" + t.j); // t.i=200 t.j=100
        }

        public static void main(String[] args){

            Test t = new Test();
            t.i = 100;
            t.j = 200;

            System.out.println("t.i=" + t.i + "t.j="+j); //t.i=100, t.j=200
            t.swap(t); //주소(유일)가 전달
            System.out.println("t.i=" + t.i + "t.j="+j); //t.i=200, t.j=100
        }
    }
```

## 문자열형
> 문자열(문자가 나열된 것)은 문자열저장소에 하나만 생성된다.

- **String 클래스** 는 **참조형 데이터** 이지만 **기본형 형식** 으로도 사용할 수 있다.
- 문자열저장소의 주소는 java.lang.String클래스를 사용하여 저장하고,사용할 수 있다.
- 문자열저장소를 저장하기 위해 " "을 사용한다.
- 문자열을 다루기위한 클래스가 4개가 지원
  - java.lang.String
  - java.lang.StringBuffer
  - java.lang.StringBuilder
  - java.util.StringTokenizer

**기본형 형식**
> new를 사용하지 않는 방법(String만 가능)
**기본형 형식의 사용법**
```java
    String s = "문자열";
```

**참조형 형식**
> new를 사용하는 방법

**참조형 형식의 사용법**
```java
    String s = new String("문자열");
```
**문자열이 같은지에 대한 비교**
> ==연산자를 사용
- **기본형 데이터형** 에 **==** 을 사용하면 **값** 이 같은 지 비교한다.
- **참조형 데이터형** 에 **==** 을 사용하면 **주소** 가 같은 지 비교를 수행한다.
- **주의** 문자열 생성한게 내 눈에 보일때도 많지만 안보일때도 많다. 기본형으로 만들어졌는지 참조형으로 만들어졌는지 알기 어려울때가 많다. ==으로 비교하지 말자.

<img src="https://user-images.githubusercontent.com/69107255/98103102-d8db8880-1ed7-11eb-8280-94807c80b0e7.JPG">

```java
    class Test{

        public static void main(String[] args){

            String str = "ABCD"; // 기본형 형식의 사용
            String str1 = new String("ABCD"); //참조형 형식의 사용

            if(str == "ABCD") // true str에 100번지와 ABCD가 저장된 주소의 값이 같은지
            if(str1 == "ABCD") // false 10번지에 주소가 100번지에 주소와 같은지

            //문자열 생성한게 내 눈에 보일때도 많지만 안보일때도 많다. 기본형으로 만들어졌는지
            //참조형으로 만들어졌는지 알기 어려울때가 많다. ==을 사용하지 않는다.
        }//main
    }//class
```