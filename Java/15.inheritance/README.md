
# 상속(inheritance)
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
