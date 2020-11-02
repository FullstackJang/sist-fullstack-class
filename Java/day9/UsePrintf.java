package day1102;

/*
 * JDK1.5���� ���� ����ϴ� Variable Arguments�� ����� method
 * 
 * */
public class UsePrintf {
	
	public static void main(String[] args) {
		
		int age = 25;
		int year = 2020;
		
		//������ ��� : %d���
		System.out.printf("%d�� ���ش�%d��\n",age,year);
		
		//������ ���
		System.out.printf("%c %c\n", 'A', '��');
		
		//�Ǽ��� ���
		System.out.printf("%f %f\n", 2020.1102, 2020.1102);
		
		//���ڿ��� ���
		System.out.printf("%s %s\n","������","������");
		
		//�ڸ����� ����, -���: ����������, -����: ��������
		System.out.printf("[%4d][%-5d]\n",11,11);
		System.out.printf("[%8.1f][%-8.1f]\n",12.345,12.456);
		
		// printf��format����ϴ°��� ����.
		System.out.format("[%4d][%-5d]\n",11,11);
		System.out.format("[%8.1f][%-8.1f]\n",12.345,12.456);
	
	}//main
}//class
