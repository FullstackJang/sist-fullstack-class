- 사원 테이블에서 '10번부서'에 근무하는 사원의 `사원번호`, `직무`, `사원명`, `연봉 조회`,`부서번호 조회`

```sql
SELECT empno, job,ename, sal
FROM emp
WHERE deptno = 10;
```

<img src = "https://user-images.githubusercontent.com/69107255/102306794-6960ba80-3fa6-11eb-87b7-e3199a200e3f.png">

---
- 사원 테이블에서 직무가 'SALESMAN'인 사원의 사원명, 사원번호, 입사일, 연봉 보너스,직무를 조회해라

```sql
SELECT * FROM emp;

SELECT ename, empno, hiredate, sal, comm, job
FROM emp
WHERE job='SALESMAN'; /*값은 대소문자를 구분한다.*/
```

<img src = "https://user-images.githubusercontent.com/69107255/102306857-92814b00-3fa6-11eb-8619-53e757912b9f.png">

---

- 사원테이블에서 부서번호가 10, 20번인 사원들의 사원번호, 사원명,부서번호,연봉,입사일 조회

```sql
SELECT empno, ename, deptno, sal, hiredate
FROM emp
WHERE deptno = 10 or deptno=20;
```

<img src = "https://user-images.githubusercontent.com/69107255/102306904-b04eb000-3fa6-11eb-9b2a-58c5dc21ddf8.png">

- 사원테이블에서 보너스를 수령하지 않는 사원들의 사원번호, 사원명,연봉, 보너스, 부서번호를 조회 (null은 관계연산자로 비교할 수 없다.)

```sql
    SELECT  empno, ename, sal, comm, deptno
    FROM emp
    WHERE comm is null;
```

<img src ="https://user-images.githubusercontent.com/69107255/102354497-ff6c0380-3fed-11eb-924e-69c7251c00dc.png">



- 사원테이블에서 연봉이 1000 ~ 3000 사이(범위)인 사원의 사원번호, 사원명,부서번호, 연봉, 입사일을 조회 between을 사용 ( 컬럼명 between 적은값 and 큰값)

```sql
SELECT empno, ename, deptno, sal, hiredate
FROM emp
WHERE sal between 1000 and 3000;
--WHERE sal >= 1000 and sal <= 3000;
```

<img src = "https://user-images.githubusercontent.com/69107255/102356270-596dc880-3ff0-11eb-8d0e-cb57d4aeeb4e.png">

- 사원테이블에서 '7902, 7698, 7566' 매니저가 관리하는 사원의 사원번호, 사원명, 매니저 번호, 부서번호를 조회 ( or를 여러개 사용해야하는 상황) 
    -  in (값,,,,)   - 포함하는 값을 조회할 때 사용 : 컬럼명 in (값,,,)
    - not in - 포함하지 않는

```sql
SELECT  empno, ename, mgr, deptno
FROM emp
WHERE mgr in (7902,7698,7566);
-- WHERE mgr not in (7902,7698,7566); /* not in은 포함하지 않는 */
-- WHERE mgr = 7902 or mgr = 7698 or mgr = 7566;
```

<img src = "https://user-images.githubusercontent.com/69107255/102356335-6be80200-3ff0-11eb-9ff0-53b0b22bcf7e.png">

- 사원 테이블에서 직무가 'CLERK'이 아닌 사원의 사원번호, 사원명, 직무, 연봉입사일 조회 같지 않음을 조회 할 때에는 !=, <>

```sql
SELECT empno, ename, job, sal, hiredate
FROM emp
--WHERE job != 'CLERK';
WHERE job <> 'CLERK';
```

<img src = "https://user-images.githubusercontent.com/69107255/102356404-7efad200-3ff0-11eb-88be-76bc8f272db7.png">

---

-- ========================산술연산자

- alias : 컬럼의 별명
- 너무 짧게 줄이면 가독성이 떨어짐 컬럼이름이 무슨 의미인지 알수 없다.

```sql
SELECT empno e_no, ename as en,hiredate h
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102357405-9d150200-3ff1-11eb-8797-e66cdc8e8041.png">

- alias는 선언된 select의 where절에서는 사용할 수 없다.

```sql
select empno, ename, sal s
from emp
--WHERE  s >= 1200; /*alias를 where에서 사용하면 에러가 난다*/
WHERE sal >= 1200;
```

<img src = "https://user-images.githubusercontent.com/69107255/102358399-ce420200-3ff2-11eb-9d62-e247f97de1eb.png">

- 사원테이블에서 모든 사원의 사원번호, 사원명, 부서번호, 연봉, 세금을 조회
    - 단, 세금은 연봉에 3.3%로 연산하여 출력

```sql
SELECT empno, ename, deptno, sal, sal * 0.0033 tax
FROM  emp;
```

- null은 연산되면 결과가 null로 나온다.(nvl 함수를 사용)
- 사원테이블에서 모든 사원의 사원번호, 사원명, 연봉, 보너스, 총 수령액을 조회
    - 단, 총 수령액은 연봉과 보너스를 합산한 금액으로 연산하고,
    - 컬럼명을 total_sal로 설정하여 조회

```sql
SELECT empno, ename, sal, comm, sal + comm total_sal
FROM emp;
```
<img src ="https://user-images.githubusercontent.com/69107255/102358492-e87be000-3ff2-11eb-97b8-0997aa3e7ac3.png">

- 사원 테이블에서 사원번호, 사원명, 연봉, 월급을 조회
    - 단, 월급은 연봉을 12로 나눈 연산결과를 출력

```sql
SELECT  empno, ename, sal, sal/12 month_sal
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102358578-08130880-3ff3-11eb-9032-29c9a2fbec8e.png">


- alias를 부여하여 '대소문자를 구분된' 컬렴명 생성
    - alias "(쌍따옴표)로 묶어서 부여

```sql
SELECT ename "Ename", sal "Sal"
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102358669-1e20c900-3ff3-11eb-8238-94ce3825db6f.png">

- 산술연산자가 아닌 연산자는 조회하는 컬럼에 사용할 수 없다.(Error)

```sql
SELECT ename, sal > 1000
FROM emp;

select * from emp;
```