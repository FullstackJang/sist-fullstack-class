package days12;

/**
 * 행과 열로 구성되는 이차원 배열
 * 
 * @author owner
 *
 */
public class Array2 {
	
	
	public void useArray2() {
	

		//1.선언) 데이터형[][] 배열명 = null;
		//       데이터형 배열명[][] = null;
		int[][]	 arr = null;
		
		//2.생성 배열명 = new 데이터형[행의수][열의갯수];
		arr = new int[2][3];
		int arr1[][] = new int[4][5]; //선언과 생성을 한번에
		
		System.out.printf("arr배열은 %d행 %d열\n", arr.length, arr[0].length);
		System.out.printf("arr1배열은 %d행 %d열\n", arr1.length, arr1[0].length);
		
		//3.값 할당
		arr[0][0] = 2020; //가장 처음 방
		arr[1][2] = 39; //가장 마지막 방
		//arr[0] = 30; //행은 주소(1차원 배열의 주소)가 담겨지기 때문에 값을 직접 넣을 수 없다.
		arr[0][1] = 10;
		arr[1][4] = 20;
		arr[2][0] = 30;
		arr[3][2] = 40;
		
		//4.값 사용
		System.out.printf("arr[0][0]=%d, arr[0][1]=%d\n",arr[0][0],arr[0][1]);

		//일괄처리
		for(int i = 0; i < arr1.length; i++) { // 행
			System.out.printf("arr1[%d]행 시작\n",i);
				for(int j = 0; j < arr1[i].length; j++) {
					System.out.printf("arr[%d][%d]=%-4d",i,j,arr1[i][j]);
				}//end for
				System.out.printf("\narr1[%d]행끝\n",i);
		}
	
	}//useArray2
	
	public static void main(String[] args) {
		
		Array2 ar2 = new Array2();
		ar2.useArray2();
	}//main
}//class
