package homework;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MemoFont extends JDialog {
    private JLabel jlblFont;
    private JTextField jtfFont;

    private JLabel jlblStyle;
    private JTextField jtfStyle;

    private JLabel jlblSize;
    private JTextField jtfSize;

    private JLabel jlblPreview;
    private JComboBox<String> jcbScript;
    private DefaultComboBoxModel<String> dcbmScript;

    private JList<String> jlFont;
    private JList<String> jlStyle;
    private JList<String> jlSize;

    private DefaultListModel dlmFont;
    private DefaultListModel dlmStyle;
    private DefaultListModel dlmSize;

    private JButton jbtncheck;
    private JButton jbtnclose;

    JScrollPane jspFont;
    JScrollPane jspStyle;
    JScrollPane jspSize;

    private JavaMemo jm;

   public MemoFont(JavaMemo jm){
       super(jm,"폰트",true);
       this.jm = jm;
       jlblFont = new JLabel("글꼴");
       jtfFont = new JTextField();
       dlmFont = new DefaultListModel<String>();
       dlmFont.addElement("Dialog");
       dlmFont.addElement("DialogInput");
       dlmFont.addElement("Serif");
       dlmFont.addElement("SansSerif");
       dlmFont.addElement("Monospaced");

       jlblStyle = new JLabel("스타일");
       jtfStyle = new JTextField();
       dlmStyle = new DefaultListModel<String>();
       dlmStyle.addElement("가늘게");
       dlmStyle.addElement("굵게");
       dlmStyle.addElement("기울임꼴");
       dlmStyle.addElement("굵은기울임꼴");


       jlblSize = new JLabel("크기");
       jtfSize = new JTextField();
       dlmSize = new DefaultListModel();
       for(int i = 8; i < 101; i++){
           dlmSize.addElement(String.valueOf(i));
       }
       jlblPreview = new JLabel("AaBbYyZz");
       dcbmScript = new DefaultComboBoxModel<String>();
       dcbmScript.addElement("한글");
       dcbmScript.addElement("영어");
       jcbScript = new JComboBox<String>(dcbmScript);

       jlFont = new JList<String>(dlmFont);
       jlStyle = new JList<String>(dlmStyle);
       jlSize = new JList<String>(dlmSize);

       jspFont = new JScrollPane(jlFont);
       jspStyle = new JScrollPane(jlStyle);
       jspSize = new JScrollPane(jlSize);

       jbtncheck = new JButton("확인");
       jbtnclose = new JButton("닫기");

       setLayout(null);

       //글꼴
       jlblFont.setBounds(10,10,30,25); //글꼴 라벨
       jtfFont.setBounds(10,30,170,20); //글꼴 텍스트필드
       jspFont.setBounds(10,55,170,120); //글꼴 리스트

       //스타일
       jlblStyle.setBounds(200,10,130,20); //스타일 라벨
       jtfStyle.setBounds(200,30,130,20); //스타일 텍스트필드
       jspStyle.setBounds(200,50,130,120); //스타일 리스트

       //크기
       jlblSize.setBounds(350,10,60,20); //크기 라벨
       jtfSize.setBounds(350,30,60,20); //크기 텍스트필드
       jspSize.setBounds(350,52,60,110); //크기 리스트
       
       //미리보기
       jlblPreview.setBounds(212,180,200,75); //미리보기
       jlblPreview.setBorder(new TitledBorder("보기")); //미리보기 테두리

       //스크립트
//       .setBounds(210,240,60,65); //스크립트 라벨
       jcbScript.setBounds(210,280,200,20); //스크립트 콤보박스

       //확인
       jbtncheck.setBounds(250,390,80,30);
       //닫기
       jbtnclose.setBounds(335,390,80,30); //닫기 버튼

       //---------------
       MemoFontEvt mfe = new MemoFontEvt(this);
       jlFont.addMouseListener(mfe);
       jlStyle.addMouseListener(mfe);
       jlSize.addMouseListener(mfe);
       jcbScript.addMouseListener(mfe);
       jbtncheck.addMouseListener(mfe);
       jlblPreview.addMouseListener(mfe);

       //글꼴
       add(jlblFont);
       add(jtfFont);
       add(jspFont);

       //스타일
       add(jlblStyle);
       add(jtfStyle);
       add(jspStyle);

       //크기
       add(jlblSize);
       add(jtfSize);
       add(jspSize);

       //미리보기
       add(jlblPreview);

       //스크립트
       add(jcbScript);

       //확인
       add(jbtncheck);

       //취소
       add(jbtnclose);
       
       MemoFontEvt mf = new MemoFontEvt(this);

       setBounds(100,100,440,480);

       setResizable(false);

       setVisible(true);

    }//MemoFont

    public JTextField getJtfFont() {
        return jtfFont;
    }//getJtfFont

    public JTextField getJtfStyle() {
        return jtfStyle;
    }//getJtfStyle

    public JTextField getJtfSize() {
        return jtfSize;
    }//getJtfSize

    public JComboBox<String> getJcbScript() {
        return jcbScript;
    }//getJcbScript

    public JList<String> getJlFont() {
        return jlFont;
    }//getJlFont

    public JList<String> getJlStyle() {
        return jlStyle;
    }//getJlStyle

    public JList<String> getJlSize() {
        return jlSize;
    }//getJlSize

    public DefaultListModel getDlmFont() {
        return dlmFont;
    }//getDlmFont

    public DefaultListModel getDlmStyle() {
        return dlmStyle;
    }//getDlmStyle

    public DefaultListModel getDlmSize() {
        return dlmSize;
    }//getDlmSize

    public JScrollPane getJspFont() {
        return jspFont;
    }

    public JScrollPane getJspStyle() {
        return jspStyle;
    }

    public JScrollPane getJspSize() {
        return jspSize;
    }

    public JLabel getJlblPreview() {
        return jlblPreview;
    }

    public JButton getJbtncheck() {
        return jbtncheck;
    }

    public JavaMemo getJm() {
        return jm;
    }//getJm
}//class
