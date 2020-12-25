# Subquery
> 쿼리문 안에 ( )를 사용하여 SELECT쿼리문을 작성하는 것

- 단수행 서브쿼리(서브쿼리가 실행 되었을 때 한 행이 반환되는 쿼리)
- 복수행 서브쿼리(서브쿼리가 실행 되었을 때 여러행이 반환되는 쿼리)로 구분
- 서브쿼리는 ()안의 SELECT 문이 가장 먼저 실행되고, 외부 쿼리가 실행된다.


## Subquery를 가질 수 있는 쿼리문
- CREATE TABLE
- INSERT
- UPDATE
- DELETE
- SELECT

# Create Subquery
> 조회된 결과로 테이블을 생성할 때(테이블 복사)

- 컬럼명, 테이터형, 크기, 조회가 된 레코드는 복사가 되지만, 제약사항(user_constraints)는 복사되지 않는다.
    - not null 조건이 따로 설정되어 있다면 복사가 된다.
- 단수행, 복수행 서브쿼리 모두 사용가능

**Create Subquery 사용법**
```sql

CREATE TABLE 테이블 명 AS ( SELECT , , , ,) /*select로 조회된 inline view를 가지고 테이블을 만드는것*/

```

# Insert Subquery
> 조회된 결과로 컬럼값을 추가 할 때

- 단수행, 복수행 서브쿼리 모두 사용 가능

**Insert Subquery 단수행 문법**
```sql
    INSERT INTO 테이블명(컬럼명,,,) VALUES (값, (SELECT ,,,));
```

**Insert Subquery 복수행 문법**

```sql
    INSERT INTO 테이블명(컬럼명,,) (SELECT ,,,)
```

# Update Subquery
> 조회된 결과로 값을 변경할 때

- 단수행 subquery만 가능

**Update Subquery 문법**
```sql
    UPDATE 테이블명
    SET     컬럼명 = (SELECT ,,,,) -- 값이 들어가는 부분에 SELECT를 사용 가능
    WHERE   컬럼명 = (SELECT ,,,,) -- 값이 들어가는 부분에 SELECT를 사용 가능 
```


# Delete Subquery
> 조회된 결과로 값을 삭제할 때

- 단수행 subquery만 가능

**Delete Subquery 문법**
```sql
    DELETE FROM 테이블명
    WHERE 컬럼명 = (SELECT ,,,,); -- 값이 들어가는 부분에 SELECT가 들어감
```