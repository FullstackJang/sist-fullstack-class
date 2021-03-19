------------------------- ALTER -----------------------

-- 테이블 조작
CREATE TABLE test_alter(
	num NUMBER,
	neam VARCHAR2(30),
	id  VARCHAR2(20),
	addr NUMBER
);

-- 컬럼명 변경
-- neam -> name
ALTER TABLE test_alter RENAME COLUMN neam TO name;


-- 컬럼의 데이터형 변경
-- 레코드가 존재하지 않을 때에는 데이터형 자체를 변경할 수 있음
-- addr 컬럼의 데이터형을 NUMBER -> VARCHAR2(300)
ALTER TABLE test_alter MODIFY addr VARCHAR2(300);

INSERT INTO test_alter(num, name, id, addr) VALUES (1,'테스트','hong','서울시');

INSERT INTO test_alter(num, name, id, addr) VALUES (2,'테스트','','서울시');

COMMIT;


-- 데이터가 존재하면 동일 데이터형에서 크기만 변경
-- ErrMsg : ORA-01439: 데이터 유형을 변경할 열은 비어 있어야 합니다
ALTER TABLE test_alter MODIFY addr NUMBER;


ALTER TABLE test_alter MODIFY addr VARCHAR2(30);


-- MODIFY로 컬럼단위 제약사항을 추가할 수 있다.
-- 컬럼의 값이 제약사항에 위배되는 값이 있다면 제약사항을 설정할 수 없다.
-- ID에 빈문자열 값이 들어 있다.
-- ErrMsg : ORA-01449: 열이 NULL값을 포함하고 있습니다 NOT NULL로 변경할 수 없습니다
ALTER TABLE test_alter MODIFY id VARCHAR2(30)
			CONSTRAINT pk_test_alter PRIMARY KEY;
-- 제약사황에 위배되는 레코드를 지운다.
DELETE FROM test_alter WHERE num = 2;
COMMIT;


-- 컬럼 삭제
-- id컬럼 삭제(컬럼에 제약사항이 존재하면 제약사항이 삭제된다.)
ALTER TABLE test_alter DROP COLUMN id;

-- 컬럼 추가
-- 컬럼을 추가하면서 "컬럼단위 제약사항"을 함께 추가할 수 있다.
-- 추가된 컬럼은 항상 제일 마지막에 추가된다.
-- 나이 컬럼 추가 나이는 20~40대까지의 나이를 추가할 수 있도록 제약

ALTER TABLE test_alter ADD age NUMBER(3) CHECK(age BETWEEN 20 AND 49);

SELECT * FROM user_constraints
WHERE table_name = 'TEST_ALTER';

-- CHECK 제약 조건에 위배된 값을 추가
-- ErrMsg : ORA-02290: 체크 제약조건(SCOTT.SYS_C008926)이 위배되었습니다
INSERT INTO test_alter(num,name,addr,age)
		VALUES(2,'테스트2','서울시',19);


INSERT INTO test_alter(num,name,addr,age)
		VALUES(2,'테스트2','서울시',20);

select * from test_alter;
