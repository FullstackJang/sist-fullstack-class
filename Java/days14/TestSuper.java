package day1109;

/**
 * 부모 클래스: 자식 클래스가 가져야할 공통 특징의 정의
 * (자식클래스가 공통적으로 사용할 변수, method를 정의)
 * @author owner
 */
public class TestSuper {
	public int a;
	protected int b;
	int c; //default, package 접근 지정자
	private int d;
	
	public TestSuper() {
		System.out.println("부모클래스의 생성자");
	}//TestSuper
	
	public void methodSuper() {
		System.out.println("부모클래스의 method");
	}//methodSuper
	
}//class