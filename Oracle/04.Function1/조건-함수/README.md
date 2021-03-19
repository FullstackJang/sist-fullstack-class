# -------------------------- 조건 함수 ----------------------------

```sql
SELECT DECODE(1,1,'일',2,'이',3,'삼', '일치하는 값이 없습니다.')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102485767-656a9080-40ab-11eb-9592-8865842ea1f7.png">

- 부서테이블에서 부서번호, 부서명, 한글 부서명을 조회
    - 단, 한글 부서명은 아래(하기)의 표와 같이 설정합니다.
    - 10번 - 개발부, 20 - 유지보수부, 30 - 영업부 , 40 - 탁구부
```sql
SELECT deptno, dname, DECODE(deptno, 10,'개발부', 20, '유지보수부', 30, '영업부','탁구부') kor_dname
FROM dept;
```

<img src = "https://user-images.githubusercontent.com/69107255/102485810-73201600-40ab-11eb-9bef-206fc814db7a.png">

- 사원테이블에서 사원번호, 사원명, 한글 직무를 조회
    - 단, 한글 직무는 아래의 표와 같이 설정합니다.
    - 'CLERK - 일반사원,'SALESMAN' - 영업사원, 'MANAGER' - 관리사원, 'ANALYST' - 분석가,'PRESIDENT' - 회장님
```sql
SELECT  empno, ename, job, DECODE(job, 'CLERK', '일반사원','SALESMAN', '영업사원', 'MANAGER', '관리사원', 'ANALYST' , '분석가','PRESIDENT','회장님') "group"
FROM  emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102485897-91861180-40ab-11eb-9d94-31df36eee48f.png">

- 사원테이블에서 사원번호, 사원명, 연봉, 보너스,  부서번호를 조회
    - 단 보너스는 아래의 표와 같이 연봉에 해당 %로 계산하여 출력한다.
    - 10 - 연봉에 10% 20 - 연봉에 15%, 30 - 연봉에 20% 그 외 연봉에 50%

```sql
SELECT empno, ename, sal, comm, deptno, TRUNC(DECODE(deptno,10,sal*0.1,20,sal* 0.15,30,sal* 0.2,sal* 0.5)) bonus
FROM  emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102485954-a9f62c00-40ab-11eb-96f9-854c61de3ec4.png">

# CASE

```sql
SELECT CASE 'java' WHEN 'java' THEN '완변한 OOP언어'
									 WHEN	'HTML' THEN 'Markup Language'
									 WHEN 'JavaScript' THEN 'toy Language'
									 else '언어의 정보가 없습니다.'
			 END lang_info
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102485979-b5e1ee00-40ab-11eb-8bff-0f5174b85d33.png">

- 사원테이블에서 사원번호, 사원명, 부서번호, 부서별 보너스, 직무를 조회
    - 단, 부서별 보너스는 10 - 100, 20 - 400, 30 - 250 그 외는 1000으로 출력
```sql
SELECT empno, ename, deptno, case deptno when 10 then 100
																				 when 20 then 400
																				 when 30 then 250
																				 else 1000
														 end dept_bonus,
 														 job
FROM  emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102486014-c2664680-40ab-11eb-97a5-dfbcf17c99f5.png">