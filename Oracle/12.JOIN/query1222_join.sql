-- �����ȣ, �����, �Ի���, �μ���ȣ, �μ���, ��ġ ��ȸ

-- ANSI Ʋ�� ����
-- SELECT�� deptno�� ON�� deptno�� �������� �� �� ����.
-- ���� �÷����� �����ϸ� � ���̺� �����ϴ� �÷����� �� �� ���� ������ ������ �߻�
-- "���̺��.�÷���"���� �÷��� �ĺ��ϵ��� �����.
-- ���̺���� ��ٸ� ���̺� alias�� �ٿ� ����ϱ� ���ϰ� �����.
		-- ���̺�� alias ����
-- Error MSG : ORA-00918: ���� ���ǰ� �ָ��մϴ�
SELECT empno, ename, hiredate, deptno, dname, loc
FROM		dept
INNER JOIN	emp
ON deptno = deptno;


SELECT empno, ename, hiredate, dept.deptno, dname, loc
FROM		dept
INNER JOIN	emp
ON emp.deptno = dept.deptno;


-- ���̺��� alias�� ���
SELECT e.empno, e.ename, e.hiredate, d.deptno, d.dname, d.loc /*inline view�� deptno�÷����� �ݿ� ���� �ʴ´�.*/
FROM		dept d
INNER JOIN	emp e
ON e.deptno = d.deptno;



-- Oracle join
-- �����ȣ, �����, �Ի���, �μ���ȣ, �μ���, ��ġ ��ȸ

SELECT e.empno, e.ename, e.hiredate,e.deptno ,d.deptno, d.dname, d.loc
FROM		dept d, emp e
WHERE		e.deptno = d.deptno;

select * from CAR_COUNTRY;
select * from CAR_MAKER;
select * from CAR_MODEL;

-- �������� '����'�� ��� ������ ������,�𵨸�, �� ��, ����, �ɼ��� ��ȸ
-- CAR_COUNTRY:������ ������
-- CAR_MAKER: ������,�𵨸�
-- CAR_MODEL: �𵨸�, �� ��, ����, �ɼ�

--  CAR_COUNTRY�� CAR_MAKER�� ���� ������
-- CAR_MAKER��CAR_MODEL�� ������ �𵨸�

-- ANSI
SELECT c_cou.maker, c_mak.model, c_mod.car_year, c_mod.price, c_mod.car_option
FROM  	car_country c_cou
INNER JOIN car_maker c_mak
ON c_mak.maker = c_cou.maker
INNER JOIN car_model c_mod
ON		c_mod.model = c_mak.model
WHERE c_cou.country = '����';


--ORACLE
--SELECT c_cou.maker, c_cma.model, c_mod.car_year, c_mod.price, c_mod.car_option
--FROM car_country c_cout, car_maker c_cma, car_model c_cmo
--WHERE ( c_cma.maker = c_cou.maker and c_cmo.model = c_mod.model ) AND c_cou.country = '����';

-- ������ �ɼǿ� 'ABS'�� �ִ� ��� ������ '������', '������', '�𵨸�', '���', '��ⷮ', '�̹���', '�Է���'�� ��ȸ

SELECT c_cou.country, c_cou.maker, c_cma.model, c_mod.car_year, c_mod.cc, c_mod.car_img, c_mod.hiredate
FROM car_country c_cou, car_maker c_cma, car_model c_mod
WHERE (c_cma.maker=c_cou.maker and c_mod.model = c_cma.model) and c_mod.car_option like '%ABS%' ;


select * from CAR_COUNTRY;
select * from CAR_MAKER;
select * from CAR_MODEL;


select * from emp;
select * from dept;
