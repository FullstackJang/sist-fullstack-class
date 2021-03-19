# 집계함수(그룹함수)
- `GROUP BY`와 같이 사용하면 그룹별 집계를 얻을 수 있다.(GROUP BY는 대부분 집계함수와 사용된다.)
- **WHERE절**에서 사용할 수 없다.
- 컬럼 중 같은 값을 묶어서 하나로 만드는 함수
- 하나의 레코드로 결과가 나옴
- 집계함수는 여러행이 조회되는 컬럼과 함께 사용되면 Error
- `sum`, `avg`, `count`, `max`, `min` 등의 함수가 제공


# COUNT
- 조회된 레코드의 수를 반환하는 함수,(레코드의 수)
- null이 있는 레코드의 수는 제외

**COUNT 사용법**
```sql
    COUNT(컬럼명) -- 컬럼명에 들어가는 데이터형은 상관이 없다.
```

# SUM
- 컬럼의 값을 합쳐 반환하는 함수

```sql
    SUM(컬럼명)
```


# AVG
- 컬럼에 존재하는 모든 레코드의 평균값을 반환하는 함수

```sql
    avg(컬럼명)
```

# MAX
- 컬럼에 존재하는 값 중 가장 큰 값을 반환하는 함수

```sql
    MAX(컬럼명)
```

# MIN
- 컬럼에 존재하는 값 중 가장 작은 값을 반환하는 함수

```sql
    MIN(컬럼명)
```

--

- 여러 컬럼이 그룹으로 묶이면 그룹별 결과, 중간결과, 총합결과를 출력한다.
- 부서에 해당하는 직무별 직무, 사원수를 조회
# 집계의 총 집계를 얻을 때
- GROUP BY ROLLUP(그룹으로 묶일 컬럼) : 집계 후 전체 결과를 출력
- GROUP BY CUBE(그룹으로 묶일 컬럼) : 전체 결과 후 집계를 출력

## ROLLUP

```sql
SELECT deptno, job, count(job)
FROM   emp
GROUP BY ROLLUP(deptno,job);
```

<img src ="https://user-images.githubusercontent.com/69107255/102612119-85fe1d80-4173-11eb-8673-cfe4d9a550ed.png">

## CUBE

```sql
SELECT deptno, COUNT(empno), SUM(sal)
FROM emp
GROUP BY CUBE(deptno);
```

<img src = "https://user-images.githubusercontent.com/69107255/102612034-623ad780-4173-11eb-9bcb-624b4c0d5e6b.png">


# ORDER BY(정렬)
> 조회된 레코드를 `오름차순`, `내림차순`으로 만들어 조회하는 것

- `모든 데이터`는 정렬할 수 있다.
- `오름차순`이 기본 정렬이다.
- 레코드가 많아지면 속도가 느려진다.

**OREDER BY 사용법**
```sql
    ORDER BY 정렬할 컬럼명 ASC 정렬할 컬럼명 ASC ,,, -- 오름차순 정렬
    ORDER BY 정렬할 컬럼명 DESC 정렬할 컬럼명 DESC ,,, --내림차순 정렬    
```


- 문자열이 숫자를 가질 때에는 자릿수의 정렬
- varchar2 데이터 타입으로 NUM컬럼을 확인 했을 때
- 기본 정렬인 ASC로 왼쪽부터 1의자리 10의 자리 .... N의 자리를 비교하며 큰 수 대로 정렬한다. 
|ORDER BY NUM 전|ORDER BY NUM 후|
|----|----|
|1|1|
|21|100001|
|1001|1001|
|300|21|
|29999|29999|
|100001|300|

# 순위 함수
- `ORDER BY`와 함께 사용
- 조회되는 컬럼 값에 순서를 부여하여 조회할 때 사용

# RANK() OVER()
> `같은 순서`가 발생한다. // 공동 순위가 발생 ex) 4위가 2명일 시 5위 없이 6위가 나옴

**RANK() OVER() 사용법**
```sql
    RANK() OVER(ORDER BY 정렬할 컬럼명)

    RANK() OVER(PARTITION BY 구분할 컬럼명 ORDER BY 정렬할 컬럼명)
```


# ROW_NUMBER() OVER()
> 같은 순서가 발생하지 않는다.

```sql
    ROW_NUMBER() OVER(ORDER BY 정렬할 컬럼명)
    
    ROW_NUMBER() OVER(PARTITION BY 구분할 컬럼명 ORDER BY 정렬할 컬럼명)
```
---

# 날짜 함수
> 날짜를 연산하는 일을 하는 함수

## ADDMONTHS()
> 월을 더할 때 사용

**ADDMONTHS() 사용법**
```sql
    ADDMONTHS(날짜, 더할 월수)
```


## MONTHS_BETWEEN()
> 두 날짜간 개월 차이

**MONTHS_BETWEEN() 사용법**
```sql
    MONTHS_BETWEEN(이후 날짜, 이전 날짜)
```

# LAST_DAY(현재날짜)

```sql
    LAST_DAY(현재 날짜)
```