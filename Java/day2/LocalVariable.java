/*

	method안에서 정의하고, method안에서만 사용되는 지역변수의 사용법

	 - method안에서 선언되고 사용되는 변수를 지역변수라고 한다.
	 - method밖에서는 사용될 수 없다.
	 - 자동초기화가 되지 않는다(개발자가 코드를 작성하여 초기화 해야한다.)
	 - method가 호출되면 memory에 생성되고, 호출이 끝나면 사라진다(자바에서 제공하는 변수중에 생명이 가장 짧다.)
	 - 초기화되지 않는 변수를 사용하면 Error가 발생한다.

*/

class LocalVariable  {
	public static void main(String[] args) {

		int i; // 변수의 선언
		i = 5; // 값 할당 (변수에 값을 넣는 것) 이전에 할당된 값은 사라진다. 값 할당은 여러번 가능

		System.out.println(i); // 값 사용

		i =  200; // 값 할당

		System.out.println(i); // 값 사용

		int j; // 초기화 하지 않은 변수를 사용하면 error가 발생한다.

		/*
			같은 이름의 변수가 선언되면 error 발생
			int i = 100;
		*/


	//가독성이 좋은 변수명을 사용하여 변수를 선언하세요.
	int maxScore = 100;
	int myScore = 80;

	System.out.println("내 점수:" + myScore+ ", 만점 :" + maxScore + "만점에서 내 점수 차이: " + (maxScore - myScore));


	}
}

/*
constant:변수를 상수처럼사용하기
진수ㄴ
연산자
*/