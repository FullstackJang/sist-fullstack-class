--------------------- ������ ���� --------------------
-- �ý��� ���� ����
SELECT * FROM dba_role_privs
where grantee ='SCOTT';

-- ������ ��������
SELECT * FROM dba_sys_privs
where grantee ='SCOTT';

--- �ó�� ����
-- cp_emp4 ���̺��� �ó��(����)�� ce4�� ����
CREATE SYNONYM ce_4 FOR cp_emp4;

-- ���� ���� : SYS������ �����ڰ� �Ѵ�.
GRANT CREATE SYNONYM TO scott;

-- �ó����ȸ
SELECT * FROM cp_emp4;

SELECT * FROM ce_4;

-- �ó�� ����
DROP SYNONYM ce_4;

SELECT * FROM USER_OBJECTS;