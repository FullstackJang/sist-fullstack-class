package day1112;

public class Lotto {

	public Lotto() {
	}

	public int[] methodA() {

		int[] arr = new int[6];

		for(int i = 0; i < arr.length; i++) {
			int k = ((int)(Math.random()*45)+1);
			arr[i] = k;

			for(int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {

		Lotto l = new Lotto();

		int[] arr = l.methodA();

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}//main
}//class
