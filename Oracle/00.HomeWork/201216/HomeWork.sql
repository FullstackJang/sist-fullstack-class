--1
SELECT empno, ename, hiredate, sal
FROM  emp
WHERE sal between 1301 and 2999;


--2

SELECT empno, job, ename, sal, sal/12 MONTH_SAL, sal/12 - ((sal/12)*0.033) after_tax
FROM emp
WHERE  job='CLERK' or job = 'SALESMAN' or job = 'ANALYST';

--3
SELECT empno, ename, deptno, sal, job, hiredate
FROM emp
WHERE (sal between 2000 and 3000) and deptno not in 10;

--4
SELECT	empno, ename, sal, job, deptno, hiredate
FROM   emp
WHERE (ename like '%A%' or ename like '%S%') and sal > 1200;

--5
SELECT '[' || empno || ']님' || hiredate || '에 입사하셨으며 현재 연봉 ' || sal || '입니다.' "Output"
FROM  emp
WHERE mgr is not null;

--6
SELECT empno, ename, job, sal, comm, deptno
FROM emp
WHERE mgr not in(7698,7566,7902);

--7
SELECT empno, ename, job, sal*(1+0.1/1.0) "Next_Years_Salary"
FROM emp;

select * from emp;
