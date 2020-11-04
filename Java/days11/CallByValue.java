package day1104;

/**
 * method의 매개변수가 기본형 데이터형이라면 arguments값이 복사되어 전달된다.
 * method안에서는 복사된 값을 가지고 사용하게 된다.(원본 값에 영향을 끼치지 않는다.)
 * @author owner
 *
 */
public class CallByValue {
	
	/**
	 * 입력되는 i변수의 값과, j변수의 값을 바꾸는 일
	 * @param i 첫번째 매개변수
	 * @param j 두번째 매개변수
	 */
	public void swap(int i, int j) {
		int temp = 0;
		temp = i;
		i = j;
		j = temp;
		System.out.println("swap 전 i=" + i +", j=" +j);
	}
	
	public static void main(String[] args) {

		int i = 11;
		int j = 4;
		
		System.out.println("swap 전 i=" + i + ", j=" + j);
		
		CallByValue c = new CallByValue();
		
		c.swap(i, j);
		
		// 값이 복사되어 전달되므로 method를 호출해도 원래의 값이 변경되지 않는다.
		System.out.println("swap 후 i=" + i +", j=" +j); 
	}//main
}//class
