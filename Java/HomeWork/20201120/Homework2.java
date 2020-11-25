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
    	super("�۲�"); // JFrame����super�� ���� Frame.init()�� title�̶�� Instance Variable�� init

        //---------------------
        //�۲�
        JLabel jlblfont = new JLabel("�۲�");
        JTextField jtxfont = new JTextField();
        
        //�۲� ��Ÿ��
        JLabel jlblstyle = new JLabel("��Ÿ��");
        JTextField jtxstyle = new JTextField();
        
        //�۲� ũ��
        JLabel jlblsize = new JLabel("ũ��");
        JTextField jtxsize = new JTextField();
        
        //����
        JLabel jlblPreview = new JLabel("                      AaBbYyZz");

        //��ũ��Ʈ
        JLabel jlblScript = new JLabel("��ũ��Ʈ");
        String[] strScript = {"�ѱ�","����"};
       
        //Ȯ�� �� �ݱ�
        JButton jlblcheck = new JButton("Ȯ��");
        JButton jlblclose = new JButton("�ݱ�");
        
        //---------------------------
        
        DefaultListModel<String> dlmFontValue = new DefaultListModel<String>();
        DefaultListModel<String> dlmStyleValue = new DefaultListModel<String>();
        DefaultListModel<String> dlmSizeValue = new DefaultListModel<String>();

        //�޺��ڽ� �� 
        DefaultComboBoxModel<String> dcbScript = new DefaultComboBoxModel<String>(strScript);
        JComboBox<String> jcbScript = new JComboBox<String>(dcbScript); //has-a����
        
        dlmFontValue.addElement("Dialog"); 
        dlmFontValue.addElement("DialogInput");
        dlmFontValue.addElement("Serif");
        dlmFontValue.addElement("SansSerif");
        dlmFontValue.addElement("Monospaced");

        dlmStyleValue.addElement("���ð�");
        dlmStyleValue.addElement("����");
        dlmStyleValue.addElement("����Ӳ�");
        dlmStyleValue.addElement("��������Ӳ�");

        for(int i = 8; i < 101; i++){
            dlmSizeValue.addElement(String.valueOf(i));
        }

        JList<String> jlfont = new JList<String>(dlmFontValue);
        JList<String> jlstyle = new JList<String>(dlmStyleValue);
        JList<String> jlsize = new JList<String>(dlmSizeValue);

        JScrollPane jspfont = new JScrollPane(jlfont);
        JScrollPane jspstyle = new JScrollPane(jlstyle);
        JScrollPane jspsize = new JScrollPane(jlsize);

        //------������ġ
        //JFrame�� default�� BorderLayout���� �����ȴ�.
        //���� ������ġ�� �ϱ� ���ؼ� BorderLayout�� null�� �־���Ѵ�.
        this.setLayout(null); //JFrame�� default-Layout�� BorderLayout�� null
        
        //�۲�
        jlblfont.setBounds(10,10,30,25); //�۲� ��
        jtxfont.setBounds(10,30,170,20); //�۲� �ؽ�Ʈ�ʵ�
        jspfont.setBounds(10,55,170,120); //�۲� ����Ʈ
        
        //��Ÿ��
        jlblstyle.setBounds(200,10,130,20); //��Ÿ�� ��
        jtxstyle.setBounds(200,30,130,20); //��Ÿ�� �ؽ�Ʈ�ʵ�
        jspstyle.setBounds(200,50,130,120); //��Ÿ�� ����Ʈ
        
        //ũ��
        jlblsize.setBounds(350,10,60,20); //ũ�� ��
        jtxsize.setBounds(350,30,60,20); //ũ�� �ؽ�Ʈ�ʵ�
        jspsize.setBounds(350,52,60,110); //ũ�� ����Ʈ
        
        //�̸�����
        jlblPreview.setBounds(212,180,200,75); //�̸�����
        jlblPreview.setBorder(new TitledBorder("����")); //�̸����� �׵θ�
        
        //��ũ��Ʈ
        jlblScript.setBounds(210,240,60,65); //��ũ��Ʈ ��
        jcbScript.setBounds(210,280,200,20); //��ũ��Ʈ �޺��ڽ�
        
        //Ȯ��
        jlblcheck.setBounds(250,390,80,30); //Ȯ�� ��ư
        
        //�ݱ�
        jlblclose.setBounds(335,390,80,30); //�ݱ� ��ư
        
        ///---------------------------
        
        //�۲�
        add(jlblfont);
        add(jtxfont);
        add(jspfont);
        
        //��Ÿ��
        add(jlblstyle);
        add(jtxstyle);
        add(jspstyle);
        
        //ũ��
        add(jlblsize);
        add(jtxsize);
        add(jspsize);
        
        //�̸�����
        add(jlblPreview);
        
        //��ũ��Ʈ
        add(jlblScript);
        add(jcbScript);
        
        //Ȯ��
        add(jlblcheck);
             
        //���
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
