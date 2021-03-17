package day1111;

/**
 * 인터페이스를 구현한 클래스
 * 클래스에서 필요한 모든 인터페이스를 구현할 수 있음
 * 문법
 * 접근지정자 class 클래스명 implements 인터페이스명,,,,{ }
 * 
 * @author owner
 *
 */
public class TestSuperimpl implements TestSuper {

	@Override
	public void methodA() {
		System.out.println("Override한 methodA 호출");
	}//methodA

	@Override
	public void methodB() {
		System.out.println("Override한 methodB 호출");
	}//methodB

	@Override
	public String name() {

		return "장일규";
	}//name

	public void subMethod() {
		System.out.println("자식의 method");
	}//subMethod

	public static void main(String[] args) {
		//인터페이스는 객체화가 되지 않음
		//TestSuperimpl ts = new TestSuper(); //생성자가 없어서 객체화가 불가

		//인터페이스는 구현한 클래스의 힙에 있는 객체 주소를 저장할 수 있음(is-a관계의 객체화)
		//ts객체로 호출 가능한 것: 부모의 변수 지원, 부모의 method(abstract method)=>Override된 method 호출
		// 부모가 자식을 가리키고 있음
		TestSuper ts = new TestSuperimpl();
		ts.methodA();
		ts.methodB();
		//ts.subMethod(); // is-a관계의 객체화를 하면 자식의 자원(변수,method)를 사용할 수 없음. 즉, 부모는 자식을 가르킬 수 있지만 자식이 뭘하는지 모름
		System.out.println(ts.name());
		System.out.println(ts);// 부모에 주소가 아닌 자식에 주소가 나오긴하나 부모에 주소가 담긴다. TestSuperimpl@7bfcd12c

	}
}