package day1111;

/**
 * 구현 클래스가 반드시 구현해야할 일의 목록만 정의
 * @author owner
 */

public interface TestSuper {
	
	//생성자를 통해 스택에서 값을 할당해줘야하는데 생성자가 없음
	//int i; 변수를 가질 수 없음.
	public static final int MAX = 999999;
	
//	public TestSuper() { 
//		//생성자를 가질 수 없다.
//	}

//	public void test() {
//		//업무를 구현할 수 있는 일반 method를 가질 수 없음
//	}
	
	public void methodA(); //abstract를 사용하지 않은 abstract method	
	public abstract void methodB(); //abstract를 사용 한 abstract method
	public abstract String name(); //abstract를 사용 한 abstract method
	
	
}//class