package day1113;

import java.util.StringTokenizer;

public class Homework {

    public String[] getStation(String station) {
        StringBuilder sb = new StringBuilder(station.replace(" " , ""));

        sb.insert(station.indexOf("�Ŵ��,")+3, "���ε����� ����,");
       
        String newStation = sb.toString();

        StringTokenizer stk = new StringTokenizer(newStation,",.");
        String[] stationArr = new String[stk.countTokens()];

        int idx = stk.countTokens()-1;
        while(stk.hasMoreTokens()) {
            stationArr[idx] = stk.nextToken();
            idx--;
        }
        return stationArr;
    }

    public static void main(String[] args) {
        Homework h = new Homework();

        String station ="��õ, �Ÿ�,�Ŵ��,�븲.�ŵ���, ����,��������û, ���,����, ȫ�� �Ա�";

        h.getStation(station);
	String[] stationArr = h.getStation(station);

	System.out.println("����");
	System.out.println("--------");
        for (String s : stationArr) {
            System.out.println(s);
        }
	System.out.println("--------");

    }
}
