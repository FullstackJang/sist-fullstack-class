package day1125;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/**
 * ������ Ŭ������ has a ������ �̺�Ʈó�� Ŭ���� ����
 * @author owner
 */

//1. XxxListener�� ����.
public class HasAEvt implements ActionListener {

	//2. ������ Ŭ������ ����
	private EvtDesign ed;
	
	//�����ڸ� ����� ������ ��ü�� �޴´�.
	public HasAEvt(EvtDesign ed) { //Has-a ���谡 �ϼ�
		this.ed = ed;
	}//HasAEvt
	
	
	//4.�߻�method Override
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
		//�̺�Ʈ�� JButton���� �߻��ߴٸ�
		if(ae.getSource() == ed.getJbtn()) {
			// JLabel�� ���ڸ� ����
			JLabel jlblOutputJabel = ed.getJlbl();
			
			//��Ʈ Ŭ������ ����
			Font font = new Font("Serif",Font.BOLD,30);
			//������ ��Ʈ�� Component�� ����
			jlblOutputJabel.setFont(font);
			
			Color c = new Color(0xDB9CFF); // ��ü �����ؼ� �ص� ��
//			jlblOutputJabel.setForeground(Color.cyan); //Constant ����� ����
			jlblOutputJabel.setForeground(new Color(0xDB9CFF)); //ColorŬ������ �����Ͽ� ����� ����
			ed.getJbtn().setForeground(new Color(0xDB9CFF));
	
			ed.getJtf().setBackground(Color.GRAY); //Constant�� ���� ����. ������ �������� ���� Component�� �ٷ� �����
			
			jlblOutputJabel.setBackground(Color.BLUE);
			jlblOutputJabel.setOpaque(true); //������ �����Ͽ� ������ ���� ���̵��� ���� �Ѵ�.
		}//end if
	}//actionPerformed
	
	
	
}//class
