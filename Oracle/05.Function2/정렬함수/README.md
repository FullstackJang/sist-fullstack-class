# --------------------------정렬 -------------------------------

# 사원명의 오름차순 정렬
- `컬럼`은 `오름차순 정렬(asc)`이 `기본설정`

```sql
SELECT empno, ename
FROM emp
ORDER BY ename;
--ORDER BY ename asc;
```

<img src = "https://user-images.githubusercontent.com/69107255/102573446-d6548b80-4131-11eb-83b0-9e8da8fa7881.png">

# 사원명의 내림차순(desc) 정렬

```sql
SELECT empno, ename
FROM emp
ORDER BY ename DESC;
```

<img src = "https://user-images.githubusercontent.com/69107255/102573532-f8e6a480-4131-11eb-81ca-79f993c7b75f.png">

- 사원번호, 사원명, 연봉을 조회
    - 단, 연봉의 내림차순 정렬, 같은 연봉이 있다면 사원명의 오름차순으로 정렬하여 출력할 것

```sql
SELECT empno, ename, sal
FROM emp
ORDER BY sal DESC, ename, empno;
```

<img src = "https://user-images.githubusercontent.com/69107255/102573559-0b60de00-4132-11eb-93c7-2abd8aab52fa.png">

--- 

# 문자열의 정렬은 자릿수의 정렬

## 문자열을 정렬하기 위해 테이블 생성
```sql
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
```

<img src = "https://user-images.githubusercontent.com/69107255/102573614-2895ac80-4132-11eb-9eae-385e6206bfd4.png">

- 문자열(VARCHAR2, CHAR)데이터형이 숫자를 가지면 자릿수의 정렬을 수행
```sql
SELECT *
FROM TEST_ORDERBY
ORDER BY num;
```

<img src = "https://user-images.githubusercontent.com/69107255/102573640-38ad8c00-4132-11eb-88b0-141b037f62a8.png">