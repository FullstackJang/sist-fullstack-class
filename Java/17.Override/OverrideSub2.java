package day1110;

/**
 * OverrideSuper의 자식클래스<br>
 * 자식클래스에서는 부모클래스를 알 수 있음<br>
 * 자식클래스가 객체화되면, 부모 클래스가 먼저 생성되고 난 후 자식클래스가 생성됨(부모의 모든 기능을 사용할 수 있음)
 * @author owner
 *
 */
public class OverrideSub2 extends OverrideSuper {
	/**
	 * Override된 method
	 * Override규칙 : 접근지정자는 달라도 되고, 반환형, method명, 매개변수는 같아야한다.
	 */
	@Override
	public void methodA() {
		System.out.println("OverrideSub2클래스에서 Override한 methodA");
	}//methodA

	/**
	 * Override된 method
	 */
	@Override
	public void methodB() {
		System.out.println("OverrideSub2클래스에서 Override한 methodB");
	}//methodB

	public void childMethod() { // IS-a관계의 객체화가 되었을 때에는 사용할 수 없음
		System.out.println("자식 method");
	}

}