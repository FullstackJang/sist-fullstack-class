# --------------------- 문자열 함수 ---------------------

# LENGTH(길이)
- WHERE절에서 사용할 수 있다.

```sql
SELECT length('오늘은 목요일 입니다.')
FROM dual;
```
<img src = "https://user-images.githubusercontent.com/69107255/102483486-26870b80-40a8-11eb-853d-6c812b112abb.png">

- 사원테이블에서 사원명이 4글자인 사원의 사원명, 사원명의 글자수, 사원번호, 입사일 조회

```sql
SELECT ename, length(ename), empno, hiredate
FROM emp
WHERE length(ename)=4;
```

<img src = "https://user-images.githubusercontent.com/69107255/102483525-3868ae80-40a8-11eb-861c-a17e751037f6.png">

# CONCAT(문자열합치기)

```sql
SELECT CONCAT('오늘은','목요일') , '오늘은' || '목요일'
FROM dual;
```
<img src = "https://user-images.githubusercontent.com/69107255/102483586-50d8c900-40a8-11eb-86a5-1dc948c92dcf.png">

# INITCAP(첫 글자를 대문자로 변환)

```sql
SELECT INITCAP('hello'), INITCAP('HELLO'), INITCAP('i am a boy')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102483637-5df5b800-40a8-11eb-8cc0-08efc7e9518b.png">

```sql
SELECT INITCAP(ename), INITCAP(job)
FROM emp;
```

<img src = "https://user-images.githubusercontent.com/69107255/102483668-69e17a00-40a8-11eb-999d-e5cdc411abf4.png">

# UPPER(대문자), LOWER(소문자 변환)

```sql
SELECT UPPER('AbcdEf'), LOWER('AbcdeF')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102483701-75cd3c00-40a8-11eb-95a9-f3c69a9d8a23.png">

- 사원 테이블에서 사원명이 'scott'인 사원의 사원번호, 사원명, 연봉, 보너스, 매니저번호를 조회

```sql
SELECT empno, ename, sal, comm, mgr
FROM emp
WHERE ename = UPPER('scott');
--WHERE LOWER(ename) = 'scott';
```

<img src = "https://user-images.githubusercontent.com/69107255/102483764-8aa9cf80-40a8-11eb-9cbf-4c34554cdc92.png">

# INSTR(인덱스 얻기)

```sql
SELECT INSTR('AbcdE','A'), INSTR('AbcdE','B')
FROM dual;
```
<img src = "https://user-images.githubusercontent.com/69107255/102483887-c6dd3000-40a8-11eb-89ab-61228ee77f3a.png">

- 사원테이블에서 사원명에 'A'가 있는 사원의 사원명을 조회
```sql
SELECT ename
FROM   emp
WHERE instr(ename,'A') <> 0;
```

<img src = "https://user-images.githubusercontent.com/69107255/102483937-dd838700-40a8-11eb-9808-1e5c185f3492.png">

# SUBSTR(글자 자르기)  -   SUBSTR(문자열, 시작인덱스, 자를 글자수)
```sql
SELECT SUBSTR('AbcdeF',2,4), SUBSTR('AbcdeF',3,1), SUBSTR('AbcdeF',4,3)
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102484003-f724ce80-40a8-11eb-8560-06e1ec6cddd3.png">

- 학생테이블에서 이름,이메일, 이메일주소, 도메인 주소 조회
```sql
SELECT name, email, SUBSTR(email,1,instr(email,'@')-1), SUBSTR(email,instr(email,'@')+1)
FROM student;
```

<img src = "https://user-images.githubusercontent.com/69107255/102484045-086ddb00-40a9-11eb-83be-c4e3ff1a8e49.png">

# REPLACE(문자열 치환)
- 모든 공백을 제거할때는 REPLACE를 사용한다.
```sql
SELECT REPLACE('오늘은 금요일 입니다.','오늘은','내일은'), REPLACE('java','a','AAAA'), REPLACE('   A BC   ',' ','')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102484125-22a7b900-40a9-11eb-84ee-b9af0b7134b3.png">


# 공백 제거
- 앞뒤 공백 제거 TRIM()
- 앞 공백 제거  LTRIM()
- 뒷 공백 제거  RTRIM()

```sql
-- TRIM은 문자열 앞뒤에 특정 문자열이 감싸여 있다면 해당 문자열을 삭제할 수 있다. TRIM(' 지울 문자열' FROM 컬럼명)
SELECT '[' || TRIM('   A BC   ') || ']' ,  '[' || LTRIM('   A BC   ') || ']' ,'[' || RTRIM('   A BC   ') || ']'
,TRIM('a' FROM'aaaaaaaaaaaaaOracleaaaaaaaaaaa')
FROM dual;
```

# 문자열을 채워서 같은 길이의 문자열을 만들 때
- 왼쪽으로(문자열의 앞에)  채울 때 LPAD, 오른쪽으로(문자열의 뒤) 채울 때 RPAD

```sql
SELECT LPAD('ABcd',10, '#'), LPAD('ABcd',10, '가'),
			 RPAD('ABcd',10, '#'), RPAD('ABcd',10, '가')
FROM dual;
```

<img src = "https://user-images.githubusercontent.com/69107255/102484197-3bb06a00-40a9-11eb-9368-6a07c448de86.png">

- 숫자가 총 12자로 구성되고 12자가 아니라면 앞에 0을 채워 넣어 12자로 만든 후 해당 숫자 앞에 SIST_ 문자열을 붙여 SIST_000000000001 의 형식으로 출력해보세요.

```sql
SELECT CONCAT('SIST_',LPAD(1,12,0)) num
FROM dual;

SELECT CONCAT('IT_',LPAD(seq,5,0))
FROM zipcode
WHERE seq < 100;

select * from student;
```

<img src = "https://user-images.githubusercontent.com/69107255/102484233-4bc84980-40a9-11eb-8933-96d3e2c35707.png">