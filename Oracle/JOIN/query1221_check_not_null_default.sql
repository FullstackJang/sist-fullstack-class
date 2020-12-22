--- CHECK, NOT NULL, DEFAULT

-- �̸�, ����, ����, �Է����� �����ϴ� ���̺�
-- �̸� - �ʼ��Է�, ���� - '����' �Ǵ� '����'�� �Է°���
-- ���̴� null�� �ԷµǸ� '0'�� �߰�
-- �Է����� �����Ǹ� INSERT�ϴ� ������ ���� ��¥
-- DEFAULT�� ��������� �ƴ�

CREATE TABLE other_constraint(

	name VARCHAR2(15) NOT NULL,
	address VARCHAR2(100) NULL, /*�⺻�� NULL�� �ްڴٰ� �Ǿ��ִ�. �����ϰ� ������� ��*/
	gender CHAR(6) CHECK (gender = '����' OR gender = '����'),
	age number(3) default 0,
	input_date date default sysdate

);

-- user_constraints : ���̺� ������ ��������� Ȯ���ϴ� dictionary.
select * from user_constraints
WHERE table_name = 'OTHER_CONSTRAINT';

-- user_cons_colums : ���̺� ������ ��������÷��� Ȯ���ϴ� dictionary
select * from user_cons_columns
where table_name = 'FOREIGN_TABLE';

-- user_tab_cols : ���̺� �����ϴ� �÷���, ��������, ũ��, default���� Ȯ�� �� �� �ִ� dic
SELECT * FROM user_tab_cols;

select * from user_tab_cols
where table_name = 'OTHER_CONSTRAINT';



-- �߰�
-- �߰� ����

-- �̸� : OK , �ּ� : OK , ���� : '����' �Ǵ� '����', ���� : OK, �Է��� : OK
INSERT INTO other_constraint(name, address, gender, age, input_date) VALUES ('��μ�','����� ���빮��','����',20, SYSDATE);


-- �̸� : OK , �ּ� : NO , ���� : '����' �Ǵ� '����', ���� : OK, �Է��� : OK
INSERT INTO other_constraint(name, gender, age, input_date) VALUES ('�����','����',20, SYSDATE);

-- �̸� : OK , �ּ� : NO , ���� : '����' �Ǵ� '����', ���� : NO, �Է��� : NO
INSERT INTO other_constraint(name, gender) VALUES ('�̴�ȣ','����');


select * from other_constraint;


-- �߰� ����

-- �̸��� null�� �ԷµǴ� ���
INSERT INTO other_constraint(name, address, gender, age, input_date) VALUES ('','����� ���빮��','����',20, SYSDATE);
-- ���� �ڵ� : ORA-01400: NULL�� ("SCOTT"."OTHER_CONSTRAINT"."NAME") �ȿ� ������ �� �����ϴ�

-- �̸� �÷��� �����ϰ� �ִ� ���
INSERT INTO other_constraint( address, gender, age, input_date ) VALUES ('����� ���빮��','����',20, SYSDATE);
-- ���� �ڵ� : ORA-01400: NULL�� ("SCOTT"."OTHER_CONSTRAINT"."NAME") �ȿ� ������ �� �����ϴ�

-- ������ '����' OR '����'�� �ƴ� ���
INSERT INTO other_constraint(name, address, gender, age, input_date) VALUES ('��μ�','����� ���빮��','��',20, SYSDATE);
-- �����ڵ� : ORA-02290: üũ ��������(SCOTT.SYS_C008664)�� ����Ǿ����ϴ�
