---------------- �����Լ�  -------------------

-- ������̺��� ��� ��� ��, ���ʽ��� �����ϴ� ��� ��
-- ���ʽ��� �������� �ʴ� ��� ��
-- null�� ���迡 �������� �ʴ´�.
SELECT COUNT (empno), COUNT (comm), COUNT(empno) - COUNT (comm)
FROM emp;

-- ������̺��� ������ ��
SELECT SUM(sal)
FROM emp;


-- ������̺��� ������ ���
SELECT TRUNC(AVG(sal))
FROM emp;

-- ������̺��� �ְ� ����
SELECT  MAX(sal)
FROM emp;

-- ������̺��� ���� ����
SELECT MIN(sal)
FROM emp;

-- �����Լ��� �������� ��ȸ�Ǵ� �÷��� �Բ� ���Ǹ� Error
-- ������̺��� �ְ���, �ְ����� ��ȸ
-- ���� ����: �ְ����� 1��, ������� n���� ��ȸ�Ǳ� ������
SELECT MAX(sal), ename /*MAX�� �ϳ��� ���ڵ尡 ������  ename���� 14���� ���ڵ尡 ������ ������ ����*/
FROM emp;


-- �����Լ��� WHERE���� ����� �� ����.
-- ������̺��� ��տ������� ���� �޴� ����� ��� ��ȣ, �����, ����, �Ի����� ��ȸ
SELECT empno, ename, sal, hiredate
FROM emp
WHERE TRUNC(AVG(sal) > sal;

-- �����Լ��� WHERE���� ����� �� ����.
-- ������̺��� �μ��� �ο��� 3�� �̻��� �μ��� ��� ��ȣ, �����, ����, �Ի��� �μ���ȣ ��ȸ
SELECT  empno, ename, sal, hiredate
FROM  emp
WHERE  COUNT(deptno) > 3;


------- �����Լ��� GROUP BY���� ����ϸ� �׷캰 ���踦 ���� �� �ִ�.

-- ������̺��� �μ���ȣ, �μ��� �ο���, �μ��� ���� ��, ��տ���, �μ��� �ְ� ����, �μ��� ���� ���� ��ȸ
SELECT deptno, COUNT(hiredate), SUM(sal), TRUNC(AVG(sal)), MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno;

-- ������̺��� �Ŵ�����ȣ, �Ŵ����� �����ϴ� ��� ��, �ְ� ������ ��ȸ
-- ��, �Ŵ����� �����ϴ� ����� ����غμ���.
SELECT mgr, count(mgr), MAX(sal)
FROM emp
WHERE mgr IS NOT NULL
GROUP BY mgr;


------------------------- HAVING ���� ���
-- ������̺��� ������� 4���̻��� �μ��� �μ���ȣ, �μ��� ��� ��, ���� ��
SELECT deptno, count(empno), sum(sal)
FROM emp
GROUP BY deptno
HAVING COUNT(empno) >= 4;


-- ������̺��� �Ŵ����� �����ϴ� ����� 2�� �̻��� �Ŵ����� �Ŵ��� ��ȣ, ���� ��� ��, ��� ����, �ְ� ������ ���� ������ ���� ��ȸ
SELECT mgr, COUNT(empno) , TRUNC(AVG(sal)) , MAX(sal) - MIN(sal)
FROM emp
GROUP BY mgr
HAVING COUNT(mgr) >= 2;

-- ��� ���̺��� �μ���ȣ, �μ��� �����, ���� ��, ��ü���� �� ��ȸ
SELECT deptno, COUNT(empno), SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno); /*�ջ� ����� ���߿� ���*/

-- ��� ���̺��� �μ���ȣ, �μ��� �����, ���� ��, ��ü���� �� ��ȸ
--  CUBE : �ջ� ����� ���� ���
SELECT deptno, COUNT(empno), SUM(sal)
FROM emp
GROUP BY CUBE(deptno);

-- �����÷��� �׷����� ���̸� �׷캰 ���, �߰����, ���հ���� ����Ѵ�.
-- �μ��� �ش��ϴ� ������ ����, ������� ��ȸ
SELECT deptno, job, count(job)
FROM   emp
GROUP BY CUBE(deptno, job);
--GROUP BY ROLLUP(deptno,job);
