package day1118;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * GridLayout: ���� ���̾ƿ�
 * ��� ��, ��� ���� ������Ʈ ũ�Ⱑ �����ϰ� �����Ǵ� ���̾ƿ�
 * @author owner
 *
 */

@SuppressWarnings("serial")
//1. ������ ������Ʈ�� ���
public class TestGridLayout extends JFrame {

    //2. �����ڸ� ����
    public TestGridLayout() {
        super("GridLayout ����");

        setLayout(new GridBagLayout());
        
        //��� ���������� �迭�� ���� �� �ִ�. ����Ʈ�� ��������ִ�.      
        //1. ����Ʈ�� ����� ��
        List<JButton> list = new ArrayList<JButton>();
        for(int i = 1; i < 10; i++) {
        	list.add(new JButton(String.valueOf(i)));
        }
        //1-1. �迭�� ����� ��
        JButton [] arr = new JButton[9];
        for(int i = 0; i < arr.length; i++) {
        	//��� ���� ���� null�̹Ƿ� ����� �� ��� ��ü�� �����Ѵ�.
        	arr[i] = new JButton(String.valueOf(i)); //�⺻�� �������� ���� ���ڿ��� �ٲ� ������ StringŬ������valueOf�� ������� 
//        	arr[i] = new JButton(Integer.valueOf(i+1).toString());
        }
        //3. ������Ʈ ����
        JButton jbtn1 = new JButton("1");
        JButton jbtn2 = new JButton("2");
        JButton jbtn3 = new JButton("3");
        JButton jbtn4 = new JButton("4");
        JButton jbtn5 = new JButton("5");
        JButton jbtn6 = new JButton("6");
        JButton jbtn7 = new JButton("7");
        JButton jbtn8 = new JButton("8");
        JButton jbtn9 = new JButton("9");
        //4. ��ġ������ ����: BorderLayout => GridLayout
        setLayout(new GridLayout(3,3));

        //5. ������Ʈ ��ġ
        
        //5-1. ����Ʈ
        for(int i = 0; i < list.size(); i++) {
        	add(list.get(i));
        }
        
        //5-2. �迭�� ���
        for(int i = 0; i < arr.length; i++) {
        	//JButton �迭�� ���濡 ������ JButton�� ��ġ�Ѵ�.
        	add(arr[i]);
        }
//        add(jbtn1);
//        add(jbtn2);
//        add(jbtn3);
//        add(jbtn4);
//        add(jbtn5);
//        add(jbtn6);
//        add(jbtn7);
//        add(jbtn8);
//        add(jbtn9);
        //6. ������ ������Ʈ�� ũ�� ����
        setSize(400,400);

        //7. ������ ������Ʈ�� ����ڿ��� �����ֱ�
        setVisible(true);

        //8. ������ ������Ʈ�� �����̺�Ʈ ó��
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }//TestGridLayout

    public static void main(String[] args) {
        new TestGridLayout();
    }
}
