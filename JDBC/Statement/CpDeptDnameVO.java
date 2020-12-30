package day1228;

/**
 * 저장하는 값이 하나라도 다르면 무조건 클래스 하나 만든다.
 * @author owner
 */
public class CpDeptDnameVO {

	private String dname;
	private String loc;
	
	public CpDeptDnameVO() {
	
	}//CpDeptDnameVO

	public CpDeptDnameVO(String dname, String loc) {
		this.dname = dname;
		this.loc = loc;
	}//CpDeptDnameVO

	public String getDname() {
		return dname;
	}//getDname

	public void setDname(String dname) {
		this.dname = dname;
	}//setDname

	public String getLoc() {
		return loc;
	}//getLoc

	public void setLoc(String loc) {
		this.loc = loc;
	}//setLoc

	@Override
	public String toString() {
		return "CpDeptDnameVO [dname=" + dname + ", loc=" + loc + "]";
	}//toString
	
}//class