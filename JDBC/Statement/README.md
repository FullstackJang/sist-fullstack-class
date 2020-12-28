# Statement
> 쿼리문 실행 객체(Statement는 쿼리문을 알지 못한다.)

- 실행할 때마다 쿼리문을 생성하여 실행한다.(쿼리문을 반복실행하면 동일 쿼리를 계속 생성)
- 쿼리문을 계속 만들기 때문에 효율이 떨어진다.
- PreparedStatement의 부모 인터페이스
- 값을 쿼리문에 직접 넣어 쿼리문을 생성한다.
- SQLInjection 발생할 수 있다.

**얻는 문법**
```java
    Statement stmt = con.createStatement();
```

<img src = "https://user-images.githubusercontent.com/69107255/103225528-70f06e00-496d-11eb-9bce-0e1d428ff9e7.png">

# DB연동

1. **드라이버로딩**
```java
   Class.forName(“oracle.jdbc.OracleDriver”);
```

2. **커넥션 얻기**
```java
   String url=”jdbc:oracle:thin:@localhost:1521:orcl”; 
   String id=“scott”;
   String pass=“tiger”;
 
   Connection con=DriverManager.getConnection(url, id, pass);
   //Connection은 autocommit이 설정되어있다.
   //( 개발자가 commit과 rollback 할 필요가 없다. – 쿼리문 하나당 Transaction 완료.) 
```

3. **쿼리문 생성객체 얻기**
```java
   Statement stmt=con.createStatement();
```
4. **쿼리문 수행 후 결과 얻기**
- `insert`, `update`, `delete`
    - 쿼리문이 실행되고 난 후 `행의 수`를 얻어야 한다. ( transaction완료 여부)
```java
    int count=stmt.executeUpdate( sql );
``` 
## INSERT
```java
    //*쿼리문 작성 시에는 ;을 넣지 않는다.
     String sql="insert into dept(deptno, dname, loc) values(99 , ’개발부’ , ’서울’)";
      try{
        stmt.executeUpdate( sql ); // insert는 추가 성공하면 1행이 반환되고 ,실패하면 예외가 발생
        //추가성공.
      }catch(SQLException se){
        // 문제가발생.
      }
```

## UPDATE
```java
     String sql="update 테이블명 set 컬럼명=값,, where 컬럼명=값,,, ";
     try{
       int cnt= stmt.executeUpdate( sql ) ; //update는 변경될 목표행수 받는다.
       if(목표로한 행수 ?){  
          //변경 성공 | 삭제 성공
       }else{
         //변경되지 않는 경우. | 삭제되지 않은 경우.
       }

     }catch(SQLException se){
       //쿼리문 실행 중 문제가 발생.
     }
```
  
5. **연결 끊기**
```java
      stmt.close();
      con.close();
```