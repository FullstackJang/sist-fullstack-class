package day1030;


/*
 * instance 변수의 자동초기화 값
 * 
 * 
 * */

public class instanceVarialbeDefaultValue {
	//기본형 데이터형의 초기화 값
	int i; //정수형 0 (byte,short, int, long)
	char c; //문자형 \u0000
	float f; //실수형 0.0 (float, double)
	boolean b; //불린형 false
	
	//참조형 데이터형(array,String,class)의 초기화 값 : null
	int[] arr;
	String str;
	AccessModifier am; //class (만들어진 모든 클래스) 

	public static void main(String[] args) {
		//1. 객체화
		instanceVarialbeDefaultValue ivdv = new instanceVarialbeDefaultValue();
		//2. 객체명으로 변수 사용
		System.out.println("정수형: " + ivdv.i);
		System.out.println("문자형:" + ivdv.c); // \u0000에 해당하는 문자가 없기 때문에 출력결과가 눈에 보이지 않는다.
		System.out.println("실수형: " + ivdv.f);
		System.out.println("불린형: " + ivdv.b);
		
		System.out.println("참조형 배열: " + ivdv.arr);
		System.out.println("참조형 문자열: " + ivdv.str);
		System.out.println("참조형 class: " + ivdv.am);
	}//main
}//class
