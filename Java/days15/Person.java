package day1110;

/**
 * 사람을 추상화 하여 만드는 클래스 <br>
 * 부모클래스이고 사람의 공통특징만 정의하여 만든 클래스<br>
 * 사람의 명사적인 특징: 눈, 코 입, 이름<br>
 * 사람의 동사적인 특징: 먹는일<br>
 * 일반클래스이고 객체화를 하여 사용<br>
 * 객체화 문법: Person 객체명 = new Person();
 * @author owner
 */
public abstract class Person {
	
	private int eye; //눈
	private int nose; //코
	private int mouth; //입
	private String name; //이름
	
	/**
	 * 사람 클래스의 기본 생성자
	 * 눈 2개, 코 1개, 입 1개가 설정되는 사람 객체를 생성할 때 사용
	 */
	public Person() {
		this(2,1,1);
	}//Person
	
	
	/**
	 *  매개변수 있는 생성자(생성자의 Overload)<br>
	 *  눈, 코, 입을 사용자가 설정하여 객체를 생성 
	 * 
	 * @param eye 눈
	 * @param nose 코
	 * @param mouth 입
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.eye = nose;
		this.mouth = mouth;
	}//Person
	
	
	/**
	 * 생성된 사람객체에 눈의 갯수를 설정하는 일
	 * @param eye 눈의 갯수
	 */
	public void setEye(int eye) {
		this.eye = eye;
	}//setEye
	
	/**
	 * 생성된 사람객체에 설정된 눈의 갯수를 반환 하는 일
	 * @return
	 */
	public int getEye() {
		return eye;
	}//getEye
	
	/**
	 * 생성된 사람객체 코의 갯수를 설정하는 일
	 * @param nose 설정할 코의 갯수
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}//setNose
	
	/**
	 * 생성된 사람에 설정되어 있는 코의 갯수를 반환 하는 일
	 * @return
	 */
	public int getNose() {
		return nose;
	}//getNose
	
	/**
	 * 사람객체의 입을 설정하는일
	 * @param mouth 설정할 입의 갯수
	 * @return
	 */
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}//setMouth
	
	/**
	 * 생성된 사람 객체의 입의 갯수를 반환 하는 일
	 * @return 입의 수
	 */
	public int getMouth() {
		return mouth;
	}//getMouth

	/**
	 * 생성된 사람 객체에 이름을 설정하는 일
	 * @param name 설정할 이름
	 */
	public void setName(String name) {
		this.name = name;
	}//setNmae
	
	/**
	 * 생성된 사람객체에 설정되어있는 이름을 반환 하는 일
	 * @return 이름
	 */
	public String getName() {
		return name;
	}//getName
	
	//-- 동사적 특징
	
	/**
	 * 사람 객체의 동사적인 특징
	 * 사람객체가 집에서 먹는 일 구현
	 * @return 밥먹는 행동
	 */
	public abstract String eat();
	
	/**
	 * method overload: 같은 이름의 method를 여러개 만드는 것
	 * 사람 객체가 밖에서 사먹는 일
	 * @param menu 음식 종류
	 * @param price 음식 가격
	 * @return 식당에서 사먹는 일
	 */
	public abstract String eat(String menu, int price);
	
	/**
	 * 사람이 구사하는 언어 
	 * @return
	 */
	public abstract String[] language(); 
	
}//class
