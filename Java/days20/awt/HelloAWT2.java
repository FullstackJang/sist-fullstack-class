package day1118;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 윈도우 프로그래밍(Component Programming)
 */


//1. 윈도우 컴포넌트를 상속 받는다. (사용자에게 보여주기 위해서)
@SuppressWarnings("serial")
public class HelloAWT2 extends Frame{

    //2생성자 작성.
    public HelloAWT2(){
        super("안녕하세요. AWT");// 부모클래스의 생성자 호출

//        Container a = new Frame();
//        Window b = new Frame();

        //3. 컴포넌트를 생성
        Button btn = new Button("나는 버튼"); //has-a

        //4. 컴포넌트를 배치
        add(btn);
 
        //5. 윈도우 크기 설정
        setSize(500,400);

        //6. 윈도우를 사용자에게 보여준다.
        setVisible(true);

        //7. 윈도우 종료이벤트 처리
//		addWindowListener(this) //WindowListener와 is a 관계가 아니므로 this는 사용할 수 없다.
		//WindowListener interface를 미리 구현한 클래스인 WindowAdapter를 제공
        //WindowAdapter 클래스는 WindowListener의 7개의 추상method를 일반 method로 구현 했기 때문에 WindowAdapter의 필요한 method만 구현(Override)한다.
        addWindowListener(new WindowAdapter() {
        	
        	@Override
        	public void windowClosing(WindowEvent e) {
        		dispose();
        	}
		}); //익명클래스는 WindowAdapter가 부모이다.
			
    }//HelloAWT
}

