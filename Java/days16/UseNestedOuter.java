package day1111;

/**
 * ��øŬ����: Ŭ�����ȿ� static Ŭ������ �����ϴ� Ŭ����
 * @author owner
 *
 */
public class UseNestedOuter {
	int OutI; //instance ����
	static int outJ; // static ����

	//Nested class�� �����ڸ� �������� �ʴ´�.
	//static �޼ҵ� ����ó�� ����ϱ� ������ ���� ����
	//	public UseNestedOuter(){
	//	}

	public void outInsMethod() {
		System.out.println("�ٱ� Ŭ������ �ν��Ͻ� method");
	}//outInsMethod


	public static void outStaMethod() {
		System.out.println("�ٱ� Ŭ������ static method�Դϴ�.");
	}//outStaMethod

	/////////////////////Nested class�� ���� /////////////////////

	static class Inner{
		// Ŭ���� ������ �⺻������ instance����
		static int i;
		int j;
		//Nested class�� �����ڸ� �������� �ʴ´�.
		//static �޼ҵ� ����ó�� ����ϱ� ������ ���� ����
		//Inner(){ 
		//}

		public static void inMethod() {
			System.out.println("���� Ŭ������ method");
			//OutI = 100; //static ���������� instance variable�� ����� �� ����
			//outInsMethod();//static ���������� instance method�� ����� �� ����
			
			outJ = 100;
			outStaMethod();
		}//inMethod
	}//Inner

	/////////////////////Nested class�� �� /////////////////////
	public static void main(String[] args) {


		Inner.inMethod(); //���� Ŭ������ method�� static�������� ����� �� ����

	}//main
}//class
