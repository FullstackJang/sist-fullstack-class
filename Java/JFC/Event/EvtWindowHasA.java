package day1125;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

/**
 * WindowListner를 구현하면 7개의 추상 method를 Override해야함
 * WindowAdapter를 구현하면 필요한 method 하나만 Override하면 됨
 * @author owner
 *
 */
public class EvtWindowHasA extends WindowAdapter /*implements WindowListener*/{

	//has a
	private UseWindowAdapter uwa;

	public EvtWindowHasA(UseWindowAdapter uwa) {
		this.uwa = uwa;
	}

	@Override
	public void windowClosing(WindowEvent e) {
			uwa.dispose();
	}
	
//	@Override
//	public void windowOpened(WindowEvent e) {
//		
//	}
//
//	@Override
//	public void windowClosing(WindowEvent e) {
//		
//		int closeflag = JOptionPane.showConfirmDialog(uwa,"종료하시겠습니까?");
//		
//		switch(closeflag) {
//			case JOptionPane.OK_OPTION : uwa.dispose();
//		}//end switch
//	}//windowClosing
//
//	@Override
//	public void windowClosed(WindowEvent e) {
//		
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//		
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//		
//	}
//
//	@Override
//	public void windowActivated(WindowEvent e) {
//		
//	}
//
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//		
//	}

	
	
}
