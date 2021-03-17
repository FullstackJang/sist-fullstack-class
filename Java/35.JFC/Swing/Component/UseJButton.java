package day1119;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
//1. ������ ������Ʈ ���
public class UseJButton extends JFrame{

	//2. ������
	public UseJButton() {
		super("�̹����� ���� JButton ���");
		
		//3. ������Ʈ ����
		//�ڹٿ��� ����ϴ� ��δ� /�� \ ��� ��� ����
		// \�� ����� ������ Ư�������� ���۱�ȣ�� ���ļ� \���� �ѱ��ڿ� �Բ� Ư������ ó���ȴ�.
		//�̶� \�ڿ� �� ���ڰ� �ڹٿ��� �����ϴ� Ư�����ڰ� �ƴ϶�� Error�� �߻��Ѵ�.
		// \�� ����Ͽ� ��θ� ǥ���� �� ������ \\�� ����Ͽ� ��θ� ǥ���Ѵ�.
		ImageIcon ii1 = new ImageIcon("/C:/dev/workspace/javase_pj/src/day1119/img/img_1.png");
		ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_pj/src/day1119/img/img_2.png");
		ImageIcon ii3 = new ImageIcon("C:/dev/workspace/javase_pj/src/day1119/img/img_3.png");
		ImageIcon ii4 = new ImageIcon("C:/dev/workspace/javase_pj/src/day1119/img/img_4.png");

		JButton jbtn1 = new JButton("���̾�",ii1);
		JButton jbtn2 = new JButton("����ġ",ii2);
		JButton jbtn3 = new JButton("����",ii3);
		
		//border ����
		jbtn1.setBorder(new TitledBorder("īī�� ������"));
		jbtn2.setBorder(new TitledBorder("īī�� ������"));
		jbtn3.setBorder(new TitledBorder("īī�� ������"));
		
		//��ư 3�� ���콺 �����Ͱ� �ö󰡰ų� Ŭ���Ǹ� �̹����� ���� : RollOver
		jbtn3.setRolloverIcon(ii4);

		//jbtn1�� �ؽ�Ʈ�� ���� ��ġ �̵� (LEFT, CENTER, RIGHT)
		jbtn1.setHorizontalTextPosition(JButton.RIGHT);
		
		//jbtn2�� �ؽ�Ʈ ������ġ �̵�(TOP,CENTER, BOTTOM)
		jbtn2.setVerticalTextPosition(JButton.BOTTOM);
		
		jbtn3.setHorizontalTextPosition(JButton.CENTER);
		jbtn3.setVerticalTextPosition(JButton.BOTTOM);

		//ǳ������: Tooltip Text
		jbtn1.setToolTipText("����� ��");
		jbtn2.setToolTipText("�������� ��");
		jbtn3.setToolTipText("�ܹ����� ��");
		//4. ��ġ������ ����
		setLayout(new GridLayout(1,3));
		
		//5. ��ġ
		add(jbtn1);
		add(jbtn2);
		add(jbtn3);
		
		//6.������ ũ�⼳��
		setBounds(100,200,600,300);
		
		//7. �����츦 ����ڿ��� �����ֱ�
		setVisible(true);
		
		//8. ���� ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJButton
	
	public static void main(String[] args) {
			new UseJButton();
	}//main
}//class
