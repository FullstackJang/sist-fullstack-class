package day1029;

/*
 * 
 * ���ѷ��� - ������� ���ƾ��� ���α׷��� ���� ��
 * 
 */
public class InfiniterFor {

	public static void main(String[] args) {
		for(;;) { //�����ϴ� ���� ���� �ʴ� ���� ����
			System.out.println("���� loop");
			break; //�ݺ����� ���� ���� ��
		}//end for
		
		for(int i = 0; ;i++) { //�����ϴ� ���� ���� ���ѷ���
			System.out.println("���� loop" + i);
			if(i == 50) {
				break;
			}
		}// end for
		
		int arr[] = {1,2,3,4};
		
		System.out.println(arr);
		
		
	}// end main
}
