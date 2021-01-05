# Transatcion 처리
> java.sql.Connection은 autocommit이 되어있어 쿼리문 하나당 Transaction을 완료한다.
- Transaction처리는 method밖에서 수행
- Connection이 instance변수로 올라간다.
- 호출하는 곳에서 제어를 수행한다.

1. **Connection이 instance 영역에 선언되어야한다.**
```java
        Connection con = ...;
```
2. **autocommit 해제**
```java
    con.setAutoCommit(false);
```

3. **쿼리를 수행하고 행의 수를 받는다.**
```java
    int cnt = pstmt.executeUpdate();
``` 

4. **호출한 곳에서 목표로한 행의 수가 나왔는지 체크**
```java
    if(totalCnt == 수행 되어야할 행수){
        con.commit(); // 트랜잭션을 완료
    }
    else {
        con.rollback(); //트랙잭션을 취소
    }
```

5. **호출하는 곳에서 con을 끊는다.**