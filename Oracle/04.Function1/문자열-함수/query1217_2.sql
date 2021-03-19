--------------------- ���ڿ� �Լ� ---------------------

-- ����
SELECT length('������ ����� �Դϴ�.')
FROM dual;

-- WHERE������ ����� �� �ִ�.
-- ������̺��� ������� 4������ ����� �����, ������� ���ڼ�, �����ȣ, �Ի��� ��ȸ

SELECT ename, length(ename), empno, hiredate
FROM emp
WHERE length(ename)=4;


-- ���ڿ���ġ��
SELECT concat('������','�����') , '������' || '�����'
FROM dual;


-- ù ���ڸ� �빮�ڷ� ��ȯ
SELECT INITCAP('hello'), INITCAP('HELLO'), INITCAP('i am a boy')
FROM dual;

SELECT INITCAP(ename), INITCAP(job)
FROM emp;

-- �빮��, �ҹ��� ��ȯ
SELECT UPPER('AbcdEf'), LOWER('AbcdeF')
FROM dual;


-- ��� ���̺��� ������� 'scott'�� ����� �����ȣ, �����, ����, ���ʽ�, �Ŵ�����ȣ�� ��ȸ
SELECT empno, ename, sal, comm, mgr
FROM emp
WHERE ename = UPPER('scott');
--WHERE LOWER(ename) = 'scott';

-- �ε��� ���
SELECT INSTR('AbcdE','A'), INSTR('AbcdE','B')
FROM dual;

-- ������̺��� ����� 'A'�� �ִ� ����� ������� ��ȸ

SELECT ename
FROM   emp
WHERE instr(ename,'A') <> 0;

-- ���� �ڸ���  SUBSTR(���ڿ�, �����ε���, �ڸ� ���ڼ�)
SELECT SUBSTR('AbcdeF',2,4), SUBSTR('AbcdeF',3,1), SUBSTR('AbcdeF',4,3)
FROM dual;

-- �л����̺��� �̸�,�̸���, �̸����ּ�, ������ �ּ� ��ȸ
SELECT name, email, SUBSTR(email,1,instr(email,'@')-1), SUBSTR(email,instr(email,'@')+1)
FROM student;

-- ���ڿ� ġȯ
-- ��� ������ �����Ҷ��� REPLACE�� ����Ѵ�.
SELECT REPLACE('������ �ݿ��� �Դϴ�.','������','������'), REPLACE('java','a','AAAA'), REPLACE('   A BC   ',' ','')
FROM dual;


-- ���� ����

-- �յ� ���� ���� TRIM()
-- �� ���� ����  LTRIM()
-- �� ���� ����  RTRIM()
-- TRIM�� ���ڿ� �յڿ� Ư�� ���ڿ��� ���ο� �ִٸ� �ش� ���ڿ��� ������ �� �ִ�. TRIM(' ���� ���ڿ�' FROM �÷���)
SELECT '[' || TRIM('   A BC   ') || ']' ,  '[' || LTRIM('   A BC   ') || ']' ,'[' || RTRIM('   A BC   ') || ']'
,TRIM('a' FROM'aaaaaaaaaaaaaOracleaaaaaaaaaaa')
FROM dual;

-- ���ڿ��� ä���� ���� ������ ���ڿ��� ���� ��
-- ��������(���ڿ��� �տ�)  ä�� �� LPAD, ����������(���ڿ��� ��) ä�� �� RPAD

SELECT LPAD('ABcd',10, '#'), LPAD('ABcd',10, '��'),
			 RPAD('ABcd',10, '#'), RPAD('ABcd',10, '��')
FROM dual;


-- ���ڰ� �� 12�ڷ� �����ǰ� 12�ڰ� �ƴ϶�� �տ� 0�� ä�� �־� 12�ڷ� ���� �� �ش� ���� �տ� SIST_ ���ڿ��� �ٿ� SIST_000000000001 �� �������� ����غ�����.
SELECT CONCAT('SIST_',LPAD(1,12,0)) num
FROM dual;

SELECT CONCAT('IT_',LPAD(seq,5,0))
FROM zipcode
WHERE seq < 100;

select * from student;
