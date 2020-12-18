-------------------- subquery -----------------------

-- create subquery
-- ���̺� ������ ��������� user_constraints data dictionary���� Ȯ�� ����

select * from user_constraints;

-- emp���̺��� �����ȣ, �����, ����, �μ���ȣ�� ��ȸ�� �����  cp_emp1���̺��� �����ض�

CREATE TABLE cp_emp1 AS
(SELECT empno, ename, sal, deptno
FROM emp);

select * from CP_EMP1;



-- alter table emp modify job varchar2(9);
alter table emp drop constraints SYS_C007597;

-- emp���̺��� �����ȣ,�����, ����(not null), ����, ���ʽ�, �Ի���,
-- �μ���ȣ�� ��ȸ�� ����� cp_emp2���̺��� �����ض�

-- �����̸Ӹ�Ű�� ����Ű�� ���簡 �ȵ����� null ��������� ���簡 �ȴ�.
CREATE TABLE cp_emp2 AS(

SELECT empno, ename, job, sal, comm, hiredate FROM emp
);

SELECT * from user_constraints;


-- ��� ���̺��� �����ȣ, �����, �Ի���, �μ���ȣ, ����, ������
-- ���ڵ尡 ��ȸ���� �ʵ��� ��ȸ�Ͽ� cp_emp3���̺���� (������ ����)

-- WHERE 1 = 1�� ��� ���ڵ带 �˻��ϴ� ��
-- dynamic query(�������� ��Ȳ�� ���� ����Ǿ� ��������� ����Ǵ� ��)
-- dynamic query���� �˻������� �ս��� ���̱� ���� �ο��ϴ� ����
CREATE TABLE cp_emp3 AS
(SELECT empno, ename, hiredate, deptno, job, sal
FROM emp
WHERE 1=0);


-- ������̺��� �Ի�⵵�� 1981���� ������� �����ȣ,�����,
-- ����, �Ŵ�����ȣ, ����, �Ի���, �μ���ȣ�� ��ȸ�Ͽ�
-- cp_emp4 ���̺��� �����ض�

CREATE TABLE cp_emp4 AS
(SELECT empno, ename, job, mgr, sal, hiredate, deptno
FROM emp
WHERE TO_CHAR(hiredate,'yyyy') = '1981'); /*TO_CHAR�Ծ��� ��¥�� ���ڷ� ������ �ֱ� ������  '1981'�� Ȧ����ǥ ��*/



------------------- Insert Subquery ---------------------
-- �ܼ��� subquery
-- cp_emp3���̺� �Ʒ��� ���� ���ڵ带 �߰�
-- �����ȣ : 1111, ����� : ������, �Ի��� : ����, �μ���ȣ : 10
-- ���� : ���, ���� : emp���̺� �����ȣ�� 7788�� ������ ������ �������� �߰�

INSERT INTO cp_emp3(empno, ename , hiredate, deptno, job, sal)
VALUES(1111,'������',SYSDATE, 10, '���', (SELECT sal FROM emp WHERE empno=7788) );
COMMIT;

select * from cp_emp3;

-- �����ȣ : 1112, ����� : ������, �Ի��� : ��������, �μ���ȣ : 10
-- ���� : emp���̺� ������� 'SCOTT'�� ����� ������ ����, ���� : emp���̺� �����ȣ�� 7566�� ������ ������ �������� �߰�

INSERT INTO cp_emp3(empno, ename, hiredate, deptno, job, sal)
VALUES(1112, '������', LAST_DAY(SYSDATE), 10, (SELECT job FROM emp WHERE ename ='SCOTT'), (SELECT sal FROM emp WHERE empno=7566 ));
COMMIT;
															

-------- ������ �������� ----------
-- emp���̺��� 20���� ������� �����ȣ,�����, �Ի���, �μ���ȣ, ����, ����
-- �� ��ȸ�Ͽ� cp_emp3���̺� �߰��ϼ���.

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

-- ������̺��� �Ի�⵵�� 1981���̸鼭, ������ 'SALESMAN'��
-- ��� ����� �ջ� ������ insert_sub���̺� total_sal�÷��� �߰�
-- job = 'SALESMAN', INPUT_DATE= ���� �Ϸ� �߰�

-- �ܼ���
INSERT INTO insert_sub(job, total_sal, input_date)
VALUES('SALESMAN',
(
SELECT SUM(sal)
FROM emp
WHERE TO_CHAR(hiredate,'yyyy') ='1981' and job = 'SALESMAN'),SYSDATE);


-- 1981�⿡ �Ի��� ������, �������� insert_sub���̺� ���� ��¥�� �߰�.

INSERT INTO insert_sub(job, total_sal, input_date)
(SELECT job,sum(sal), sysdate
FROM 	emp
WHERE	TO_CHAR(hiredate,'yyyy')='1981'
GROUP BY  job;


select * from insert_sub;
