package day1103;

/**
 * ��� ��ü�� ����ϴ� Ŭ����
 * @author owner
 *
 */
public class UsePerson {	
	/**
	 * Java Application
	 * @param args �Է°�
	 */
	public static void main(String[] args) {
		//����ȭ
		Person jang = new Person();
		jang.setName("���ϱ�");
//		jang.setEye(2); //������ �����ϴ� �ڵ�� �ʿ� ����. 
//		jang.setMouth(1);
//		jang.setNose(1);
		
		System.out.println("��:" + jang.getEye() + ", �� :" + jang.getNose() + ", �� :" + jang.getMouth());
		System.out.println(jang.getEye());
		System.out.println(jang.eat());
		System.out.println(jang.eat("��ī��",8000));

		System.out.println("-------------------------");
		////// �����ϴ� ������ �̸����� ��ü�� ����� ��,��,�̸� �����ϰ�, �Դ��� ����
		
		//1.��üȭ
		Person sana = new Person();
		
		//2.setter ȣ��
		sana.setEye(2);
		sana.setNose(1);
		sana.setMouth(1);
		sana.setName("�糪");
		
		//3.getter ȣ��
		System.out.println("���� �����ϴ� �������� �̸��� " + sana.getName()+"\n�糪�� ���� " + sana.getEye() +"�� �糪�� �ڴ� " + sana.getNose() + "�� �糪�� ���� " + sana.getMouth()+ "��");
		
		//4.������ ���� �ϴ� method
		System.out.println(sana.eat());
		System.out.println(sana.eat("�쵿",5000));
		
		System.out.println("-------------------------");
		Person jinban = new Person(3,1,1);
		jinban.setName("õ����");
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("����",0));
		
	}//main
} //class
