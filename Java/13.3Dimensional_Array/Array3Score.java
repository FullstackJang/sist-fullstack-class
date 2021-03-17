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
				{{88,87,89},{93,77,90},{74,79,81} }, //1�� �л��� ����
				{{60,69,75},{81,83,86}}, //2�� �л��� ����
				{{59,55,60},{100,99,100},{70,79,85},{73,82,88} }//3�� �л��� ����
		};

		//�ึ�� ���� ���� �ٸ� �迭: ���� �迭
		String[][] names = {{"�糪","���","��ġ"},{"����","�Ű�"},{"����","���̾�","�ٸ���","����"}};

		System.out.println("���� ��: " + groupScore.length);
		for(int i = 0; i < groupScore.length; i++) {
			System.out.println((i+1) + "���� ���� ��:" + groupScore[i].length);
		}//end for

		System.out.println("-----------------------------");
		for(int i = 0; i < groupScore.length; i++) { //��
			System.out.println((i+1)+"�� ����");
			System.out.println("��ȣ\t�̸�\tJava\tOracle\tJSP\t����");
			for(int j = 0; j < groupScore[i].length; j++) { //��
				System.out.printf("%d��\t%s\t", j+1,names[i][j]); //������ �迭�� �ε����� ������ �迭�� �ε����� ����.
				for(int k = 0; k < groupScore[i][j].length; k++) { //��
					System.out.printf("%d\t",groupScore[i][j][k]);
				}
				java_total = javatotalScore(groupScore); // �ڹ������� ���� ��
				oracle_total = oracletotalScore(groupScore); //����Ŭ������ ���� ��
				jsp_total = jsptotalScore(groupScore); //����Ŭ������ ���� ��
				total_score = totalScore();//����
				total_avg = avgScore(total_score,groupScore.length);
				java_good_Score = javaBestScore(groupScore);
				System.out.printf("%d",totalScore(groupScore[i][j]));
				System.out.printf("\n");
			}
			System.out.println("------------------------");
			System.out.printf("�������� Java[%d] Oracle[%d] JSP[%d] ��ü ����[%d] ��ü ���[%d]\n",java_total,oracle_total,jsp_total,total_score,total_avg);
			System.out.printf("Java�� �ְ� ����[%d]",java_good_Score);
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
