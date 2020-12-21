-- SELECT �ܼ��� ��������

-- ������̺��� ��տ����� �ʰ� �ϴ� ����� �����ȣ, �����, �Ի���, ������ ��ȸ�ϼ���
SELECT  empno, ename, hiredate, sal
FROM emp
where sal > (SELECT TRUNC(AVG(sal)) FROM emp);


-- cp_emp3���̺��� �����ȣ�� 1111���� ����� �μ���ȣ�� ���� �μ���ȣ�� ����
-- ����� emp���̺��� ��ȸ. ��ȸ�÷��� �μ���ȣ, �����ȣ, �����, �Ի���, ����

select * from cp_emp3;
select * from emp;

SELECT deptno, empno, ename, hiredate, sal
FROM emp
where deptno = (SELECT deptno FROM cp_emp3 WHERE empno = 1111);

-- scalar subquery(�ܼ��� subquery) : ��ȸ�ϴ� �÷��� ���
-- ���� ������ �÷���� �ٱ� ������ �÷����� ���ٸ� '���̺��.�÷���"��
-- �������� �÷��� �ĺ��Ͽ� ���

-- �����ȣ,�����, �μ���ȣ, �μ����� ��ȸ
SELECT empno, ename, deptno, (SELECT dname FROM dept WHERE dept.deptno = emp.deptno) dname
FROM emp;

select *
from dept;


-- ��� ���̺��� �ְ���, �ְ����� �����ϴ� ������� ��ȸ
SELECT ename, (SELECT MAX(sal) FROM emp)
FROM emp
WHERE sal = (SELECT  MAX(sal)
FROM emp);

--------------------------������ subquery : ��ȸ����� ������ ����ȸ
select empno, ename, sal, hiredate
from (SELECT ename, empno, sal, hiredate
FROM emp);

-- ���� �������� �÷��� alias�� �ο��Ǹ� �ٱ� ���������� alias�θ� ��밡��
select empno, ename, sal, h /*���� �ζ��κ信 hiredate�� ���⶧���� �ٱ��ʿ����� h�� ����ؾ��Ѵ�.*/
from (SELECT ename, empno, sal, hiredate h
FROM emp);

-- ������������ ��ȸ�� �÷��� ����� �� �ִ�.
select empno, ename, sal, hiredate, comm
from (SELECT ename, empno, sal, hiredate  /*���� ���������� ��ȸ�Ȱ͸� �ٱ� ���������� ��밡��*/
FROM emp);

-- ������̺��� ���� �������� �Ի��� ������� 5���� ������� ��ȸ
-- ���帶������ �Ի��� ������� ��ȣ�� ���������� �ٿ��ش�.)
-- �����ȣ,�����,�Ի���
SELECT rownum , empno, ename, hiredate
FROM (SELECT empno, ename, hiredate
FROM emp
ORDER BY hiredate DESC)
WHERE ROWNUM BETWEEN 1 AND 5;


-- ������̺��� ���� �������� �Ի��� 2 �� ������� 5��(2��°~6��°)�� ������� ��ȸ
-- ���帶������ �Ի��� ������� ��ȣ�� ���������� �ٿ��ش�.)
-- �����ȣ,�����,�Ի���

SELECT rnum, empno, ename, hiredate
FROM (SELECT  ROWNUM rnum , empno, ename, hiredate
FROM 	(SELECT empno, ename, hiredate
			 FROM emp
			 ORDER BY hiredate DESC))
WHERE rnum between 2 and 6;


------------------------------- ���� ��ȣ -------------------------------
-- ������̺��� ��ȣ, �����ȣ, ������� ��ȸ
-- ��ȣ�� ��ȸ�Ǵ� �÷��� ������� 1�� ���� �ο��Ѵ�.
SELECT ROWNUM, empno, ename
FROM emp;


--ROWNUM�� ORDER BY���� ���� �����ȴ�.
-- ������̺��� ��ȣ, �����ȣ, ������� ��ȸ
-- ��, ������� ������������ �����Ͽ� ��ȸ
SELECT ROWNUM, empno, ename
FROM emp
ORDER BY ename asc; /*ROWNUM�� ORDER BY���� ���� �����ȴ�.*/


-- where������ ����ϸ� 1�����ʹ� �񱳰� �ǳ�, 1�� ���Ŀ��� �񱳰� ���� �ʴ´�.
-- ������̺��� ��ȣ,�����ȣ, ������� ��ȸ
-- ��, ��ȣ�� 12~7�������� ����� ���
SELECT ROWNUM, empno, ename
FROM emp
WHERE ROWNUM between 1 and 7;
--WHERE ROWNUM between 2 and 7; /*2������ �����ϸ� ��ȸ�� ���� �ʴ´�.*/
--WHERE ROWNUM >= 1 and ROWNUM <= 7 ;
--WHERE ROWNUM >= 2 and ROWNUM <= 7 ; /*2������ �����ϸ� ��ȸ�� ���� �ʴ´�.*/


-- ROWNUM�� SELECT���� �����ǰ� ���ȴ�.
-- ���� Subquery���� ROWNUM�� ��ȸ���� �ʾƵ� �ٱ� SELECT���� ROWNUM�� ����� �� �ִ�.
-- ���ʿ� ROWNUM�� �ٱ��ʿ��� ����Ϸ��� ALIAS�� �ٿ��� ����ؾ��Ѵ�.
SELECT rnum, en, empno, ename, job
FROM (SELECT ROWNUM rnum,empno en,ename, empno ,job FROM emp order by ename);

