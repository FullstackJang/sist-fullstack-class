# INDEX
> 검색을 빠르게 하기 위해 생성하는 객체

- `자동인덱스`
> Oracle에서 자동을 생성해주는 인덱스

- `수동인덱스`
> 개발자가 직접 생성하는 인덱스

- USER_INDEXES에서 생성된 인덱스를 확인 할 수 있다.
    - `UNIQUE INDEX`, `NON UNIQUE INDEX`, `BITMAP INDEX`, `COMPOSIT INDEX`를 지원한다.
- `INDEX`는 `record의 주소(rowid)를 사용한다.`(값은 같은게 존재 할 수 있지만 index는 유일하다.)
    - `ROWID`는 `AAASji(데이터오브젝트번호)` `AAH(파일번호)` `AAAASE(block번호) AAA(ROW 번호)`로 구분되어 있다.
- 인덱스로 설정하는 컬럼선정할 때의 기준
    - `WHERE절`에서 많이 사용되는 컬럼이 되는게 좋다.
    - 자주 변경되지 않는 컬럼이 되어야 한다.(인덱스랑 테이블이랑 서로 다른 객체)
- 인덱스는 언제쓰면 좋은지?
    - 레코드의 양이 많을 때 사용하는 것이 좋다.(레코드 양이 많다는 것은 환경(컴퓨터사양)에 따라 다른다.)
    - 검색의 결과가 전체 레코드의 약 10 ~ 15%정도가 될때

**INDEX 생성 문법**
```sql
    CREATE [ UNIQUE ] INDEX 인덱스명 ON 테이블명(컬럼명,,,);
                                    -- 이 테이블에서 이컬컬럼을 인덱스로 할거야라는 뜻
    -- UNIQUE 붙이면 UNIQUE INDEX
    -- UNIQUE 없애면 NON UNIQUE INDEX
```

**INDEX 삭제 문법**
```sql
    DROP INDEX 인덱스명;
```

**INDEX 리빌드 문법**
> `테이블`과 `인덱스`간의 차이를 없애는 것 
```sql
    ALTER INDEX 인덱스명 REBUILD;
```

## UNIQUE INDEX
- 자동인덱스
    - 테이블에 PRIMARY KEY, UNIQUE제약을 설정하면 자동으로 생성된다.
- 컬럼의 값이 유일할 때 생성하고 사용하는 인덱스

**UNIQUE INDEX 문법**
```sql
    CREATE UNIQUE INDEX 인덱스명 ON 테이블명(컬럼명 [ASC | DESC]);
```

## NON UNIQUE INDEX
- 수동인덱스
- 컬럼의 값이 중복될 때 생성하고 사용하는 인덱스

**NON UNIQUE INDEX문법**
```sql
    CREATE INDEX 인덱스명 ON 테이블명(컬럼명 [ASC | DESC]);
     -- NON UNIQUE는 명시하지 않는다.
```

## BITMAP INDEX
- 수동인덱스
- 컬럼의 값이 중복되지만 컬럼의 값형태가 독특(코드값)할 때 사용하는 인덱스


**BITMAP INDEX 문법**
```sql
    CREATE BITMAP INDEX 인덱스명 ON 테이블명(컬럼명);    
```

## COMPOSIT INDEX
- 수동인덱스
- 컬럼여러개가 합쳐져서 인덱스를 구성

**COMPOSIT INDEX 문법**
```sql
    CREATE UNIQUE 인덱스명 ON 테이블명(컬럼명,,,);
```