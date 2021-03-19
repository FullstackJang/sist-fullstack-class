# 숙제1.
아래 제시된 `제약사항`에 대하여 `레코드를 저장`할 수 있는 `테이블을 생성`하세요.

## **테이블에 저장하고자 하는 값**
- `아이디`
- `이름`
- `나이`
- `성별`
- `주소`
- `부서번호`
- `이메일`
- `입력일`

## **컬럼에 설정해야 하는 제약사항**
- `아이디`는 **null을 허용하지 않으며**, **중복값을 저장할 수 없다.**
- `이름`은 **반드시 입력**되어야한다.
- `나이`는 **20~39살까지**만 `입력가능`하다. 
- `성별`은 **'M'** 또는 **'F'** 만 `입력가능`해야한다.
- `주소`는 **반드시 입력**되어야한다.
- `부서번호`는   dept테이블에 deptno번에 해당하는 번호만 입력가능해야하며
    - dept테이블의 레코드가 삭제되면 같이 삭제 되어야한다. 
- `이메일`을 없을 수도 있지만 있다면 유일해야한다. 
- `입력일`은  입력되지 않는다면 추가되는 시점의 현재 날짜로입력되어야한다.


```sql
        CREATE TABLE member(

            id	 varchar2(15) NOT NULL,
            name varchar2(15) NOT NULL,
            age number(2) CHECK(age BETWEEN 20 AND 29),
            gender char(2) CHECK(gender = 'M' or gender = 'F'),
            addr varchar2(200) NOT NULL,
            email varchar2(50) UNIQUE,
            f_deptno number(2) CONSTRAINT fk_f_deptno REFERENCES dept( deptno )
            ON DELETE CASCADE,
            input_date date DEFAULT SYSDATE,

        CONSTRAINT uk_id primarykey(id)

        );
```

# 숙제 2
### 위의 테이블을 사용하여 모든 제약사항에 대해 성공하는 경우와  실패하는 경우의 쿼리문을 모든 쿼리문을 작성하세요.

## 추가 성공

- **아이디** :  , **이름** : , **나이** : ,**성별** : `'M'` 또는 `'F'`, **주소** :, **이메일** :, **부서번호** :, **입력일** :


## **값이 전부 OK인 경우**
- **아이디** : `OK`  , **이름** : `OK` , **나이** : `OK` ,**성별** : `'M'` 또는 `'F'`, **주소** : `OK` , **이메일** : `OK`, **부서번호** : `OK` , **입력일** : `OK`

```sql
    INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date) 
        VALUES('admin','장일규',28,'M','인천시 계양구','admin@gmail.com',10,SYSDATE);
    COMMIT;
```

<img src = "https://user-images.githubusercontent.com/69107255/102868003-f3b08f00-447c-11eb-8bd3-332827b4e03c.png">

## **이메일이 비어있는 경우**
- 아이디: `OK`  , 이름: `OK` , 나이: `OK` ,성별: `'M'` 또는 `'F'`, 주소: `OK` , 이메일: '', 부서번호: `OK` , 입력일: `OK`

```sql
    INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
    VALUES('admin','장일규',28,'M','인천시 계양구','',10,SYSDATE);
    COMMIT;
```

<img src ="https://user-images.githubusercontent.com/69107255/102870223-155f4580-4480-11eb-83af-78e564dd69a3.png">

## **이메일 컬럼이 없는 경우**
- 아이디: `OK`  , 이름: `OK` , 나이: `OK` ,성별: `'M'` 또는 `'F'`, 주소: `OK` , 부서번호: `OK` , 입력일: `OK`
```sql
    INSERT INTO member(id, name, age, gender, addr, f_deptno, input_date)
    VALUES('admin','장일규',28,'M','인천시 계양구',10,SYSDATE);
    COMMIT;
```

<img src = "https://user-images.githubusercontent.com/69107255/102870652-a9311180-4480-11eb-9883-1973d526fa0c.png">

