package day1102;

import day1102.Marker;

/**
 * Marker클래스를 생성하고 사용하기 위한 클래스. 
 * @author owner
 *
 */
public class UseMarker {

	/**
	 * Java Application
	 * @param args
	 */
	public static void main(String[] args) {


		//4.클래스를 사용하기 위해서는 개체화를 수행
		Marker black = new Marker();//참조형 데이터형을 사용하기 위해 객체화를 수행
		System.out.println(black.wrie("안녕하세요"));
		Marker red = null;
		System.out.println(red);
	
	}//main
}//class
