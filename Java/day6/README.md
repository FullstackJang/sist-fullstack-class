# 자바 6일차 (1028)

## eclipse: 통합개발툴 (IDE: Integrated Development Environmnet)
> 소스코드 작성, 컴파일, 실행, 배포, 디버깅등의 개발에 필요한 모든 기능을 제공하는 툴

- EPL (Eclipse Public License) eclipse 공용허가서를 가지고 있는 무료 소프트웨어
- package 기반으로 소스 관리

## package
> class 파일(bytecode)의 관리편의성을 높이기 위한 폴더(directory)
- 관련있는 소스나 bytecode를 폴더로 묶어서 관리하기위해
- 패키지단위로 jar로 묶어서 배포
- Java에서 제공하는 패키지명과 다르게 설정
- source 코드 작성 시 가장 첫 번째 줄에 package 선언 하고 compile을 하면 만들어진다.


### 패캐지 선언방법
```
package 패키지명; 
//패키지명은 역방향 도메인(도메인을 거꾸로 기술)사용 

ex) sist.co.kr -> kr.co.sist
```

## DOS에서 패키지 컴파일 과정
- eclipse는 패키지컴파일을 자동으로 처리해준다. 
- eclipse의 편의성을 알 수 있다.
### 1.소스코드 작성
```
package kr.co.sist; // 패캐지 선언

class Test{
        public static void main(String[] args){

        }
}
```
### 2. 저장 : Test.java

```
3. 컴파일(패키지 컴파일 : 패키지 컴파일 옵션 -d . 을 사용)
javac -d . 소스코드명.java //package 선언된 이름으로 directory를 생성

소스코드 : c:/dev/src/day1028 안에 존재한다면

    c:dev/src/day1028/Test.java
                     /kr/
                        /co/
                            /sist/Test.class
```

### 4.실행
```
 가장 외부패키지(kr폴더)가 보여지는 위치에서 실행한다.

java 패키지명.클래스명
java kr.co.sist.Test
```