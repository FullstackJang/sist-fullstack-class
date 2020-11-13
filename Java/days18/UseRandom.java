package day1113;
import java.util.Random;

public class UseRandom {

    public UseRandom() {
        //1. 클래스 객체화
        Random random = new Random();

//        System.out.println(random);

        //2. method를 호출하여 난수를 얻는 일
        //정수의 난수
        int num = random.nextInt();
        System.out.println("발생한 난수" + num);
        System.out.println("범위의 난수" + (num % 10)); // %는 가짓수
        System.out.println("범위의 난수에서 양수만 얻기" + Math.abs(num % 10));

        int num1 = random.nextInt(10); // nextInt(가짓수)
        System.out.println("범위의 난수" + num1);

        //실수의 난수
        double num2 = random.nextDouble();
        System.out.println("발생한 난수 " + num2);
        System.out.println("범위한 난수 " + num2 * 5); // * 가짓수
        System.out.println("범위한 난수에서 정수만 얻기 " + (int) (num2 * 5)); // 실수에서 정수 값만 얻고 싶을때는 Casting하면 됨
        
        
        //boolean 난수
        boolean bool = random.nextBoolean();
        System.out.println(bool);
    }

    public static void main(String[] args) {

        new UseRandom();

    }
}

