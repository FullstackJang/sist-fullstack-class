package day1030;


/*
 * instance variable의 선언과 사용법
 * 
 * 
 * 
 * */

public class UseInstanceVariable {
	
	int year;
	int month;
	

	public static void main(String[] args) {
		// 프로그램을 실행하면 가장 먼저 실행되는 static 영역에서는 instance영역의 변수는 직접 사용할 수 없다.
		// 변수를 직접 사용할 수 없다. => 객체화를 하여 사용
		
		//1.객체화 : 클래스명 객체명 = new 클래스명();
		UseInstanceVariable uiv = new UseInstanceVariable();
		//2. 객체명을 사용하여 instance 변수를 사용한다. : 객체명.변수명
		uiv.year = 2020;
		uiv.month =10;
		System.out.println(uiv.year + "-" + uiv.month);
		
		UseInstanceVariable uiv1 = new UseInstanceVariable();
		//다른 이름의 객체가 생성되면 그 객체안에 같은 이름의 변수가 만들어 진다.
		uiv1.year = 1993;
		uiv1.month =7;		
		System.out.println(uiv1.year + "-" + uiv1.month);
		System.out.println(((uiv.year - uiv1.year)+1) + "살");
		
	}// main
	
}
