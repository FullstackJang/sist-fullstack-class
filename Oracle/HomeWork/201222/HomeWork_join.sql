
/*���� 4.  ������̺���  ������� 'ADAMS' �� ������� ������ ���� �޴�
    ����� �����ȣ, �����, ����,�μ���ȣ,�μ���,��ġ,�����ȣ,�õ�,����,
    �����𵨸�, ����,����,�ɼ�, �Է����� ��ȸ�ϼ���.
  ��. �����ȣ�� seq�� ������ ������ ���� �������� ����Ͽ� ������ ��.
    ���� �𵨸��� ������������ �����ϰ�, �������� ���ٸ� �����
     ������������ �����Ͽ� 1~4��° ���ڵ常 ����մϴ�.*/
--SELECT * FROM CAR_COUNTRY;
--SELECT * FROM CAR_MAKER;
--SELECT * FROM CAR_MODEL;

-- =================

/*����, ���, BMW, BENZ�� ��� ������ ������, ������
 �𵨸�, �ɼ�, ����,�Է����� ��ȸ�ϼ���.
��, �Է����� ������������ �������� �� 3~5��° ���ڵ常 ����ϰ�,
    �ɼ��� ù��°',' ������ ����մϴ�.
    �Է����� 'mm-dd-yyyy' �� �������� ����մϴ�.*/

SELECT * FROM CAR_COUNTRY;
SELECT * FROM CAR_MAKER;
SELECT * FROM CAR_MODEL;

SELECT c_cou.country, c_cou.maker, c_mak.model, substr(c_mod.car_option,1,instr(c_mod.car_option,',')-1), c_mod.car_year, TO_CHAR(hiredate,'mm-dd-yyyy')
FROM car_country c_cou LEFT OUTER JOIN car_maker c_mak
ON c_cou.maker = c_mak.maker
LEFT OUTER JOIN car_model c_mod
ON c_mak.model = c_mod.model
WHERE c_cou.maker IN ('����','���','BMW','BENZ')
ORDER BY hiredate desc;

/*����2. �����ɼǿ� 'ABS' ����� �ִ� ������ ������, ������,�𵨸�,
    ����, ����, �Է���, �̹������� ��ȸ�ϼ���.
  ��, ������ ������������ �����ϵ� ������ ���ٸ� ������ ������������
    �������� �� 2~7��° ���ڵ常 ����մϴ�.
    ���İ� ���ݿ��� 3�ڸ� ���� ','�� �־� ����ϰ�, �ɼ��� 'ABS' ������
    ����մϴ�. �̹������� ó�� '.'������ ����մϴ�.
    �ɼǰ� �̹������� ��� �빮�ڷ� ����մϴ�. */

SELECT * FROM CAR_COUNTRY;
SELECT * FROM CAR_MAKER;
SELECT * FROM CAR_MODEL;

SELECT c_cou.country, c_cou.maker, c_mod.model, c_mod.car_year,c_mod.price, c_mod.hiredate,c_mod.car_img
FROM car_country c_cou LEFT OUTER JOIN car_maker c_mak
ON c_cou.maker = c_mak.maker
LEFT OUTER JOIN car_model c_mod
ON c_mak.model = c_mod.model
WHERE c_mod.car_option  LIKE '%ABS%'
ORDER BY c_mod.price asc, car_year desc;


SELECT rnum, c_cou_country, c_cou_maker, c_mod_model, c_mod_car_year,c_mod_price, c_mod_hiredate,c_mod_car_img, c_mod_car_option
FROM (SELECT ROWNUM rnum, c_cou_country, c_cou_maker, c_mod_model, c_mod_car_year,c_mod_price, c_mod_hiredate,c_mod_car_img, c_mod_car_option
FROM (SELECT c_cou.country AS  c_cou_country, c_cou.maker AS c_cou_maker, c_mod.model AS c_mod_model, TO_CHAR(c_mod.car_year,'999,999') AS c_mod_car_year , TO_CHAR(c_mod.price,'999,999') AS c_mod_price , c_mod.hiredate AS c_mod_hiredate  , UPPER(SUBSTR(c_mod.car_img,1,INSTR(c_mod.car_img,'.')-1)) AS c_mod_car_img, UPPER(substr(c_mod.car_option,1,instr(c_mod.car_option,'ABS')+2)) AS c_mod_car_option
FROM car_country c_cou LEFT OUTER JOIN car_maker c_mak
ON c_cou.maker = c_mak.maker
LEFT OUTER JOIN car_model c_mod
ON c_mak.model = c_mod.model
WHERE c_mod.car_option  LIKE '%ABS%'
ORDER BY c_mod.price asc, car_year desc))
WHERE rnum BETWEEN 2 AND 7;


/*
����3. �����ȣ,�����,����, ���ʽ�, �Ǽ��ɾ�, �Ի���,�μ���ȣ,�μ���, ��ġ,
        �����ȣ,�õ�,����,��, ������ ��ȸ�ϼ���.
   ��. ������� ������������ �������� �� 3~6��° ���ڵ常 ����մϴ�.
        ������� ù���ڸ� �빮�ڷ� ����մϴ�.
       ������ ��ü 7�ڸ��� ���� ','�� �־� ����ϵ� 7�ڸ��� ���� �ʴ� ������
       0�� �־� ����ϼ���.
       �����ȣ�� '-'�ڷ� ���͸� ����մϴ�.
        ������ ���ٸ� '��������'�� ����մϴ�.
*/


SELECT * FROM emp;
SELECT * FROM dept;
SELECT * FROM ZIPCODE;


SELECT ROWNUM rnum, e_empno, e_ename, e_sal, Total_money, e_hiredate, d_deptno, d_dname, d_loc, z_zipcode, z_sido, z_gugun, z_dong, z_bunji
FROM (SELECT e.empno AS e_empno, e.ename AS e_ename, e.sal AS e_sal, TRUNC(e.sal - e.sal*0.033,-1) AS Total_Money, e.hiredate AS e_hiredate, d.deptno AS d_deptno,d.dname AS d_dname,d.loc AS d_loc,
z.zipcode AS z_zipcode , z.sido AS z_sido, z.gugun AS z_gugun, z.dong AS z_dong, z.bunji AS z_bunji
FROM emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno
LEFT OUTER JOIN zipcode z
ON d.deptno = z.seq
ORDER BY e.ename asc)
