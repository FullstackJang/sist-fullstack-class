package day1125;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class UseWindowAdapter extends JFrame {
	
	public UseWindowAdapter() {
		super("Adapter클래스를 사용하는 이유");
		
//		//has a 관계를 설정
//		EvtWindowHasA ewha = new EvtWindowHasA(this); //has a
//		
//		//윈도우 이벤트
//		addWindowListener(ewha);
		
		//종료처리는 코드가 매우 적기 때문에 외부 클래스로 만들 필요가 없다.
		//클래스를 만들지 않고 anonymous inner class로 작성
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setBounds(100,100,200,400);
		setVisible(true);
		
		
	}//UseWindowAdapter
	
	public static void main(String[] args) {
		new UseWindowAdapter();
	}//main
}//class
