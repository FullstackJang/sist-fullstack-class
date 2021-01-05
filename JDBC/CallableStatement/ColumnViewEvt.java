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
		// JComboBox에 값을 설정하는 Model객체를 얻는다.
		DefaultComboBoxModel<String> dcbm = cv.getDcbmTableName();

		// DBMS에서 조회된 테이블명을 얻는다.
		ColumnViewDAO cvDAO = ColumnViewDAO.getInstance();
		try {
			List<String> list = cvDAO.selectAllTableName();

			// Model객체에 조회된 결과를 설정한다.
			for (String tname : list) {
				dcbm.addElement(tname);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(cv, "테이블명을 조회할 수 없습니다.");
			e.printStackTrace();
		}

	}// setAllTableName

	/**
	 * 입력된 테이블에 컬럼정보를 조회하여 Model에 설정
	 * @param tname
	 */
	public void setTableColumn(String tname) {
		//입력된 테이블에 컬럼정보를 조회하여 
		try {
			List<ColumnVO> columnData = ColumnViewDAO.getInstance().selectOneTable(tname);
			//Model에 설정
			DefaultTableModel dtm = cv.getDtmColumnView();
			dtm.setRowCount(0); //보여주기 전에 행을 초기화
			
			//행의 값을 설정하기 위한 Object[]선언
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
			JOptionPane.showMessageDialog(cv, tname + "테이블의 정보를 조회할 수 없습니다.");
			e.printStackTrace();
		}//end catch
		
	}//setTableColumn

	@Override
	public void actionPerformed(ActionEvent ae) {
		String tabName = cv.getDcbmTableName().getElementAt(cv.getJcbTableName().getSelectedIndex());
		switch (JOptionPane.showConfirmDialog(cv, tabName + "테이블을 조회하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			setTableColumn(tabName);
		}// end switch
	}// actionPerformed

}// class
