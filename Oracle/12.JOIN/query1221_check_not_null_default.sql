--- CHECK, NOT NULL, DEFAULT

-- 이름, 성별, 나이, 입력일을 저장하는 테이블
-- 이름 - 필수입력, 성별 - '남자' 또는 '여자'만 입력가능
-- 나이는 null이 입력되면 '0'이 추가
-- 입력일이 생략되면 INSERT하는 시점의 현재 날짜
-- DEFAULT는 제약사항은 아님

CREATE TABLE other_constraint(

	name VARCHAR2(15) NOT NULL,
	address VARCHAR2(100) NULL, /*기본은 NULL을 받겠다고 되어있다. 생략하고 사용했을 뿐*/
	gender CHAR(6) CHECK (gender = '남자' OR gender = '여자'),
	age number(3) default 0,
	input_date date default sysdate

);

-- user_constraints : 테이블에 설정된 제약사항을 확인하는 dictionary.
select * from user_constraints
WHERE table_name = 'OTHER_CONSTRAINT';

-- user_cons_colums : 테이블에 설정된 제약사항컬럼을 확인하는 dictionary
select * from user_cons_columns
where table_name = 'FOREIGN_TABLE';

-- user_tab_cols : 테이블에 존재하는 컬럼명, 데이터형, 크기, default등을 확인 할 수 있는 dic
SELECT * FROM user_tab_cols;

select * from user_tab_cols
where table_name = 'OTHER_CONSTRAINT';



-- 추가
-- 추가 성공

-- 이름 : OK , 주소 : OK , 성별 : '남자' 또는 '여자', 나이 : OK, 입력일 : OK
INSERT INTO other_constraint(name, address, gender, age, input_date) VALUES ('김민석','서울시 서대문구','남자',20, SYSDATE);


-- 이름 : OK , 주소 : NO , 성별 : '남자' 또는 '여자', 나이 : OK, 입력일 : OK
INSERT INTO other_constraint(name, gender, age, input_date) VALUES ('김민지','여자',20, SYSDATE);

-- 이름 : OK , 주소 : NO , 성별 : '남자' 또는 '여자', 나이 : NO, 입력일 : NO
INSERT INTO other_constraint(name, gender) VALUES ('이대호','남자');


select * from other_constraint;


-- 추가 실패

-- 이름이 null이 입력되는 경우
INSERT INTO other_constraint(name, address, gender, age, input_date) VALUES ('','서울시 서대문구','남자',20, SYSDATE);
-- 에러 코드 : ORA-01400: NULL을 ("SCOTT"."OTHER_CONSTRAINT"."NAME") 안에 삽입할 수 없습니다

-- 이름 컬럼을 제외하고 넣는 경우
INSERT INTO other_constraint( address, gender, age, input_date ) VALUES ('서울시 서대문구','남자',20, SYSDATE);
-- 에러 코드 : ORA-01400: NULL을 ("SCOTT"."OTHER_CONSTRAINT"."NAME") 안에 삽입할 수 없습니다

-- 성별이 '남자' OR '여자'가 아닌 경우
INSERT INTO other_constraint(name, address, gender, age, input_date) VALUES ('김민석','서울시 서대문구','남',20, SYSDATE);
-- 에러코드 : ORA-02290: 체크 제약조건(SCOTT.SYS_C008664)이 위배되었습니다
