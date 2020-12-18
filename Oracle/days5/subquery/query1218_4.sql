-------------- Update Subquery
-- cp_cmp3 테이블에서 사원명이 '류수정'인 사원의 연봉을
-- emp테이블의 사원번호가 7698인 사원의 연봉과 동일한 연봉으로 변경

UPDATE cp_emp3
set sal = (SELECT sal
					FROM emp
					WHERE empno = 7698)
WHERE ename = '류수정';

COMMIT;

-- Delete Subquery
-- emp 테이블의 사원명이 'SCOTT'인 사원의 사원번호와 일치하는 사원을
-- cp_emp3테이블에서 삭제해주세요.

DELETE FROM cp_emp3 WHERE empno = (SELECT empno
																	 FROM emp
																	 WHERE ename = 'SCOTT');

rollback;

-- emp테이블에 부서번호가 20번인 부서의 사원번호와 일치하는 모든 사원을
-- cp_emp3테이블에서 삭제
-- IN에 대해서는 복수형 서브쿼리를 사용할 수 있다.

DELETE FROM cp_emp3
							WHERE empno IN (SELECT empno
															FROM emp
															WHERE deptno = 20
														);
-- rollback;
commit;
select * from CP_EMP3;
select * from emp;


