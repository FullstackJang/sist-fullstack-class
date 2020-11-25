package day1125;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class HomeworkHasA implements ActionListener{

    private Homework h;

    public HomeworkHasA(Homework h) {
        this.h = h;
    }//HomeworkHasA


    @Override
    public void actionPerformed(ActionEvent e) {

        JTextField idstr = h.getJtxID();
        JPasswordField pwstr = h.getJtxPW();
        JTextField printstr = h.getJtxPrint();

        String idstr1 = idstr.getText();
        char[] pwstr1 = pwstr.getPassword();
        String pw = String.valueOf(pwstr1);

        if(!(idstr1.isEmpty())) { //문자열이 비어있지 않으면
            pwstr.requestFocus();
        }
        else {
            idstr.requestFocus();
            JOptionPane.showMessageDialog(h, "아이디 필수 입력");
        }

        if(pw.isEmpty()) {
            pwstr.requestFocus();
            JOptionPane.showMessageDialog(h, "비밀번호 필수 입력");
        }

        Font font = new Font("Serif",Font.BOLD,25);
        if((!(idstr1.isEmpty())) && (!(pw.isEmpty()))) {
            printstr.setFont(font);

            printstr.setText(idstr1 + " " + pw);

        }
    }
}
