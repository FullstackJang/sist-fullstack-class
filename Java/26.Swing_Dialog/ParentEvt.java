package day1126;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * UseParent의 이벤트를 처리하는 클래스
 * UseParent와 ParentEvt는 has a 관계
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
		// 버튼이 눌려지면 JDialog를 생성한다.

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
