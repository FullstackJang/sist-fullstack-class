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


