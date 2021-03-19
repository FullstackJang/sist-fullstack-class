# JOIN
> 정규화가 진행되어 서로 다른 테이블에 분산 저장된 데이터를 모아서 조회할 때

- 조인 조건을 잘못 설정하면 모든 레코드의 곱하여 조회되는 `"Cartesian Product"`이 발생할 수 있다. (카티션 곱이 발생되어 조회된 결과의 레코드를 사용할 수 없다.)
- **ANSI 문법**과 **Oracle 문법** 두 가지를 사용할 수 있다.
- `DRIVING TABLE(조인의 기준이 되는 테이블)` 선정에 따라 join속도가 달라진다.
    - join 시 key가 되는 테이블
## **driving table 선정 조건**
- `부모자식 관계`가 설정 되어있다면, `primary key`가 설정된 테이블이 **DRIVING TABLE**
- 조인 조건에 따라 `EQUI-JOIN`과 `NON-EQUI-JOIN`으로 구분된다.

- **EQUI-JOIN(등가 조인)**
- 조인 조건이 정확히 일치하는 경우 사용
  (PK(기본키) 와 FK(외래키) 를 사용한 조인)
- 조인 조건에 `' = '` 를 이용하는 조인을 보통 `등가 조인(Equi-join)`이라고 함.
    - **INNER JOIN**
    - **OUTER JOIN**

- **NON-EQUI-JOIN**
    - SELF JOIN


- 관계가 없는 테이블이 조인된다면 
    - 레코드의 다양성이 적은 테이블이 **DRIVING TABLE**것이 좋다.
    - 레코드의 수가 적은 테이블이 **DRIVING TABLE**이 되는 것이 좋다.

## JOIN의 종류
- **INNER JOIN**
- **OUTER JOIN**
- CROSS JOIN
- **SELF JOIN**

# **INNER JOIN**
> 서로 다른 테이블의 같은 값이 존재하는 레코드만 조회

**INNER JOIN ANSI쿼리**
```sql
        SELECT          컬럼명,,,,
        FROM            테이블명
        INNER JOIN      조인할 테이블 명
        ON              조인 조건
        INNER JOIN
        ON
        
        --INNER JOIN
        --ON
        --문법이 여러개 온다.
        
        .
        .
        .
        WHERE 검색 조건
```
**INNER JOIN Oracle쿼리 문법**
```sql
        SELECT  컬럼명,,,,  -- alias.컬럼명을 권장 / 이유) 나중에 테이블이 많아지면 중복되는 컬럼명이 많아지니 구분하기 어렵다.
        FROM    테이블명 alias, 조인할 테이블명 alias ,,,,
        WHERE   ( 조인조건 ) AND 검색조건
```

1. 연결 컬럼(조인조건) : `deptno`컬럼
- 두 테이블에 공통되는 컬럼에 연결 조건을 찾아야한다.

```sql
        SELECT e.empno, e.ename, e.hiredate, d.deptno, d.dname, d.loc /*inline view에 deptno컬럼명이 반영 되지 않는다.*/
        FROM		dept d
        INNER JOIN	emp e
        ON e.deptno = d.deptno;
```

<img src = "https://user-images.githubusercontent.com/69107255/102846637-d7e4c300-4453-11eb-8f9d-78ac3f30d1e4.png">


# **OUTER JOIN**
> 한쪽 테이블에만 레코드가 존재하더라도 조회 가능한 JOIN

- 3가지가 존재
- **LEFT OUTER JOIN**
- **RIGHT OUTER JOIN**
- FULL OUTER JOIN

**OUTER JOIN ANSI 문법**
```sql
        SELECT  컬럼명,,,,
        FROM    테이블명 LEFT | RIGHT OUTER JOIN  조인할 테이블명  --[ OUTER ]는 생략가능
        ON      조인조건
```

**OUTER JOIN Oracle 문법**
```sql
    조인 조건에 (+) 기호를 사용하여 OUTER JOIN을 구현한다. 
    레코드가 존재하지 않는 컬럼에 기호를 사용

        SELECT      컬럼명 ,,,,
        FROM        테이블명 alias, 조인할테이블명 alias ,,,,
        WHERE       alias.컬럼명(+) = alias.컬럼명; -- 두 개의 컬럼 중 레코드가 없는 쪽에 '(+)' 를 붙여준다.
```

# **SELF JOIN**
> 하나의 테이블을 조인 하는 것

- `검색출력용 테이블`과, `조건비교용 테이블` 구분하여 사용할 것

```sql
        SELECT     컬럼명
        FROM       테이블명 alias , 조인할 테이블 명 alias
        WHERE      ( 조인조건 )
```