------------------------- ALTER -----------------------

-- ���̺� ����
CREATE TABLE test_alter(
	num NUMBER,
	neam VARCHAR2(30),
	id  VARCHAR2(20),
	addr NUMBER
);

-- �÷��� ����
-- neam -> name
ALTER TABLE test_alter RENAME COLUMN neam TO name;


-- �÷��� �������� ����
-- ���ڵ尡 �������� ���� ������ �������� ��ü�� ������ �� ����
-- addr �÷��� ���������� NUMBER -> VARCHAR2(300)
ALTER TABLE test_alter MODIFY addr VARCHAR2(300);

INSERT INTO test_alter(num, name, id, addr) VALUES (1,'�׽�Ʈ','hong','�����');

INSERT INTO test_alter(num, name, id, addr) VALUES (2,'�׽�Ʈ','','�����');

COMMIT;


-- �����Ͱ� �����ϸ� ���� ������������ ũ�⸸ ����
-- ErrMsg : ORA-01439: ������ ������ ������ ���� ��� �־�� �մϴ�
ALTER TABLE test_alter MODIFY addr NUMBER;


ALTER TABLE test_alter MODIFY addr VARCHAR2(30);


-- MODIFY�� �÷����� ��������� �߰��� �� �ִ�.
-- �÷��� ���� ������׿� ����Ǵ� ���� �ִٸ� ��������� ������ �� ����.
-- ID�� ���ڿ� ���� ��� �ִ�.
-- ErrMsg : ORA-01449: ���� NULL���� �����ϰ� �ֽ��ϴ� NOT NULL�� ������ �� �����ϴ�
ALTER TABLE test_alter MODIFY id VARCHAR2(30)
			CONSTRAINT pk_test_alter PRIMARY KEY;
-- �����Ȳ�� ����Ǵ� ���ڵ带 �����.
DELETE FROM test_alter WHERE num = 2;
COMMIT;


-- �÷� ����
-- id�÷� ����(�÷��� ��������� �����ϸ� ��������� �����ȴ�.)
ALTER TABLE test_alter DROP COLUMN id;

-- �÷� �߰�
-- �÷��� �߰��ϸ鼭 "�÷����� �������"�� �Բ� �߰��� �� �ִ�.
-- �߰��� �÷��� �׻� ���� �������� �߰��ȴ�.
-- ���� �÷� �߰� ���̴� 20~40������� ���̸� �߰��� �� �ֵ��� ����

ALTER TABLE test_alter ADD age NUMBER(3) CHECK(age BETWEEN 20 AND 49);

SELECT * FROM user_constraints
WHERE table_name = 'TEST_ALTER';

-- CHECK ���� ���ǿ� ����� ���� �߰�
-- ErrMsg : ORA-02290: üũ ��������(SCOTT.SYS_C008926)�� ����Ǿ����ϴ�
INSERT INTO test_alter(num,name,addr,age)
		VALUES(2,'�׽�Ʈ2','�����',19);


INSERT INTO test_alter(num,name,addr,age)
		VALUES(2,'�׽�Ʈ2','�����',20);

select * from test_alter;
