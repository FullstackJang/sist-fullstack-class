package day1110;

public class SubA extends SuperA {

	public SubA() {
		System.out.println("자식기본 생성자");
	}//SubA
	
	public SubA(int i) {
		this();
		System.out.println("자식 인자 생성자 " + i);
	}
}
