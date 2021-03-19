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
