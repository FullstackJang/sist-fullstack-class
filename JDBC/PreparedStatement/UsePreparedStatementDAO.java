package day1229;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class UsePreparedStatementDAO {
	
	public void addEmp() {
		CpEmpAddVO ceaVO = new CpEmpAddVO(1111,"조유리","사원",2800,2800);
		
		//객체얻기
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		
		try {
			psDAO.insertCpEmp(ceaVO);
			System.out.println(ceaVO.getEmpno()+"번 사원 정보 추가 성공");
		} catch (SQLException se) {
			System.out.println("DB에서 문제 발생");
			switch(se.getErrorCode()) {
			case 1438 : System.out.println("사원번호는 4자리로 입력해주세요.");break;
			case 12899 : System.out.println("사원명은 10byte / 직무는 9byte 내로 입력 해 주세요. "); break;
				
			}//end switch
			se.printStackTrace();
		}
		
	}//addEmp
	
	public void modifyEmp() {
		
		CpEmpModifyVO cemVO = new CpEmpModifyVO(1111,"대리",3200,100);
		
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		try {
			int rowCnt = psDAO.updateCpEmp(cemVO);//1111번 사원이 존재하지 않아 변경이 안되는 것입니다.
			
			if( rowCnt != 0 ) {
				System.out.println(cemVO.getEmpno()+"번 사원의 정보가 변경되었습니다.");
			}else {
				System.out.println(cemVO.getEmpno()+"번 사원은 존재하지 않습니다. 사원번호를 확인하세요.");
			}//end else
			
		} catch (SQLException e) {
			System.out.println("DB작업 중 문제가 발생");
			e.printStackTrace();
		}//end catch
		
	}//modifyEmp
	
	public void removeEmp() {
		int empno = 1111;
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		try {
			int rowCnt = psDAO.deleteCpEmp(1111);
			
			if(rowCnt != 0) {
				System.out.println(empno + "번 사원 정보 삭제 성공");
			}else {
				System.out.println(empno + "번 사원은 존재하지 않습니다.");
			}//end else
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
	
	}//removeEmp
	
	public void searchAllEmp() {
		PreparedStatementDAO psDAO = PreparedStatementDAO.getInstance();
		try {
			List<CpEmpAllVO> list = psDAO.selectAllCpEmp();
			
			System.out.println("사원번호\t사원명\t직무\t연봉\t보너스\t입사일1,\t입사일2");
			System.out.println("============================================");
			
			if(list.isEmpty()) {
				System.out.println("사원정보가 존재하지 않습니다.");
			}//end if
			
			Date hiredate = null; //Oracle에서 Date형으로 얻어지는 날짜를 저장하기 위해
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE hh:mm:ss");
					
			for(CpEmpAllVO ceaVO : list) {
				
				//Date를 받는다.
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
				System.out.println(empno + "번 사원이 존재하지 않습니다.");
			}else {
				System.out.println(empno + "번 사원 정보 조회 결과");
				System.out.println("사원명 [" + ceoVO.getEname()+ "]");
				System.out.println("직무 [" + ceoVO.getJob()+ "]");
				System.out.println("연봉 [" + ceoVO.getSal()+ "]");
				System.out.println("보너스 [" + ceoVO.getComm()+ "]");
				System.out.println("입사일 [" + ceoVO.getHiredate()+ "]");
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
