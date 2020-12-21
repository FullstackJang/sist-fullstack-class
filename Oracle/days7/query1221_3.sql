---------------------constraints ---------------------
-- Primary Key
-- 이름, 아이디,주소를 저장할 수 있는 테이블 생성
-- 컬럼단위 제약사항
-- 제약사항명을 설정하지 않으면 Oracle에서 제약사항명을 자동으로 부여 SYS_Cxxxx
CREATE TABLE primary_column(

	name varchar2(15),
	id varchar2(20) constraint pk_primary_coulmn primary key,
	addr varchar2(300)
);


drop table primary_column;
purge recyclebin;
select * from user_indexes;
select * from user_constraints;

insert into primary_column(name,id, addr) values('테스트','test','테스트');

commit;

-- 테이블단위 제약사항
-- 번호, 이름, 주민번호를 저장하는 테이블

CREATE TABLE primary_table(

	num number,
	name varchar2(30), /*가변길이는 크기를 주지 않으면 0으로 들어간다.*/
	ssn char(14),

	constraint pk_primary_table primary key(ssn)

);

-- primary_table 값 추가 성공하는 경우

-- 최초입력
insert into primary_table(num,name,ssn) values(1,'테스트1','880101-1234567');


-- 주민번호가 다르다면 추가 성공
insert into primary_table(num,name,ssn) values(1,'테스트1','880101-1234568');

commit;

-- primary_table 에러 나는 경우
-- 같은 주민번호가 입력될 때
insert into primary_table(num,name,ssn) values(1,'테스트1','880101-1234568');

-- null이 입력될 때

-- 숫자, 날짜는 한가지 상황에서만 null이 발생
	-- INSERT(추가)할 때 컬럼을 생략하는 경우
-- 컬럼을 생략하는 경우
insert into primary_table(num,name) values(1,'테스트3');


-- 문자열
		-- 추가할 때 컬럼을 생략하거나, 컬럼을 명시하고 ''를 넣는 경우
-- 컬럼을 정의하고 ''를 넣는 경우
insert into primary_table(num,name) values(1,'');

select num,name,ssn from primary_table;
