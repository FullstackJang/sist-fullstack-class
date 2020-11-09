package day1109;

/**
 * 가변배열(Variable Array): 행마다 열에 갯수가 다른 배열
 * @author owner
 *
 */
public class VariableArray {
	public VariableArray() {
		//1.선언) 데이터형[][] 배열명 = null;
		int [][] arr = null;

		//2.생성) 열의 갯수를 설정하지 않는다. 배열명 = new 데이터형[행의수][];
		arr=new int[5][];

		//3.행 마다 열 생성) 배열명[행의번호] = new 데이터형[열의수]; //방이 초기화 됨
		arr[0] = new int[5];
		arr[1] = new int[5];
		//방을 초기화: 배열명[방의번호] = new 데이터형[]{값,,,,};
		arr[2] = new int[] {1,2,3,4}; //new int[]를 생략할 수 없음
		arr[3] = new int[] {10,20,30};
		arr[4] = new int[] {100,200,300,400,500,600};


		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]행 열의 수: %d\n",i,arr[i].length);
		}
		System.out.println("---------------------------------");

		for(int i = 0; i < arr.length; i++) { //행
			for(int j = 0; j < arr[i].length; j++) {//열
				System.out.printf("%d\t",arr[i][j]);
			}
			System.out.printf("\n");
		}
	}//VariableArray

	public static void main(String[] args) {
		new VariableArray();
	}//main
}//class
