SELECT '����� ������' address, 2020 year FROM dual;


------------------- ��ġ �Լ� -------------------

--ABS(���밪)
SELECT abs(-12), abs(12)
FROM dual;


--ROUND(�ݿø�) : round(��, �ݿø��Ͽ� �� �ڸ��� )
-- �Ǽ��δ� �ݿø��Ͽ� �� �ڸ����� �����Ѵ�.
SELECT ROUND(555.555,2)
FROM dual;

SELECT ROUND(555.554,2) /*555.554�� 4���� �ݿø� ����� �ƴ϶� �ݿø����� �ʴ´�.*/
FROM dual;

-- �����δ� �ش��ڸ����� �ݿø��Ѵ�.
SELECT ROUND(777.777,-1)
FROM dual;

-- ��� ���̺��� ��� ����� �����ȣ, �����, ����, ������ ��ȸ
-- ��, ������ �Ҽ��� 1��° �ڸ����� �ݿø��Ͽ� ����θ� ����� ��
SELECT empno, ename, sal, ROUND(sal * 0.033)
FROM emp;

-- CEIL(�ø�)
SELECT CEIL(10.1), CEIL(10.0001)
FROM dual;

-- FLOOR(����)
SELECT FLOOR(10.9)
FROM dual;

-- TRUNC(����)
-- �Ǽ��δ� �ش��ε��� �������� �ڸ���.
SELECT TRUNC(777.777,2), TRUNC( 777.777,1)
FROM dual;

-- �����δ� �ش��ε��� ���� �ڸ���.
SELECT TRUNC(777.777,-1), TRUNC( 777.777,-2)
FROM dual;


-- ������̺��� ������� �����ȣ, �����, ����, ������ ��ȸ
-- ��, ������ ������ 3.3%�� ����ϰ�, ������ �����Ͽ� ��ȸ ���
SELECT empno, ename, sal, TRUNC(sal*0.033,-1) tax
FROM emp;

-- ���� ������ MOD(��, ���� ��)
SELECT MOD(10,3) , MOD(2020,12)
FROM dual;