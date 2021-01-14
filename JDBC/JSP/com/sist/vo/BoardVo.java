package com.sist.vo;

public class BoardVo {
	private int no;
	private String name;
	private String pwd;
	private String email;
	private String title;
	private String content;
	private String fname;
	
	public BoardVo() {
		
	}//BoardVo

	public BoardVo(int no, String name, String pwd, String email, String title, String content, String fname) {
		this.no = no;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.title = title;
		this.content = content;
		this.fname = fname;
	}//BoardVo

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", title=" + title
				+ ", content=" + content + ", fname=" + fname + "]";
	}
	
}//class
