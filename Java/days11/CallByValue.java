package day1104;

/**
 * method�� �Ű������� �⺻�� ���������̶�� arguments���� ����Ǿ� ���޵ȴ�.
 * method�ȿ����� ����� ���� ������ ����ϰ� �ȴ�.(���� ���� ������ ��ġ�� �ʴ´�.)
 * @author owner
 *
 */
public class CallByValue {
	
	/**
	 * �ԷµǴ� i������ ����, j������ ���� �ٲٴ� ��
	 * @param i ù��° �Ű�����
	 * @param j �ι�° �Ű�����
	 */
	public void swap(int i, int j) {
		int temp = 0;
		temp = i;
		i = j;
		j = temp;
		System.out.println("swap �� i=" + i +", j=" +j);
	}
	
	public static void main(String[] args) {

		int i = 11;
		int j = 4;
		
		System.out.println("swap �� i=" + i + ", j=" + j);
		
		CallByValue c = new CallByValue();
		
		c.swap(i, j);
		
		// ���� ����Ǿ� ���޵ǹǷ� method�� ȣ���ص� ������ ���� ������� �ʴ´�.
		System.out.println("swap �� i=" + i +", j=" +j); 
	}//main
}//class
