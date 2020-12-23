CREATE TABLE test(num number, name VARCHAR2(30));

INSERT INTO test(num,name)VALUES(1,'류수정');
COMMIT;

-- SEQUENCE는 쿼리문이 실패하면 해당 번호가 날라갈 수 있다 따라서
-- 정확한 순차적인 번호를 나타내야할 때는 서브쿼리를 사용해야한다.

SELECT * FROM TEST;
-- TEST테이블에 아래의 레코드를 추가하세요
-- 번호는 이전에 들어가 있는 번호 다음 번호로 추가되어야한다.
INSERT INTO test(num, name)VALUES((SELECT MAX(num)+1 FROM test),'김지민');
INSERT INTO test(num, name)VALUES((SELECT MAX(num)+1 FROM test),'최을');
INSERT INTO test(num, name)VALUES((SELECT MAX(num)+1 FROM test),'최민지');
INSERT INTO test(num, name)VALUES((SELECT MAX(num)+1 FROM test),'김민');

SELECT * FROM TEST;


---------------------- SEQUENCE -------------------------

------- SEQUENCE
SELECT * FROM user_sequences;

CREATE SEQUENCE test_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999;

-- 간접 실행
-- 쿼리문에 넣어서 사용하는 것
-- CURRVAL은 메모리에 올라와있는 시퀀스의 현재값을 얻는일만 수행
-- ORA-08002: 시퀀스 TEST_SEQ.CURRVAL은 이 세션에서는 정의 되어 있지 않습니다
SELECT test_seq.CURRVAL
FROM dual;

-- NEXTVAL
select test_seq.NEXTVAL
from dual;

DROP SEQUENCE test_seq;

-- 1~9999999999 까지 10씩 증가하는 시퀀스
CREATE SEQUENCE seq_test
INCREMENT BY 10
START WITH 1
MAXVALUE 999999999
CACHE 100
CYCLE;

SELECT seq_test.NEXTVAL
FROM DUAL;

DROP SEQUENCE seq_test;

SELECT * FROM user_sequences;

-- 쿼리문이 실패하면 번호가 사라진다.

-- 이름을 한글 5자까지만 입력가능하도록 변경
ALTER TABLE test MODIFY name varchar2(15);

INSERT INTO test(num,name) VALUES( test_seq.NEXTVAL , '테스트');
                        -- test_seq.NEXTVAL 바깥 쿼리가 실패하더라도 1씩 증가된다. 
SELECT * FROM test;
