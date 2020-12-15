--1
create table celeb(

	name varchar2(15),
	addr varchar2(150),
	age number(3),
	blood varchar2(2),
	gender char(3), /*한글 '남'or'여' 1자당 3byte*/
	input_date date

);

insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('공유', '경기도 파주시', 26,'A','남',sysdate);
insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('류수정', '서울시 동대문구 동대문동', 24, 'AB','여', sysdate);
insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('차은우', '인천시 미추홀구 미추홀동', 28, 'O','남',sysdate);
insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('차은우이', '서울시 종로구 종로동', 30, 'A', '남', sysdate);
insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('이미주', '수원시 영통구 망포동', 27, 'B', '여', sysdate);

--2
select * from celeb;

--3
update celeb
set    age = 47, addr = '서울시 종로구 경복궁'
where  name = '차은우이';

--4
savepoint work_4;

--5
delete from celeb
where name = '차은우이';

--6
rollback to work_4;

--7
truncate table celeb;

--8
drop table celeb;

--9
show recyclebin;

--10
purge recyclebin;
