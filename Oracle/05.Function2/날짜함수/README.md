# 날짜 함수
- `날짜`에 `+ 연산`을 사용하면 `현재 날짜`에서 `하루씩 증가하는 날`을 얻을 수 있다.
- `날짜`에 `- 연산`을 사용하면 `현재 날짜`에서 `하루씩 감소하는 날`을 얻을 수 있다.
```sql
SELECT sysdate, sysdate + 4, sysdate -2
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102609007-23eee980-416e-11eb-9bd8-551ae9a670df.png">

# 월 연산
- ADD_MONTHS()

```sql
SELECT	SYSDATE, ADD_MONTHS(SYSDATE,1), ADD_MONTHS(SYSDATE, 2)
FROM	dual;
```

# 두 개월간 차이

```sql
SELECT TRUNC(MONTHS_BETWEEN('2021-4-21',SYSDATE))
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102609281-8cd66180-416e-11eb-9577-9ac4f0c9e47d.png">

# 입사일로부터 개월 수 구하기
```sql
SELECT  ename, TRUNC(MONTHS_BETWEEN(SYSDATE,hiredate)) after_hiredate , hiredate
FROM emp;
```

<img src ="https://user-images.githubusercontent.com/69107255/102609362-aaa3c680-416e-11eb-96f4-f074d518f5fc.png">

# 태어난 개월 수 구한 후 년도 구하기
```sql
SELECT MONTHS_BETWEEN(SYSDATE,'1993-7-14') /12
FROM dual;
```

# 마지막날 구하기 last_day(현재 날짜)
SELECT SYSDATE, LAST_DAY(SYSDATE), LAST_DAY('2021-02-01')
FROM   dual;

<img src = "https://user-images.githubusercontent.com/69107255/102609475-e50d6380-416e-11eb-8f25-dc711ad8e48c.png">