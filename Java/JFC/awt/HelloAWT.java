package day1117;

import java.awt.*;

/**
 * 윈도우 프로그래밍(Component Programming)
 */

//1. 윈도우 컴포넌트를 상속 받는다. (사용자에게 보여주기 위해서)
@SuppressWarnings("serial")
public class HelloAWT extends Frame {

    //2생성자 작성.
    public HelloAWT(){
        super("안녕하세요. AWT");// 부모클래스의 생성자 호출

        //3. 컴포넌트를 생성
        Button btn = new Button("나는 버튼");

        //4. 컴포넌트를 배치
        add(btn);

        //5. 윈도우 크기 설정
        setSize(500,400);

        //6. 윈도우를 사용자에게 보여준다.
        setVisible(true);

    }//HelloAWT

    public static void main(String[] args) {

        new HelloAWT();

    }
}
