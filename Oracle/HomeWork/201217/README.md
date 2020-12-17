# emp 테이블
<img src = "https://user-images.githubusercontent.com/69107255/102488714-d744d900-40af-11eb-8f30-526227ef3be2.png">

# 숙제 1. 
- 사원 테이블에서 모든 사원의 `사원번호` ,`사원명`, `입사일`,`연봉`, `월급`을 `조회`하세요.
    - 단, `월급`은 `연봉`을 `12로 나눈 값으로 소수점 첫번째자리에서 반올림`하여 `출력`합니다.

```sql
    SELECT empno, ename, hiredate, sal, ROUND(sal/12,0) "Month Salary"
    FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102489066-55a17b00-40b0-11eb-9b13-2c44be942410.png">


# 숙제 2. 
- `사원 테이블`에서 `입사월`이 `12월`인 사원들의 `사원번호`, `사원명`, `입사일`, `연봉`, `실수령액`을 `조회`하세요.
    - 단, 실수령액은 연봉과 보너스를 합산한 금액으로 연산하고,
    - 세금은 실수령액에서 3.3%를 제외한  금액으로 연산하여 원단위절사하여 출력합니다. 

```sql
    SELECT empno, ename, hiredate, sal, NVL(TRUNC((sal+comm)*0.033,-1),TRUNC(sal - sal*0.033,-1)) "Total_Money"
    FROM emp
    WHERE TO_CHAR(TO_DATE(hiredate,'yyyy-mm-dd'),'mm') = 12;
```

<img src = "https://user-images.githubusercontent.com/69107255/102489125-66ea8780-40b0-11eb-9984-f559a5b27621.png">

# 숙제 3. 
- `사원 테이블`에서 `10번 부서`와 `30번 부서`에 `근무하면서` `매니저가 있는 사원`의 `사원번호`, `매니저번호`, `입사일`, `연봉`, `사원명`, `직무`를 `조회`하세요.
    - 단, 입사일은 "년-월-일 분기 요일" 의 형식으로 출력하되 년도는 2자리만 출력하세요, 사원명은 모두 소문자로 출력하고, 직무는 앞자리만 대문자로 출력하세요.

```sql
    SELECT empno, mgr, TO_CHAR(hiredate,'yy-mm-dd q day'), sal, LOWER(ename), INITCAP(job)
    FROM  emp
    WHERE (deptno = 10 or deptno = 30) and mgr is not null;
```

<img src = "https://user-images.githubusercontent.com/69107255/102489203-7e297500-40b0-11eb-92ce-c9564aef472e.png">

# 숙제 4. 
- 아래의 값을 입력할 수 있는 `테이블을생성`하고 `데이터를 추가`하세요.
```
   12345,'류수정','880101-1234567'
   4326,'이나은','980101-2234567'
   51,'강호동','991217-1234567'
   98762,'이수근','991212-1234567'
   961,'박서준','001212-4234567'
```

```sql
CREATE TABLE patient (
	patient_num number(5),
	patient_name char(9),
	patient_ssn char(42)
);

INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(12345,'류수정','880101-1234567');
INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(4326,'이나은','980101-2234567');
INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(51,'강호동','991217-1234567');
INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(98762,'이수근','991212-1234567');
INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(961,'박서준','001212-4234567');
```
 
<img src = "https://user-images.githubusercontent.com/69107255/102490033-a9609400-40b1-11eb-925b-ef1fb5080b4a.png">

# 숙제 5.
-  4번에서 생성한 `테이블을 사용`하여 `번호`, `이름`, `주민번호 -앞자리만`,  `성별` 을 조회하세요. 
    - 단, 번호는 I_00000000 의 형식으로 출력할 것.
```sql
SELECT patient_name,SUBSTR(patient_ssn,1,instr(patient_ssn,'-')-1) front_ssn, CASE WHEN TO_CHAR(MOD(TO_NUMBER(SUBSTR(patient_ssn,8,1)),2)) = 0  THEN '여자'
                                                                               		 ELSE '남자'
																					 END GENDER, CONCAT('I_',LPA(patient_num,8,0)) "Patient_Num"
FROM patient;
```

<img src = "https://user-images.githubusercontent.com/69107255/102489936-82a25d80-40b1-11eb-86ab-efb4c0a57b14.png">

# 숙제 6. 
- 4번에서 생성한 `테이블`에서 `이름`이 `'이수근'인 사람`의 `주민번호를 '991212-2234567'` 로 `변경`하세요.

<img src = "https://user-images.githubusercontent.com/69107255/102489843-61da0800-40b1-11eb-9c65-8f9fbe459896.png">