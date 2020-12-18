# 집계함수

# COUNT()
- 사원테이블에서 모든 사원 수, 보너스를 수령하는 사원 수
    - 보너스를 수령하지 않는 사원 수
    - null은 집계에 포함하지 않는다.

```sql
SELECT COUNT (empno), COUNT (comm), COUNT(empno) - COUNT (comm)
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102610684-f0fa2500-4170-11eb-8ef6-048162804a02.png">

# SUM()
- 사원테이블에서 연봉의 합
```sql
SELECT SUM(sal)
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102610965-7087f400-4171-11eb-93b4-9ba3c6bf767b.png">

# AVG()

- 사원테이블에서 연봉의 평균

```sql
SELECT TRUNC(AVG(sal))
FROM emp;
```

<img src ="https://user-images.githubusercontent.com/69107255/102610996-809fd380-4171-11eb-890c-b2587557a938.png">

# MAX()
- 사원테이블에서 최고 연봉

```sql
SELECT  MAX(sal)
FROM emp;
```
<img src = "https://user-images.githubusercontent.com/69107255/102611068-99a88480-4171-11eb-8f83-a0779e949b1d.png">

# MIN()
- 사원테이블에서 최저 연봉
```sql
SELECT MIN(sal)
FROM emp;
```
<img src = "https://user-images.githubusercontent.com/69107255/102611121-b0e77200-4171-11eb-98bb-cf217f503198.png">

- 집계함수는 여러행이 조회되는 컬럼과 함께 사용되면 Error
- 사원테이블에서 최고연봉, 최고연봉자 조회
- 에러 이유: 최고연봉은 1행, 사원명은 n행이 조회되기 때문에
```sql
SELECT MAX(sal), ename /*MAX로 하나의 레코드가 나오고  ename으로 14개의 레코드가 나오기 때문에 에러*/
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102611296-fe63df00-4171-11eb-9326-2f8dabf69052.png">

- 집계함수는 WHERE절에 사용할 수 없다.
- 사원테이블에서 평균연봉보다 많이 받는 사원의 사원 번호, 사원명, 연봉, 입사일을 조회

```sql
SELECT empno, ename, sal, hiredate
FROM emp
WHERE TRUNC(AVG(sal) > sal;
```
<img src = "https://user-images.githubusercontent.com/69107255/102611215-dbd1c600-4171-11eb-907b-a16c5d13fedd.png">

- 집계함수는 WHERE절에 사용할 수 없다.
- 사원테이블에서 부서별 인원이 3명 이상인 부서의 사원 번호, 사원명, 연봉, 입사일 부서번호 조회

```sql
SELECT  empno, ename, sal, hiredate
FROM  emp
WHERE  COUNT(deptno) > 3;
```

<img src = "https://user-images.githubusercontent.com/69107255/102611215-dbd1c600-4171-11eb-907b-a16c5d13fedd.png">

------- 집계함수와 GROUP BY절을 사용하면 그룹별 집계를 얻을 수 있다.

- 사원테이블에서 `부서번호`, `부서별 인원수`, `부서별 연봉 합`, `평균연봉`, `부서별 최고 연봉`, `부서별 최저 연봉 조회`

```sql
SELECT deptno, COUNT(hiredate), SUM(sal), TRUNC(AVG(sal)), MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno;
```
<img src = "https://user-images.githubusercontent.com/69107255/102611413-3539f500-4172-11eb-9dc5-0c2cab0c3977.png">

- 사원테이블에서 `매니저번호`, `매니저별 관리하는 사원 수`, `최고 연봉을 조회`
    - 단, 매니저가 존재하는 사원만 출력해부세요.

```sql
SELECT mgr, count(mgr), MAX(sal)
FROM emp
WHERE mgr IS NOT NULL
GROUP BY mgr;
```
<img src = "https://user-images.githubusercontent.com/69107255/102611491-5e5a8580-4172-11eb-86f8-66753ae602d1.png">

# HAVING 절의 사용

- 사원테이블에서 사원수가 4명이상인 부서의 부서번호, 부서별 사원 수, 연봉 합

```sql
SELECT deptno, count(empno), sum(sal)
FROM emp
GROUP BY deptno
HAVING COUNT(empno) >= 4;
```

<img src = "https://user-images.githubusercontent.com/69107255/102611588-86e27f80-4172-11eb-9af9-a24a8b738749.png">

- 사원테이블에서 매니저가 관리하는 사원이 2명 이상인 매니저의 매니저 번호, 관리 사원 수, 평균 연봉, 최고 연봉과 최저 연봉의 차를 조회

```sql
SELECT mgr, COUNT(empno) , TRUNC(AVG(sal)) , MAX(sal) - MIN(sal)
FROM emp
GROUP BY mgr
HAVING COUNT(mgr) >= 2;
```

<img src = "https://user-images.githubusercontent.com/69107255/102611640-a5487b00-4172-11eb-9ace-9ae905244682.png">


- 사원 테이블에서 부서번호, 부서별 사원수, 연봉 합, 전체연봉 합 조회

```sql
SELECT deptno, COUNT(empno), SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno); /*합산 결과를 나중에 출력*/
```

<img src = "https://user-images.githubusercontent.com/69107255/102611683-c1e4b300-4172-11eb-9057-833f9c7ea91b.png">

##  CUBE : 합산 결과를 먼저 출력
- 사원 테이블에서 부서번호, 부서별 사원수, 연봉 합, 전체연봉 합 조회
```sql
SELECT deptno, COUNT(empno), SUM(sal)
FROM emp
GROUP BY CUBE(deptno);
```

- 여러컬럼이 그룹으로 묶이면 그룹별 결과, 중간결과, 총합결과를 출력한다. 
- 부서에 해당하는 직무별 직무, 사원수를 조회

```sql
SELECT deptno, job, count(job)
FROM   emp
GROUP BY CUBE(deptno, job);
--GROUP BY ROLLUP(deptno,job);
```

<img src = "https://user-images.githubusercontent.com/69107255/102611837-0ec88980-4173-11eb-91dd-bc0054eace05.png">