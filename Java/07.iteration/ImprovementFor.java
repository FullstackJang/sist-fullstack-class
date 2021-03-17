package day1029;

/*
 *  개선된 for의 사용
 *  인덱스를 사용할 수 없고, 배열, List, Set의 모든 방의 값을 처음 부터 끝까지 출력 할 때 사용
 * 
 */

public class ImprovementFor {
	
	public static void main(String[] args) {
		//Array : 배열
		 int[] arr = {2020, 10, 29, 12, 7};
		 
		 //개선된 for: 인덱스를 사용 할 수 없다.
		 for(int value : arr) {
			 System.out.println(value);
		 }
		 
		 //기존 for :인덱스를 사용할 수 있다.
		 for(int i = 0; i < arr.length;i++) {
			 System.out.println(arr[i]);
		 }
		 
		
	}//main
}//class
