-- 배기량(CC)이 2000 이상인 차량의 모델명, 년식, 가격, 배기량,입력일을 조회
-- 단, 출력은 가장 마지막에 입고된 다음 차량부터 7건의 차량만 출력하세요.

SELECT r, model, car_year, price, cc, hiredate
FROM (SELECT ROWNUM r, model,car_year,price,cc, hiredate
FROM (SELECT model,car_year,price,cc,hiredate
FROM car_model
where cc >= 2000
ORDER BY hiredate desc))
WHERE r BETWEEN 1 and 7;

select * from car_model;

------------------------------------ UNION ------------------------------------
-- cp_cmp1(한국본사), emp(미국지사)
-- 본사 사원정보와 지사사원 정보를  조회 //만약 정보를 모두 조회하라면 (UINON ALL)
-- 조회 컬럼은 사원번호, 사원명, 연봉, 부서번호

SELECT empno, ename, sal, deptno
FROM cp_emp1
UNION all
SELECT empno, ename, sal, deptno
FROM emp;

-- 본사 사원정보와 지사사원 정보를  조회
-- 단, 본사 사원정보는 10번 부서 사원만, 지사사원 정보는 20번 부서 사원만 조회
-- 조회 컬럼은 사원번호, 사원명, 연봉, 부서번호

SELECT empno, ename, sal, deptno
FROM cp_emp1
WHERE deptno = 10
UNION all
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno = 20;

------------------- UNION --- 컬럼의 갯수가 일치하지 않으면 Error

SELECT empno, ename, sal, deptno
FROM cp_emp1
UNION all
SELECT empno, ename, sal
FROM emp;

------------------- UNION --- 컬럼의 데이터형이 일치하지 않으면 Error

SELECT empno, ename, sal, deptno
FROM cp_emp1
UNION all
SELECT empno, sal, ename, deptno
FROM emp;

-- 컬럼의 갯수와 데이터형만 일치하면 Error가 발생하지 않는다.
SELECT empno, ename, sal, deptno
FROM cp_emp1
UNION all
SELECT mgr, job, comm, empno
FROM emp;

-- 본사 사원정보와 지사사원 정보를  조회
-- 단, 본사, 지사사원의 10번 부서 사원만 조회
-- 조회 컬럼은 번호, 사원번호, 사원명, 연봉, 부서번호

SELECT ROWNUM, empno, ename, sal,deptno
FROM (SELECT  empno, sal, ename, deptno
FROM cp_emp1
UNION all
SELECT empno, sal, ename, deptno
FROM emp)
where deptno = 10;
