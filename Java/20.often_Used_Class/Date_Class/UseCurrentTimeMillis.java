package day1113;

/**
 * �ý����� �ð� ���
 * @author owner
 *
 */
public class UseCurrentTimeMillis {

	public UseCurrentTimeMillis() {
		//System.out.println(System.currentTimeMillis());
		
		long startTime =  System.currentTimeMillis();
		for(int i = 0; i < 5000; i++) {
			System.out.println("i = " + i);
		}//end for
		long endTime =  System.currentTimeMillis();
		System.out.println((endTime - startTime)+"ms");
	}//UseCurrentTimeMillis

	
	
	
	public static void main(String[] args) {

		new UseCurrentTimeMillis();
		
	}//main
}//class
