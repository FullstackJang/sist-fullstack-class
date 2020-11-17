package day1117;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

class MyDate{

    public void methodA() {

        Date date = new Date();
        Random r = new Random();

        SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd a hh:mm:ss EEEE", Locale.KOREA);
        SimpleDateFormat sdf1 = new SimpleDateFormat("YY-MM-dd a hh:mm:ss EEEE", Locale.UK);
        SimpleDateFormat sdf2 = new SimpleDateFormat("YY-MM-dd a hh:mm:ss EEEE", Locale.US);
        SimpleDateFormat sdf3 = new SimpleDateFormat("YY-MM-dd a hh:mm:ss EEEE", Locale.CHINA);
        SimpleDateFormat sdf4 = new SimpleDateFormat("YY-MM-dd a hh:mm:ss EEEE", Locale.JAPAN);

        String formatDate = sdf.format(date);
        String formatDate1 = sdf1.format(date);
        String formatDate2 = sdf2.format(date);
        String formatDate3 = sdf3.format(date);
        String formatDate4 = sdf4.format(date);

        int a = r.nextInt(5) + 1;
        switch (a) {

            case 1:
                System.out.println(formatDate);
                break;
            case 2:
                System.out.println(formatDate1);
                break;
            case 3:
                System.out.println(formatDate2);
                break;
            case 4:
                System.out.println(formatDate3);
                break;

        }
    }//methodA
}

public class UseDate {

    public static void main(String[] args) {

       MyDate a = new MyDate();
       a.methodA();
    }
}
