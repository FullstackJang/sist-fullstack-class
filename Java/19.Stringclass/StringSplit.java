package day1112;


public class StringSplit {

	public void useSplit() {
		
		String csvData = "Java,Oracle,JDBC,HTML.CSS,JavaScript";
		String[] subjectArr = csvData.split(""); // split�� .(��)�� �ڸ� �� ����. '.'�� �ڸ����� ���Խ����·� ���. [����] => [.]
		System.out.println(subjectArr.length);
		
		for(int i = 0; i < subjectArr.length; i++) System.out.println(subjectArr[i]);
	}
	
	public static void main(String[] args) {
		new StringSplit().useSplit();
	}//main
}//class
