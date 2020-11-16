package day1116;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * �˻��� ����� ������, �ߺ����� ������� �ʴ� Set���<br>
 * �Է°��� ���������� �Էµ��� �ʴ´�.
 */
public class UseSet {

    public UseSet(){

        //1. ����
        Set<String> set = new HashSet<String>();

        //2. �� �Ҵ�(�ֱ�)
        set.add("Ʈ���̽�");
        set.add("������");
        set.add("���");
        set.add("�����̰�");
        set.add("���ι̽�����");
        set.add("���"); // �ߺ� �����ʹ� �߰� ���� �ʴ´�.
        
        //3. �� ����
        set.remove("�����̰�");
        
        System.out.println(set.size() + "/" + set);

        //4. �˻�. : Iterator�� ���
        Iterator<String> ita = set.iterator(); // Iterator�� �����͸� ���� Set�� ������� �Ѱ� �ش�.

        while(ita.hasNext()){ // ���� �����ϴ� ��
            System.out.println(ita.next()); //���� ��� �����͸� ���� ������ �̵�
        }
    }//UseSet

    public static void main(String[] args) {

        UseSet us = new UseSet();

    }//main
}//class
