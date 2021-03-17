package day1127;

/**
 * method내의 예외를 method를 호출한 곳에서 처리하도록 만드는 throws 사용
 * @author owner
 *
 */
public class UseThrows implements Cloneable{
	
	/**
	 * 객체의 현재상태를 복제하여 반환하는 일 
	 * @return 복제된 객체
	 */

	//복제 업무를 처리할 때 발생하는 예외를 호출한 곳에서 처리하도록 날림
	public UseThrows cloneObject() throws CloneNotSupportedException {
		
		UseThrows ut = null;
	
		//throws로 날려버린 예외는 try~catch로 처리하지 않아도 된다.
		//객체 복제중 예외가 발생하면 아랫줄의 코드는 실행되지 않는다.
		ut = (UseThrows)this.clone();
		
		System.out.println("복제 성공");
		
		return ut;
	}//cloneObject
	
	public static void main(String[] args) {

		UseThrows ut = new UseThrows();
		
		try {
			UseThrows ut1 = ut.cloneObject();
			System.out.println("복제된 객체 " + ut1);
		} catch (CloneNotSupportedException e) {
			//method를 호출한 곳에서 예외가 발생했을때 처리코드를 작성한다.ㄴㄴㄴ
			System.err.println("복제중 문제 발생");
			e.printStackTrace();
		}//end catch
	
	}//main
}//class
