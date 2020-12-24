-- 인덱스 조회
SELECT * FROM USER_INDEXES
WHERE table_name = 'EMP';

-- 리빌드
ALTER INDEX pk_emp REBUILD;
SELECT * FROM CP_EMP4;

-- 인덱스 생성
-- cp_emp4테이블에 사원번호 컬럼을 인덱스로 설정
CREATE UNIQUE INDEX idx_cp_emp4 ON cp_emp4(empno);
SELECT * FROM USER_INDEXES;

-- index hint : /*+ hint */
SELECT /*+ empno */empno, ename, job, mgr
FROM 	 cp_emp4
WHERE  empno = 7902;


-- 인덱스 삭제
DROP INDEX idx_cp_emp4;
SELECT * FROM USER_INDEXES;

-- 사원명을 NON UNIQUE INDEX로 생성
CREATE INDEX idx_cp_emp4 ON cp_emp4(ename);
SELECT * FROM USER_INDEXES;
SELECT * FROM CP_EMP4;
-- 나도 모르게 index를 사용하고 있는 것
SELECT * FROM cp_emp4
WHERE ename = 'BLAKE';

-- 우편번호를 검색
CREATE TABLE zipcode_idx as (select * from zipcode);

-- gugun에 인덱스 설정
-- 컬럼에 값이 같은 값이 있을 때 UNIQUE INDEX를 만들 수 없다.
-- Eroor ORA-01452: 중복 키가 있습니다. 유일한 인덱스를 작성할 수 없습니다
CREATE UNIQUE INDEX idx_zip ON zipcode_idx( gugun );

-- gugun은 중복되는 값이 있으므로  NON UNIQUE INDEX로 만들어야한다.
CREATE INDEX idx_zip ON zipcode_idx( gugun );
SELECT * FROM USER_INDEXES;

-- 0.172s
SELECT * FROM zipcode
ORDER BY gugun;

-- 0.157s
-- 인덱스를 사용하여 정렬의 효과를 얻을 때에는 컬럼을 인덱스로 부여하고 WHERE절(검색조건)에 "컬럼명 > '0'"를 사용하면 인덱스를 사용한 정렬을 수행
SELECT * FROM zipcode_idx
WHERE gugun > '0';
