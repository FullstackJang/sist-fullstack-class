--------------------- 관리자 계정 --------------------
-- 시스템 권한 보기
SELECT * FROM dba_role_privs
where grantee ='SCOTT';

-- 쿼리문 생성권한
SELECT * FROM dba_sys_privs
where grantee ='SCOTT';

--- 시노님 생성
-- cp_emp4 테이블의 시노님(별명)을 ce4로 설정
CREATE SYNONYM ce_4 FOR cp_emp4;

-- 권한 설정 : SYS계정인 관리자가 한다.
GRANT CREATE SYNONYM TO scott;

-- 시노님조회
SELECT * FROM cp_emp4;

SELECT * FROM ce_4;

-- 시노님 삭제
DROP SYNONYM ce_4;

SELECT * FROM USER_OBJECTS;