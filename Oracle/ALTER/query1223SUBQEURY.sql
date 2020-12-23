-- EXISTS()

-- 사원테이블에서 사원명이 'SCOTT'인 사원이 존재할 때 사원테이블을 조회하세요
-- 사원번호, 사원명, 입사일, 연봉, 부서번호 조회
-- (SCOTT 이라는 사원이 존재할 때 모든 사원정보가 조회되어져야함)
-- 조회 결과가 있다면 실행해줘

SELECT empno, ename, hiredate, sal, deptno
FROM  emp
WHERE EXISTS(SELECT * FROM emp where ename = 'SCOTT1'); /*조건이 true*/

-------------------- 부서별 직무 연봉을 정산 ----------------
-------부서번호(NUMBER(2)), 직무(VARCHAR2(9),연봉합(NUMBER), 입력일(DATE)을 저장하는 테이블 생성

CREATE TABLE dept_account(

		deptno NUMBER(2),
		job VARCHAR2(9),
		sal_total NUMBER,
		input_date date

);

-- 위에 생성된 테이블에 '30'번 부서이면서 '1981'에 입사한 사원들의
-- 직무, 연봉합, 조회시점의 날짜로 추가.
-- 1981년에 입사한 사원이 존재한다면 정산작업을 수행하고
-- 그렇지 않다면 정산작업을 수행하지 않는다.
INSERT INTO dept_account(deptno, job, sal_total, input_date)
(
	SELECT deptno, job, sum(sal), sysdate
	FROM emp
	WHERE EXISTS( SELECT empno FROM emp WHERE to_char(hiredate,'yyyy')='1983')
	 and deptno = 30 AND TO_CHAR(hiredate,'yyyy') = '1981'
	GROUP BY deptno, job
);

select * from dept_account;
