package day1117;

import java.util.LinkedList;
import java.util.List;

/**
 * java.util.List를 구현한 클래스: 1차원 배열의 형식이면서 가변 길이 형
 * 발생된 데이터가 기존의 데이터 사이에 들어가는 일이 많을 때 사용
 */
public class UseLinkedList {

    public UseLinkedList() {
        //1. 생성
        List<String> ll = new LinkedList<String>(); // IS-A 관계 객체화
        LinkedList<String> list = new LinkedList<String>(); // 자식클래스로 객체화

        //2. 값 추가: 순차적
        ll.add("Java");
        ll.add("Oracle");
        ll.add("JDBC");

        list.add("Java");
        list.add("JSP");
        list.add("XML");
        list.add("JSON");

        System.out.println(ll.size() + "/" + ll);
        System.out.println(list.size() + "/" + list);
        //기존에 데이터 사이에 값을 추가할 때 ArrayList보다 효율이 좋다

        list.add(1,"JDBC");
        list.add(1,"Oracle");

        System.out.println(list.size() + "/" + list);

        list.remove(4);

        System.out.println(list.size() + "/" + list);

        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }//UseLinkedList

    public static void main(String[] args) {
        new UseLinkedList();
    }
}
