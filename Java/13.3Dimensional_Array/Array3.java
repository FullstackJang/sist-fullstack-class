package day1109;

/**
 * ��,��,���� ������ ������ �迭
 * 
 * @author owner
 *
 */
public class Array3 {

	public void useArray3() {
		//1.����) ��������[][][] �迭�� = null;
		int[][][] arr = null;

		//2.����) �迭�� = new ��������[���� ��ȣ][���� ��ȣ][���� ��ȣ];
		//������ �迭�� �����?�� ���� ����

		arr = new int[3][2][3]; //��� ���� ���� �ʱ�ȭ
		System.out.println("���� ����: " + arr.length + ", ���� ����:" + arr[0].length + ", ���� ����" + arr[0][0].length);

		//1+2. ����� ������ �ѹ���. ��������[][][] �迭��=new ��������[��][��][��];
		int[][][] arr1 = new int[4][3][2];		
		System.out.println("���� ����: " + arr1.length + ", ���� ����:" + arr1[0].length + ", ���� ����" + arr1[0][0].length);

		//3.�� �Ҵ� �迭��[���� ��ȣ][���� ��ȣ][���� ��ȣ];
		//3���� �迭�� ���� 2�����迭�� �����ּҸ� ����������
		//3���� �迭�� ��,���� 1�����迭�� �����ּҸ� ������ ����

		arr[0][0][0] = 10;
		arr[2][1][2] = 1000;

		//4. �� ��� �迭��[���� ��ȣ][���� ��ȣ][���� ��ȣ] = ��;
		System.out.println(arr[0][0][0] + "/" + arr[0][0][1] + "/" + arr[2][0][0] + "/" + arr[2][1][2]);


		//�ϰ�ó��
		for(int i = 0; i < arr.length; i++) { // ��
			System.out.println("arr[" + i + "]�� ����");
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println("arr[" + i + "]["+ j +"]�� ����");
				for(int k=0; k < arr[i][j].length; k++) { //��
					System.out.printf("arr[%d][%d][%d]=%d\t", i,j,k,arr[i][j][k]);
				}//end for
				System.out.println("\narr[" + i + "]["+ j +"]�� ��");
			}//end for
			System.out.println("arr[" + i + "]��  ��");
		}//end for
		
		System.out.println("----------------------------------------------");
		//�⺻�� ������ ���
		int[][][] arr2 = new int[][][] { {{1,2},{3,4},{5,6}} , {{7,8},{9,10},{11,12}} };
		System.out.println("arr2 �迭�� ���� �� " + arr2.length +", ���� ��" + arr2[0].length + ", ���� ��" + arr2[0][0].length);
		
		for(int i = 0; i < arr2.length; i++) { //��
			for(int j = 0; j < arr2[i].length; j++) { //��
				for(int k = 0; k < arr2[i][j].length; k++) {//��
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
