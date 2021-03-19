-- 여러개의 컬럼이 하나의 Primary key로 구성
-- 번호, 아이템명, 설명,  생산일 20-01-01AM

CREATE TABLE primary_multi(

	num number,
	item varchar2(30),
	info varchar2(4000byte),
	prd_date char(10 byte),

	-- N개의 컬럼이 primary key로 들어갈 수 있다.
	constraint pk_primary_multi primary key( item, prd_date)

);

select * from user_constraints
where constraint_type = 'P';
--where table_name = 'PRIMARY_MULTI';


-- 여러개의 컬럼이 하나의 PK로 구성되면, 모든 컬럼에 동일한 값이 입력되었을 때
-- 제약사항 위배가 된다

--success
-- 최초 입력 시 성공
insert into primary_multi(num,item,info, prd_date) values (1, '마스크', '나를 보호해준다.', '20-12-21AM');

-- 같은 생산물이더라도 날짜가 다르면 입력 가능
insert into primary_multi(num,item,info, prd_date) values (1, '마스크', '나를 보호해준다.', '20-12-21PM');

-- 같은 날짜일지라도 생산물이 다르다면 입력 가능
insert into primary_multi(num,item,info, prd_date) values (3, '황사마스크', '미세 먼지를 차단', '20-12-21AM');

-- Error
-- 같은 날짜에 같은 생산물을 추가되는 경우
insert into primary_multi(num,item,info, prd_date) values (4, '황사마스크', '미세 먼지를 완전 차단', '20-12-21AM');

-- 설정된 PK컬럼쭝 하나라또 null이 추가되는 경우
-- 아이템에 null 추가
insert into primary_multi(num,item,info, prd_date) values (4, '', '미세 먼지를 완전 차단', '20-12-21AM');

-- 생산일에 null 입력
insert into primary_multi(num,item,info) values (4, '황사마스크', '미세 먼지를 완전 차단');

select * from primary_multi;

select * from user_indexes;

