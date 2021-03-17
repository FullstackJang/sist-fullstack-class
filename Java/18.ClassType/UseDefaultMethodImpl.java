package day1111;

/**
 * implements로 인터페이스를 구현한 클래스
 * interface가 상속을 받았다면 부모 interface의 모든 abstract method를 Override해야 함
 * @author owner
 *
 */
public class UseDefaultMethodImpl implements UseDefaultMethod {

	/**
	 * SuperA 인터페이스에 존재하는 abstract method
	 */
	@Override
	public void methodA() {
		System.out.println("methodA Override");
	}//MethodA
	
	/**
	 * SuperB 인터페이스의 methodB
	 */
	@Override
	public int methodB(String param) {
		return 11;
	}//methodB
	
	/**
	 * UseDefaultMethod에 존재하는 abstract method
	 */
	public void methodC() {
		System.out.println("methodC Override");
	}
	
	
	
	public static void main(String[] args) {
		//is-a 관계의 객체화 부모 - 자식
		UseDefaultMethod udm = new UseDefaultMethodImpl();
		
		//udm으로 호출 가능한 method
		//구현한 interface에 존재하는 모든 추상method
		//Default method
		
		//호출되지 않으면 자식클래스로 강제 형변환 하여 호출
		//((자식클래스명)객체명).부모의method();
		((UseDefaultMethodImpl)udm).methodA();
		
		udm.methodA();
		
		int temp = udm.methodB("안녕");
		System.out.println(temp);
		
		udm.methodC();
		
		
		/////default method
		udm.methodDef();
		System.out.println(udm.methodDef1());
		
		
	}//main
}//class