## **INPUT_DATE 컬럼이 비어있는 경우**
-- 아이디: `OK`  , 이름: `OK` , 나이: `OK` ,성별: `'M'` 또는 `'F'`, 주소: `OK` , 이메일: NULL, 부서번호: `OK` , 입력일: `NO`

```sql
    INSERT INTO member(id, name, age, gender, addr, f_deptno)
    VALUES('admin12','장일규',28,'M','인천시 계양구',10);
    COMMIT;
```
<img src = "https://user-images.githubusercontent.com/69107255/102873871-06c75d00-4485-11eb-95a2-7b6256b18aa7.png">


## **추가 실패**

## **아이디가 중복인 경우**
- ORA-00001: 무결성 제약 조건(SCOTT.PK_ID)에 위배됩니다
```sql
-- 아래 admin.ryu라는 아이디로 추가하였다.
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','류수정',23,'F','서울시 강남구','ryu@gmail.com',20,SYSDATE);

-- 그 후에 동일한 아이디의 다른 컬럼값은 다르지만 'primary key'제약 사항인 중복이 될 수 없는 조건에 걸린다. 
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','김여울',25,'F','서울시 강서구','kim@gmail.com',10,SYSDATE);
```

<img src = "https://user-images.githubusercontent.com/69107255/102875028-991c3080-4486-11eb-8557-ced875aead7f.png">

## **아이디가 NULL인 경우**
- ORA-01400: NULL을 ("SCOTT"."MEMBER"."ID") 안에 삽입할 수 없습니다

```sql
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('','류수정',23,'F','서울시 강남구','ryu@gmail.com',20,SYSDATE);
```

<img src = "https://user-images.githubusercontent.com/69107255/102874909-712ccd00-4486-11eb-9269-1077b78b6fdf.png">

## **20~39살 이외에 나이가 입력된 경우**

- age에 10살을 추가하려고 하고 있음
- ErrorMsg : ORA-02290: 체크 제약조건(SCOTT.SYS_C008792)이 위배되었습니다
```sql
    INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
        VALUES('admin.ryu','류수정',10,'F','서울시 강남구','ryu@gmail.com',20,SYSDATE);
```

<img src = "https://user-images.githubusercontent.com/69107255/102875437-22336780-4487-11eb-99e7-49fc496b8f89.png">

- age에 40살을 추가하려고 하고 있음
```sql
    INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
        VALUES('admin.ryu','류수정',40,'F','서울시 강남구','ryu@gmail.com',20,SYSDATE);
```

<img src = "https://user-images.githubusercontent.com/69107255/102875437-22336780-4487-11eb-99e7-49fc496b8f89.png">


## **gender컬럼에 'M' 또는' F'이외에 값이 들어간 경우**
- ORA-02290: 체크 제약조건(SCOTT.SYS_C008800)이 위배되었습니다

- `gender컬럼`에 **소문자'f'** 를 추가하려고 하고 있음
```sql
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','류수정',22,'f','서울시 강남구','ryu@gmail.com',20,SYSDATE);
```

<img src = "https://user-images.githubusercontent.com/69107255/102875833-ae458f00-4487-11eb-8fa7-9861e037207a.png">

# **ON DELETE CASCADE 성공과 실패** 
- 부서번호는 dept테이블에 deptno번에 해당하는 번호만 입력가능해야하며
    - dept테이블의 레코드가 삭제되면 같이 삭제 되어야한다. 

- dept 테이블
    - 테스트를 위해 deptno컬럼에 50번을 추가하였다.
```sql
select * from dept;
insert into dept(deptno,dname,loc) values (50,'SOFT ENGINEER','INCHEON');
```

<img src = "https://user-images.githubusercontent.com/69107255/102876914-43955300-4489-11eb-8b17-3846f6db6ef7.png">


## **`ON DELETE CASCADE`를 제약조건에 작성하지 않은 경우**

