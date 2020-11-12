package day1112;


public class StringSplit {

	public void useSplit() {
		
		String csvData = "Java,Oracle,JDBC,HTML.CSS,JavaScript";
		String[] subjectArr = csvData.split(""); // split은 .(점)을 자를 수 없다. '.'을 자를려면 정규식형태로 사용. [문자] => [.]
		System.out.println(subjectArr.length);
		
		for(int i = 0; i < subjectArr.length; i++) System.out.println(subjectArr[i]);
	}
	
	public static void main(String[] args) {
		new StringSplit().useSplit();
	}//main
}//class
