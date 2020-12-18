--------------------------���� -------------------------------

-- ������� �������� ����
-- �÷��� �������� ����(asc)�� �⺻����
SELECT empno, ename
FROM emp
ORDER BY ename;
--ORDER BY ename asc;

-- ������� ��������(desc) ����
SELECT empno, ename
FROM emp
ORDER BY ename DESC;

-- �����ȣ, �����, ������ ��ȸ
-- ��, ������ �������� ����, ���� ������ �ִٸ� ������� ������������ �����Ͽ� ����� ��
SELECT empno, ename, sal
FROM emp
ORDER BY sal DESC, ename, empno;


-------------���ڿ��� ������ �ڸ����� ����
CREATE TABLE test_orderby (

num VARCHAR2(10)
);

INSERT INTO TEST_ORDERBY(num) VALUES(1);
INSERT INTO TEST_ORDERBY(num) VALUES(11);
INSERT INTO TEST_ORDERBY(num) VALUES(201);
INSERT INTO TEST_ORDERBY(num) VALUES(10001);
INSERT INTO TEST_ORDERBY(num) VALUES(10009);
INSERT INTO TEST_ORDERBY(num) VALUES(2005);
INSERT INTO TEST_ORDERBY(num) VALUES(3);
INSERT INTO TEST_ORDERBY(num) VALUES(4);
INSERT INTO TEST_ORDERBY(num) VALUES(321);
INSERT INTO TEST_ORDERBY(num) VALUES(30001);;

commit;

-- ���ڿ�(VARCHAR2, CHAR)���������� ���ڸ� ������ �ڸ����� ������ ����
SELECT *
FROM TEST_ORDERBY
ORDER BY num;

