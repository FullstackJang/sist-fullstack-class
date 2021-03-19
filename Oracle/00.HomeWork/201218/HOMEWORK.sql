-- 1
CREATE TABLE class(

	name VARCHAR2(9),
	age number(2),
	gender number(1),
	blood VARCHAR2(2),
	email VARCHAR2(100)

);

INSERT INTO class(NAME, AGE, GENDER, BLOOD, EMAIL) VALUES('±èÁö¿ø', 22, 2, 'A','kim@test.com');
INSERT INTO class(NAME, AGE, GENDER, BLOOD, EMAIL) VALUES('±è°­¹Î', 23, 1, 'B' , 'kangmin@test.com');
INSERT INTO class(NAME, AGE, GENDER, BLOOD, EMAIL) VALUES('³²ÁöÇö', 27, 2, 'A' , 'nam@eun.co.kr');
INSERT INTO class(NAME, AGE, GENDER, BLOOD, EMAIL) VALUES('¹®Ã¤¿ø', 24, 2, 'B' ,  'moon@sist.co.kr');
INSERT INTO class(NAME, AGE, GENDER, BLOOD, EMAIL) VALUES('¹ÎÀ±±â', 25, 1, 'A' , 'kwon@daum.net');
INSERT INTO class(NAME, AGE, GENDER, BLOOD, EMAIL) VALUES('¹Úº¸°Ë', 25, 1, 'A' , 'park_bo@eun.co.kr');

select * from class;

--2
SELECT name, age, decode(gender,1,'³²ÀÚ',2,'¿©ÀÚ') AS "Gender", (TO_CHAR(SYSDATE,'YYYY')-age)+1 AS "Birth_Year"
FROM class;

--3
SELECT name, SUBSTR(email,0,INSTR(email,'@')-1) AS "Email", SUBSTR(email,INSTR(email,'@')+1) AS domain
FROM class;

--4
SELECT name, age, ROW_NUMBER() OVER(ORDER BY age desc) AS rank
FROM class;

--5
SELECT age, COUNT(*) AS count, SUM(age) AS sum_total, TRUNC(AVG(age)) age_avg, MAX(age) max_age
FROM class
GROUP BY ROLLUP(age);
