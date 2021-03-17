package day1125;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * ActionEvent를 ActionListener로 처리
 * @author owner
 *
 */

//1. 윈도우 컴포넌트를 생성
@SuppressWarnings("serial")
public class EvtDesign extends JFrame {
	
	//2. 이벤트가 발생했을 때 처리뙬 Component를 선언
	private JButton jbtn;
	private JLabel jlbl;
	private JTextField jtf;
	
	//2. default constructor정의, Component를 생성
	public EvtDesign() {
		super("ActionEvent 처리");
	
		//3. Component를 생성
		jlbl = new JLabel("출력JLabel");
		jbtn = new JButton("Swing 버튼");
		jtf=new JTextField();
		//4. 이벤트처리 객체와 has a 관계로 설정하고, 
		HasAEvt hasA = new HasAEvt(this);
		//이벤트 처리객체에서 이벤트를 처리할 수 있도록 등록 addXxxListener
		
		jbtn.addActionListener(hasA); //is a 관계로 이벤트를 처리하는 구조이므로 내 객체안에서 이벤트를 처리할 것이다.
		
		//4. 배치(Component를 붙임)
		add("Center",jbtn); //1행 1열
		add("North",jlbl);
		add("South",jtf);
		//5. 윈도우 크기 설정
		setSize(400,200);
		
		//6.윈도우 컴포넌트를 사용자에게 보여주기
		setVisible(true);
	
		//7. 윈도우 컴포넌트 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseSwing
	

	//8. 이벤트 처리클래스에서 Component를 사용할 수 있도록 getter method를 작성
	public JButton getJbtn() {
		return jbtn;
	}//getJbtn


	public JLabel getJlbl() {
		return jlbl;
	}//getJlbl

	
	
	public JTextField getJtf() {
		return jtf;
	}//JTextField


	public static void main(String[] args) {
		new EvtDesign();
	}//main

}//UseSwing
