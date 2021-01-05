package day1230;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")

//1. Window Component�� JFrame ��ӹޱ�
public class ZipcodeSearch extends JFrame {

	private JButton jbtnInput;
	private JTextArea jtaZipcodeDisplay;
	private JScrollPane jspZipcodeScroll;
	private JTextField jtfDong;

	// 2. ������ �ۼ�
	public ZipcodeSearch() {
		super("�����ȣ �˻�");

		// 3. ������Ʈ�� ����
		// jlb=jlabel + Name => ������Ʈ���� + �ϴ��Ϸ� �̸��� �����ϴ� ���� �밡���� �����̶�� �Ѵ�.
		JLabel jlblZipcode = new JLabel("�����ȣ");
		jtfDong = new JTextField(20);
		jbtnInput = new JButton("�Է�");
		jtaZipcodeDisplay = new JTextArea();
		jspZipcodeScroll = new JScrollPane(jtaZipcodeDisplay);

		// 4. ��ġ������ ����
//		setLayout(new BorderLayout());//BorderLayout�� �ϳ��� ������ �ϳ��� ������Ʈ�� ��ġ�� �� �ִ�.

		// ���ʿ��� �������� ������Ʈ�� �ѹ��� ��ġ�Ǿ���ϹǷ� Container Component�� JPanel�� �ʿ��ϴ�.

		JPanel jpNorth = new JPanel(); // FlowLayout
		// �����̳� ������Ʈ�� ���̾ƿ� ����
		jpNorth.setLayout(new FlowLayout());

		// �Ϲ� ������Ʈ�� �����̳� ������Ʈ�� ��ġ
		jpNorth.add(jlblZipcode);
		jpNorth.add(jtfDong);
		jpNorth.add(jbtnInput);

		// 5. Component��ġ
		// BorderLayout�� �ϳ��� ������ �ϳ��� ������Ʈ�� ��ġ�� �� �ִ�.
		add("North", jpNorth);
		add("North", jpNorth);
		add("North", jpNorth); // jlblName��jtfName�� �������°� �ƴ϶� jbtnInput�ؿ� �򸰴�.
		add("Center", jspZipcodeScroll);

		//inner class�� �̺�Ʈ ó�� (����� HAS a)
		//inner class�� ���� HAS A�̴�.
		
		InnerEvt ie = this.new InnerEvt();
					 //�ٱ�Ŭ������.new ��ü��();
		jbtnInput.addActionListener(ie);
		jtfDong.addActionListener(ie);
		
		// 6.������ ������Ʈ�� JFrameũ�⼳��
		setLocation(500, 100);
		setSize(400, 300);

		// 7. ������ ������Ʈ�� JFrame�� ����ڿ��� �����ֱ�
		setVisible(true);

		// 8. ������ ������Ʈ�� ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// UseLayOutManager

	/////////////////////// inner class�� �̺�Ʈ ó�� �ڵ� ���� /////////////////////////////
	
	public class InnerEvt implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String dong = jtfDong.getText().trim();
			if(!"".equals(dong)) {
				setZipcode(dong);
				jtfDong.setText("");
			}//end if
		
		}//actionPerformed
		
		public void setZipcode(String dong) {

		ZipcodeDAO zDAO = ZipcodeDAO.getInsctance();
		try {
			List<ZipcodeVO> listZipcode = zDAO.selectZipcode(dong);//PreparedStatement
//			List<ZipcodeVO> listZipcode = zDAO.selectStatementZipcode(dong);//Statement
			
			StringBuilder sbOutput = new StringBuilder();
			
			sbOutput.append("[").append(dong).append("] ���� �˻��� ��� \n");
			sbOutput.append("==============================================\n");
			sbOutput.append("�����ȣ\t�ּ�\n");
			if(listZipcode.isEmpty()) {
				sbOutput.append("�Է��Ͻ� ���� �������� �ʽ��ϴ�.\n ���̸��� Ȯ���ϼ���.");
			}//end if
			
			for(ZipcodeVO zVO : listZipcode) {
				sbOutput.append(zVO.getZipcode()).append("\t")
				.append(zVO.getSido()).append(" ")
				.append(zVO.getGugun()).append(" ")
				.append(zVO.getDong()).append(" ")
				.append(zVO.getBunji()).append("\n");
				
			}//end for
			
			jtaZipcodeDisplay.setText(sbOutput.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		}//setZipcode
		
	}//class
	/////////////////////// inner class�� �̺�Ʈ ó�� �ڵ� ���� /////////////////////////////
	
	public static void main(String[] args) {

		new ZipcodeSearch();

	}// main
}// class