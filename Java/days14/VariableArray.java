package day1109;

/**
 * �����迭(Variable Array): �ึ�� ���� ������ �ٸ� �迭
 * @author owner
 *
 */
public class VariableArray {
	public VariableArray() {
		//1.����) ��������[][] �迭�� = null;
		int [][] arr = null;

		//2.����) ���� ������ �������� �ʴ´�. �迭�� = new ��������[���Ǽ�][];
		arr=new int[5][];

		//3.�� ���� �� ����) �迭��[���ǹ�ȣ] = new ��������[���Ǽ�]; //���� �ʱ�ȭ ��
		arr[0] = new int[5];
		arr[1] = new int[5];
		//���� �ʱ�ȭ: �迭��[���ǹ�ȣ] = new ��������[]{��,,,,};
		arr[2] = new int[] {1,2,3,4}; //new int[]�� ������ �� ����
		arr[3] = new int[] {10,20,30};
		arr[4] = new int[] {100,200,300,400,500,600};


		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]�� ���� ��: %d\n",i,arr[i].length);
		}
		System.out.println("---------------------------------");

		for(int i = 0; i < arr.length; i++) { //��
			for(int j = 0; j < arr[i].length; j++) {//��
				System.out.printf("%d\t",arr[i][j]);
			}
			System.out.printf("\n");
		}
	}//VariableArray

	public static void main(String[] args) {
		new VariableArray();
	}//main
}//class