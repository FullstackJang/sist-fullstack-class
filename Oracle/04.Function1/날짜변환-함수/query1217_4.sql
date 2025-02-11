-- 날짜 변환

							-- 앞에는 날짜이고 뒤에는 문자열이다.
SELECT TO_DATE('2020-12-17','yyyy-mm-dd'), '2020-12-17'
FROM dual;
											-- '2020-12-17이라는 문자열이 요일 패턴으로 만들어 졌기 때문에 에러가 발생 하지 않고  요일을 출력할 수 있다.
SELECT TO_CHAR(TO_DATE('2020-12-17','yyyy-mm-dd'),'dd')
FROM dual;

-- INSERT에 날짜 추가
INSERT INTO STUDENT(num,name, input_date) VALUES ('7','박원',SYSDATE);

-- 현재날짜가 아닌 다른 날짜를 추가
-- 1. 날짜형식의 문자열
INSERT INTO STUDENT(num,name, input_date) VALUES ('8','배수지', '2020-12-17');

-- 2. TO_DATE()를 사용하여 날짜 형식의 문자열을 날짜로 변환하여 추가할 수 있다.
INSERT INTO STUDENT(num,name, input_date) VALUES ('9', '이나은', TO_DATE('2020-12-17','yyyy-mm-dd') );

COMMIT;

SELECT num, TO_CHAR(input_date,'yyyy-mm-dd day hh24:mi:ss') FROM STUDENT;


-- 숫자변환: TO_NUBMER
						--문자열 - 문자열은 안되는거짐나 Oracle이 형변환을 자동적으로 처리해준다.
SELECT '1' , '2'-'1'
FROM dual;


-- 문자열을 연산할 때는 TO_NUMBER()을 사용해서 연산해주자.
SELECT '1' , '2', TO_NUMBER('2') - TO_NUMBER('2')
FROM dual;

-- 숫자형식이 아닌 문자열이 입력되면 Error
SELECT TO_NUMBER('이')
FROM dual;
