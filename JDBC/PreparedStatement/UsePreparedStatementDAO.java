package day1229;

import java.sql.SQLException;

public class UsePreparedStatementDAO {
	
	public void addEmp() {
		CpEmpAddVO ceaVO = new CpEmpAddVO(1111,"������","���",2800,2800);
		
		//��ü���
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		
		try {
			psDAO.insertCpEmp(ceaVO);
			System.out.println(ceaVO.getEmpno()+"�� ��� ���� �߰� ����");
		} catch (SQLException se) {
			System.out.println("DB���� ���� �߻�");
			switch(se.getErrorCode()) {
			case 1438 : System.out.println("�����ȣ�� 4�ڸ��� �Է����ּ���.");break;
			case 12899 : System.out.println("������� 10byte / ������ 9byte ���� �Է� �� �ּ���. "); break;
				
			}//end switch
			se.printStackTrace();
		}
		
	}//addEmp
	
	public void modifyEmp() {
		
		CpEmpModifyVO cemVO = new CpEmpModifyVO(1111,"�븮",3200,100);
		
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		try {
			int rowCnt = psDAO.updateCpEmp(cemVO);//1111�� ����� �������� �ʾ� ������ �ȵǴ� ���Դϴ�.
			
			if( rowCnt != 0 ) {
				System.out.println(cemVO.getEmpno()+"�� ����� ������ ����Ǿ����ϴ�.");
			}else {
				System.out.println(cemVO.getEmpno()+"�� ����� �������� �ʽ��ϴ�. �����ȣ�� Ȯ���ϼ���.");
			}//end else
			
		} catch (SQLException e) {
			System.out.println("DB�۾� �� ������ �߻�");
			e.printStackTrace();
		}//end catch
		
	}//modifyEmp
	
	public void removeEmp() {
		int empno = 1111;
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		try {
			int rowCnt = psDAO.deleteCpEmp(1111);
			
			if(rowCnt != 0) {
				System.out.println(empno + "�� ��� ���� ���� ����");
			}else {
				System.out.println(empno + "�� ����� �������� �ʽ��ϴ�.");
			}//end else
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
	
	}//removeEmp
	
	public void searchAllEmp() {
		
	}//searchAllEmp
	
	public void searchOneEmp() {
		
	}//searchOneEmp
	
	public static void main(String[] args) {
		UsePreparedStatementDAO upsDAO = new UsePreparedStatementDAO();
//		upsDAO.addEmp();
//		upsDAO.modifyEmp();
		upsDAO.removeEmp();
		
	}//main
	
}//class
