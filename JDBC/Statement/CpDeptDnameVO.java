package day1228;

/**
 * �����ϴ� ���� �ϳ��� �ٸ��� ������ Ŭ���� �ϳ� �����.
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