-- ��ⷮ(CC)�� 2000 �̻��� ������ �𵨸�, ���, ����, ��ⷮ,�Է����� ��ȸ
-- ��, ����� ���� �������� �԰�� ���� �������� 7���� ������ ����ϼ���.

SELECT r, model, car_year, price, cc, hiredate
FROM (SELECT ROWNUM r, model,car_year,price,cc, hiredate
FROM (SELECT model,car_year,price,cc,hiredate
FROM car_model
where cc >= 2000
ORDER BY hiredate desc))
WHERE r BETWEEN 1 and 7;

select * from car_model;

------------------------------------ UNION ------------------------------------
-- cp_cmp1(�ѱ�����), emp(�̱�����)
-- ���� ��������� ������ ������  ��ȸ //���� ������ ��� ��ȸ�϶�� (UINON ALL)
-- ��ȸ �÷��� �����ȣ, �����, ����, �μ���ȣ

SELECT empno, ename, sal, deptno
FROM cp_emp1
UNION all
SELECT empno, ename, sal, deptno
FROM emp;

-- ���� ��������� ������ ������  ��ȸ
-- ��, ���� ��������� 10�� �μ� �����, ������ ������ 20�� �μ� ����� ��ȸ
-- ��ȸ �÷��� �����ȣ, �����, ����, �μ���ȣ

SELECT empno, ename, sal, deptno
FROM cp_emp1
WHERE deptno = 10
UNION all
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno = 20;

------------------- UNION --- �÷��� ������ ��ġ���� ������ Error

SELECT empno, ename, sal, deptno
FROM cp_emp1
UNION all
SELECT empno, ename, sal
FROM emp;

------------------- UNION --- �÷��� ���������� ��ġ���� ������ Error

SELECT empno, ename, sal, deptno
FROM cp_emp1
UNION all
SELECT empno, sal, ename, deptno
FROM emp;

-- �÷��� ������ ���������� ��ġ�ϸ� Error�� �߻����� �ʴ´�.
SELECT empno, ename, sal, deptno
FROM cp_emp1
UNION all
SELECT mgr, job, comm, empno
FROM emp;

-- ���� ��������� ������ ������  ��ȸ
-- ��, ����, �������� 10�� �μ� ����� ��ȸ
-- ��ȸ �÷��� ��ȣ, �����ȣ, �����, ����, �μ���ȣ

SELECT ROWNUM, empno, ename, sal,deptno
FROM (SELECT  empno, sal, ename, deptno
FROM cp_emp1
UNION all
SELECT empno, sal, ename, deptno
FROM emp)
where deptno = 10;
