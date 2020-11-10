package day1110;
import java.util.*;
/**
 * annotation 사용
 * @author owner
 *
 */
public class UseAnnotation {

	@Override // annotation Override가 제대로 했는지 컴파일러가 판단
	public String toString() {

		return "나는 주소를 반환하기 싫어요";
	}//toString

	/**
	 * 정상동작을 기대하기 어려운 경우에 설정하는 annotation 
	 * 대체 클래스와 method를 제시
	 * @Deprecated 비추천 method
	 */
	@Deprecated
	public void test() {
		System.out.println("업무코드정의");
	}//test

	//unused - 변수가 사용되지 않을 때 경고
	//rawtypes - 데이터형에 안정성을 위해서 Generic를 사용하는 문법을 권장하는데 
	// 			 Generic을 사용하지 않고 JCF를 사용해야 할 때 경고 없애기	 
	@SuppressWarnings({ "unused", "rawtypes" })
	public void temp() {
		//@SuppressWarnings("unused")
		int i;

		//@SuppressWarnings({ "unused", "rawtypes" })
		List l = null;
	}//temp
	public static void main(String[] args) {
		String str = new String("오늘은 화요일 입니다."); //객체를 출력했을때 주소가 나오지 않는것은 toString()을 Overriding 한것
		System.out.println(str.toString());  //주소x Object.toString()를 Override하여 주소가 아니고 값이 나옴.

		UseAnnotation ua = new UseAnnotation();
		System.out.println(ua.toString()); //주소 Object.toString()를 Override 하지 않아 Object이 제공하는 주소 형태가 문자열로 반환됨
		//Object에 String() getClass().getName() + '@' + Integer.toHexString(hashCode())

		Date date = new Date();
		System.out.println(date); // Object toString()를 Override하여 주소가 아닌 메시지가 반환
		System.out.println(date.toString());
		//		System.out.println(date.getYear() + 1900 ); //비추천 method는 가급적이면 사용하지 않는 것이 좋다.

		ua.test();
	}//main
}//class
