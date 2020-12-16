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