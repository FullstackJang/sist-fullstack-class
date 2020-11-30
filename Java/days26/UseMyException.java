package day1130;

import java.util.Random;

/**
 * 사용자 정의 예외 처리 클래스를 사용하는 클래스
 * @author owner
 *
 */
public class UseMyException {
// throws로 날리는 예외는 method안에서 throw로 발생된 예외가 되어야 한다
// 또는 throws로 날리는 예외는 method안에서 throw로 발생된 예외의 부모가 될 수 있다. (부모로 예외를 날리면 어떤 문제가 발생했느지 알기 어렵다.)
	public void method() throws TestException {
		
		if(new Random().nextBoolean()) {
			//예외가 발생하는 상황
//			throw new TestException(); // 고정적인 메시지를 출력
			throw new TestException("가변적인 메시지를 출력");
		}//end if
	}//method

	
	/**
	 * 
	 *  류수정 method: 일을 하는 도중에 초딩이 담배를 피우는 것을 목격하면 예외를 발생시킨다.
	 * @return 하던일을 계속
	 * @throws Exception 초딩이 담배 핀 경우
	 */
	public String ryuSujeong() throws CigaretteException { // 류수정이 길을 걸어간다.
		
		String result = "";
		String[] grade = {"초딩","중딩","고딩","대딩"};
		
		//배열의 갯수만큼 난수를 얻어, 배열에서 난수번째 방의 값을 얻는다.
		String getGrade = grade[new Random().nextInt(grade.length)];
		
		if("초딩".equals(getGrade)) { //문자열 리터럴로 equals해야 null포인터를 발생안시킬수 있다.
		//초딩이 담배를 피우는 상황에 예외를 발생시켜 처리
		
			throw new CigaretteException(getGrade + "님 금연해 주세요.");
//			throw new CigaretteException(); //지나친 흡연을 삼가합시다.
		}//end if
		
		result = getGrade + "이 흡연 중 모른척 지나간다.";

		
		return result;
	}//ryuSujeong
	
	
	public static void main(String[] args) {
		UseMyException ume = new UseMyException();
		
	
		try {
			ume.method();
			System.out.println("정상적인 코드 진행");
		} catch (TestException te) {
			System.err.println("method안에서 예외가 발생: " + te.getMessage());
			te.printStackTrace();
		}//end catch
		
		try {
			String msg = ume.ryuSujeong();
			System.out.println(msg); //정상진행
		} catch(CigaretteException ce) { //최상위 예외를 throws하면 method를 호출하여 일을 하는 것과 상관이 없는 예외이기 때문에 가독성이 떨어진다.
		ce.printStackTrace();
		}//end catch
	}//main
}//class