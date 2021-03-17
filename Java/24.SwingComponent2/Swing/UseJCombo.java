package day1120;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * JComboBox => java.awt���� Choice ��ü�� ����� �� ����
 * 
 * JComboBox�� MVC�������� ��������Ű�
 * Choice�� MVc������ �ƴϴ�.
 * @author owner
 *
 */
@SuppressWarnings("serial")
public class UseJCombo extends JFrame {

	public UseJCombo() {
			super("");
			
			//3. ������Ʈ�� ����
			JLabel jlblEmail = new JLabel("�̸���");
			JTextField jtfEmail = new JTextField(15);
			JLabel jlblEmailAt = new JLabel("@");
			
			//Model��ü ����
			
			String[] tempDomain = {"gmail.com","daum.net","naver.com","nate.com"};
			
			DefaultComboBoxModel<String> dcbmDomain = new DefaultComboBoxModel<String>(tempDomain);
			
			//Model�� �����͸� �߰��� �߰��غ���.
			dcbmDomain.addElement("hotmail.com");
			
			//View��ü �����ϰ�, Model��ü�� ���踦 ����
			JComboBox<String> jcbDomain = new JComboBox<String>(dcbmDomain);
			
			//4. ��ġ�����ڸ� ���� 
			setLayout(new FlowLayout()); //BorderLayout => FlowLayout���� ����
			
			
			add(jlblEmail);
			add(jtfEmail);
			add(jlblEmailAt);
			add(jcbDomain);
			
			
			
			//5. ũ�⼳��
			setBounds(200,100,400,100);
			
			
			//6. ����ȭ
			setVisible(true);

			//7. ����
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
	}//UseJCombo
	
	public static void main(String[] args) {
		new UseJCombo();
	}//main
}//class
