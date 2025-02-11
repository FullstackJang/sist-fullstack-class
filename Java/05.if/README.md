# 자바 5일차 (1027)

## 제어문
> 프로그램의 순차적인 흐름을 변경하는 문장들

## 조건문(if,else,switch~case)
> 단일 if, if~else, 다중 if 3가지 형태로 사용.

## Flowchart
> 프로그램의 간단한 흐름을 도식화.

## 단일 if
> 조건에 맞을 경우에만 코드를 실행해야 할 때

**수업 코드: [단일 if](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day5/UseIf.java)**

```
    문법:
         if(조건식) {
            조건에 맞을 경우 실행되어야 할 코드들
    }
```

## if~else문
> 둘 중 하나의 코드가 반드시 실행 되어야할 때

**수업 코드: [if~else문](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day5/UseIfElse.java)**
```
	문법:
		if(조건식) {
			조건에 맞을 때 실행될 문장들...
		}
		else {
			조건에 맞지 않을 때 실행 될 문장들...
		}
```

## 다중if 문(else~if)
> 연관성있는 여러 조건을 비교해야 할 때

**수업 코드: [else~if](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day5/UseElseIf.java)**

```
    문법:
        if(조건식) {
            조건에 맞을 수행 문장들...
        }
        else if(조건식) {
            조건에 맞을 때 수행 문장들...
        }
        else if(조건식) {
            조건에 맞을 때 수행 문장들..
        }
       else {
           모든 조건에 맞지 않을 때 수행 문장들...
       } 
```

## switch~case
> 일치하는 정수를 비교할 때 사용

**수업 코드: [if~else문](https://github.com/FullstackJang/sist-fullstack-class/blob/master/Java/day5/UseSwitchCase.java)**

```
    문법:
        switch(변수명) { //비교 가능 타입: byte,short,int,char, String(JDK1.7부터 사용가능)

            case 상수: 변수의 값이 상수와 같을 때 수행 문장들...
            case 상수: 변수의 값이 상수와 같을 때 수행 문장들...
            case 상수: 변수의 값이 상수와 같을 때 수행 문장들...
            .
            .
            .
            default: 변수의 값에 해당하는 case가 없을 때 수행문장들..
        }
```

## break;
> switch-case, for, while, do~while문에서 실행을 멈추고 빠져 나갈 때 사용