package day1130;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentsListEvt implements ActionListener {

    private Students st;
    private final int NUM_1 = 1;
    private final int NUM_2 = 2;
    private final int NUM_3 = 3;
    private int cnt = 0;
    private JTextArea jta = new JTextArea(10,30);
    private JScrollPane jsp = new JScrollPane(jta);
    

    private List<String> stlist = new ArrayList<>();

    public StudentsListEvt(Students st){
        this.st = st;
        jta.append("�̸�" + "\n");
        jta.append("-----\n");    
    }//StudentsListEvt

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == st.getJtxSelect()){
        selectmenu();
        }//end if
    }//actionPerformed

    public void selectmenu(){

    	try {
        switch(Integer.parseInt(st.getJtxSelect().getText())){
            case NUM_1:
                            String StudentName = JOptionPane.showInputDialog("�̸��� �Է��ϼ���.");
                            stlist.add(StudentName);
                            jta.append(String.valueOf(stlist.get(cnt++)) + "\n");
                            break;
            case NUM_2:
                            JOptionPane.showMessageDialog(null,jsp);
                            break;

            case NUM_3:   int flag =  JOptionPane.showConfirmDialog(null,"���������Ͻðڽ��ϱ�?");
                            switch(flag){
                                case JOptionPane.OK_OPTION:
                                    System.out.println("�����մϴ�.");
                                    st.dispose();
                                    break;
//                                case JOptionPane.NO_OPTION:
//                                case JOptionPane.CANCEL_OPTION:
                            }//end switch
                            break;
        }//end switch
    	}catch(NumberFormatException nfe) {
    		System.out.println("1 2 3 �߿� �Է� ��Ź�帳�ϴ�.");
    	}

    }//selectmenu

}//StudentlistEvt
