package day1127;

/**
 * ��ü ����
 * ��� ��ü�� clone()�� ȣ���� �� ������ �������� �ʴ´�.
 *  clone()�� protected�̹Ƿ� �����Ϸ��� Ŭ�����ȿ����� �����ȴ�.
 * @author owner
 */
public class ObjectClone implements Cloneable{
	private int year;
	private String name;

	public ObjectClone() {
		year = 2020;
		name = "������";
	}//ObjectClone
	
	public static void main(String[] args) {
		
		//1. �����Ϸ��� ��ü�� ����
		ObjectClone oc = new ObjectClone();
		
		//2. ����
		//clone()method�� �����Ͽ��ܸ� throws�ϰ� �����Ƿΰ����ڴ� �ش� ���ܸ� �ݵ�� try~catch�� ��Ƽ� ó���ؾ��Ѵ�.
		//��ü�� ���¸� �����ؾ��� �� ���
		try {
		ObjectClone oc1 = (ObjectClone)oc.clone();
		System.out.println("���� �Ǿ����ϴ�.");
		System.out.println(oc + "/" + oc1);

		oc.year = 1010;
		oc.name = "�׽�Ʈ";
		oc1.year = 2010;
		oc1.name = "�׽�Ʈ1";
		
		System.out.println(oc.year + "/" + oc.name);
		System.out.println(oc1.year + "/" + oc1.name);
		
		}catch(CloneNotSupportedException cnse) {
		}//end catch
		
		//forName()�� ClassNotFoundException�� throws�ϰ� �����Ƿ� method�� ȣ���ϴ� ������ try~catch�� ���ܸ� ��Ƽ� ó���ؾ��Ѵ�.
		try {
			Class str = Class.forName("day1127.ObjectClone");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//main
}//class
