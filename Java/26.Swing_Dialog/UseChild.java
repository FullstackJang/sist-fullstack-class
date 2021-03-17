package day1126;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * 메인창에서 사용하는 부가적인 기능을 구현하는 창
 * 
 * @author owner
 *
 */
@SuppressWarnings("serial")
public class UseChild extends JDialog {

	private JButton jbtn;
	private JLabel jlbl;

	public UseChild(UseParent up) {
		super(up, "JDialog 부가적인 기능", true);

		jbtn = new JButton("버튼");
		jlbl = new JLabel("JDialog는 부모 창에서 필요한 부가적인 기능을 구현한다.");

		jlbl.setBorder(new TitledBorder("메시지"));

		// 이벤트 처리객체 생성하고 has A 관계설정.
		ChildEvt ce = new ChildEvt(this);
		jbtn.addActionListener(ce);
		addWindowListener(ce);

		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtn);

		add("Center", jlbl);
		add("South", jpSouth);

		// Dialog 좌표의 시작점은 부모창의 좌상단이 되어야한다.
		// getX() 윈도우의 x좌표, getY() 윈도우의 y좌표
		setBounds(up.getX() + 300, up.getY() + 130, 300, 300);

		setVisible(true);

	}// UseChild

	public JButton getJbtn() {
		return jbtn;
	}// getJbtn

	public JLabel getJlbl() {
		return jlbl;
	}// getJlbl

}
