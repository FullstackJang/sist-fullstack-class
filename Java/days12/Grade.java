package days12;

class StudentsGrade {
	StudentsGrade(){
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
	}
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
	
}
public class Grade {
	public static void main(String[] args) {
	
		StudentsGrade s = new StudentsGrade();
		
		
	}
}
