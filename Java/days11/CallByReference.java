package day1104;

/**
 * method�� �Ű������� ���������������̸� �ϳ��� �ּҰ� method������ ���޵ȴ�.
 * @author owner
 *
 */
public class CallByReference {

	private int i;
	private int j;
	
	public void swap(CallByReference cbr) {
//		System.out.println("swap:" + cbr); // �ּҴ� ������� �ʰ� �״�� ����
		int temp = 0;
		//heap�޸��� �ε�� ������ ���� �۾��� ����
		temp = cbr.i; 
		cbr.i = cbr.j;
		cbr.j = temp;
		
		System.out.printf("swap �� cbr.i=%d cbr.j=%d\n",cbr.i,cbr.j);
	}//swap
	
	
	/**
	 * ������ ���������� �Ű������� �����Ͽ� �ּҸ� ������ �ּҴ� �����ϱ� ������ �ܺο��� ����ϴ� �ּҳ� ���ο��� ����ϴ� �ּҴ� ���� �ּҰ� �ȴ�.
	 * @param args
	 */
	public static void main(String[] args) {
		CallByReference cbr = new CallByReference();
//		System.out.println(cbr);
		cbr.i =11;
		cbr.j = 4;
		
		System.out.printf("swap �� cbr.i= %d, cbr.j=%d\n",cbr.i,cbr.j);// i = 11, j = 4
		cbr.swap(cbr);	
		System.out.printf("swap �� cbr.i= %d, cbr.j=%d\n",cbr.i,cbr.j);// i = 11, j = 4
		
	}//main
}//class
