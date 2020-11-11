package day1111;

/**
 * 클래스안에 클래스가 정의되는 클래스
 * @author owner
 *
 */
public class UseInner {
	int outI;

	public UseInner() {
		System.out.println("바깥 클래스의 생성자");
	}//UseInner

	public void outMethod() {
		System.out.println("바깥 클래스의 method outI" + outI);
		
		//안쪽 클래스 호출 시 
		//System.out.println("안쪽 클래스의 변수 j" + j); //변수를 직접접근하여 사용할 수 없음
		//inMethod(); // 안쪽클래스의 method를 직접 접근할 수 없음
		
	}//outMethod

	////////////////// Inner class 시작 ////////////////////
	public class Inner{
		//안쪽 클래스는 변수, 생성자, 메소드를 가질 수 있음
		int j;

		public Inner() {
			System.out.println("안쪽 클래스의 생성자");
		}//Inner

		public void inMethod() {
			System.out.println("안쪽 클래스의 method Inner j=" + j);
			System.out.println("바깥 클래스의 변수 outI=" + outI);
			outMethod();// 바깥 클래스의 method
		}//inMethod

	}//class
	//////////////////Inner class 끝 ////////////////////
	
	@SuppressWarnings("unused")
	public void createInner() {
		//안쪽 클래스를 객체화
		Inner in = this.new Inner(); // this는 method를 호출하는 객체의 주소로 대체
		//Inner in= new Inner(); // this는 생략할 수 있음 this.new => new
		//this.outI

	}//createInner

	public static void main(String[] args) {
		//inner class의 객체화
		//1. 바깥 클래스 객체화
		UseInner ui = new UseInner();
		ui.createInner();		
		
		System.out.println("------------------------");
		//2. 바깥 클래스의 객체를 사용하여 안쪽 클래스의 객체를 생성한다.
		
		//바깥클래스명.안쪽클래스명 객체명 = 바깥클래스의 객체명.new 안쪽클래스의 생성자();
		UseInner.Inner in = ui.new Inner();

		Inner in1 = ui.new Inner(); // 데이터형에 바깥 클래스명을 생락할 수 있음.
		
		in.j = 11;
		in.inMethod(); // 안쪽 클래스의 method에서 바깥 클래스의 변수, method를 호출
	}//main
}//class
