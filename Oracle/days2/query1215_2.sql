-- rollback

commit;

insert into student (num, name) values (1, '�׽�Ʈ');

update student
set name='�׽�Ʈ1';
where name='�׽�Ʈ';

rollback;

select * from student;


-- savepoint : rollback���� ���ϴ� �������� ����� ��.
savepoint insert_a;

insert into student(num,name,addr) values(1,'������','����� ������ ������');

savepoint update_b;

update student
set addr='����� ������ ���ﵿ', age =20
where num =1;

savepoint delete_c;

delete from student
where num=1;

select * from student;

-- commit;
--rollback; /*���� commit ���ı��� �۾��� ��ҵȴ�.*/

rollback to insert_a; /*���������� �۾��� ��ҵȴ�. `commit`�Ǹ� ������ ��ü�� ������Ƿ� `rollback to ��������`�� ����� �� ����. */

--���̺� ���� : ���ڵ��� ������ ������� ���̺��� �����ȴ�.
drop table student;

select * from tab;

-- �����뿡 ������ ���̺�Ȯ��

-- ���̺���
flashback table student to before drop;


-- ������ ����
purge recyclebin;

