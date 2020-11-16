package day1116;

import java.util.List;
import java.util.Vector;

/**
 * - �˻��� ����� ������, �ߺ� �����͸� ������ �� �ִ� List�� ���
 * - ����������: �������� �߰�, �����۾��� ���� ���� ������ ����ȴ�.
 */
public class UseList {
    /**
     * Multi Thread���� ���� ���� �Ұ��� (����ȭ)
     * �ӵ��� ArrayList���� ������.
     */
    public void useVector() {
        //1. ���� : Generic�� �⺻���� ����� �� ���� / �⺻�� ��� Wrapper Class�� ���
        Vector<Integer> vec = new Vector<Integer>(3);

        //�⺻ ���� ũ��, size�� ���� ũ�Ⱑ ������ ����, �����Ͱ� �߰��Ǹ� ���� ũ�Ⱑ �þ��.
        List<String> list = new Vector<String>();

        System.out.println("������ ũ��" + vec.size());
        System.out.println("����Ʈ�� ũ��" + list.size());

        //2. �� �߰�: Generic���� ���� �� ���������� �߰� ����
        vec.add(10); // �⺻�� ���������� �߰��ϸ�, �����Ϸ���
        // �⺻�� ���������� �߰��ϸ�,JVM�� �⺻�� ���������� �����Ǵ� Wrpper Class�� ����Ͽ� ��ü�� ����� �߰��Ѵ�. JDK1.5�������� �߰� �� autoboxing�̶�� �Ѵ�.
        vec.add(20); // => vec.add(new Integer(20));���� ����ȴ�.
        System.out.println("������ ũ��" + vec.size()); // size 2
        vec.add(30);
        vec.add(10); // ���� Capacity�� ũ�⸦ 3���� �����Ͽ�����, capacity�� ũ�⸦ �ʰ��ϴ��� ���� �����Ͽ� �߰��ȴ�.
        System.out.println("������ ũ��" + vec.size()); // size 4
        System.out.println(vec); // Object.toString()�� Vector�� Override�Ͽ� �ּҰ� �ƴ� ���� ���

        list.add("�糪");
        list.add("���");
        list.add("��ġ");
        list.add("�̳�");
        list.add("����");
        System.out.println("list ũ��: " + list.size() + ", " + list);

        //---�迭�� ����
        //�迭�� ����Ʈ�� ũ��� ����
        //        int[] arr = new int[vec.size()]; //int�� Integer�� ���� ���������� �ƴϴ�.
        Integer[] arr1 = new Integer[vec.size()];
        String[] arr = new String[list.size()];

        //����: Generic�� ������� �ʰ� �����ϸ�(����)��� �߻��Ѵ�.
            list.toArray(arr);
            vec.toArray(arr1);

        //3. �� ���: Unboxing
        String name = list.get(0); //�Էµ��������� �����ϴ� �������� ���ٸ� Unboxing ���� x
        System.out.println(name);

        int num = vec.get(0); // Wrapper Class�� Generic���� �����Ǿ� ���� �� �⺻�� ������������ ���� ������ JVM�� Wrapper Class���� �⺻������ ���� ���� Unboxing�� ���� ��

        //int num = vec.get(0).intValue(); // ((Integer)vec.get(0)).intValue();

        System.out.println(name + "/" + num);

        //4. �ϰ�ó��
        for (int i = 0; i < vec.size(); i++) {
            System.out.println(vec.get(i));
        }//end for

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }//end for

        //�� ����
        //index
        vec.remove(1); //20����
        list.remove(3); //"��ġ"����
        System.out.println(vec);
        System.out.println(list);

        //Ojbect
        vec.remove(new Integer(30)); // 30�� ���� �Ǿ����ϴ�.  //������ ���ٸ� Wrapper�� ��ü�� ���� ����� �ȴ�. JDK 1.8����
        vec.remove(Integer.valueOf(30)); // 30�� ���� JDK9 ���Ŀ��� �����ڰ� ����õ���� ����Ǿ� static method���
        list.remove("�糪");
        System.out.println(vec);
        System.out.println(list);//�糪����

        System.out.println("vec�� ����°�?" + vec.isEmpty());
        System.out.println("list�� ����°�?" + list.isEmpty());

        //��� ���� ���� ����
        vec.clear();
        list.clear();
        System.out.println("vec�� ����°�?" + vec.isEmpty());
        System.out.println("list�� ����°�?" + list.isEmpty());

        System.out.println(list.size() == 0);

        System.out.println("------�迭�� ������ ����--------");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);

        }     for(int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i]);
        }
    }//useVector

    /**
     * Multi Thread�� ���� ���� ���� (�񵿱�ȭ)
     * �ӵ��� Vector���� ������.
     */
    public void useArrayList() {
    }//useArrayList

    public static void main(String[] args) {

        UseList ul = new UseList();

        ul.useVector();
        System.out.println("--------------------");
        ul.useArrayList();

    }//main
}//class
