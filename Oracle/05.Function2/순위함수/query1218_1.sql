-------------------------- RANK 함수 : 순위를 부여할 때 -------------------

--ORDER BY절을 함께 사용하지 않는다.

-- 사원테이블에서 사원번호, 사원명, 연봉, 연봉의 순서를 조회하세요

-- 조회되는 레코드에 공동 등수를 확인 할 때
SELECT empno, ename, sal, RANK() OVER(ORDER BY sal desc)
FROM emp;


-- 조회되는 레코드에 공동 등수를 확인하고 싶지 않을 때
SELECT empno, ename, sal, ROW_NUMBER() OVER(ORDER BY sal desc)
FROM emp;


SELECT ename, rank() OVER(ORDER BY ename)
FROM emp;


-- PARTION BY 사용
-- 사원테이블에서 부서번호, 부서별 연봉 순위, 연봉, 사원명을 조회

SELECT deptno, ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal desc) rank, sal, ename
FROM emp;
--WHERE deptno = 30 특정 부서에 대해서만 알 수도 있다.

-- 사원테이블에서 직무, 직무별 연봉순위, 연봉, 사원명 조회
-- 단, 같은 연봉이 존재한다면 같은 순위를 가진다.
SELECT job, RANK() OVER(PARTITION BY job ORDER BY sal) rank, sal, ename
FROM emp;
