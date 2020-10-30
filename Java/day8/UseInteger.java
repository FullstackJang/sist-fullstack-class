package day1030;

/*	
 * 		Integer class에서 제공하는 instance method와 static method의 사용
 * 		-instance method는 객체의 instance 변수의 값을 사용하여 업무처리하는 method
 * 		-static method는 입력된 값으로만 업무처리하는 method
 * 
 * */
public class UseInteger {

	public static void main(String[] args) {
			
		//객체화: 클래스명 객체명 = new 클래스명();
		// Integer을 아래 처럼 쓰는건 좋지않지만 생성자를 배우지않아서.. 일단 객체화		
		Integer i = new Integer(30);
//		byte b =i; 참조형 타입을 기본형 타입에 넣을 수없다. 타입이 다름
		System.out.println("객체 i가 가진값: " + i);
		
		// i객체가 저장하고 있는 instance 변수의 값을 instance method를 사용하여
		// byte형의 값으로 반환 받았다.
		byte b = i.byteValue();
		System.out.println("byte로 받은 값: " + b);
		
		double d = i.doubleValue();
		System.out.println("double로 받은 값: " + d);
		
		//static method는 객체가 가진 값이 아닌 입력된 값으로만 일시적인 업무처리를 하는 method
		Integer.parseInt("2020");
		
		//static method는 객체명으로 호출하지 않는다.
		//i.parseInt("2020"); The static method parseInt(String) from the type Integer should be accessed in a static way
		
		
	}//main
}//class

