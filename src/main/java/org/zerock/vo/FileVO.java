package org.zerock.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("file")
public class FileVO {
	
	private String fullname;
	private int bno;
	private Date regdate;
	
	public FileVO(int bno,String fullname) {
		this.bno = bno;
		this.fullname = fullname;
	}
	
	@Override
	public String toString() {
		return "FileVO [fullname=" + fullname + ", bno=" + bno + ", regdate=" + regdate + "]";
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	

}
