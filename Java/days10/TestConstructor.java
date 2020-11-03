package day1103;

public class TestConstructor {

	/**
	 * 기본생성자
	 */
	public TestConstructor() {
		System.out.println("기본 생성자");
	}

	/**
	 * 생성자의 Overload : 생성자를 여러개 만들 수 있으므로
	 * 객체화를 다양하게 할 수 있다.
	 * @param i
	 */
	public TestConstructor(int i) {
		System.out.println("매개변수 있는 생성자");
//		TestConstructor(); //생성자는 직접 호출 할 수 없다.
//		method(); // method는 직접 호출
	}


	public void method() {
		System.out.println("일반method");
	}

	public static void main(String[] args) {
		new TestConstructor(20); //생성자를 호출하면 객체가 하나 생성된다.
	}//main
}//class
