/*
숙제1.
사원테이블에서 부서번호가 10, 30번 부서의 사원을  정보를 조회하여
조회한결과로  emp_work 테이블을 생성합니다.
*/

SELECT empno, ename, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE deptno in (10,30);

CREATE TABLE emp_work(

	empno NUMBER(4),
	ename VARCHAR2(10),
	job		VARCHAR2(9),
	mgr 	NUMBER(4),
	hiredate DATE,
	sal		 NUMBER(7,2),
	comm	 NUMBER(7,2),
	deptno NUMBER(2)
);

INSERT INTO emp_work(empno, ename, job, mgr, hiredate, sal, comm, deptno)
(
		SELECT empno, ename,job, mgr, hiredate, sal, comm, deptno
		FROM emp
		WHERE deptno in (10,30)
);

-- 2-1. 위에서 생성된 테이블의  empno 컬럼명을 emp_no로 변경합니다.
ALTER TABLE emp_work RENAME COLUMN empno TO emp_no;

-- 2-2. 위에서 생성된 테이블의 ename 컬럼을 한글 30자 까지 입력가능하도록
-- 컬럼의 길이를 변경합니다.
ALTER TABLE emp_work MODIFY ename VARCHAR2(90);


--  2-3. 위에서 생성된 테이블에 ename 컬럼을 null을 저장하지 않도록 변경합니다.
ALTER TABLE emp_work MODIFY ename NOT NULL;

-- 2-4. 위에서 생성된 테이블에  empno컬럼에 primary key 제약사항을 설정합니다.
ALTER TABLE emp_work ADD CONSTRAINT pk_emp_no PRIMARY KEY(emp_no);

--  2-5. 위에서 생성된 테이블에 deptno 컬럼에 foreign key 제약사항을 설정합니다.
				--    (부모테이블은 dept)
ALTER TABLE emp_work ADD FOREIGN KEY(deptno) REFERENCES dept(deptno);

select * from user_constraints
where table_name = 'EMP_WORK';
-- 2-6. 위에서 설정된 2-5번 제약을 삭제하세요.
ALTER TABLE emp_work DROP CONSTRAINT SYS_C008933;

-- 2-7. 위에서 설정된 2-4 번 제약을 비활성화 하세요.
ALTER TABLE emp_work DISABLE CONSTRAINT pk_emp_no;

/*3. 관리자계정으로 로그인 하여
    아이디와 비밀번호를 test/test1234인 계정을 생성하고
    접속가능하도록 권한을 설정하세요.*/

-- ALTER session set "_ORACLE_SCRIPT" = TRUE;
-- 계정 생성
ALTER session set "_ORACLE_SCRIPT" = TRUE;
CREATE USER test IDENTIFIED BY 1234;

ALTER session set "_ORACLE_SCRIPT" = TRUE;
GRANT CONNECT TO test;

-- 4. 위의 계정을 삭제 합니다.
DROP USER test;

/*5. user_cons_columns 테이블과  user_constraints을 사용하여
    'EMP'테이블에 설정된 컬럼명, 제약사항타입(constraint_type), 제약사항명을
    조회하세요.
*/


SELECT * FROM  user_cons_columns
WHERE table_name = 'EMP';

SELECT * FROM user_constraints
WHERE table_name = 'EMP';



