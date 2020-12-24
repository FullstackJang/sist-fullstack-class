-------------------------- VIEW ----------------------------
-- 권한 부여
GRANT CREATE VIEW TO scott;

SELECT *
FROM dba_sys_privs
WHERE grantee = 'SCOTT';

-- 권한부여된 계정만 뷰를 만들 수 있다.
CREATE OR REPLACE VIEW v_cp_emp AS ( SELECT * FROM (cp_emp4));

-- 뷰 조회
SELECT * FROM user_views;
SELECT * FROM user_objects; /*전제 조회*/


-- 원본 테이블로 조회
SELECT * FROM cp_emp4;

-- view를 사용한 조회
SELECT * FROM V_CP_EMP;

-- view DML
-- 추가
INSERT INTO v_cp_emp(empno,ename) VALUES (1111,'류수정');

-- 수정
UPDATE v_cp_emp
SET job = '사원', mgr = 1234
WHERE empno = 1111;

-- 삭제
DELETE FROM v_cp_emp
where ename = '류수정';

-- 실제테이블에 DML
INSERT INTO cp_emp4(empno,ename) VALUES (2222,'김민지');

-- VIEW의 삭제
DROP VIEW v_cp_emp;

SELECT * FROM user_views;

-- 복합 뷰
CREATE TABLE cp_dept as (SELECT * FROM DEPT);
CREATE TABLE cp_emp as (SELECT * FROM emp);

CREATE VIEW v_dept AS
( SELECT d.deptno, d.dname, d.loc, e.empno, e.ename, e.job, e.hiredate
	FROM dept d, emp e
	WHERE e.deptno(+) = d.deptno);

-- view를 사용하면 조인하지않아도 서로다른 테이블의 레코드를 얻을 수 있다.
SELECT deptno, dname, loc, empno, INITCAP(ename), job, hiredate
FROM v_dept
WHERE deptno = 10;

-- DML
-- insert Error
-- ORA-01779: 키-보존된것이 아닌 테이블로 대응한 열을 수정할 수 없습니다
INSERT INTO v_dept(deptno, dname, loc, empno, ename, job, hiredate)
		VALUES(50,'개발부','서울',1111,'류수정','사원',sysdate);

-- UPDATE Error
UPDATE v_dept
SET dname = '운영'
WHERE deptno = 40;


-- DELETE도 Error



-- View의 변경
CREATE OR REPLACE VIEW v_dept AS
( SELECT d.deptno, d.dname, d.loc, e.empno, e.ename
	FROM dept d, emp e
	WHERE e.deptno(+) = d.deptno);
, LOC, ENAME
SELECT * FROM cp_dept;
SELECT * FROM cp_emp;


-- View를 삭제
DROP VIEW v_dept;
