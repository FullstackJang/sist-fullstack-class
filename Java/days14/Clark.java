package day1109;

/**
 * 사람의 공통 특징은 Person에서 사용하고, 자식클래스에서는 자신만의 특징을 정의하여 사용<br>
 * @author owner
 *
 */
public class Clark extends Person {
	private int power;
	
	/**
	 * 사람의 일반적인 힘은 2정도이고, Clark은 큰 힘을 가진다.
	 */
	public Clark() {
		power=7;
	}//Clark

	/**
	 * Clark의 힘은 돌에 의해 제어된다.
	 * @param stone 돌의 타입
	 * @return 돌에 따른 결과
	 */
	public String power(String stone) {
		String result = "";
					
		if(stone.equals("다이아몬드")) {
			power=10;
			result = "감사합니다. ^0^b";
		}else if(stone.equals("크립토나이트")){
			power= 0;
			result = "힘이 사라진다. Orz";
		}else {
			power=11;
			result="힘이 폭발!! (/ ㅡㅡ)/";
		}//end else
		return result;
	}//power
	
}//class