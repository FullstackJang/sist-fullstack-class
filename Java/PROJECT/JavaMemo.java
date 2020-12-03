package homework;

import javax.swing.*;

public class JavaMemo extends JFrame {

    private JavaMemoRun jmr;
    private JTextArea jtaMemo;

    private JMenuItem jmiNew;
    private JMenuItem jmiOpen;
    private JMenuItem jmiSave;
    private JMenuItem jmiNewSave;
    private JMenuItem jmiClose;
    private JMenuItem jmiFont;
    private JMenuItem jmiHelp;
    public JavaMemo(){
        this.jmr = jmr;

        JMenuBar jmb = new JMenuBar();

        JMenu jmFile = new JMenu("파일");
        jmiNew = new JMenuItem("새글");
        jmiOpen = new JMenuItem("열기");
        jmiSave = new JMenuItem("저장");
        jmiNewSave = new JMenuItem("새 이름으로 저장");
        jmiClose = new JMenuItem("닫기");

        JMenu jmOpen = new JMenu("서식");
        jmiFont = new JMenuItem("폰트");

        JMenu jmHelp = new JMenu("도움말");
        jmiHelp = new JMenuItem("메모장 정보");

        jtaMemo = new JTextArea();


        //--------------------
        jmFile.add(jmiNew);
        jmFile.addSeparator();
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.add(jmiNewSave);
        jmFile.addSeparator();
        jmFile.add(jmiClose);

        //---------------------
        jmOpen.add(jmiFont);

        jmHelp.add(jmiHelp);

        jmb.add(jmFile);
        jmb.add(jmOpen);
        jmb.add(jmHelp);

        add(jtaMemo);
        JavaMemoEvt jme = new JavaMemoEvt(this);
        jmiNew.addActionListener(jme);
        jmiOpen.addActionListener(jme);
        jmiSave.addActionListener(jme);
        jmiNewSave.addActionListener(jme);
        jmiFont.addActionListener(jme);
        jmiClose.addActionListener(jme);
        jmiHelp.addActionListener(jme);

        //----------------
        setJMenuBar(jmb);

        setBounds(100,200,700,400);

        setVisible(true);

    }//JavaMemo

    public JTextArea getJtaMemo() {
        return jtaMemo;
    }//getJtaMemo

    public JMenuItem getJmiNew() {
        return jmiNew;
    }//getJmiNew

    public JMenuItem getJmiOpen() {
        return jmiOpen;
    }//getJmiOpen

    public JMenuItem getJmiSave() {
        return jmiSave;
    }//getJMiSave

    public JMenuItem getJmiNewSave() {
        return jmiNewSave;
    }//getJmiNewSave

    public JMenuItem getJmiClose() {
        return jmiClose;
    }//getJmiClose

    public JMenuItem getJmiFont() {
        return jmiFont;
    }//getJmiFont

    public JMenuItem getJmiHelp() {
        return jmiHelp;
    }//getJmiHelp

}//class
