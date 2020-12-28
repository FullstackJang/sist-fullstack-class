# 조회
> `ResultSet`을 사용

```java
    String sql = "select deptno, dname, loc from dept";

    ResultSet rs = stmt.executeQuery(sql);
    // rs는 커서의 제어권을 얻는다.

    int deptno = 0;
    String dname = "";
    String loc = "";
    
    while(rs.next()){ //포인터(cursor)의 다음(아래)에 레코드가 존재하는지?
        //java.sql.ResultSet의 getInt(); 오라클에 데이터형을 자바의 데이터형으로 바꿔준다.
        int deptno = rs.getInt("deptno");

        //java.sql.ResultSet의 getString(); 오라클에 데이터형을 자바의 데이터형으로 바꿔준다.
        String dname = rs.getString("danme");

        String loc = rs.getString("loc");

    }//end while
```

cursor는 레코드의 유무를 반환하는 포인터이다.

