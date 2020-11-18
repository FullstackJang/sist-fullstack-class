package day1118;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * ������ ���α׷���(Component Programming)
 */


//1. ������ ������Ʈ�� ��� �޴´�. (����ڿ��� �����ֱ� ���ؼ�)
@SuppressWarnings("serial")
public class HelloAWT2 extends Frame{

    //2������ �ۼ�.
    public HelloAWT2(){
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
//		addWindowListener(this) //WindowListener�� is a ���谡 �ƴϹǷ� this�� ����� �� ����.
		//WindowListener interface�� �̸� ������ Ŭ������ WindowAdapter�� ����
        //WindowAdapter Ŭ������ WindowListener�� 7���� �߻�method�� �Ϲ� method�� ���� �߱� ������ WindowAdapter�� �ʿ��� method�� ����(Override)�Ѵ�.
        addWindowListener(new WindowAdapter() {
        	
        	@Override
        	public void windowClosing(WindowEvent e) {
        		dispose();
        	}
		}); //�͸�Ŭ������ WindowAdapter�� �θ��̴�.
			
    }//HelloAWT
}

