# Oracle 주석
```
-- 한줄주석

/*
    여러줄 주석
*/
```

# insert문 (DML)
> `테이블에 레코드 삽입`할 때 사용

- **특징**
    - 기존에 레코드 사이에 값이 들어간다.(순차적으로 입력되지 않는다.)

**insert문법 2가지 (입력되는 값은 반드시 Table의 컬럼 순서대로 입력해야 된다.)**

- **컬럼명을 생략하여 사용**
 ```   
    insert into 테이블명 values(값,,,,);
```
- **컬럼명을 명시하여 사용(권장)**
    - 입력되는 값은 컬럼의 순서와 상관 없이 입력가능
    - 명시되지 않은 컬럼에는 `null(숫자도 문자열도 아닌 사용할 수 없는 값)`이 들어간다.

```
insert into 테이블명(컬럼명,,,) values(값,,,,);
```

# 값의 종류에 따라 작성하는 법
- **숫자**
    - `12`, `15`, `11`, `11.14`

- **문자열**
    - (**고정길이형**,**가변길이형**) `'값'`

- **날짜**
    - **현재 날짜** - sysdate ( 년,월,일,시,분,초 까지 추가 )
    - **다른 날짜** - 문자열을 날짜형식으로 작성하여 추가 '2020-12-16' `to_date()함수`를 사용하여 추가


# select (DML)

- `모든 레코드`의 `원하는 컬럼`을 `조회`할 때 사용

**select 문법**
- `select`와 `from`은 **필수**로 와야한다. (**모든 레코드**에서 원하는 `컬럼`만 `조회`)
- `where`, `gruop by`, `having`, `order by`은 **선택**
    - `select` **컬럼명, 컬럼명 연산자, 함수명(컬럼명),,**
    - `from` **테이블명**
    - where  검색조건 조건에 일치하는 레코드만 조회
    - group by 그룹으로 묶어 레코드만 조회 **그룹으로 묶일 컬럼명,,,**
    - having 그룹으로 묶일 조건   **그룹으로 묶일 조건**
    - order by 정렬 조건 **정렬할 컬럼명**

**select 조회** 컬럼에 `*`을 사용하면 해당 테이블의 모든 컬럼을 조회

# Transaction
> DBMS의 작업 단위

- 하나의 쿼리문으로 구성되는 경우도 있고, 여러개의 쿼리문으로 구성되는 경우도 있다.
- **Transaction**의 대상쿼리는 `insert`, `update`, `delete` 이다.
- transaction이 **정상적**으로 종료되는 경우에는 **commit**을 하여 작업 상태를 저장해야한다.
- transaction이 **비정상적**으로 종료되는 경우 **rollback**을 하여 작업 상태를 취소해야한다.

- **commit**
> 접속자 세션의 Transaction작업상태를 HDD에 기록하고, 모든 접속자에게 변경상황을 통지하는 일

- commit은 `insert`**,** `update`**,** `delete` 쿼리작업 후에 하면 된다.
- commit된 데이터는 rollback으로 작업 취소할 수 없다.
- commit되기 전의 데이터는 다른 접속자(sqlplus,golden) 세션에서 사용할 수 없다.

**커밋 문법**
```
    commit
```

**rollback**
> 접속자 세션에 Transaction작업상태를 취소하는 일

- **savepoint**를 사용하여 rollback하는 위치를 설정하고, 해당 지점 까지의 쿼리작업을 취소 할 수 있다.
    - `savepoint(저장점)`은 commit을 수행하면 모두 사라진다.(savepint는 Oracle에만 존재)
    - 같은 이름의 `savepoint(저장점)` 생성하면 이전 저장점이 사라진다.
    - `insert`**,**`update`**,**`delete`(transaction 대상쿼리문)가 실행되기 전에 설정한다.

**savepoint 문법**
- `insert`**,**`update`**,**`delete`(transaction 대상쿼리문)가 실행되기 전에 설정한다.
```
    savepoint 저장점명;
```

