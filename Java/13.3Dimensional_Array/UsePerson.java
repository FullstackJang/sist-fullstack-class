package day1109;

/**
 * ��Ӱ����� Ŭ���������� �θ�Ŭ������ ��üȭ�Ͽ� ����ϴ� �Ϻ���, �ڽ�Ŭ������ ��üȭ�Ͽ� ����ϴ� ���� �� ����
 * @author owner
 *
 */
public class UsePerson{

	public static void main(String[] args) {

		HongGilDong hgd = new HongGilDong(); //�ڽ��� �����ϸ� �θ� ���� ���� ��
		Clark superman = new Clark(); //�ڽ��� �����ϸ� �θ� ���� ���� ��

		hgd.setName("ȫ�浿"); //�θ�Ŭ������ method
		superman.setName("Ŭ��"); //�θ�Ŭ������ method

		System.out.println(hgd.getName()+"�� ��"+hgd.getEye() + "��, ��" + hgd.getNose() + ", ��" + hgd.getMouth());
		System.out.println(superman.getName()+"�� ��"+superman.getEye() + "��, ��" + superman.getNose() + ", ��" + superman.getMouth());

		System.out.println(hgd.eat());
		System.out.println(superman.eat()); //����
		System.out.println(hgd.eat("����",1));//����
		System.out.println(superman.eat("������ũ",10)); //����


		//�ڽ�Ŭ������ ������ �ڽŸ��� Ư¡ ȣ��
		System.out.println(hgd.fight(5)); // 6->7
		System.out.println(hgd.fight(6)); // 7->8
		System.out.println(hgd.fight(8)); // 7->8
		System.out.println(hgd.fight(9)); // 8->7
		System.out.println(hgd.fight(7)); // 7
		
		System.out.println("-------------------------------");
		System.out.println(superman.power("¯��"));
		System.out.println(superman.power("ũ���䳪��Ʈ"));
		System.out.println(superman.power("���̾Ƹ��"));
		
		Jangilkyu ilkyu = new Jangilkyu();

	}//main
}//class
