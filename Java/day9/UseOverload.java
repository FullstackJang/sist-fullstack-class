package day1102;

/*
 * 같은 이름의 method를 여러개 정의할 수 있는 Overload에 대한 사용
 *
 * 
 */
public class UseOverload {
	
	/**
	 * ★을 하나를 출력하는 일.
	 */
	public void printStar() {
		System.out.print("★");
	}//printStar
	
	/**
	 * 사용자가 입력하는 수 대로 ☆을 출력하는 일.
	 * @param cnt 출력할 별의 갯수
	 */
	public void printStar(int cnt) {
	
		for(int i = 0; i < cnt; i++) {
			System.out.println("☆");
		}
	}//printStar
	
	
	
	
	public static void main(String[] args) {
		
		UseOverload uo = new UseOverload();
		
		uo.printStar(2); // 같은 일므의 method로 다른 일ㅇ르 할 수 있다. : 다형성
		
		System.out.println("------------------------------------");
		
		for(int i = 0; i < 4; i++) {
			for(int j =0; j <=i; j++) {
				uo.printStar();
			}//end for
			System.out.println();
		}//end for

	}//main
}//
