package day1112;

import java.util.StringTokenizer;

public class Work1112 {
	/**
	 * CSV 데이터를 토큰으로 분리하여 배열 담는 일.
	 * @return
	 */
	public String[] csvProcess() {
		String[] stationArr = null;
		String station="봉천,신림,신대방.구로디지털단지,대림.신도림,문래,영등포구청,당산,합정,홍대입구";

		//1. 하나의 문자열에서 특정 문자로 분리할 수 있는 클래스를 생성(StringTokenizer)
			 StringTokenizer stk = new StringTokenizer(station,",."); // 값을가지지 않고 들어오는 값에 대한 제어권을 가지게 됨
		//2. 토큰의 갯수로 배열을 생성 - 배열의 방이 동적으로 생성
			 stationArr = new String[stk.countTokens()]; //인덱스를 사용하여 방에 접근
			 int idx = 0;
		//3. 토큰이 존재하는지 물어보고 토큰이 있다면  
			 while(stk.hasMoreTokens()) {
				//4. 토큰을 가져와서 배열방에 저장
				 stationArr[idx] = stk.nextToken();
				 idx++;
			 }//end while
		return stationArr;
	}//csvProcess

	public void printArray(String[] stationArr) {

		System.out.println("역명");
		System.out.println("---------");
		
		int cnt = 0;
		
		for(int i =0; i < stationArr.length; i++) {
			System.out.println(stationArr[i]);
			if(stationArr[i].startsWith("신")) {//'신'으로 시작하는 역의 수
				cnt++;
			}//end if
		}//end for
		System.out.println("---------");
		System.out.printf("정거장 수[%d]개, ;'신'으로 시작하는 역의 갯수[%d]\n",stationArr.length,cnt);
	}//printArray
	
	

	public static void main(String[] args) {

		//객체화
		Work1112 work = new Work1112();
		
		//1.CSV데이터를 처리하는 method 호출
		String[] temp = work.csvProcess();
		
		//2.출력
		work.printArray(temp);
		
		
	}//main
}//class
