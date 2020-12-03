package homework;


import java.awt.*;
import java.awt.event.*;

public class MemoFontEvt extends MouseAdapter implements WindowListener {

    private MemoFont mf;

    public MemoFontEvt(MemoFont mf) {
        this.mf = mf;

    }//MemoFontEvt

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == mf.getJlFont()) {
            setFont();
            setPreview();

        }//font end if

        if(me.getSource() == mf.getJlStyle()) {
            setStyle();
            setPreview();

        }// end if

        if(me.getSource() == mf.getJlSize()) {
            setSize();
            setPreview();
        }// end if

        if(me.getSource() == mf.getJlblPreview()){
            setPreview();
        }

        if(me.getSource() == mf.getJcbScript()) {
            setScript();
        }// end if

        if(me.getSource() == mf.getJcbScript()){
            setScript();
        }//end if

        if(me.getSource() == mf.getJbtncheck()){
            fontApply();
        }//end if


    }//mouseClicked

    public void setFont() {
        mf.getJtfFont().setText(mf.getJlFont().getSelectedValue());
    }//setFont

    public void setStyle() {
        mf.getJtfStyle().setText(mf.getJlStyle().getSelectedValue());
    }//setStyle

    public void setSize() {
        mf.getJtfSize().setText(mf.getJlSize().getSelectedValue());
    }//setSize

    public void setPreview() {
        Font font = mf.getJlblPreview().getFont();

       String a = mf.getJlFont().getSelectedValue().trim();
       int b = mf.getJlStyle().getSelectedIndex();
       int c= Integer.parseInt(mf.getJlSize().getSelectedValue());

       mf.getJlblPreview().setFont(new Font(mf.getJlFont().getSelectedValue(),mf.getJlStyle().getSelectedIndex(),10));

//        mf.getJlblPreview().setFont(new Font(mf.getJlFont().getSelectedValue(),mf.getJlStyle().getSelectedIndex(),Integer.parseInt(mf.getJlSize().getSelectedValue())));

    }//setPreview

    public void setScript() {
        if("한글".equals(mf.getJcbScript().getSelectedItem().toString())){
            mf.getJlblPreview().setText("AaBbYyZz가나다");
        }//end if

        if("영어".equals(mf.getJcbScript().getSelectedItem().toString())){
            mf.getJlblPreview().setText("AaBbYyZz");
        }
    }//setScript

    public void fontApply() {
        mf.getJm().getJtaMemo().append(mf.getJlFont().getSelectedValue() + " " + mf.getJlStyle().getSelectedValue() + " "
                +mf.getJlSize().getSelectedValue());

        mf.getJbtncheck().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.dispose();
            }
        });
    }//fontApply

    @Override
    public void windowActivated(WindowEvent e) {

    }//windowActivated

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        mf.dispose();
    }//windowClosing

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }//windowClosed

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

}//class