SELECT '서울시 마포구' address, 2020 year FROM dual;


------------------- 수치 함수 -------------------

--ABS(절대값)
SELECT abs(-12), abs(12)
FROM dual;


--ROUND(반올림) : round(값, 반올림하여 볼 자릿수 )
-- 실수부는 반올림하여 볼 자릿수를 설정한다.
SELECT ROUND(555.555,2)
FROM dual;

SELECT ROUND(555.554,2) /*555.554는 4값이 반올림 대상이 아니라서 반올림하지 않는다.*/
FROM dual;

-- 정수부는 해당자리에서 반올림한다.
SELECT ROUND(777.777,-1)
FROM dual;

-- 사원 테이블에서 모둔 사원의 사원번호, 사원명, 연봉, 세금을 조회
-- 단, 세금은 소수점 1번째 자리에서 반올림하여 양수부만 출력할 것
SELECT empno, ename, sal, ROUND(sal * 0.033)
FROM emp;

-- CEIL(올림)
SELECT CEIL(10.1), CEIL(10.0001)
FROM dual;

-- FLOOR(내림)
SELECT FLOOR(10.9)
FROM dual;

-- TRUNC(절삭)
-- 실수부는 해당인덱스 다음부터 자른다.
SELECT TRUNC(777.777,2), TRUNC( 777.777,1)
FROM dual;

-- 정수부는 해당인덱스 부터 자른다.
SELECT TRUNC(777.777,-1), TRUNC( 777.777,-2)
FROM dual;


-- 사원테이블에서 모든사원의 사원번호, 사원명, 연봉, 세금을 조회
-- 단, 세금은 연봉에 3.3%로 계산하고, 원단위 절삭하여 조회 출력
SELECT empno, ename, sal, TRUNC(sal*0.033,-1) tax
FROM emp;

-- 나눈 나머지 MOD(값, 나눌 수)
SELECT MOD(10,3) , MOD(2020,12)
FROM dual;



---------------------------- NULL 변환 함수 ----------------------------
SELECT nvl('hello','널'), nvl('','널')
FROM dual;

-- 사원테이블에서 사원번호, 사원명, 입사일, 연봉, 보너스, 총수령액 조회
-- 단, 보너스가 없다면 0으로 출력하고, 총 수령액은 연봉과 보너스를 합산한 금액으로 출력

SELECT empno, ename, hiredate, sal, nvl(comm,0) comm, sal+nvl(comm,0) total_sal
FROM emp;


-- 컬럼의 데이터형과 NULL일 때 출력할 데이터형이 다르다면 Error 발생
-- 사원테이블에서 사원번호, 사원명, 연봉, 보너스를 조회
-- 단, 보너스가 없다면 0을 출력
SELECT empno, ename, sal, nvl(comm,'0원') /*문자열이 숫자형식을 가지고 있으면 오라클이 알아서 형변환을 해준다.*/
FROM emp;

-- 우편번호 테이블에서 '공덕동'인 동을 사용하여, 우편번호, 시도,구군, 동을,번지를 조회
-- 단, 번지가 없다면 '번지없음'을 출력

SELECT zipcode, sido, gugun, dong, nvl(bunji,'번지없음')
FROM zipcode
WHERE dong like '공덕동%';
																

-- NVL2
SELECT NVL2('','값있음','값없음')
FROM dual;

-- 사원테이블에서 사원명, 사원번호, 연봉, 보너스, 인센티브를 조회
-- 단, 인센티브는 보너스가 있다면 일괄 50으로 출력하고, 없다면 100으로 일괄 출력한다.
SELECT ename empno, sal, comm, NVL2(comm,50,100) incen
FROM  emp;


