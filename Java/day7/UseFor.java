package day1028;

public class UseFor {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			System.out.println("¾È³çÇÏ¼¼¿ä.");
		}
		
		
		for(int i = 1; i < 101; i++) {
			System.out.println(i);
		}
		
		for(int i = 1; i < 101; i+=2) {
			System.out.println(i);
		}
		
		for(int i = 0; i <= 100; i+=2) {
			System.out.println(i);
		}
		
		for(int i=0; i <= 100; i++) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
		
		for(int i = 1; i < 10; i++) {
			System.out.println(i);
		}
		
		for(int i = 65; i <= 90; i++) {
			System.out.println((char)i);
		}
		
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		
		System.out.println(sum);
	}//main
	
}
