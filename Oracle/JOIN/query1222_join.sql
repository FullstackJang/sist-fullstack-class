-- 사원번호, 사원명, 입사일, 부서번호, 부서명, 위치 조회

-- ANSI 틀린 문법
-- SELECT에 deptno와 ON에 deptno가 누구껀지 알 수 없다.
-- 같은 컬럼명이 존재하면 어떤 테이블에 존재하는 컬럼인지 알 수 없기 때문에 에러가 발생
-- "테이블명.컬럼명"으로 컬럼을 식별하도록 만든다.
-- 테이블명이 길다면 테이블에 alias를 붙여 사용하기 편하게 만든다.
		-- 테이블명 alias 별명
-- Error MSG : ORA-00918: 열의 정의가 애매합니다
SELECT empno, ename, hiredate, deptno, dname, loc
FROM		dept
INNER JOIN	emp
ON deptno = deptno;


SELECT empno, ename, hiredate, dept.deptno, dname, loc
FROM		dept
INNER JOIN	emp
ON emp.deptno = dept.deptno;


-- 테이블의 alias를 사용
SELECT e.empno, e.ename, e.hiredate, d.deptno, d.dname, d.loc /*inline view에 deptno컬럼명이 반영 되지 않는다.*/
FROM		dept d
INNER JOIN	emp e
ON e.deptno = d.deptno;



-- Oracle join
-- 사원번호, 사원명, 입사일, 부서번호, 부서명, 위치 조회

SELECT e.empno, e.ename, e.hiredate,e.deptno ,d.deptno, d.dname, d.loc
FROM		dept d, emp e
WHERE		e.deptno = d.deptno;

select * from CAR_COUNTRY;
select * from CAR_MAKER;
select * from CAR_MODEL;

-- 제조국이 '국산'인 모든 차량의 제조사,모델명, 년 식, 가격, 옵션을 조회
-- CAR_COUNTRY:제조국 제조사
-- CAR_MAKER: 제조사,모델명
-- CAR_MODEL: 모델명, 년 식, 가격, 옵션

--  CAR_COUNTRY와 CAR_MAKER의 접점 제조사
-- CAR_MAKER와CAR_MODEL의 접점은 모델명

-- ANSI
SELECT c_cou.maker, c_mak.model, c_mod.car_year, c_mod.price, c_mod.car_option
FROM  	car_country c_cou
INNER JOIN car_maker c_mak
ON c_mak.maker = c_cou.maker
INNER JOIN car_model c_mod
ON		c_mod.model = c_mak.model
WHERE c_cou.country = '국산';


--ORACLE
--SELECT c_cou.maker, c_cma.model, c_mod.car_year, c_mod.price, c_mod.car_option
--FROM car_country c_cout, car_maker c_cma, car_model c_cmo
--WHERE ( c_cma.maker = c_cou.maker and c_cmo.model = c_mod.model ) AND c_cou.country = '국산';

-- 차량의 옵션에 'ABS'가 있는 모든 차량의 '제조국', '제조사', '모델명', '년식', '배기량', '이미지', '입력일'을 조회

SELECT c_cou.country, c_cou.maker, c_cma.model, c_mod.car_year, c_mod.cc, c_mod.car_img, c_mod.hiredate
FROM car_country c_cou, car_maker c_cma, car_model c_mod
WHERE (c_cma.maker=c_cou.maker and c_mod.model = c_cma.model) and c_mod.car_option like '%ABS%' ;


select * from CAR_COUNTRY;
select * from CAR_MAKER;
select * from CAR_MODEL;


select * from emp;
select * from dept;
