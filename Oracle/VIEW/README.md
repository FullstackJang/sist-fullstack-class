# VIEW
> 실제 테이블을 사용하지 않고 조회를 수행 할 때

- Oracle에서는 `단순 View`와 `복합 View`를 지원
- `권한(CREATE View)`이 부여된 계정만 View를 생성할 수 있다. (권한은 SYS관리자 계정이 부여)

**뷰의 장점**
- 뷰를 만들면 복잡한 쿼리문을 단순화하여 조회할 수 있다.
    - 실제테이블에 DML작업이 발생하면 View에 바로 반영된다.
- 메모리에서 작업하기 때문에 속도가 빠르다.


## 단순VIEW
> 테이블 하나에서 도출된 뷰

- `함수`나``수식`을 포함하지 않고 단순한 컬럼으로만 도출 된 View
- `DML`수행이 가능(View에 작업한 내용이 실제 도출된 테이블에 반영된다.)
- `DML`이 안되면 `with check option`을 부여한다.

## 복합View
> 여러 테이블에서 도출된 뷰

- `함수`나`수식`을 포함하여 도출된 뷰
- `DML`수행이 안된다. (`INSERT`,`UPDATE`,`DELETE`는 불가능)
    - 복합View일때는 `SELECT`만 가능하다.
- `함수`나`수식`을 포함한 뷰는 DML전체를 수행할 수 없다.
- `생성된 View`는 `user_views`테이블에서 조회할 수 있다.

**VIEW 생성 문법**
```sql
    CREATE [OR REPLACE] VIEW 뷰명(컬럼명) AS (SELECT ,,,);
```

**VIEW 삭제 문법**
```sql
    DROP  VIEW 뷰명;
```