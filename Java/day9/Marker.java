package day1102;

/**
 * 마카펜을 대상으로 선정하여 제작된 클래스<br>
 * 추상화작업: -명사적인 특징: 뚜껑, 몸체, 색
 * 			-동사적인 특징: 쓴다.
 * @author owner
 *
 */
public class Marker { 

	private int cap,body; //private 접근지정자는 클래스 외부에서 절대 접근 불가능.
	private String color;

	/**
	 * 동사적인 특징: 입력받은 메세지를 설정된 색의 마카펜으로 화이트 보드에 쓰는 일
	 * @param msg 메시지
	 * @return 쓰는 작업
	 */
	public String wrie(String msg) {
		return msg + "를" + color + "색인 마카펜으로 화이트보드에 쓴다.";
	}//write
	
	
}//class
