package day1120;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Homework extends JFrame {

	public Homework() {
		super("�ڹ�-�޸���");
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu jmFile = new JMenu("����");
		JMenu jmTemplate = new JMenu("����");
		JMenu jminfo = new JMenu("����");


		JMenuItem jminew = new JMenuItem("����");
		JMenuItem jmiOpen = new JMenuItem("����");
		JMenuItem jmisave = new JMenuItem("����");
		JMenuItem jminewsave = new JMenuItem("���̸����� ����");
		JMenuItem jmiclose = new JMenuItem("�ݱ�");
		
		//--����
		JMenuItem jmifont = new JMenuItem("�۲�");
		JMenuItem jmiauto = new JMenuItem("�ڵ� �ٹٲ�");
		
		//--����
		JMenuItem jmiinfo = new JMenuItem("�޸�������");

		
		//��ü�۾���â
		JTextArea jtx = new JTextArea();
		
		jmFile.add(jminew);
		jmFile.addSeparator(); 
		jmFile.add(jmiOpen);
		jmFile.add(jmisave);
		jmFile.add(jminewsave);
		jmFile.addSeparator(); 
		jmFile.add(jmiclose);
		
		jmTemplate.add(jmifont);
		jmTemplate.addSeparator(); 
		jmTemplate.add(jmiauto);
		
		jminfo.add(jmiinfo);
		
		jmb.add(jmFile);
		jmb.add(jmTemplate);
		jmb.add(jminfo);
		
		setJMenuBar(jmb);
				
		add(jtx);
		
		setBounds(100,200,700,400);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}//Homework
	
	public static void main(String[] args) {
		new Homework();
	}//main
}//class
