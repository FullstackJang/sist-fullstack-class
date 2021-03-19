# Select Subquery

- 단수행, 복수행 모두 사용 가능
- scalar subquery
    - 조회하는 컬럼에 사용하는 subquery

## **Select Subquery 문법**

## **단수행**

```sql
    select 컬럼명, , ,
    FROM 테이블명
    WHERE 컬럼명 = (SELECT ,,,,)
```

## 복수행
> 조회결과를 가지고 재 조회

- 바깥 SELECT컬럼명은 실제 테이블의 컬럼명이 아니고 inline view의 컬럼명이다.
- 바깥 SELECT에서 사용하는 컬럼명은 조회결과에서 나오는 컬럼명만 사용할 수 있다.
- 많은 양의 레코드에서 일부분의 레코드를 조회할 때
```sql
    SELECT 컬럼명, , , 
    FROM (SELECT, , ,) -- inline view를 가지고 재 조회
```

## scalar : 조회컬럼에 정의하는 subquery 
> 바깥 쿼리가 실행한 컬럼값을 가지고 조회.
 
```sql
    SELECT 컬럼명, (SELECT 컬럼명 FROM 테이블명 WHERE 컬럼명 = 컬럼명)
    FROM 테이블명
```

# ROWNUM
> 조회하는 컬럼에 가상번호를 부여할 때 사용하는 가상컬럼(pseudo column)

**ROWNUM 특징**
- ORDER BY전에 번호가 부여되기 때문에, 정렬하면 번호가 섞인다.
- WHERE절에서 조건에 사용하면 1번행에서는 조회가 되나, 1번행을 넘어가면 조회되지 않는다.
- SELECT 마다 별개로 사용된다.

```sql
    SELECT 컬럼명, ROWNUM
```

# UNION
> 여러 테이블을 하나로 합쳐서 조회할 때

- 여러 테이블의 조회결과를 아래로 붙여 조회할 때 사용
- 컬럼명은 달라도 되나, `컬럼의 개수`,`데이터형`은 **반드시** 일치해야한다.
- SQLInjection 취약점 존재
- **error** 
    - 컬럼의 개수가 맞지 않을 때
    - 컬럼의 데이터형이 일치하지 않을 때

# **UNION 문법**

```sql
        -- A 테이블
        SELECT 컬럼,,,
        FROM 테이블명
   
        UNION [all]

        -- B 테이블
        SELECT 컬럼,,,
        FROM 테이블명
        UNION [all]

        -- A테이블과 B테이블이 합쳐져서 하나로 보여준다.
```

## **union**
> 중복데이터가 존재하면 중복데이터를 출력하지 않는다.

## **union all**
> 중복 데이터가 존재하더라도 모두 출력한다.

# EXITS()
> 서브쿼리에서 조회 결과가 없을때 바깥 서브쿼리의 실행을 막기

- WHERE절 `exits 함수`를 사용하면 조회결과가 있을 때에만 외부 쿼리가 실행된다.
- `EXITS()함수`내의 쿼리결과를 사용하지 않고, 조회 레코드가 있는지 없는지만 판단 
- `EXITS()`를 통해 바깥 쿼리를 실행 할건지 안할건지 결정 할수 있다.
```sql

        SELECT
        FROM
        WHERE EXITS(조회 쿼리)
```

```sql
    WHERE EXISTS( SELECT empno FROM emp WHERE to_char(hiredate,'yyyy')='1983')

    -- 1983년에 입사한 사람이 있으면 바깥쿼리를 실행해줘
    -- 1983년에 입사한 사람이 있으면 조건이 TRUE가 되고  없다면 FALSE가 된다. 
```
