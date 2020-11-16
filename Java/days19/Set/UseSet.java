package day1116;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 검색의 기능이 없으며, 중복값을 허용하지 않는 Set사용<br>
 * 입력값은 순차적으로 입력되지 않는다.
 */
public class UseSet {

    public UseSet(){

        //1. 생성
        Set<String> set = new HashSet<String>();

        //2. 값 할당(넣기)
        set.add("트와이스");
        set.add("러블리즈");
        set.add("라붐");
        set.add("오마이걸");
        set.add("프로미스나인");
        set.add("라붐"); // 중복 데이터는 추가 되지 않는다.
        
        //3. 값 삭제
        set.remove("오마이걸");
        
        System.out.println(set.size() + "/" + set);

        //4. 검색. : Iterator를 사용
        Iterator<String> ita = set.iterator(); // Iterator에 데이터를 가진 Set의 제어권을 넘겨 준다.

        while(ita.hasNext()){ // 방이 존재하는 지
            System.out.println(ita.next()); //값을 얻고 포인터를 다음 방으로 이동
        }
    }//UseSet

    public static void main(String[] args) {

        UseSet us = new UseSet();

    }//main
}//class
