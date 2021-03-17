package day1030.sub;
import day1030.AccessModifier;

/*
 * 	다른 패키지에 있는 AccessModifier을 상속해서 사용했을때
 * 
 * */

public class AccessModifier4  extends AccessModifier{
	int pub = 1;
	public static void main(String[] args) {

		//1.객체화
		AccessModifier4 am4 = new AccessModifier4();
		
		//2. 변수의 사용.
		System.out.println("public : " + am4.pub);
		System.out.println("protected : " + am4.pro);
//		System.out.println("private : " + am4.pri); // private 사용 불가
//		System.out.println("default:" + am4.def); // default 사용 불가
	}//main
}//class
