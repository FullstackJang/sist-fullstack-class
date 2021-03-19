/*
����1.
������̺��� �μ���ȣ�� 10, 30�� �μ��� �����  ������ ��ȸ�Ͽ�
��ȸ�Ѱ����  emp_work ���̺��� �����մϴ�.
*/

SELECT empno, ename, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE deptno in (10,30);

CREATE TABLE emp_work(

	empno NUMBER(4),
	ename VARCHAR2(10),
	job		VARCHAR2(9),
	mgr 	NUMBER(4),
	hiredate DATE,
	sal		 NUMBER(7,2),
	comm	 NUMBER(7,2),
	deptno NUMBER(2)
);

INSERT INTO emp_work(empno, ename, job, mgr, hiredate, sal, comm, deptno)
(
		SELECT empno, ename,job, mgr, hiredate, sal, comm, deptno
		FROM emp
		WHERE deptno in (10,30)
);

-- 2-1. ������ ������ ���̺���  empno �÷����� emp_no�� �����մϴ�.
ALTER TABLE emp_work RENAME COLUMN empno TO emp_no;

-- 2-2. ������ ������ ���̺��� ename �÷��� �ѱ� 30�� ���� �Է°����ϵ���
-- �÷��� ���̸� �����մϴ�.
ALTER TABLE emp_work MODIFY ename VARCHAR2(90);


--  2-3. ������ ������ ���̺� ename �÷��� null�� �������� �ʵ��� �����մϴ�.
ALTER TABLE emp_work MODIFY ename NOT NULL;

-- 2-4. ������ ������ ���̺�  empno�÷��� primary key ��������� �����մϴ�.
ALTER TABLE emp_work ADD CONSTRAINT pk_emp_no PRIMARY KEY(emp_no);

--  2-5. ������ ������ ���̺� deptno �÷��� foreign key ��������� �����մϴ�.
				--    (�θ����̺��� dept)
ALTER TABLE emp_work ADD FOREIGN KEY(deptno) REFERENCES dept(deptno);

select * from user_constraints
where table_name = 'EMP_WORK';
-- 2-6. ������ ������ 2-5�� ������ �����ϼ���.
ALTER TABLE emp_work DROP CONSTRAINT SYS_C008933;

-- 2-7. ������ ������ 2-4 �� ������ ��Ȱ��ȭ �ϼ���.
ALTER TABLE emp_work DISABLE CONSTRAINT pk_emp_no;

/*3. �����ڰ������� �α��� �Ͽ�
    ���̵�� ��й�ȣ�� test/test1234�� ������ �����ϰ�
    ���Ӱ����ϵ��� ������ �����ϼ���.*/

-- ALTER session set "_ORACLE_SCRIPT" = TRUE;
-- ���� ����
ALTER session set "_ORACLE_SCRIPT" = TRUE;
CREATE USER test IDENTIFIED BY 1234;

ALTER session set "_ORACLE_SCRIPT" = TRUE;
GRANT CONNECT TO test;

-- 4. ���� ������ ���� �մϴ�.
DROP USER test;

/*5. user_cons_columns ���̺��  user_constraints�� ����Ͽ�
    'EMP'���̺� ������ �÷���, �������Ÿ��(constraint_type), ������׸���
    ��ȸ�ϼ���.
*/


SELECT * FROM  user_cons_columns
WHERE table_name = 'EMP';

SELECT * FROM user_constraints
WHERE table_name = 'EMP';



