package homework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

    private JavaMemo jMemo;

    public JavaMemoEvt(JavaMemo jMemo) {
        this.jMemo = jMemo;
    }//JavaMemoEvt

    @Override
    public void actionPerformed(ActionEvent ae) {

        //새글
        if (ae.getSource() == jMemo.getJmiNew()) {
            newMemo();
        }//end if

        if (ae.getSource() == jMemo.getJmiOpen()) {
            openMemo();
        }//end if

        if (ae.getSource() == jMemo.getJmiSave()) {
            saveMemo();
        }//end if

        if (ae.getSource() == jMemo.getJmiNewSave()) {
            saveNewMemo();
        }//end if

        if (ae.getSource() == jMemo.getJmiClose()) {
            memoClose();
        }//end if

        if (ae.getSource() == jMemo.getJmiFont()) {
            openFont();
        }//end if

        if(ae.getSource() == jMemo.getJmiClose()){
            memoClose();
        }//end if

        if(ae.getSource() == jMemo.getJmiHelp()){
            openHelp();
        }

    }//actionPerformed


    //새글
    private void newMemo() {

        jMemo.getJtaMemo().setText("");

    }//newMemo

    //열기
    private void openMemo() {
        FileDialog fd = new FileDialog(jMemo, "열기", FileDialog.LOAD);

        fd.setVisible(true);

        String file = fd.getFile();

        if (fd.getFile() != null) {
            jMemo.setTitle("메모장-열기:" + file);
        }//end if

    }//openMemo

    //저장
    private void saveMemo() {
        FileDialog fd = new FileDialog(jMemo, "저장", FileDialog.SAVE);

        fd.setVisible(true);

        String file = fd.getFile();

        if (fd.getFile() != null) {
            jMemo.setTitle("메모장-저장:" + file);
        }//end if
    }//saveMemo

    //새로저장
    private void saveNewMemo() {
        FileDialog fd = new FileDialog(jMemo, "저장", FileDialog.SAVE);

        fd.setVisible(true);

        String file = fd.getFile();

        if (fd.getFile() != null) {
            jMemo.setTitle("메모장-저장:" + file);
        }//end if

    }//saveNewMemo

    //닫기
    private void memoClose() {

        jMemo.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                    jMemo.dispose();
            }//windowClosing
        });

    }//memoClose

    private void openFont() {
        new MemoFont(jMemo);
    }//openFont

    private void openHelp() {
        new JavaMemoInfo(jMemo);
    }//openHelp


}//class
