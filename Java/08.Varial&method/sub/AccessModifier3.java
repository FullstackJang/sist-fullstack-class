package day1030.sub;
import day1030.AccessModifier;

/*
	다른 패키지의 클래스에서 다른 클래스의 instance변수 사용
	public만 가능
*/

public class AccessModifier3 {

	public static void main(String[] args) {

		//1.객체화
		AccessModifier am = new AccessModifier();
		//2. 변수의 사용.
		System.out.println("public : " + am.pub);
//		System.out.println("protected : " + am.pro);
//		System.out.println("private : " + am.pri); // private 사용 불가
//		System.out.println("default:" + am.def);
	}//main
}//class
