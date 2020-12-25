-------------------- subquery -----------------------

-- create subquery
-- 테이블에 설정된 제약사항은 user_constraints data dictionary에서 확인 가능

select * from user_constraints;

-- emp테이블에서 사원번호, 사원명, 연봉, 부서번호를 조회한 결과로  cp_emp1테이블을 생성해라

CREATE TABLE cp_emp1 AS
(SELECT empno, ename, sal, deptno
FROM emp);

select * from CP_EMP1;



-- alter table emp modify job varchar2(9);
alter table emp drop constraints SYS_C007597;

-- emp테이블에서 사원번호,사원명, 직무(not null), 연봉, 보너스, 입사일,
-- 부서번호를 조회한 결과로 cp_emp2테이블을 생성해라

-- 프라이머리키와 포린키는 복사가 안되지만 null 제약사항은 복사가 된다.
CREATE TABLE cp_emp2 AS(

SELECT empno, ename, job, sal, comm, hiredate FROM emp
);

SELECT * from user_constraints;


-- 사원 테이블에서 사원번호, 사원명, 입사일, 부서번호, 직무, 연봉을
-- 레코드가 조회되지 않도록 조회하여 cp_emp3테이블생성 (구조만 복사)

-- WHERE 1 = 1은 모든 레코드를 검색하는 것
-- dynamic query(쿼리문이 상황에 따라 변경되어 만들어지고 실행되는 것)
-- dynamic query에서 검색조건을 손쉽게 붙이기 위해 부여하는 조건
CREATE TABLE cp_emp3 AS
(SELECT empno, ename, hiredate, deptno, job, sal
FROM emp
WHERE 1=0);


-- 사원테이블에서 입사년도가 1981년인 사원들의 사원번호,사원명,
-- 직무, 매니저번호, 연봉, 입사일, 부서번호를 조회하여
-- cp_emp4 테이블을 생성해라

CREATE TABLE cp_emp4 AS
(SELECT empno, ename, job, mgr, sal, hiredate, deptno
FROM emp
WHERE TO_CHAR(hiredate,'yyyy') = '1981'); /*TO_CHAR함쑤가 날짜를 문자로 내보내 주기 때문에  '1981'을 홀따옴표 함*/



------------------- Insert Subquery ---------------------
-- 단수행 subquery
-- cp_emp3테이블에 아래와 같은 레코드를 추가
-- 사원번호 : 1111, 사원명 : 류수정, 입사일 : 오늘, 부서번호 : 10
-- 직무 : 사원, 연봉 : emp테이블에 사원번호가 7788인 연봉과 동일한 연봉으로 추가

INSERT INTO cp_emp3(empno, ename , hiredate, deptno, job, sal)
VALUES(1111,'류수정',SYSDATE, 10, '사원', (SELECT sal FROM emp WHERE empno=7788) );
COMMIT;

select * from cp_emp3;

-- 사원번호 : 1112, 사원명 : 김지원, 입사일 : 마지막날, 부서번호 : 10
-- 직무 : emp테이블에 사원명이 'SCOTT'인 사원과 동일한 직무, 연봉 : emp테이블에 사원번호가 7566인 연봉과 동일한 연봉으로 추가

INSERT INTO cp_emp3(empno, ename, hiredate, deptno, job, sal)
VALUES(1112, '김지원', LAST_DAY(SYSDATE), 10, (SELECT job FROM emp WHERE ename ='SCOTT'), (SELECT sal FROM emp WHERE empno=7566 ));
COMMIT;
															

-------- 복수행 서브쿼리 ----------
-- emp테이블에서 20번부 사원들의 사원번호,사원명, 입사일, 부서번호, 직무, 연봉
-- 을 조회하여 cp_emp3테이블에 추가하세요.

--INSERT INTO cp_emp(empno, hiredate, deptno, job, sal)

INSERT INTO cp_emp3
(select empno, ename, hiredate, deptno, job, sal
from emp
where deptno = 20);


CREATE TABLE INSERT_SUB(

	job VARCHAR2(9),
	total_sal NUMBER,
	input_date DATE

);

-- 사원테이블에서 입사년도가 1981년이면서, 직무가 'SALESMAN'인
-- 모든 사원의 합산 연봉을 insert_sub테이블 total_sal컬럼에 추가
-- job = 'SALESMAN', INPUT_DATE= 현재 일로 추가

-- 단수행
INSERT INTO insert_sub(job, total_sal, input_date)
VALUES('SALESMAN',
(
SELECT SUM(sal)
FROM emp
WHERE TO_CHAR(hiredate,'yyyy') ='1981' and job = 'SALESMAN'),SYSDATE);


-- 1981년에 입사한 직무별, 연봉합을 insert_sub테이블에 오늘 날짜로 추가.

INSERT INTO insert_sub(job, total_sal, input_date)
(SELECT job,sum(sal), sysdate
FROM 	emp
WHERE	TO_CHAR(hiredate,'yyyy')='1981'
GROUP BY  job;


select * from insert_sub;
