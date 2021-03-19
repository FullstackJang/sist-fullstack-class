---------------------------- OUTER JOIN ----------------------------

-- ��� �μ��� �ٹ��ϴ� ��� ���� ��ȸ(����� ������ �μ������� ��ȸ)

-- ANSI : LEFT, RIGHT, FULL - ���ڵ尡 �����ϴ� ���̺�
SELECT d.deptno, d.dname, d.loc, e.empno, e.ename, e.job, e.hiredate
FROM emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- Oracle : (+) - ���ڵ尡 �������� �ʴ� ���̺�
SELECT  d.deptno, d.dname, d.loc, e.empno, e.ename, e.job, e.hiredate
FROM    dept d, emp e
WHERE e.deptno(+) = d.deptno;

-- �����簡 '����, ���'�� ��� ������ ������, �𵨸�, ����,��� ��ȸ


select * from CAR_COUNTRY;
select * from CAR_MAKER;
select * from CAR_MODEL;

-- ANSI
SELECT cma.maker, cma.model, cmo.price, cmo.car_year
FROM car_maker cma LEFT JOIN car_model cmo
ON cmo.model = cma.model
WHERE cma.maker in ('����','���');


-- Oracle
SELECT cma.maker, cma.model, cmo.price, cmo.car_year
FROM  car_model cmo,car_maker cma
WHERE (cmo.model(+) = cma.model ) and cma.maker in ('����','���');

select * from dept;
select * from emp;
SELECT * FROM ZIPCODE;

-- ��� �μ��� �ٹ��ϴ� ������� �����ȣ,
-- �����, ����, �μ���ȣ, �μ���, ��ġ,����, �����ȣ,�õ�, ����, �� ���� ��ȸ
-- ������̺�� �����ȣ ���̺���  �����ȣ�� seq�� ���� ������ ����

SELECT d.deptno, d.dname,  d.loc, e.empno, e.ename, e.sal, z.zipcode, z.sido, z.gugun, z.dong, z.bunji
FROM  dept d, emp e , zipcode z
WHERE (e.deptno(+) = d.deptno and  z.seq(+) = d.deptno);

select * from emp;

-- ������̺��� ������� 'ALLEN'�� ������� ������ ���� �޴� �����
-- �����ȣ,�����, �Ի���, ����, ���� ��ȸ

-- subquery
SELECT empno, ename, hiredate, sal, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'ALLEN');

-- SELF JOIN
SELECT e1.empno, e1.ename, e1.hiredate, e1.sal, e1.job
FROM 		emp e1, emp e2
WHERE		(e1.sal > e2.sal) and e2.ename = 'ALLEN';




