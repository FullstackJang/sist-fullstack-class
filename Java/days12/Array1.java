package days12;

/**
 * ���θ� ������ ������ �迭
 * @author owner
 *
 */
public class Array1 {

	public Array1() {
		//1. ���� ) ��������[] �迭�� = null;
		//		  �������� �迭��[] =null;
		int[] arr = null;
		int arr1[] = null;

		//2.���� ) �迭�� = new ��������[���� ����]; //��� ���� ���� �ʱ�ȭ �ȴ�.
		arr = new int[5];//���� ������ �����ϸ� ���� ������ ������� ����
		arr1 = new int[4];
		System.out.printf("arr�迭�� ���� ���� %d, arr1�迭�� ���� ���� %d\n",arr.length,arr1.length);

		//3.�� �Ҵ� ) �迭��[���ǹ�ȣ] = ��;
		arr[0] = 2020;
		arr[1] = 11;
		arr[2] = 5;
		arr[3] = 12;
		arr[4] = 20;

		//		arr[8] = 15; //�ε����� �����Ͽ� ���

		//4. �� ��� ) �迭��[���ǹ�ȣ]
		System.out.printf("arr[0]=%d\tarr[1]=%d\n",arr[0],arr[1]);
		System.out.printf("arr1[0]=%d\tarr1[1]=%d\n",arr1[0],arr1[1]);


		//---------------------------------------
		//�ϰ�ó��
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %-5d", i, arr[i]);
		}//end for
	}//Array1


	/**
	 * �迭�� �⺻������(new�� ������� �ʰ�)���� ���
	 */
	public void useArray1() {
		System.out.println("\n--------------");

		//�⺻�� ������ ���
		//�ԷµǴ� ������ ���� ������ �����ȴ�.
		//����) ��������[] �迭�� = {��,,,,};
		//		int[] arr = new int[] {10,100,1000,10000,100000};
		int[] arr = {10,100,1000,10000,100000};
		System.out.println(arr.length);
		//�ʿ��� ��� ���� ���� ������ �� ����
		arr[1] = 500;

		//���
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%-10d\n",i,arr[i]);
		}//end for

		String[] names = {"���","�糪","����","�̳�","����","����","��ȿ"};
		int[] score = {82,70,96,85,79,68,39};
		System.out.println("==============");
		System.out.println("��ȣ\t�̸�\t����\t����");
		//������ ���ϴ� method�� �ۼ��ϰ� ������ �־� ������ ���Ͽ� ���
		//������ A+(96~100), A(90~94),B+(85~89),B(80~84)
		int totalScore =0;

		for(int i = 0; i < names.length;i++) {
			totalScore += score[i]; //totalScore = totalScore+score[i];
			System.out.printf("%d\t%s\t%d\t%s\n",i+1,names[i],score[i],processGrade(score[i]));
		}//end for
		System.out.println("==============================");
		System.out.printf("�����ο�[%d��], ����[%d], ���[%.2f],",names.length ,totalScore,((double)totalScore/names.length));

	}//useArray1

	/**
	 * �Էµ� ������ ������ ���ϴ� ��
	 * @param score ����
	 * @return ���������� ����
	 */
	private String processGrade(int score) {
		String grade = "F";

		if(score > 94 && score < 101) grade ="A+";
		else if(score > 89 && score < 95) grade = "A";
		else if(score > 84 && score < 90) grade = "B+";
		else if(score > 79 && score < 85) grade = "B";
		else if(score > 74 && score < 80) grade = "C+";
		else if(score > 69 && score < 75) grade = "C";
		else if(score > 64 && score < 70) grade = "D+"; 
		else if(score > 59 && score < 65) grade = "D";

		return grade;

	}

	public static void main(String[] args) {

		new Array1(); //�����ڴ� ȣ�������� method�� ȣ���� �� ����.

		new Array1().useArray1();
	}//main
}//class
