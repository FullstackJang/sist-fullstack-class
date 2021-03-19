-------------------------- RANK �Լ� : ������ �ο��� �� -------------------

--ORDER BY���� �Բ� ������� �ʴ´�.

-- ������̺��� �����ȣ, �����, ����, ������ ������ ��ȸ�ϼ���

-- ��ȸ�Ǵ� ���ڵ忡 ���� ����� Ȯ�� �� ��
SELECT empno, ename, sal, RANK() OVER(ORDER BY sal desc)
FROM emp;


-- ��ȸ�Ǵ� ���ڵ忡 ���� ����� Ȯ���ϰ� ���� ���� ��
SELECT empno, ename, sal, ROW_NUMBER() OVER(ORDER BY sal desc)
FROM emp;


SELECT ename, rank() OVER(ORDER BY ename)
FROM emp;


-- PARTION BY ���
-- ������̺��� �μ���ȣ, �μ��� ���� ����, ����, ������� ��ȸ

SELECT deptno, ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal desc) rank, sal, ename
FROM emp;
--WHERE deptno = 30 Ư�� �μ��� ���ؼ��� �� ���� �ִ�.

-- ������̺��� ����, ������ ��������, ����, ����� ��ȸ
-- ��, ���� ������ �����Ѵٸ� ���� ������ ������.
SELECT job, RANK() OVER(PARTITION BY job ORDER BY sal) rank, sal, ename
FROM emp;
