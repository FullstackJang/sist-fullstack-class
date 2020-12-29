package day1229;


public class UseSingleton {
		
	public static void main(String[] args) {
		//Singleton pattern이 도입된 클래스는 외부에서 직접객체화 할 수 없다.
		//TestSingleton ts = new TestSingleton();
		
		//객체는 객체를 얻을 수 있는 method(method)를 사용하여 객체를 얻는다.
		TestSingleton ts = TestSingleton.getInstance();
		TestSingleton ts1 = TestSingleton.getInstance();
		
		System.out.println("ts: " + ts);
		System.out.println("ts1: "+ ts1);
	}//main
}//class
