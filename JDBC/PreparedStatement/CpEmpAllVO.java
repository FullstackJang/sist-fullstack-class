package day1229;

import java.sql.Date;

public class CpEmpAllVO {

	private int empno;
	private String ename;
	private String job;
	private int sal;
	private int comm;
	private String hiredate; //Date형을 TO_CHAR함수를 사용하여 원하는 형식으로 뽑을 때
	private Date hiredate1; //오라클에Date형을 원형 그대로 받을 때
	
	public CpEmpAllVO() {
	
	}//CpEmpAllVO

	public CpEmpAllVO(int empno, String ename, String job, int sal, int comm, String hiredate, Date hiredate1) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
		this.hiredate = hiredate;
		this.hiredate1 = hiredate1;
		
	}//CpEmpAllVO

	public int getEmpno() {
		return empno;
	}//getEmpno

	public void setEmpno(int empno) {
		this.empno = empno;
	}//setEmpno

	public String getEname() {
		return ename;
	}//getEname

	public void setEname(String ename) {
		this.ename = ename;
	}//setEname

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

	public int getComm() {
		return comm;
	}//getComm

	public void setComm(int comm) {
		this.comm = comm;
	}//setComm

	public String getHiredate() {
		return hiredate;
	}//getHiredate

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}//setHiredate

	public Date getHiredate1() {
		return hiredate1;
	}//getHiredate1

	public void setHiredate1(Date hiredate1) {
		this.hiredate1 = hiredate1;
	}//setHiredate1

	@Override
	public String toString() {
		return "CpEmpAllVO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", comm=" + comm
				+ ", hiredate=" + hiredate + ", hiredate1=" + hiredate1 + "]";
	}//toString
	
}//class
