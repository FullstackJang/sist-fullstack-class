package days12;

public class Array2Init {

	public static final int ROW_ONE = 1;
	
	/**
	 * 
	 * ������ �迭�� �ʱ�ȭ(�⺻�������� ���)
	 * 
	 */
	public void array2() {
		//��������[][] �迭�� = {{��,,,},{��,,,},{��,,,}};
		
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println("arr�迭�� "+ arr.length +"��" + arr[0].length+"��");
		//��� ���� �� ���
		
		int temp = 0;
		for(int i = 0; i < arr.length; i++) { //��
			for(int j = 0; j < arr[i].length; j++) { //��
				switch(i) {
				case ROW_ONE:
					temp+=arr[i][j];
				}
				System.out.print("arr[" + i + "][" + j + "]=" + arr[i][j] + " ");
			}
			System.out.println();
		}//end for
		
		System.out.println("arr�迭�� 1���� ��:" + temp);
		
		
		
		
	}//array2
	
	
	
	
	public static void main(String[] args) {
		
		Array2Init arr = new Array2Init();
		
		arr.array2();
		
	}
}
