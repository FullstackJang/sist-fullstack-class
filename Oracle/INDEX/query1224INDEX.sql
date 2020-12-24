-- �ε��� ��ȸ
SELECT * FROM USER_INDEXES
WHERE table_name = 'EMP';

-- ������
ALTER INDEX pk_emp REBUILD;
SELECT * FROM CP_EMP4;

-- �ε��� ����
-- cp_emp4���̺� �����ȣ �÷��� �ε����� ����
CREATE UNIQUE INDEX idx_cp_emp4 ON cp_emp4(empno);
SELECT * FROM USER_INDEXES;

-- index hint : /*+ hint */
SELECT /*+ empno */empno, ename, job, mgr
FROM 	 cp_emp4
WHERE  empno = 7902;


-- �ε��� ����
DROP INDEX idx_cp_emp4;
SELECT * FROM USER_INDEXES;

-- ������� NON UNIQUE INDEX�� ����
CREATE INDEX idx_cp_emp4 ON cp_emp4(ename);
SELECT * FROM USER_INDEXES;
SELECT * FROM CP_EMP4;
-- ���� �𸣰� index�� ����ϰ� �ִ� ��
SELECT * FROM cp_emp4
WHERE ename = 'BLAKE';

-- �����ȣ�� �˻�
CREATE TABLE zipcode_idx as (select * from zipcode);

-- gugun�� �ε��� ����
-- �÷��� ���� ���� ���� ���� �� UNIQUE INDEX�� ���� �� ����.
-- Eroor ORA-01452: �ߺ� Ű�� �ֽ��ϴ�. ������ �ε����� �ۼ��� �� �����ϴ�
CREATE UNIQUE INDEX idx_zip ON zipcode_idx( gugun );

-- gugun�� �ߺ��Ǵ� ���� �����Ƿ�  NON UNIQUE INDEX�� �������Ѵ�.
CREATE INDEX idx_zip ON zipcode_idx( gugun );
SELECT * FROM USER_INDEXES;

-- 0.172s
SELECT * FROM zipcode
ORDER BY gugun;

-- 0.157s
-- �ε����� ����Ͽ� ������ ȿ���� ���� ������ �÷��� �ε����� �ο��ϰ� WHERE��(�˻�����)�� "�÷��� > '0'"�� ����ϸ� �ε����� ����� ������ ����
SELECT * FROM zipcode_idx
WHERE gugun > '0';
