package day1127;

public class UseThrow {

	/**
	 * ���� ���� �߻�
	 * 
	 * ���̵�� ��й�ȣ�� �Է¹޾� ���̵� "admin"�̰�, ��й�ȣ�� "1234"�϶���
	 * �α��� �������� ó���Ѵ�
	 * �α��� ���д� ���ܸ� �߻����� ȣ���� ������ ����ó���� �����Ѵ�.
	 * @param args
	 * @throws Exception 
	 */
	
	public void login(String id, String pass) throws Exception {
		
		//���ڿ� ��ü�� method�� ȣ�� �Ͽ� �� �� ������ NullPointerException�� �߻��� �� �ֱ� ������ ���ܰ� �߻��ϴ� ��Ȳ�� �̿��� �����ϱ� ���� "".equals(������)�� �������� ���Ѵ�. 
		if(("admin".equals(id)) && ("1234").equals(pass)) {
			System.out.println("�α��� ����");
		}
		else {
			throw new Exception("�α��� ����. ���̵� ��й�ȣ�� Ȯ���� �ּ���");
		}//end else
		
	}//login
	
	public static void main(String[] args) {

		UseThrow ut = new UseThrow();
		
		String id = "admin";
		String pass = "1234";

		try {
			ut.login(id, pass);
		}catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}//main
}//class
