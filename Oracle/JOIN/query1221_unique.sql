------------------------ unique ------------------------

-- �÷�����
CREATE TABLE unique_column (

	name varchar2(30),
	age number(3),
--	email varchar2(50) UNIQUE /*������׸��� ���Ƿ� ���������. ex) SYS_CXXXXX*/
	email VARCHAR2(50) CONSTRAINT uk_email UNIQUE,
	addr VARCHAR2(100)

);

-- ���̺� ����
CREATE TABLE unique_table (

	name VARCHAR2(15),
	phone VARCHAR2(13),
	CONSTRAINT uk_phone UNIQUE( phone )

);

SELECT * FROM USER_CONSTRAINTS;
select * from  foreign_column;


-- �߰�
-- ����

-- 1. ���ʵ����� �Է�
INSERT INTO unique_column(name, age, email, addr) VALUES ('��μ�',25,'kim@test.com','����� ������');


-- 2. �̸����� �ٸ� ���
INSERT INTO unique_column(name, age, email, addr) VALUES ('��μ�',25,'lee@test.com','����� ������');

--3. NULL�� �ԷµǴ� ��� (UNIQUE�� NULL�� �ߺ��� �ȴ�.)
INSERT INTO unique_column(name, age, email, addr) VALUES ('�̹���',25,'','����� ��걸');


select * from unique_column;

-- ����
-- ���� �̸����� �ԷµǴ� ���
INSERT INTO unique_column(name, age, email, addr) VALUES ('��ä��',25,'lee@test.com','����� ��걸');

