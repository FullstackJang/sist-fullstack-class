-- rollback

commit;

insert into student (num, name) values (1, '테스트');

update student
set name='테스트1';
where name='테스트';

rollback;

select * from student;


-- savepoint : rollback으로 원하는 지점까지 취소할 때.
savepoint insert_a;

insert into student(num,name,addr) values(1,'류수정','서울시 마포구 공덕동');

savepoint update_b;

update student
set addr='서울시 강남구 역삼동', age =20
where num =1;

savepoint delete_c;

delete from student
where num=1;

select * from student;

-- commit;
--rollback; /*직전 commit 이후까지 작업이 취소된다.*/

rollback to insert_a; /*저장점까지 작업이 취소된다. `commit`되면 저장점 자체가 사라지므로 `rollback to 저잠정명`을 사용할 수 없다. */

--테이블 삭제 : 레코드의 유무에 상관없이 테이블은 삭제된다.
drop table student;

select * from tab;

-- 휴지통에 버려진 테이블확인

-- 테이블복구
flashback table student to before drop;


-- 휴지통 비우기
purge recyclebin;

