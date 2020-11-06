package days12;

// �ֹι�ȣ�� �Է¹޾� ��ȿ�� �˻�.
// ��ü�� �����Ǹ� �ν��Ͻ� ������ �ֹι�ȣ�� �����Ѵ�.
// 1.����� �ֹι�ȣ�� ���ڼ��� 14���̸� true �׷��� ������ false ��ȯ�ϴ� �޼ҵ�
// 2.����� �ֹι�ȣ�� 7��° �ڸ��� '-'�� �����ϸ� true �׷��� ������ false�� ��ȯ�ϴ� method
// 3.��������� �����Ͽ� String���� ��ȯ�ϴ� method ��ȯ������:"1998�� 1��1��"
// 4.���̸� �����Ͽ� int�� ��ȯ�ϴ� method 
// 5.������ �����Ͽ� String���� ��ȯ�ϴ� method ��ȯ������ ���� or ����
// 1,2-1900����/  3,4-2000���� / 5,6-1900���� �ܱ��� / 7,8-2000���� �ܱ���
// 0,9-1800����
// 6�� �츦 ���Ͽ� String���� ��ȯ�ϴ� method

class Privacy{

	String securityNumber; //�ֹι�ȣ

	public Privacy(String securityNumber) {
		this.securityNumber = securityNumber; //�ֹι�ȣ init
	}//������

	//Solve1 ����� �ֹι�ȣ�� ���ڼ��� 14���̸� true �׷��� ������ false ��ȯ�ϴ� �޼ҵ�
	public boolean snAvailable(){
		boolean flag = (securityNumber.length() == 14) ? true : false; //�ֹι�ȣ�����̰� 14�� ����? �� : �ƴ�

		return flag;
	}//snAvailable

	//Solve2 ����� �ֹι�ȣ�� 7��° �ڸ��� '-'�� �����ϸ� true �׷��� ������ false�� ��ȯ�ϴ� method
	public boolean hyphenCheck() {
		boolean flag = (securityNumber.contains("-") ? true : false); //�ֹι�ȣ�� -�� �����ϳ�? �� : �ƴ�

		return flag;
	}//hyphenCheck

	// 3.��������� �����Ͽ� String���� ��ȯ�ϴ� method ��ȯ������:"1998�� 1��1��"
	public String myBirthday() {
		// 1,2-1900����/  3,4-2000���� / 5,6-1900���� �ܱ��� / 7,8-2000���� �ܱ���
		// 0,9-1800����
		String yearmd = securityNumber.substring(0,6); // 880101
		String year = " "; 
		String myYear,myMonth,myDay = " "; 
		if((securityNumber.charAt(0)-48) == 0) { //00��� ���̸�
			year = "20" + yearmd;
		}
		else { // 90��� ���̸�
			year = "19" + yearmd;
		}

		myYear = year.substring(0,4)+"��"; // yyyy + "��"
		myMonth = year.substring(5,6)+"��"; // mm + '"��"
		myDay = year.substring(6,8)+"��"; // dd + "��"
		year = myYear + myMonth + myDay; // ���ڿ� ����
		return year;

	}//myBirthday

	// 4.���̸� �����Ͽ� int�� ��ȯ�ϴ� method 
	public int myAge() {

		int age = Integer.parseInt(securityNumber.substring(0,2)); //���ڿ��� �ֹι�ȣ �յ��ڸ� "YY" ���ڷ� ����ȯ

		int myage = 0;

		if((securityNumber.charAt(0)-48) == 0) { 
			myage = 2020-(2000+age)+1;
		}
		else {
			myage = 2020-(1900+age)+1;
		}

		return myage;
	}//myAge

	//Solve5 ������ �����Ͽ� String���� ��ȯ�ϴ� method ��ȯ������ ���� or ����
	// 1,2-1900����/  3,4-2000���� / 5,6-1900���� �ܱ��� / 7,8-2000���� �ܱ���  0,9-1800����

	public String myGender() {
		String gender = "����";
		int genderValue = Integer.parseInt(securityNumber.substring(7,8))%2;

		if(genderValue == 1) {
			gender = "����";
		}
		else {
			gender = "����";
		}
		return gender;
	}//myGender


	//Solve6 �츦 ���Ͽ� String���� ��ȯ�ϴ� method
	/*
	0: ������, 1: ��, 2: ��, 3: ����, 4: ��, 5: ��,	//10��27�� UseElseIf.java Ȱ��
	6: ȣ����, 7: �䳢, 8: ��, 9: ��, 10: ��, 11: ��
	 */
	public String myZodiac() {
		
		String myYear = securityNumber.substring(0,2);
		if((securityNumber.charAt(0)-48) == 0) { //00��� ���̸�
			myYear = "20" + myYear;
		}
		else { // 90��� ���̸�
			myYear = "19" + myYear;
		}
		int integerYear = Integer.parseInt(myYear);
		
		String[] zodiac = {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","��"};
		String myZodiac = " ";
		
		if(integerYear%12 == 0) myZodiac = zodiac[0];
		else if(integerYear%12 == 1)myZodiac = zodiac[1];
		else if(integerYear%12 == 2)myZodiac = zodiac[2];
		else if(integerYear%12 == 3)myZodiac = zodiac[3];
		else if(integerYear%12 == 4)myZodiac = zodiac[4];
		else if(integerYear%12 == 5)myZodiac = zodiac[5];
		else if(integerYear%12 == 6)myZodiac = zodiac[6];
		else if(integerYear%12 == 7)myZodiac = zodiac[7];
		else if(integerYear%12 == 8)myZodiac = zodiac[8];
		else if(integerYear%12 == 9)myZodiac = zodiac[9];
		else if(integerYear%12 == 10)myZodiac = zodiac[10];
		else if(integerYear%12 == 11)myZodiac = zodiac[11];

		return myZodiac;
	}//myZodiac

}//class

public class StringProject {

	public static void main(String[] args) {
		
		// ��ü �ν��Ͻ�ȭ
		// new�� ���� heap�� ��ü ����
		// ������ ����
		// person1���� new���� heap�� ������ �ν��Ͻ� ��ü�� �ּҸ� ����Ű�� �ִ�.
		Privacy person1 = new Privacy("910723-1234567");
		
		
		if(person1.snAvailable()) { //�ֹι�ȣ ��ȿ���� Ȯ��
			if(person1.hyphenCheck()) { //������ Ȯ��
				String birth = person1.myBirthday(); //YYYY��MM��DD��
				int age = person1.myAge();  // ����
				String gender = person1.myGender(); // ����
				String zodiac = person1.myZodiac(); // ��
				System.out.printf("�������:%s\n����:%d\n����:%s\n��:%s",birth,age,gender,zodiac);
			} else {
				System.out.println("-�� Ȯ���ϼ���.");
			}//end else

		} else {
			System.out.println("�ֹι�ȣ�� �ڸ��� Ȯ��");
		}//end else
	}//main
}//class
