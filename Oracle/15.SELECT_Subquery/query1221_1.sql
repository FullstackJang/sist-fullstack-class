-- SELECT 단수행 서브쿼리

-- 사원테이블에서 평균연봉을 초과 하는 사원의 사원번호, 사원명, 입사일, 연봉을 조회하세요
SELECT  empno, ename, hiredate, sal
FROM emp
where sal > (SELECT TRUNC(AVG(sal)) FROM emp);


-- cp_emp3테이블에서 사원번호가 1111번인 사원의 부서번호와 같은 부서번호를 가진
-- 사원을 emp테이블에서 조회. 조회컬럼은 부서번호, 사원번호, 사원명, 입사일, 연봉

select * from cp_emp3;
select * from emp;

SELECT deptno, empno, ename, hiredate, sal
FROM emp
where deptno = (SELECT deptno FROM cp_emp3 WHERE empno = 1111);

-- scalar subquery(단수행 subquery) : 조회하는 컬럼명에 사용
-- 안쪽 쿼리의 컬럼명과 바깥 쿼리의 컬럼명이 같다면 '테이블명.컬럼명"의
-- 문법으로 컬럼을 식별하여 사용

-- 사원번호,사원명, 부서번호, 부서명을 조회
SELECT empno, ename, deptno, (SELECT dname FROM dept WHERE dept.deptno = emp.deptno) dname
FROM emp;

select *
from dept;


-- 사원 테이블에서 최고연봉, 최고연봉을 수령하는 사람명을 조회
SELECT ename, (SELECT MAX(sal) FROM emp)
FROM emp
WHERE sal = (SELECT  MAX(sal)
FROM emp);

--------------------------복수행 subquery : 조회결과를 가지고 재조회
select empno, ename, sal, hiredate
from (SELECT ename, empno, sal, hiredate
FROM emp);

-- 안쪽 쿼리에서 컬럼명에 alias가 부여되면 바깥 쿼리에서는 alias로만 사용가능
select empno, ename, sal, h /*안쪽 인라인뷰에 hiredate가 없기때문에 바깥쪽에서는 h로 사용해야한다.*/
from (SELECT ename, empno, sal, hiredate h
FROM emp);

-- 안쪽쿼리에서 조회한 컬럼명만 사용할 수 있다.
select empno, ename, sal, hiredate, comm
from (SELECT ename, empno, sal, hiredate  /*안쪽 쿼리문에서 조회된것만 바깥 쿼리문에서 사용가능*/
FROM emp);

-- 사원테이블에서 가장 마지막에 입사한 사원부터 5명의 사원정보 조회
-- 가장마지막에 입사한 사원부터 번호를 순차적으로 붙여준다.)
-- 사원번호,사원명,입사일
SELECT rownum , empno, ename, hiredate
FROM (SELECT empno, ename, hiredate
FROM emp
ORDER BY hiredate DESC)
WHERE ROWNUM BETWEEN 1 AND 5;


-- 사원테이블에서 가장 마지막에 입사한 2 전 사원부터 5명(2번째~6번째)의 사원정보 조회
-- 가장마지막에 입사한 사원부터 번호를 순차적으로 붙여준다.)
-- 사원번호,사원명,입사일

SELECT rnum, empno, ename, hiredate
FROM (SELECT  ROWNUM rnum , empno, ename, hiredate
FROM 	(SELECT empno, ename, hiredate
			 FROM emp
			 ORDER BY hiredate DESC))
WHERE rnum between 2 and 6;


------------------------------- 가상 번호 -------------------------------
-- 사원테이블에서 번호, 사원번호, 사원명을 조회
-- 번호는 조회되는 컬럼의 순서대로 1번 부터 부여한다.
SELECT ROWNUM, empno, ename
FROM emp;


--ROWNUM은 ORDER BY보다 먼저 생성된다.
-- 사원테이블에서 번호, 사원번호, 사원명을 조회
-- 단, 사원명의 오름차순으로 정렬하여 조회
SELECT ROWNUM, empno, ename
FROM emp
ORDER BY ename asc; /*ROWNUM은 ORDER BY보다 먼저 생성된다.*/


-- where절에서 사용하면 1번부터는 비교가 되나, 1번 이후에는 비교가 되지 않는다.
-- 사원테이블에서 번호,사원번호, 사원명을 조회
-- 단, 번호는 12~7번까지의 사원만 출력
SELECT ROWNUM, empno, ename
FROM emp
WHERE ROWNUM between 1 and 7;
--WHERE ROWNUM between 2 and 7; /*2번부터 시작하면 조회가 되지 않는다.*/
--WHERE ROWNUM >= 1 and ROWNUM <= 7 ;
--WHERE ROWNUM >= 2 and ROWNUM <= 7 ; /*2번부터 시작하면 조회가 되지 않는다.*/


-- ROWNUM은 SELECT마다 생성되고 사용된다.
-- 안쪽 Subquery에서 ROWNUM을 조회하지 않아도 바깥 SELECT에서 ROWNUM을 사용할 수 있다.
-- 안쪽에 ROWNUM을 바깥쪽에서 사용하려면 ALIAS를 붙여서 사용해야한다.
SELECT rnum, en, empno, ename, job
FROM (SELECT ROWNUM rnum,empno en,ename, empno ,job FROM emp order by ename);

