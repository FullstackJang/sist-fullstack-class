package day1201;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Work1130 {

    public static final String INPUT_NAME = "1"; //이름 입력
    public static final String PRINT_NAME = "2"; //이름 출력
    public static final String CLOSE = "3"; //종료

    private List<String> nameList; //이름을 저장할 List


    public Work1130() {
        nameList = new ArrayList<>();

        //메뉴를 제공한다. (메뉴는 무조건 한번은 실행해야한다.)
        boolean exitFlag = false;
        BufferedReader br = null;

        try {
            do {
                System.out.println("메뉴) 1 이름입력 2. 이름출력 3. 종료");
                System.out.print("번호를 입력 :");
                String inputMenu = "";

                //시스템 입력(키보드 입력)을 받기위한 표준 입력 스트림 연결 : 16bit + 8bit
                br = new BufferedReader(new InputStreamReader(System.in));

                //입력값 받기
                inputMenu = br.readLine();

                if (!("".equals(inputMenu))) {
                    //입력받은 문자열 중 가장 첫글자만 비교하여 업무를 실행한다.
                    switch (inputMenu.substring(0, 1)) {

                        case INPUT_NAME:
                            inputName();
                            break;
                        case PRINT_NAME:
                            printName();
                            break;
                        case CLOSE:
                            exitFlag = close();
                            System.out.println("감사합니다.");
                            break;

                        default:
                            System.out.println("메뉴는 1,2,3중 하나만 입력!!");
                    }//switch
                }//end if

            } while (!exitFlag);
        } catch (IOException ie) {
            ie.printStackTrace();
            JOptionPane.showMessageDialog(null, "키보드에서 입력을 받을 수 없습니다.");
        }

    }//Work1130

    public void inputName() {
        String name = JOptionPane.showInputDialog("이름을 입력");

        if(name != null && !"".equals(name)){
            nameList.add(name);
        }//end if

    }//inputName

    public void printName() {
        JTextArea jtaNameDisplay =  new JTextArea(10,40);
        jtaNameDisplay.setEditable(false);// 편집 불가 상태로 설정
        JScrollPane jspNameDispaly = new JScrollPane(jtaNameDisplay); //has a
        jspNameDispaly.setBorder(new TitledBorder("이름 목록"));

        jtaNameDisplay.append("이 름\n");
        jtaNameDisplay.append("------\n");

        if(nameList.isEmpty()) {
            jtaNameDisplay.append("입력된 이름이 없습니다.");
        }//end if

//        for(int i =0; i < nameList.size(); i++){
//            jtaNameDisplay.append(nameList.get(i) + "\n");
//        }//end if

        //향상된 for : for(데이터형 변수명 : 배열명)
        for(String s : nameList){
            jtaNameDisplay.append(s + "\n");
        }

        JOptionPane.showMessageDialog(null,jspNameDispaly);

    }//PrintNames

    /**
     * 메뉴에서 3을 입력하면 사용자에게 종료여부를 묻고 do~while을 빠져 나간다.
     *
     * @return
     */
    public boolean close() {
        boolean flag = false;
        flag = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?") == JOptionPane.OK_OPTION;

//        switch(JOptionPane.showConfirmDialog(null,"정말 종료하시겠습니까?")) {
//            case JOptionPane.OK_OPTION:{
//                flag =true;
//            }
//        }

//        return JOptionPane.showConfirmDialog(null,"정말 종료하시겠습니까?") == JOptionPane.OK_OPTION; 이것도 가능
        return flag;
    }//Close

    public static void main(String[] args) {
        new Work1130();
    }//main
}//class
