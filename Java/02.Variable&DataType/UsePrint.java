/*
	주석은 컴파일러가 해석하지 않음
	 
*/

class UsePrint{
	
	public static void main(String[] args){


// 값에 대한 출력 -변수
	int i = 10; // 기본형 데이터형
	UsePrint up = new UsePrint(); // 참조형 데이터형
	UsePrint us;
	System.out.println("-------변수 출력----------");
	System.out.println(i); //기본형 데이터형
	System.out.println(up); // 참조형 데이터형: 주소가 출력
	System.out.println("-------연산식의 출력----------");
	System.out.println("10+22="+10+22);
	// 문자열에 +기호를 사용하면 덧붙임의 의미
	System.out.println("10+22="+ (10+22));

	//자동 형변환 : int의 하위데이터형(byte,short)으로 변수 선언하고, 값을 할당 때 발생
	byte b = 1; // 4byte의 리터럴이 1byte로 변환되어 b변수의 할당
	short s = 1; // 4byte의 리터럴이 2byte로 변환되어 s변수의 할당

	System.out.println(b + "," + s);

	//연산의 자동형변환: int의 하위데이터형이 연산되면 결과가 int로 나온다.
	
	byte b1 = 10;
	byte b2 = 20;

	int result = 0; //error: 4byte의 결과를 1byte에 저장할 수 없다.
	//int result = 0; // success: 4byte의 결과를 4byte의 저장할 수 있다.
	result = (byte)b1+(byte)b2; // b1(1byte)과 b2(1byte)를 더하면 결과가 4byte(int)로 발생

	System.out.println(b1 + " + " + b2 + "=" + result);


	char c = 'A'; //문자 A에 대한 Unicode코드 값 할당
	System.out.println(c); // 저장된 Unicode값에 해당하는 문자를 출력


	float f = 3.14f; // 8byte의 리터럴이 4byte로 할당 될 수 없다. 형 명시 f를 붙여줘야한다.
	// 형명시 F를 사용하면 8byte의 리터럴이 4byte의 리터럴로 축소 변환
	System.out.println(f);

	double d = 3.14D; // 형명시 D는 주로 생략한다.
	System.out.println(d);
	
	}//main
}// class