# VO(Value Object)
- 값을 저장하고, 사용할 목적으로 제작하는 클래스
- 여러 개의 분할된 값을 묶어서 관리하기 위해 작성
- 분할된 값이 묶여서 어떤 값으로 사용되는지 알 수 있으므로 가독성 향상
- 값을 변경하지 않고 그대로 사용하는 개게
- DTO(Data Transfer Object)와 비슷 : 객체간에 값을 전달하기위한 객체
    - DTO는 값을 변경할 수 있는 객체

**VO 규칙**
- Framework 사용하지 않은 경우
    - 매개변수 있는 생성자를 만든다. (개발자가 VO를 생성하여 값을 넣어준다.)

- Framework 사용하는 경우
    - 매개변수 있는 생성자를 만들지 않는다.(Framework에서 VO를 생성하여 setter method를 호출하여 값을 넣어준다.)

1. **클래스명에 VO를 붙여준다.**

```java
    public class TestVO{
```

2. **instance 변수 선언** 
```java
    private int deptno;
    private String dname;
```

3. **setter / getter 작성**
setter method
> 값을 설정하기 위한 목적
```java
    public void set변수명(매개변수){

    }

    //EX)
    public void setDeptno(int deptno){
        this.deptno = deptno;
    }

```

getter method
> 값을 얻기 위한 목적
```java
    public 반환형 get변수명(){

    }

    //EX)
    public int getDeptno(){
        return deptno;
    }

```