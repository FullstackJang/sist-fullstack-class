-- ��¥ ��ȯ

							-- �տ��� ��¥�̰� �ڿ��� ���ڿ��̴�.
SELECT TO_DATE('2020-12-17','yyyy-mm-dd'), '2020-12-17'
FROM dual;
											-- '2020-12-17�̶�� ���ڿ��� ���� �������� ����� ���� ������ ������ �߻� ���� �ʰ�  ������ ����� �� �ִ�.
SELECT TO_CHAR(TO_DATE('2020-12-17','yyyy-mm-dd'),'dd')
FROM dual;

-- INSERT�� ��¥ �߰�
INSERT INTO STUDENT(num,name, input_date) VALUES ('7','�ڿ�',SYSDATE);

-- ���糯¥�� �ƴ� �ٸ� ��¥�� �߰�
-- 1. ��¥������ ���ڿ�
INSERT INTO STUDENT(num,name, input_date) VALUES ('8','�����', '2020-12-17');

-- 2. TO_DATE()�� ����Ͽ� ��¥ ������ ���ڿ��� ��¥�� ��ȯ�Ͽ� �߰��� �� �ִ�.
INSERT INTO STUDENT(num,name, input_date) VALUES ('9', '�̳���', TO_DATE('2020-12-17','yyyy-mm-dd') );

COMMIT;

SELECT num, TO_CHAR(input_date,'yyyy-mm-dd day hh24:mi:ss') FROM STUDENT;


-- ���ں�ȯ: TO_NUBMER
						--���ڿ� - ���ڿ��� �ȵǴ°����� Oracle�� ����ȯ�� �ڵ������� ó�����ش�.
SELECT '1' , '2'-'1'
FROM dual;


-- ���ڿ��� ������ ���� TO_NUMBER()�� ����ؼ� ����������.
SELECT '1' , '2', TO_NUMBER('2') - TO_NUMBER('2')
FROM dual;

-- ���������� �ƴ� ���ڿ��� �ԷµǸ� Error
SELECT TO_NUMBER('��')
FROM dual;
