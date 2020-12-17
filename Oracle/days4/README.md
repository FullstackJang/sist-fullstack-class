# function
> 자주 사용될 코드를 미리 구현해놓고 필요한 곳에 호출하여 사용

- Oracle function 특징
    - 간접호출(실행기 (execute)를 사용하지 않고 쿼리문에 넣어 사용하는 것)
    - **DML** (`insert`,`update`,`delete`,`select`)에서 사용할 수 있다.
    - **Oracle에서 제공하는 함수**와 **사용자정의 함수(PL/SQL에서 정의)**가 있다.

# 수치함수
- 연산이 많으면 자바가 하는게 좋다.

## ABS(절대값)

**ABS(절대값) 사용법**
```sql
    SELECT ABS(number값) from 테이블명; --함수에 들어가는 값까지 컬럼이름으로 된다. 따라서, alias를 활용하자
```

## ROUND(반올림)

- 정수부를 반올림하면 해당 자리에서 반올림된다.
- 실수부를 반올림하면 그 다음 자리에서 반올림된다.

**ROUND(반올림) 사용법**
```sql
    ROUND(값, 반올림하여 볼 자릿수)
```

## CEIL(올림)
- `CEIL 함수`는 인수에서 `지정한 수치를 올림`하여 정수를 구하는 함수이다

**CEIL 사용법**
```sql
    CEIL(값)
```

## FLOOR(내림)

**FLOOR 사용법**
```sql
    FLOOR(값)
```

## TRUNC(절삭)

**TRUNC(절삭) 사용법**
```sql
    TRUNC(값, 절삭할 자릿수) 
                            
    -- 소수(실수)부는 절삭할 다음 자리를 버림
    소수부 TRUNC(555.555,2) => 555.55
   
    -- 정수부는 해당 자리를 버림
    정수부 TRUNC(555.555,-1) => 550
```

---

# NULL변환 함수
> `컬럼의 값`이 `null`일 때 `다른 값`으로 `변환`해주는 함수
## NVL
> 조회결과가 null일 때 다른 값으로 변환하는 일
**NVL 사용법**

```sql
    NVL(값, NULL일 때 사용할 값)
        * NULL일 때 사용할 값은 컬럼의 데이터형과 같은 데이터형으로 

    -- comm(보너스)가 null이면 0원으로 채워준다.
    SELECT NVL(comm,0) from emp; 
```

## NVL2
> 조회결과가 있다면 A값을 NULL이 경우엔 B값을 반환하는 함수
```sql
    NVL2(값, NULL이 아닐 때 보여줄 값, NULL일 때 보여줄 값)
```

# 문자열 함수

## LENGTH
> 문자열의 길이를 반환하는 함수

**LENGTH 사용법**
```sql
    LENGTH(값)
```

## CONCAT
> 두개의 문자열을 합칠 때

**CONCAT 사용법**
```sql
    CONCAT(문자열,합칠 문자열)
```

## INITCAP
> 첫 글자를 대문자로 변환

**INITCAP 사용법**
```sql
    INITCAP('문자열')
    
    INITCAP('hello')  -- 'Hello'
    INITCAP('HELLO')  -- 'Hello'
    INITCAP('i am a boy') -- ' I Am A Boy' 공백 이후에 첫글자는 다 대문자로 바꿔준다.
```

## UPPER
> 모두 대문자로 변경

**UPPER 사용법**
```sql
    UPPER(문자열)
```

## LOWER
> 모두 소문자로 변경
```sql
    LOWER(문자열)
```


## INSTR
> 특정문자의 인덱스를 얻기
- `Oracle`은 `시작인덱스`가 `1번부터 시작`된다.
- 찾고자 하는 문자가 없다면 `0번`을 반환

**INSTR 사용법**
```sql
    INSTR(컬럼명, 찾을문자)
```
## SUBSTR
> 문자열 자를 때

**SUBSTR 사용법**

```sql
    SUBSTR(컬럼명,시작인덱스,자를 글자 수)
```

## REPLACE
> 문자열 치환

**REPLACE 사용법**
```sql
    REPLACE(컬럼명, 찾을 문자열, 치환할 문자열)
```

## TRIM
> 문자열의 앞뒤 공백을 제거

- TRIM은 문자열 앞뒤에 특정 문자열이 감싸여 있다면 해당 문자열을 삭제할 수 있다. 

```sql
TRIM(' 지울 문자열' FROM 컬럼명)

TRIM('a' FROM'aaaaaaaaaaaaaOracleaaaaaaaaaaa') --결과값 : 'Oracle'
```
**TRIM 사용법**
```sql
    TRIM(컬럼명) 

    TRIM(' A BC ') -- 'A BC' 앞뒤 공백이 제거 된다.
```

