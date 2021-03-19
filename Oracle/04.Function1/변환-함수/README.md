# ----------------------------- 변환 함수 ----------------------------------

```sql
SELECT sysdate
FROM  dual;
```
<img src = "https://user-images.githubusercontent.com/69107255/102484586-d315bd00-40a9-11eb-8be2-912dcff25452.png">

```sql
SELECT TO_CHAR(sysdate,'yyyy"년"-mm-d am hh(hh24):mi:ss dy day q "분기"')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102484617-df017f00-40a9-11eb-95c8-21ff928c8d79.png">



- 패턴은 대소문자 가리지 않는다.
```sql
SELECT TO_CHAR(sysdate,'YYYY"년"-MM-D AM HH(HH24):MI:SS DY DAY Q "분기"')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102484678-f5a7d600-40a9-11eb-84a3-6e581ce77339.png">


- pattern이 길면 Error가 발생
```sql
SELECT  TO_CHAR(SYSDATE,'yyyy " 년 " mm " 월 " dd " 일 " am  hh " 시 "  mi " 분 " ss " 초 " ')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102484933-4ae3e780-40aa-11eb-8183-c8d316e3605b.png">

- pattern이 길면 TO_CHAR을 두번으로 끊어서 사용하자
```sql
SELECT  TO_CHAR(SYSDATE,'yyyy " 년 " mm " 월 " dd " 일 "') || TO_CHAR(SYSDATE,' am  hh " 시 "  mi " 분 " ss " 초 " ')
FROM dual;
```


- 사원 테이블에서 사원번호, 사원명, 입사일을 조회
    - 단, 입사일은 월-일-년의 형식으로 출력

```sql
SELECT empno, ename, TO_CHAR(hiredate,'mm-dd-yy')
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102485017-64852f00-40aa-11eb-86ba-91fd374f47e5.png">

- 사원테이블에서 입사년도가 1981년인 사원의 사원번호, 사원명, 연봉 입사일,부서번호를 조회해주세요.

```sql
SELECT empno, ename, sal, hiredate, deptno
FROM emp
WHERE TO_CHAR(hiredate, 'yyyy') = '1981';
```

<img src = "https://user-images.githubusercontent.com/69107255/102485052-7070f100-40aa-11eb-9245-81f8284afd8d.png">

# 숫자 변환
- 0 : 해당 자리에 데이터가 존재하지 않으면 '0'을 출력.

```sql
SELECT TO_CHAR(20202,'0,000,000')  , TO_CHAR(2020,'0,000,000.00'),
			TO_CHAR(20202,'0,000')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102485106-7ff03a00-40aa-11eb-9ebf-40f684cfaa35.png">

- 9 : 데이터가 존재하는 것만 출력

```sql
SELECT TO_CHAR(2020,'9,999,999') , TO_CHAR(20202,'9,999')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102485167-94cccd80-40aa-11eb-9a40-0df9069397cb.png">

- 사원 테이블에서 사원번호, 사원명, 입사일, 연봉을 조회
    - 단, 연봉은 3자리를 초과 했을 때만 3자리 마다 ,를 넣어 출력
```sql
SELECT empno, ename, hiredate,'[' || TO_CHAR(sal,'9,999') || ']'
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102485207-a0b88f80-40aa-11eb-87c6-135b9a74ee88.png">