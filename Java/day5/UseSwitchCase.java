/*
 	switch~case: ��ġ�ϴ� ������ ���� �� ���
 	switch�� �Էµ� ������ ���� ��ġ�ϴ� case���� ������ ����
 */

public class UseSwitchCase {
	//Constant: ������ ���ó�� ����� ��. (������ ���,������ �Ұ�)
	public static final int GRADE_A_PLUS = 10;
	public static final int GRADE_A = 9;
	public static final int GRADE_B = 8;
	public static final int GRADE_C = 7;
	public static final int GRADE_D = 6;

	public static void main(String[] args) {	

		int i = 1; //�� ���� Ÿ��: byte,short,int,char, String(JDK1.7���� ��밡��)
		//case�� ����� �񱳿뵵�̱� ������ ���� case�� �������(0,1,2,3)�� �ƴϾ �ȴ�.
		//�������̸� ��������� case �ۼ��Ѵ�. (�� �ӵ� ���)
		switch(i) {
			case 0: System.out.println("A"); break;
			case 1: System.out.println("B"); break;
			case 2: System.out.println("C"); 
			default: System.out.println("Z"); break;
		}//end switch


		/*
		  �Է� ������ ���� ���� ���ϱ�
		  90 ~ 100: A
		  80 ~ 89: B
		  70 ~ 79: C
		  60 ~ 69: D
		   0 ~ 59: F
		 */

		int score = Integer.parseInt(args[0]); // �Է°����� ������ ��ȯ�Ͽ� ���� �Ҵ�
		char grade= 'F'; //������ ������ ����
		System.out.println(score + "��");

		System.out.print(score + "���� ");

		switch(score / 10){ // 99->9, 81->8, 77->7
			case 10:
			case 9: grade = 'A'; break;
			case 8: grade = 'B'; break;
			case 7: grade = 'C'; break;
			case 6: grade = 'D'; break;
			default: grade = 'F';
		} //end switch

		System.out.println(grade+ "����");	

		System.out.print("------------------------------------------");

			grade= 64; //������ ������ ����
			System.out.println(score + "��");
	
			System.out.print(score + "���� ");
	
			switch(score / 10){ 
				case 6: grade++; 
				case 7: grade++; 
				case 8: grade++; 
				case 9: 
				case 10: grade++; break;
				default: grade+=6;
			} //end switch
			//A - 65, B - 66, C - 67, D- 68, E - 69, F - 70
			System.out.println(grade+ "����");	

		System.out.print("------------------------------------------");
			score = Integer.parseInt(args[0]); // �Է°����� ������ ��ȯ�Ͽ� ���� �Ҵ�
			grade= 'F'; //������ ������ ����
			System.out.println(score + "��");
	
			System.out.print(score + "���� ");
			switch(score / 10){ // 99->9, 81->8, 77->7
				case GRADE_A_PLUS:
				case GRADE_A: grade = 'A'; break;
				case GRADE_B: grade = 'B'; break;
				case GRADE_C: grade = 'C'; break;
				case GRADE_D: grade = 'D'; break;
				default: grade = 'F';
	
			} //end switch
	
			System.out.println(grade+ "����");	
	}//main
}//class
