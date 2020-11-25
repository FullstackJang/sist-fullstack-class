package day1125;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Homework extends JFrame {
	
	//이벤트가 발생했을 때 처리뙬 Component를 선언
			private JTextField jtxID;
			private JPasswordField jtxPW;
			private JTextField jtxPrint;

	// default constructor정의, Component를 생성
	public Homework() {
		super();
		
		//컴포넌트 생성
		//아이디
		jtxID = new JTextField();
		TitledBorder tb = new TitledBorder("아이디");
		jtxID.setBorder(tb);
		//비밀번호
		jtxPW = new JPasswordField();
		TitledBorder tb1 = new TitledBorder("비밀번호");
		jtxPW.setBorder(tb1);
		//출력
		jtxPrint = new JTextField();
		TitledBorder tb2 = new TitledBorder("출력");
		jtxPrint.setBorder(tb2);

		//has-a
		HomeworkHasA hwha = new HomeworkHasA(this);
		
		jtxID.addActionListener(hwha);
		jtxPW.addActionListener(hwha);
		jtxPrint.addActionListener(hwha);
		
		setLayout(null);
		
		//아이디
		jtxID.setBounds(10,10,450,50);
		
		//비밀번호
		jtxPW.setBounds(10,80,450,50);
		
		//출력
		jtxPrint.setBounds(10,160,450,50);

		add(jtxID);
		add(jtxPW);
		add(jtxPrint);
		
		setBounds(100,100,500,280);
		
		setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//Homework

	
	public JTextField jtxID() {
		return jtxID;
	}

	public JTextField getJtxID() {
		return jtxID;
	}


	public JPasswordField getJtxPW() {
		return jtxPW;
	}


	public JTextField getJtxPrint() {
		return jtxPrint;
	}


	public static void main(String[] args) {
		new Homework();
	}
}
