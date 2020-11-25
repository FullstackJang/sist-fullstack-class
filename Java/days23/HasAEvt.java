package day1125;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/**
 * 디자인 클래스와 has a 관계의 이벤트처리 클래스 생성
 * @author owner
 */

//1. XxxListener를 구현.
public class HasAEvt implements ActionListener {

	//2. 디자인 클래스를 선언
	private EvtDesign ed;
	
	//생성자를 만들고 디자인 객체를 받는다.
	public HasAEvt(EvtDesign ed) { //Has-a 관계가 완성
		this.ed = ed;
	}//HasAEvt
	
	
	//4.추상method Override
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
		//이벤트를 JButton에서 발생했다면
		if(ae.getSource() == ed.getJbtn()) {
			// JLabel에 글자를 변경
			JLabel jlblOutputJabel = ed.getJlbl();
			
			//폰트 클래스를 생성
			Font font = new Font("Serif",Font.BOLD,30);
			//생성된 폰트를 Component에 적용
			jlblOutputJabel.setFont(font);
			
			Color c = new Color(0xDB9CFF); // 객체 생성해서 해도 됨
//			jlblOutputJabel.setForeground(Color.cyan); //Constant 전경색 설정
			jlblOutputJabel.setForeground(new Color(0xDB9CFF)); //Color클래스를 생성하여 전경색 설정
			ed.getJbtn().setForeground(new Color(0xDB9CFF));
	
			ed.getJtf().setBackground(Color.GRAY); //Constant로 배경색 설정. 투명도가 설정되지 않은 Component는 바로 적용됨
			
			jlblOutputJabel.setBackground(Color.BLUE);
			jlblOutputJabel.setOpaque(true); //투명도를 해제하여 설정된 색이 보이도록 설정 한다.
		}//end if
	}//actionPerformed
	
	
	
}//class
