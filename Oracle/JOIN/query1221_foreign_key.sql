-- foreign key (�ܷ�Ű, ����Ű)
-- primary_column ���̺��� id�÷��� �����ϴ� �ڽ����̺� ����

-- column ���� ������� : �÷��� ��������(ũ��) constraint ������׸� references ���������̺��(�÷���)
-- �ڽ����̺��� �÷����� �θ����̺��� �÷���� ���� �ʾƵ� �ȴ�.

CREATE TABLE foreign_column (
  f_id varchar2(20) constraint fk_f_id references primary_column( id ),
  email varchar2(50),
  age number(3),
  input_date date
);


-- table���� �������
-- primary_table���̺��� ssn�÷��� ����Ű�� ����

CREATE TABLE foreign_table (

	ssn CHAR(14),
	age NUMBER(3),
--	CONSTRAINT fk_ssn foreign key(ssn) references primary_table(ssn)
	CONSTRAINT fk_ssn foreign key(ssn) references primary_table(ssn)
 	ON DELETE CASCADE
);


---- �ٸ� ���̺� �Ϲ��÷��� Foreign key�� ������ �� ����.
--  �����ȣ ���̺��� seq�� ����

CREATE TABLE test(
																									-- seq�� Primary key�� �ƴ϶�� ��
	seq NUMBER(5) CONSTRAINT fk_seq references zipcode( seq )


);

select * from user_constraints
where table_name = 'FOREIGN_TABLE';


insert into primary_column(name, id, addr) values ('������', 'ryu','�����');
insert into primary_column(name, id, addr) values ('��μ�', 'kim','�����');
commit;
-- foreign key ���� �߰�
-- �߰� ����

-- 1. �θ� ���̺��� �����ϴ� ������ �÷����� �߰��� ��
insert into foreign_column(f_id, email, age, input_date) values ('kim','kim@test.com',20,sysdate);

-- 2. �θ����̺� �����ϴ� ���̶�� ��� �߰��� �� �ִ�.
insert into foreign_column(f_id, email, age, input_date) values ('kim','kim11111@test.com',25,sysdate);

insert into foreign_column(f_id, email, age, input_date) values ('ryu','ryu@test.com',21,sysdate);

-- 3 null�� �߰��ϴ� ���
insert into foreign_column( email, age, input_date) values ('null@test.com',21,sysdate);

insert into foreign_column( email, age, input_date) values ('null1@test.com',21,sysdate);


-- foreign key ���� ����
-- �߰� ����
--1. �θ� ���̺� �������� �ʴ� ������ �߰��� ��
insert into foreign_column(f_id, email, age, input_date) values ('ryu1','ryu@test.com',21,sysdate);


-- ���ڵ� ����
-- foreign key ������׿� on delete cascade�� ������ �ʾҴٸ� �ڽ����̺��� ���ڵ带 ������ �� �θ����̺��� ���ڵ带 ������ �� �ִ�.
select * from foreign_column;
select * from primary_column;

-- �θ����̺��� �����ϰ� ���� ���� ���ڵ� ����( �ٷ� ������ �� )
delete from primary_column where id = 'test';


-- �θ����̺��� �����ϰ� �ִ� �ڽķ��ڵ尡 ������ �� ����
delete from primary_column where id = 'kim'; /*kim�� ryu�� �ڽķ��ڵ尡 �����ϹǷ� ������ �� ����.*/


-- �ڽ����̺� �����ϴ� ���ڵ带 ���� �� �θ����̺��� ���ڵ带 �����Ѵ�.
--1. �ڽ� ���ڵ带 ������ ��
DELETE FROM foreign_column where f_id ='ryu';

--2. �θ� ���ڵ带 �����Ѵ�.
DELETE FROM primary_column where id ='ryu';

select * from foreign_column;
select * from primary_column;

-- �θ����̺� ���ڵ尡 ���� �Ǹ� �ڵ����� �ڽ� ���̺��� ��� ���ڵ带 ���ÿ� ����
INSERT INTO foreign_table(ssn, age) VALUES ('880101-1234567',20);
INSERT INTO foreign_table(ssn, age) VALUES ('880101-1234567',21);
INSERT INTO foreign_table(ssn, age) VALUES ('880101-1234568',21);
COMMIT;
SELECT * FROM  foreign_table;
SELECT * FROM  primary_table;


-- ON DELETE CASCADE�� �����Ǿ��־� �θ����̺��� ���ڵ带 �����ϸ� ��� �ڽ����̺��� ��� ���ڵ尡 �����ȴ�.
DELETE FROM primary_table WHERE ssn ='880101-1234567';
