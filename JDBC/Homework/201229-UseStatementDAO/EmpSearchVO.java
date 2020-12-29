package day1229.HomeWork;

public class EmpSearchVO {
	
	private int empno;	
	private String ename;		
	private int deptno;
	private int sal;
	private int comm;
	private String job;
	
	public EmpSearchVO() {
	}//EmpSearchVO

	public EmpSearchVO(int empno, String ename, int deptno, int sal, int comm, String job) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.sal = sal;
		this.comm = comm;
		this.job = job;
	}//EmpSearchVO

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "EmpSearchVO [empno=" + empno + ", ename=" + ename + ", deptno=" + deptno + ", sal=" + sal + ", comm="
				+ comm + ", job=" + job + "]";
	}
	
}//class
