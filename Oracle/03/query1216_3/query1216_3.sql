--- �����ȣ ���̺� ����

-- ( �����ȣ, �õ�, ����, ��, ����, SEQ)

CREATE TABLE zipcode (
zipcode char(7), /*�����ȣ�� ������ ���� 7�ڸ�(����������)*/
sido char(6), /*UTF-8�� �Ǿ��־ �ѱ��� �ѱ��ڴ� 1byte*/
gugun varchar2(25),/*������ 2��~25�ڱ��� �ִ�. ������ 1byte*/
dong varchar2(300),
bunji varchar2(25),
seq number(5)
);

select * from zipcode;
select count(*) from zipcode;
-- truncate table zipcode;

-- �����ȣ ��ȸ : �󵵵� �˻�
select zipcode, sido, gugun, dong,bunji
from  zipcode
where dong like 'ȿ����%';

