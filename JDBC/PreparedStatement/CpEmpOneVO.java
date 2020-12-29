package day1229;

public class CpEmpOneVO {

	private String ename;
	private String job;
	private int sal;
	private int comm;
	private String hiredate;
	public CpEmpOneVO() {
	
	}//CpEmpModifyVO
	public CpEmpOneVO(String ename, String job, int sal, int comm, String hiredate) {
		super();
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
		this.hiredate = hiredate;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "CpEmpOneVO [ename=" + ename + ", job=" + job + ", sal=" + sal + ", comm=" + comm + ", hiredate="
				+ hiredate + "]";
	}


	
	
}//class
