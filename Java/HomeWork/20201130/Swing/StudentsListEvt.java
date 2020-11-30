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
        jta.append("이름" + "\n");
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
                            String StudentName = JOptionPane.showInputDialog("이름을 입력하세요.");
                            stlist.add(StudentName);
                            jta.append(String.valueOf(stlist.get(cnt++)) + "\n");
                            break;
            case NUM_2:
                            JOptionPane.showMessageDialog(null,jsp);
                            break;

            case NUM_3:   int flag =  JOptionPane.showConfirmDialog(null,"정말종료하시겠습니까?");
                            switch(flag){
                                case JOptionPane.OK_OPTION:
                                    System.out.println("감사합니다.");
                                    st.dispose();
                                    break;
//                                case JOptionPane.NO_OPTION:
//                                case JOptionPane.CANCEL_OPTION:
                            }//end switch
                            break;
        }//end switch
    	}catch(NumberFormatException nfe) {
    		System.out.println("1 2 3 중에 입력 부탁드립니다.");
    	}

    }//selectmenu

}//StudentlistEvt