- 부모테이블에서 참조하고 있는 자식레코드가 존재할 때 삭제

1. **50번 dept에 추가하였다.**
```sql
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','류수정',22,'F','서울시 강남구','ryu@gmail.com',50,SYSDATE);
```
<img src = "https://user-images.githubusercontent.com/69107255/102877539-417fc400-448a-11eb-8bd9-20044a9cbc60.png">

2. **부모테이블에서 deptno가 50번인 것을 삭제를 시도했다.** 
```sql
DELETE FROM dept where deptno = 50;
```

3. **deptno에 50번은 자식레코드에 존재하므로 삭제할 수 없다.**

 **ORA-02292: 무결성 제약조건(SCOTT.FK_F_DEPTNO)이 위배되었습니다- 자식 레코드가 발견되었습니다.**
<img src = "https://user-images.githubusercontent.com/69107255/102877746-96bbd580-448a-11eb-8f43-e398d64222f7.png">

### **자식테이블에서 부모테이블의 레코드를 참조하고 있으면 삭제를 못하는것일까?!!!!!**

- **자식테이블에 참조하는 레코드를 지운 후 부모테이블의 레코드를 삭제한다.**

4. **자식 레코드를 삭제한 후**
```sql
DELETE FROM member where f_deptno = 50;
```

<img src = "https://user-images.githubusercontent.com/69107255/102878397-835d3a00-448b-11eb-87b7-6cdbc31d1f83.png">

5. **부모 레코드를 삭제한다.**
```sql
DELETE FROM dept where deptno = 50;
```
<img src ="https://user-images.githubusercontent.com/69107255/102878525-c15a5e00-448b-11eb-8c83-d21bebc3535d.png">

---

## **ON DELETE CASCADE를 제약조건에 작성한 경우**

위에서 member테이블을 생성할 때 `ON DELETE CASCADE`을 작성한 경우이다.

```sql
CREATE TABLE member(
    f_deptno number(2) CONSTRAINT fk_f_deptno REFERENCES dept( deptno ),
	ON DELETE CASCADE
);
```

1. **50번 dept에 추가하였다.**
```sql
INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
VALUES('admin.ryu','류수정',22,'F','서울시 강남구','ryu@gmail.com',50,SYSDATE);
```
<img src = "https://user-images.githubusercontent.com/69107255/102879300-e3081500-448c-11eb-9a1f-a3357fdacbc6.png">

2. **ON DELETE CASCADE**가 설정되어있어 부모테이블의 레코드를 삭제하면 모든 자식테이블의 모든 레코드가 삭제된다.
** 
```sql
DELETE FROM dept WHERE dname = 'SOFT ENGINEER';
```
### **member table**<br>
<img src = "https://user-images.githubusercontent.com/69107255/102879960-f4055600-448d-11eb-84d2-ac9fe0caec72.png"> <br>

### **dept table**<br>
<img src = "https://user-images.githubusercontent.com/69107255/102879695-8bb67480-448d-11eb-819b-49600530ab44.png">


## **이메일이 유일하지 않은 경우**

- 이메일이 `ryu@gmail.com`인 회원을 추가해주고, 이메일을 중복해서 `ryu@gmail.com`로 추가하려고 시도하였다. -실패-
```sql

    INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
    VALUES('admin.ryu','류수정',23,'F','서울시 강남구','ryu@gmail.com',20,SYSDATE);

    -- ryu@gmail.com 이메일 중복
    INSERT INTO member(id, name, age, gender, addr, email, f_deptno, input_date)
    VALUES('admin.kim','김민지',26,'F','경기도 수원시','ryu@gmail.com',30,SYSDATE);

```

ORA-00001: 무결성 제약 조건(SCOTT.SYS_C008851)에 위배됩니다
<img src = "https://user-images.githubusercontent.com/69107255/102880252-5cecce00-448e-11eb-9a7e-4c1c454b0207.png">