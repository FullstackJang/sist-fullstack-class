package day1118;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * ������ ���α׷���(Component Programming)
 */


//1. ������ ������Ʈ�� ��� �޴´�. (����ڿ��� �����ֱ� ���ؼ�)
@SuppressWarnings("serial")
public class HelloAWT3 extends Frame implements WindowListener{

    //2������ �ۼ�.
    public HelloAWT3(){
        super("�ȳ��ϼ���. AWT");// �θ�Ŭ������ ������ ȣ��

//        Container a = new Frame();
//        Window b = new Frame();

        //3. ������Ʈ�� ����
        Button btn = new Button("���� ��ư"); //has-a

        //4. ������Ʈ�� ��ġ
        add(btn);
 
        //5. ������ ũ�� ����
        setSize(500,400);

        //6. �����츦 ����ڿ��� �����ش�.
        setVisible(true);

        //7. ������ �����̺�Ʈ ó��
        addWindowListener(this);
    }//HelloAWT
    //Mywin�� Frame�̴�. is-A����
    //MYwin�� WindowListener�̴�.
    //�ڽ��� �θ��̴�.

    public static void main(String[] args) {

        new HelloAWT3();

    }

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}//windowOpened

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		System.exit(0); //��𿡼��� ��밡��. �������� JVM�� ������ �����ϴ� �� 
		//0-false ������ ����: ���� ������ �۾��� �������� �ʰ�, �ٷ� ���� 
		//1-true ���� ����: ���� ������ �۾��� ������ �� ����
		
		dispose(); //�θ� Ŭ������ Window�� ��쿡�� ��� ����. ���� �����츦 ����

	}//windowClosing

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}//windowClosed

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}//windowIconified

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}//windowDeiconified

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}//windowActivated

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}//windowDeactivated
}
