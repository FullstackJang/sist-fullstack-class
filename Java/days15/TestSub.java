package day1110;

/**
 * �ڽ� Ŭ����
 * @author owner
 *
 */
public class TestSub extends TestSuper {
	int j; //�θ�� ���� �̸��� ����
	int k;
	public TestSub() {
		super(11);
		System.out.println("TestSub�ڽ�Ŭ������ �⺻ ������");
	}//TestSub

	@Override
	public void print() {
		j = 11; //�θ�� �ڽ��� ���� �̸��� ������ ������ �ڽĿ� ������ ���� �����
		k = 10;

		i = 20000;//�θ� ���� ������ �ĺ��Ǿ� ���� //this�� ��������
		//this.i = 20000; �θ� ���� ������ �ڽ�Ŭ������ �����ּ��� this�� ���� ���ȴ�. i = 20000;�� ���� 

		//-----------------

		super.i = 20000; // �θ� ���� ������ �θ��� �������ּ� super�κ��� ���� �� �ִ�. 
		//�θ�� �ڽ��� ���� �̸��� ������ ������ �ְ�, �θ��� ������ ����ϱ����ؼ��� �ݵ�� super�θ� �����ؾ��Ѵ�.
		super.j = 2020;

		//System.out.println(super); // �θ�Ŭ������ �ּҸ� ����� �� ����.

		System.out.println("�ڽ�j= " + j + "/ k=" + k);
		//super.k //�ڽ��� ������ �ִ� k�� �ǳʶپ ������ ����.
		//print();  => this.print() this�� �����ִ� ��
		super.print(); // �ڽ��� method�� �ƴ� �θ��� method�� ȣ���ϰ� ���� ��
	}

	public static void main(String[] args) {
		//���� �����ɶ� �θ� �ؿ� �򸮰� �ڽ��� �ö󰣴�.
		//�ڽĿ� �����ּҴ� this�̰� super�� �����ִ°� �θ��� method�� �����̴�.
		//this�� �ڽ��� �����ּ� super�� �θ��� �����ּ�
		TestSub ts = new TestSub();
		ts.print();
		//**��ü�� �ּ�**�δ� �θ�� �ڽ��� �̸��� ���ٸ� �ĺ����� ���ϱ� ������ �θ��� �ڿ��� ȣ���� �� ����
	}//main

}//class
