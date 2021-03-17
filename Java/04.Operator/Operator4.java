package a1026;

/*
 	관계연산자
 	>, >, >=, <=, ==(같다), !=(다르다)

 */

public class Operator4 {

	public static void main(String[] args) {
		
		int i = 10, j = 26, k = 10;
		
		System.out.println(i+ " == " + k + "=>" + (i == k)); // 같다면 ture
		System.out.println(i+ " == " + j + "=>" + (i == j)); // 같지 않다면 false
		
		System.out.println(i+ " != " + k + "=>" + (i != k)); // 같다면 false
		System.out.println(i+ " != " + j + "=>" + (i != j)); // 같지 않다면 true
		
		
	}
}
