package day1110;

/**
 * AbstractSuper의 자식 클래스(추상클래스의 자식 클래스: 부모클래스의 모든 abstract method를 반드시 Override해야 함(구현해야함))
 * @author owner
 *
 */
public class AbstractSub extends AbstractSuper {

	public AbstractSub() {
		System.out.println("자식클래스");
	}

	@Override
	public void methodB() {
//		super.methodB(); //abstract method는 직접 호출 할 수 없음
		System.out.println("Override한 methodB");
	}//methodB

	@Override
	public  int methodC() {
		return 11;
	}//methodC

	public static void main(String[] args) {
		AbstractSub as = new AbstractSub(); //자식클래스를 객체화하면 부모클래스가 먼저 생성된다.
		
		as.methodA(); //부모가 가진 method
		as.methodB(); //부모의 추상메소드를 Override한 method
		System.out.println(as.methodC()); //부모의 추상메소드를 Override한 method
		/*
		 콘솔 결과
		 
			추상클래스의 생성자
			자식클래스
			일반 method
			Override한 methodB
			11

		*/
	}//main
}//class
