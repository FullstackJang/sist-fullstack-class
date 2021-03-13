## **1. com.example.demo.db 패키지를 생성한다.**
<img src ="https://user-images.githubusercontent.com/69107255/109823118-fc8ebf80-7c7a-11eb-94cb-f505294e399f.png">

## **2. dbConfig.xml을 생성해준다.**

<img src ="https://user-images.githubusercontent.com/69107255/109805420-c0e9fa80-7c66-11eb-9966-df297d94605b.png">

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```
 내가 사용할 **DBMS**, **서버url**, **사용자 이름**과 **비밀번호**등을 정해주는 설정파일
    - https://mybatis.org/mybatis-3/ko/getting-started.html

- XML설정파일에서 지정하는 마이바티스의 핵심이 되는 설정은 트랜잭션을 제어하기 위한 TransactionManager과 함께 **데이터베이스 Connection인스턴스**를 가져오기 위한 **DataSource** 를 포함한다. 

- `environment엘리먼트`는 **트랜잭션 관리**와 **커넥션 풀링**을 위한 환경적인 설정을 나타낸다.

## **3. db.properties `properties확장자 파일`을 생성한다.**

<img src ="https://user-images.githubusercontent.com/69107255/109806293-e297b180-7c67-11eb-8867-0ae557248222.png">

```
  driver=oracle.jdbc.driver.OracleDriver
  url=jdbc:oracle:thin:@localhost:1521:orcl
  username=scott
  password=tiger
```


## **4. 다시 `dbConfig.xml`파일로 돌아와서 위에서 작성한 db.properties파일인 외부 db연결 파일을 가져온다.**
그 후에 클래스들의 전체 경로와 이름에 대한 별칭을 만들어준다.** 
    
<img src = "https://user-images.githubusercontent.com/69107255/109807694-93528080-7c69-11eb-80f8-3df5037e8751.png">

## **5. mapper 설정**

- 매핑파일을 설정해 준다.
    - 필요에 의해서 매핑파일이 여러개가 될 수 있다.

<img src ="https://user-images.githubusercontent.com/69107255/109808088-0c51d800-7c6a-11eb-8ecd-46c82ccf796b.png">

## **6. XML Mapper의 작성**

- Mapper는 SQL문을 저장하는 곳이다.
**GoodsMapper.xml**을 추가하여 실행 할 SQL문을 추가해준다.
- https://mybatis.org/mybatis-3/ko/getting-started.html

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!-- DTD 선언 -->
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="org.mybatis.example.BlogMapper">
<!-- DAO의 메서드가 될 것이다.-->

  <!-- 모든 상품 조회 -->
                        <!-- resultType은 Goods테이블에 값을 자바객체에 무엇으로 포장할지 선언하는 것 
                             com.dbConfig.xml에 typeAlias에 alias를 goodsVo로 사용하기로 했다. -->
  <select id="findAll" resultType="goodsVo">
    select * from Goods
  </select>
</mapper>
```

## 7. SqlSessionFactory클래스를 가지고 있는 GoodsManager클래스 생성

- SqlSessionFactory는 데이터베이스와의 연결과 SQL의 실행에 대한 모든 것을 가진 가장 중요한 객체이다.


<img src ="https://user-images.githubusercontent.com/69107255/109823931-b71ec200-7c7b-11eb-94fd-13dbb0de95f9.png">

