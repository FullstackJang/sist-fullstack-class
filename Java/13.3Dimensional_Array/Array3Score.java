package day1109;

public class Array3Score {
	private int java_total;
	private int oracle_total;
	private int jsp_total;
	private int total_score;
	private int total_avg;
	private int java_good_Score;

	public static final int JAVA_INDEX=0;
	public static final int ORACLE_INDEX=1;
	public static final int JSP_INDEX=2;

	public Array3Score() {
		int[][][] groupScore = {
				{{88,87,89},{93,77,90},{74,79,81} }, //1조 학생의 점수
				{{60,69,75},{81,83,86}}, //2조 학생의 점수
				{{59,55,60},{100,99,100},{70,79,85},{73,82,88} }//3조 학생의 점수
		};

		//행마다 열의 갯수 다른 배열: 가변 배열
		String[][] names = {{"사나","모모","츠치"},{"가가","거거"},{"무무","라이언","앨리스","무지"}};

		System.out.println("조의 수: " + groupScore.length);
		for(int i = 0; i < groupScore.length; i++) {
			System.out.println((i+1) + "조의 조원 수:" + groupScore[i].length);
		}//end for

		System.out.println("-----------------------------");
		for(int i = 0; i < groupScore.length; i++) { //면
			System.out.println((i+1)+"조 점수");
			System.out.println("번호\t이름\tJava\tOracle\tJSP\t총점");
			for(int j = 0; j < groupScore[i].length; j++) { //행
				System.out.printf("%d번\t%s\t", j+1,names[i][j]); //삼차원 배열의 인덱스와 이차원 배열의 인덱스가 같다.
				for(int k = 0; k < groupScore[i][j].length; k++) { //열
					System.out.printf("%d\t",groupScore[i][j][k]);
				}
				java_total = javatotalScore(groupScore); // 자바점수의 누적 합
				oracle_total = oracletotalScore(groupScore); //오라클점수의 누적 합
				jsp_total = jsptotalScore(groupScore); //오라클점수의 누적 합
				total_score = totalScore();//총점
				total_avg = avgScore(total_score,groupScore.length);
				java_good_Score = javaBestScore(groupScore);
				System.out.printf("%d",totalScore(groupScore[i][j]));
				System.out.printf("\n");
			}
			System.out.println("------------------------");
			System.out.printf("과목별총점 Java[%d] Oracle[%d] JSP[%d] 전체 총점[%d] 전체 평균[%d]\n",java_total,oracle_total,jsp_total,total_score,total_avg);
			System.out.printf("Java의 최고 점수[%d]",java_good_Score);
		}
	}//Array3Score

	public int totalScore(int[] groupScore) {
		int studentScore = 0;

		for(int i = 0; i < groupScore.length; i++) {
			studentScore += groupScore[i];
		}
		return studentScore;
	}//totalScor

	public int javatotalScore(int[][][] groupScore) {

		int result = 0;

		for(int i = 0; i < groupScore.length; i++) {
			for(int j = 0; j < groupScore[i].length; j++) {
				result += groupScore[i][j][JAVA_INDEX];
			}
		}
		return result;
	}//classTotalScore

	public int oracletotalScore(int[][][] groupScore) {
		int reslut = 0;

		for(int i = 0; i < groupScore.length; i++) {
			for(int j = 0; j <groupScore[i].length; j++) {
				reslut += groupScore[i][j][ORACLE_INDEX];
			}
		}
		return reslut;
	}//oracletotalScore

	public int jsptotalScore(int[][][] groupScore) {
		int result = 0;

		for(int i = 0; i < groupScore.length; i++) {
			for(int j = 0; j <groupScore[i].length; j++) {
				result += groupScore[i][j][JSP_INDEX];
			}
		}
		return result;
	}//jsptotalScore

	public int totalScore() {
		return java_total+oracle_total+jsp_total;
	}//totalScore

	public int avgScore(int total_score, int i) {
		double result = total_score / (double)i; 

		return (int)result;
	}//avgScore

	public int javaBestScore(int[][][] groupScore) {
		int tempJava = groupScore[1][1][0];
		int goodScore = 0;
		for(int i = 0; i < groupScore.length; i++) {
			for(int j = 0; j < groupScore[i].length; j++) {
				if(tempJava < groupScore[i][j][JAVA_INDEX]) {
					goodScore = groupScore[i][j][JAVA_INDEX];
				}
			}
		}//end for
		return goodScore;
	}

	public static void main(String[] args) {
		new Array3Score();
	}//main
}//class
