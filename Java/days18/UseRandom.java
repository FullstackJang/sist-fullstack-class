package day1113;
import java.util.Random;

public class UseRandom {

    public UseRandom() {
        //1. Ŭ���� ��üȭ
        Random random = new Random();

//        System.out.println(random);

        //2. method�� ȣ���Ͽ� ������ ��� ��
        //������ ����
        int num = random.nextInt();
        System.out.println("�߻��� ����" + num);
        System.out.println("������ ����" + (num % 10)); // %�� ������
        System.out.println("������ �������� ����� ���" + Math.abs(num % 10));

        int num1 = random.nextInt(10); // nextInt(������)
        System.out.println("������ ����" + num1);

        //�Ǽ��� ����
        double num2 = random.nextDouble();
        System.out.println("�߻��� ���� " + num2);
        System.out.println("������ ���� " + num2 * 5); // * ������
        System.out.println("������ �������� ������ ��� " + (int) (num2 * 5)); // �Ǽ����� ���� ���� ��� �������� Casting�ϸ� ��
        
        
        //boolean ����
        boolean bool = random.nextBoolean();
        System.out.println(bool);
    }

    public static void main(String[] args) {

        new UseRandom();

    }
}

