package day1030;
/*
 * instance 변수를 사용하여 업무를 처리할 때 주로 만드는 instance method의 사용 예
 * 
 */

public class UseInstanceMethod {
	int year = 2020;
	
	/**
	 * 태어난 년도를 입력받아 나이를 연산하는 업무<br>
	 * 연산식 : 올해 - 태어난 해 + 1<br>
	 * 올해는 2020년으로 instance variable에 저장되어 있다.
	 * @param birth 태어난해
	 * @return 연산된 나이
	 */
	public int getAge(int birth) {
		return year-birth+1;
	}//getAge
	
	public static void main(String[] args) {
		
		
//		getAge(1993); //static 영역은 instance 영역보다 먼저 호출되기 때문에
		// instance 영역의 변수나method를 직접 호출할 수 없다.
		
		//1. 객체화: static 영역에서 instance 영역의 자원(변수,method)을 사용하기 위해
		UseInstanceMethod uim = new UseInstanceMethod();
		
		//2. method호출(객체의 값을 사용하여 업무를 처리한다.)
		int birthYear=1993;
		int age = uim.getAge(birthYear); //instance method 호출
		
		System.out.println(birthYear + "년 생은 " + age + "살");
	
	}//main
}//class
