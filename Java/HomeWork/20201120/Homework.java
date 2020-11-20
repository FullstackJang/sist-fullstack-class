package day1120;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Homework extends JFrame {

	public Homework() {
		super("자바-메모장");
		
		JMenuBar jmb = new JMenuBar();
		
		JMenu jmFile = new JMenu("파일");
		JMenu jmTemplate = new JMenu("서식");
		JMenu jminfo = new JMenu("도움말");


		JMenuItem jminew = new JMenuItem("새글");
		JMenuItem jmiOpen = new JMenuItem("열기");
		JMenuItem jmisave = new JMenuItem("저장");
		JMenuItem jminewsave = new JMenuItem("새이름으로 저장");
		JMenuItem jmiclose = new JMenuItem("닫기");
		
		//--서식
		JMenuItem jmifont = new JMenuItem("글꼴");
		JMenuItem jmiauto = new JMenuItem("자동 줄바꿈");
		
		//--도움말
		JMenuItem jmiinfo = new JMenuItem("메모장정보");

		
		//전체글쓰기창
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
