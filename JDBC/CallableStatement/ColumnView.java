package day0104;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ColumnView extends JFrame {

	private DefaultComboBoxModel<String> dcbmTableName;
	private JComboBox<String> jcbTableName;
	private DefaultTableModel dtmColumnView;
	private JTable jtaColumnView;
	private JButton jbtnSearch;
	
	public ColumnView() {
		super("���̺� �÷� ��ȸ");

		dcbmTableName = new DefaultComboBoxModel<String>();
		jcbTableName = new JComboBox<String>(dcbmTableName);

		String[] columnNames = {"��ȣ","�÷���","��������","ũ��","null���"};
		dtmColumnView = new DefaultTableModel(columnNames,6);

		jtaColumnView = new JTable(dtmColumnView);
		//�÷��� ���� ����
		jtaColumnView.getColumnModel().getColumn(0).setPreferredWidth(40);
		jtaColumnView.getColumnModel().getColumn(1).setPreferredWidth(300);
		jtaColumnView.getColumnModel().getColumn(2).setPreferredWidth(140);
		jtaColumnView.getColumnModel().getColumn(3).setPreferredWidth(100);
		jtaColumnView.getColumnModel().getColumn(4).setPreferredWidth(100);

		//���ڵ��� ���� ����
		jtaColumnView.setRowHeight(30);
		jbtnSearch = new JButton("��ȸ");
		
		JPanel jpNorth = new JPanel();
		jpNorth.add(new JLabel("���̺��"));
		jpNorth.add(jcbTableName);
		jpNorth.add(jbtnSearch);
		
		JScrollPane jspCenter = new JScrollPane(jtaColumnView);
		
		add("North",jpNorth);
		add("Center", jspCenter);
		
		ColumnViewEvt cvEvt = new ColumnViewEvt(this);
		jbtnSearch.addActionListener(cvEvt);
		
		setBounds(100,100,650,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//ColumnView

	public JComboBox<String> getJcbTableName() {
		return jcbTableName;
	}

	public DefaultComboBoxModel<String> getDcbmTableName() {
		return dcbmTableName;
	}

	public JTable getJtaColumnView() {
		return jtaColumnView;
	}

	public DefaultTableModel getDtmColumnView() {
		return dtmColumnView;
	}

	public JButton getJbtnSearch() {
		return jbtnSearch;
	}
	
	public static void main(String[] args) {
		new ColumnView();
	}
}//class