package day1111.sub;

/**
 * 사람의 공통 특징은 Person에서 사용하고, 자식클래스에서는 자신만의 특징을 정의하여 사용<br>
 * @author owner
 * 날으는 일을 하기위해서 Fly interface를 구현
 */
public class Clark extends Person implements Fly {
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
	/**
	 * @param stone
	 * @return
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

	/**
	 * Person이 제공하는 eat이 자식클래스의 상황에 맞지 않기 때문에 자식클래스에 자신의 상황에 맞도록 method를 다시 만드는 것
	 */
	@Override
	public String eat() {
		//name변수는 private이기 때문에 자식클래스에서 사용할 수 없다.
		//부모클래스의 private 변수는 setter method나 getter method를 사용하여 접근한다.
		return super.getName() + "이 집에서 '빵'을 먹는다."; 
	}//eat

	@Override
	public String eat(String food, int price) { //오버로딩
		return super.getName() + "이 레스토랑에서 " + food + "인 음식을 "+ price +"$ 내고 사먹었습니다."; 
	}//eat

	@Override
	public String[] language() {
		String[] lang = new String[3];
		lang[0] = "영어";
		lang[1] = "독일어";
		lang[2] = "외례어";
		return lang;
	}//language

	///////////////// Fly abstract method ////////////////////

	@Override
	public int upwardForce() {
		return 100;
	}

	@Override
	public int drivingForce() {
		return 400;
	}
	
}//class