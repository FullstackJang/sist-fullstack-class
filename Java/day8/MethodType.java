package day1030;
/*
 * method의 4가지 형태
 * 
*/


public class MethodType {

	/**
	 * 반환형 없고 매개변수 없는 형: 고정 일
	 */
	public void typeA() {
		System.out.println("typeA: 고정 일");
	}//typeA
	
	/**
	 * 반환형 없고, 매개변수 있는 형: 가변 일
	 * @param i 입력 값
	 */
	public void typeB(int i) {
		System.out.println("가변 일: " + i);
	}//typeB
	
	/**
	 * 반환형있고, 매개변수 없는 형: 고정 값
	 * @return 정수 값
	 */
	public int typeC() {
		
		return 30;
	}//typeC
	
	/**
	 * 
	 * 반환형 있고, 매개변수 있는 형 - 가변 값
	 * @return
	 */
	public int typeD(char c) {
		
		return (int)c;
	}//typeD
	
	
	public static void main(String[] args) {
	
		//객체화:
		MethodType mt = new MethodType();
		mt.typeA();
		
		mt.typeB(10);
		mt.typeB(20);
		mt.typeB(30);
		
		int today = mt.typeC();
		System.out.println(today);
		
		
		int code = mt.typeD('A');
		System.out.println(code);
	}//main
}//class
