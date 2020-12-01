package day1201;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 버튼을 클릭하면 FileDialog를 제공하고, FileDialog에서 파일을 선택하면, 선택한 파일의 내용을
 * JTextArea에 출력
 */
@SuppressWarnings("serial")
public class TxtFileRead extends JFrame implements ActionListener {

    private JButton jbtnFileOpen;
    private JTextArea jtaNote;

    public TxtFileRead() {
        super("text파일 뷰어");

        jbtnFileOpen = new JButton("파일선택");
        jtaNote = new JTextArea();

        JScrollPane jspNote = new JScrollPane(jtaNote);
        jspNote.setBorder(new TitledBorder("문서파일의 내용"));

        JPanel jpNorth = new JPanel();
        jpNorth.add(jbtnFileOpen);

        //이벤트 등록
        jbtnFileOpen.addActionListener(this);

        add("North", jbtnFileOpen);
        add("Center", jspNote);

        setBounds(100, 100, 500, 500);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }//TxtFileRead

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbtnFileOpen) {
            fileOpen();
        }//end if

    }//actionPerformed

    private void fileOpen() {
        FileDialog fdOpen = new FileDialog(this, "파일선택", FileDialog.LOAD);
        fdOpen.setVisible(true);

        String path = fdOpen.getDirectory();
        String name = fdOpen.getFile();

        if (path != null) { //파일 선택하고 열기를 누른경우
            //확장자가 java일때만 파일을 열어서 보여주기
            if (name.endsWith("java")) {
                //선택한 파일의 경로와 파일명으로 파일 클래스를 생성
                File file = new File(path + name);

                if (file.exists()) { //파일이 존재하면
                    //스트림을 사용하여 선택한 파일에 연결하고,
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

                        jtaNote.setText(""); //JTextArea 내용 초기화
                        // 파일의 내용을 읽어 들여
                        String temp = "";
                        while ((temp = br.readLine()) != null) {
                            jtaNote.append(temp + "\n"); //append는 줄바꿈 기능이없다.
                        }//end while
                        // JTextArea에 출력
                        //스트림을 사용했으면 스트림을 닫는다.
                        br.close();

                    } catch (IOException ie) {
                        JOptionPane.showMessageDialog(this, "작업중 불편을 드려 죄송합니다.");
                        ie.printStackTrace();
                    }//end catch


                }//end if
            }//end if
        }//end if

    }//fileOpen

    public static void main(String[] args) {
        new TxtFileRead();
    }//main
}//class
