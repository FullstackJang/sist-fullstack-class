package day1110;

/**
 * AbstractSuper�� �ڽ� Ŭ����(�߻�Ŭ������ �ڽ� Ŭ����: �θ�Ŭ������ ��� abstract method�� �ݵ�� Override�ؾ� ��(�����ؾ���))
 * @author owner
 *
 */
public class AbstractSub extends AbstractSuper {

	public AbstractSub() {
		System.out.println("�ڽ�Ŭ����");
	}

	@Override
	public void methodB() {
//		super.methodB(); //abstract method�� ���� ȣ�� �� �� ����
		System.out.println("Override�� methodB");
	}//methodB

	@Override
	public  int methodC() {
		return 11;
	}//methodC

	public static void main(String[] args) {
		AbstractSub as = new AbstractSub(); //�ڽ�Ŭ������ ��üȭ�ϸ� �θ�Ŭ������ ���� �����ȴ�.
		
		as.methodA(); //�θ� ���� method
		as.methodB(); //�θ��� �߻�޼ҵ带 Override�� method
		System.out.println(as.methodC()); //�θ��� �߻�޼ҵ带 Override�� method
		/*
		 �ܼ� ���
		 
			�߻�Ŭ������ ������
			�ڽ�Ŭ����
			�Ϲ� method
			Override�� methodB
			11

		*/
	}//main
}//class
