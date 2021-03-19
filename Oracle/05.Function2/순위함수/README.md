# RANK 함수
> 순위를 부여할 때 
- `ORDER BY절`을 함께 사용하지 않는다.

- 사원테이블에서 사원번호, 사원명, 연봉, 연봉의 순서를 조회하세요

# 조회되는 레코드에 공동 등수를 확인 할 때

```sql
SELECT empno, ename, sal, RANK() OVER(ORDER BY sal desc)
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102576063-10289080-4138-11eb-90d8-ae5ee7d158eb.png">

# 조회되는 레코드에 공동 등수를 확인하고 싶지 않을 때
```sql
SELECT empno, ename, sal, ROW_NUMBER() OVER(ORDER BY sal desc)
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102576123-29c9d800-4138-11eb-95cd-650f8a903ef4.png">

# 이름 순으로 중복 등수 없는 순위
```sql
SELECT ename, rank() OVER(ORDER BY ename)
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102576161-38b08a80-4138-11eb-8702-1d9bb97e5fcc.png">

# PARTION BY 사용

- 사원테이블에서 부서번호, 부서별 연봉 순위, 연봉, 사원명을 조회

```sql
SELECT deptno, ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal desc) rank, sal, ename
FROM emp;
--WHERE deptno = 30 특정 부서에 대해서만 알 수도 있다.
```

<img src = "https://user-images.githubusercontent.com/69107255/102576220-5b42a380-4138-11eb-8162-2a2c9d688dbe.png">

- 사원테이블에서 직무, 직무별 연봉순위, 연봉, 사원명 조회
    - 단, 같은 연봉이 존재한다면 같은 순위를 가진다.

```sql
SELECT job, RANK() OVER(PARTITION BY job ORDER BY sal) rank, sal, ename
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102576244-6b5a8300-4138-11eb-8785-a5b9ef660ee3.png">