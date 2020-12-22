---------------------------- OUTER JOIN ----------------------------

-- 모든 부서에 근무하는 사원 정보 조회(사원이 없더라도 부서정보는 조회)

-- ANSI : LEFT, RIGHT, FULL - 레코드가 존재하는 테이블
SELECT d.deptno, d.dname, d.loc, e.empno, e.ename, e.job, e.hiredate
FROM emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- Oracle : (+) - 레코드가 존재하지 않는 테이블
SELECT  d.deptno, d.dname, d.loc, e.empno, e.ename, e.job, e.hiredate
FROM    dept d, emp e
WHERE e.deptno(+) = d.deptno;

-- 제조사가 '현대, 기아'인 모든 차량의 제조사, 모델명, 가격,년식 조회


select * from CAR_COUNTRY;
select * from CAR_MAKER;
select * from CAR_MODEL;

-- ANSI
SELECT cma.maker, cma.model, cmo.price, cmo.car_year
FROM car_maker cma LEFT JOIN car_model cmo
ON cmo.model = cma.model
WHERE cma.maker in ('현대','기아');


-- Oracle
SELECT cma.maker, cma.model, cmo.price, cmo.car_year
FROM  car_model cmo,car_maker cma
WHERE (cmo.model(+) = cma.model ) and cma.maker in ('현대','기아');

select * from dept;
select * from emp;
SELECT * FROM ZIPCODE;

-- 모든 부서에 근무하는 사원들의 사원번호,
-- 사원명, 연봉, 부서번호, 부서명, 위치,연봉, 우편번호,시도, 구군, 동 번지 조회
-- 사원테이블과 우편번호 테이블은  사원번호와 seq로 조인 조건을 설정

SELECT d.deptno, d.dname,  d.loc, e.empno, e.ename, e.sal, z.zipcode, z.sido, z.gugun, z.dong, z.bunji
FROM  dept d, emp e , zipcode z
WHERE (e.deptno(+) = d.deptno and  z.seq(+) = d.deptno);

select * from emp;

-- 사원테이블에서 사원명이 'ALLEN'인 사원보다 연봉을 많이 받는 사원의
-- 사원번호,사원명, 입사일, 연봉, 직무 조회

-- subquery
SELECT empno, ename, hiredate, sal, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'ALLEN');

-- SELF JOIN
SELECT e1.empno, e1.ename, e1.hiredate, e1.sal, e1.job
FROM 		emp e1, emp e2
WHERE		(e1.sal > e2.sal) and e2.ename = 'ALLEN';




