package day1126;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * JDialog�� �̺�Ʈ�� ó���ϱ����� Ŭ����
 * 
 * @author owner
 *
 */
public class ChildEvt extends WindowAdapter implements ActionListener {

	private UseChild uc;

	public ChildEvt(UseChild uc) {
		this.uc = uc;
	}// ChildEvt

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == uc.getJbtn()) {

			String lunch = JOptionPane.showInputDialog("���ɸ޴��� �����̾����ϱ�?");

			if (lunch != null && !lunch.equals("")) { 
				String[] menu = { "¥��", "«��", "������", "���", "������", "����", "���뱹��,������", "���,���,������", "���κ��,�����,��ġ�",
						"������,��������" };
				String[] type = { "�߽�", "�߲��� ����", "�н�", "�ѽ�", "���" };

				String tempType = lunch + "�� �˼� ���� �������� �Դϴ�.";
				for (int i = 0; i < menu.length; i++) {
					if (menu[i].contains(lunch)) {
						tempType = lunch +"��(��)" +type[i] + "�Դϴ�.";
						break;
					} // end if
				} // end for
				JOptionPane.showMessageDialog(uc, tempType);
			} // end if
		} // end if
	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
//		JDialog�� ���� ������ JFrame.EXIT_ON_CLOSE Constant�� ����� �� ����.
		uc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}// windowClosing

}// class
