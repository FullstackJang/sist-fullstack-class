package day1029;

/*
 *  ������ for�� ���
 *  �ε����� ����� �� ����, �迭, List, Set�� ��� ���� ���� ó�� ���� ������ ��� �� �� ���
 * 
 */

public class ImprovementFor {
	
	public static void main(String[] args) {
		//Array : �迭
		 int[] arr = {2020, 10, 29, 12, 7};
		 
		 //������ for: �ε����� ��� �� �� ����.
		 for(int value : arr) {
			 System.out.println(value);
		 }
		 
		 //���� for :�ε����� ����� �� �ִ�.
		 for(int i = 0; i < arr.length;i++) {
			 System.out.println(arr[i]);
		 }
		 
		
	}//main
}//class
