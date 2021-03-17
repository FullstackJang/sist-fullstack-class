package day1118;

import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * AWT 보다 향상 된 Window Application을 제작할 수 있는 Swing을 사용
 * @author owner
 *
 */

//1. javax.swing.JFrame을 상속 받는다.
@SuppressWarnings("serial")
public class UseSwing extends JFrame {
	
	//2. default constructor
	public UseSwing() {
		super("JFrame을 사용하여 윈도우 디자인 제공.");
	
		//3. Component를 생성
		Button btn = new Button("AWT 버튼");
		JButton jbtn = new JButton("Swing 버튼");
		
		//4. 배치(Component를 붙임)
		//배치 관리자(Layout Manager)를 사용하여 컴포넌트를 배치
		setLayout(new GridLayout(1, 2));
		add(btn); //1행 0열
		add(jbtn); //1행 1열
		
		//5. 윈도우 크기 설정
		setSize(400,200);
		
		//6.윈도우 컴포넌트를 사용자에게 보여주기
		setVisible(true);
	
		//윈도우 컴포넌트 종료
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//addWindowListener컴포넌트로도 종료가 되지만 위에 setDefaultCloseOperation로 한줄로 종료하는게 더 효율적이다.	
//        addWindowListener(new WindowAdapter() {
//        	
//        	@Override
//        	public void windowClosing(WindowEvent e) {
//        		dispose();
//        	}
//		}); //익명클래스는 WindowAdapter가 부모이다.
	}//UseSwing
	
	public static void main(String[] args) {
		new UseSwing();
	}//main
}//UseSwing
