package day1126;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * UseParent�� �̺�Ʈ�� ó���ϴ� Ŭ����
 * UseParent�� ParentEvt�� has a ����
 * @author owner
 *
 */
public class ParentEvt extends WindowAdapter implements ActionListener {

	private UseParent up;

	public ParentEvt(UseParent up) {
		this.up = up;
	}// ParentEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		// ��ư�� �������� JDialog�� �����Ѵ�.

		if (ae.getSource() == up.getJbtn()) {
			createDialog();
		} // end if
	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		up.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// windowClosing

	private void createDialog() {
		new UseChild(up);
	}// createDialog

}// class
