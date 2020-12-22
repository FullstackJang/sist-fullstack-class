-- foreign key (외래키, 참조키)
-- primary_column 테이블의 id컬럼을 참조하는 자식테이블 생성

-- column 단위 제약사항 : 컬럼명 데이터형(크기) constraint 제약사항명 references 참조할테이블명(컬럼명)
-- 자식테이블의 컬럼명은 부모테이블의 컬럼명과 같지 않아도 된다.

CREATE TABLE foreign_column (
  f_id varchar2(20) constraint fk_f_id references primary_column( id ),
  email varchar2(50),
  age number(3),
  input_date date
);


-- table단위 제약사항
-- primary_table테이블의 ssn컬럼을 참조키로 설정

CREATE TABLE foreign_table (

	ssn CHAR(14),
	age NUMBER(3),
--	CONSTRAINT fk_ssn foreign key(ssn) references primary_table(ssn)
	CONSTRAINT fk_ssn foreign key(ssn) references primary_table(ssn)
 	ON DELETE CASCADE
);


---- 다른 테이블에 일반컬럼은 Foreign key로 참조할 수 없다.
--  우편번호 테이블의 seq를 참조

CREATE TABLE test(
																									-- seq가 Primary key가 아니라는 뜻
	seq NUMBER(5) CONSTRAINT fk_seq references zipcode( seq )


);

select * from user_constraints
where table_name = 'FOREIGN_TABLE';


insert into primary_column(name, id, addr) values ('류수정', 'ryu','서울시');
insert into primary_column(name, id, addr) values ('김민수', 'kim','서울시');
commit;
-- foreign key 생성 추가
-- 추가 성공

-- 1. 부모 테이블에서 존재하는 값으로 컬럼값을 추가할 때
insert into foreign_column(f_id, email, age, input_date) values ('kim','kim@test.com',20,sysdate);

-- 2. 부모테이블에 존재하는 값이라면 몇개든 추가할 수 있다.
insert into foreign_column(f_id, email, age, input_date) values ('kim','kim11111@test.com',25,sysdate);

insert into foreign_column(f_id, email, age, input_date) values ('ryu','ryu@test.com',21,sysdate);

-- 3 null을 추가하는 경우
insert into foreign_column( email, age, input_date) values ('null@test.com',21,sysdate);

insert into foreign_column( email, age, input_date) values ('null1@test.com',21,sysdate);


-- foreign key 생성 실패
-- 추가 실패
--1. 부모 테이블에 존재하지 않는 값으로 추가할 때
insert into foreign_column(f_id, email, age, input_date) values ('ryu1','ryu@test.com',21,sysdate);


-- 레코드 삭제
-- foreign key 제약사항에 on delete cascade가 사용되지 않았다면 자식테이블의 레코드를 삭제한 후 부모테이블의 레코드를 삭제할 수 있다.
select * from foreign_column;
select * from primary_column;

-- 부모테이블에서 참조하고 있지 않은 레코드 삭제( 바로 삭제가 됨 )
delete from primary_column where id = 'test';


-- 부모테이블에서 참조하고 있는 자식레코드가 존재할 때 삭제
delete from primary_column where id = 'kim'; /*kim과 ryu는 자식레코드가 존재하므로 삭제할 수 없다.*/


-- 자식테이블에 참조하는 레코드를 지운 후 부모테이블의 레코드를 삭제한다.
--1. 자식 레코드를 삭제한 후
DELETE FROM foreign_column where f_id ='ryu';

--2. 부모 레코드를 삭제한다.
DELETE FROM primary_column where id ='ryu';

select * from foreign_column;
select * from primary_column;

-- 부모테이블에 레코드가 삭제 되면 자동으로 자식 테이블의 모든 레코드를 동시에 삭제
INSERT INTO foreign_table(ssn, age) VALUES ('880101-1234567',20);
INSERT INTO foreign_table(ssn, age) VALUES ('880101-1234567',21);
INSERT INTO foreign_table(ssn, age) VALUES ('880101-1234568',21);
COMMIT;
SELECT * FROM  foreign_table;
SELECT * FROM  primary_table;


-- ON DELETE CASCADE가 설정되어있어 부모테이블의 레코드를 삭제하면 모든 자식테이블의 모든 레코드가 삭제된다.
DELETE FROM primary_table WHERE ssn ='880101-1234567';
