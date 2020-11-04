package day1104;

/**
 * method의 매개변수가 참조형데이터형이면 하나의 주소가 method안으로 전달된다.
 * @author owner
 *
 */
public class CallByReference {

	private int i;
	private int j;
	
	public void swap(CallByReference cbr) {
//		System.out.println("swap:" + cbr); // 주소는 복사되지 않고 그대로 전달
		int temp = 0;
		//heap메모리의 로드된 변수에 직접 작업을 수행
		temp = cbr.i; 
		cbr.i = cbr.j;
		cbr.j = temp;
		
		System.out.printf("swap 안 cbr.i=%d cbr.j=%d\n",cbr.i,cbr.j);
	}//swap
	
	
	/**
	 * 참조형 데이터형을 매개변수로 선언하여 주소를 받으면 주소는 유일하기 때문에 외부에서 사용하는 주소나 내부에서 사용하는 주소는 같은 주소가 된다.
	 * @param args
	 */
	public static void main(String[] args) {
		CallByReference cbr = new CallByReference();
//		System.out.println(cbr);
		cbr.i =11;
		cbr.j = 4;
		
		System.out.printf("swap 전 cbr.i= %d, cbr.j=%d\n",cbr.i,cbr.j);// i = 11, j = 4
		cbr.swap(cbr);	
		System.out.printf("swap 전 cbr.i= %d, cbr.j=%d\n",cbr.i,cbr.j);// i = 11, j = 4
		
	}//main
}//class
