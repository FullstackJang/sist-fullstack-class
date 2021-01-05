package day1230;

public class ZipcodeVO {
	
	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	private String bunji;
	
	
	public ZipcodeVO(String zipcode, String sido, String gugun, String dong, String bunji) {
		this.zipcode = zipcode;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.bunji = bunji;
	}//ZipcodeVO
	
	public String getZipcode() {
		return zipcode;
	}//getZipcode
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}//setZipcode
	public String getSido() {
		return sido;
	}//getSido
	public void setSido(String sido) {
		this.sido = sido;
	}//setSido
	public String getGugun() {
		return gugun;
	}//getGugun
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}//setGugun
	public String getDong() {
		return dong;
	}//getDong
	public void setDong(String dong) {
		this.dong = dong;
	}//setDong
	public String getBunji() {
		return bunji;
	}//getBunji
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}//setBunji
	@Override
	public String toString() {
		return "ZipcodeVO [zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", bunji="
				+ bunji + "]";
	}//toString

}//class