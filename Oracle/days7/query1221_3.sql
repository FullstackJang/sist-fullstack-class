---------------------constraints ---------------------
-- Primary Key
-- �̸�, ���̵�,�ּҸ� ������ �� �ִ� ���̺� ����
-- �÷����� �������
-- ������׸��� �������� ������ Oracle���� ������׸��� �ڵ����� �ο� SYS_Cxxxx
CREATE TABLE primary_column(

	name varchar2(15),
	id varchar2(20) constraint pk_primary_coulmn primary key,
	addr varchar2(300)
);


drop table primary_column;
purge recyclebin;
select * from user_indexes;
select * from user_constraints;

insert into primary_column(name,id, addr) values('�׽�Ʈ','test','�׽�Ʈ');

commit;

-- ���̺���� �������
-- ��ȣ, �̸�, �ֹι�ȣ�� �����ϴ� ���̺�

CREATE TABLE primary_table(

	num number,
	name varchar2(30), /*�������̴� ũ�⸦ ���� ������ 0���� ����.*/
	ssn char(14),

	constraint pk_primary_table primary key(ssn)

);

-- primary_table �� �߰� �����ϴ� ���

-- �����Է�
insert into primary_table(num,name,ssn) values(1,'�׽�Ʈ1','880101-1234567');


-- �ֹι�ȣ�� �ٸ��ٸ� �߰� ����
insert into primary_table(num,name,ssn) values(1,'�׽�Ʈ1','880101-1234568');

commit;

-- primary_table ���� ���� ���
-- ���� �ֹι�ȣ�� �Էµ� ��
insert into primary_table(num,name,ssn) values(1,'�׽�Ʈ1','880101-1234568');

-- null�� �Էµ� ��

-- ����, ��¥�� �Ѱ��� ��Ȳ������ null�� �߻�
	-- INSERT(�߰�)�� �� �÷��� �����ϴ� ���
-- �÷��� �����ϴ� ���
insert into primary_table(num,name) values(1,'�׽�Ʈ3');


-- ���ڿ�
		-- �߰��� �� �÷��� �����ϰų�, �÷��� ����ϰ� ''�� �ִ� ���
-- �÷��� �����ϰ� ''�� �ִ� ���
insert into primary_table(num,name) values(1,'');

select num,name,ssn from primary_table;
