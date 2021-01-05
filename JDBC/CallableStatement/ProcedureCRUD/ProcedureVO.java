package day0105;

public class ProcedureVO {
	private int deptno;
	private int empno;
	private String dname;
	private String loc;
	private String ename;
	private String hiredate;
	
	
	public ProcedureVO() {
	}//ProcedureVO


	public ProcedureVO(int deptno, int empno, String dname, String loc, String ename, String hiredate) {
		super();
		this.deptno = deptno;
		this.empno = empno;
		this.dname = dname;
		this.loc = loc;
		this.ename = ename;
		this.hiredate = hiredate;
	}


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getLoc() {
		return loc;
	}


	public void setLoc(String loc) {
		this.loc = loc;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getHiredate() {
		return hiredate;
	}


	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}


	@Override
	public String toString() {
		return "ProcedureVO [deptno=" + deptno + ", empno=" + empno + ", dname=" + dname + ", loc=" + loc + ", ename="
				+ ename + ", hiredate=" + hiredate + "]";
	}
	

}//class
