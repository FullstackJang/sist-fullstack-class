# Clob(Character Large Object)
> 4GByte의 문자열을 저장할 때
- 조회 할 때 별도의 Stream을 연결하여 조회한다.

**Clob 사용법**
```java
    rs = pstmt.executeQuery();

    Clob clob = null;
    BufferedReader br = null;
    String str = "";
    while(rs.next()){
        //  String str = rs.getString("clob컬럼"); // Local에서만 가능 Server에 올라가면 안된다.
        1. Clob를 얻는다.
        clob = rs.getClob("clob컬럼명");

    try{
        2. Clob에서 문자열 읽기스트림을 얻고, 줄단위로 읽어들이는 기능을 가진 스트림과 연결한다.
        br = new BufferedReader(clob.getCharacterStream());

        3. BufferedReader에서 줄 단위로 읽는다.
        str = "";
        while((str = br.readLine() != null){
            str
        }
    }finally{
        4. 스트림 끊기
        br.close();
    }

```
