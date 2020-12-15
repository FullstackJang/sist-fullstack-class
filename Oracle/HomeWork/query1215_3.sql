--1
create table celeb(

	name varchar2(15),
	addr varchar2(150),
	age number(3),
	blood varchar2(2),
	gender char(3), /*�ѱ� '��'or'��' 1�ڴ� 3byte*/
	input_date date

);

insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('����', '��⵵ ���ֽ�', 26,'A','��',sysdate);
insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('������', '����� ���빮�� ���빮��', 24, 'AB','��', sysdate);
insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('������', '��õ�� ����Ȧ�� ����Ȧ��', 28, 'O','��',sysdate);
insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('��������', '����� ���α� ���ε�', 30, 'A', '��', sysdate);
insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('�̹���', '������ ���뱸 ������', 27, 'B', '��', sysdate);

--2
select * from celeb;

--3
update celeb
set    age = 47, addr = '����� ���α� �溹��'
where  name = '��������';

--4
savepoint work_4;

--5
delete from celeb
where name = '��������';

--6
rollback to work_4;

--7
truncate table celeb;

--8
drop table celeb;

--9
show recyclebin;

--10
purge recyclebin;
