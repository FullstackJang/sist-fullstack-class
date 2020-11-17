package day1117;

import day1116.UseSet;

import java.util.Stack;

/**
 * LIFO(Last In First Out)를 구현한 클래스
 */
public class UseStack {

    public UseStack() {
        //1. 생성: 절대로 IS-A 관계의 객체화를 하지 않는다.
        Stack<String> sta = new Stack<String>();

        //2. 메소드 호출: 부모의 method는 사용하지 않는다.
        //값 추가
        sta.push("1. Java SE");
        sta.push("2. Oracle");
        sta.push("3. JDBC");
        sta.push("4. Java EE");
//        System.out.println(sta.pop());
        System.out.println(sta);
        System.out.println("스택이 비어있는가?: " + sta.empty()); //false

        //모든 방의 값을 얻기: 마지막에 입력된 것이 먼저 나온다.
        while (!sta.empty()) {
            System.out.println(sta.pop());
        }
        /*4. Java EE
          3. JDBC
          2. Oracle
          1. Java SE
        */

        System.out.println("스택이 비어있는가?: " + sta.empty()); //true
    }

    public static void main(String[] args) {
        new UseStack();
    }//main
}//UseStack
