package day1110;

public class RunOverride {

	public static void main(String[] args) {

		//자식클래스로 객체 생성
		//부모클래스의 자원과, 자식클래스의 자원을 사용할 수 있다.
		OverrideSub os = new OverrideSub();
		OverrideSub2 os2 = new OverrideSub2();		
		
		os.methodA(); //부모의 method가 호출
		os.methodB();
		//부모의 method가 호출 => 자식의 method가 호출되도록 하고 싶다.
		//method명의 일관성을 위해 method명은 그대로 사용하면서 동작만 다르게 수행 - .다형성
		os2.methodA(); //Override 된 method 호출
		os2.methodB(); //Override 된 method 호출
		os2.childMethod(); //자식클래스가 구현한 method호출
		
		
		System.out.println("----------------------------------");
		
		//is-a 관계의 객체화 -객체 다형성을 사용(같은 클래스로 만들어진 객체가 다른 일을 수행)
		//부모클래스명 객체명 = new 자식클래스의생성자();
		//데이터형이 부모클래스이기 때문에 부모의 자원만 사용가능
		//호출가능한 method는 부모클래스가 가진 method만 호출 가능
		OverrideSuper o_super = new OverrideSub();
		OverrideSuper o_super2 = new OverrideSub2();
		o_super.methodA(); // Override하지 않았기 때문에 부모의 method가 호출
		o_super.methodB(); // Override하지 않았기 때문에 부모의 method가 호출
		
		//Override한 method가 존재하면 부모 클래스의 method를 호출하는 것이 아닌 
		//!!!자식의 method를 최우선적으로 호출!!!
		o_super2.methodA();
		o_super2.methodB();
//		o_super2.childMethod(); //is-a관계의 객체화를 하면 데이터형이 부모클래스이기 때문에 부모 클래스에 해당하는 method만 호출할 수 있음
		//OverrideSuper클래스 타입 설계도에는 childMethod()가 없다.
		//부모는 자식을 가리킬수 있지만 자식은 부모가 뭘하는 지 모른다.
	}//main
}//class
