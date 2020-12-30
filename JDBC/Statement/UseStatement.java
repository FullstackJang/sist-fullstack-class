package day1228;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Statement를 사용한 CRUD
 * 
 * @author owner
 */
public class UseStatement {

	private StatementCRUD stmtCRUD;

	public UseStatement() {
		stmtCRUD = new StatementCRUD();
	}// UseStatement

	public void addForm() {
		String csvData = JOptionPane.showInputDialog("부서정보추가\n입력 예) 부서번호,부서명,위치");
		// ,로 구분되어 입력된 값을 분리한다.
		String[] processData = csvData.split(",");

		// 입력된 값을 DBMS에 INSERT하기 위해서 입력 값을 VO에 설정한다.
		CpDeptVo cdVO = new CpDeptVo(Integer.parseInt(processData[0]), processData[1], processData[2]);

		try {
			stmtCRUD.insertProcess(cdVO);// 입력된 값을 묶어서 가지고 있는 VO를 입력
			System.out.println(cdVO.getDeptno() + "번 부서 정보 추가성공");
		} catch (SQLException e) { // method안에서 발생하는 모든 예외를 모아서 처리 할 수있다.
			System.out.println(cdVO.getDeptno() + "번 부서 정보 추가실패");
			// SQLException은 에러코드를 에러에 종류에 따라서 다양하게 반환한다.
			switch (e.getErrorCode()) {
			case 1:
				System.out.println("같은 부서번호가 존재합니다");
				break;
			case 1400:
				System.out.println("부서명은 반드시 입력해야합니다.");
				break;
			case 1438:
				System.out.println("부서번호는 숫자 2자리 입니다.");
				break;
			case 12899:
				System.out.println("부서명이나 위치의 글자수를 확인 해주세요 부서명은 14byte 위치 13byte입니다.");
				System.out.println(e.getMessage());
				break;

			}// end switch

			e.printStackTrace();
		}
	}// insertForm

	public void modifyForm() {
		String csvData = JOptionPane.showInputDialog("부서정보변경\n부서번호와 일치하는 부서의 부서명과 위치를 변경합니다. \n입력 예) 부서번호,부서명,위치");
		// ,로 구분되어 입력된 값을 분리한다.
		String[] processData = csvData.split(",");

		// 입력된 값을 DBMS에 INSERT하기 위해서 입력 값을 VO에 설정한다.
		CpDeptVo cdVO = new CpDeptVo(Integer.parseInt(processData[0]), processData[1], processData[2]);

		try {
			int cnt = stmtCRUD.updateProcess(cdVO);

			if (cnt == 0) {
				System.out.println(cdVO.getDeptno() + "번 부서정보가 변경되지않았습니다.부서번호를 확인하세요.");
			} else {
				System.out.println(cdVO.getDeptno() + "번 부서정보가 변경되었습니다.");
			} // end else
		} catch (SQLException se) {
			System.err.println("DB작업 중 문제 발생");
			switch (se.getErrorCode()) {
			case 1400:
				System.out.println("부서명은 반드시 입력해야합니다.");
				break;
			case 12899:
				System.out.println("부서명이나 위치의 글자수를 확인 해주세요 부서명은 14byte 위치 13byte입니다.");
				System.out.println(se.getMessage());
				break;

			}// end switch
			se.printStackTrace();
		} // end catch

	}// updateForm

	public void removeForm() {
		String inputData = JOptionPane.showInputDialog("부서정보삭제\n입력 예) 부서번호");

		int deptno = Integer.parseInt(inputData);

		try {
			int cnt = stmtCRUD.deleteProcess(deptno);
			if (cnt != 0) {
				System.out.println(deptno + "번 부서정보가 삭제 되었습니다.");
			} else {
				System.out.println(deptno + "번 부서정보가 삭제 되지 않았습니다.");
			}
		} catch (SQLException e) {
			System.err.println("DB에서 문제가 발생");
			e.printStackTrace();
		} // end catch

	}// deleteForm

	public void searchAll() {

		try {
			List<CpDeptVo> list = stmtCRUD.selectAllCpDept();

			System.out.println("부서번호\t부서명\t위치");
			System.out.println("--------------------------------");
			if (list.isEmpty()) {
				System.out.println("입력된 부서 정보가 존재하지 않습니다.");
			} // end if
			for (CpDeptVo cdVO : list) {
				System.out.println(cdVO.getDeptno() + "\t" + cdVO.getDname() + "\t" + cdVO.getLoc());
			}
			System.out.println("--------------------------------");
			System.out.println("조회된 레코드는" + list.size() + "건 입니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	}// searchAll

	public void searchOneForm() {
		String inputData = JOptionPane.showInputDialog("부서정보조회\n입력 예) 부서번호");

		int deptno = Integer.parseInt(inputData);

		try {
			System.out.println(deptno + "번 부서정보조회");
			CpDeptDnameVO cddVO = stmtCRUD.selectCpDeptOne(deptno);

			if (cddVO != null) {
				System.out.println("부서명[" + cddVO.getDname() + "]");
				System.out.println("부서위치[" + cddVO.getLoc() + "]");
			}else {
				System.out.println("조회된 부서가 없습니다. 부서번호를 확인해주세요.");
			}
			
		} catch (SQLException e) {
			System.err.println("DB에서 문제가 발생");
			e.printStackTrace();
		} // end catch

	}// deleteForm

	public static void main(String[] args) {
		UseStatement us = new UseStatement();
//		us.addForm();
//		us.modifyForm();
//		us.removeForm();
//		us.searchAll();
		us.searchOneForm();

	}// main

}// class
