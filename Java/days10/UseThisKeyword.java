package day1104;

/**
 * ȣ���ϴ� ��ü�� �ּҷ� ����Ǵ� this keyword�� ���
 * @author owner
 *
 */
public class UseThisKeyword {
	int i;
	public void useInstance(int i, UseThisKeyword utk) {
		//i=i; //���������� �̸��� instance ������ �̸��� ���ٸ� ���������� ���� ����Ѵ�.
		
		utk.i = i; //instance ������ ���������� �����ϱ����� �ν��Ͻ������� �տ� ��ü���� ����Ѵ�.
		//���� ���� �ϸ� �ڵ尡 ������� �������� ������.
		
		System.out.println("stack i =" + i);
	}
	
	
	/**
	 * this��� Ű���带 ����ϸ� method�� ȣ�� �� �� ���� ��ü�� �ּҷ� this�� ����ȴ�.
	 * t.method(); this�� t��ü�� �ּҷ� ����ȴ�.
	 * @param i
	 */
	public void UseThis(int i) {
//		System.out.println(this); //this�� method�� ȣ���ϴ� ��ü�� �ּҷ� ����ȴ�.
		this.i = i;
	}//useThis
	
	public static void main(String[] args) {
		
		UseThisKeyword utk = new UseThisKeyword();
		UseThisKeyword utk1 = new UseThisKeyword();
		System.out.println(utk + "/" + utk1);
		utk.UseThis(20);
		utk1.UseThis(200);
		System.out.println(utk.i+"/" + utk1.i);
//		utk.useInstance(2020, utk);
//		System.out.println("main i=" + utk.i);
		
	}//main
}//class
