package day1029;


/*
		 ���۰� ���� �� �� ������ ����ϴ� �ݺ���
		 �ּ� 1���� ����!! �ִ� ���Ǳ��� ����
		 do {
		 	�ݺ����� �����
		 }while(���ǽ�);
*/

public class UseDoWhile {

	public static void main(String[] args) {

		
		int i = 100; //�ʱⰪ
		
		do {
			System.out.println("i=" + i); //�ݺ����� ����
			i++; //��,���ҽ�
		}while(i < 10); // ���ǽ�
		
		//-------------------------------------------------------
		//Solve 1
		//1~100������ �� �߿� 4�� ����� ������ ���
		int cnt = 0; //����� ����
		int sum = 0;
		int j = 1;
		do {
			
			if(j%4 == 0) {
				sum += j; //���� ǥ�� sum = sum + j;
				cnt++; //���� ǥ��  ++cnt; // cnt+=1; // cnt= cnt+1;
			}// end if
			j++;
		}while(j <= 100);
		System.out.println("4�� ����� ��:" + sum + " 4�� ��� ����:" + cnt);
		
		
	}//main
}//class
