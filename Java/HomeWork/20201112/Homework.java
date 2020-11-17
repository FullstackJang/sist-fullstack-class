package day1112;

import java.util.StringTokenizer;

public class Homework {
	int cnt;
	String station="봉천,신림,신대방.구로디지털단지,대림.신도림,문래,영등포구청,당산,합정,홍대입구";

	//1. 각각의 역을StringTokenizer를 사용하여 String[]에 저장하고 반환하는 method를 만든다.
	public String[] MethodA(){

		StringTokenizer stk = new StringTokenizer(station, ",.");
		String[] arr = new String[stk.countTokens()];

		int j = 0;
		while(stk.hasMoreTokens()) { //토큰 가지고있니?			
			arr[j] = stk.nextToken(); 			
			j++;
		}
		return arr;
	}

	public int getCnt() {

		for(int i =0; i < station.length(); i++) {
			if(station.charAt(i) == '신') {  //startsWith 오답
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Homework a = new Homework();

		String[] arr = a.MethodA();
		System.out.println("역명");
		System.out.println("---------");
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("---------");
		System.out.printf("정거장 수:[%d]개, '신'으로 시작하는 역수[%d]역\n",arr.length,a.getCnt());

	}
}
