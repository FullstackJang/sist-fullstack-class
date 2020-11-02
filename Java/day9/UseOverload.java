package day1102;

/*
 * ���� �̸��� method�� ������ ������ �� �ִ� Overload�� ���� ���
 *
 * 
 */
public class UseOverload {
	
	/**
	 * ���� �ϳ��� ����ϴ� ��.
	 */
	public void printStar() {
		System.out.print("��");
	}//printStar
	
	/**
	 * ����ڰ� �Է��ϴ� �� ��� ���� ����ϴ� ��.
	 * @param cnt ����� ���� ����
	 */
	public void printStar(int cnt) {
	
		for(int i = 0; i < cnt; i++) {
			System.out.println("��");
		}
	}//printStar
	
	
	
	
	public static void main(String[] args) {
		
		UseOverload uo = new UseOverload();
		
		uo.printStar(2); // ���� �Ϲ��� method�� �ٸ� �Ϥ��� �� �� �ִ�. : ������
		
		System.out.println("------------------------------------");
		
		for(int i = 0; i < 4; i++) {
			for(int j =0; j <=i; j++) {
				uo.printStar();
			}//end for
			System.out.println();
		}//end for

	}//main
}//
