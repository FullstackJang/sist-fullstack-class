CREATE TABLE member(

	id	 varchar2(15) constraint pk_id PRIMARY KEY,
	name varchar2(15) NOT NULL,
	age number(2) CHECK(age BETWEEN 20 AND 29),
	gender char(2) CHECK(gender = 'M' or gender = 'F'),
	addr varchar2(200) NOT NULL ,
	email varchar2(50) UNIQUE,
	f_deptno number(2) CONSTRAINT fk_f_deptno REFERENCES dept( deptno )
	ON DELETE CASCADE,
	input_date date DEFAULT SYSDATE

);

-- �߰� ����
-- ���̵�: `OK`  , �̸�: `OK` , ����: `OK` ,����: `'M'` �Ǵ� `'F'`, �ּ�: `OK` , �̸���: `OK`, �μ���ȣ: `OK` , �Է���: `OK`
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin','���ϱ�',28,'M','��õ�� ��籸','admin@gmail.com',10,SYSDATE);

-- ���̵�: `OK`  , �̸�: `OK` , ����: `OK` ,����: `'M'` �Ǵ� `'F'`, �ּ�: `OK` , �̸���: '', �μ���ȣ: `OK` , �Է���: `OK`
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin','���ϱ�',28,'M','��õ�� ��籸','',10,SYSDATE);


-- ���̵�: `OK`  , �̸�: `OK` , ����: `OK` ,����: `'M'` �Ǵ� `'F'`, �ּ�: `OK` , �̸���: NULL, �μ���ȣ: `OK` , �Է���: `OK`
INSERT INTO member(id, name, age, gender, addr, f_deptno, input_date)
VALUES('admin','���ϱ�',28,'M','��õ�� ��籸',10,SYSDATE);

-- ���̵�: `OK`  , �̸�: `OK` , ����: `OK` ,����: `'M'` �Ǵ� `'F'`, �ּ�: `OK` , �̸���: NULL, �μ���ȣ: `OK` , �Է���: `NO`

INSERT INTO member(id, name, age, gender, addr, email, f_deptno)
VALUES('admin','���ϱ�',28,'M','��õ�� ��籸','admin@gmail.com',10);

-- =============================================================================================

-- �߰� ����

-- id�÷��� �ߺ��� ���
-- ORA-00001: ���Ἲ ���� ����(SCOTT.PK_ID)�� ����˴ϴ�
-- �Ʒ� admin.ryu��� id�� �߰��Ͽ���.
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','������',23,'F','����� ������','ryu@gmail.com',20,SYSDATE);

-- �� �Ŀ� ������ id�� �ٸ� �÷����� �ٸ����� 'primary key'���� ������ �ߺ��� �� �� ���� ���ǿ� �ɸ���.
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','�迩��',25,'F','����� ������','kim@gmail.com',10,SYSDATE);


-- id�÷��� NULL�� ���
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('','������',23,'F','����� ������','ryu@gmail.com',20,SYSDATE);

-- 20~39�� �̿ܿ� ���̰� �Էµ� ���
-- age�� 10���� �߰��Ϸ��� �ϰ� ����
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','������',10,'F','����� ������','ryu@gmail.com',20,SYSDATE);

-- age�� 40���� �߰��Ϸ��� �ϰ� ����
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','������',40,'F','����� ������','ryu@gmail.com',20,SYSDATE);


-- gender�÷��� 'M' �Ǵ�' F'�̿ܿ� ���� �� ���
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','������',22,'f','����� ������','ryu@gmail.com',20,SYSDATE);

--

INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','������',22,'F','����� ������','ryu@gmail.com',50,SYSDATE);


DELETE FROM dept where deptno = 50;

DELETE FROM member where f_deptno = 50;


--ON DELETE CASCADE�� �����Ǿ��־� �θ����̺��� ���ڵ带 �����ϸ� ��� �ڽ����̺��� ��� ���ڵ尡 �����ȴ�.
DELETE FROM dept WHERE dname = 'SOFT ENGINEER';

select * from dept;
insert into dept(deptno,dname,loc) values (50,'SOFT ENGINEER','INCHEON');


--�̸����� �������� ���� ���
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.kim','�����',26,'F','��⵵ ������','ryu@gmail.com',30,SYSDATE);



select * from member;

drop table member;
purge recyclebin;








select * from user_cons_columns
where table_name = 'MEMBER';
