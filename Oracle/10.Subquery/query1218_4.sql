-------------- Update Subquery
-- cp_cmp3 ���̺��� ������� '������'�� ����� ������
-- emp���̺��� �����ȣ�� 7698�� ����� ������ ������ �������� ����

UPDATE cp_emp3
set sal = (SELECT sal
					FROM emp
					WHERE empno = 7698)
WHERE ename = '������';

COMMIT;

-- Delete Subquery
-- emp ���̺��� ������� 'SCOTT'�� ����� �����ȣ�� ��ġ�ϴ� �����
-- cp_emp3���̺��� �������ּ���.

DELETE FROM cp_emp3 WHERE empno = (SELECT empno
																	 FROM emp
																	 WHERE ename = 'SCOTT');

rollback;

-- emp���̺� �μ���ȣ�� 20���� �μ��� �����ȣ�� ��ġ�ϴ� ��� �����
-- cp_emp3���̺��� ����
-- IN�� ���ؼ��� ������ ���������� ����� �� �ִ�.

DELETE FROM cp_emp3
							WHERE empno IN (SELECT empno
															FROM emp
															WHERE deptno = 20
														);
-- rollback;
commit;
select * from CP_EMP3;
select * from emp;


