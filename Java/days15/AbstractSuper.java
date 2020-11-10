package day1110;

/**
 * 상속을 위해서 만드는 클래스
 * 자식클래스가 반드시 구현해야할 일의 목록을 abstract method로 정의할 수 있음.
 * @author owner
 *
 */
public abstract class AbstractSuper {

	public AbstractSuper() {
		System.out.println("추상클래스의 생성자");
	}//AbstractSuper

	public void methodA() { // 자식클래스가 호출하여 사용할 수 있는 method
		System.out.println("일반 method");
	}//methodA
	
	//abstract method는 구현의 강제성이 있음(자식클래스에서 반드시 Override 해야함)
	//method의 body가 없는 abstract method : body가 없어서 일을 할 수 없음
	public abstract void methodB();
	public abstract int methodC();
	
	public static void main(String[] args) {
		//new AbstractSuper(); //추상클래스는 직접 객체화 할 수 없음
	}//main

}//class
