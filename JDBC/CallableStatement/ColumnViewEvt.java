package day0104;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ColumnViewEvt implements ActionListener {

	private ColumnView cv;

	public ColumnViewEvt(ColumnView cv) {
		this.cv = cv;
		setAllTableName();
	}// ColumnViewEvt


	public void setAllTableName() {
		// JComboBox�� ���� �����ϴ� Model��ü�� ��´�.
		DefaultComboBoxModel<String> dcbm = cv.getDcbmTableName();

		// DBMS���� ��ȸ�� ���̺���� ��´�.
		ColumnViewDAO cvDAO = ColumnViewDAO.getInstance();
		try {
			List<String> list = cvDAO.selectAllTableName();

			// Model��ü�� ��ȸ�� ����� �����Ѵ�.
			for (String tname : list) {
				dcbm.addElement(tname);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(cv, "���̺���� ��ȸ�� �� �����ϴ�.");
			e.printStackTrace();
		}

	}// setAllTableName

	/**
	 * �Էµ� ���̺� �÷������� ��ȸ�Ͽ� Model�� ����
	 * @param tname
	 */
	public void setTableColumn(String tname) {
		//�Էµ� ���̺� �÷������� ��ȸ�Ͽ� 
		try {
			List<ColumnVO> columnData = ColumnViewDAO.getInstance().selectOneTable(tname);
			//Model�� ����
			DefaultTableModel dtm = cv.getDtmColumnView();
			dtm.setRowCount(0); //�����ֱ� ���� ���� �ʱ�ȭ
			
			//���� ���� �����ϱ� ���� Object[]����
			Object[] rowData = null;
			ColumnVO cv = null;
			
			for(int i = 0; i < columnData.size(); i++) {

				cv = columnData.get(i);
				rowData = new Object[5];
				rowData[0] = Integer.valueOf(i+1);
				rowData[1] = cv.getColumnName();
				rowData[2] = cv.getDataType();
				rowData[3] = Integer.valueOf(cv.getPrecision());
				rowData[4] = cv.getNullable() == 0? "Not Null":"Null";
				dtm.addRow(rowData);
			}//end for
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(cv, tname + "���̺��� ������ ��ȸ�� �� �����ϴ�.");
			e.printStackTrace();
		}//end catch
		
	}//setTableColumn

	@Override
	public void actionPerformed(ActionEvent ae) {
		String tabName = cv.getDcbmTableName().getElementAt(cv.getJcbTableName().getSelectedIndex());
		switch (JOptionPane.showConfirmDialog(cv, tabName + "���̺��� ��ȸ�Ͻðڽ��ϱ�?")) {
		case JOptionPane.OK_OPTION:
			setTableColumn(tabName);
		}// end switch
	}// actionPerformed

}// class
