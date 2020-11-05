package days12;

class StudentsGrade {
	StudentsGrade(){
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
	}
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
	
}
public class Grade {
	public static void main(String[] args) {
	
		StudentsGrade s = new StudentsGrade();
		
		
	}
}
