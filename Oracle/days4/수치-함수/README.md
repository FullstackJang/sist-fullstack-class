# ------------------- 수치 함수 -------------------

# ABS(절대값)
```sql
SELECT abs(-12), abs(12)
FROM dual;
```
<img src = "https://user-images.githubusercontent.com/69107255/102481693-6698bf00-40a5-11eb-8b09-d46da8612af2.png">

# ROUND(반올림) : round(값, 반올림하여 볼 자릿수 )
- 실수부는 반올림하여 볼 자릿수를 설정한다.

```sql
SELECT ROUND(555.555,2)
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102481741-7c0de900-40a5-11eb-83ac-4c233af528b0.png">


```sql
SELECT ROUND(555.554,2) /*555.554는 4값이 반올림 대상이 아니라서 반올림하지 않는다.*/
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102481848-a8296a00-40a5-11eb-9584-337831cb38bd.png">

- 정수부는 해당자리에서 반올림한다.
```sql
SELECT ROUND(777.777,-1)
FROM dual;
```

<img src ="https://user-images.githubusercontent.com/69107255/102481891-bd9e9400-40a5-11eb-8f4d-d909ac3c3b4c.png">

- 사원 테이블에서 모둔 사원의 사원번호, 사원명, 연봉, 세금을 조회
    - 단, 세금은 소수점 1번째 자리에서 반올림하여 양수부만 출력할 것
```sql
SELECT empno, ename, sal, ROUND(sal * 0.033)
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102481947-d27b2780-40a5-11eb-846f-2130b48760c5.png">

# CEIL(올림)

```sql
SELECT CEIL(10.1), CEIL(10.0001)
FROM dual;
```

<img src ="https://user-images.githubusercontent.com/69107255/102482024-ef175f80-40a5-11eb-95f5-787d0077b16a.png">

# FLOOR(내림)

```sql
SELECT FLOOR(10.9)
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102482085-08201080-40a6-11eb-9dc1-f493642ae558.png">


# TRUNC(절삭)
- 실수부는 해당인덱스 다음부터 자른다.

```sql
SELECT TRUNC(777.777,2), TRUNC( 777.777,1)
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102482124-179f5980-40a6-11eb-8875-359b1f91343a.png">

- 정수부는 해당인덱스 부터 자른다.
```sql
SELECT TRUNC(777.777,-1), TRUNC( 777.777,-2)
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102482175-27b73900-40a6-11eb-9ec3-50411c0c7d53.png">


- 사원테이블에서 모든사원의 사원번호, 사원명, 연봉, 세금을 조회
    - 단, 세금은 연봉에 3.3%로 계산하고, 원단위 절삭하여 조회 출력

```sql
SELECT empno, ename, sal, TRUNC(sal*0.033,-1) tax
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102482227-369deb80-40a6-11eb-8811-d810871385f4.png">

- 나눈 나머지 MOD(값, 나눌 수)

```sql
SELECT MOD(10,3) , MOD(2020,12)
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102482256-46b5cb00-40a6-11eb-9113-40ab37b94b0a.png">