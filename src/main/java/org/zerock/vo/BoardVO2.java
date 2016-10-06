package org.zerock.vo;

import java.util.Arrays;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("board2")
public class BoardVO2 {
	
	private int bno;
	private int gno;
	private int gorder;
	private int depth;
	private int parent=0; 

	private String title;
	private String content;
	private String writer;
	private int viewcnt;
	
	private String delflag;
	private Date regdate;
	private Date updatedate;
	
	private String[] files;
	
	private PageVO page;
	
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	
	public PageVO getPage() {
		return page;
	}
	public void setPage(PageVO page) {
		this.page = page;
	}
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public int getGorder() {
		return gorder;
	}
	public void setGorder(int gorder) {
		this.gorder = gorder;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "BoardVO2 [bno=" + bno + ", gno=" + gno + ", gorder=" + gorder + ", depth=" + depth + ", parent="
				+ parent + ", title=" + title + ", content=" + content + ", writer=" + writer + ", viewcnt=" + viewcnt
				+ ", delflag=" + delflag + ", regdate=" + regdate + ", updatedate=" + updatedate + ", files="
				+ Arrays.toString(files) + ", page=" + page + "]";
	}

}
