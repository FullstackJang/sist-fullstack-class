- 별도의 테이블이 언급되지 않으면 사원테이블에서 작업을 수행한다.
<img src = "https://user-images.githubusercontent.com/69107255/102350657-8e761d00-3fe8-11eb-987a-82ba54ee6a5f.png">

# 숙제 1.
- 연봉이 1300초과 3000 미만인 모든 사원의 `사원번호`, `사원명`,`입사일`,`연봉`을 `조회`할 것.


```sql
SELECT empno, ename, hiredate, sal
FROM  emp
WHERE sal between 1301 and 2999;
```

<img src = "https://user-images.githubusercontent.com/69107255/102348168-d2672300-3fe4-11eb-9aa2-e5ce1ad0579a.png">

# 숙제 2.
 - 직무가 CLERK, SALESMAN,ANALYST 인 사원의 `사원번호`,`직무`, `사원명`, `연봉`, `월급`, `실수령액`을 조회하세요.
- 단, 월급은 연봉을 12로 나눈 값을 조회하고, 실수령액은 연봉에서 세금 3.3%을 제외한 금액으로조회한다. 

```sql
SELECT empno, job, ename, sal, sal/12 MONTH_SAL, sal/12 - ((sal/12)*0.033) after_tax
FROM emp
WHERE  job='CLERK' or job = 'SALESMAN' or job = 'ANALYST';
```

<img src = "https://user-images.githubusercontent.com/69107255/102351065-2ffd6e80-3fe9-11eb-9821-3d8f499c0fc3.png">

# 숙제 3.
-  연봉이 2000~3000 사이이면서 부서가 10번이 아닌 부서에 근무하는 사원의 사원번호, 사원명,부서번호,연봉, 직무, 입사일을 조회하세요.

```sql
SELECT empno, ename, deptno, sal, job, hiredate
FROM emp
WHERE (sal between 2000 and 3000) and deptno not in 10;
```

<img src = "https://user-images.githubusercontent.com/69107255/102349186-4c4bdc00-3fe6-11eb-8784-516f254b5919.png">

# 숙제4.
- 사원명에 'A'가 있거나, 'S'가 있으면서 연봉을 1200보다 많이 받는 사원의 사원번호, 사원명, 연봉, 직무, 부서번호, 입사일을 조회하세요.

```sql
SELECT	empno, ename, sal, job, deptno, hiredate
FROM   emp
WHERE (ename like '%A%' or ename like '%S%') and sal > 1200;
```

<img src = "https://user-images.githubusercontent.com/69107255/102349432-ac428280-3fe6-11eb-8e6f-224763e53ac2.png">

# 숙제5. 
- 사원 테이블에서 매니저가 있는 사원의 `사원번호`, `사원명`, `연봉`, `입사일` `조회`하여 아래의 형식으로 출력하고 `컬럼명을 대소문자 구분`하여 `Output`으로설정하세요.
    - xxx(사원번호)님 xxx에 입사하셨으며 현재 연봉 xxx원 입니다.      

```sql
SELECT '[' || empno || ']님' || hiredate || '에 입사하셨으며 현재 연봉 ' || sal || '입니다.' "Output"
FROM  emp
WHERE mgr is not null;
```

<img src = "https://user-images.githubusercontent.com/69107255/102351306-8e2a5180-3fe9-11eb-82b4-aa9937169851.png">


# 숙제 6. 
- `사원 테이블`에서 `7698`,`7566`,`7902`, `매니저가 관리하지 않는 사원`의 `사원번호`, `사원명`, `직무`,`연봉`, `보너스` , `부서번호`를 `조회`하세요.

```sql
SELECT empno, ename, job, sal, comm, deptno
FROM emp
WHERE mgr not in(7698,7566,7902);
```

<img src = "https://user-images.githubusercontent.com/69107255/102349768-32f75f80-3fe7-11eb-9239-d6a21215f8b8.png">

# 숙제 7.
- `사원 테이블`에서 `모든 사원`의 `사원번호`, `사원명`, `직무`, `연봉`, `내년 연봉`을 `조회`하세요.
- 단, 내년연봉은 현재연봉보다10% 인상된 금액으로 연산하여 조회할 것.

```sql
SELECT empno, ename, job, sal*(1+0.1/1.0) "Next_Years_Salary"
FROM emp;
SELECT * from emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102350420-3e975600-3fe8-11eb-8f5e-cc4501eb3480.png">