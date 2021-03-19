-- || 문자열 붙임 연산자
-- 조회결과를 문자열로 출력할 때. ||는 자바로 치면 문자열을 더하는것과 같다.

-- 사원테이블에서 사원명,사원번호를 조회
-- 단, 출력은 [xxx]사원님 사원번호는 [xxxx] 입니다. 의 형식으로 출력
SELECT '[' || ename || ']사원님 사원번호는 [' || empno || ']입니다.' output
FROM  emp;

-- 사원테이블에서 사원명의 첫 글자가 'A'로 시작하는 사원의 사원명, 사원번호 조회

SELECT  ename,deptno
FROM emp
WHERE ename like 'A%';


-- 사원테이블에서 사원명의 끝 글자가 'S'로 끝나는 사원의 사원명, 사원번호 조회

SELECT ename, empno
FROM emp
where ename like '%S';

-- 사원테이블에서 사원명에 'A'가 들어있는 사원의 사원명, 사원번호 조회

SELECT ename, empno
FROM emp
where ename like '%A%';

-- 사원테이블에서 사원명에 'L'가 두개들어있는 사원의 사원명, 사원번호 조회

SELECT ename, empno
FROM emp
where ename like '%L%L%';


-- 사원테이블에서 사원명이 5글자인 사원에 사원명, 사원번호를 조회
SELECT ename, empno
FROM emp
WHERE ename like '_____';


-- 사원테이블에서 사원명이 5글자 이면서 세번째 문자가 'A'인 사원의 사원명을 조회
SELECT ename, empno
FROM emp
WHERE ename like '__A__';


-- 사원테이블에서 직무를 조회
-- 단, 중복되는 직무는 조회하지 않는다.
SELECT distinct job
FROM emp;

-- 사원테이블에서 부서번호를 조회
-- 단, 중복되는 매니저번호는 조회하지 않는다.
SELECT distinct mgr
FROM emp;

-- distinct는 중복값을 가진 컬럼과 중복값을 가지지않은 컬림이
-- 레코드로 조회되면 중복배제를 하지 않는다.
SELECT  distinct deptno,  mgr
FROM emp;

------group by------------------------------
SELECT 	job
FROM 	emp
GROUP BY 	job ;


SELECT	deptno
FROM    emp
GROUP BY deptno;

-- 그룹으로 묶여지지 않은 컬럼이 조회컬럼에 정의되면 Error
-- 여러행이 조회되는 컬럼과 같이 사용되면 그룹으로 묶여지지 않는다.
SELECT	deptno, ename
FROM	emp
GROUP BY deptno;



