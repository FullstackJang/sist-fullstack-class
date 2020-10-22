/*
	기본형 데이터형을 이용한 변수의 선언과 사용
	자동 형변환, 형명시
*/

class DataType {
	public static void main(String[] args) {

		//정수를 저장할 수 있는 데이터형. byte,short,int,long
		byte a = 10; // 자동형변환
		short b = 20; // 자동형변환
		int c = 30; 
		long d = 40; // 리터럴의 크기보다 적은 값이 사용될 때, 형명시 생략 가능
		long e = 2147483648L; // 형명시 (리터럴의 크기보다 큰 값이 사용)
		
		System.out.println("byte : " + a + "short: " + b + "int : " + c + "long : " + d + "," + e); 

		//-----문자형-----
		char f = 'A'; // Unicode 값 65 할당
		char g = 'a'; // Unicode 값 97 할당
		char h = '0'; // Unicode 값 48 할당

		System.out.println("char:"+f+","+g+","+h); // 코드 값에 해당하는 문자를 출력
		

		//-----실수형-----
		float i = 2020.22f; // 형명시 필수(8byte의 리터럴을 4byte로 축소)
		double j = 2020.22; // 형명시 생략가능
		System.out.println("float:"+i+", double:"+j);
	
		//-----실수형-----
		boolean k = true;
		boolean l = false;

		System.out.println("boolean:" + k + "," + l);


		//자동형변환: int의 하위데이터형이 연산되면 결과가 int로 나온다.

		byte num1 = 3;
		short num2 = 4;
		// short result = num1 + num2; byte가 short로 변환된 후 short끼리 연산되어 결과가 int로 발생하여 short데이터형에 할당 될 수 없음.
		int result = num1 + num2; // error해결은 short를 int로 바꾼다.

		System.out.println(num1 + "+" + num2 + "=" + result);


	}
}
