package day1106;

/**
 * �����л��� ���� ������ ó��
 * ���� ���� : Java SE, Oracle, JSP 
 * @author owner
 *
 */
public class Array2Score {

	private int javaTotal,oracleTotal,jspTotal;
	private int topScore; //�ְ� ����
	private int topNumber; //�ְ� ��ȣ
	private String topName; //�ְ����� ���
	private int bestScore; //�� ����� �ְ�����
	public static final int JAVA_INDEX=0;
	public static final int ORACLE_INDEX=1;
	public static final int JSP_INDEX=2;
	public int firstGrade =0;
	public void processScore() {

		String[] names = {"�糪","���","����","����","�̳�","��ȿ"};
		int[][] score = {{91,86,93},{83,81,88},{77,65,100},{67,50,89,},{97,93,99},{78,77,89}};
		int totalScore = 0; //�� �л��� ����
		double avg=0.0;

		System.out.println("��ȣ\t�̸�\t\tJava\tOracle\tJSP\t����\t���\t�ְ� ����");	
		System.out.println("------------------------------------------------------------");
		for(int i = 0; i < score.length; i++) { //��
			System.out.printf("%d\t%s\t",i+1,names[i]);
			for(int j = 0; j < score[i].length; j++) { //��
				System.out.printf("%d\t",score[i][j]);
			}//end for
			javatotalScore(score[i][JAVA_INDEX]); // �ڹ������� ���� ��
			oracletotalScore(score[i][ORACLE_INDEX]); // ����Ŭ ������ ���� ��
			jsptotalScore(score[i][JSP_INDEX]); // jsp������ ������

			//���� ���ϱ�
			totalScore = totalScore(score[i]); // ������ �迭�� �� ���� ������ �迭�� �̷�����ֵ�.
			//���� �־��ָ� ������ �迭�� ����.

			//�ְ�����
			topScore(totalScore,i);
			
			//�ѻ�� ���� �� �ְ�����
			bestScore = bestScore(score[i]);
			
			
			//��� ���ϱ�
			avg = avg(totalScore,score[i].length);
			
			System.out.printf("%d\t\t%.1f\t%d\n",totalScore,avg,bestScore);
		}//end for

		System.out.println("------------------------------------------------------------");
		System.out.printf("�����ο� [%d]\t",score.length);
		System.out.printf("���� Java SE [%d], Oracle [%d], JSP [%d]",javaTotal,oracleTotal,jspTotal);
		System.out.printf("��ü ���� [%d], ��ü ���[%.2f]\n",allTotalScore(),allAvg(allTotalScore(),score.length,score[0].length));
		System.out.printf("1���л� ����: [%d], 1���л��� ��ȣ[%d], 1���л��� �̸�[%s]", topScore,topNumber,names[topNumber-1]);
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
	 * ������ �迭�� �Է¹޾� ��� ���� �ջ��Ͽ� ��ȯ
	 * @param score �ջ� ������ ���ؾ��� ������ �迭
	 * @return �ջ�����
	 */
	public int totalScore(int[] score) {
		int total=0;

		for(int i = 0; i < score.length; i++) {
			total += score[i];
		}//end for

		return total;
	}//totalScore

	/**
	 * ������ ���� ���� �� ��� ��� ��
	 * @param totalscore ����
	 * @param subjectCnt �����
	 * @return ���
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
