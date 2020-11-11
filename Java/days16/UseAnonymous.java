package day1111;

import day1111.sub.Clark;
import day1111.sub.Fly;

/**
 * method�� �Ű������� Ŭ������ �������̽��� �Ű������� �����ϰ� ���� �� ������ Ŭ���������� �ۼ����� �ʰ�, method�� ȣ�� �� �� �ִ� "�͸�Ŭ����"�� ���
 * @author owner
 */
public class UseAnonymous {
	public void useFly(Fly fly) {
		System.out.println(fly.drivingForce()+"/" + fly.upwardForce());
	}
	
	public static void main(String[] args) {
		
		//Fly�� ������ Ŭ������ �ۼ��ϰ�, ��üȭ
		Clark c=new Clark();
		//method�� ȣ���ϱ� ���� ��üȭ
		UseAnonymous ua = new UseAnonymous();
		//method ȣ��
		ua.useFly(c); //Clark�� Fly�� is a �����̹Ƿ� Clark instance�� �Ҵ� �� �� ����
		
		//Fly�� ������ Ŭ���������� ���� �ۼ����� �ʰ� anonymous inner class�� ó���� �� ����
		//�ܺ�Ŭ������.class �ܺ�Ŭ������$1.class //
		ua.useFly(new Fly() {
			
			@Override
			public int upwardForce() {
				return 0;
			}

			@Override
			public int drivingForce() {
				return 0;
			}
		});
		
	}//main
}//class
