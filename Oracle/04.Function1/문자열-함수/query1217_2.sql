--------------------- 문자열 함수 ---------------------

-- 길이
SELECT length('오늘은 목요일 입니다.')
FROM dual;

-- WHERE절에서 사용할 수 있다.
-- 사원테이블에서 사원명이 4글자인 사원의 사원명, 사원명의 글자수, 사원번호, 입사일 조회

SELECT ename, length(ename), empno, hiredate
FROM emp
WHERE length(ename)=4;


-- 문자열합치기
SELECT concat('오늘은','목요일') , '오늘은' || '목요일'
FROM dual;


-- 첫 글자를 대문자로 변환
SELECT INITCAP('hello'), INITCAP('HELLO'), INITCAP('i am a boy')
FROM dual;

SELECT INITCAP(ename), INITCAP(job)
FROM emp;

-- 대문자, 소문자 변환
SELECT UPPER('AbcdEf'), LOWER('AbcdeF')
FROM dual;


-- 사원 테이블에서 사원명이 'scott'인 사원의 사원번호, 사원명, 연봉, 보너스, 매니저번호를 조회
SELECT empno, ename, sal, comm, mgr
FROM emp
WHERE ename = UPPER('scott');
--WHERE LOWER(ename) = 'scott';

-- 인덱스 얻기
SELECT INSTR('AbcdE','A'), INSTR('AbcdE','B')
FROM dual;

-- 사원테이블에서 사원명에 'A'가 있는 사원의 사원명을 조회

SELECT ename
FROM   emp
WHERE instr(ename,'A') <> 0;

-- 글자 자르기  SUBSTR(문자열, 시작인덱스, 자를 글자수)
SELECT SUBSTR('AbcdeF',2,4), SUBSTR('AbcdeF',3,1), SUBSTR('AbcdeF',4,3)
FROM dual;

-- 학생테이블에서 이름,이메일, 이메일주소, 도메인 주소 조회
SELECT name, email, SUBSTR(email,1,instr(email,'@')-1), SUBSTR(email,instr(email,'@')+1)
FROM student;

-- 문자열 치환
-- 모든 공백을 제거할때는 REPLACE를 사용한다.
SELECT REPLACE('오늘은 금요일 입니다.','오늘은','내일은'), REPLACE('java','a','AAAA'), REPLACE('   A BC   ',' ','')
FROM dual;


-- 공백 제거

-- 앞뒤 공백 제거 TRIM()
-- 앞 공백 제거  LTRIM()
-- 뒷 공백 제거  RTRIM()
-- TRIM은 문자열 앞뒤에 특정 문자열이 감싸여 있다면 해당 문자열을 삭제할 수 있다. TRIM(' 지울 문자열' FROM 컬럼명)
SELECT '[' || TRIM('   A BC   ') || ']' ,  '[' || LTRIM('   A BC   ') || ']' ,'[' || RTRIM('   A BC   ') || ']'
,TRIM('a' FROM'aaaaaaaaaaaaaOracleaaaaaaaaaaa')
FROM dual;

-- 문자열을 채워서 같은 길이의 문자열을 만들 때
-- 왼쪽으로(문자열의 앞에)  채울 때 LPAD, 오른쪽으로(문자열의 뒤) 채울 때 RPAD

SELECT LPAD('ABcd',10, '#'), LPAD('ABcd',10, '가'),
			 RPAD('ABcd',10, '#'), RPAD('ABcd',10, '가')
FROM dual;


-- 숫자가 총 12자로 구성되고 12자가 아니라면 앞에 0을 채워 넣어 12자로 만든 후 해당 숫자 앞에 SIST_ 문자열을 붙여 SIST_000000000001 의 형식으로 출력해보세요.
SELECT CONCAT('SIST_',LPAD(1,12,0)) num
FROM dual;

SELECT CONCAT('IT_',LPAD(seq,5,0))
FROM zipcode
WHERE seq < 100;

select * from student;
