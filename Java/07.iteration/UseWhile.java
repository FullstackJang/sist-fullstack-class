package day1029;

/*
 *  ���۰� ���� ���� �� ���� �� ����ϴ� �ݺ���
 *  while : �ּ� 0�� ���� �ִ� ���Ǳ��� ����
 */

public class UseWhile {
	public static void main(String[] args) {
		int i = 10; // �ʱⰪ
		
		while(i < 10) { //���ǽ�
			System.out.println("i = " + i);//�ݺ� ���� ����
			i++; // ��,���ҽ�
		}//end while
		
		//------------------------------------------
		
		//while�� ����Ͽ� ������ 5�� ���
		int j = 1, dan = 5;
		while(j < 10) {
			System.out.println(dan + "*" + j + "=" + dan*j);
			j++;
		}
		
		//------------------------------------------
		//100d���� ���� 0���� 1�� �����ϴ� �ڵ�
		
		int k = 100;
		
		while(k >= 0) {
			System.out.println(k);
			k--;
		}
		
		
		
		
		
		
		
		
	}//main
}//class
