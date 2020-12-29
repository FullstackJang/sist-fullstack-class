package day1229;

/**
 * Singleton pattern�� ������ Ŭ����
 * @author owner
 */
public class TestSingleton {
	
	private static TestSingleton ts; // ��ü�� ������ �� �ϳ��� �����ϱ����� �񱳿�

	//1. Ŭ�����ܺο��� ���� ��üȭ�� ���� ���ϵ��� ���´�.
		private TestSingleton() {
			
		}//TestSingleton
		
	//2. ��ü�� ��ȯ�ϴ� method ����
		public static TestSingleton getInstance() {
			if(ts == null) { //��ü�� �����Ǿ����� �ʴٸ�
				ts = new TestSingleton();
			}//end if
			
			return ts;
			
		}//getInstance
}//class
