--주석

/*
  edit ( ed ) : SQLPlus에서 제공하는 편집기.
	1. 실행 : edit 경로/파일명.sql
	ed 경로/파일명.sql
	예시) edit c:/dev/query/query1215_1.sql

	2.편집기 안에서 쿼리문 작성.( SQL Schema 작성)
	- 쿼리문은 대소문자를 가리지 않는다.( DBMS에서 대문자로 처리)
	- 쿼리문의 끝에는 ;을 붙인다.

	3. 작성된 쿼리문 실행
	 @경로/파일명.sql
*/


select * from dept;

desc dept;


/*
  테이블 작성.

  학생정보를 저장하는 테이블 생성.
  학번(숫자5), 이름(가변길이형 15), 나이(숫자 2), 이메일(가변길이형 50자), 전화번호(가변길이형 13), 주소(가변길이형 200자)(한글은 3바이트라 200이면 60자들어감), 주민번호(고정길이형 14), 반(고정길이형 1), 입력일(날짜)

*/

-- 계정의 테이블명은 유일하다. : 테이블명이나 컬럼명이 두 단어로 이루어질 때에는 '_'로 구분한다.
create table student(
		num number(5),
		name varchar2(13),
		age number(2),
		email varchar2(50),
		phone varchar2(13),
		addr varchar2(200),
		ssn char(14),
		class char(1),
		input_Date date

);

-- 테이블의 구조보기 : desc 테이블명
desc student;

-- 계정이 가지고 있는 테이블에 목록 조회.
-- select * from tab;
-- tab는 DBMS에서 제공하는 테이블로 DataDictionary라고 한다.
select * from tab;

/*
  	생성된 테이블에 record를 추가.
*/

-- 컬럼명을 생략하여 추가.(컬럼에 값이 제대로 들어갔는지 알기 어렵다.)

insert into student values(1, '류수정', 23, 'ryu@daum.net', '010-1234-5678','서울시 마포구','970101-1234567','A',sysdate);

insert into student values(2, '케이', 26, '010-4356-8771', 'key@test.com','서울시 마포구','960102-1234567','A',sysdate);

/*
	모든 레코드 조회
*/

select * from student;


-- 컬럼명을 명시하여 추가. (입력되는 값이 어떤 컬럼으로 추가되는지 알 수있다.)

insert into student(NUM, NAME, AGE, EMAIL, PHONE, ADDR, SSN, CLASS, INPUTDATE) values(3,'이미주',26,'lee@sist.co.kr','010-9767-8891','서울시 서대문구', '951111-2345678','A',sysdate);


-- 컬럼명을 명시하면 테이블의 컬럼순서에 상관 없이 값을 insert 할 수 있다.
insert into student(NAME, AGE,NUM,INPUTDATE, EMAIL, PHONE,CLASS, ADDR, SSN) values('정예인',26,4,sysdate,'jung@test.com','010-6783-0091','A','경기도 수원시 영통구','911215-2345678');


select * from student;

-- 커럼명이 생략되면 해당 컬럼에는 null이 입력된다.
insert into student(NUM, NAME, PHONE) values (5, '서지수', '010-5476-3340');

commit;

insert into student(NUM, NAME, PHONE) values (6, '유지애', '010-1111-2222');

-- select * from STUDENT;

/*
	검색(조회) : 모든 레코드의 특정 컬럼을 검색.
*/

-- 학생테이블에서 번호, 이름, 이메일, 주소를 검색(조회).

select num, name, email,phone, addr
from student;

-- 학생테이블에서 이름이 '케이'인 학상의 이메일을 'key@test.com'으로 변경해주세요.
update student
set email = 'key@test.com'
where name ='케이';

select * from student;

-- 학생테이블에서 학생의 번호가 '2'번인 학생의 전화번호를 '010-2222-2222'로 나이를 27로 변경 해주세요.
update student
set phone = '010-2222-2222', age = 27
where num = 2;

select * from student;

-- 'A'강의장의 학생 나이를 모두 27세로 변경해라
update student
set   age = 30
where class = 'A';

commit;

-- 학생테이블에서 학번이 4번이며 반이 'a'강의장인 학생의 나이를 25세로 주소를 '서울시 강서구', 입력일을 쿼리문이 실행된 시간으로 변경해라
update student
set age = 25, addr='서울시 강서구', inputdate=sysdate
where num=4 AND class='A';


select * from student;

-- rollback; -- commit된 후에 데이터는 다시 안돌아간다.

commit; --메모리에 있는 데이터를 HDD에 전달하고  현재 접속되어있는 다른 사람들의 데이터에도 적용 받을 때


-- 레코드 삭제
-- 전체 레코드를 삭제해 보자.
delete from student;

rollback;

select * from student;

-- 학생테이블에서 번호가 1번인 학생의 레코드를 삭제
delete
from	 student
where 	num=1;


select * from student;
rollback;


-- truncate
truncate table student;


select * from student;
