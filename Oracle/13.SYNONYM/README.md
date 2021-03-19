# Synonym
- 테이블의 별명

- 테이블을 다른 이름으로 호출 할 수 있는 객체
    - 계정이 달라도 사용할 수 있다.
- `권한`이 설정된 계정만 `Synonym`을 생성할 수 있다.
    - 관리자 계정으로 권한을 확인할 수 있다.
    - **시스템 권한**
        - `dba_role_privs`
    - **쿼리문 생성 권한**
        - `dba_sys_privs`
- `생성된 Synonym`은 `user_synonyms`테이블에서 조회할 수 있다.

- Synonym 권한 부여
```sql
    -- 해당 계정만 사용할 수 있는 Synonym
    GRANT CREATE SYNONYM TO 계정명

    -- 모든 계정이 사용할 수 있는 Synonym
    GRANT CREATE PUBLIC SYNONYM TO 계정명    
```

- **Synonym 생성 문법**
```SQL
    CREATE SYNONYM 시노님명 FOR 테이블명;
```

- **Synonym 삭제 문법**
```SQL
    DROP SYNONYM 시노님명;
```
