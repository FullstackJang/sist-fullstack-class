-------------------------- VIEW ----------------------------
-- ���� �ο�
GRANT CREATE VIEW TO scott;

SELECT *
FROM dba_sys_privs
WHERE grantee = 'SCOTT';

-- ���Ѻο��� ������ �並 ���� �� �ִ�.
CREATE OR REPLACE VIEW v_cp_emp AS ( SELECT * FROM (cp_emp4));

-- �� ��ȸ
SELECT * FROM user_views;
SELECT * FROM user_objects; /*���� ��ȸ*/


-- ���� ���̺�� ��ȸ
SELECT * FROM cp_emp4;

-- view�� ����� ��ȸ
SELECT * FROM V_CP_EMP;

-- view DML
-- �߰�
INSERT INTO v_cp_emp(empno,ename) VALUES (1111,'������');

-- ����
UPDATE v_cp_emp
SET job = '���', mgr = 1234
WHERE empno = 1111;

-- ����
DELETE FROM v_cp_emp
where ename = '������';

-- �������̺� DML
INSERT INTO cp_emp4(empno,ename) VALUES (2222,'�����');

-- VIEW�� ����
DROP VIEW v_cp_emp;

SELECT * FROM user_views;

-- ���� ��
CREATE TABLE cp_dept as (SELECT * FROM DEPT);
CREATE TABLE cp_emp as (SELECT * FROM emp);

CREATE VIEW v_dept AS
( SELECT d.deptno, d.dname, d.loc, e.empno, e.ename, e.job, e.hiredate
	FROM dept d, emp e
	WHERE e.deptno(+) = d.deptno);

-- view�� ����ϸ� ���������ʾƵ� ���δٸ� ���̺��� ���ڵ带 ���� �� �ִ�.
SELECT deptno, dname, loc, empno, INITCAP(ename), job, hiredate
FROM v_dept
WHERE deptno = 10;

-- DML
-- insert Error
-- ORA-01779: Ű-�����Ȱ��� �ƴ� ���̺�� ������ ���� ������ �� �����ϴ�
INSERT INTO v_dept(deptno, dname, loc, empno, ename, job, hiredate)
		VALUES(50,'���ߺ�','����',1111,'������','���',sysdate);

-- UPDATE Error
UPDATE v_dept
SET dname = '�'
WHERE deptno = 40;


-- DELETE�� Error



-- View�� ����
CREATE OR REPLACE VIEW v_dept AS
( SELECT d.deptno, d.dname, d.loc, e.empno, e.ename
	FROM dept d, emp e
	WHERE e.deptno(+) = d.deptno);
, LOC, ENAME
SELECT * FROM cp_dept;
SELECT * FROM cp_emp;


-- View�� ����
DROP VIEW v_dept;
