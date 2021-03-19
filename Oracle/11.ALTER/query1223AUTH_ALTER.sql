------- 관리자계정 sqlplus "/as sysdba"접속, system/ managerjang

-- C##으로 시작하는 계정아닌 계정 생성
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- 계정생성 (접속, DMBS를 사용할 수 없다.)
CREATE USER jik IDENTIFIED BY 1234;


SELECT * FROM dba_users
WHERE USERNAME = 'JIK';


-- 생성된 계정에 접속, DBMS 사용 권한
GRANT CONNECT, RESOURCE TO jik;


SELECT * FROM dba_tablespaces;

-- 생성된 계정이 사용할 tablesapce 설정
ALTER USER jik DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;

------------------생성된 계정으로 접속 수행
CREATE TABLE test(name VARCHAR2(10));

-- 계정 조회
SELECT * FROM dba_users
where username = 'JIK';

-- 계정 닫기
ALTER USER jik ACCOUNT LOCK;

-- 계정 열기
ALTER USER jik ACCOUNT UNLOCK;

-- 관리자계정은 다른 계정의 비번을 변경할 수 있다.
alter user jik IDENTIFIED BY 1234;

--계정삭제
-- 12c부터 _ORACLE_SCRIPT를 사용해야한다.
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- cascade 테이블이 만들어져 있으면 cascade 옵션을 사용해서 지워야한다.
drop user jik cascade;

-- 권한 회수
-- 12c부터 _ORACLE_SCRIPT를 사용해야한다.
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

SELECT * FROM dba_users; -- 관리자 계정이 아닌 일반계정은 사용할 수 없다.

REVOKE RESOURCE,CONNECT FROM scott;
-- ERROR:ORA-01045: 사용자 SCOTT는 CREATE SESSION 권한을 가지고있지 않음; 로그온이 거절되었습니다

GRANT CONNECT,RESOURCE TO scott;


SELECT * FROM user_objects;

select * from user_indexes;
