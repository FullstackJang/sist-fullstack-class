# CallalbeStatement
- DBMS에서 제작된 Procedure를 호출하기위해 만들어진 객체
    - PreparedStatement의 하위 interface(ind변수를 사용)

**CallalbeStatement 사용법**
3. 쿼리문 생성객체를 얻기
```java
    String callProc = "{call 프로시저명(바인드변수,,,, )}";
    CallableStatement cstmt = con.prepareCall(쿼리문);
```

4. 바인드 변수에 값 **설정**
**in parameter**
> procedure안에 값을 넣는 것
```java
    cstmt.setXxx(인덱스,값);

    cstmt.setInt(인덱스, 정수값);
    cstmt.setString(인덱스,문자열값);
```

**out prameter**
> procedure가 처리한 결과를 받는 것
```java
    cstmt.registerOutParameter( 인덱스,java.sql.Types.상수 ); 
                                            // 상수는 특정 DB에 귀속되는 데이터형을 제공하지 않는다.
                                            /*(상위개념제공: NUMBER => NUMERIC
                                                            VARCHAR2 => VARCHAR)
                                            */
```

5. 프로시저를 실행(부모의 method를 사용) 
> `out parameter`에 값이 저장된다.
```
    cstmt.execute();
```

6. outparameter에 저장된 값 받기
**위(4번)의 registerOutParameter에 인덱스와 `동일한 인덱스`를 사용하여 값을 받는다.**
```
    cstmt.getInt(인덱스);
```


# Procedure (PL/SQL)
- DBMS에서 자주 사용될 쿼리문을 미리 구현해두고 필요한 곳에서 호출하여 사용할 때 
- 직접호출하여 사용 (SQLPlus에서 `실행기(exec | execute)`를 사용하여 호출)
- 함수보다 개선된 `매개변수`를 지원 (retrun 값이 여러 개가 될 수 있다.)
- `컴파일(@파일명.sql)` 후 `실행( exec 프로시저명(값,,,,))`을 수행
- 매개변수는 외부의 값을 받아들이는 `in parameter`와 프로시저의 처리결과를 반환하는 `out parameter`가 존재

## 바인드 변수란?
> 값과 변수가 따로 떨어져있으나 묶여서 같이 사용되는 변수
```java
    SELECT * FROM ?

    SET 

```

**Procedure 작성법**
1. **작성**
```sql
    CREATE [or REPLACE] PROCEDURE 프로시저명(데이터형 매개변수명,,,,) 
    IS 
        -- 변수 선언, recode 선언(VO와 비슷), table 선언(배열과 비슷),cursor선언(여러행 조회)
    BEGIN 
        -- 코드 작성: 연산, 제어, 쿼리문(transaction을 개발자가 처리)

        -- 예외 처리
    END;
    /
```

2. **컴파일) SQLPlus에서 컴파일 수행**
```
    SQL> @경로/파일명.sql
```

3. **실행) SQLPlus에서 실행**
    **3-1. **바인드 변수를 선언**
    ```sql
        SQL> var | variable 변수명 데이터형(크기)
    ```
    **3-2. 프로시저 실행**
    ```sql
        SQL> exec | execute 프로시저명(값, , ,                    :바인드변수명,:바인드변수명,,,,)
                                    --in parameter에 들어가는 값  -- :바인드명수명=> out parameter에 전달되는 변수. 프로시저가 처리한 결과가 바인드 벤수에 저장
    ```

    ***3-3. 바인드변수를 출력**
    ```sql
        SQL> print바인드변수명 바인드변수명 바인드변수명 
    ```

# Procedure생성 호출

1. **Procedure 작성(변경)**
```sql
    --PL/SQL는 :=이 대입연산자 이다.

    CREATE OR REPLACE PROCEDURE age_proc(year IN NUMBER,age OUT NUMBER, zodiac OUT varchar2) 
    IS

    BEGIN
        age := TO_CHAR(SYSDATE,'yyyy') - year + 1;
        zodiac := '소띠';

    END;
    /
```

2. **저장**
```
    test.sql
```

3. **컴파일**
```sql
    SQL> @c:/dev/test.sql
```

4. **out parameter값을 저장하기 위한 bind변수 선언**
```sql
    SQL> VAR age NUMBER
    SQL> VAR b_zodiac VARCHAR2(200)
```

5. **실행기를 사용하여 실행**
```sql
    SQL> exec age_proc(2021,:b_age,:b_zodiac)
```

6. **bind변수의 값 출력**
```sql
    SQL> print b_age b_zodiac
```

7. **생성된 프로시저 확인**
```sql
select * from user_procedures;
```

# Procedure를 조회
- user_procedures;
```sql
    SELECT * FROM user_procedures;
```

# 