# 자바 7일차 (1029)

## 반복문
> 코드의 실행을 여러 번 하기 위해서 제공되는 문장

## 단일 for
> 시작과 끝을 알 때 사용하는 반복문

-  **단일 for문 수업 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/UseFor.java)

for문법
```java
    for(초기화식 ; 조건식; 증,감소식) {
        반복수행 할 문장들.....
    }
```
## 다중 for
> for문안에 for문 정의
- 바깥 for가 한번 실행 될 때 안쪽 for는 몇번 실행되는지 생각
  
- **다중 for문 수업 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/TestFor2.java)

## 무한 loop (infinite loop)
- 끝나지 않는 프로그램을 만들어야 할 때
- 무한 loop 코드 아래줄에 코드가 작성되어 있으면 error가 발생

### 무한 loop 사용 사례
 > OS, 시계, 서버

- **for문 무한 loop 수업 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/InfiniterFor.java)
- **while문 무한 loop 수업 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/InfiniterWhile.java)  
- **do-while문 무한 loop 수업 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/InfiniterDoWhile.java)
### 무한루프
```java
    EX1)
    for( ; ; ){

    }
    // 초기식,조건식,증,감소식을 작성하지 않을 때
    // 증가하는 값을 알수 없다

----------------------------------------------------------------------------
    
    EX2)
    for(초기값;  ;증,감소식){

    }
    //조건식만 생략하여 작성 할 때
    //증가하는 값을 알 수 있다. 
```
## break
> switch-case, for, while, do~while을 빠져 나갈 때 사용

## continue
> 반복문의 수행을 건너 뛸 때 사용
- continue를 반복문의 제일 마지막줄에 기술하지 않는다.
- 조건식에 넣어서 사용
- **continue 수업 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/UseContinue.java)

## 개선된 for문
> 인덱스를 사용할 수 없다.

- Java SE5(JDK1.5)에서부터 지원하는 문법
-  배열, Collection(List,Set)의 처음 방부터 끝방까지 출력하는 일을 함
- 기존의 for보다 처리되는 속도가 느림
- **for each 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/ImprovementFor.java)
  
for each문법
```java
    for(데이터형 변수명 : 배열명){ 
                    //배열명에는 List명,Set명이 올수도 있음
    }
```

## while문
- 최소 0번 수행에 최대 조건까지 수행
- **while 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/UseWhile.java)

while 문법
```java
    EX1)

    //초기값
    while(조건식){ 
        //조건식에는 관계연산자, 일을 하는 method가 들어갈 수 있다.
        반복 수행문장;
        //증,감소식
    }

    //초기값과 증,감소식이 들어가면 for의 형태다
```


## do~while문
- 최소 1번 수행에 최대 조건까지 수행
> 시작과 끝을 알 수 없을 때 사용 
- **DO-while 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/UseDoWhile.java)
  
do~while 문법
```java
    //초기값;
    do{
        반복수행 문장들;
        증,감소식;
    }while(조건식);

//조건식의 결과가 true이면 do로 올라가서 실행
//조건식이 false이면 해당 do~while문 탈출
```

## Escape Characeter(특수문자)
> 문자열안에 사용하면서 정해진 기능을 수행하는 문자들
- \문자 (\뒤에 나오는 하나의 문자로 정해진 기능이 수행된다.)
- 특수문자는 정해져있다.
- 형식) "\문자"
- **EscapeCharacter 예제 코드**  [code](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day7/EscapeCharacter.java)

|특수문자|기능
|------|------
|\n|개행 - 줄을 변경|
|\r |커서를 그 줄에 가장 앞으로 이동(Windows에만 존재)|
|\t|Tab -tab키를 누른 것과 같은 효과|
|\ "|"를 사용할 때|
|\ "|'를 사용할 때|