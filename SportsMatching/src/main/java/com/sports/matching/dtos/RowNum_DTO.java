package com.sports.matching.dtos;

import java.io.Serializable;

public class RowNum_DTO implements Serializable{

	private static final long serialVersionUID = -1653396913725611483L;
	
	private int page; 			// 현재페이지
	private int countList; 		// 페이지 당 보여줄 게시글 수
	private int totalCount;		// 총 게시글 수
	private int countPage; 		// 한 화면에 보여줄 페이지 수
	private int totalPage; 		// 총 페이지 수
	private int start;			// 시작번호
	private int end; 			// 마지막번호

	public RowNum_DTO(int page, int totalCount, int start, int end) {
		this.page = page;
		this.countList = 10;
		this.totalCount = totalCount;
		this.countPage = 5;
		this.totalPage = (this.totalCount / this.countList);
		if (this.totalCount % this.countList > 0) {
			totalPage++;
		}
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "RowNum_DTO [page=" + page + ", countList=" + countList + ", totalCount=" + totalCount + ", countPage="
				+ countPage + ", totalPage=" + totalPage + ", start=" + start + ", end=" + end + "]";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCountList() {
		return countList;
	}

	public void setCountList(int countList) {
		this.countList = countList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
