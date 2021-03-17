/*
  산술연산자; +, -, *, /, %
 */

public class Operator2 {
	
	public static void main(String[] args) {
		
		int  i = 9;
		int  j = 3;
		
		System.out.println(i + "/" + j + '=' + i/j);
		
		System.out.println(i + " % 2 = " + i % 2); // 0아니면 1 두가지의 수
		
		int temp = 1993;
		
		System.out.println(temp % 12);
		//0:원숭이, 1:닭, 2:개, 3:돼지, 4:쥐, 5:소
		//6:호랑이, 7:토끼, 8:용, 9:뱀, 10:말, 11:양 
		//12가지의 수
	}
}
