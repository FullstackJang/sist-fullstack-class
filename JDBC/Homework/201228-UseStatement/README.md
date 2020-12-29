# CP_EMP3테이블에 INSERT, UPDATE, DELETE 작업을 Statement 객체를 사용하여 수행

1. INSERT : 사원번호 : 2222, 사원명 : 조유리, 입사일 : 현재날짜, 부서번호 : 20, 직무 : 사원 ,연봉 : 3000

2. UPDATE : 2222사원번호에 해당하는 레코드의 부서번호를 50번으로, 직무를 주임, 연봉 3200으로 변경

3. DELETE : 2222번 사원번호에 해당하는 레코드를 삭제

String sql = "insert into cp_emp3() values(,,,SYSDATE)";