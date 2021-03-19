----------------------------- 변환 함수 ----------------------------------
SELECT sysdate
FROM  dual;

SELECT TO_CHAR(sysdate,'yyyy"년"-mm-d am hh(hh24):mi:ss dy day q "분기"')
FROM dual;

-- 패턴은 대소문자 가리지 않는다.
SELECT TO_CHAR(sysdate,'YYYY"년"-MM-D AM HH(HH24):MI:SS DY DAY Q "분기"')
FROM dual;



-- pattern이 길면 Error가 발생
SELECT  TO_CHAR(SYSDATE,'yyyy " 년 " mm " 월 " dd " 일 " am  hh " 시 "  mi " 분 " ss " 초 " ')
FROM dual;

-- pattern이 길면 TO_CHAR을 두번으로 끊어서 사용하자
SELECT  TO_CHAR(SYSDATE,'yyyy " 년 " mm " 월 " dd " 일 "') || TO_CHAR(SYSDATE,' am  hh " 시 "  mi " 분 " ss " 초 " ')
FROM dual;


-- 사원 테이블에서 사원번호, 사원명, 입사일을 조회
-- 단, 입사일은 월-일-년의 형식으로 출력
SELECT empno, ename, TO_CHAR(hiredate,'mm-dd-yy')
FROM emp;

-- 사원테이블에서 입사년도가 1981년인 사원의 사원번호, 사원명, 연봉
-- 입사일,부서번호를 조회해주세요.
SELECT empno, ename, sal, hiredate, deptno
FROM emp
WHERE TO_CHAR(hiredate, 'yyyy') = '1981';

-- 숫자 변환
-- 0 : 해당 자리에 데이터가 존재하지 않으면 '0'을 출력.
SELECT TO_CHAR(20202,'0,000,000')  , TO_CHAR(2020,'0,000,000.00'),
			TO_CHAR(20202,'0,000')
FROM dual;

-- 9 : 데이터가 존재하는 것만 출력
SELECT TO_CHAR(2020,'9,999,999') , TO_CHAR(20202,'9,999')
FROM dual;

-- 사원 테이블에서 사원번호, 사원명, 입사일, 연봉을 조회
-- 단, 연봉은 3자리를 초과 했을 때만 3자리 마다 ,를 넣어 출력
SELECT empno, ename, hiredate,'[' || TO_CHAR(sal,'9,999') || ']'
FROM emp;

select * from emp;
