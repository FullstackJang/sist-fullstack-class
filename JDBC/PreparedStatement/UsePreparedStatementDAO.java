package day1229;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

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
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		try {
			List<CpEmpAllVO> list = psDAO.selectAllCpEmp();
			
			System.out.println("�����ȣ\t�����\t����\t����\t���ʽ�\t�Ի���1,\t�Ի���2");
			System.out.println("============================================");
			
			if(list.isEmpty()) {
				System.out.println("��������� �������� �ʽ��ϴ�.");
			}//end if
			
			Date hiredate = null; //Oracle���� Date������ ������� ��¥�� �����ϱ� ����
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE hh:mm:ss");
					
			for(CpEmpAllVO ceaVO : list) {
				
				//Date�� �޴´�.
				hiredate = ceaVO.getHiredate1();
		
				System.out.println(ceaVO.getEmpno() + "\t" + 
				ceaVO.getEname() + "\t" + ceaVO.getJob() + "\t" + ceaVO.getSal()+ "\t" + ceaVO.getComm() +"\t" +ceaVO.getHiredate() + "\t" + sdf.format(hiredate));
			}//end for
		} catch (SQLException se) {
			se.printStackTrace();
		}//end switch
		
	}//searchAllEmp
	
	public void searchOneEmp() {
		
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		
		int empno = 1;
		
		try {
			CpEmpOneVO ceoVO = psDAO.selectOneCpEmp(empno);
			System.out.println(ceoVO);
			if(ceoVO == null) {
				System.out.println(empno + "�� ����� �������� �ʽ��ϴ�.");
			}else {
				System.out.println(empno + "�� ��� ���� ��ȸ ���");
				System.out.println("����� [" + ceoVO.getEname()+ "]");
				System.out.println("���� [" + ceoVO.getJob()+ "]");
				System.out.println("���� [" + ceoVO.getSal()+ "]");
				System.out.println("���ʽ� [" + ceoVO.getComm()+ "]");
				System.out.println("�Ի��� [" + ceoVO.getHiredate()+ "]");
			}//end if
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//searchOneEmp
	
	public static void main(String[] args) {
		UsePreparedStatementDAO upsDAO = new UsePreparedStatementDAO();
//		upsDAO.addEmp();
//		upsDAO.modifyEmp();
//		upsDAO.removeEmp();
		upsDAO.searchAllEmp();
//		upsDAO.searchOneEmp();
	}//main
	
}//class
