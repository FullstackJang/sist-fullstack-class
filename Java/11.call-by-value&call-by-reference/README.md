## method 호출

## Call By Value
> method를 호출 할 때 매개변수가 기본형 데이터형이면 값이 복사되어 넘어간다.
-  **Call By Value 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/days11/CallByValue.java)
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
> 
- **주소** 는 유일하다.
- **참조형 데이터형** 에는 class, String, array있다.
-  **Call By Reference 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/days11/CallByReference.java)
 
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

