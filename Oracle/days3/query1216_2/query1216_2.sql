-- || ���ڿ� ���� ������
-- ��ȸ����� ���ڿ��� ����� ��. ||�� �ڹٷ� ġ�� ���ڿ��� ���ϴ°Ͱ� ����.

-- ������̺��� �����,�����ȣ�� ��ȸ
-- ��, ����� [xxx]����� �����ȣ�� [xxxx] �Դϴ�. �� �������� ���
SELECT '[' || ename || ']����� �����ȣ�� [' || empno || ']�Դϴ�.' output
FROM  emp;

-- ������̺��� ������� ù ���ڰ� 'A'�� �����ϴ� ����� �����, �����ȣ ��ȸ

SELECT  ename,deptno
FROM emp
WHERE ename like 'A%';


-- ������̺��� ������� �� ���ڰ� 'S'�� ������ ����� �����, �����ȣ ��ȸ

SELECT ename, empno
FROM emp
where ename like '%S';

-- ������̺��� ����� 'A'�� ����ִ� ����� �����, �����ȣ ��ȸ

SELECT ename, empno
FROM emp
where ename like '%A%';

-- ������̺��� ����� 'L'�� �ΰ�����ִ� ����� �����, �����ȣ ��ȸ

SELECT ename, empno
FROM emp
where ename like '%L%L%';


-- ������̺��� ������� 5������ ����� �����, �����ȣ�� ��ȸ
SELECT ename, empno
FROM emp
WHERE ename like '_____';


-- ������̺��� ������� 5���� �̸鼭 ����° ���ڰ� 'A'�� ����� ������� ��ȸ
SELECT ename, empno
FROM emp
WHERE ename like '__A__';


-- ������̺��� ������ ��ȸ
-- ��, �ߺ��Ǵ� ������ ��ȸ���� �ʴ´�.
SELECT distinct job
FROM emp;

-- ������̺��� �μ���ȣ�� ��ȸ
-- ��, �ߺ��Ǵ� �Ŵ�����ȣ�� ��ȸ���� �ʴ´�.
SELECT distinct mgr
FROM emp;

-- distinct�� �ߺ����� ���� �÷��� �ߺ����� ���������� �ø���
-- ���ڵ�� ��ȸ�Ǹ� �ߺ������� ���� �ʴ´�.
SELECT  distinct deptno,  mgr
FROM emp;

------group by------------------------------
SELECT 	job
FROM 	emp
GROUP BY 	job ;


SELECT	deptno
FROM    emp
GROUP BY deptno;

-- �׷����� �������� ���� �÷��� ��ȸ�÷��� ���ǵǸ� Error
-- �������� ��ȸ�Ǵ� �÷��� ���� ���Ǹ� �׷����� �������� �ʴ´�.
SELECT	deptno, ename
FROM	emp
GROUP BY deptno;



