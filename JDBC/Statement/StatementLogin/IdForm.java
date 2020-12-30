package day1230.StatementLogin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class IdForm extends JFrame {

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JLabel jlOutput;

	private IdForm idFrm;

	public IdForm() {
		super("로그인");
		idFrm = this;
		jtfId = new JTextField();
		jpfPass = new JPasswordField();
		jlOutput = new JLabel("출력창");

		jtfId.setBorder(new TitledBorder("아이디"));
		jpfPass.setBorder(new TitledBorder("비밀번호"));
		jlOutput.setBorder(new TitledBorder("출력창"));

		setLayout(new GridLayout(3, 1));

		add(jtfId);
		add(jpfPass);
		add(jlOutput);

		// Inner class로 이벤트 처리
		IdForm.Evtinner ei = this.new Evtinner();
		jtfId.addActionListener(ei);
		jpfPass.addActionListener(ei);

		setBounds(100, 100, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// IdForm

	////////////////////// Event 처리 inner class /////////////////////////

	public class Evtinner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {

			if(ae.getSource() == jtfId) {
				idNull();
			}//end if
			
			if(ae.getSource() == jpfPass) {
				passNull();
			}//end if
			
		}// actionPerformed

	}// class

	public void idNull() {

		if ("".equals(jtfId.getText().trim())) {
			JOptionPane.showMessageDialog(idFrm, "아이디는 필수 입력!!");
			jtfId.requestFocus();
			return;
		} // end if

		jpfPass.requestFocus();
	}// idNull

	public void passNull() {
		if ("".equals(new String(jpfPass.getPassword()).trim())) {
			JOptionPane.showMessageDialog(idFrm, "비밀번호는는 필수 입력!!");
			jpfPass.requestFocus();
			return;
		} // end if
		login();
	} // passNull

	public void login() {
		String id = jtfId.getText().trim();
		String pass = new String(jpfPass.getPassword()).trim();
		
		LoginDAO lDAO = LoginDAO.getInstance();
		try {
			String name = lDAO.login(id, pass);
			
			if("".equals(name)) {
				JOptionPane.showMessageDialog(idFrm,"아이디나 비밀번호를 확인");
			}else {
				jlOutput.setText(name + "님 로그인 하셨습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		
	}//login
	
	
	////////////////////// Event 처리 inner class /////////////////////////

	public static void main(String[] args) {
		new IdForm();
	}// main

}// class
