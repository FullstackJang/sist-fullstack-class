package a1026;

/*
	main method의 arguments 입력
	java 클래스를 실할 때 외부에서 값을 넣어 실해하기
	외부 값을 입력받으면 사용자가 입력한 값으로 프로그램을 실행하기 때문에 프로그램이 동적으로 동작함
	실행) java 클래스명 값 값 값 값 , , , ,
 */

public class UseArguments {

	public static void main(String[] args) {

		System.out.println("첫번째 입력 값:" + args[0]);
		System.out.println("두번째 입력 값:" + args[1]);
		System.out.println("세번째 입력 값:" + args[2]);

		// 외부값을 입력받기 위한 parameter의 데이터형은 String형이고
		// String형은 연산자를 이용한 연산을 할 수 없다. ( Error )
		// + 연산을 할 수 있는데 + 연산은 덧붙임의 연산을 수행한다.

		System.out.println(args[0] + args[1]); // 1026 - 덧붙임의 연산

		// int num1 = args[0]; // 문자열(참조형데이터형)을 정수형에 할당 할 수 없다.
		// 문자열을 정수로 변환하여 할당. 
		// Integer.parseInt() method를 사용
		int num1 = Integer.parseInt(args[0]); // 정수형태의 문자열만 변환가능
		int num2 = Integer.parseInt(args[1]);
		System.out.println(num1+num2); // 36 - 사칙연산 
		// 문자열을 정수로 변환하여 변수에 저장하고, 저장된 정수를 연산한다.
		
	}//main
}// class