## LTRIM
> 문자열의 앞공백만 제거

**LTRIM 사용법**
```sql
    LTRIM(컬럼명) 

    LTRIM(' A BC ') -- 'A BC ' 앞 공백만 제거 된다.
```

## RTRIM
> 문자열의 뒷 공백만 제거

**RTRIM 사용법**
```sql
    RTRIM(컬럼명) 

    RTRIM(' A BC ') -- ' A BC' 뒷 공백만 제거 된다.
```

## LPAD
> 문자열 앞에 문자열을 채워 지정한 길이의 문자열을 만들 때

- LPAD를 거쳐서 나오면 문자열이 된다.

**LPAD 사용법**
```sql
    LPAD(컬럼명, 전체 글자 수, 채울 문자)

    LPAD('ABC',10, '#') -- 결과값 #######ABC
```

## RPAD
> 문자열 뒤에 문자열을 채워 지정한 길이의 문자열을 만들 때

- 한글은 2바이트로 계산
    - 이유 : 저장된건 3바이트이지만, 출력한것은 2바이트

**RPAD 사용법**

```sql
    RPAD(컬럼명, 전체글자수, 채울문자)
    RPAD('ABC',10,'%') -- 결과값 ABC%%%%%%%
```

# 조건 함수

## DECODE
- PL/SQL에서 사용할 수 없다.
- DCODE는 `반환값에 해당하는 코드가 짧을 때` 사용

**DECODE 사용법**
```sql
    DECODE(컬럼명,비교값,반환값,비교값이 없을 때 반환할 값) -- 비교값과 반환값이 여러개가 올 수 있다.

    DECODE(1,1,'일',2,'이',3,'삼','일치하는 값이 없습니다.')
```

## CASE
- CASE는 `반환값에 해당하는 코드가 길 때` 사용
- CASE문과 같은 동작 수행

**CASE 사용법**
- SELECT(조회)하는 컬렘에서 사용
```sql
    CASE 컬럼명 WHEN 비교값 THEN 실행코드
    CASE 컬럼명 WHEN 비교값 THEN 실행코드
    CASE 컬럼명 WHEN 비교값 THEN 실행코드
            .  
            .
            .
         ELSE 비교값이 없을 때 실행코드
    END alias
```

# 변환 함수

## TO_CHAR()
> 문자열변환

### 날짜 pattern
- pattern안에 내용이 너무 길면 Error가 발생
- pattern은 대소문자 구분하지 않는다.
 
 |날짜|pattern|
 |----|----|
 |y|년|
 |m|월|
 |dd| 일|
 |d| 주에 요일 번째|  
 |h | 시간 (hh- 12시간, hh24 - 24시간)|
 |mi | 분|
 |s | 초|
 |am | 오전/오후|
 |dy | 월|
 | day | 요일|
 |q | 분기

##  '날짜'를 '문자열'로 바꿀 때

```sql
    TO_CHAR(날짜,'pattern')
    
    - pattern 안에서 LETTER가 아닌 문자나 문자열을 쓸 때는 "(쌍따옴표) 를 사용
```

##  '숫자'를 '문자열'로 바꿀 때
    - 0 - 해당 자리에 데이터가 없다면 0으로 출력한다.
    - 9 - 데이터가 존재하는 것만 출력한다.
```sql
    TO_CHAR(숫자, 'pattern')

    TO_CHAR(2020,'0,000,000') -- 결과값: 0,002,020
    TO_CHAR(2020,'9,999,999') -- 결과값: 2,020     
```

## TO_DATE()
> `날짜형식의 문자열`을 `날짜`로 변환

```sql
    TO_DATE('날짜형식의 문자열','pattern')
                               -- pattern은 TO_CHAR와 같다.

    TO_DATE('2020-12-17', 'yyyy-mm-dd')
```

## TO_NUMBER()
> `숫자형식의 문자열`을 `숫자`로 변환
```sql
    TO_NUMBER('숫자형식의 문자열')
```



# dual테이블
    - 가상테이블(존재하지 않으나 존재하는 것처럼 사용할 수 있는 테이블)
    - 연습용 테이블
    - 같은 이름의 테이블을 생성하면 가상테이블은 사라진다.
    - 입력되는 값으로 컬럼을 생성하고 한 행을 조회

**dual 테이블 사용법**
```sql
    SELECT 값,,, FROM dual;
```
