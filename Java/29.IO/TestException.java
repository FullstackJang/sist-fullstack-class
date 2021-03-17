package day1130;

/**
 * 사용자 정의 예외처리 클래스
 * @author owner
 */

//1. 예외처리 클래스를 상속
@SuppressWarnings("serial")
public class TestException extends Exception {

	public TestException() {
		super("예외 발생시 고정적인 메시지");
	}//TestException
	
	public TestException(String msg) {
		super(msg);
	}//TestException
}//class