package day1111;

/**
 * 중첩클래스: 클래스안에 static 클래스를 정의하는 클래스
 * @author owner
 *
 */
public class UseNestedOuter {
	int OutI; //instance 변수
	static int outJ; // static 변수

	//Nested class는 생성자를 정의하지 않는다.
	//static 메소드 변수처럼 사용하기 때문에 넣지 않음
	//	public UseNestedOuter(){
	//	}

	public void outInsMethod() {
		System.out.println("바깥 클래스의 인스턴스 method");
	}//outInsMethod


	public static void outStaMethod() {
		System.out.println("바깥 클래스의 static method입니다.");
	}//outStaMethod

	/////////////////////Nested class의 시작 /////////////////////

	static class Inner{
		// 클래스 안쪽은 기본적으로 instance영역
		static int i;
		int j;
		//Nested class는 생성자를 정의하지 않는다.
		//static 메소드 변수처럼 사용하기 때문에 넣지 않음
		//Inner(){ 
		//}

		public static void inMethod() {
			System.out.println("안쪽 클래스의 method");
			//OutI = 100; //static 영역에서는 instance variable를 사용할 수 없음
			//outInsMethod();//static 영역에서는 instance method를 사용할 수 없음
			
			outJ = 100;
			outStaMethod();
		}//inMethod
	}//Inner

	/////////////////////Nested class의 끝 /////////////////////
	public static void main(String[] args) {


		Inner.inMethod(); //안쪽 클래스의 method를 static문법으로 사용할 수 있음

	}//main
}//class
