package day1109;

/**
 * 자식 클래스를 생성하면, 부모클래스가 먼저 생성됨
 * @author owner
 *
 */
public class TestSub extends TestSuper{
	
	public TestSub() {
		super();
		System.out.println("자식 클래스의 생성자");
	}//TestSub
	
	public static void main(String[] args) {
		TestSub ts = new TestSub(); //객체 생성
		
		//코드의 재사용성: 부모클래스에 변수나 method를 자식 클래스에서 자신의 인스턴스로 사용하는 것
		System.out.println("public 변수: " + ts.a); //TestSub클래스에 없지만 TestSub클래스에 있는 것 처럼 사용 가능
		System.out.println("protected변수: " + ts.b);
		System.out.println("default변수: " + ts.c);//같은 패키지 사용가능, 다른 패키지 사용불가

		ts.methodSuper();
		
	}//main
}//class
