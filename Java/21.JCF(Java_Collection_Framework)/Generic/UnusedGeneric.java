package day1116;

import java.util.ArrayList;
import java.util.List;

public class UnusedGeneric {

    public UnusedGeneric() {
        //JDK1.4까지 사용하던 문법(Generic이 지원되지 않을 때) : List가 모든 값을 저장할 수 있음

        //1. 생성
        @SuppressWarnings("rawtypes")
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(list.size());

        //2. 값 추가 (Generic을 사용하지 않으면 모든 값을 추가할 수 있음)
        list.add(10);
        list.add(20);
//        list.add(30.11); // Generic을 사용하지 않았기 때문에 모든 값 추가 가능
//        list.add("안녕하세요");

        System.out.println(list.size());

        //3. 값 얻기
        for (int i = 0; i < list.size();i++){
            System.out.println(list.get(i) * 10); // 값을 꺼내서 연산하여 사용할 때 Error가 발생
            System.out.println(list.get(i)); // 단순히 값을 출력하는거는 문제가 발생하지 않는다.
        }

    }//UnusedGeneric

    public static void main(String[] args) {

        new UnusedGeneric();

    }//main
}//class
