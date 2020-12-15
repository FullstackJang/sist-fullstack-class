# DBMS (DataBse Mangement System)
> 체계화된 데이터들의 모임

- **DBMS란?**
    - DataBse의 정의와 특징을 고려하여 제작된 프로그램


- **DBMS사용 목적**
    - 과거의 데이터를 가지고 미래를 예측하기 위해서(정보를 관리할 때 사용)

- **DBMS의 종류**
    RDBMS(Relational DataBase Management System)
    - Oracle(대용량)
    - MS-SQL(가성비)
    - DB2(가성비)
    - MySQL(속도가 빠름)

- **DataBase의 등장 배경**
    - 여러 사용자가 데이터를 공유해야할 필요가 생김
    - 구조변경에 대한 번거로움이 수시로 생김
    - 물리적인 주소가 아닌 데이터 값에 의한 검색을 수행

- **DataBase의 정의**
    - `통합된데이터`
    - `공용데이터`
    - `운영데이터`
    - `저장데이터`
- **SQL**
    - SQL(Structured Query Language)문으로 DBMS를 조작
    - SQL문은 DBMS마다 다르다.(ANSI Query)
    - `DDL`,`DCL`,`DML` 3가지로 구분된다.

- **정의어(Data Definition Language)**
    - 객체(`table`,`index`,`sequence`,`view`)등의 객체를 생성하거나, 삭제,조작할 때 사용하는 SQL문
    - `create`, `drop`, `truncate`, `alter`

- **제어어(Data Control Language)**
    - 데이터를 제어할 때 사용하는 SQL문
    - `commit`, `rollback`, `grant`, `revoke`

- **조작어(Data Manipulation Language)**
    - 테이블을 조작할 때 사용하는 쿼리문
    - `insert`, `update`, `delete`, `select`

- **DataBase의 특징**
    - `실시간 접근성`
    - `내용의 의한 참조`(주소가 아닌 값에 대한 참조)
    - `동시 공유`


## **RDBMS**
> Table을 생성하여 관계를 설정하고 데이터를 저장,조작하는 DBMS

##  **Data란?**
- Data를 의미있게 정리하면 정보가 된다.(DataBase)
- `수`, `영상`, `단어`등의 형태로 된 의미의 단위
- `연구`나 `조사`의 바탕이 되는 재료

## **Table**

|번호|이름|나이
|----|----|----|
|1|류수정|23|
|2|케이|25|

## **컬럼명(`Column Name`, `Field Name`)**
> 컬럼이 가지고 있는 값이 무엇인지 알려주는 것

|번호|이름|나이|
|----|----|----|

# #**컬럼(`Column`)**
> `컬럼명`에 해당하는 값들

||
|----|
|류수정|
|케이|

## **레코드(`recode`,`row`,`tuple`)**
> 식별하기 위해 저장된 정보들

||||
|----|----|----|
|1|류수정|23

## **도메인(domain)**
> 컬럼에 해당하는 값하나를 `도메인` 이라고한다.

||
|-----|
|류수정|

- **Oracle 특징**
    - Oracle은 `tablespace`에 `테이블`이 저장된다.
    - Oracle은 대소문자를 구분하지 않는다.(**모두** **대문자**로 저장된다.)
    - ( **모두의 범위** = `컬럼명`, `테이블명`, `쿼리문`, `데이터형` )
    - (`컬럼값`은 **대소문자**가 구분된다.)

# 테이블 생성
- `DDL`의 `create`를 사용

**create 문법**
```
    create table 테이블명 (
        //컬럼단위 제약사항
        컬럼명 데이터형(크기) constraint 제약사항명 제약사항
        .
        .
        .
        
        //테이블단위 제약사항
        constraint 제약사항명 제약사항종류(적용컬럼),
        .
        .
        constraint 제약사항명 제약사항종류(적용컬럼)
    );
```

# **Oracle에서 지원하는 DataType**
|값 종류|데이터형 명| 크기|사용법|
|---|----|----|----|
|숫자 - 정수형|number|숫자 22자|컬럼명 number(크기)|
|숫자 - 실수형|number|숫자 22자|컬럼명 number(전체크기,실수크기)|
|문자열 - 고정길이형|char|2000byte문자(영문자로 2000자)|컬럼명 char(크기)|
|문자열 - 가변길이형|varchar2|4000byte문자(영문자로 4000자)|컬럼명 varchar2(크기)|
|날짜|date||컬럼명 date(현재 날짜를 추가할 때에는 sysdate사용)|
|긴 숫자<br>(숫자22자 이상)|long|2GByte|컬럼명 long<br>입력되는 숫자까지 저장된다.|
|긴 문자열|clob|4GByte|컬럼명 clob|
|파일|blob|4GByte|컬럼명 blob|

## **number**

```
사람의 나이는 0~999
age number(3): 0~999
age number : 0 ~ 9999999999999999999999(22개)

사람의 키는 정수3자리 실수 1자리
height number(4,1) //(0~999.9) 총 4자리 중 실수는 1자리만 쓰겠다.

사람의 몸무개는 정수3자리 실수 2자리
weight number(5,2) // (0~999.99)
```

## **문자열**
- `고정길이`와 `가변길이`가 있다.

- `고정길이형`

- **특징**
    - 최초 설정한 크기를 유지하는 데이터 형
    - 검색속도가 빠르다.
    - 검색의`키(primary key)`로 설정하여 사용한다.
    - 데이터형의 길이가 같을 때 (주민번호,카드번호 등등)

- **단점**
    - 값이 설정한 크기보다 적게 입력되더라도 최초 크기를 유지하여 저장공간에 낭비로 이어질 수 있다.
```
name char(10)

insert into 테이블명(NAME) VALUES('류수정');

한글은 한글자당 3byte를 차지한다. 1byte에 공간을 가지고 있는다.

검색 시 1byte에 공간이 있기 때문에 조회가 안될 수 있음
```
- `가변길이형`

- **특징**
    - 최초 설정한 크기를 유지 하지않는 데이터 형
    - 검색속도가 느리다.
    - 값이 설정한 크기보다 적게 입력되면 저장공간의 크기가 줄어든다.
    - 데이터의 길이가 다를 때(이름, 주소,이메일 주소)
```
    name varchar2(10)

    insert into 테이블명(name) values('류수정');<br>

    1byte가 남으면 버려버린다.

```

# **SQLPlus 사용법**
> Oracle에서 제공하는 Oracle Client

- SQLPlus 하는일
    - Server Process 접속
    - SQL문을 작성 후 실행
    - 서버가 처리한 결과를 받아서 출력하는 일

## **Server Process 접속**

- 관리자 계정 : sqlplus "/as sysdba"
    - sqlplus "아이디/비번" //아이디와 패스워드가 노출되어서 좋은 방법이 아님
    - sqlplus "아이디(엔터 후) 비밀번호
    - sqlplus (엔터후) 아이디 비밀번호 