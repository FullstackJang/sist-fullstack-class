package day1110;

/**
 * 사람의 공통 특징은 Person에서 사용하고, 자식클래스에서는 자신만의 특징을 정의하여 사용<br>
 * 싸움의 레벨은 최대 10까지 올라가며 일반적인 능력은 3정도이다.
 * @author owner
 *
 */
public class HongGilDong extends Person {

	private int level;

	/**
	 * 싸움의 레벨은 최대 10까지 올라가며 일반적인 능력은 3정도이나, 홍길동은
	 * 높은 싸움 능력치를 가진다.
	 */
	public HongGilDong() {
		this.level = 6;
	}//HongGilDong

	/**
	 * 싸움에 일을 구현한 method<br>
	 * 현재 능력보다 낮은 상대와 싸우면 이기는 결과,현재 능력과 같은 상대와 싸우면 비기는 결과
	 * 현재 능력보다 높은 상대와 싸우면 지는 결과를 반환
	 * @param yourLevel 상대의 레벨
	 * @return 싸움의 결과
	 */
	public String fight(int yourLevel) { // 지는 경우
		String result = " ";

		if(level < yourLevel) {
			level--;
			if(level < 0) {
				level = 0;
			}//end if
			result ="졌다 ~(_-_)~";
		}else if(level > yourLevel) { // 이기는 경우
			level++;
			if(level > 10) {
				level=10;
			}//end if
			result="이겼어 s('.^)v";
		}else { // 비기는 경우
			result ="비겼어 ㅡㅡ";
		}
		return result;
	}//fight		

	/**
	 * 부모클래스에서 제공하는 기능이 자식클래스와 맞지 않기 때문에 자식클래스에 상황에 맞도록 method를 Override
	 */
	@Override
	public String eat(String menu, int price) { //오버로딩
		return super.getName() + "이(가) 주막에서 " + menu + "인 음식을 "+ price +"냥 내고 사먹었습니다."; 
	}//eat

	@Override
	public String eat() {
		return getName()+"이 집에서 밥을 먹는다.";
	}

	@Override
	public String[] language() {
		
		String[] lang = {"한국어","중국어"};
		return lang;
	}//language
}//class