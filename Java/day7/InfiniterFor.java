package day1029;

/*
 * 
 * 무한루프 - 종료되지 말아야할 프로그램을 만들 때
 * 
 */
public class InfiniterFor {

	public static void main(String[] args) {
		for(;;) { //증가하는 수를 세지 않는 무한 루프
			System.out.println("무한 loop");
			break; //반복문을 빠져 나갈 때
		}//end for
		
		for(int i = 0; ;i++) { //증가하는 수를 세는 무한루프
			System.out.println("무한 loop" + i);
			if(i == 50) {
				break;
			}
		}// end for
		
		int arr[] = {1,2,3,4};
		
		System.out.println(arr);
		
		
	}// end main
}
