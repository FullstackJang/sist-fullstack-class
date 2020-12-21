-- �������� �÷��� �ϳ��� Primary key�� ����
-- ��ȣ, �����۸�, ����,  ������ 20-01-01AM

CREATE TABLE primary_multi(

	num number,
	item varchar2(30),
	info varchar2(4000byte),
	prd_date char(10 byte),

	-- N���� �÷��� primary key�� �� �� �ִ�.
	constraint pk_primary_multi primary key( item, prd_date)

);

select * from user_constraints
where constraint_type = 'P';
--where table_name = 'PRIMARY_MULTI';


-- �������� �÷��� �ϳ��� PK�� �����Ǹ�, ��� �÷��� ������ ���� �ԷµǾ��� ��
-- ������� ���谡 �ȴ�

--success
-- ���� �Է� �� ����
insert into primary_multi(num,item,info, prd_date) values (1, '����ũ', '���� ��ȣ���ش�.', '20-12-21AM');

-- ���� ���깰�̴��� ��¥�� �ٸ��� �Է� ����
insert into primary_multi(num,item,info, prd_date) values (1, '����ũ', '���� ��ȣ���ش�.', '20-12-21PM');

-- ���� ��¥������ ���깰�� �ٸ��ٸ� �Է� ����
insert into primary_multi(num,item,info, prd_date) values (3, 'Ȳ�縶��ũ', '�̼� ������ ����', '20-12-21AM');

-- Error
-- ���� ��¥�� ���� ���깰�� �߰��Ǵ� ���
insert into primary_multi(num,item,info, prd_date) values (4, 'Ȳ�縶��ũ', '�̼� ������ ���� ����', '20-12-21AM');

-- ������ PK�÷��� �ϳ���� null�� �߰��Ǵ� ���
-- �����ۿ� null �߰�
insert into primary_multi(num,item,info, prd_date) values (4, '', '�̼� ������ ���� ����', '20-12-21AM');

-- �����Ͽ� null �Է�
insert into primary_multi(num,item,info) values (4, 'Ȳ�縶��ũ', '�̼� ������ ���� ����');

select * from primary_multi;

select * from user_indexes;

