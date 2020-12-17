-------------------------- 조건 함수 ----------------------------

SELECT DECODE(1,1,'일',2,'이',3,'삼', '일치하는 값이 없습니다.')
FROM dual;

-- 부서테이블에서 부서번호, 부서명, 한글 부서명을 조회
-- 단, 한글 부서명은 아래(하기)의 표와 같이 설정합니다.
-- 10번 - 개발부, 20 - 유지보수부, 30 - 영업부 , 40 - 탁구부

SELECT deptno, dname, DECODE(deptno, 10,'개발부', 20, '유지보수부', 30, '영업부','탁구부') kor_dname
FROM dept;


-- 사원테이블에서 사원번호, 사원명, 한글 직무를 조회
-- 단, 한글 직무는 아래의 표와 같이 설정합니다.
-- 'CLERK - 일반사원,'SALESMAN' - 영업사원, 'MANAGER' - 관리사원,
-- 'ANALYST' - 분석가,'PRESIDENT' - 회장님

SELECT  empno, ename, job, DECODE(job, 'CLERK', '일반사원','SALESMAN', '영업사원', 'MANAGER', '관리사원', 'ANALYST' , '분석가','PRESIDENT','회장님')
FROM  emp;

-- 사원테이블에서 사원번호, 사원명, 연봉, 보너스,  부서번호를 조회
-- 단 보너스는 아래의 표와 같이 연봉에 해당 %로 계산하여 출력한다.
-- 10 - 연봉에 10% 20 - 연봉에 15%, 30 - 연봉에 20% 그 외 연봉에 50%

SELECT empno, ename, sal, comm, deptno, TRUNC(DECODE(deptno,10,sal*0.1,20,sal* 0.15,30,sal* 0.2,sal* 0.5)) bonus
FROM  emp;

-- CASE
SELECT CASE 'java' WHEN 'java' THEN '완변한 OOP언어'
									 WHEN	'HTML' THEN 'Markup Language'
									 WHEN 'JavaScript' THEN 'toy Language'
									 else '언어의 정보가 없습니다.'
			 END lang_info
FROM dual;

-- 사원테이블에서 사원번호, 사원명, 부서번호, 부서별 보너스, 직무를 조회
-- 단, 부서별 보너스는 10 - 100, 20 - 400, 30 - 250 그 외는 1000으로 출력
SELECT empno, ename, deptno, case deptno when 10 then 100
																				 when 20 then 400
																				 when 30 then 250
																				 else 1000
														 end dept_bonus,
 														 job
FROM  emp;

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
