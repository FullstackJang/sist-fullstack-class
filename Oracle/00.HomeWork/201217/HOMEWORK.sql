
select * from emp;
-- 1
SELECT empno, ename, hiredate, sal, ROUND(sal/12,0) "Month Salary"
FROM emp;

-- 2
SELECT empno, ename, hiredate, sal, NVL(TRUNC((sal+comm)*0.033,-1),TRUNC(sal - sal*0.033,-1)) "Total_Money"
FROM emp
WHERE TO_CHAR(TO_DATE(hiredate,'yyyy-mm-dd'),'mm') = 12;

-- 3
SELECT empno, mgr, TO_CHAR(hiredate,'yy-mm-dd q day'), sal, LOWER(ename), INITCAP(job)
FROM  emp
WHERE (deptno = 10 or deptno = 30) and mgr is not null;

-- 4
CREATE TABLE patient (
	patient_num number(5),
	patient_name char(9),
	patient_ssn char(42)
);

--4
INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(12345,'류수정','880101-1234567');
INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(4326,'이나은','980101-2234567');
INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(51,'강호동','991217-1234567');
INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(98762,'이수근','991212-1234567');
INSERT INTO patient(patient_num, patient_name, patient_ssn) VALUES(961,'박서준','001212-4234567');

-- 5
SELECT patient_name,SUBSTR(patient_ssn,1,instr(patient_ssn,'-')-1) front_ssn, CASE WHEN TO_CHAR(MOD(TO_NUMBER(SUBSTR(patient_ssn,8,1)),2)) = 0  THEN '여자'
                                                                               		 ELSE '남자'
																																									 END GENDER, CONCAT('I_',LPAD(patient_num,8,0)) "Patient_Num"
FROM patient;

--6
UPDATE patient
SET  patient_ssn = '991212-2234567'
WHERE patient_name = '이수근';

select * from patient;
