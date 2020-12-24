# JDBC (Java DataBase Connectivity)
> Java에서 DBMS를 사용(연동)하기 위한 방법을 제공하는 저수준 API

- Driver loading방식을 사용하여 Driver만 제공된다면 모든 DBMS와 연결가능
- Driver는 Java에서 제작 배포하는 것이 아닌 DB제조사에서 Driver를 제작하여 배포한다.(JDBC-ODBC Driver만 Java에서 제공)
- `java.sql`package에서 관련 클래스를 제공

- **Driver**는 4가지형으로 제공
1. JDBC-ODBC- bridge Driver ( Type1 )
    - Windows 운영체제에서 사용되는 드라이버
    - DB연동 관리를 OS의 ODBC에서 수행하고 자바는 ODBC와 연결하는 방식
    - 속도가 느리다.
    - `Windows환경`에서만 연결 및 사용이 가능

2. Native Driver Type ( Type2 : OCI Driver )
    - 모든 운영체제에서 사용될 수 있는 드라이버
    - `DB쪽의 연결 언어`가 `Java언어`가 아닌 언어로 개발된 Driver
    - 언어간의 충돌이 발생할 수 있다.
    - 속도는 빠르다.

3. Network Protocol Driver Type ( Type3 Driver )
    - Middle ware에서 사용하는 드라이버

4. Native Protocol Driver ( Type4 Driver : thin ) // 기능을 많이 빼서 thin(얇은)드라이버
    - 모든 운영체제에서 동작할 수 있다.
    - **연결에 필요한 모든 부분**이 `자바언어로 개발된 드라이버`


# JDBC 연동 순서
1. 드라이버 로딩
```java
    //Class.forname()은 java.lang pakage에 있음
    //Class.forname()을 사용하면 입력된 클래스의 객체를 생성하여 JVM에 생성 하는 일을 함
    //Class.forname() 사용자가 new를하지않아도 new한 효과가 있다.
    Class.forName("oracle.jdbc.OracleDriver");
                  //배포되는 드라이버에 존재하는 Class명을 작성해준다.
                  //현재 SQLPLUS나 golden을 실행 한 상태 
```
2. 로딩된 드라이버를 사용하여 `DB와 연결을 얻기`
```java
    //java.sql의 DriverManger.getConnection()를 사용해야한다.
    //DriverManger클래스는 생성자가 없어서 객체화가 안됨 static으로 사용해야함

   /* static Connection DriverManger.getConnection(url,id,pass); 
        url,id,pass을 가지고 OracleDriver을 통해서 DBMS의 연결을 요청한다.
    
        DBMS 1521포트쪽에서는 인증을 요청하고 인증이 완료되면 DBMS쪽에서 JVM쪽으로 Connection을 반환 Driver Manager을 통해서 Connection을 얻는다.
    */

    String url = "jdbc:oracle:thin:@DBServer위치:1521:SID";
    String id = "scott";
    String pass = "tiger";

    //DriverManger는 로딩된 드라이버를 사용하여 DB와 연결을 시도하고 연결을 반환하는 일

    //Connection은 연결관리를 한다. Transaction을 관리한다, 쿼리문 생성객체 반환하는 일
    Connection con = DriverManger.getConnection(url,id,pass);


```

3. `연결(Connetion)`을 관리하는 객체로 부터 쿼리문 `생성객체 얻기`

```java
    Statement stmt = con.createStatement(); //Statement는 실행하는 쿼리문을 알 수 없다.
    PreparedStaement pstmt = con.pprepareStatement(쿼리문); // PreparedStatement는 실행하는 쿼리문을 알고 있다.
    CallableStatement cstmt = con.prepareCall("프로시저명"); //procedure를 실행
```

4. 쿼리문 생성객체를 사용하여 쿼리문 실행(쿼리문이 DBMS로 전송이 된다.)
```java

    boolean flag = stmt.execute(쿼리문); // CREATE, DROP, TRUNCATE,ALTER,GRANT,REVOKE
    // 잘되면 TRUE 안되면 FALSE
    // 계정이 잘 되었는지
    // 인덱스 생성이 잘 되었는지
    // 잘 짤렸는지
    // 잘 바뀌었는지
    // 권한이 잘 들어갔는지, 회수 잘 되었는지.
    int cnt = stmt.executeUpdate(쿼리문); //실행이 되면 몇개의 레코드(row)가 바뀌었는지 저장하게 된다.(INSERT,UPDATE,DELETE)
    //INSERT 몇개의 행이 추가되었는지.
    //UPDATE 몇개의 행이 변경되었는지
    //DELETE 몇개의 행이 삭제되었는지
    //를 알수 있따. 
    ResultSet	rs = stmt.executeQuery(쿼리문); // SELECT 인라인뷰의 제어권이 필요하다.
                                              // SLECT의 쿼리문을 executeUpdate,execute에서 사용하면 pointer에 제어권을 얻어오지 못한다.

    DB를 바꾸지 않는 쿼리 : SELECT
    DB를 바꾸는 쿼리 : 변경되는 쿼리 CREATE,DROP,TRUNCATE,ALTER,GRANT,REVOKE,INSERT,UPDATE,DELETE
  
```
**제일중요**
5. 연결 끊기(반드시 연결을 끊어야함)
```java
    rs.close();
    stmt.close();
    con.close();
```