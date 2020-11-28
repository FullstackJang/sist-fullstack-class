package day1126;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * JDialog의 이벤트를 처리하기위한 클래스
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

			String lunch = JOptionPane.showInputDialog("점심메뉴는 무엇이었습니까?");

			if (lunch != null && !lunch.equals("")) { 
				String[] menu = { "짜장", "짬뽕", "볶음밥", "울면", "설렁탕", "곰탕", "순대국밥,감자탕", "김밥,라면,떡볶이", "순두부찌개,된장찌개,김치찌개",
						"돈가츠,히레가츠" };
				String[] type = { "중식", "뜨끈한 국밥", "분식", "한식", "양식" };

				String tempType = lunch + "는 알수 없는 음식종류 입니다.";
				for (int i = 0; i < menu.length; i++) {
					if (menu[i].contains(lunch)) {
						tempType = lunch +"은(는)" +type[i] + "입니다.";
						break;
					} // end if
				} // end for
				JOptionPane.showMessageDialog(uc, tempType);
			} // end if
		} // end if
	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
//		JDialog를 닫을 때에는 JFrame.EXIT_ON_CLOSE Constant를 사용할 수 없다.
		uc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}// windowClosing

}// class
