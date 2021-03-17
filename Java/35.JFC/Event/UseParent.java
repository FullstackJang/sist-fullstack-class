package day1126;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 주 기능을 가지고 있는 메인 창(부모 창)
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseParent extends JFrame {

	private JButton jbtn;

	public UseParent() {
		super("부모 창");

		jbtn = new JButton("부가적인 기능 사용");

		// 이벤트 객체 생성 관계설정
		ParentEvt pe = new ParentEvt(this);

		// 컴포넌트에서 이벤트를 발생시키고 이벤트를 처리할 곳 기술
		jbtn.addActionListener(pe);
		addWindowListener(pe);

		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtn);

		add("South", jpSouth);

		setBounds(100, 100, 1000, 700);

		setVisible(true);

	}// UseParent

	public JButton getJbtn() {
		return jbtn;
	}

	public static void main(String[] args) {
		new UseParent();
	}// main

}// class
