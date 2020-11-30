package day1130;

import javax.swing.*;
import java.awt.*;

//1. ������ ������Ʈ ���
@SuppressWarnings("serial")
public class Students extends JFrame {
    
    //2.������Ʈ ��ü ����
    private JLabel jlblMenu;
    private JLabel jlblName;
    private JLabel jlblOutput;
    private JLabel jlblClose;

    private JTextField jtxSelect;

    public Students() {

        //3.������Ʈ ��ü ����
        //JLabel
        jlblMenu = new JLabel("�޴�:");
        jlblName = new JLabel("1.�̸� �Է�");
        jlblOutput = new JLabel("2.���");
        jlblClose = new JLabel("3.����");

        //JTextField
        jtxSelect = new JTextField(10);

        //4. ��ġ������ ����
        setLayout(null); //������ ������ ��ġ�������� BorderLayout�� �����
        
        //5. ������Ʈ�� ��ġ�� ��Ʈ ũ�� ����
        jlblMenu.setBounds(50,50,100,20); //�޴� ��
        jlblMenu.setFont(new Font("Serif", Font.BOLD, 15)); //�޴� ��Ʈ
        
        jlblName.setBounds(100,50,100,20); //�̸� ��
        jlblName.setFont(new Font("Serif", Font.BOLD, 15)); //�̸� ��Ʈ

        jlblOutput.setBounds(200,50,100,20); //��� ��
        jlblOutput.setFont(new Font("Serif", Font.BOLD, 15)); //��� ��Ʈ
        
        jlblClose.setBounds(250,50,100,20); //���� ��
        jlblClose.setFont(new Font("Serif", Font.BOLD, 15)); //���� ��Ʈ
        
        jtxSelect.setBounds(50,80,250,30); //�ؽ�Ʈ�ʵ�


        //6. ������Ʈ ��ġ
        add(jlblMenu);
        add(jlblName);
        add(jlblOutput);
        add(jlblClose);
        add(jtxSelect);

        // StudentsListEvt class�� has a ����
        StudentsListEvt sle = new StudentsListEvt(this);

        jtxSelect.addActionListener(sle);

        // ������ ũ�� �������� ��ġ ����
        setBounds(800,350,400,200);

        //������ ũ�� ���� ���� (�ִ�ȭ �ȵ�)
//        setResizable(false);

        // ����ڿ��� �����ֱ�
        setVisible(true);

        //����
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//Homework

    public JTextField getJtxSelect() {
        return jtxSelect;
    }//getJtxSelect

    public static void main(String[] args) {
        new Students();
    }//main
}//class