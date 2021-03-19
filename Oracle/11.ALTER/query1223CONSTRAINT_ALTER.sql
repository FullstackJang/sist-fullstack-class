---------------- ������� --------------------
TRUNCATE TABLE test_alter;

alter table test_alter ADD id VARCHAR2(30) CONSTRAINT pk_test_alter PRIMARY KEY;


-- ������� ����
	-- PRIMARY KEY ����
	ALTER TABLE test_alter DROP CONSTRAINT PK_TEST_ALTER;

	 -- CHECK ����
	ALTER TABLE test_alter DROP CONSTRAINT SYS_C008926;

	INSERT INTO test_alter(num, name, addr, age, id)
				VALUES(1,'�׽�Ʈ','�����',0,'test');


--������� �߰� : id �÷��� PK���� �߰�
ALTER TABLE test_alter ADD CONSTRAINT pk_test_alter
		PRIMARY KEY(id);


INSERT INTO test_alter(num, name, addr, age, id)
				VALUES(2,'�׽�Ʈ2','�����',0,'test2');

COMMIT;

-- ��������� Ȱ�� ����
-- ���� ���̵�� �߰��� �� ����.
-- ORA-00001: ���Ἲ ���� ����(SCOTT.PK_TEST_ALTER)�� ����˴ϴ�
INSERT INTO test_alter(num, name, addr, age, id)
				VALUES(2,'�׽�Ʈ2','�����',0,'test2');

-- ������� ��Ȱ��ȭ
	ALTER TABLE test_alter DISABLE CONSTRAINT pk_test_alter;

  INSERT INTO test_alter(num, name, addr, age, id)
				VALUES(2,'�׽�Ʈ3','�����',0,'test2');


SELECT * FROM test_alter;


-- ��������� Ȱ��ȭ
		-- ������׿� ����Ǵ� �÷����� �����ϸ� Ȱ��ȭ�� �ȵȴ�.
		-- id�÷��� �ߺ����� �ִµ� pk�� �ٲٷ��� �ϴ� ������ �߻�
		--ErrMsg ORA-02437: (SCOTT.PK_TEST_ALTER)�� ������ �� �����ϴ� - �߸��� �⺻ Ű�Դϴ�
		ALTER TABLE test_alter ENABLE CONSTRAINT pk_test_alter;

		-- �������ǿ� ����Ǵ� �÷��� ���� ������ ��
		DELETE FROM test_alter
		WHERE id='test2';

		--�õ�
		ALTER TABLE test_alter ENABLE CONSTRAINT pk_test_alter;


		--Ŀ��
		COMMIT;

SELECT * FROM user_constraints
WHERE table_name = 'TEST_ALTER';
