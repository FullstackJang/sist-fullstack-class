/*
	if~else문: 둘 중 하나의 코드가 반드시 실행 되어야할 때
	문법:
		if(조건식) {
			조건에 맞을 때 실행될 문장들...
		}
		else {
			조건에 맞지 않을 때 실행 될 문장들...
		}
 */

public class UseIfElse {

	public static void main(String[] args){

		int num = Integer.parseInt(args[0]);

		System.out.print(num + "은(는)");

		if(num >= 0) {
			System.out.println("양수");
		}
		else {
			System.out.println("음수");
		}//end else

		//입력받은 수가 "홀수"인지 "짝수"인지 출력 코드

		if(num % 2 == 1) {
			System.out.println("홀수");
		}
		else {
			System.out.println("짝수");
		}//end else

		//입력되는 두번째 arguments는 나이입니다. 입력된 나이를 사용하여 "성년"인지 "미성년"인지를 출력하는 코드 작성
		// 성년 판정 19살 이상 이다.

		int age = Integer.parseInt(args[1]);

		System.out.print("입력나이 " + age + "살은");

		if(age > 18) {
			System.out.println("성년");
		}
		else {
			System.out.println("미성년");
		}

		// 세번째 arguments로 점수가 입력된다. 입력된 점수가 0 ~ 100점 사이면 "유효점수" 그렇지 않으면 "잘못된 점수"를 출력

		int score = Integer.parseInt(args[2]);

		if(score >= 0 && score <= 100) {
			System.out.println("유효점수");
		}
		else {
			System.out.println("잘못된 점수");
		}

		// 네번째 arguments로 언어의 종류가 입력된다. 
		// 입력된 언어가 Java 또는 Python 또는 C# 일 때에는 "최근 OOP언어"를 출력하고
		// 그렇지 않다면 "프로그래밍 언어"를 출력

		if(args[3].equals("Java") || args[3].equals("Python") || args[3].equals("C#")) {
			System.out.println("최근OOP언어");
		}
		else {
			System.out.println("프로그래밍 언어");
		}


		// 다섯번째 입력값을 long(Wrapper class)으로 처리하고
		//입력값이 int의 범위(Wrapper Class Contant)일때는
		// "int"를 출력하고 그렇지 않으면 "long"을 출력하는 코드 작성

		long inputNum = Long.parseLong(args[4]);

		if(inputNum >= Integer.MIN_VALUE  && inputNum <= Integer.MAX_VALUE) {
			System.out.println("int의 범위");
		}
		else {
			System.out.println("long의 범위");
		}//end else
		
		
		
		
		
	}//main
}
