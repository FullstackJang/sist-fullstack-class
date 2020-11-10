package day1110;
import java.util.*;
/**
 * annotation ���
 * @author owner
 *
 */
public class UseAnnotation {

	@Override // annotation Override�� ����� �ߴ��� �����Ϸ��� �Ǵ�
	public String toString() {

		return "���� �ּҸ� ��ȯ�ϱ� �Ⱦ��";
	}//toString

	/**
	 * �������� ����ϱ� ����� ��쿡 �����ϴ� annotation 
	 * ��ü Ŭ������ method�� ����
	 * @Deprecated ����õ method
	 */
	@Deprecated
	public void test() {
		System.out.println("�����ڵ�����");
	}//test

	//unused - ������ ������ ���� �� ���
	//rawtypes - ���������� �������� ���ؼ� Generic�� ����ϴ� ������ �����ϴµ� 
	// 			 Generic�� ������� �ʰ� JCF�� ����ؾ� �� �� ��� ���ֱ�	 
	@SuppressWarnings({ "unused", "rawtypes" })
	public void temp() {
		//@SuppressWarnings("unused")
		int i;

		//@SuppressWarnings({ "unused", "rawtypes" })
		List l = null;
	}//temp
	public static void main(String[] args) {
		String str = new String("������ ȭ���� �Դϴ�."); //��ü�� ��������� �ּҰ� ������ �ʴ°��� toString()�� Overriding �Ѱ�
		System.out.println(str.toString());  //�ּ�x Object.toString()�� Override�Ͽ� �ּҰ� �ƴϰ� ���� ����.

		UseAnnotation ua = new UseAnnotation();
		System.out.println(ua.toString()); //�ּ� Object.toString()�� Override ���� �ʾ� Object�� �����ϴ� �ּ� ���°� ���ڿ��� ��ȯ��
		//Object�� String() getClass().getName() + '@' + Integer.toHexString(hashCode())

		Date date = new Date();
		System.out.println(date); // Object toString()�� Override�Ͽ� �ּҰ� �ƴ� �޽����� ��ȯ
		System.out.println(date.toString());
		//		System.out.println(date.getYear() + 1900 ); //����õ method�� �������̸� ������� �ʴ� ���� ����.

		ua.test();
	}//main
}//class
