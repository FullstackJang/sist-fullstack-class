package day1030;

/*
 * Ŭ������ ����Ǹ� �ϳ��� ������ ���������, ��� ��ü�� �����Ͽ�
 * ����ϴ� static (class) variable�� ���
*/

public class UseStaticVariable {

	static int i; //static ���� - �ϳ��� ����(�����Ͽ� �ϳ��� ���)
	int j;// instance ���� - ��ü ���� ����(���� ���)
	public static void main(String[] args) {
		//static ������ Ŭ������ ����ɶ� �޸𸮿� �ö󰡱� ������ ��ü���� ������� �ʰ�
		//Ŭ���������� �����Ͽ� ����Ѵ�.
		System.out.println(i);
		UseStaticVariable usv = new UseStaticVariable();
		UseStaticVariable usv1 = new UseStaticVariable();
		//instance ������ ��ü���� �����Ǵ� �����̹Ƿ� ��ü���� ����Ͽ� ������ ����
		usv.j =100;
		usv1.j=200;
		System.out.println("usv.j:" + usv.j+ ", usv1.j:" + usv1.j);
		// static ������ �ϳ��� �����Ǵ� �����̹Ƿ� ��ü���� ����Ͽ� ������ �����ϴ���
		// ���� ���Ǵ� ���� �ƴϴ�.(���Ŀ� ����� ������ ���ȴ�.)
		// ��ü���� ����Ͽ� ������ ����ϴ� ������ �������� �ʴ´�.
		usv.i=10000;
		usv1.i=30000;
		System.out.println("usv.i:" + usv.i+ ", usv1.i:" + usv1.i);

		//Ŭ������.���������� �������
		UseStaticVariable.i = 100000;
		System.out.println(UseStaticVariable.i);
	}
}
