package day1111;

/**
 * method ���ο� �����ϰ�, method�ȿ����� ���Ǵ� ����Ŭ���� ���
 * @author owner
 *
 */
public class UseLocalOuter {

	int outI;
	
	public void method(int param_i, int param_j) {
		int locI =10;
		int locJ =20;

		/////////////// ����Ŭ���� ���� ////////////////
		class Local {
			int i;
			
			public Local() {
				System.out.println("���� Ŭ����");
			}//Local
			
			public void localMethod() {
				System.out.println("����Ŭ������ method�Դϴ�. i = " + i);
				System.out.println("�ٱ�Ŭ������ �ν��Ͻ����� outI = " + outI);
				System.out.println("method���� �������� locI = " + locI);
				System.out.println("method���� �������� locJ = " + locJ);
				System.out.println("method���� �Ű����� param_i = " + param_i);
				System.out.println("method���� �Ű����� param_j = " + param_j);
				
				//����Ŭ�������� �ٱ� Ŭ������ �ν��Ͻ� ������ �� �Ҵ��� ����
				outI = 34;
				
				//locI = 1; //�������� ����� �����ϳ� ���Ҵ��� �� �� ����
				//locJ = 1; //�������� ����� �����ϳ� ���Ҵ��� �� �� ����
				//param_i = 1; //���Ҵ��� �� �� ���� 
				//param_j = 1; //���Ҵ��� �� �� ����
			}//localMethod
			
		}//class
		/////////////// ����Ŭ���� ��  ////////////////
//		locI=1000;
//		param_i= 20000;
		//����Ŭ������ ��üȭ
		Local loc = new Local();
		loc.i = 100;
		loc.localMethod();
		
	}//method

	public static void main(String[] args) {

		UseLocalOuter ulo = new UseLocalOuter();
		ulo.method(2020,11);
	}//main
}//UseLocalOuter
