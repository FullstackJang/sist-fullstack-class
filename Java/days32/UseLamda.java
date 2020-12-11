package day1211;

import java.util.Random;

public class UseLamda {

	public UseLamda() {
		// �������̽��� ���ϰ� ���� ���.(����Ŭ������ ������ �ʰ�, abstract method Override���� �ʰ�)
		Lamda1 lamb1 = () -> {
			System.out.println("test method ȣ��");
		};

		// ���ٽ��� Ȱ���ؼ� �Ʒ� anonyŬ������ lam1���� 1�ٷ� �ٿ�����.

		Lamda1 anony = new Lamda1() {
			@Override
			public void test() {
				System.out.println("anony method ȣ��");
			}
		};

		// ���ٽ��� ����� ȣ��
		lamb1.test();

		anony.test();

	}// UseLamda

	public void test(Lamda1 lm) {
		lm.test();
	}// test

	public void parameter() {
		Lamda2 l2 = (String na) -> {
			// ���� : ����, ����, ����, ����
			String famliyName = "";
			String firstName = "";
			// �ԷµǴ� na�� ����Ͽ� ���� �̸��� ����ϴ� �ڵ带 �ۼ�

			int idx = 1;

			if (na.startsWith("����") || na.startsWith("����") || na.startsWith("����") || na.startsWith("����")) {
				idx = 2;
			} // end if

			famliyName = na.substring(0, idx);
			firstName = na.substring(idx);

			System.out.println("��:" + famliyName + ",�̸�:" + firstName);

		};
		l2.name("�������");
		l2.name("������");

	}// parameter

//	public void returnValue() {
//		
//		Lamda3 l3 = () -> {
//			Random r = new Random();
//			
//			return r.nextInt(45)+1;
//		};
//		
//		System.out.println(l3.luckyNumber());
//		
//	}//returnValue

	public static void main(String[] args) {
		UseLamda ul = new UseLamda();
		ul.test(() -> {
			System.out.println("���ٽ����� ����");
		});
		System.out.println("------------------------");
		ul.parameter();
		System.out.println("------------------------");
//		ul.returnValue();
		
		//���ٽ����� ����Ͽ� 1~100���� ����ϴ� for�� Thread�� ó���ϴ��ڵ� �ۼ�
		
		Thread t = new Thread(() -> {
			for(int i =1; i < 101; i++) {
					System.out.println(i);
				}//end for
		});
		
		t.start();
		
	}// main
}// UseLamda
