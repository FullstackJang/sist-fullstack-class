package days12;

public class Array2Init {

	public static final int ROW_ONE = 1;
	
	/**
	 * 
	 * 이차원 배열의 초기화(기본형형식의 사용)
	 * 
	 */
	public void array2() {
		//데이터형[][] 배열명 = {{값,,,},{값,,,},{값,,,}};
		
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println("arr배열은 "+ arr.length +"행" + arr[0].length+"열");
		//모든 방의 값 출력
		
		int temp = 0;
		for(int i = 0; i < arr.length; i++) { //행
			for(int j = 0; j < arr[i].length; j++) { //열
				switch(i) {
				case ROW_ONE:
					temp+=arr[i][j];
				}
				System.out.print("arr[" + i + "][" + j + "]=" + arr[i][j] + " ");
			}
			System.out.println();
		}//end for
		
		System.out.println("arr배열의 1행의 합:" + temp);
		
		
		
		
	}//array2
	
	
	
	
	public static void main(String[] args) {
		
		Array2Init arr = new Array2Init();
		
		arr.array2();
		
	}
}