```
    savepoint a;
    insert into ...;
    savepoint b;
    update set ...;

    rollback to b; // dupdate set 부분 4번라인이 취소되고  2번라인까지로 작업것으로 돌아간다.


    rollback to a; // 1번라인까지 작업까지 돌아간 후
    rollback to b; // 해당 쿼리를 실행하면 오류


```

**rollback 문법**
- 직전 commit이후 작업을 취소
- 삭제하기 전에 작업으로 돌아갈 수 있다. 단, commit후에는 불가능
```
rollack;
```

```
    rollback to 저장점명;
```

golden 같은 애플리케이션은 비정상 종료를 하면 commit을 자동적으로 해주지만
sqlplus dos환경에서는 비정상 종료하면 commit을 자동적으로 해주지 않는다.

# update
> `조건`에 맞는 `컬럼`의 `값`을 `변경`할 때 사용

- update는 Transaction 대상 쿼리(작업이 정상적으로 종료가 되었다는 판단이 되면 `commit`을 해줘야한다.)

**update문법**
- `set`은 변경할 값에 대한 설정
- `where`절은 `조건` 
    - 조건에 일치하는 모든 레코드의 컬럼 값을 변경한다. (0~n건 행이 변경)
```
    update 테이블명
    set    컬럼명 = 변경할 값, 컬럼명 = 변경할 값 , , , 
    where  컬럼명 = 기준값
```
# delete(DML)
> 테이블에 레코드를 삭제할 때

- 컬럼에 값한개를 지우는 것은 할 수 없다. update를 통해서 null로 변경은 가능
- `delete`는 **행**하나를 지운다. 
- `truncate`로 `절삭`하는 것보다 `속도가 느리다`.
- transaction 대상 커리문 (commit과 rollback이 가능)

**delete 문법**
- **모든 레코드를 삭제**
```
    delete from 테이블명;
```

- **2.조건에 맞는 레코드를 삭제**
```
    delete from 테이블명
    where 컬럼명=삭제할 값;
```

## truncate:(DDL)
- **특징**
    - table에 레코드를 절삭할 때 사용
    - **transaction 대상쿼리가 아니므로 commit이나 rollback을 할 필요가 없다.**
    - **절삭된 레코드는 rollback으로 복구할수 없다.**
    - **특정행**만 절삭할 수 없다.

**truncate 문법**
```
    truncate table 테이블명;
```

# drop(DDL)
- DBMS의 `객체`(`table`**,**`sequence`**,** `index`**,** `function` 등등) 를 **삭제**할 때 사용
- transaction 대상 쿼리가 아님

- 테이블 삭제

**drop 문법**
```
    drop 대상 대상명;
```

**테이블 삭제**
```
    drop table 테이블명;
```

- Oracle 11g 이후 부터 `삭제된 테이블`은 `휴지통`으로 이동된다. 

- 휴지통 옵션
    - **휴지통 보기(show명령어는 SQLPlus에서 제공하는 문장이다. 따라서, tool에서 지원하지 않으면 사용 불가(골드는 사용 불가))**
    - `삭제전 이름`,`휴지통으로 이동된 이름의 정보`가 보여진다.)
    ```
        show recyclebin;
    ```
    - **휴지통 비우기**
    ```
        purge recyclebin; //객체가 완전히 지워진거고, 복구가 안된다.
    ```
    - **복구 하기(같은 이름의 테이블이 생성되어 있다면 복구할 수 없다.)**
    ```
        flashback table 테이블명 to before drop;
    ```


# Oracle 연산자

|종류|연산자|
|----|----|
|산술 연산자<br>(select문의 검색 컬럼에 사용할 수 있다.)|`+`**,** `-` **,** `*`**,** `/`|
|관계 연산자<br>(관계연산자는 where, having절에서 사용할 수 있다.|`>`**,** `<`**,** `>=`**,** `<=`**,** `=(같다)`**,** `!=(<>`)|
|논리 연산자|`and`**,** `or`**,** `not`|
|문자열 비교|`like`**,** `%`**,** `_`|
|null 비교연산자|`is null`**,** `is not null`|
|범위 연산자|컬럼명 `between 값 and 값`|
|문자열 붙임연산자<br>(select문의 검색 컬럼에 사용할 수 있다.)|, ` || ` ,|

