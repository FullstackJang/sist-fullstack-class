package day1120;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class UseMenu extends JFrame {
	
	public UseMenu() {
		super("a");
		
		//1.메뉴바 생성
		JMenuBar jmb = new JMenuBar();
		
		//------------
		
		//2.Menu생성
		JMenu jmFile = new JMenu("파일");
		JMenu jmEdit = new JMenu("편집");
		
		//------------
		
		//3. MenuItem생성
		//파일메뉴에 배치될 MenuItem 생성
		JMenuItem jmiOpen = new JMenuItem("열기");
		JMenuItem jmiSave = new JMenuItem("저장");
		JMenuItem jmiEnd = new JMenuItem("종료");

		//편집메뉴에 배치될 MenuItem생성
		JMenuItem jmiCopy = new JMenuItem("복사");
		JMenuItem jmiCut = new JMenuItem("자르기");
		JMenuItem jmiPaste = new JMenuItem("붙이기");
		
		//------------

		//4. MenuItem을 Menu 배치
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		jmFile.addSeparator(); //메뉴에 구분선 설정
		jmFile.add(jmiEnd);
		
		
		jmEdit.add(jmiCut);
		jmEdit.add(jmiCopy);
		jmEdit.add(jmiPaste);
		
		
		//5. 메뉴를 MenuBar에 배치
		jmb.add(jmFile);
		jmb.add(jmEdit);
		
		//6. 메뉴바를 윈도우 컴포넌트에 배치
		setJMenuBar(jmb);
		
		//7. 윈도우 크기 설정
		setBounds(100,200,400,600);
		
		//8.윈도우를 사용자에게 보여주기(가시화)
		setVisible(true);
		
		//9.종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseMenu
	
	public static void main(String[] args) {
		new UseMenu();
	}//main
}//class
