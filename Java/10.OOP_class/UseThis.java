package day1104;

/**
 * this의 method형식<br>
 * 문법 ) this(값,,,);
 * 생성자에서 다른 생성자를 호출 할 때
 * @author owner
 *
 */
public class UseThis {

	/**
	 * 기본생성자: new UseThis();
	 */
	public UseThis() {
		this(11);
		System.out.println("기본생성자:Default Constructor");
	}//UseThis

	/**
	 * 오버로딩된 생성자 : new UseThis(정수의값);
	 * @param tmep
	 */
	public UseThis(int tmep) {
		//this(); // 생성자의 첫번째 줄에서만 사용 가능
		System.out.println("매개변수 있는 생성자:Overload Constructor");
	}//UseThis

	public static void main(String[] args) {

		new UseThis();

	}//main
}//class
