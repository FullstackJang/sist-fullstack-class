package Homework;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UseStatement {
	
	private StatementCRUD stmtCRUD;
	CpEmpVO ceVO;
	public UseStatement() {
		stmtCRUD = new StatementCRUD();
		String[] processData = {"2222","조유리","SYSDATE","20","사원","3000"};
		ceVO = new CpEmpVO(processData[0],processData[1],processData[2],Integer.parseInt(processData[3]), processData[4], Integer.parseInt(processData[5]));
		
	}//UseStatement
	
	//================================= addForm =====================================
	public void addForm(){

		try {
			stmtCRUD.insertProcess(ceVO);
			System.out.println(ceVO.getDeptno() +"번 부서 정보 추가성공");
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			System.err.println("DB작업 중 문제 발생");
			switch(se.getErrorCode()) {
			case 1: System.out.println("같은 부서번호가 존재합니다");break;
			case 1400: System.out.println("부서명은 반드시 입력해야합니다.");break;
			case 1438: System.out.println("부서번호는 숫자 2자리 입니다."); break;
			case 12899 : System.out.println("부서명이나 위치의 글자수를 확인 해주세요 부서명은 14byte 위치 13byte입니다."); 
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
				System.out.println(ceVO.getEmpno() + "번 사원 정보가 변경 되었습니다.");
			}else {
				System.out.println(ceVO.getDeptno()+"번 사원정보가 변경되지않았습니다. 사원정보를 확인하세요.");		

//				System.out.println(ceVO.getDeptno()+"번 부서정보가 변경되었습니다.");
			}//end else
		} catch (SQLException se) {
			System.err.println("DB작업 중 문제 발생");
			switch(se.getErrorCode()) {
			case 1400: System.out.println("부서명은 반드시 입력해야합니다.");break;
			case 12899 : System.out.println("부서명이나 위치의 글자수를 확인 해주세요 부서명은 14byte 위치 13byte입니다."); 
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
				System.out.println(ceVO.getEmpno() + "번 사원정보가 삭제 되었습니다.");
			}else {
				System.out.println(ceVO.getEmpno() + "번 사원정보가 삭제 되지 않았습니다.");
			}
		} catch (SQLException e) {
			System.err.println("DB에서 문제가 발생");
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
