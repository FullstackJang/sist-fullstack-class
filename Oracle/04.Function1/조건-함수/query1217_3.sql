-------------------------- ���� �Լ� ----------------------------

SELECT DECODE(1,1,'��',2,'��',3,'��', '��ġ�ϴ� ���� �����ϴ�.')
FROM dual;

-- �μ����̺��� �μ���ȣ, �μ���, �ѱ� �μ����� ��ȸ
-- ��, �ѱ� �μ����� �Ʒ�(�ϱ�)�� ǥ�� ���� �����մϴ�.
-- 10�� - ���ߺ�, 20 - ����������, 30 - ������ , 40 - Ź����

SELECT deptno, dname, DECODE(deptno, 10,'���ߺ�', 20, '����������', 30, '������','Ź����') kor_dname
FROM dept;


-- ������̺��� �����ȣ, �����, �ѱ� ������ ��ȸ
-- ��, �ѱ� ������ �Ʒ��� ǥ�� ���� �����մϴ�.
-- 'CLERK - �Ϲݻ��,'SALESMAN' - �������, 'MANAGER' - �������,
-- 'ANALYST' - �м���,'PRESIDENT' - ȸ���

SELECT  empno, ename, job, DECODE(job, 'CLERK', '�Ϲݻ��','SALESMAN', '�������', 'MANAGER', '�������', 'ANALYST' , '�м���','PRESIDENT','ȸ���')
FROM  emp;

-- ������̺��� �����ȣ, �����, ����, ���ʽ�,  �μ���ȣ�� ��ȸ
-- �� ���ʽ��� �Ʒ��� ǥ�� ���� ������ �ش� %�� ����Ͽ� ����Ѵ�.
-- 10 - ������ 10% 20 - ������ 15%, 30 - ������ 20% �� �� ������ 50%

SELECT empno, ename, sal, comm, deptno, TRUNC(DECODE(deptno,10,sal*0.1,20,sal* 0.15,30,sal* 0.2,sal* 0.5)) bonus
FROM  emp;

-- CASE
SELECT CASE 'java' WHEN 'java' THEN '�Ϻ��� OOP���'
									 WHEN	'HTML' THEN 'Markup Language'
									 WHEN 'JavaScript' THEN 'toy Language'
									 else '����� ������ �����ϴ�.'
			 END lang_info
FROM dual;

-- ������̺��� �����ȣ, �����, �μ���ȣ, �μ��� ���ʽ�, ������ ��ȸ
-- ��, �μ��� ���ʽ��� 10 - 100, 20 - 400, 30 - 250 �� �ܴ� 1000���� ���
SELECT empno, ename, deptno, case deptno when 10 then 100
																				 when 20 then 400
																				 when 30 then 250
																				 else 1000
														 end dept_bonus,
 														 job
FROM  emp;

----------------------------- ��ȯ �Լ� ----------------------------------
SELECT sysdate
FROM  dual;

SELECT TO_CHAR(sysdate,'yyyy"��"-mm-d am hh(hh24):mi:ss dy day q "�б�"')
FROM dual;

-- ������ ��ҹ��� ������ �ʴ´�.
SELECT TO_CHAR(sysdate,'YYYY"��"-MM-D AM HH(HH24):MI:SS DY DAY Q "�б�"')
FROM dual;



-- pattern�� ��� Error�� �߻�
SELECT  TO_CHAR(SYSDATE,'yyyy " �� " mm " �� " dd " �� " am  hh " �� "  mi " �� " ss " �� " ')
FROM dual;

-- pattern�� ��� TO_CHAR�� �ι����� ��� �������
SELECT  TO_CHAR(SYSDATE,'yyyy " �� " mm " �� " dd " �� "') || TO_CHAR(SYSDATE,' am  hh " �� "  mi " �� " ss " �� " ')
FROM dual;


-- ��� ���̺��� �����ȣ, �����, �Ի����� ��ȸ
-- ��, �Ի����� ��-��-���� �������� ���
SELECT empno, ename, TO_CHAR(hiredate,'mm-dd-yy')
FROM emp;

-- ������̺��� �Ի�⵵�� 1981���� ����� �����ȣ, �����, ����
-- �Ի���,�μ���ȣ�� ��ȸ���ּ���.
SELECT empno, ename, sal, hiredate, deptno
FROM emp
WHERE TO_CHAR(hiredate, 'yyyy') = '1981';

-- ���� ��ȯ
-- 0 : �ش� �ڸ��� �����Ͱ� �������� ������ '0'�� ���.
SELECT TO_CHAR(20202,'0,000,000')  , TO_CHAR(2020,'0,000,000.00'),
			TO_CHAR(20202,'0,000')
FROM dual;

-- 9 : �����Ͱ� �����ϴ� �͸� ���
SELECT TO_CHAR(2020,'9,999,999') , TO_CHAR(20202,'9,999')
FROM dual;

-- ��� ���̺��� �����ȣ, �����, �Ի���, ������ ��ȸ
-- ��, ������ 3�ڸ��� �ʰ� ���� ���� 3�ڸ� ���� ,�� �־� ���
SELECT empno, ename, hiredate,'[' || TO_CHAR(sal,'9,999') || ']'
FROM emp;

select * from emp;
