package day1030;

/*
 * 클래스가 실행되면 하나의 변수가 만들어지고, 모든 객체가 공유하여
 * 사용하는 static (class) variable의 사용
*/

public class UseStaticVariable {

	static int i; //static 변수 - 하나만 생성(공유하여 하나만 사용)
	int j;// instance 변수 - 객체 마다 생성(각각 사용)
	public static void main(String[] args) {
		//static 변수는 클래스가 실행될때 메모리에 올라가기 때문에 객체명을 사용하지 않고
		//클래스명으로 접근하여 사용한다.
		System.out.println(i);
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		//instance 변수는 객체마다 생성되는 변수이므로 객체명을 사용하여 변수를 접근
		usv.j =100;
		usv1.j=200;
		System.out.println("usv.j:" + usv.j+ ", usv1.j:" + usv1.j);
		// static 변수는 하나만 생성되는 변수이므로 객체명을 사용하여 변수에 접근하더라도
		// 각각 사용되는 것이 아니다.(최후에 변경된 값으로 사용된다.)
		// 객체명을 사용하여 변수를 사용하는 문법을 권장하지 않는다.
		usv.i=10000;
		usv1.i=30000;
		System.out.println("usv.i:" + usv.i+ ", usv1.i:" + usv1.i);

		//클래스명.변수명으로 사용하자
		UseStaticVariable.i = 100000;
		System.out.println(UseStaticVariable.i);
	}
}
