package days12;

/**
 * ��� ���� �����Ǵ� ������ �迭
 * 
 * @author owner
 *
 */
public class Array2 {
	
	
	public void useArray2() {
	

		//1.����) ��������[][] �迭�� = null;
		//       �������� �迭��[][] = null;
		int[][]	 arr = null;
		
		//2.���� �迭�� = new ��������[���Ǽ�][���ǰ���];
		arr = new int[2][3];
		int arr1[][] = new int[4][5]; //����� ������ �ѹ���
		
		System.out.printf("arr�迭�� %d�� %d��\n", arr.length, arr[0].length);
		System.out.printf("arr1�迭�� %d�� %d��\n", arr1.length, arr1[0].length);
		
		//3.�� �Ҵ�
		arr[0][0] = 2020; //���� ó�� ��
		arr[1][2] = 39; //���� ������ ��
		//arr[0] = 30; //���� �ּ�(1���� �迭�� �ּ�)�� ������� ������ ���� ���� ���� �� ����.
		arr[0][1] = 10;
		arr[1][4] = 20;
		arr[2][0] = 30;
		arr[3][2] = 40;
		
		//4.�� ���
		System.out.printf("arr[0][0]=%d, arr[0][1]=%d\n",arr[0][0],arr[0][1]);

		//�ϰ�ó��
		for(int i = 0; i < arr1.length; i++) { // ��
			System.out.printf("arr1[%d]�� ����\n",i);
				for(int j = 0; j < arr1[i].length; j++) {
					System.out.printf("arr[%d][%d]=%-4d",i,j,arr1[i][j]);
				}//end for
				System.out.printf("\narr1[%d]�ೡ\n",i);
		}
	
	}//useArray2
	
	public static void main(String[] args) {
		
		Array2 ar2 = new Array2();
		ar2.useArray2();
	}//main
}//class
