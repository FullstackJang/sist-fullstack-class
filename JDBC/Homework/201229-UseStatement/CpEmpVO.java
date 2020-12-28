package Homework;

public class CpEmpVO {
	
	private String empno;
	private String ename;
	private String hiredate;
	private int deptno;
	private String job;
	private int sal;
	
	public CpEmpVO() {
		
	}//CpEmpVO
	
	public CpEmpVO(String empno, String ename, String hiredate, int deptno, String job, int sal) {
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.deptno = deptno;
		this.job = job;
		this.sal = sal;
	}//CpEmpVO

	public String getEmpno() {
		return empno;
	}//getEmpno

	public void setEmpno(String empno) {
		this.empno = empno;
	}//setEmpno

	public String getEname() {
		return ename;
	}//getEname

	public void setEname(String ename) {
		this.ename = ename;
	}//setEname

	public String getHiredate() {
		return hiredate;
	}//getHiredate

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}//setHiredate

	public int getDeptno() {
		return deptno;
	}//getDeptno

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}//setDeptno

	public String getJob() {
		return job;
	}//getJob

	public void setJob(String job) {
		this.job = job;
	}//setJob

	public int getSal() {
		return sal;
	}//getSal

	public void setSal(int sal) {
		this.sal = sal;
	}//setSal
	
}//class
