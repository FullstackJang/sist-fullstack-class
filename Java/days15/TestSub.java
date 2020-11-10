package day1110;

/**
 * 자식 클래스
 * @author owner
 *
 */
public class TestSub extends TestSuper {
	int j; //부모와 같은 이름의 변수
	int k;
	public TestSub() {
		super(11);
		System.out.println("TestSub자식클래스의 기본 생성자");
	}//TestSub

	@Override
	public void print() {
		j = 11; //부모와 자식이 같은 이름의 변수를 가지면 자식에 변수를 먼저 사용함
		k = 10;

		i = 20000;//부모만 가진 변수는 식별되어 사용됨 //this가 숨어있음
		//this.i = 20000; 부모만 가진 변수는 자식클래스의 시작주소인 this로 부터 사용된다. i = 20000;과 동일 

		//-----------------

		super.i = 20000; // 부모만 가진 변수는 부모의 시작인주소 super로부터 사용될 수 있다. 
		//부모와 자식이 같은 이름의 변수를 가지고 있고, 부모의 변수를 사용하기위해서는 반드시 super로만 접근해야한다.
		super.j = 2020;

		//System.out.println(super); // 부모클래스의 주소를 출력할 수 없다.

		System.out.println("자식j= " + j + "/ k=" + k);
		//super.k //자식이 가지고 있는 k는 건너뛰어서 볼수가 없다.
		//print();  => this.print() this가 숨어있는 것
		super.print(); // 자신의 method가 아닌 부모의 method를 호출하고 싶을 때
	}

	public static void main(String[] args) {
		//힙이 생성될때 부모가 밑에 깔리고 자식이 올라간다.
		//자식에 시작주소는 this이고 super로 쓸수있는건 부모의 method와 변수이다.
		//this는 자식의 시작주소 super는 부모의 시작주소
		TestSub ts = new TestSub();
		ts.print();
		//**객체의 주소**로는 부모와 자식이 이름이 같다면 식별되지 못하기 때문에 부모의 자원을 호출할 수 없음
	}//main

}//class
