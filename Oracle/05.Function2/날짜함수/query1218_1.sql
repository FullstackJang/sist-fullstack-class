-----------------------------날짜 함수 ---------------------------
-- 날짜에 + 연산을 사용하면 현재 날짜에서 하루씩 증가하는 날을 얻을 수 있다.
-- 날짜에 - 연산을 사용하면 현재 날짜에서 하루씩 감소하는 날을 얻을 수 있다.

SELECT sysdate, sysdate + 4, sysdate -2
FROM dual;


-- 월 연산
SELECT	SYSDATE, ADD_MONTHS(SYSDATE,1), ADD_MONTHS(SYSDATE, 2)
FROM	dual;

-- 두 개월간 차이
SELECT TRUNC(MONTHS_BETWEEN('2021-4-21',SYSDATE))
FROM dual;

SELECT  ename, TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)) after_hiredate , hiredate
FROM emp;

SELECT MONTHS_BETWEEN(SYSDATE,'1993-7-14') /12
FROM dual;


-- 마지막날 구하기 last_day(현재 날짜)
SELECT SYSDATE, LAST_DAY(SYSDATE), LAST_DAY('2021-02-01')
FROM   dual;
