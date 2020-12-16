--- 우편번호 테이블 생성

-- ( 우편번호, 시도, 구군, 동, 번지, SEQ)

CREATE TABLE zipcode (
zipcode char(7), /*우편번호는 전국이 전부 7자리(하이픈포함)*/
sido char(6), /*UTF-8로 되어있어서 한글은 한글자당 1byte*/
gugun varchar2(25),/*구군은 2자~25자까지 있다. 공백은 1byte*/
dong varchar2(300),
bunji varchar2(25),
seq number(5)
);

select * from zipcode;
select count(*) from zipcode;
-- truncate table zipcode;

-- 우편번호 조회 : 상도동 검색
select zipcode, sido, gugun, dong,bunji
from  zipcode
where dong like '효성동%';

