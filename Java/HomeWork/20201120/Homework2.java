package day1120;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Homework2 extends JFrame {

    public Homework2() {
    	super("글꼴"); // JFrame에서super를 통해 Frame.init()에 title이라는 Instance Variable에 init

        //---------------------
        //글꼴
        JLabel jlblfont = new JLabel("글꼴");
        JTextField jtxfont = new JTextField();
        
        //글꼴 스타일
        JLabel jlblstyle = new JLabel("스타일");
        JTextField jtxstyle = new JTextField();
        
        //글꼴 크기
        JLabel jlblsize = new JLabel("크기");
        JTextField jtxsize = new JTextField();
        
        //보기
        JLabel jlblPreview = new JLabel("                      AaBbYyZz");

        //스크립트
        JLabel jlblScript = new JLabel("스크립트");
        String[] strScript = {"한글","영어"};
       
        //확인 및 닫기
        JButton jlblcheck = new JButton("확인");
        JButton jlblclose = new JButton("닫기");
        
        //---------------------------
        
        DefaultListModel<String> dlmFontValue = new DefaultListModel<String>();
        DefaultListModel<String> dlmStyleValue = new DefaultListModel<String>();
        DefaultListModel<String> dlmSizeValue = new DefaultListModel<String>();

        //콤보박스 모델 
        DefaultComboBoxModel<String> dcbScript = new DefaultComboBoxModel<String>(strScript);
        JComboBox<String> jcbScript = new JComboBox<String>(dcbScript); //has-a관계
        
        dlmFontValue.addElement("Dialog"); 
        dlmFontValue.addElement("DialogInput");
        dlmFontValue.addElement("Serif");
        dlmFontValue.addElement("SansSerif");
        dlmFontValue.addElement("Monospaced");

        dlmStyleValue.addElement("가늘게");
        dlmStyleValue.addElement("굵게");
        dlmStyleValue.addElement("기울임꼴");
        dlmStyleValue.addElement("굵은기울임꼴");

        for(int i = 8; i < 101; i++){
            dlmSizeValue.addElement(String.valueOf(i));
        }

        JList<String> jlfont = new JList<String>(dlmFontValue);
        JList<String> jlstyle = new JList<String>(dlmStyleValue);
        JList<String> jlsize = new JList<String>(dlmSizeValue);

        JScrollPane jspfont = new JScrollPane(jlfont);
        JScrollPane jspstyle = new JScrollPane(jlstyle);
        JScrollPane jspsize = new JScrollPane(jlsize);

        //------수동배치
        //JFrame은 default로 BorderLayout으로 지정된다.
        //따라서 수동배치를 하기 위해서 BorderLayout을 null을 주어야한다.
        this.setLayout(null); //JFrame에 default-Layout인 BorderLayout을 null
        
        //글꼴
        jlblfont.setBounds(10,10,30,25); //글꼴 라벨
        jtxfont.setBounds(10,30,170,20); //글꼴 텍스트필드
        jspfont.setBounds(10,55,170,120); //글꼴 리스트
        
        //스타일
        jlblstyle.setBounds(200,10,130,20); //스타일 라벨
        jtxstyle.setBounds(200,30,130,20); //스타일 텍스트필드
        jspstyle.setBounds(200,50,130,120); //스타일 리스트
        
        //크기
        jlblsize.setBounds(350,10,60,20); //크기 라벨
        jtxsize.setBounds(350,30,60,20); //크기 텍스트필드
        jspsize.setBounds(350,52,60,110); //크기 리스트
        
        //미리보기
        jlblPreview.setBounds(212,180,200,75); //미리보기
        jlblPreview.setBorder(new TitledBorder("보기")); //미리보기 테두리
        
        //스크립트
        jlblScript.setBounds(210,240,60,65); //스크립트 라벨
        jcbScript.setBounds(210,280,200,20); //스크립트 콤보박스
        
        //확인
        jlblcheck.setBounds(250,390,80,30); //확인 버튼
        
        //닫기
        jlblclose.setBounds(335,390,80,30); //닫기 버튼
        
        ///---------------------------
        
        //글꼴
        add(jlblfont);
        add(jtxfont);
        add(jspfont);
        
        //스타일
        add(jlblstyle);
        add(jtxstyle);
        add(jspstyle);
        
        //크기
        add(jlblsize);
        add(jtxsize);
        add(jspsize);
        
        //미리보기
        add(jlblPreview);
        
        //스크립트
        add(jlblScript);
        add(jcbScript);
        
        //확인
        add(jlblcheck);
             
        //취소
        add(jlblclose);
       
        setBounds(100,100,440,480);

        setVisible(true);
        
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }//Homework

    public static void main(String[] args) {
    			new Homework2();
    }//main
}//class
