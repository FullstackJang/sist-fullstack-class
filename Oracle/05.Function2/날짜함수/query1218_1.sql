-----------------------------��¥ �Լ� ---------------------------
-- ��¥�� + ������ ����ϸ� ���� ��¥���� �Ϸ羿 �����ϴ� ���� ���� �� �ִ�.
-- ��¥�� - ������ ����ϸ� ���� ��¥���� �Ϸ羿 �����ϴ� ���� ���� �� �ִ�.

SELECT sysdate, sysdate + 4, sysdate -2
FROM dual;


-- �� ����
SELECT	SYSDATE, ADD_MONTHS(SYSDATE,1), ADD_MONTHS(SYSDATE, 2)
FROM	dual;

-- �� ������ ����
SELECT TRUNC(MONTHS_BETWEEN('2021-4-21',SYSDATE))
FROM dual;

SELECT  ename, TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)) after_hiredate , hiredate
FROM emp;

SELECT MONTHS_BETWEEN(SYSDATE,'1993-7-14') /12
FROM dual;


-- �������� ���ϱ� last_day(���� ��¥)
SELECT SYSDATE, LAST_DAY(SYSDATE), LAST_DAY('2021-02-01')
FROM   dual;
