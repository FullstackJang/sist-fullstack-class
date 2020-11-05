package days12;

/**
 * 열로만 구성된 일차원 배열
 * @author owner
 *
 */
public class Array1 {

	public Array1() {
		//1. 선언 ) 데이터형[] 배열명 = null;
		//		  데이터형 배열명[] =null;
		int[] arr = null;
		int arr1[] = null;

		//2.생성 ) 배열명 = new 데이터형[방의 갯수]; //모든 방의 값은 초기화 된다.
		arr = new int[5];//방의 갯수를 설정하면 방의 갯수가 변경되지 않음
		arr1 = new int[4];
		System.out.printf("arr배열의 방의 갯수 %d, arr1배열의 방의 갯수 %d\n",arr.length,arr1.length);

		//3.값 할당 ) 배열명[방의번호] = 값;
		arr[0] = 2020;
		arr[1] = 11;
		arr[2] = 5;
		arr[3] = 12;
		arr[4] = 20;

		//		arr[8] = 15; //인덱스에 주의하여 사용

		//4. 값 사용 ) 배열명[방의번호]
		System.out.printf("arr[0]=%d\tarr[1]=%d\n",arr[0],arr[1]);
		System.out.printf("arr1[0]=%d\tarr1[1]=%d\n",arr1[0],arr1[1]);


		//---------------------------------------
		//일괄처리
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %-5d", i, arr[i]);
		}//end for
	}//Array1


	/**
	 * 배열을 기본형형식(new를 사용하지 않고)으로 사용
	 */
	public void useArray1() {
		System.out.println("\n--------------");

		//기본형 형식의 사용
		//입력되는 값으로 방의 갯수가 설정된다.
		//문법) 데이터형[] 배열명 = {값,,,,};
		//		int[] arr = new int[] {10,100,1000,10000,100000};
		int[] arr = {10,100,1000,10000,100000};
		System.out.println(arr.length);
		//필요한 경우 방의 값을 변경할 수 있음
		arr[1] = 500;

		//출력
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%-10d\n",i,arr[i]);
		}//end for

		String[] names = {"모모","사나","정연","미나","나연","쯔위","지효"};
		int[] score = {82,70,96,85,79,68,39};
		System.out.println("==============");
		System.out.println("번호\t이름\t점수\t학점");
		//학점을 구하는 method를 작성하고 점수를 넣어 학점을 구하여 출력
		//학점은 A+(96~100), A(90~94),B+(85~89),B(80~84)
		int totalScore =0;

		for(int i = 0; i < names.length;i++) {
			totalScore += score[i]; //totalScore = totalScore+score[i];
			System.out.printf("%d\t%s\t%d\t%s\n",i+1,names[i],score[i],processGrade(score[i]));
		}//end for
		System.out.println("==============================");
		System.out.printf("응시인원[%d명], 총점[%d], 평균[%.2f],",names.length ,totalScore,((double)totalScore/names.length));

	}//useArray1

	/**
	 * 입력된 점수로 학점을 구하는 일
	 * @param score 점수
	 * @return 점수에대한 학점
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

		new Array1(); //생성자는 호출하지만 method를 호출할 수 없다.

		new Array1().useArray1();
	}//main
}//class
