package day1029;

public class TestFor2 {

	public static void main(String[] args) {
		/*
		for(int i = 0; i < 4; i++) {
			for(int j = i+1; j < 5; j++) {
				System.out.print(i + " " + j+ " ");
			}// end for
			System.out.println();
		}// end for
		*/
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}		
	}// end main
}
