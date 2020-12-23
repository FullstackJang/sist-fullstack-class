------- �����ڰ��� sqlplus "/as sysdba"����, system/ managerjang

-- C##���� �����ϴ� �����ƴ� ���� ����
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- �������� (����, DMBS�� ����� �� ����.)
CREATE USER jik IDENTIFIED BY 1234;


SELECT * FROM dba_users
WHERE USERNAME = 'JIK';


-- ������ ������ ����, DBMS ��� ����
GRANT CONNECT, RESOURCE TO jik;


SELECT * FROM dba_tablespaces;

-- ������ ������ ����� tablesapce ����
ALTER USER jik DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;

------------------������ �������� ���� ����
CREATE TABLE test(name VARCHAR2(10));

-- ���� ��ȸ
SELECT * FROM dba_users
where username = 'JIK';

-- ���� �ݱ�
ALTER USER jik ACCOUNT LOCK;

-- ���� ����
ALTER USER jik ACCOUNT UNLOCK;

-- �����ڰ����� �ٸ� ������ ����� ������ �� �ִ�.
alter user jik IDENTIFIED BY 1234;

--��������
-- 12c���� _ORACLE_SCRIPT�� ����ؾ��Ѵ�.
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- cascade ���̺��� ������� ������ cascade �ɼ��� ����ؼ� �������Ѵ�.
drop user jik cascade;

-- ���� ȸ��
-- 12c���� _ORACLE_SCRIPT�� ����ؾ��Ѵ�.
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

SELECT * FROM dba_users; -- ������ ������ �ƴ� �Ϲݰ����� ����� �� ����.

REVOKE RESOURCE,CONNECT FROM scott;
-- ERROR:ORA-01045: ����� SCOTT�� CREATE SESSION ������ ���������� ����; �α׿��� �����Ǿ����ϴ�

GRANT CONNECT,RESOURCE TO scott;


SELECT * FROM user_objects;

select * from user_indexes;
