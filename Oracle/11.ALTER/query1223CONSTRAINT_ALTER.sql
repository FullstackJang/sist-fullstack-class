---------------- 제약사항 --------------------
TRUNCATE TABLE test_alter;

alter table test_alter ADD id VARCHAR2(30) CONSTRAINT pk_test_alter PRIMARY KEY;


-- 제약사항 삭제
	-- PRIMARY KEY 삭제
	ALTER TABLE test_alter DROP CONSTRAINT PK_TEST_ALTER;

	 -- CHECK 삭제
	ALTER TABLE test_alter DROP CONSTRAINT SYS_C008926;

	INSERT INTO test_alter(num, name, addr, age, id)
				VALUES(1,'테스트','서울시',0,'test');


--제약사항 추가 : id 컬럼에 PK제약 추가
ALTER TABLE test_alter ADD CONSTRAINT pk_test_alter
		PRIMARY KEY(id);


INSERT INTO test_alter(num, name, addr, age, id)
				VALUES(2,'테스트2','서울시',0,'test2');

COMMIT;

-- 제약사항이 활성 상태
-- 같은 아이디는 추가할 수 없다.
-- ORA-00001: 무결성 제약 조건(SCOTT.PK_TEST_ALTER)에 위배됩니다
INSERT INTO test_alter(num, name, addr, age, id)
				VALUES(2,'테스트2','서울시',0,'test2');

-- 제약사항 비활성화
	ALTER TABLE test_alter DISABLE CONSTRAINT pk_test_alter;

  INSERT INTO test_alter(num, name, addr, age, id)
				VALUES(2,'테스트3','서울시',0,'test2');


SELECT * FROM test_alter;


-- 제약사항의 활성화
		-- 제약사항에 위배되는 컬럼값이 존재하면 활성화가 안된다.
		-- id컬럼에 중복값이 있는데 pk로 바꾸려고 하니 에러가 발생
		--ErrMsg ORA-02437: (SCOTT.PK_TEST_ALTER)을 검증할 수 없습니다 - 잘못된 기본 키입니다
		ALTER TABLE test_alter ENABLE CONSTRAINT pk_test_alter;

		-- 제약조건에 위배되는 컬럼의 값을 삭제한 후
		DELETE FROM test_alter
		WHERE id='test2';

		--시도
		ALTER TABLE test_alter ENABLE CONSTRAINT pk_test_alter;


		--커밋
		COMMIT;

SELECT * FROM user_constraints
WHERE table_name = 'TEST_ALTER';
