package day1111;

import day1111.sub.Clark;
import day1111.sub.Fly;

/**
 * method의 매개변수가 클래스나 인터페이스를 매개변수로 선언하고 있을 때 별도의 클래스파일을 작성하지 않고, method를 호출 할 수 있는 "익명클래스"의 사용
 * @author owner
 */
public class UseAnonymous {
	public void useFly(Fly fly) {
		System.out.println(fly.drivingForce()+"/" + fly.upwardForce());
	}
	
	public static void main(String[] args) {
		
		//Fly를 구현한 클래스를 작성하고, 객체화
		Clark c=new Clark();
		//method를 호출하기 위해 객체화
		UseAnonymous ua = new UseAnonymous();
		//method 호출
		ua.useFly(c); //Clark는 Fly와 is a 관계이므로 Clark instance를 할당 할 수 있음
		
		//Fly를 구현한 클래스파일을 별도 작성하지 않고 anonymous inner class로 처리할 수 있음
		//외부클래스명.class 외부클래스명$1.class //
		ua.useFly(new Fly() {
			
			@Override
			public int upwardForce() {
				return 0;
			}

			@Override
			public int drivingForce() {
				return 0;
			}
		});
		
	}//main
}//class
