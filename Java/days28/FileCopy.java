package day1202;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 버튼을 클릭하면 FileDialog를 제공하고, FileDialog에서 파일을 선택하면, 선택한 파일의 내용을 복사한 후 결과를 JTextArea에 출력
 */

public class FileCopy extends JFrame implements ActionListener {

    private static final long serialVersionUID = -5244321997258661069L;

    public static final int EOF = -1;
    private JButton jbtnFileOpen;
    private JTextArea jtaFileList;

    public FileCopy() {
        super("파일 복사");

        jbtnFileOpen = new JButton("파일선택");
        jtaFileList = new JTextArea();

        JScrollPane jspNote = new JScrollPane(jtaFileList);
        jspNote.setBorder(new TitledBorder("복사 파일 목록"));

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
            try {
                fileCopy();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "파일복사 중 문제 발생.");
                e.printStackTrace();
            }
        }//end if
    }//actionPerformed

    private void fileCopy() throws IOException {
        FileDialog fdOpen = new FileDialog(this, "파일선택", FileDialog.LOAD);
        fdOpen.setVisible(true);

        String path = fdOpen.getDirectory();
        String name = fdOpen.getFile();

        if (path != null) { //파일 선택하고 열기를 누른경우
            File originalFile = new File(path + name);

            if (originalFile.exists()) { //파일이 존재한다면
                StringBuilder sbCopyName = new StringBuilder(originalFile.getAbsolutePath());
                //파일명에 _bak넣어 복사할 파일명 생성
                sbCopyName.insert(sbCopyName.lastIndexOf("."), "_bak");

                FileInputStream readStream = null;
                FileOutputStream writeStream = null;
                File copyFile = new File(sbCopyName.toString());

                boolean copyFlag = false;

                if (copyFile.exists()) { //복사할 파일명과 동일한 파일명 존재 ?
                    switch (JOptionPane.showConfirmDialog(this, copyFile.getName() + "동일 파일명이 존재합니다.\n 덮어 쓰시겠습니까?")) {

                        case JOptionPane.OK_OPTION:
                            copyFlag = false;
                            break;
                        case JOptionPane.NO_OPTION:
                            copyFlag = true;
                            break;
                        case JOptionPane.CANCEL_OPTION:
                            copyFlag = true;
                            break;
                    }//end switch
                }//end if

                if (!copyFlag) { //중복 파일이 없으면 false, 예-false, 아니오,취소,true

                    try {
                        //1. 파일을 읽기 위한 스트림 연결
                        readStream = new FileInputStream(originalFile);
                        //2. 파일을 쓰기 위한 스트림 연결
                        writeStream = new FileOutputStream(copyFile);
                        //3. 파일에 내용을 읽어 와서
                        int readSize = 0;
                        byte[] readData = new byte[512];
                        while ((readSize = readStream.read(readData)) != EOF) {
                            //readSize는 읽어들인 값이 저장된 배열의 데이터가 존재하는 곳까지 갯수 저장
                            //4. 스트림에 기록하고
//                            writeStream.write(readSize);
//                            System.out.println(readSize);
                            writeStream.write(readData,0, readSize);

                            //5. 스트림에 기록된 내용을 목적지로 분출
                            writeStream.flush();
                        }//end while
                        JOptionPane.showMessageDialog(this, name + "이 복사 되었습니다.");
                    } finally {
                        //6. 연결끊기
                        if (readStream != null) {
                            readStream.close();
                        }//end if
                        if (writeStream != null) {
                            writeStream.close();
                        }//end if
                    }//end if
                    jtaFileList.append(sbCopyName.toString() + "\n");
                }//end if
            }//end if
        }//end if
    }//fileOpen

    public static void main(String[] args) {

        new FileCopy();

    }//main
}//class
