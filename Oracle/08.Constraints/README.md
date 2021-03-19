# 제약사항
> 개발자(DBA: DataBase Administrator)가 원하는 값만 받기위해 `테이블`에 설정하는 것

- 테이블에 설정된 제약사항은 **user_constraints(Data Dictionary : 정보저장용 테이블) 테이블**에서 확인할 수 있다.
- **테이블단위 제약사항**과 **컬럼단위 제약사항**, **alter문**으로 설정할 수 있다.
    - **테이블단위 제약사항(table level constraints)**
        - 테이블 생성시 컬럼의 정의가 종료되고 나서 정의하는 제약사항

    - **컬럼단위 제약사항(column level constraints)**
        - 테이블 생성시 컬럼의 정의 뒤에 붙여서 정의하는 제약사항 

- 제약사항은 alter문을 사용하여 `활성화` 또는 `비활성화`를 수행 할 수 있다.

- 제약사항 종류
    - **Primary key**
    - **foreign key**
    - **UNIQUE**
    - **CHECK**
    - **NOT NULL**
    - **default**(제약사항 x)

## primary key(주키)

- 반드시 존재하면서 유일한 값을 설정 할 때 사용
- null을 허용하지 않으면서 컬럼의 값을 유일하게 관리해야할 때
- 테이블에 하나만 설정할 수 있다.
- 테이블간의 관계를 설정할 때 사용(부모테이블)
- `테이블 단위 제약사항 문법`과 `컬럼단위 제약사항 문법` 모두 사용 가능
- primary key를 설정하면 Oracle에서 index를 자동으로 생성하고 빠른 검색할 수 있게 도와준다.
- `user_constraints` DD에서 `constraint_type`이 `'P'`로 설정된다.
- 누구나 다 가지고 있으면서 유일한것이 primary key
    - ex) 주민번호 // `핸드폰`이나 `이메일`은 없는사람도 있음

- **primary key 생성 문법**

    - **테이블단위 제약사항**(하나 또는 여러개의 컬럼으로 PK가 구성될 수 있다.)
    ```sql
        CREATE TABLE 테이블명( 
            컬럼명 데이터형(크기)
                    .
                    .
                    .           
            
            컬럼명 데이터형(크기),
            constraint 제약사항명 primary key(pk가 되어져야할 컬럼명)
                       pk_테이블명
        );
    ```

    - **컬럼단위 제약사항**(컬럼하나만 PK로 구성할 수 있다.)
        ```sql
            CREATE TABLE 테이블명(
                컬럼명 데이터형(크기) constraint 제약사항명 primary key,
            );

        ```

## foreign key(외래키,참조키)
> 다른 테이블(부모테이블)의 `컬럼 값`과 `동일한 값`으로 `컬럼 값`이 `저장`되어야 할 때

- null을 허용한다.
- `부모테이블`의 `Primary key 컬럼`만 **참조 가능**
- 값이 입력될 때에는 부모테이블의 컬럼에 존재하는 값으로만 추가된다.
- foreign key가 설정된 테이블을 `자식 테이블`이라고 한다.
- `하나의 테이블`은 `여러 개의 foreign key`를 가질 수 있다.
- 부모테이블의 레코드를 참조(사용)하는 자식테이블이 존재한다면, 자식테이블의 레코드가 삭제 된 후 부모테이블의 레코드가 삭제 될 수 있다.


- **foreign key 생성 문법**
    - **테이블단위 제약사항**
    ```sql
        CREATE TABLE 테이블명(
            컬럼명 데이터형(크기),
                    .
                    .
            constraint 제약사항명 foreign key (적용 컬럼명) references 부모테이블명( 참조할컬럼명 )
        )
    ```

    - **컬럼단위 제약사항**
    ```sql
        CREATE TABLE 테이블명(
            컬럼명 데이터형(크기) constraint 제약사항명 references 부모테이블명( 참조할컬럼명 )
        );
    ```

# **UNIQUE**
- 값이 없을 수도 있고, 있다면 유일해야할 때(NULL을 허용하면서, 값이 있다면 유일해야할 때)
- 컬럼단위 제약사항, 테이블단위 제약사항 모두 사용 가능
- unique제약은 하나의 테이블에 여러 개를 설정할 수 있다.
- **UNIQUE 생성 문법**
    - **테이블단위 제약사항**
    ```sql
        CREATE TABLE 테이블명(
            CREATE TABLE 테이블명(
                컬럼명 데이터형(크기),
                    .
                    .
                    .
                           --UK_컬럼명 
                CONSTRAINT 제약사항명 UNIQUE( 적용 컬럼 )
            );
    ```

    - **컬럼단위 제약사항**
    ```sql
       CREATE TABLE 테이블명(
                                            --UK_컬럼명 
            컬럼명 데이터형(크기) CONSTRAINT 제약사항명 UNIQUE,

       );
    ```
    - **CHECK**
    - **NOT NULL**

# CHECK 조건
> 컬럼의 값을 원하는 형태로 받을 때

- 제약사항명을 설정하지 않고, 컬럼단위 제약사항으로만 설정
- 다른 컬럼을 체크조건에 넣을 수 없다.(체크로 지정된 컬럼만 체크조건에 사용 가능)
- 남자 또는 여자
- 10대 20대만
- **CHECK 조건 문법**
    ```sql
        컬럼명 데이터형(크기) CHECK ( 컬럼명의 조건 )

        ex) 성별은 M 또는 F만 입력 할 수 있다.
            gender char(1) CHECK(gender = 'M' OR gender = 'F') /*gender컬럼에는 'm' 또는 'f'의 값만 넣을 수 있다.*/
    ```

# **NOT NULL**
> 컬럼에 값을 반드시 입력해야 할 때

- 제약사항명을 설정하지 않고, 컬럼단위 제약사항으로만 설정

- **NOT NULL 문법**
    ```sql
        컬럼명 데이터형(크기) NOT NULL
    ```

# **default**(제약사항 x)
- 제약사항은 아님
- `NULL`이 입력되는 상황이 발생하면, 설정해놓은 기본값으로 추가되는 속성
- select * from user_constraints;에서 확인이 되지는 않음

- **default 문법**
    ```sql
        컬럼명 데이터형(크기) DEFAULT NULL일 때 입력될 값
    ```

# ON DELETE CASCADE
> 부모테이블의 레코드가 삭제되면 자식테이블레코드를 자동으로 삭제하기
```sql
    CREATE TABLE 테이블명(

        컬럼명 데이터형(크기),
        CONSTRAINT 제약사항명 foreign key(적용컬럼명) references 부모테이블명(참조컬럼명) on delete cascade

    );
```

# ERD(Entity Realation Dialgram)

|테이블명|
|----|
|PK컬럼|
|일반 컬럼|

-- user_constraints : 테이블에 설정된 제약사항을 확인하는 dictionary.
-- user_cons_colums : 테이블에 설정된 제약사항컬럼을 확인하는 dictionary
