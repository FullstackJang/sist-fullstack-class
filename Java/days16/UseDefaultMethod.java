package day1111;

/**
 * interface안에서 업무를 구현 할 수 있는 default method의 사용
 * interface는 extends를 사용하여 interface끼리 다중상속을 할 수 있음
 * 자식 interface는 부모interface의 abstract method를 Override하지 않음
 * @author owner
 *
 */
public interface UseDefaultMethod extends SuperA,SuperB{

	public void methodC();
	
	public default void methodDef() {
		System.out.println("인터페이스가 제공하는 구현된 업무");
	}//methodDef
	
	public default String methodDef1() {
		return "반환값이 있는 default method";
	}//methodDef
	
}
