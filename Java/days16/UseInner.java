package day1111;

/**
 * Ŭ�����ȿ� Ŭ������ ���ǵǴ� Ŭ����
 * @author owner
 *
 */
public class UseInner {
	int outI;

	public UseInner() {
		System.out.println("�ٱ� Ŭ������ ������");
	}//UseInner

	public void outMethod() {
		System.out.println("�ٱ� Ŭ������ method outI" + outI);
		
		//���� Ŭ���� ȣ�� �� 
		//System.out.println("���� Ŭ������ ���� j" + j); //������ ���������Ͽ� ����� �� ����
		//inMethod(); // ����Ŭ������ method�� ���� ������ �� ����
		
	}//outMethod

	////////////////// Inner class ���� ////////////////////
	public class Inner{
		//���� Ŭ������ ����, ������, �޼ҵ带 ���� �� ����
		int j;

		public Inner() {
			System.out.println("���� Ŭ������ ������");
		}//Inner

		public void inMethod() {
			System.out.println("���� Ŭ������ method Inner j=" + j);
			System.out.println("�ٱ� Ŭ������ ���� outI=" + outI);
			outMethod();// �ٱ� Ŭ������ method
		}//inMethod

	}//class
	//////////////////Inner class �� ////////////////////
	
	@SuppressWarnings("unused")
	public void createInner() {
		//���� Ŭ������ ��üȭ
		Inner in = this.new Inner(); // this�� method�� ȣ���ϴ� ��ü�� �ּҷ� ��ü
		//Inner in= new Inner(); // this�� ������ �� ���� this.new => new
		//this.outI

	}//createInner

	public static void main(String[] args) {
		//inner class�� ��üȭ
		//1. �ٱ� Ŭ���� ��üȭ
		UseInner ui = new UseInner();
		ui.createInner();		
		
		System.out.println("------------------------");
		//2. �ٱ� Ŭ������ ��ü�� ����Ͽ� ���� Ŭ������ ��ü�� �����Ѵ�.
		
		//�ٱ�Ŭ������.����Ŭ������ ��ü�� = �ٱ�Ŭ������ ��ü��.new ����Ŭ������ ������();
		UseInner.Inner in = ui.new Inner();

		Inner in1 = ui.new Inner(); // ���������� �ٱ� Ŭ�������� ������ �� ����.
		
		in.j = 11;
		in.inMethod(); // ���� Ŭ������ method���� �ٱ� Ŭ������ ����, method�� ȣ��
	}//main
}//class
