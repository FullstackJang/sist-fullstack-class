# ResultSetMetaData
- DataDictionary를 사용하지 않고 조회하는 테이블의 컬럼정보를 얻을 때 사용하는 객체
    - 연결가능한 모든 DBMS에서 정보를 얻을 수 있다.

**ResultSetMetaData 사용법**

1. select쿼리를 실행한 ResultSet에서 ResultSetMetaData를 얻는다.
```java
    ResultSetMetaData rsmd = rs.getMetaData();
```

2. method사용
```java
    // 컬럼의 개수
    int count = rsmd.getColumnCount();

    // 컬럼명 얻기
    String coluumnName = rsmd.getColumnName(int column); //파라미터에 Column인덱스는 1번부터 시작

    // 컬럼데이터형
    String columnTypeName = rsmd.getColumnTypeName(int column);

    // 컬럼의 크기
    int columnPrecision = rsmd.getPrecision(int column);

    // null 허용
    int flag = isNullable(int column); // 0이면 NotNull / 1이면 Null
```