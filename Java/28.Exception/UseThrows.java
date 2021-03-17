package day1127;

/**
 * method���� ���ܸ� method�� ȣ���� ������ ó���ϵ��� ����� throws ���
 * @author owner
 *
 */
public class UseThrows implements Cloneable{
	
	/**
	 * ��ü�� ������¸� �����Ͽ� ��ȯ�ϴ� �� 
	 * @return ������ ��ü
	 */

	//���� ������ ó���� �� �߻��ϴ� ���ܸ� ȣ���� ������ ó���ϵ��� ����
	public UseThrows cloneObject() throws CloneNotSupportedException {
		
		UseThrows ut = null;
	
		//throws�� �������� ���ܴ� try~catch�� ó������ �ʾƵ� �ȴ�.
		//��ü ������ ���ܰ� �߻��ϸ� �Ʒ����� �ڵ�� ������� �ʴ´�.
		ut = (UseThrows)this.clone();
		
		System.out.println("���� ����");
		
		return ut;
	}//cloneObject
	
	public static void main(String[] args) {

		UseThrows ut = new UseThrows();
		
		try {
			UseThrows ut1 = ut.cloneObject();
			System.out.println("������ ��ü " + ut1);
		} catch (CloneNotSupportedException e) {
			//method�� ȣ���� ������ ���ܰ� �߻������� ó���ڵ带 �ۼ��Ѵ�.������
			System.err.println("������ ���� �߻�");
			e.printStackTrace();
		}//end catch
	
	}//main
}//class
