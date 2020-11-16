package day1116;

import java.util.ArrayList;
import java.util.List;

public class UnusedGeneric {

    public UnusedGeneric() {
        //JDK1.4���� ����ϴ� ����(Generic�� �������� ���� ��) : List�� ��� ���� ������ �� ����

        //1. ����
        @SuppressWarnings("rawtypes")
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(list.size());

        //2. �� �߰� (Generic�� ������� ������ ��� ���� �߰��� �� ����)
        list.add(10);
        list.add(20);
//        list.add(30.11); // Generic�� ������� �ʾұ� ������ ��� �� �߰� ����
//        list.add("�ȳ��ϼ���");

        System.out.println(list.size());

        //3. �� ���
        for (int i = 0; i < list.size();i++){
            System.out.println(list.get(i) * 10); // ���� ������ �����Ͽ� ����� �� Error�� �߻�
            System.out.println(list.get(i)); // �ܼ��� ���� ����ϴ°Ŵ� ������ �߻����� �ʴ´�.
        }

    }//UnusedGeneric

    public static void main(String[] args) {

        new UnusedGeneric();

    }//main
}//class
