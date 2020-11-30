package day1130;

import javax.swing.*;
import java.awt.*;

//1. 윈도우 컴포넌트 상속
@SuppressWarnings("serial")
public class Students extends JFrame {
    
    //2.컴포넌트 객체 선언
    private JLabel jlblMenu;
    private JLabel jlblName;
    private JLabel jlblOutput;
    private JLabel jlblClose;

    private JTextField jtxSelect;

    public Students() {

        //3.컴포넌트 객체 생성
        //JLabel
        jlblMenu = new JLabel("메뉴:");
        jlblName = new JLabel("1.이름 입력");
        jlblOutput = new JLabel("2.출력");
        jlblClose = new JLabel("3.종료");

        //JTextField
        jtxSelect = new JTextField(10);

        //4. 배치관리자 설정
        setLayout(null); //기존의 설정된 배치관리자인 BorderLayout이 사라짐
        
        //5. 컴포넌트의 위치와 폰트 크기 설정
        jlblMenu.setBounds(50,50,100,20); //메뉴 라벨
        jlblMenu.setFont(new Font("Serif", Font.BOLD, 15)); //메뉴 폰트
        
        jlblName.setBounds(100,50,100,20); //이름 라벨
        jlblName.setFont(new Font("Serif", Font.BOLD, 15)); //이름 폰트

        jlblOutput.setBounds(200,50,100,20); //출력 라벨
        jlblOutput.setFont(new Font("Serif", Font.BOLD, 15)); //출력 폰트
        
        jlblClose.setBounds(250,50,100,20); //종료 라벨
        jlblClose.setFont(new Font("Serif", Font.BOLD, 15)); //종료 폰트
        
        jtxSelect.setBounds(50,80,250,30); //텍스트필드


        //6. 컴포넌트 배치
        add(jlblMenu);
        add(jlblName);
        add(jlblOutput);
        add(jlblClose);
        add(jtxSelect);

        // StudentsListEvt class와 has a 관계
        StudentsListEvt sle = new StudentsListEvt(this);

        jtxSelect.addActionListener(sle);

        // 윈도우 크기 보여지는 위치 설정
        setBounds(800,350,400,200);

        //윈도우 크기 조절 막기 (최대화 안됨)
//        setResizable(false);

        // 사용자에게 보여주기
        setVisible(true);

        //종료
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//Homework

    public JTextField getJtxSelect() {
        return jtxSelect;
    }//getJtxSelect

    public static void main(String[] args) {
        new Students();
    }//main
}//class