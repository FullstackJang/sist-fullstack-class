# 자바 4일차(1026)

## 시프트 연산
**수업 코드: [시프트 연산](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day4/Operator3.java)**
1. << : left shift
><< : 비트를 왼쪽으로 밀고, 밀어서 빈칸을 항상 0으로 채운다.
2. `>>` : right shift
>`>>` :  비트를 오른쪽으로 밀고, 밀어서 빈칸을 최상위 부호비트에 따라 0또는 1을 채운다.
3. `>>>` : unsigned right shift
>`>>>` : 비트를 오른쪽으로 밀고, 밀어서 빈칸을 항상 0으로 채운다.

## 관계연산자
> 대소비교, 연산결과 boolean으로 발생
**수업 코드: [관계연산자](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day4/Operator4.java)**

## 논리연산자
**수업 코드: [논리연산자](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day4/Operator5.java)**
> 일반 논리 : 여러 개의 관계연산자를 묶어서 비교할 때
> &&(AND), ||(OR)
- &&: 전항이 ture이고 후항이 ture일 때 ture반환
- ||: 전항이 false이고, 후항이 false일 때만  false반환

> 비트 논리 : 비트에 대한 연산
> &(AND), |(OR), ^(XOR)
- &(AND): 상위비트와 하위비트 모두 1인 경우에만 1내림
- |(OR): 상위비트와 하위비트 모두 0인 경우에만 0내림
- ^(XOR): 상위비트와 하위비트 둘중 하나만 1인 경우 1내림

## 삼항연산자
**수업 코드: [삼항연산자](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day4/Operator6.java)**
> 문법) 조건식 ? 항1 : 항2

## 대입연산자
**수업 코드: [대입연산자](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day4/Operator7.java)**
> 대상체의 값을 변경한다.
- 순수대입: =
- 산술대입:  +=, -=, *=, %=
- 쉬프트 대입: <<=, >>=, >>>=
- 비트논리대입: &=, |=, ^=

## 시프트대입연산자
**수업 코드: [시프트대입연산자](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day4/Operator7.java)**

## 외부 값 입력: main method arguments
> arguments(method 외부에 존재하는 값들)
- parameter ( 매개변수: method외부의 값을 method 내부로 전달하기 위한 변수 )
**수업 코드: [Arguments](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day4/UseArguments.java)**