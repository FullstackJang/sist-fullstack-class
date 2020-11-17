package day1113;

import java.util.StringTokenizer;

public class Homework {

    public String[] getStation(String station) {
        StringBuilder sb = new StringBuilder(station.replace(" " , ""));

        sb.insert(station.indexOf("신대방,")+3, "구로디지털 단지,");
       
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

        String station ="봉천, 신림,신대방,대림.신도림, 문래,영등포구청, 당산,합정, 홍대 입구";

        h.getStation(station);
	String[] stationArr = h.getStation(station);

	System.out.println("역명");
	System.out.println("--------");
        for (String s : stationArr) {
            System.out.println(s);
        }
	System.out.println("--------");

    }
}
