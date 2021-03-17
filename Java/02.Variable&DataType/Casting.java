/*
	강제 형 변환에 대한 예
	(변경 할 데이터형)상수;
	(변경 할 데이터형)변수;
*/

class Casting {
	public static void main(String[] args) {

		float f = 3.1415f; // 형 명시 : 리터럴의 크기 자체를 축소하여 값 ㄶ고 변수에 할당
		int i = 0;

		//i=f; 값의 종류가 다르므로 할당 될 수 없다.
		// 강제 형변환으로 값을 할당 할 수 있따.

		i = (int)f; // .1415가 사라진다.
		System.out.println("float:"+f + "," + "int:" + i);

		float f1 = (float)3.14; // 강제 형 변환 : 리터럴의 크기 자체는 유지되고 변수에 할당할 때 값을 float으로 변경하여 할당

		System.out.println("float: "+ f1);


		byte num1 = 4;
		byte num2 = 26;
		byte result = 0;

		result = (byte)(num1 + num2); //자동형변환 => 강제형변환

		System.out.println(num1 + " + " + num2 + " = " + result);

		char c = 'A'; // Unicode 저장
		System.out.println(c + "의 Unicode값: " + (int)c);

		//casting이 되지 않는 경우 - 기본형 데이터형(값을 저장)을 참조형 데이터형(주소 저장)으로 변환
		/*
		int temp = 4; 
		String s = (int)tmp; => (X)
		*/

		//참조형 데이터형(주소 저장)을 기본형 데이터형(값을 저장)으로 변환.
		/*
		String s = "4";
		int temp = (int)s; => (X)
		*/


		//boolean형은 다른 데이터형으로 강제형변환 되지 않는다.
		/*
		boolean b1 = true;
		System.out.println((int)b1); => (X)
		*/


	}
}
