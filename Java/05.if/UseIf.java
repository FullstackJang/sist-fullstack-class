/*
 	���� if�� : ���ǿ� ���� ������ �ڵ带 �����ؾ� �� ��.

 	if( ���ǽ� ) {
 		���ǿ� ���� �� ���� �� �����...
 	}
  
 */


public class UseIf {

	public static void main(String[] args) {

		int i = 27;
		
		if(i < 0) {
			i = -i;
		}// end if
		
		System.out.println("i�� " + i);
		
		System.out.println("------------------------------------");
		
		if( (i >= 0) && (i<=100)) {
			System.out.println(i);
		}//end if
		
		System.out.println("�����մϴ�.");
		
	}//main
}// class