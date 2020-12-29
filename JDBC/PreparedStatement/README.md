# PreparedStatement
> 쿼리문이 반복 실행 되더라도 쿼리문을 한번만 생성하고 **값만 변경하여 실행**

- 쿼리문 작성시에 문자열을 감싸는 `'`를 사용하지 않는다.
- 쿼리문에 값을 넣어주는 `bind varialbe ( ? )`을 사용 `(?)`를 `바인드 변수`라고한다.
    - `바인드 변수`는 순서대로 `인덱스`를 가진다.
- 같은 쿼리문이 여러 번 실행 될 때 `Statement`보다 효율이 좋다.
- `SQLInjection`공격이 발생하지 않는다.

1. **드라이버 로딩**

2. **로딩된 드라이버를 사용하여 `DB와 연결을 얻기`(커넥션 얻기)**

3. **쿼리문 생성객체 얻기**
```java
                                                                //1,2,3 인덱스
    String sql = "INSERT INTO cp_dept(deptno, dname, loc) VALUES (?,?,?)";
    //PreparedStatement는 내가 실행해야 하는 쿼리를 알고 시작한다.
    PreparedStatemnet pstmt = con.prepareStatement(sql); 
```

4. **바인드 변수의 값 넣기(쿼리문과 입력하는 값을 분리할 수 있다.)**
- 쿼리문이 간단해진다.
- `컬럼명`, `테이블명`에 대해서는 `바인드 변수`를 사용할 수 없다.
- `바인드 변수`는 `값`부분에 대해서만 사용이 가능하다.
```java
    pstmt.setInt(바인드변수인덱스,값); // 정수값을 입력
    pstmt.setString(바인드변수인덱스,값); //문자열값 입력
    pstmt.setDate(바인드변수인덱스,값);//날짜 값

    pstmt.setInt(1,10);
    pstmt.setString(2,"개발부");
    pstmt.setString(3,"서울");
```

5. **쿼리문 실행**
- 매개변수가 없으므로 매개변수를 넣지 않도록 주의
```java
    pstmt.executeXxx();
```

# DAO (Data Access Object)
- DBMS에 관련된 코드를 정의하는 클래스

