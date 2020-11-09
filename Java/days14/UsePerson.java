package day1109;

/**
 * 상속관계의 클래스에서는 부모클래스를 객체화하여 사용하는 일보다, 자식클래스를 객체화하여 사용하는 일이 더 많음
 * @author owner
 *
 */
public class UsePerson{

	public static void main(String[] args) {

		HongGilDong hgd = new HongGilDong(); //자식을 생성하면 부모가 먼저 생성 됨
		Clark superman = new Clark(); //자식을 생성하면 부모가 먼저 생성 됨

		hgd.setName("홍길동"); //부모클래스의 method
		superman.setName("클락"); //부모클래스의 method

		System.out.println(hgd.getName()+"은 눈"+hgd.getEye() + "개, 코" + hgd.getNose() + ", 입" + hgd.getMouth());
		System.out.println(superman.getName()+"은 눈"+superman.getEye() + "개, 코" + superman.getNose() + ", 입" + superman.getMouth());

		System.out.println(hgd.eat());
		System.out.println(superman.eat()); //변경
		System.out.println(hgd.eat("국밥",1));//변경
		System.out.println(superman.eat("스테이크",10)); //변경


		//자식클래스가 정의한 자신만의 특징 호출
		System.out.println(hgd.fight(5)); // 6->7
		System.out.println(hgd.fight(6)); // 7->8
		System.out.println(hgd.fight(8)); // 7->8
		System.out.println(hgd.fight(9)); // 8->7
		System.out.println(hgd.fight(7)); // 7
		
		System.out.println("-------------------------------");
		System.out.println(superman.power("짱돌"));
		System.out.println(superman.power("크립토나이트"));
		System.out.println(superman.power("다이아몬드"));
		
		Jangilkyu ilkyu = new Jangilkyu();

	}//main
}//class
