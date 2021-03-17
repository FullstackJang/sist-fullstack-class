# polymorphism(다형성)
> 하나의 대상을 다양하게 사용하는 것
- **객체 다형성** 과 **method 다형성** 을 지원

## method 다형성
### Overload(Overloading)
>하나의 클래스안에서 같은 이름의 method를 여러 개 정의할 수 있는 방법

#### Overload의 규칙
- Overloading은 method 이름이 같아야 한다.
- 접근지정자, 반환형은 달라도 된다. 
    - (전달되는 arguments(인자) 의 순서 또한 같아야 한다.)
- 매개변수의 개수 또는 타입 이 달라야한다. 
  - (매개변수는 같고 반환 타입만 다를 경우 Overloading성립(X))

##### Overloading의 장점
- 가독성 및 편의성 향상
- 메소드 이름을 동일하게 해서 오류를 줄일 수 있다. 

