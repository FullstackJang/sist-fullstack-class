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
		super("파일다이얼로그");
		jbtnFileopen = new JButton("파일 열기");
		jbtnFileSave = new JButton("파일 저장");
		jtaFileList = new TextArea();
		
		JScrollPane jspCenter = new JScrollPane(jtaFileList);
		jspCenter.setBorder(new TitledBorder("파일리스트"));
		
		
		JPanel jpNorth = new JPanel();
		jpNorth.setBorder(new TitledBorder("다이얼로그 선택"));
		jpNorth.add(jbtnFileopen);
		jpNorth.add(jbtnFileSave);
		
		//이벤트처리객체를 생성하고 : has a
		FileDialogEvt fde = new FileDialogEvt(this);
		
		//컴포넌트에서 발생하는 이벤트를 처리할 수 있도록 이벤트에 등록
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
