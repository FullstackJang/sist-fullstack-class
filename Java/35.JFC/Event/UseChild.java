package day1126;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * ����â���� ����ϴ� �ΰ����� ����� �����ϴ� â
 * 
 * @author owner
 *
 */
@SuppressWarnings("serial")
public class UseChild extends JDialog {

	private JButton jbtn;
	private JLabel jlbl;

	public UseChild(UseParent up) {
		super(up, "JDialog �ΰ����� ���", true);

		jbtn = new JButton("��ư");
		jlbl = new JLabel("JDialog�� �θ� â���� �ʿ��� �ΰ����� ����� �����Ѵ�.");

		jlbl.setBorder(new TitledBorder("�޽���"));

		// �̺�Ʈ ó����ü �����ϰ� has A ���輳��.
		ChildEvt ce = new ChildEvt(this);
		jbtn.addActionListener(ce);
		addWindowListener(ce);

		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtn);

		add("Center", jlbl);
		add("South", jpSouth);

		// Dialog ��ǥ�� �������� �θ�â�� �»���� �Ǿ���Ѵ�.
		// getX() �������� x��ǥ, getY() �������� y��ǥ
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
