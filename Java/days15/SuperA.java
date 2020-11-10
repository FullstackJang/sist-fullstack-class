package day1110;

public class SuperA {
	public SuperA() {
		this(200);
		System.out.println("부모 기본 생성자");
	}//SuperA
	
	public SuperA(int i) {
		System.out.println("부모 인자 생성자"+ i);
	}
}//class
