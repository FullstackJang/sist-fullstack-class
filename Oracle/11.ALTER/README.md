# **ALTER**
- DDL 
- `테이블 조작`,`제약사항`,`계정`을 처리할 수 있다.

## **테이블 조작**
> 컬럼의 데이터형을 변경할 수 있다.(레코드가 존재하지 않으면 데이터형까지 변경 가능, 레코드가 존재하면 동일 데이터형에서 크기만 변경 가능)

**테이블 조작 문법**

```sql
    ALTER TABLE 테이블명 MODIFY 컬럼명 데이터형(크기) 컬럼단위_제약사항 
``` 

## **컬럼 추가**
>추가되는 컬럼은 제일 마지막에만 추가 가능

**컬럼 추가 문법**

```sql
    ALTER TABLE 테이블명 ADD 컬럼명 데이터형(크기) 컬럼단위_제약사항
```

## **컬럼 삭제**

**컬럼 삭제**
```sql
    ALTER TABLE 테이블명 DROP COLUMN 컬럼명

    -- 컬럼에대한 제약사항 값들 모두 지워진다.
```

## **컬럼명 변경**

```sql
    ALTER TABLE 테이블명 RENAME COULMN 이전컬럼명 to 변경할컬럼명
```


## 제약사항 설정

### **제약사항 추가**
> 테이블단위 제약사항의 문법을 통해 처리할 수 있음

```sql
    ALTER TABLE 테이블명 ADD CONSTRAINT 제약사항명 제약사항(적용컬럼);
                                        --primary키, foriegn key UNIQUE는 가능
```

### **제약사항 삭제**
```sql
    ALTER TABLE 테이블명 DROP CONSTRAINT 제약사항명;
```

### **제약사항 활성화 or 비활성화**
> 비활성화 후 활성화를 하려면 컬럼의 값이 제약사항에 위배되는 값이 없어야 한다.

```sql
    ALTER TABLE 테이블명 [ ENABLE | DISABLE ] CONSTRAINT 제약사항명; 
```

## **계정**
- 관리자계정만 가능

### **계정생성**
> 생성된 계정은 접속 및 DBMS를 사용할 수 없다.

- Oracle 12c 부터는 계정명 앞에 c##형태로 시작해야한다.
- `C##`형식의 계정을 사용하지 않을려면 `_ORACLE_SCRIPT`를 활성화 해아한다.
- **C## 제외 문법**
> 일시적임 / 다음번에 접속하면 다시 해줘야함
```SQL
    ALTER session set "_ORACLE_SCRIPT" = TRUE; 
```
**계정생성 문법**
```sql
    CREATE USER 계정명 IDENTIFIED BY 비번;
```

### **생성된 계정에 권한 부여**

- **connect** : 접속권한
- **resource** : DBMS를 사용할 수 있는 권한
- **dba** : dba권한, create, view - view 생성 권한,,,
- `GRANT`를 사용하여 권한 부여 - DCL
- 12c부터는 resource권한 이후에 `tablespace`사용 권한을 `alter`로 변경해야한다.

**권한을 줄때의 문법**
```sql
    GRANT 권한,,, TO 계정명;
```

**생성된 계정이 사용할 tablesapce 설정 문법**
```sql
    ALTER USER 계정명 DEFAULT TABLESPACE 테이블스페이스명 QUOTA UNLIMITED ON 테이믈스페이스명; 
```

## **계정의 비밀번호 변경**
> 접속 계정의 비밀번호 변경을 할 수 있다.
```sql
    ALTER USER 계정명 IDENTIFIED BY 비밀번호;
```

## **계정을 활성화 | 비활성화
> 계정의 `풀기` | `잠금`

```sql
    ALTER USER 계정명 ACCOUNT [ LOCK | UNLOCK ]
```

## **계정 삭제**

- 계정정보는 `dba_users`에서 확인이 가능
    - `SELECT * FROM dba_users;`
- 접속중인 계정은 삭제할 수 없다.
- Oracle 12c부터는 `ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;`를 수행한 후 계정을 삭제한다.

**계정삭제 문법** 
```sql
    -- 계정이 생성한 Oracle Object가 있을때
    DROP USER 계정명;

    -- 계쩡이 생성한 Oracle Object 있을 때
    DROP USER 계정명 CASCADE;
    -- 
```

## **REVOKE(권한회수)

- `관리자 계정`만 `권한을 회수` 할 수 있다.
- DCL

```sql
    REVOKE 회수할 권한 ,,, FROM 계정명;
```

## 백업
> exp.exe 사용
- 모든 계정은 `백업`을 수행 할 수 있다. 
- DOS창에서 수행
    - 도움말 보기: exp help = y
     - 테이블만 백업 : exp userid=계정명/비밀번호 tableds=백업할테이블,,, file=백업파일의 경로
     - 모든 Object 백업 : exp userid="계정명/비밀번호 full=y file=백업할파일의 경로
  - 백업파일은 확장자를 ".dmp"로 설정


## 복구
> imp.exe 사용
- 모든 계정은 복구를 수행할 수 있다.

- DOS창에서 수행
    - 도움말 보기 : exp help=y
    - `같은 이름의 객체가 존재`하면 해당 객체는 복구되지 않는다.
    - 테이블만 복구 : imp suerid=계정명/비번 tables=복구할테이블명,,,file=복구할파일의경로,,
    - 모든 Object 복구 : imp  userid=계정명/비번 full=y file=복구할파일의경로

# CRUD ( Create Read Update Delete)
> DB작업의 모든것을 줄여서 부르는 이름

## Create
- CREATE
- INSERT

## READ
- SELECT

## UPDATE
- UPDATE
- ALTER
- GRANT

## DELETE
- DROP
- DELETE
- TRUNCATE
- REVOKE


# SEQUENCE
> 순차적인 번호를 관리하는 객체

- `NEXTVAL`, `CURRVAL`
    - 번호를 얻는 pseudo column을 제공
- `user_sequences`에서 시퀀스를 확인 할 수 있다.

- `NEXTVAL`
    - FILE영역에 존재하는 시퀀스의 값을 변경하고, 접속자 세션에 시퀀스객체를 올리고, 다음 번호를 얻는다.

- `CURRVAL`
    - 접속자세션에 올라와있는 시퀀스객체의 현재 번호를 얻는 일

**SEQUENCE 생성 문법**
```sql
    CREATE SEQUENCE 시퀀스명
    INCREMENT BY 증가하는 수
    START WITH 시작수
    MAXVALUE 끝 값
    CACHE   메모리에 올려놓을 수 -- 20이 기본 설정
    CYCLE | NOCYCLE 반복여부    -- NOCYCLE이 기본 설정
```

- 번호얻기
    - 다음 번호: 시퀀스명.NEXTVAL
    - 현재 번호 : 시퀀스명.CURRVAL 

**SEQUENCE 삭제 문법**
```
    DROP SEQUENCE 시퀀스명 
```