package day1112;

import java.util.StringTokenizer;

/**
 * ���ڿ��� �ڸ��� ����ϴ� Ŭ����
 * @author owner
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		String str = "������������ ������ ������ ���հ�,�;�,�ӳɳ�,�׳ɳɳ�";

		//1. ���ڿ��� �������� �����ϴ� StringTokenizer�� ���
//		StringTokenizer stk = new StringTokenizer(str);
		
		//���̶�� ���� �����̱� ������ �Ʒ��� ���̴� ������ �ʴ´�.
//		System.out.println("��ū�� ��: " + stk.countTokens()); //pointer�� �̵��ϸ� ��ū�� ���� �پ��
//		System.out.println("��ū�� �����ϴ���: " + stk.hasMoreTokens());
//		System.out.println("pointer�� �����ϴ� ��ġ�� ���� ���, pointer�� �̵�: " + stk.nextToken());
//		System.out.println("��ū�� �����ϴ���: " + stk.hasMoreTokens());
//		System.out.println("��ū�� ��: " + stk.countTokens());
//		System.out.println("��ū�� �����ϴ���: " + stk.hasMoreTokens());
//--------------------------------
		
		//2. ���ڿ��� Ư�����ڷ� �����Ͽ� �ڸ���: StringTokenizer(���ڿ�,"�ڸ�����");
		//���� ���ڸ� ��ȣ���� ����(������.)
//		StringTokenizer stk = new StringTokenizer(str, "��, "); 
		
		//3.���ڿ��� Ư�����ڷ� �����Ͽ� �ڸ���: StringTokenizer(���ڿ�,"�ڸ�����",��ȣ����);
		StringTokenizer stk = new StringTokenizer(str, "��, ",false); 
		//���ع��ڸ� ��ȣ������ ���� ����: true- ��ȣ flase- ��ȣ
		
		
		//��ū ���� �� �� ������ ��ū�� ���� ������ �߶󳻾��Ѵ�.
		//���۰� ���� �� �� ���� �� ����ϴ� �ݺ��� while ���
		while(stk.hasMoreTokens()) {
			System.out.println(stk.nextToken()); //���� �������� �����͸� ������ġ�� �̵�\
			System.out.println(stk.countTokens());
		}//end while

		// �����ʹ� �ѹ� �������� �ű⼭ ��
		// �ٽ� ����ϰ� ������ ��ü�� �ٽ� �����ؾ���
//		while(stk.hasMoreTokens()) {
//			System.out.println(stk.nextToken()); //���� �������� �����͸� ������ġ�� �̵�\
//			System.out.println(stk.countTokens());
//		}//end while
		
		
	}//UseStringTokenizer
	
	public static void main(String[] args) {
		new UseStringTokenizer();
	}//main
}//class
