package day1030;


/*
 * instance variable�� ����� ����
 * 
 * 
 * 
 * */

public class UseInstanceVariable {
	
	int year;
	int month;
	

	public static void main(String[] args) {
		// ���α׷��� �����ϸ� ���� ���� ����Ǵ� static ���������� instance������ ������ ���� ����� �� ����.
		// ������ ���� ����� �� ����. => ��üȭ�� �Ͽ� ���
		
		//1.��üȭ : Ŭ������ ��ü�� = new Ŭ������();
		UseInstanceVariable uiv = new UseInstanceVariable();
		//2. ��ü���� ����Ͽ� instance ������ ����Ѵ�. : ��ü��.������
		uiv.year = 2020;
		uiv.month =10;
		System.out.println(uiv.year + "-" + uiv.month);
		
		UseInstanceVariable uiv1 = new UseInstanceVariable();
		//�ٸ� �̸��� ��ü�� �����Ǹ� �� ��ü�ȿ� ���� �̸��� ������ ����� ����.
		uiv1.year = 1993;
		uiv1.month =7;		
		System.out.println(uiv1.year + "-" + uiv1.month);
		System.out.println(((uiv.year - uiv1.year)+1) + "��");
		
	}// main
	
}
