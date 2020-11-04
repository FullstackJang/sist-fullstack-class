package day1104;

/**
 * 
 * String으로 클래스명을 지었을때 java.lang.String붙여서 사용해야한다.
 * 
 * 개발자가 편하게 사용할 수 있도록 java.lang 패키지의 모든 클래스를 import 처리해준다.
 * (import없이 java.lang 패키지의 클래스를 사용할 수 있다.)
 * 
 * java.lang패키지에 존재하는 클래스의 이름과 동일한 이름으로 클래스를 생성하면
 * 내가 만든 클래스를 먼저 사용하게 된다.
 * 
 * -해경방법 : java.lang 패키지(외부패키지)의 클래스를 full path로 설정하여 사용한ㄴ다.
 * full path : 패키지명.클래스명
 * 
 * 결론 : 가급적이면 외부패키지에서 제공하는 클래스이름과 다르게 설정하자
 *  
 * @author owner
 *
 */
public class String {

	public static void main(String[] args) {

		String str = "ABCD";
		
		String str1 = new java.lang.String("ABCD");
		
	}
}
