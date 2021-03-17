package day1127;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintErrorMsg {
	public static void main(String[] args) {

//		System.out.println("정상 출력");
//		System.err.println("비정상 출력");
		
	try {
		int i = Integer.parseInt(args[0]);
		System.out.println(i);
	}catch(ArrayIndexOutOfBoundsException aioobe) {
		System.err.println(aioobe.getMessage()); //Index 0 out of bounds for length 0
	}catch(NumberFormatException ne) {
		System.err.println(ne.getMessage()); //예외 이유 
		//For input string: "일"
		
		System.err.println(ne); // 예외처리클래스와 예외 이유
		// java.lang.NumberFormatException: For input string: "일"
		
		ne.printStackTrace(); //Stack에 쌓인 자세한 예외 메시지
		/*java.lang.NumberFormatException: For input string: "일"
			at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
			at java.base/java.lang.Integer.parseInt(Integer.java:652)
			at java.base/java.lang.Integer.parseInt(Integer.java:770)
			at day1127.PrintErrorMsg.main(PrintErrorMsg.java:10)
		*/
	}//end catch
	
	System.out.println("---------------------");

	// instanceof : 연산자 - 객체가 클래스(인터페이스)로 생성된 객체인지 판단.
	// 객체 instanceof 클래스
	PrintErrorMsg pem = new PrintErrorMsg();
	System.out.println(pem instanceof PrintErrorMsg);
	
	ActionListener ae = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};

	System.out.println(ae instanceof ActionListener);
	
	}//main
}//class
