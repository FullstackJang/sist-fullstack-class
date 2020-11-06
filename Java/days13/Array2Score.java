package day1106;

/**
 * 여러학생의 여러 점수를 처리
 * 시험 과목 : Java SE, Oracle, JSP 
 * @author owner
 *
 */
public class Array2Score {

	private int javaTotal,oracleTotal,jspTotal;
	private int topScore; //최고 점수
	private int topNumber; //최고 번호
	private String topName; //최고점수 사람
	private int bestScore; //한 사람의 최고점수
	public static final int JAVA_INDEX=0;
	public static final int ORACLE_INDEX=1;
	public static final int JSP_INDEX=2;
	public int firstGrade =0;
	public void processScore() {

		String[] names = {"사나","모모","정연","쯔위","미나","지효"};
		int[][] score = {{91,86,93},{83,81,88},{77,65,100},{67,50,89,},{97,93,99},{78,77,89}};
		int totalScore = 0; //한 학생의 총점
		double avg=0.0;

		System.out.println("번호\t이름\t\tJava\tOracle\tJSP\t총점\t평균\t최고 점수");	
		System.out.println("------------------------------------------------------------");
		for(int i = 0; i < score.length; i++) { //행
			System.out.printf("%d\t%s\t",i+1,names[i]);
			for(int j = 0; j < score[i].length; j++) { //열
				System.out.printf("%d\t",score[i][j]);
			}//end for
			javatotalScore(score[i][JAVA_INDEX]); // 자바점수의 누적 합
			oracletotalScore(score[i][ORACLE_INDEX]); // 오라클 점수의 누적 합
			jsptotalScore(score[i][JSP_INDEX]); // jsp점수의 누적합

			//총점 구하기
			totalScore = totalScore(score[i]); // 이차원 배열의 한 행은 일차원 배열로 이루어져있따.
			//행을 넣어주면 일차원 배열이 들어간다.

			//최고점수
			topScore(totalScore,i);
			
			//한사람 과목 중 최고점수
			bestScore = bestScore(score[i]);
			
			
			//평균 구하기
			avg = avg(totalScore,score[i].length);
			
			System.out.printf("%d\t\t%.1f\t%d\n",totalScore,avg,bestScore);
		}//end for

		System.out.println("------------------------------------------------------------");
		System.out.printf("응시인원 [%d]\t",score.length);
		System.out.printf("총점 Java SE [%d], Oracle [%d], JSP [%d]",javaTotal,oracleTotal,jspTotal);
		System.out.printf("전체 총점 [%d], 전체 평균[%.2f]\n",allTotalScore(),allAvg(allTotalScore(),score.length,score[0].length));
		System.out.printf("1등학생 점수: [%d], 1등학생의 번호[%d], 1등학생의 이름[%s]", topScore,topNumber,names[topNumber-1]);
	}//processScore


	public int bestScore(int[] score) {
		
		int studentScore = 0;
		for(int i = 0; i < score.length-1; i++) {
			for(int j = i+1; j < score.length; j++) {
				if(studentScore < score[j]) {
					studentScore = score[j];
				}
			}
		}
		
		return studentScore;
	}

	public void topScore(int score,int num) {
		if(topScore < score) {
			topScore= score;
			topNumber = num+1;
		}//end if
	}//topScore

	public double allAvg(int allTotalScore, int cnt, int subjectCnt) {
		double resultAvg = 0.0;

		resultAvg = allTotalScore / (cnt * subjectCnt);

		return resultAvg;
	}//allAvg

	/**
	 * 일차원 배열을 입력받아 모든 열을 합산하여 반환
	 * @param score 합산 점수를 구해야할 일차원 배열
	 * @return 합산점수
	 */
	public int totalScore(int[] score) {
		int total=0;

		for(int i = 0; i < score.length; i++) {
			total += score[i];
		}//end for

		return total;
	}//totalScore

	/**
	 * 총점에 대한 과목 수 평균 얻는 일
	 * @param totalscore 총점
	 * @param subjectCnt 과목수
	 * @return 평균
	 */
	public double avg(int totalScore, int subjectCnt) {
		double resultAvg = 0.0;

		resultAvg = (double)totalScore/subjectCnt;

		return resultAvg;
	}//avg

	public void javatotalScore(int score) {
		javaTotal += score;
	}

	public void oracletotalScore(int score) {
		oracleTotal += score;
	}

	public void jsptotalScore(int score) {
		jspTotal += score;
	}

	public int allTotalScore() {
		return javaTotal+oracleTotal+jspTotal;
	}//allTotal



	//--main
	public static void main(String[] args) {
		Array2Score as = new Array2Score();
		as.processScore();

	}//main
}//class
