package day1130;

@SuppressWarnings("serial")
public class CigaretteException extends Exception {

	/**
	 * 일반적인 금연의 예외의 메시지
	 */
	public CigaretteException() {
		super("지나친 흡연을 삼가합시다.");
	}// CigaretteException
	
	/**
	 * 상황에 맞는 금연의 메시지
	 * @param msg
	 */
	public CigaretteException(String msg) {
		super(msg);
	}//CigartteException
	
}//class
