package day1110;

public class RunOverride {

	public static void main(String[] args) {

		//�ڽ�Ŭ������ ��ü ����
		//�θ�Ŭ������ �ڿ���, �ڽ�Ŭ������ �ڿ��� ����� �� �ִ�.
		OverrideSub os = new OverrideSub();
		OverrideSub2 os2 = new OverrideSub2();		
		
		os.methodA(); //�θ��� method�� ȣ��
		os.methodB();
		//�θ��� method�� ȣ�� => �ڽ��� method�� ȣ��ǵ��� �ϰ� �ʹ�.
		//method���� �ϰ����� ���� method���� �״�� ����ϸ鼭 ���۸� �ٸ��� ���� - .������
		os2.methodA(); //Override �� method ȣ��
		os2.methodB(); //Override �� method ȣ��
		os2.childMethod(); //�ڽ�Ŭ������ ������ methodȣ��
		
		
		System.out.println("----------------------------------");
		
		//is-a ������ ��üȭ -��ü �������� ���(���� Ŭ������ ������� ��ü�� �ٸ� ���� ����)
		//�θ�Ŭ������ ��ü�� = new �ڽ�Ŭ�����ǻ�����();
		//���������� �θ�Ŭ�����̱� ������ �θ��� �ڿ��� ��밡��
		//ȣ�Ⱑ���� method�� �θ�Ŭ������ ���� method�� ȣ�� ����
		OverrideSuper o_super = new OverrideSub();
		OverrideSuper o_super2 = new OverrideSub2();
		o_super.methodA(); // Override���� �ʾұ� ������ �θ��� method�� ȣ��
		o_super.methodB(); // Override���� �ʾұ� ������ �θ��� method�� ȣ��
		
		//Override�� method�� �����ϸ� �θ� Ŭ������ method�� ȣ���ϴ� ���� �ƴ� 
		//!!!�ڽ��� method�� �ֿ켱������ ȣ��!!!
		o_super2.methodA();
		o_super2.methodB();
//		o_super2.childMethod(); //is-a������ ��üȭ�� �ϸ� ���������� �θ�Ŭ�����̱� ������ �θ� Ŭ������ �ش��ϴ� method�� ȣ���� �� ����
		//OverrideSuperŬ���� Ÿ�� ���赵���� childMethod()�� ����.
		//�θ�� �ڽ��� ����ų�� ������ �ڽ��� �θ� ���ϴ� �� �𸥴�.
	}//main
}//class
