package day1112;

import java.util.StringTokenizer;

public class Work1112 {
	/**
	 * CSV �����͸� ��ū���� �и��Ͽ� �迭 ��� ��.
	 * @return
	 */
	public String[] csvProcess() {
		String[] stationArr = null;
		String station="��õ,�Ÿ�,�Ŵ��.���ε����д���,�븲.�ŵ���,����,��������û,���,����,ȫ���Ա�";

		//1. �ϳ��� ���ڿ����� Ư�� ���ڷ� �и��� �� �ִ� Ŭ������ ����(StringTokenizer)
			 StringTokenizer stk = new StringTokenizer(station,",."); // ���������� �ʰ� ������ ���� ���� ������� ������ ��
		//2. ��ū�� ������ �迭�� ���� - �迭�� ���� �������� ����
			 stationArr = new String[stk.countTokens()]; //�ε����� ����Ͽ� �濡 ����
			 int idx = 0;
		//3. ��ū�� �����ϴ��� ����� ��ū�� �ִٸ�  
			 while(stk.hasMoreTokens()) {
				//4. ��ū�� �����ͼ� �迭�濡 ����
				 stationArr[idx] = stk.nextToken();
				 idx++;
			 }//end while
		return stationArr;
	}//csvProcess

	public void printArray(String[] stationArr) {

		System.out.println("����");
		System.out.println("---------");
		
		int cnt = 0;
		
		for(int i =0; i < stationArr.length; i++) {
			System.out.println(stationArr[i]);
			if(stationArr[i].startsWith("��")) {//'��'���� �����ϴ� ���� ��
				cnt++;
			}//end if
		}//end for
		System.out.println("---------");
		System.out.printf("������ ��[%d]��, ;'��'���� �����ϴ� ���� ����[%d]\n",stationArr.length,cnt);
	}//printArray
	
	

	public static void main(String[] args) {

		//��üȭ
		Work1112 work = new Work1112();
		
		//1.CSV�����͸� ó���ϴ� method ȣ��
		String[] temp = work.csvProcess();
		
		//2.���
		work.printArray(temp);
		
		
	}//main
}//class
