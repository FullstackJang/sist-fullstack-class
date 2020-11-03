package day1103;

/**
 * 사람 객체를 사용하는 클래스
 * @author owner
 *
 */
public class UsePerson {	
	/**
	 * Java Application
	 * @param args 입력값
	 */
	public static void main(String[] args) {
		//객쳬화
		Person jang = new Person();
		jang.setName("장일규");
//		jang.setEye(2); //값ㅇ르 설정하는 코드는 필요 없다. 
//		jang.setMouth(1);
//		jang.setNose(1);
		
		System.out.println("눈:" + jang.getEye() + ", 코 :" + jang.getNose() + ", 입 :" + jang.getMouth());
		System.out.println(jang.getEye());
		System.out.println(jang.eat());
		System.out.println(jang.eat("돈카츠",8000));

		System.out.println("-------------------------");
		////// 좋아하는 연예인 이름으로 객체를 만들고 눈,코,이름 설정하고, 먹는일 수행
		
		//1.객체화
		Person sana = new Person();
		
		//2.setter 호출
		sana.setEye(2);
		sana.setNose(1);
		sana.setMouth(1);
		sana.setName("사나");
		
		//3.getter 호출
		System.out.println("내가 좋아하는 연예인의 이름은 " + sana.getName()+"\n사나의 눈은 " + sana.getEye() +"개 사나의 코는 " + sana.getNose() + "개 사나의 입은 " + sana.getMouth()+ "개");
		
		//4.동적인 일을 하는 method
		System.out.println(sana.eat());
		System.out.println(sana.eat("우동",5000));
		
		System.out.println("-------------------------");
		Person jinban = new Person(3,1,1);
		jinban.setName("천진반");
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("선두",0));
		
	}//main
} //class
