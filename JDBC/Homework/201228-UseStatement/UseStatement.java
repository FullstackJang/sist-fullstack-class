package Homework;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UseStatement {
	
	private StatementCRUD stmtCRUD;
	CpEmpVO ceVO;
	public UseStatement() {
		stmtCRUD = new StatementCRUD();
		String[] processData = {"2222","������","SYSDATE","20","���","3000"};
		ceVO = new CpEmpVO(processData[0],processData[1],processData[2],Integer.parseInt(processData[3]), processData[4], Integer.parseInt(processData[5]));
		
	}//UseStatement
	
	//================================= addForm =====================================
	public void addForm(){

		try {
			stmtCRUD.insertProcess(ceVO);
			System.out.println(ceVO.getDeptno() +"�� �μ� ���� �߰�����");
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			System.err.println("DB�۾� �� ���� �߻�");
			switch(se.getErrorCode()) {
			case 1: System.out.println("���� �μ���ȣ�� �����մϴ�");break;
			case 1400: System.out.println("�μ����� �ݵ�� �Է��ؾ��մϴ�.");break;
			case 1438: System.out.println("�μ���ȣ�� ���� 2�ڸ� �Դϴ�."); break;
			case 12899 : System.out.println("�μ����̳� ��ġ�� ���ڼ��� Ȯ�� ���ּ��� �μ����� 14byte ��ġ 13byte�Դϴ�."); 
			System.out.println(se.getMessage());
			break;	
			}//end switch
		}//end catch
	}//addForm
	
	//========================================= modifyForm =========================================
	public void modifyForm() {
		
		try {
			int cnt = stmtCRUD.updateProcess(ceVO);
			if(cnt == 1) {
				System.out.println(ceVO.getEmpno() + "�� ��� ������ ���� �Ǿ����ϴ�.");
			}else {
				System.out.println(ceVO.getDeptno()+"�� ��������� ��������ʾҽ��ϴ�. ��������� Ȯ���ϼ���.");		

//				System.out.println(ceVO.getDeptno()+"�� �μ������� ����Ǿ����ϴ�.");
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
	}//modifyForm
	

	//========================================= modifyForm =========================================
	public void removeForm() {
		
		try {
			int cnt = stmtCRUD.deleteProcess( ceVO );
			
			if(cnt != 0) {
				System.out.println(ceVO.getEmpno() + "�� ��������� ���� �Ǿ����ϴ�.");
			}else {
				System.out.println(ceVO.getEmpno() + "�� ��������� ���� ���� �ʾҽ��ϴ�.");
			}
		} catch (SQLException e) {
			System.err.println("DB���� ������ �߻�");
			e.printStackTrace();
		}//end catch
		
	}//deleteForm


	public static void main(String[] args) {
	
	UseStatement us = new UseStatement();
//	us.addForm();
//	us.modifyForm();
	us.removeForm();
		
	}// main
}// class
