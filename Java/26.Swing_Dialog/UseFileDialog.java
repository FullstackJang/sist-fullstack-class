package day1126;

import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseFileDialog extends JFrame {
	private JButton jbtnFileopen,jbtnFileSave;
	private TextArea jtaFileList;
	
	public UseFileDialog() {
		super("���ϴ��̾�α�");
		jbtnFileopen = new JButton("���� ����");
		jbtnFileSave = new JButton("���� ����");
		jtaFileList = new TextArea();
		
		JScrollPane jspCenter = new JScrollPane(jtaFileList);
		jspCenter.setBorder(new TitledBorder("���ϸ���Ʈ"));
		
		
		JPanel jpNorth = new JPanel();
		jpNorth.setBorder(new TitledBorder("���̾�α� ����"));
		jpNorth.add(jbtnFileopen);
		jpNorth.add(jbtnFileSave);
		
		//�̺�Ʈó����ü�� �����ϰ� : has a
		FileDialogEvt fde = new FileDialogEvt(this);
		
		//������Ʈ���� �߻��ϴ� �̺�Ʈ�� ó���� �� �ֵ��� �̺�Ʈ�� ���
		jbtnFileopen.addActionListener(fde); //ActionEvent
		jbtnFileSave.addActionListener(fde); //ActionEvent
		addWindowListener(fde); //WindowEvent
		 
		
		add("North",jpNorth);
		add("Center",jspCenter);
		
		
		setBounds(100,100,500,600);
		
		setVisible(true);
		
	}//UseFileDialog
	
	
	public JButton getJbtnFileopen() {
		return jbtnFileopen;
	}//getJbtnFileopen


	public JButton getJbtnFileSave() {
		return jbtnFileSave;
	}//getJbtnFileSave


	public TextArea getJtaFileList() {
		return jtaFileList;
	}//getJtaFileList


	public static void main(String[] args) {
			new UseFileDialog();
	}//main
}//class
