package day1111;

/**
 * method 내부에 정의하고, method안에서만 사용되는 지역클래스 사용
 * @author owner
 *
 */
public class UseLocalOuter {

	int outI;
	
	public void method(int param_i, int param_j) {
		int locI =10;
		int locJ =20;

		/////////////// 지역클래스 시작 ////////////////
		class Local {
			int i;
			
			public Local() {
				System.out.println("지역 클래스");
			}//Local
			
			public void localMethod() {
				System.out.println("지역클래스의 method입니다. i = " + i);
				System.out.println("바깥클래스의 인스턴스변수 outI = " + outI);
				System.out.println("method안의 지역변수 locI = " + locI);
				System.out.println("method안의 지역변수 locJ = " + locJ);
				System.out.println("method안의 매개변수 param_i = " + param_i);
				System.out.println("method안의 매개변수 param_j = " + param_j);
				
				//지역클래스에서 바깥 클래스의 인스턴스 변수에 값 할당은 가능
				outI = 34;
				
				//locI = 1; //지역변수 출력은 가능하나 값할당은 할 수 없음
				//locJ = 1; //지역변수 출력은 가능하나 값할당은 할 수 없음
				//param_i = 1; //값할당은 할 수 없음 
				//param_j = 1; //값할당은 할 수 없음
			}//localMethod
			
		}//class
		/////////////// 지역클래스 끝  ////////////////
//		locI=1000;
//		param_i= 20000;
		//지역클래스의 객체화
		Local loc = new Local();
		loc.i = 100;
		loc.localMethod();
		
	}//method

	public static void main(String[] args) {

		UseLocalOuter ulo = new UseLocalOuter();
		ulo.method(2020,11);
	}//main
}//UseLocalOuter
