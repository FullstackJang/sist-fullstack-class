package day1127;

public class UseThrow {

	/**
	 * 예외 강제 발생
	 * 
	 * 아이디와 비밀번호를 입력받아 아이디가 "admin"이고, 비밀번호가 "1234"일때만
	 * 로그인 성공으로 처리한다
	 * 로그인 실패는 예외를 발생시켜 호출한 곳에서 실패처리를 수행한다.
	 * @param args
	 * @throws Exception 
	 */
	
	public void login(String id, String pass) throws Exception {
		
		//문자열 객체의 method를 호출 하여 비교 할 때에는 NullPointerException이 발생할 수 있기 때문에 예외가 발생하는 상황을 미연에 방지하기 위해 "".equals(변수명)의 문법으로 비교한다. 
		if(("admin".equals(id)) && ("1234").equals(pass)) {
			System.out.println("로그인 성공");
		}
		else {
			throw new Exception("로그인 실패. 아이디나 비밀번호를 확인해 주세요");
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
