package org.zerock.vo;

import org.apache.ibatis.type.Alias;

@Alias("page")
public class PageVO {
	
	private int pageNo = 1;
	private int listSize = 10;
	private int lastPage;
	private int count;
	private int startPage;
	private int endPage;
	private int pageSize = 10;
	
	// Search
	private int end;
	private int start;
	private String searchWord = "";
	private String scontent="";
	private String stitle="";
	private String swriter="";

	
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getSwriter() {
		return swriter;
	}
	public void setSwriter(String swriter) {
		this.swriter = swriter;
	}
	public PageVO() {
		setPage();
	}
	public void setPageNo (int pageNo) {
		this.pageNo = pageNo;
		setPage();
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	private void setPage()
	{
		start = (pageNo-1) * listSize +1;
		end = pageNo * listSize;
	}
	public void setCount(int count) {
		this.count = count;
		setList();
	}
	private void setList()
	{
		lastPage = (count % listSize == 0) ? count / listSize : count / listSize +1 ;
		int currPage = (pageNo-1) / pageSize + 1;
		startPage = (currPage -1) * pageSize + 1;
		endPage = (currPage * pageSize < lastPage) ? currPage * pageSize : lastPage;
	}
	public int getLastPage()
	{
		return lastPage;
	}
	public int getPageNo() {
		return pageNo;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	@Override
	public String toString() {
		return "PageVO [pageNo=" + pageNo + ", listSize=" + listSize + ", lastPage=" + lastPage + ", count=" + count
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", pageSize=" + pageSize + ", end=" + end
				+ ", start=" + start + ", searchWord=" + searchWord + ", scontent=" + scontent + ", stitle=" + stitle
				+ ", swriter=" + swriter + "]";
	}


}
