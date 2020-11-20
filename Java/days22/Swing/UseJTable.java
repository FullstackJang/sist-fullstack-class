package day1120;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UseJTable extends JFrame {

	public UseJTable() {
		super("JTable ����");
		
		//3. ������Ʈ ����
		//�÷����� �����ϴ� ������ �迭�� ����
		String[] columnNames = {"��ȣ","�̸�","����","�̸���","���"};
		
		//���ڵ� ���� �����ϴ� ������ �迭 ����
		String[][] rowData = {
								{"1","������","23","ryu@test.com",""},
								{"2","����","25","kei@naver.com",""},
								{"3","������","26","seo@hanmail.net",""},
								{"4","������","27","you@daum.com",""},
							 };
		//�����͸� ������ Model��ü ����
		DefaultTableModel dtm = new DefaultTableModel(rowData,columnNames);
	
		//�����͸� ������ ��ü ����
		JTable jta = new JTable(dtm); //JTable�� jta�� DefaultTableModel�� dtm�� Has-A�����̴�.
		
		//���� ũ�⼳��
		jta.setRowHeight(20);
		
		//�÷��� ���� ����
		jta.getColumnModel().getColumn(0).setPreferredWidth(80);
		jta.getColumnModel().getColumn(1).setPreferredWidth(120);
		jta.getColumnModel().getColumn(2).setPreferredWidth(80);
		jta.getColumnModel().getColumn(3).setPreferredWidth(220);

		//��ġ������ ����
		setLayout(new BorderLayout());
		
		
		//dtm�� method�� ����Ͽ� �����͸� �߰�
		//�迭�� ����
		String[] data= {"5","�̹���","26","lee@hotmail.net",""};
		//Model��ü�� �������߰�
		dtm.addRow(data);
		
		//Vector ���
		Vector<String> vec = new Vector<String>();
		vec.add("6");
		vec.add("������");
		vec.add("26");
		vec.add("jeong@nate.com");
		vec.add("");
		//Model��ü�� �������߰�
		dtm.addRow(vec);
		
		//��Ŭ�ѹ� ����
		JScrollPane jsp = new JScrollPane(jta); // jsp�� jta�� Has-a ����
		//�׵θ�
		jsp.setBorder(new TitledBorder("�л�����"));
		//��ġ
		add(jsp);
		
		setBounds(100,100,700,400);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UseJTable();
	}
}
