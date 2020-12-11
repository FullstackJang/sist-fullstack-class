package day1211;

import java.util.Random;

public class UseLamda {

	public UseLamda() {
		// 인터페이스를 편하게 쉽게 사용.(구현클래스를 만들지 않고, abstract method Override하지 않고)
		Lamda1 lamb1 = () -> {
			System.out.println("test method 호출");
		};

		// 람다식을 활용해서 아래 anony클래스를 lam1으로 1줄로 줄여졌다.

		Lamda1 anony = new Lamda1() {
			@Override
			public void test() {
				System.out.println("anony method 호출");
			}
		};

		// 람다식을 사용한 호출
		lamb1.test();

		anony.test();

	}// UseLamda

	public void test(Lamda1 lm) {
		lm.test();
	}// test

	public void parameter() {
		Lamda2 l2 = (String na) -> {
			// 복성 : 남궁, 제갈, 선우, 독고
			String famliyName = "";
			String firstName = "";
			// 입력되는 na를 사용하여 성과 이름을 출려하는 코드를 작성

			int idx = 1;

			if (na.startsWith("남궁") || na.startsWith("제갈") || na.startsWith("독고") || na.startsWith("선우")) {
				idx = 2;
			} // end if

			famliyName = na.substring(0, idx);
			firstName = na.substring(idx);

			System.out.println("성:" + famliyName + ",이름:" + firstName);

		};
		l2.name("독고옥분");
		l2.name("류수정");

	}// parameter

//	public void returnValue() {
//		
//		Lamda3 l3 = () -> {
//			Random r = new Random();
//			
//			return r.nextInt(45)+1;
//		};
//		
//		System.out.println(l3.luckyNumber());
//		
//	}//returnValue

	public static void main(String[] args) {
		UseLamda ul = new UseLamda();
		ul.test(() -> {
			System.out.println("람다식으로 구현");
		});
		System.out.println("------------------------");
		ul.parameter();
		System.out.println("------------------------");
//		ul.returnValue();
		
		//람다식으로 사용하여 1~100까지 출력하는 for를 Thread로 처리하는코드 작성
		
		Thread t = new Thread(() -> {
			for(int i =1; i < 101; i++) {
					System.out.println(i);
				}//end for
		});
		
		t.start();
		
	}// main
}// UseLamda
