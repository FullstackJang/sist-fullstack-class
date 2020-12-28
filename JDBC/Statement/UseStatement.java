package day1228;

import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Statement�� ����� CRUD
 * @author owner
 */
public class UseStatement {
	
	private StatementCRUD stmtCRUD;
	
	public UseStatement() {
		stmtCRUD = new StatementCRUD();
	}//UseStatement
	
	public void addForm() {
		String csvData = JOptionPane.showInputDialog("�μ������߰�\n�Է� ��) �μ���ȣ,�μ���,��ġ");
		//,�� ���еǾ� �Էµ� ���� �и��Ѵ�.
		String[] processData = csvData.split(",");
		
		//�Էµ� ���� DBMS�� INSERT�ϱ� ���ؼ� �Է� ���� VO�� �����Ѵ�.
		CpDeptVo cdVO = new CpDeptVo(Integer.parseInt(processData[0]),
				processData[1],processData[2]);
		
		try {
			stmtCRUD.insertProcess(cdVO);//�Էµ� ���� ��� ������ �ִ� VO�� �Է�
			System.out.println(cdVO.getDeptno() +"�� �μ� ���� �߰�����");
		} catch (SQLException e) { //method�ȿ��� �߻��ϴ� ��� ���ܸ� ��Ƽ� ó�� �� ���ִ�.
			System.out.println(cdVO.getDeptno() +"�� �μ� ���� �߰�����");
			//SQLException�� �����ڵ带 ������ ������ ���� �پ��ϰ� ��ȯ�Ѵ�.
			switch(e.getErrorCode()) {
			case 1: System.out.println("���� �μ���ȣ�� �����մϴ�");break;
			case 1400: System.out.println("�μ����� �ݵ�� �Է��ؾ��մϴ�.");break;
			case 1438: System.out.println("�μ���ȣ�� ���� 2�ڸ� �Դϴ�."); break;
			case 12899 : System.out.println("�μ����̳� ��ġ�� ���ڼ��� Ȯ�� ���ּ��� �μ����� 14byte ��ġ 13byte�Դϴ�."); 
			System.out.println(e.getMessage());
			break;
			
			}//end switch
			
			e.printStackTrace();
		} 
	}//insertForm
	
	public void modifyForm() {
		String csvData = JOptionPane.showInputDialog("�μ���������\n�μ���ȣ�� ��ġ�ϴ� �μ��� �μ���� ��ġ�� �����մϴ�. \n�Է� ��) �μ���ȣ,�μ���,��ġ");
		//,�� ���еǾ� �Էµ� ���� �и��Ѵ�.
		String[] processData = csvData.split(",");
		
		//�Էµ� ���� DBMS�� INSERT�ϱ� ���ؼ� �Է� ���� VO�� �����Ѵ�.
		CpDeptVo cdVO = new CpDeptVo(Integer.parseInt(processData[0]),
				processData[1],processData[2]);
		
		try {
			int cnt = stmtCRUD.updateProcess(cdVO);
			
			if(cnt == 0) {
				System.out.println(cdVO.getDeptno()+"�� �μ������� ��������ʾҽ��ϴ�.�μ���ȣ�� Ȯ���ϼ���.");		
			}else {
				System.out.println(cdVO.getDeptno()+"�� �μ������� ����Ǿ����ϴ�.");
			}//end else
		} catch (SQLException se) {
			System.err.println("DB�۾� �� ���� �߻�");
			switch(se.getErrorCode()) {
			case 1400: System.out.println("�μ����� �ݵ�� �Է��ؾ��մϴ�.");break;
			case 12899 : System.out.println("�μ����̳� ��ġ�� ���ڼ��� Ȯ�� ���ּ��� �μ����� 14byte ��ġ 13byte�Դϴ�."); 
			System.out.println(se.getMessage());
			break;
			
			}//end switch
			se.printStackTrace();
		}//end catch
		
	}//updateForm
	
	public void removeForm() {
		String inputData = JOptionPane.showInputDialog("�μ���������\n�Է� ��) �μ���ȣ");
		
		int deptno = Integer.parseInt(inputData);
		
		try {
			int cnt = stmtCRUD.deleteProcess( deptno );
			if(cnt != 0) {
				System.out.println(deptno + "�� �μ������� ���� �Ǿ����ϴ�.");
			}else {
				System.out.println(deptno + "�� �μ������� ���� ���� �ʾҽ��ϴ�.");
			}
		} catch (SQLException e) {
			System.err.println("DB���� ������ �߻�");
			e.printStackTrace();
		}//end catch
		
	}//deleteForm
	
	public static void main(String[] args) {
		UseStatement us = new UseStatement();
//		us.addForm();
		us.modifyForm();
//		us.removeForm();
	}//main
	
}//class
