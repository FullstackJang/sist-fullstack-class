package day1125;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * ActionEvent를 ActionListener로 처리
 * @author owner
 *
 */

//1. 윈도우 컴포넌트를 상속, XxxListener구현
@SuppressWarnings("serial")
public class UseActionEvent extends JFrame implements ActionListener{
	
	//2. 이벤트가 발생했을 때 처리뙬 Component를 선언
	private JButton jbtn;
	
	
	//2. default constructor정의, Component를 생성
	public UseActionEvent() {
		super("ActionEvent 처리");
	
		//3. Component를 생성
		jbtn = new JButton("Swing 버튼");
		
		//4. Component를 이벤트에 등록 addXxxListener
		jbtn.addActionListener(this); //is a 관계로 이벤트를 처리하는 구조이므로 내 객체안에서 이벤트를 처리할 것이다.
		// 이벤트를 처리하고자 할 때 this를 넣어준다.
		
		//4. 배치(Component를 붙임)
		add("Center",jbtn); //1행 1열
		
		//5. 윈도우 크기 설정
		setSize(400,200);
		
		//6.윈도우 컴포넌트를 사용자에게 보여주기
		setVisible(true);
	
		//7. 윈도우 컴포넌트 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseSwing
	
	//8. 추상 method Override
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//ConfirmDialog
//		int flag = JOptionPane.showConfirmDialog(this, "창을 닫으시겠습니다.");
//		
//		switch(flag) {
//		case JOptionPane.OK_OPTION:
//			dispose();
//			break;
//			
//		case JOptionPane.NO_OPTION :
//			System.out.println("아니오");
//			break;
//		case JOptionPane.CANCEL_OPTION :
//			System.out.println("취소");
//		}//end switch
//	
		
		//MessageDialog
//		JOptionPane.showMessageDialog(this, "오늘은 수요일.");
		
		//InputDialog
//		String msg = JOptionPane.showInputDialog("하고싶은 말 입력");
//		System.out.println(msg);
		
		JOptionPane.showMessageDialog(this, "버튼이 클릭되었습니다.");
	}
	
	public static void main(String[] args) {
		new UseActionEvent();
	}//main

}//UseSwing
