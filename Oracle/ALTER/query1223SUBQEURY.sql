-- EXISTS()

-- ������̺��� ������� 'SCOTT'�� ����� ������ �� ������̺��� ��ȸ�ϼ���
-- �����ȣ, �����, �Ի���, ����, �μ���ȣ ��ȸ
-- (SCOTT �̶�� ����� ������ �� ��� ��������� ��ȸ�Ǿ�������)
-- ��ȸ ����� �ִٸ� ��������

SELECT empno, ename, hiredate, sal, deptno
FROM  emp
WHERE EXISTS(SELECT * FROM emp where ename = 'SCOTT1'); /*������ true*/

-------------------- �μ��� ���� ������ ���� ----------------
-------�μ���ȣ(NUMBER(2)), ����(VARCHAR2(9),������(NUMBER), �Է���(DATE)�� �����ϴ� ���̺� ����

CREATE TABLE dept_account(

		deptno NUMBER(2),
		job VARCHAR2(9),
		sal_total NUMBER,
		input_date date

);

-- ���� ������ ���̺� '30'�� �μ��̸鼭 '1981'�� �Ի��� �������
-- ����, ������, ��ȸ������ ��¥�� �߰�.
-- 1981�⿡ �Ի��� ����� �����Ѵٸ� �����۾��� �����ϰ�
-- �׷��� �ʴٸ� �����۾��� �������� �ʴ´�.
INSERT INTO dept_account(deptno, job, sal_total, input_date)
(
	SELECT deptno, job, sum(sal), sysdate
	FROM emp
	WHERE EXISTS( SELECT empno FROM emp WHERE to_char(hiredate,'yyyy')='1983')
	 and deptno = 30 AND TO_CHAR(hiredate,'yyyy') = '1981'
	GROUP BY deptno, job
);

select * from dept_account;
