package day1229;

/**
 * Singleton pattern을 도입한 클래스
 * @author owner
 */
public class TestSingleton {
	
	private static TestSingleton ts; // 객체가 생성될 때 하나만 생성하기위해 비교용

	//1. 클래스외부에서 직접 객체화를 하지 못하도록 막는다.
		private TestSingleton() {
			
		}//TestSingleton
		
	//2. 객체를 반환하는 method 생성
		public static TestSingleton getInstance() {
			if(ts == null) { //객체가 생성되어있지 않다면
				ts = new TestSingleton();
			}//end if
			
			return ts;
			
		}//getInstance
}//class
