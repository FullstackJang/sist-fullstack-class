package day1030;

/*
 * instance variable�� ������������ ���
 * public: ��Ű���� ������� �ܺο��� ���� ����
 * protected: ���� ��Ű���� �ٸ� Ŭ���������� ��밡�� / ��Ű���� �ٸ��� ��Ӱ����� �ڽ�Ŭ�������� ��밡��
 * private: �� Ŭ���� �ȿ����� ��� ����
 * default: ���� ��Ű���� �ٸ� Ŭ�������� ��밡�� / ��Ű���� �ٸ��� ����� �� ����.
*/

public class AccessModifier {

	public int pub;
	protected int pro;
	private int pri; // �� Ŭ�����ȿ��� ������ ������ �ܺο��� ���� ��� �� �� ����.
	int def;

	public static void main(String[] args) {

		//1.��üȭ
		AccessModifier am = new AccessModifier();
		//2. ������ ���: ������ ���ǵ� Ŭ���� �ȿ����� ���������ڿ� �������
		//��� ��� ����
		System.out.println("AccessModifier: " + am.pub + "/" + am.pro + "/" + am.pri + "/" + am.def );
		
		
	}
}
