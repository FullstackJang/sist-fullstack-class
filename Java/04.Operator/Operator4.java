package a1026;

/*
 	���迬����
 	>, >, >=, <=, ==(����), !=(�ٸ���)

 */

public class Operator4 {

	public static void main(String[] args) {
		
		int i = 10, j = 26, k = 10;
		
		System.out.println(i+ " == " + k + "=>" + (i == k)); // ���ٸ� ture
		System.out.println(i+ " == " + j + "=>" + (i == j)); // ���� �ʴٸ� false
		
		System.out.println(i+ " != " + k + "=>" + (i != k)); // ���ٸ� false
		System.out.println(i+ " != " + j + "=>" + (i != j)); // ���� �ʴٸ� true
		
		
	}
}
