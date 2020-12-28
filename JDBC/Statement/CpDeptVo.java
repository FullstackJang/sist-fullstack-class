package day1228;

/**
 * VO (Value Object)
 * @author owner
 */
public class CpDeptVo {
	//instance variable ¼±¾ð 
	private int deptno;
	private String dname;
	private String loc;
	public CpDeptVo() {
	}
	
	public CpDeptVo(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
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

	
}//class
