package day1118;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 윈도우 프로그래밍(Component Programming)
 */


//1. 윈도우 컴포넌트를 상속 받는다. (사용자에게 보여주기 위해서)
@SuppressWarnings("serial")
public class HelloAWT3 extends Frame implements WindowListener{

    //2생성자 작성.
    public HelloAWT3(){
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
        addWindowListener(this);
    }//HelloAWT
    //Mywin은 Frame이다. is-A관계
    //MYwin은 WindowListener이다.
    //자식은 부모이다.

    public static void main(String[] args) {

        new HelloAWT3();

    }

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}//windowOpened

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		System.exit(0); //어디에서든 사용가능. 실행중인 JVM을 강제로 종료하는 일 
		//0-false 비정상 종료: 종료 이후의 작업을 수행하지 않고, 바로 종료 
		//1-true 정상 종료: 종료 이후의 작업을 수행한 후 종료
		
		dispose(); //부모 클래스가 Window인 경우에만 사용 가능. 현재 윈도우를 종료

	}//windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}//windowClosed

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}//windowIconified

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}//windowDeiconified

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}//windowActivated

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}//windowDeactivated
}
