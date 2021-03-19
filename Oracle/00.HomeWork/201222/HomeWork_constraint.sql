CREATE TABLE member(

	id	 varchar2(15) constraint pk_id PRIMARY KEY,
	name varchar2(15) NOT NULL,
	age number(2) CHECK(age BETWEEN 20 AND 29),
	gender char(2) CHECK(gender = 'M' or gender = 'F'),
	addr varchar2(200) NOT NULL ,
	email varchar2(50) UNIQUE,
	f_deptno number(2) CONSTRAINT fk_f_deptno REFERENCES dept( deptno )
	ON DELETE CASCADE,
	input_date date DEFAULT SYSDATE

);

-- 추가 성공
-- 아이디: `OK`  , 이름: `OK` , 나이: `OK` ,성별: `'M'` 또는 `'F'`, 주소: `OK` , 이메일: `OK`, 부서번호: `OK` , 입력일: `OK`
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin','장일규',28,'M','인천시 계양구','admin@gmail.com',10,SYSDATE);

-- 아이디: `OK`  , 이름: `OK` , 나이: `OK` ,성별: `'M'` 또는 `'F'`, 주소: `OK` , 이메일: '', 부서번호: `OK` , 입력일: `OK`
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin','장일규',28,'M','인천시 계양구','',10,SYSDATE);


-- 아이디: `OK`  , 이름: `OK` , 나이: `OK` ,성별: `'M'` 또는 `'F'`, 주소: `OK` , 이메일: NULL, 부서번호: `OK` , 입력일: `OK`
INSERT INTO member(id, name, age, gender, addr, f_deptno, input_date)
VALUES('admin','장일규',28,'M','인천시 계양구',10,SYSDATE);

-- 아이디: `OK`  , 이름: `OK` , 나이: `OK` ,성별: `'M'` 또는 `'F'`, 주소: `OK` , 이메일: NULL, 부서번호: `OK` , 입력일: `NO`

INSERT INTO member(id, name, age, gender, addr, email, f_deptno)
VALUES('admin','장일규',28,'M','인천시 계양구','admin@gmail.com',10);

-- =============================================================================================

-- 추가 실패

-- id컬럼이 중복인 경우
-- ORA-00001: 무결성 제약 조건(SCOTT.PK_ID)에 위배됩니다
-- 아래 admin.ryu라는 id로 추가하였다.
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','류수정',23,'F','서울시 강남구','ryu@gmail.com',20,SYSDATE);

-- 그 후에 동일한 id의 다른 컬럼값은 다르지만 'primary key'제약 사항인 중복이 될 수 없는 조건에 걸린다.
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','김여울',25,'F','서울시 강서구','kim@gmail.com',10,SYSDATE);


-- id컬럼이 NULL인 경우
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('','류수정',23,'F','서울시 강남구','ryu@gmail.com',20,SYSDATE);

-- 20~39살 이외에 나이가 입력된 경우
-- age에 10살을 추가하려고 하고 있음
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','류수정',10,'F','서울시 강남구','ryu@gmail.com',20,SYSDATE);

-- age에 40살을 추가하려고 하고 있음
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','류수정',40,'F','서울시 강남구','ryu@gmail.com',20,SYSDATE);


-- gender컬럼에 'M' 또는' F'이외에 값이 들어간 경우
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','류수정',22,'f','서울시 강남구','ryu@gmail.com',20,SYSDATE);

--

INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','류수정',22,'F','서울시 강남구','ryu@gmail.com',50,SYSDATE);


DELETE FROM dept where deptno = 50;

DELETE FROM member where f_deptno = 50;


--ON DELETE CASCADE가 설정되어있어 부모테이블의 레코드를 삭제하면 모든 자식테이블의 모든 레코드가 삭제된다.
DELETE FROM dept WHERE dname = 'SOFT ENGINEER';

select * from dept;
insert into dept(deptno,dname,loc) values (50,'SOFT ENGINEER','INCHEON');


--이메일이 유일하지 않은 경우
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.kim','김민지',26,'F','경기도 수원시','ryu@gmail.com',30,SYSDATE);



select * from member;

drop table member;
purge recyclebin;








select * from user_cons_columns
where table_name = 'MEMBER';
