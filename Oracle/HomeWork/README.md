
- 학원생들에 데이터였지만 개인정보보호법에 준수하여 가상의 이름으로 변경.
- 해당 데이터는 및 sql 쿼리문에 있는 정보들은 **가짜데이터**임

# 숙제 1.
- 아래와 같은 데이터를 저장할 수 있는 `테이블을 생성`하고 `데이터를 추가`하세요.<br>
( 추가되는 데이터를 보고 `컬럼의 데이터형`과 `크기`를 결정할 것.) 
```
'공유,'경기도 파주시', 26,'A','남', 현재날짜
'류수정','서울시 동대문구 동대문동', 24,'AB','여', 현재날짜
'차은우','인천시 미추홀구 미추홀동', 28,'O','남' 현재날짜
'차은우이','서울시 종로구 종로동', 30,'A','남', 현재날짜
'이미주','수원시 영통구 망포동', 27,'B','여', 현재날짜
```
**테이블 생성**
```
create table celeb(

	name varchar2(15),
	addr varchar2(150),
	age number(3),
	blood char(2), // 혈액형 A형 AB형 2byte필요
	gender char(3), /*한글 '남'or'여' 1자당 3byte*/
	input_date date

    insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('공유', '경기도 파주시', 26,'A','남',sysdate);
    insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('류수정', '서울시 동대문구 동대문동', 24, 'AB','여', sysdate);
    insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('차은우', '인천시 미추홀구 미추홀동', 28, 'O','남',sysdate);
    insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('차은우이', '서울시 종로구 종로동', 30, 'A', '남', sysdate);
    insert into celeb(NAME, ADDR, AGE, BLOOD, GENDER, INPUT_DATE) values ('이미주', '수원시 영통구 망포동', 27, 'B', '여', sysdate);


);
```

<img src ="https://user-images.githubusercontent.com/69107255/102195546-0fa6b480-3f02-11eb-9c9f-4be26c1897a4.png">

# 숙제2. 
`숙제 1`에 `insert 된 모든 레코드의 컬럼`을 `조회`하세요.

```
select * from celeb;
```

<img src = "https://user-images.githubusercontent.com/69107255/102196998-eedf5e80-3f03-11eb-8355-fd5949802248.png">

# 숙제 3.
- 위의 정보에서 `이름`이 `'차은우이'`를 찾아 `주소`를 `'서울시 종로구 경복궁'`
으로 `나이`를 `45세`로 `변경`하세요. 
```
update celeb
set    age = 47, addr = '서울시 종로구 경복궁'
where  name = '차은우이';
```
<img src = "https://user-images.githubusercontent.com/69107255/102197141-17ffef00-3f04-11eb-9a10-f95f91c5e7fe.png">

# 숙제4. 
- `work_4`라는 `이름의 저장점`을 `생성`해 보세요.
```
savepoint work_4;
```

# 숙제 5.
위의 `정보`에서 `'차은우이'` 를 찾아 `레코드를  삭제`하세요.

```
delete from celeb
where name = '차은우이';
```

<img src = https://user-images.githubusercontent.com/69107255/102197368-63b29880-3f04-11eb-8423-0b18b74e8d09.png>


# 숙제6. 
`숙제5`에서 `삭제한 작업만 취소`하세요.

```
rollback to work_4;
```


# 숙제 7.
 위의 `테이블`의 `모든 레코드`를 `절삭`하세요.
 ```
 truncate table celeb;
```

<img src = "https://user-images.githubusercontent.com/69107255/102197730-e2a7d100-3f04-11eb-8b40-881ddfff76d1.png">

# 숙제 8.
 위의 `숙제테이블 자체`를 `삭제`하세요.

 ```
 drop table celeb;
```

# 숙제 9.
- `삭제된 테이블`을 `휴지통`에서 `확인`해보세요.
    - SQLPlus문법 이므로 tool에 따라서 안될 수도 있다.

<img src = "https://user-images.githubusercontent.com/69107255/102198336-9a3ce300-3f05-11eb-9a40-a06a52d67b9c.png">


# 숙제 10. 
휴지통을 비워보세요.

```
purge recyclebin;
```