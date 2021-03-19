------------------------ unique ------------------------

-- 컬럼단위
CREATE TABLE unique_column (

	name varchar2(30),
	age number(3),
--	email varchar2(50) UNIQUE /*제약사항명이 임의로 만들어진다. ex) SYS_CXXXXX*/
	email VARCHAR2(50) CONSTRAINT uk_email UNIQUE,
	addr VARCHAR2(100)

);

-- 테이블 단위
CREATE TABLE unique_table (

	name VARCHAR2(15),
	phone VARCHAR2(13),
	CONSTRAINT uk_phone UNIQUE( phone )

);

SELECT * FROM USER_CONSTRAINTS;
select * from  foreign_column;


-- 추가
-- 성공

-- 1. 최초데이터 입력
INSERT INTO unique_column(name, age, email, addr) VALUES ('김민수',25,'kim@test.com','서울시 마포구');


-- 2. 이메일이 다른 경우
INSERT INTO unique_column(name, age, email, addr) VALUES ('김민수',25,'lee@test.com','서울시 마포구');

--3. NULL이 입력되는 경우 (UNIQUE는 NULL은 중복이 된다.)
INSERT INTO unique_column(name, age, email, addr) VALUES ('이민지',25,'','서울시 용산구');


select * from unique_column;

-- 실패
-- 같은 이메일이 입력되는 경우
INSERT INTO unique_column(name, age, email, addr) VALUES ('문채원',25,'lee@test.com','서울시 용산구');

