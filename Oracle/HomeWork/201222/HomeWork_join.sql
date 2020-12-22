
/*숙제 4.  사원테이블에서  사원명이 'ADAMS' 인 사원보다 연봉을 많이 받는
    사원의 사원번호, 사원명, 연봉,부서번호,부서명,위치,우편번호,시도,구군,
    차량모델명, 연식,가격,옵션, 입력일을 조회하세요.
  단. 우편번호의 seq와 차량의 연식을 조인 조건으로 사용하여 조인할 것.
    차량 모델명을 내림차순으로 정렬하고, 차량모델이 같다면 년식의
     내림차순으로 정렬하여 1~4번째 레코드만 출력합니다.*/
--SELECT * FROM CAR_COUNTRY;
--SELECT * FROM CAR_MAKER;
--SELECT * FROM CAR_MODEL;

-- =================

/*현대, 기아, BMW, BENZ인 모든 차량의 제조국, 제조사
 모델명, 옵션, 연식,입력일을 조회하세요.
단, 입력일의 내림차순으로 정렬했을 때 3~5번째 레코드만 출력하고,
    옵션은 첫번째',' 까지만 출력합니다.
    입력일은 'mm-dd-yyyy' 의 형식으로 출력합니다.*/

SELECT * FROM CAR_COUNTRY;
SELECT * FROM CAR_MAKER;
SELECT * FROM CAR_MODEL;

SELECT c_cou.country, c_cou.maker, c_mak.model, substr(c_mod.car_option,1,instr(c_mod.car_option,',')-1), c_mod.car_year, TO_CHAR(hiredate,'mm-dd-yyyy')
FROM car_country c_cou LEFT OUTER JOIN car_maker c_mak
ON c_cou.maker = c_mak.maker
LEFT OUTER JOIN car_model c_mod
ON c_mak.model = c_mod.model
WHERE c_cou.maker IN ('현대','기아','BMW','BENZ')
ORDER BY hiredate desc;

/*숙제2. 차량옵션에 'ABS' 기능이 있는 차량의 제조국, 제조사,모델명,
    연식, 가격, 입력일, 이미지명을 조회하세요.
  단, 가격의 오름차순으로 정렬하되 가격이 같다면 연식의 내림차순으로
    정렬했을 때 2~7번째 레코드만 출력합니다.
    연식과 가격에는 3자리 마다 ','를 넣어 출력하고, 옵션은 'ABS' 까지만
    출력합니다. 이미지명은 처음 '.'까지만 출력합니다.
    옵션과 이미지명은 모두 대문자로 출력합니다. */

SELECT * FROM CAR_COUNTRY;
SELECT * FROM CAR_MAKER;
SELECT * FROM CAR_MODEL;

SELECT c_cou.country, c_cou.maker, c_mod.model, c_mod.car_year,c_mod.price, c_mod.hiredate,c_mod.car_img
FROM car_country c_cou LEFT OUTER JOIN car_maker c_mak
ON c_cou.maker = c_mak.maker
LEFT OUTER JOIN car_model c_mod
ON c_mak.model = c_mod.model
WHERE c_mod.car_option  LIKE '%ABS%'
ORDER BY c_mod.price asc, car_year desc;


SELECT rnum, c_cou_country, c_cou_maker, c_mod_model, c_mod_car_year,c_mod_price, c_mod_hiredate,c_mod_car_img, c_mod_car_option
FROM (SELECT ROWNUM rnum, c_cou_country, c_cou_maker, c_mod_model, c_mod_car_year,c_mod_price, c_mod_hiredate,c_mod_car_img, c_mod_car_option
FROM (SELECT c_cou.country AS  c_cou_country, c_cou.maker AS c_cou_maker, c_mod.model AS c_mod_model, TO_CHAR(c_mod.car_year,'999,999') AS c_mod_car_year , TO_CHAR(c_mod.price,'999,999') AS c_mod_price , c_mod.hiredate AS c_mod_hiredate  , UPPER(SUBSTR(c_mod.car_img,1,INSTR(c_mod.car_img,'.')-1)) AS c_mod_car_img, UPPER(substr(c_mod.car_option,1,instr(c_mod.car_option,'ABS')+2)) AS c_mod_car_option
FROM car_country c_cou LEFT OUTER JOIN car_maker c_mak
ON c_cou.maker = c_mak.maker
LEFT OUTER JOIN car_model c_mod
ON c_mak.model = c_mod.model
WHERE c_mod.car_option  LIKE '%ABS%'
ORDER BY c_mod.price asc, car_year desc))
WHERE rnum BETWEEN 2 AND 7;


/*
숙제3. 사원번호,사원명,연봉, 보너스, 실수령액, 입사일,부서번호,부서명, 위치,
        우편번호,시도,구군,동, 번지를 조회하세요.
   단. 사원명을 오름차순으로 정렬했을 때 3~6번째 레코드만 출력합니다.
        사원명은 첫글자만 대문자로 출력합니다.
       연봉은 전체 7자리로 맞춰 ','를 넣어 출력하되 7자리가 되지 않는 연봉은
       0을 넣어 출력하세요.
       우편번호는 '-'뒤로 부터만 출력합니다.
        번지가 없다면 '번지없음'을 출력합니다.
*/


SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM ZIPCODE;


SELECT ROWNUM rnum, e_empno, e_ename, e_sal, Total_money, e_hiredate, d_deptno, d_dname, d_loc, z_zipcode, z_sido, z_gugun, z_dong, z_bunji
FROM (SELECT e.empno AS e_empno, e.ename AS e_ename, e.sal AS e_sal, TRUNC(e.sal - e.sal*0.033,-1) AS Total_Money, e.hiredate AS e_hiredate, d.deptno AS d_deptno,d.dname AS d_dname,d.loc AS d_loc,
z.zipcode AS z_zipcode , z.sido AS z_sido, z.gugun AS z_gugun, z.dong AS z_dong, z.bunji AS z_bunji
FROM emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno
LEFT OUTER JOIN zipcode z
ON d.deptno = z.seq
ORDER BY e.ename asc)
