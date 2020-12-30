package day1229;

public class CpEmpModifyVO {

	private int empno;
	private String job;
	private int sal;
	private int comm;
	public CpEmpModifyVO() {
	
	}//CpEmpModifyVO
	public CpEmpModifyVO(int empno, String job, int sal, int comm) {
		this.empno = empno;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
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
	@Override
	public String toString() {
		return "CpEmpModifyVO [empno=" + empno + ", job=" + job + ", sal=" + sal + ", comm=" + comm + "]";
	}

	
	
}//class
