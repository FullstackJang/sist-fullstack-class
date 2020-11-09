package day1109;

/**
 * 면,행,열로 구성된 삼차원 배열
 * 
 * @author owner
 *
 */
public class Array3 {

	public void useArray3() {
		//1.선언) 데이터형[][][] 배열명 = null;
		int[][][] arr = null;

		//2.생성) 배열명 = new 데이터형[면의 번호][행의 번호][열의 번호];
		//이차원 배열이 몇개있지?가 면의 갯수

		arr = new int[3][2][3]; //모든 방의 값은 초기화
		System.out.println("면의 갯수: " + arr.length + ", 행의 갯수:" + arr[0].length + ", 열의 갯수" + arr[0][0].length);

		//1+2. 선언과 생성을 한번에. 데이터형[][][] 배열명=new 데이터형[면][행][열];
		int[][][] arr1 = new int[4][3][2];		
		System.out.println("면의 갯수: " + arr1.length + ", 행의 갯수:" + arr1[0].length + ", 열의 갯수" + arr1[0][0].length);

		//3.값 할당 배열명[면의 번호][행의 번호][열의 번호];
		//3차원 배열에 면은 2차원배열의 시작주소를 가지고있음
		//3차원 배열에 면,행은 1차원배열의 시작주소를 가지고 있음

		arr[0][0][0] = 10;
		arr[2][1][2] = 1000;

		//4. 값 사용 배열명[면의 번호][행의 번호][열의 번호] = 값;
		System.out.println(arr[0][0][0] + "/" + arr[0][0][1] + "/" + arr[2][0][0] + "/" + arr[2][1][2]);


		//일괄처리
		for(int i = 0; i < arr.length; i++) { // 면
			System.out.println("arr[" + i + "]면 시작");
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println("arr[" + i + "]["+ j +"]행 시작");
				for(int k=0; k < arr[i][j].length; k++) { //열
					System.out.printf("arr[%d][%d][%d]=%d\t", i,j,k,arr[i][j][k]);
				}//end for
				System.out.println("\narr[" + i + "]["+ j +"]행 끝");
			}//end for
			System.out.println("arr[" + i + "]면  끝");
		}//end for
		
		System.out.println("----------------------------------------------");
		//기본형 형식의 사용
		int[][][] arr2 = new int[][][] { {{1,2},{3,4},{5,6}} , {{7,8},{9,10},{11,12}} };
		System.out.println("arr2 배열의 면의 수 " + arr2.length +", 행의 수" + arr2[0].length + ", 열의 수" + arr2[0][0].length);
		
		for(int i = 0; i < arr2.length; i++) { //면
			for(int j = 0; j < arr2[i].length; j++) { //행
				for(int k = 0; k < arr2[i][j].length; k++) {//열
					System.out.printf("arr2[%d][%d][%d]=%d ",i,j,k,arr2[i][j][k]);
				}
				System.out.println();
			}
		}
	}//useArray30

	public static void main(String[] args) {

		Array3 a3 = new Array3();

		a3.useArray3();
	}//main
}//class
