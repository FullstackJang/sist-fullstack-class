package day1112;

/**
 * 긴 문자열을 사용할 때 쓰는 클래스: StringBuffer, StringBuilder 사용
 * @author owner
 *
 */
public class UseStringBuilder {

	StringBuffer sb;

	public void useStringBuffer() {
		//1. 생성: 클래스에서 다른 클래스의 기능을 사용하기위해 상속(is-a)을 받을 수도 있고, 객체를 직접 생성(has-a)하여 사용할 수도 있음
		sb = new StringBuffer();

		//2. method호출: 객체가 제공하는 일 사용
		//값 추가 (정수,실수,문자,불린,문자열)
//		sb.append("오늘은 ");
//		sb.append(11);
//		sb.append("월");
//		sb.append(12);
//		sb.append("일");
		
		//메소드 체인
		//모든 메서드가 하나의 체인으로 연결
		sb.append("오늘은 ").append(11).append(12).append("일");

		//값 삽입 (인덱스를 지정하여 값을 넣는다.)
		//오늘은 11월 12일
		//0123456789 <- String index 존재
		sb.insert(4, "2020년");
		//오늘은 2020년11월12일

		//값 삭제: 문자열에서 년도 4자리중 앞 2자리 삭제
		// delete(시작인덱스, 끝 인덱스 + 1) // +1 하는 이유 null문자가 포함되어있기 때문
		sb.delete(4,5+1);

		//
		sb.reverse();
		
		//StringBuffer의 내용을 String 할당
		String str = sb.toString();
		System.out.println(str);

	}//useStringBuffer

	public void useStringBuilder() {
		//1. 생성: 클래스에서 다른 클래스의 기능을 사용하기위해 상속(is-a)을 받을 수도 있고, 객체를 직접 생성(has-a)하여 사용할 수도 있음
		StringBuilder sb = new StringBuilder();

		//2. method호출: 객체가 제공하는 일 사용
		//값 추가 (정수,실수,문자,불린,문자열)
		sb.append("오늘은 ");
		sb.append(11);
		sb.append("월");
		sb.append(12);
		sb.append("일");

		//값 삽입 (인덱스를 지정하여 값을 넣는다.)
		//오늘은 11월 12일
		//0123456789 <- String index 존재
		sb.insert(4, "2020년");
		//오늘은 2020년11월12일

		//값 삭제: 문자열에서 년도 4자리중 앞 2자리 삭제
		// delete(시작인덱스, 끝 인덱스 + 1) // +1 하는 이유 null문자가 포함되어있기 때문
		sb.delete(4,5+1);

		//
		sb.reverse();
		
		String str = sb.toString();		
		System.out.println(str);
		
	}//useStringBuilder

	
	
	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();
		usb.useStringBuffer();
		System.out.println("---");
		usb.useStringBuilder();

		//String(문자열)에 + 연산을 사용하면 Compiler가 +연산을 StringBuilder로 변감함
		//		String str = "안녕";
		//		str += "하세요";
		//		str += "오늘은 목요일입니다.";
		//		System.out.println(str);
	}//main
}//class