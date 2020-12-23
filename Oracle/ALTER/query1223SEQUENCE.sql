CREATE TABLE test(num number, name VARCHAR2(30));

INSERT INTO test(num,name)VALUES(1,'������');
COMMIT;

-- SEQUENCE�� �������� �����ϸ� �ش� ��ȣ�� ���� �� �ִ� ����
-- ��Ȯ�� �������� ��ȣ�� ��Ÿ������ ���� ���������� ����ؾ��Ѵ�.

SELECT * FROM TEST;
-- TEST���̺� �Ʒ��� ���ڵ带 �߰��ϼ���
-- ��ȣ�� ������ �� �ִ� ��ȣ ���� ��ȣ�� �߰��Ǿ���Ѵ�.
INSERT INTO test(num, name)VALUES((SELECT MAX(num)+1 FROM test),'������');
INSERT INTO test(num, name)VALUES((SELECT MAX(num)+1 FROM test),'����');
INSERT INTO test(num, name)VALUES((SELECT MAX(num)+1 FROM test),'�ֹ���');
INSERT INTO test(num, name)VALUES((SELECT MAX(num)+1 FROM test),'���');

SELECT * FROM TEST;


---------------------- SEQUENCE -------------------------

------- SEQUENCE
SELECT * FROM user_sequences;

CREATE SEQUENCE test_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999;

-- ���� ����
-- �������� �־ ����ϴ� ��
-- CURRVAL�� �޸𸮿� �ö���ִ� �������� ���簪�� ����ϸ� ����
-- ORA-08002: ������ TEST_SEQ.CURRVAL�� �� ���ǿ����� ���� �Ǿ� ���� �ʽ��ϴ�
SELECT test_seq.CURRVAL
FROM dual;

-- NEXTVAL
select test_seq.NEXTVAL
from dual;

DROP SEQUENCE test_seq;

-- 1~9999999999 ���� 10�� �����ϴ� ������
CREATE SEQUENCE seq_test
INCREMENT BY 10
START WITH 1
MAXVALUE 999999999
CACHE 100
CYCLE;

SELECT seq_test.NEXTVAL
FROM DUAL;

DROP SEQUENCE seq_test;

SELECT * FROM user_sequences;

-- �������� �����ϸ� ��ȣ�� �������.

-- �̸��� �ѱ� 5�ڱ����� �Է°����ϵ��� ����
ALTER TABLE test MODIFY name varchar2(15);

INSERT INTO test(num,name) VALUES( test_seq.NEXTVAL , '�׽�Ʈ');
                        -- test_seq.NEXTVAL �ٱ� ������ �����ϴ��� 1�� �����ȴ�. 
SELECT * FROM test;
