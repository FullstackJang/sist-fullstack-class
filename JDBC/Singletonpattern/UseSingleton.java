package day1229;


public class UseSingleton {
		
	public static void main(String[] args) {
		//Singleton pattern�� ���Ե� Ŭ������ �ܺο��� ������üȭ �� �� ����.
		//TestSingleton ts = new TestSingleton();
		
		//��ü�� ��ü�� ���� �� �ִ� method(method)�� ����Ͽ� ��ü�� ��´�.
		TestSingleton ts = TestSingleton.getInstance();
		TestSingleton ts1 = TestSingleton.getInstance();
		
		System.out.println("ts: " + ts);
		System.out.println("ts1: "+ ts1);
	}//main
}//class
