package day1110;

/**
 * 부모클래스: 자식클래스들이 사용해야 할 공통 코드
 * @author owner
 */
public class TestSuper {
	int i;
	int j;
	
	public TestSuper() {
//		super();
		System.out.println("TestSuper 기본생성자(부모)");
	}//TestSuper

	public TestSuper(int i) {
		this();
		System.out.println("TestSuper 매개변수 있는 생성자(부모)");
	}//TestSuper


	public void print() {
		System.out.println("부모:i=" + i + ", j=" + j );
	}
}//class
