package day1112;

import java.util.StringTokenizer;

public class Homework {
	int cnt;
	String station="��õ,�Ÿ�,�Ŵ��.���ε����д���,�븲.�ŵ���,����,��������û,���,����,ȫ���Ա�";

	//1. ������ ����StringTokenizer�� ����Ͽ� String[]�� �����ϰ� ��ȯ�ϴ� method�� �����.
	public String[] MethodA(){

		StringTokenizer stk = new StringTokenizer(station, ",.");
		String[] arr = new String[stk.countTokens()];

		int j = 0;
		while(stk.hasMoreTokens()) { //��ū �������ִ�?			
			arr[j] = stk.nextToken(); 			
			j++;
		}
		return arr;
	}

	public int getCnt() {

		for(int i =0; i < station.length(); i++) {
			if(station.charAt(i) == '��') {  //startsWith ����
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Homework a = new Homework();

		String[] arr = a.MethodA();
		System.out.println("����");
		System.out.println("---------");
		for(int i=0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("---------");
		System.out.printf("������ ��:[%d]��, '��'���� �����ϴ� ����[%d]��\n",arr.length,a.getCnt());

	}
}
