--------------------------정렬 -------------------------------

-- 사원명의 오름차순 정렬
-- 컬럼은 오름차순 정렬(asc)이 기본설정
SELECT empno, ename
FROM emp
ORDER BY ename;
--ORDER BY ename asc;

-- 사원명의 내림차순(desc) 정렬
SELECT empno, ename
FROM emp
ORDER BY ename DESC;

-- 사원번호, 사원명, 연봉을 조회
-- 단, 연봉의 내림차순 정렬, 같은 연봉이 있다면 사원명의 오름차순으로 정렬하여 출력할 것
SELECT empno, ename, sal
FROM emp
ORDER BY sal DESC, ename, empno;


-------------문자열의 정렬은 자릿수의 정렬
CREATE TABLE test_orderby (

num VARCHAR2(10)
);

INSERT INTO TEST_ORDERBY(num) VALUES(1);
INSERT INTO TEST_ORDERBY(num) VALUES(11);
INSERT INTO TEST_ORDERBY(num) VALUES(201);
INSERT INTO TEST_ORDERBY(num) VALUES(10001);
INSERT INTO TEST_ORDERBY(num) VALUES(10009);
INSERT INTO TEST_ORDERBY(num) VALUES(2005);
INSERT INTO TEST_ORDERBY(num) VALUES(3);
INSERT INTO TEST_ORDERBY(num) VALUES(4);
INSERT INTO TEST_ORDERBY(num) VALUES(321);
INSERT INTO TEST_ORDERBY(num) VALUES(30001);;

commit;

-- 문자열(VARCHAR2, CHAR)데이터형이 숫자를 가지면 자릿수의 정렬을 수행
SELECT *
FROM TEST_ORDERBY
ORDER BY num;

